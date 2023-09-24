<template>
  <div style="text-align: center">
      Welcome {{store.auth.user.username}} to Wonderland
  </div>
  <div>
      <el-button @click="logout()" type="danger" plain>Log Out</el-button>
  </div>
</template>

<script setup>
import {get} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";
import {useStore} from "@/stores";

const store = useStore()

const logout = () => {
    get('/api/auth/logout', (message) => {
        ElMessage.success(message)
        store.auth.user = null
        router.push('/')
    })
}
</script>

<style scoped>

</style>