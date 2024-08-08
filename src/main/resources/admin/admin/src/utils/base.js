const base = {
    get() {
        return {
            url : "http://localhost:8080/TWSsystem/",
            name: "TWSsystem",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/TWSsystem/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "勤工助学系统"
        } 
    }
}
export default base
