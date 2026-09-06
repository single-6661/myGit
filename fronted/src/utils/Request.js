export async function loginPost(url,mobile,paswd){
const fetchOption = {
  //方法：发送数据，设置数据名，存储cookie
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    credentials: 'include',
    body: JSON.stringify({
      mobile: mobile,
      password: paswd
    })
  }
  //用try catch 包裹，网络请求报错返回报错
  try{
      const res = await fetch("http://localhost:8080"+url,fetchOption);

      if (res.status !== 200) {
      return false;
    }

      const isLogin = await res.json();

      return isLogin;
  }catch{
    console.error("请求错误");
    return false
  }

}


//发出搜索返回content
export async function searchGet(url,searchGet){
const fetchOption = {
  //方法：发送数据，设置数据名，存储cookie
  //用get方法不能向后端传入body参数
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
    credentials: 'include',
  }
  //用try catch 包裹，网络请求报错返回报错
  try{
    //用encodeURLComponent是ai提示的，用于防止用户字符串输入特殊值导致后端报错，传入该方法可以自动编码成合法字符串，后端接收编码时也可以还原字符串
      const res = await fetch("http://localhost:8080"+url+"?keyword="+encodeURIComponent(searchGet),fetchOption);

      if (res.status !== 200) {
      return false;
    }

      const searchData = await res.json();

      return searchData;
  }catch{
    console.error("请求错误");
    console.error(fetchOption);
    return false
  }

}


//得到conten/hot渲染card
export async function contentGet(url){
const fetchOption = {
  //方法：发送数据，设置数据名，存储cookie
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
    credentials: 'include',
  }
  //用try catch 包裹，网络请求报错返回报错
  try{
      const res = await fetch("http://localhost:8080"+url,fetchOption);

      if (res.status !== 200) {
      return false;
    }

      const contentData = await res.json();

      return contentData;
  }catch{
    console.error("请求错误");
    return false
  }
}