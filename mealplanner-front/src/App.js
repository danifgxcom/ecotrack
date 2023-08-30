import React, { useState } from 'react';

import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';
import MealList from './components/MealList';
import DropWindow from './components/DropWindow';


export default function App() {
  const [mealList, setMealList] = useState([]);
  const [dropWindowMeals, setDropWindowMeals] = useState([]);

  const addMealToMealList = (meal) => {
    setMealList([...mealList, meal]);
  };

  const addMealToWindow = (meal) => {
    setDropWindowMeals([...dropWindowMeals, meal]);
  };

  return (
    <DndProvider backend={HTML5Backend}>
      <div>
        <MealList userId="userId" addMealToWindow={addMealToWindow} />
        <DropWindow addMealToMealList={addMealToMealList} />
      </div>
    </DndProvider>
  );
}
