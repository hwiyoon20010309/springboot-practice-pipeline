import axios from "axios";

export const sendMessageToBackend = async (message) => {
  try {
    const response = await axios.post("/api/chat", { message });
    return response.data.response;
  } catch (error) {
    console.error("❌ 백엔드 연결 오류:", error);
    return "서버와 연결할 수 없습니다 😢";
  }
};
