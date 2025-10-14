import React, { useState } from "react";
import ChatBox from "./ChatBox.jsx";
import ChatInput from "./ChatInput.jsx";
import { sendMessageToBackend } from "../api/api.js";


function ChatApp() {
  const [messages, setMessages] = useState([]);

  const handleSend = async (text) => {
    if (!text.trim()) return;

    const userMsg = { sender: "user", text };
    setMessages((prev) => [...prev, userMsg]);

    const reply = await sendMessageToBackend(text);
    const botMsg = { sender: "bot", text: reply };
    setMessages((prev) => [...prev, botMsg]);
  };

  return (
    <div className="chat-container">
      <ChatBox messages={messages} />
      <ChatInput onSend={handleSend} />
    </div>
  );
}

export default ChatApp;
