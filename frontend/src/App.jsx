import React, { useState } from "react";
import "./styles/chat.css";
import ChatBox from "./components/ChatBox";

function App() {
  return (
    <div className="app">
      <h1>AI Chatbot 💬</h1>
      <ChatBox />
    </div>
  );
}

export default App;
