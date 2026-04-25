import React, { useState } from "react";
import api from "./api";

export default function App() {
  const [orderId, setOrderId] = useState("");
  const [amount, setAmount] = useState("");
  const [item, setItem] = useState("");
  const [qty, setQty] = useState("");
  const [message, setMessage] = useState("");

  const processPayment = async () => {
    try {
      const res = await api.post(
        `/payment/process?orderId=${orderId}&amount=${amount}`
      );
      setMessage(`Payment saved with ID: ${res.data.id}`);
    } catch (err) {
      setMessage("Payment failed");
    }
  };
  const createOrder = async () => {
    try {
      const res = await api.post(
        `/order/create?item=${item}&qty=${qty}`
      );
      setMessage(res.data);
    } catch (err) {
      setMessage("Order creation failed");
    }
  };
  
  return (
    <div style={{ padding: "30px", fontFamily: "Arial" }}>
      <h1>Enterprise DevOps Demo UI</h1>

      <h2>Payment</h2>
      <input
        placeholder="Order ID"
        value={orderId}
        onChange={(e) => setOrderId(e.target.value)}
      />
      <input
        placeholder="Amount"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      />
      <button onClick={processPayment}>Process Payment</button>

      <h2>Order</h2>
	  <input
        placeholder="Item"
        value={item}
        onChange={(e) => setItem(e.target.value)}
      />
      <input
        placeholder="Qty"
        value={qty}
        onChange={(e) => setQty(e.target.value)}
      />
      <button onClick={createOrder}>Create Order</button>

      <p>{message}</p>
    </div>
  );
}