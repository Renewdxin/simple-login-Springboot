import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import 'element-plus/dist/index.css'
import axios from "axios";

const app = createApp(App)

axios.defaults.baseURL = '8.137.116.169:8080'

app.use(createPinia())
app.use(router)

app.mount('#app')
