<script setup>
import {get} from "@/net";
import {ElMessage} from "element-plus";

get('/api/user/me', () => {
  ElMessage.success('登录成功')
}, () => {
  ElMessage.warning('未登录')
})
</script>

<template>
  <router-view/>

</template>

<style scoped>

</style>
