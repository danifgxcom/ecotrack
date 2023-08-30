import React, { useState } from 'react';

export default function AddMealForm({ addMeal }) {
  const [newMeal, setNewMeal] = useState({ name: '', calories: 0, quantity: '', ingredients: [] });
  
  const handleSubmit = () => {
    addMeal(newMeal);
    setNewMeal({ name: '', calories: 0, quantity: '', ingredients: [] });
  };

  return (
    <div>
      {/* Asumiendo que manejas los cambios en los inputs y actualizas newMeal */}
      <button onClick={handleSubmit}>Add Meal</button>
    </div>
  );
}
