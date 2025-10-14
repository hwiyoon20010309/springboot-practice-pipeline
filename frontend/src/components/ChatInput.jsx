import React, { useState } from "react";

function ChatInput({ onSend }) {
  const [input, setInput] = useState("");

  const handleSubmit = () => {
    if (input.trim()) {
      onSend(input);
      setInput("");
    }
  };

  const handleKeyPress = (e) => {
    if (e.key === "Enter") handleSubmit();
  };

  return (
    <div className="chat-input">
      <input
        type="text"
        value={input}
        onChange={(e) => setInput(e.target.value)}
        onKeyDown={handleKeyPress}
        placeholder="메시지를 입력하세요..."
      />
      <button onClick={handleSubmit}>전송</button>
    </div>
  );
}

export default ChatInput;
