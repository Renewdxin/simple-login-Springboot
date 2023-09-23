<script setup>
import {ElMessage} from "element-plus";
import router from "@/router";
import {get} from "@/net";

const logout =() => {
  get('/api/auth/logout',(message) => {
    ElMessage.success(message)
    router.push('/')
  })
}

</script>

<template>
  <div>
    Welcome to Wonderland!
  </div>

  <div>
    <el-button @click="logout()" type="danger" plain>Log out</el-button>
  </div>
</template>

<style scoped>

</style>