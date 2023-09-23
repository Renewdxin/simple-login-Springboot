<script setup>

</script>

<template>
  <div style="width: 100vw; height: 100vh; overflow: hidden; display: flex">
    <div style="flex: 1">
      <el-image style="width: 100%; height: 100%" fit="cover"
                src="https://asdxz.oss-cn-beijing.aliyuncs.com/img/202309231321807.jpg"/>
    </div>

    <div style="width: 800px; background-color: white">
      <router-view/>
    </div>
  </div>
</template>

<style scoped>

</style>