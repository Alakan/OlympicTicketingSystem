# Nom du script : create-react-structure.ps1

# Créez les dossiers principaux
New-Item -ItemType Directory -Path "src/components" -Force
New-Item -ItemType Directory -Path "src/pages" -Force

# Créez les composants de base
$components = @("Header.js", "Footer.js", "OfferList.js", "OfferItem.js", "ReservationForm.js", "UserAuth.js")
foreach ($component in $components) {
    New-Item -ItemType File -Path "src/components/$component" -Force
}

# Créez les pages principales
$pages = @("HomePage.js", "OffersPage.js", "LoginPage.js", "RegisterPage.js", "AdminPage.js")
foreach ($page in $pages) {
    New-Item -ItemType File -Path "src/pages/$page" -Force
}

# Créez le fichier App.js dans src
$appJsContent = @"
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomePage from './pages/HomePage';
import OffersPage from './pages/OffersPage';
import LoginPage from './pages/LoginPage';
import RegisterPage from './pages/RegisterPage';
import AdminPage from './pages/AdminPage';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={HomePage} />
        <Route path="/offers" component={OffersPage} />
        <Route path="/login" component={LoginPage} />
        <Route path="/register" component={RegisterPage} />
        <Route path="/admin" component={AdminPage} />
      </Switch>
    </Router>
  );
}

export default App;
"@

Set-Content -Path "src/App.js" -Value $appJsContent

# Créez le fichier index.js dans src
$indexJsContent = @"
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css';

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
"@

Set-Content -Path "src/index.js" -Value $indexJsContent

Write-Host "La structure du projet React a été générée avec succès."
