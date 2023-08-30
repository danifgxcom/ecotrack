import { useDrag } from 'react-dnd';

export default function DnDMeal({ meal, type, handleDrag }) {
  const effectiveType = type || 'DEFAULT_TYPE';
  const [, ref] = useDrag(() => ({
    type: effectiveType,
    item: { meal },
    end: (item, monitor) => {
      if (monitor.didDrop()) {
        handleDrag(meal);
      }
    },
  }));
  return (
   <div
  ref={ref}
  style={{
    border: "1px solid black",
    padding: "10px",
    margin: "5px",
    cursor: "grab",
    display: "inline-block",
    width: "max-content",
    minWidth: "100px"  // Puedes ajustar este valor
  }}
>
  {meal.name}
</div>

  );
}
