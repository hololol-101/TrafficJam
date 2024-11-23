import axios from "axios";

export default axios.create({
    baseURL: process.env.LOCAL_DEVELOP_SERVER_URL,
    headers: {
        "Content-Type": "application/json",
    },
});