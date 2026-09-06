//由于要通过search搜素得到的数据渲染整个card search和card分别由headNav和home渲染到layout，组件嵌套太深，用一个bus作为全局的中转
//注意，用bus全局来中转数据在我这种小demo里面可以，但是用到大工程中会导致数据错乱

//引入空实例，专门用于中转信息
import mitt from 'mitt'
const bus = mitt()
export default bus