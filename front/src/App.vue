<script setup>
import {Lock, User} from '@element-plus/icons-vue'
</script>

<template>
  <div style="width: 100vw; height: 100vh; overflow: hidden; display: flex">
    <div style="flex: 1">
      <el-image style="width: 100%; height: 100%" fit="cover"
          src="https://asdxz.oss-cn-beijing.aliyuncs.com/img/202309231321807.jpg"/>
    </div>

    <div style="width: 800px; background-color: white">
      <div style="text-align: center; margin:0 200px">
        <div style="margin-top: 150px">
          <div style="font-size: 25px; font-weight: bold">Log in</div>
          <div style="margin-top: 5px; font-size: 14px; color: grey">Please Log in First</div>
        </div>

        <div style="margin-top: 30px">
          <el-input type="text" placeholder="Username/Email">
            <template #prefix>
              <el-icon><User /></el-icon>
            </template>
          </el-input>

          <el-input type="password" style="margin-top: 10px" placeholder="Password">
            <template #prefix>
              <el-icon><Lock /></el-icon>
            </template>
          </el-input>
        </div>

        <div>
          <el-row style="margin-top: 10px">
            <el-col :span="12" style="text-align: left">
              <el-checkbox v-model="checked1" label="Remember me" size="default" />
            </el-col>
            <el-col :span="12" style="text-align: right">
              <el-link>forget the password?</el-link>
            </el-col>
          </el-row>
        </div>

        <div style="margin-top: 30px">
          <el-button style="width: 200px; height: 30px" type="success" plain> Log in</el-button>
        </div>
        <el-divider>
          <span style="color: grey;">No account?</span>
        </el-divider>
        <div>
          <el-button style="width: 200px" type="success" plain>Sign up</el-button>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>

</style>
