import axios from "axios";
import{ElMessage} from "element-plus";

const defaultError =() => ElMessage.error("Wrong!")
const defaultFailure =(message) => ElMessage.warning(message)

function post(url, data, success, failure = defaultFailure, error = defaultError) {
    axios
        .post(url, data, {
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            withCredentials: true,
        }).then(({data}) => {
        if(data.success) {
            success(data.message, data.status)
        } else {
            failure(data.message, data.status)
        }
        })
        .catch(error);
}

function get(url, data, success, failure = defaultFailure, error = defaultError) { //这里加了括号就错了
    axios.get(url, {
        withCredentials: true
    }).then(({data}) => {
        if(data.success) {
            success(data.message, data.status)
        } else {
            failure(data.message, data.status)
        }
    }).catch(error)
}

export {get, post}