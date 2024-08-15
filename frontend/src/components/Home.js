// src/components/Home.js
import React, { useState, useEffect } from 'react';

function Home() {
  const [offers, setOffers] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/offers')
      .then(response => response.json())
      .then(data => setOffers(data));
  }, []);

  return (
    <div>
      <h1>Welcome to Olympic Ticketing System</h1>
      <ul>
        {offers.map(offer => (
          <li key={offer.id}>{offer.description} - {offer.price} €</li>
        ))}
      </ul>
    </div>
  );
}

export default Home;
