<script setup>

</script>

<template>
  <div style="width: 100vw; height: 100vh; overflow: hidden; display: flex">
    <div style="flex: 1">
      <el-image style="width: 100%; height: 100%" fit="cover"
                src="https://asdxz.oss-cn-beijing.aliyuncs.com/img/202309231321807.jpg"/>
    </div>

    <div class="welcome-title" >
      <div style="font-size: 30px; font-weight: bold; ">Welcome to Wonderland</div>
      <div style="margin-top: 10px">Do whatever you want, btw you can have a talk with the Lupin the Third</div>
      <div style="margin-top: 10px">Or you can chat with the god of Java</div>
    </div>

    <div style="width: 800px; background-color: wheat">
      <router-view v-slot ="{Component}">
        <transition name="el-fade-in-linear" mode="out-in">
          <component :is="Component" style="height: 100%"/>
        </transition>

      </router-view>
    </div>
  </div>
</template>

<style scoped>
  .welcome-title {
    position: absolute;
    bottom: 20px;
    left: 20px;
    color: white;
    text-shadow: 0 0 10px black;
  }

</style>