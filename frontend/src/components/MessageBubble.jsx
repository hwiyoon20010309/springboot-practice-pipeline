import React from "react";

function MessageBubble({ sender, text }) {
  const isUser = sender === "user";
  return (
    <div className={`message-bubble ${isUser ? "user" : "bot"}`}>
      <div className="bubble-content">{text}</div>
    </div>
  );
}

export default MessageBubble;
