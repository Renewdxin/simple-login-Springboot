<script setup>
import {Lock, User} from "@element-plus/icons-vue";
import {reactive} from "vue";
import {ElMessage} from "element-plus";
import {post} from "@/net";
import router from "@/router";


const form = reactive({
  username:'',
  password:'',
  remember: false
})

const login = () => {
  if(!form.username || !form.password) {
    ElMessage.warning("Please enter the blanks")
  } else {
    post('/api/auth/login',{
      username: form.username,
      password: form.password,
      remember: form.remember
    }, (message) => {
      ElMessage.success(message)
      router.push('/index')
    })
  }
}
</script>

<template>
  <div style="text-align: center; margin:0 200px">
    <div style="margin-top: 150px">
      <div style="font-size: 25px; font-weight: bold">Log in</div>
      <div style="margin-top: 5px; font-size: 14px; color: grey">Please Log in First</div>
    </div>

    <div style="margin-top: 30px">
      <el-input v-model="form.username" type="text" placeholder="Username/Email">
        <template #prefix>
          <el-icon><User /></el-icon>
        </template>
      </el-input>

      <el-input v-model="form.password" type="password" style="margin-top: 10px" placeholder="Password">
        <template #prefix>
          <el-icon><Lock /></el-icon>
        </template>
      </el-input>
    </div>

    <div>
      <el-row style="margin-top: 10px">
        <el-col :span="12" style="text-align: left">
          <el-checkbox v-model="form.remember" label="Remember me" size="default" />
        </el-col>
        <el-col :span="12" style="text-align: right">
          <el-link @click="router.push('/forget')">forget the password?</el-link>
        </el-col>
      </el-row>
    </div>

    <div style="margin-top: 30px">
      <el-button @click="login" style="width: 200px; height: 30px" type="success" plain> Log in</el-button>
    </div>
    <el-divider>
      <span style="color: grey;">No account?</span>
    </el-divider>
    <div>
      <el-button style="width: 200px" type="success" @click="router.push('/register')" plain>Sign up</el-button>
    </div>
  </div>
</template>

<style scoped>

</style>