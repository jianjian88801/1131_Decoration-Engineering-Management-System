const base = {
    get() {
        return {
            url : "http://localhost:8080/zhuangshigongchengguanli/",
            name: "zhuangshigongchengguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhuangshigongchengguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "装饰工程管理系统"
        } 
    }
}
export default base
