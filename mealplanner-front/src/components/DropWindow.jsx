import React, { useState } from "react";
import { useDrop } from "react-dnd";

export default function DropWindow() {
  const [droppedMeals, setDroppedMeals] = useState([]);

  const [, ref] = useDrop({
    accept: "MEAL",
    drop: (item) => {
      setDroppedMeals((prevMeals) => [...prevMeals, item.meal]);
    },
  });

  return (
    <div
      ref={ref}
      style={{
        border: "3px dashed gray",
        height: "300px",
        width: "300px",
        overflow: "auto",
      }}
    >
      <h2>Dropped Meals</h2>
      <ul>
        {droppedMeals.map((meal, index) => (
          <li key={index}>{meal.name}</li>
        ))}
      </ul>
    </div>
  );
}
