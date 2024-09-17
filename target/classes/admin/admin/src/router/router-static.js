import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import hetong from '@/views/modules/hetong/list'
    import hetongbaojia from '@/views/modules/hetongbaojia/list'
    import kehu from '@/views/modules/kehu/list'
    import lixiangxiangmu from '@/views/modules/lixiangxiangmu/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yushuanbaojia from '@/views/modules/yushuanbaojia/list'
    import zhuangshicailiao from '@/views/modules/zhuangshicailiao/list'
    import zhuangxiujindu from '@/views/modules/zhuangxiujindu/list'
    import dictionaryLixiangxiangmu from '@/views/modules/dictionaryLixiangxiangmu/list'
    import dictionaryLixiangxiangmuYesno from '@/views/modules/dictionaryLixiangxiangmuYesno/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryZhuangshicailiao from '@/views/modules/dictionaryZhuangshicailiao/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryLixiangxiangmu',
        name: '保养类型',
        component: dictionaryLixiangxiangmu
    }
    ,{
        path: '/dictionaryLixiangxiangmuYesno',
        name: '审核结果',
        component: dictionaryLixiangxiangmuYesno
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryZhuangshicailiao',
        name: '材料类型',
        component: dictionaryZhuangshicailiao
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/hetong',
        name: '合同管理',
        component: hetong
      }
    ,{
        path: '/hetongbaojia',
        name: '合同报价',
        component: hetongbaojia
      }
    ,{
        path: '/kehu',
        name: '客户',
        component: kehu
      }
    ,{
        path: '/lixiangxiangmu',
        name: '立项项目',
        component: lixiangxiangmu
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '员工',
        component: yonghu
      }
    ,{
        path: '/yushuanbaojia',
        name: '预算报价',
        component: yushuanbaojia
      }
    ,{
        path: '/zhuangshicailiao',
        name: '装饰材料总计划',
        component: zhuangshicailiao
      }
    ,{
        path: '/zhuangxiujindu',
        name: '装修进度',
        component: zhuangxiujindu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
