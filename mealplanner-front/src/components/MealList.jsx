import React, { useState, useEffect } from 'react';
import axios from 'axios';
import DnDMeal from './DnDMeal';

export default function MealList() {
  const [meals, setMeals] = useState([]);
  
  useEffect(() => {
    axios.get('http://localhost:3000/meals/userId')
      .then(response => setMeals(response.data))
      .catch(error => console.error('Error fetching meals:', error));
  }, []);
  
  const handleDrag = (meal) => {
    setMeals(prevMeals => prevMeals.filter(m => m.id !== meal.id));
  };
  
  return (
    <div>
      <h1>Your Meals</h1>
      <ul>
        {meals.map((meal) => (
          <li key={meal.id}>
            <DnDMeal meal={meal} type="MEAL" handleDrag={handleDrag} />
          </li>
        ))}
      </ul>
    </div>
  );
}
