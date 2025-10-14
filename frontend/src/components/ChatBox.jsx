import React, { useEffect, useRef } from "react";
import MessageBubble from "./MessageBubble.jsx";

function ChatBox({ messages }) {
  const chatEndRef = useRef(null);

  useEffect(() => {
    chatEndRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  return (
    <div className="chat-box">
      {messages.map((msg, index) => (
        <MessageBubble key={index} sender={msg.sender} text={msg.text} />
      ))}
      <div ref={chatEndRef} />
    </div>
  );
}

export default ChatBox;
