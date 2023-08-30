import React, { useState, useEffect } from 'react';
import axios from 'axios';

function MealPlanner() {
  const [meals, setMeals] = useState([]);
  const [newMeal, setNewMeal] = useState('');

  useEffect(() => {
    axios.get('/api/meals')
      .then(response => {
        setMeals(response.data);
      })
      .catch(error => console.error('Error fetching meals:', error));
  }, []);

  const addMeal = () => {
    axios.post('/api/meals', { name: newMeal })
      .then(response => {
        setMeals([...meals, response.data]);
        setNewMeal('');
      })
      .catch(error => console.error('Error adding meal:', error));
  };

  return (
    <div>
      <h1>Meal Planner</h1>
      <ul>
        {meals.map(meal => <li key={meal.id}>{meal.name}</li>)}
      </ul>
      <input
        type="text"
        value={newMeal}
        onChange={e => setNewMeal(e.target.value)}
      />
      <button onClick={addMeal}>Add Meal</button>
    </div>
  );
}

export default MealPlanner;
