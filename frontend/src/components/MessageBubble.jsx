import React from "react";
import "../styles/chat.css"; // 스타일 파일을 공통으로 사용

function MessageBubble({ sender, text }) {
  const isUser = sender === "user";

  return (
    <div className={`message-bubble ${isUser ? "user" : "ai"}`}>
      <div className="message-content">
        <span className="sender-label">{isUser ? "You 💬" : "AI 🤖"}</span>
        <p className="message-text">{text}</p>
      </div>
    </div>
  );
}

export default MessageBubble;
