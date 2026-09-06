<script>
import { loginPost } from '@/utils/Request.js'
import { cloneVNode } from 'vue';
export default{
    name:'login',
    data(){
        return{
            //接收数据名，登录状态开始为flase
            isLogin:false,
            mobileInput:'',
            passwordInput:''
        }
    },
    methods:{
        //后端传入数据方法，request方法仅包括主url，需要加入字符串
        async submit(){
            if(!this.mobileInput || !this.passwordInput){
                alert("账户或密码不能为空！")
                return this.isLogin;
            }
            console.log("发送登录请求,手机号："+this.mobileInput+" 密码："+this.passwordInput);
            this.isLogin = await loginPost("/login",this.mobileInput,this.passwordInput);
            if(this.isLogin){
                alert("登陆成功");
            }else{ 
                alert("登录失败")
            }
            return this.isLogin;
        },
        //弹窗关闭，值传入父组件，由父组件控制是否关闭
        closeAct(){
            
        }
    }

}

</script>

<template>
    <div class="back" :class="$attrs.class">
        <div class="login">
            <button type="button" class="close" @click="closeAct">X</button>
            <div class="top">
                <p>密码登录</p>
                <div></div>
            </div>
            <div class="login-input">
                <input id="mobile" placeholder="手机或邮箱号" v-model="mobileInput"/>
                <input id="password" placeholder="密码" v-model="passwordInput"/>
            </div>
            <button class="login-button" @click="submit()">注册/登录</button>
            <div class="attention">未注册手机验证后自动登录，注册即代表同意《知乎协议》《隐私保护指引》</div>
        </div>
    </div>
</template>

<style scoped lang="scss">

    .back {

        user-select: none;
        width: 100vw;
        height: 100vh;
        background:rgba(0,0,0,0.5);
        border-radius: 0px 0px 0px 0px;
        display: flex;
        justify-content: center;
        align-items: center;
        position: relative;
        .login {
            .close {
                position: absolute;
                right: -30px;
                top: 0px;
                font-weight:600;
                height: 26px;
                color:#fff;
        }
            opacity: 1;
            width: 444px;
            height: 442px;
            background: #FFFFFF;
            border-radius: 0px 0px 0px 0px;
            position: relative;
            .top {
                p {
                    width: 80px;
                    height: 22px;
                    font-weight: normal;
                    font-size: 20px;
                    color: #000000;
                    line-height: 22px;
                    text-align: left;
                    font-style: normal;
                    text-transform: none;
                    font-family: "Microsoft YaHei", sans-serif;
                    margin-left: 30px;
                    margin-top: 30px;
                }
                div {
                    width: 77px;
                    height: 4px;
                    background: #0084FF;
                    border-radius: 0px 0px 0px 0px;
                    margin-left: 30px;
                    margin-top: 16px;
                }
            }
            .login-input {
                input {
                    width: 384px;
                    height: 60px;
                    background: #fff;
                    border-radius: 0px 0px 0px 0px;
                    margin-left: 30px;
                    margin-top: 20px;
                    padding-right: 20px;
                    border-bottom:1px solid #d8d8d8;
                    &::placeholder{
                        font-weight: normal;
                        font-size: 14px;
                        color: #9E9E9E;
                        line-height: 22px;
                        text-align: center;
                        font-style: normal;
                        text-transform: none;
                    }
                    &:focus {
                        border-bottom:1px solid #0084FF;
  }
                }
            }
            .login-button{
                margin-top: 40px;
                margin-left: 30px;
                width: 384px;
                height: 52px;
                background: #0084FF;
                border-radius: 4px 4px 4px 4px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 18px;
                color: #FFFFFF;
                line-height: 22px;
                text-align: center;
                font-style: normal;
                text-transform: none;
                &:hover {
                    background: #60b4ff;
                }
                &:active {
                    background:#48a0ee;
                }
            }
            .attention{
                margin-left: 30px;
                margin-top: 30px;
                width: 365px;
                height: 44px;
                font-family: PingFang SC, PingFang SC;
                font-weight: normal;
                font-size: 14px;
                color: #9E9E9E;
                line-height: 22px;
                text-align: left;
                font-style: normal;
                text-transform: none;
            }
        }
    }
</style>