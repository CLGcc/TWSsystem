<template>
	<div class="addEdit-block" style="width: 100%;">
		<el-form
			:style='{"padding":"30px 40px","boxShadow":"0 0px 0px #999","borderRadius":"6px","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="150px"
		>
			<template >
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="select" v-if="type!='info'"  label="岗位名称" prop="gangweimingcheng">
					<el-select :disabled="ro.gangweimingcheng" v-model="ruleForm.gangweimingcheng" placeholder="请选择岗位名称" >
						<el-option
							v-for="(item,index) in gangweimingchengOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="岗位名称" prop="gangweimingcheng">
					<el-input v-model="ruleForm.gangweimingcheng"
						placeholder="岗位名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="select" v-if="type!='info'" label="学号" prop="xuehao">
					<el-select :disabled="ro.xuehao" @change="xuehaoChange" v-model="ruleForm.xuehao" placeholder="请选择学号">
						<el-option
							v-for="(item,index) in xuehaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-else-if="ruleForm.xuehao" label="学号" prop="xuehao">
					<el-input v-model="ruleForm.xuehao" placeholder="学号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="学生姓名" prop="xueshengxingming">
					<el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名" clearable  :readonly="ro.xueshengxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="学生姓名" prop="xueshengxingming">
					<el-input v-model="ruleForm.xueshengxingming" placeholder="学生姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="底薪" prop="dixin">
					<el-input v-model="ruleForm.dixin" placeholder="底薪" clearable  :readonly="ro.dixin"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="底薪" prop="dixin">
					<el-input v-model="ruleForm.dixin" placeholder="底薪" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="绩效" prop="jixiao">
					<el-input v-model="ruleForm.jixiao" placeholder="绩效" clearable  :readonly="ro.jixiao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="绩效" prop="jixiao">
					<el-input v-model="ruleForm.jixiao" placeholder="绩效" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="岗位补贴" prop="gangweibutie">
					<el-input v-model="ruleForm.gangweibutie" placeholder="岗位补贴" clearable  :readonly="ro.gangweibutie"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="岗位补贴" prop="gangweibutie">
					<el-input v-model="ruleForm.gangweibutie" placeholder="岗位补贴" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="全勤奖" prop="quanqinjiang">
					<el-input v-model="ruleForm.quanqinjiang" placeholder="全勤奖" clearable  :readonly="ro.quanqinjiang"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="全勤奖" prop="quanqinjiang">
					<el-input v-model="ruleForm.quanqinjiang" placeholder="全勤奖" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="加班费" prop="jiabanfei">
					<el-input v-model="ruleForm.jiabanfei" placeholder="加班费" clearable  :readonly="ro.jiabanfei"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="加班费" prop="jiabanfei">
					<el-input v-model="ruleForm.jiabanfei" placeholder="加班费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="扣绩效" prop="koujixiao">
					<el-input v-model="ruleForm.koujixiao" placeholder="扣绩效" clearable  :readonly="ro.koujixiao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="扣绩效" prop="koujixiao">
					<el-input v-model="ruleForm.koujixiao" placeholder="扣绩效" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="其它扣款" prop="qitakoukuan">
					<el-input v-model="ruleForm.qitakoukuan" placeholder="其它扣款" clearable  :readonly="ro.qitakoukuan"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="其它扣款" prop="qitakoukuan">
					<el-input v-model="ruleForm.qitakoukuan" placeholder="其它扣款" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'" label="实发工资" prop="shifagongzi">
					<el-input v-model="shifagongzi" placeholder="实发工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-else-if="ruleForm.shifagongzi" label="实发工资" prop="shifagongzi">
					<el-input v-model="ruleForm.shifagongzi" placeholder="实发工资" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="工资备注" prop="gongzibeizhu">
					<el-input v-model="ruleForm.gongzibeizhu" placeholder="工资备注" clearable  :readonly="ro.gongzibeizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="工资备注" prop="gongzibeizhu">
					<el-input v-model="ruleForm.gongzibeizhu" placeholder="工资备注" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="部门账号" prop="bumenzhanghao">
					<el-input v-model="ruleForm.bumenzhanghao" placeholder="部门账号" clearable  :readonly="ro.bumenzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="部门账号" prop="bumenzhanghao">
					<el-input v-model="ruleForm.bumenzhanghao" placeholder="部门账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' class="input" v-if="type!='info'"  label="部门名称" prop="bumenmingcheng">
					<el-input v-model="ruleForm.bumenmingcheng" placeholder="部门名称" clearable  :readonly="ro.bumenmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"padding":"0px","boxShadow":"0px 0px 0px 0px #d2b3aa","margin":"0 0 20px 0","borderColor":"#d3a7be","borderRadius":"0px","background":"#fff","borderWidth":"0px","display":"block","width":"100%","minWidth":"500px","borderStyle":"solid"}' v-else class="input" label="部门名称" prop="bumenmingcheng">
					<el-input v-model="ruleForm.bumenmingcheng" placeholder="部门名称" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto","background":"none"}' class="btn">
				<el-button :style='{"border":"1px solid #6ebe9b","cursor":"pointer","padding":"0 16px","boxShadow":"inset 0px 0px 56px 0px #5dae8b","margin":"20px 40px 20px 0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
				<el-button :style='{"border":"1px solid #e68888","cursor":"pointer","padding":"0 16px","boxShadow":"inset 0px 0px 56px 0px #ff7676","margin":"0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
				<el-button :style='{"border":"1px solid #e68888","cursor":"pointer","padding":"0 16px","boxShadow":"inset 0px 0px 56px 0px #ff7676","margin":"0","color":"#fff","minWidth":"120px","outline":"none","borderRadius":"4px","background":"#fff","width":"auto","lineHeight":"44px","fontSize":"14px","height":"44px"}' v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				gangweimingcheng : false,
				xuehao : false,
				xueshengxingming : false,
				dixin : false,
				jixiao : false,
				gangweibutie : false,
				quanqinjiang : false,
				jiabanfei : false,
				koujixiao : false,
				qitakoukuan : false,
				shifagongzi : false,
				gongzibeizhu : false,
				bumenzhanghao : false,
				bumenmingcheng : false,
				ispay : false,
				userid : false,
			},
			
			
			ruleForm: {
				gangweimingcheng: '',
				xuehao: '',
				xueshengxingming: '',
				dixin: '',
				jixiao: '',
				gangweibutie: '',
				quanqinjiang: '',
				jiabanfei: '',
				koujixiao: '',
				qitakoukuan: '',
				shifagongzi: '',
				gongzibeizhu: '',
				bumenzhanghao: '',
				bumenmingcheng: '',
				userid: '',
			},
		
			gangweimingchengOptions: [],
			xuehaoOptions: [],
			
			rules: {
				gangweimingcheng: [
					{ required: true, message: '岗位名称不能为空', trigger: 'blur' },
				],
				xuehao: [
					{ required: true, message: '学号不能为空', trigger: 'blur' },
				],
				xueshengxingming: [
				],
				dixin: [
					{ required: true, message: '底薪不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jixiao: [
					{ required: true, message: '绩效不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				gangweibutie: [
					{ required: true, message: '岗位补贴不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				quanqinjiang: [
					{ required: true, message: '全勤奖不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				jiabanfei: [
					{ required: true, message: '加班费不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				koujixiao: [
					{ required: true, message: '扣绩效不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				qitakoukuan: [
					{ required: true, message: '其它扣款不能为空', trigger: 'blur' },
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				shifagongzi: [
				],
				gongzibeizhu: [
				],
				bumenzhanghao: [
				],
				bumenmingcheng: [
				],
				ispay: [
				],
				userid: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {
		shifagongzi: {
			get: function () {
				return 0+parseFloat(this.ruleForm.dixin==""?0:this.ruleForm.dixin)+parseFloat(this.ruleForm.jixiao==""?0:this.ruleForm.jixiao)+parseFloat(this.ruleForm.gangweibutie==""?0:this.ruleForm.gangweibutie)+parseFloat(this.ruleForm.quanqinjiang==""?0:this.ruleForm.quanqinjiang)+parseFloat(this.ruleForm.jiabanfei==""?0:this.ruleForm.jiabanfei)-parseFloat(this.ruleForm.koujixiao==""?0:this.ruleForm.koujixiao)-parseFloat(this.ruleForm.qitakoukuan==""?0:this.ruleForm.qitakoukuan) || 0
			}
		},



	},
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='gangweimingcheng'){
							this.ruleForm.gangweimingcheng = obj[o];
							this.ro.gangweimingcheng = true;
							continue;
						}
						if(o=='xuehao'){
							this.ruleForm.xuehao = obj[o];
							this.ro.xuehao = true;
							continue;
						}
						if(o=='xueshengxingming'){
							this.ruleForm.xueshengxingming = obj[o];
							this.ro.xueshengxingming = true;
							continue;
						}
						if(o=='dixin'){
							this.ruleForm.dixin = obj[o];
							this.ro.dixin = true;
							continue;
						}
						if(o=='jixiao'){
							this.ruleForm.jixiao = obj[o];
							this.ro.jixiao = true;
							continue;
						}
						if(o=='gangweibutie'){
							this.ruleForm.gangweibutie = obj[o];
							this.ro.gangweibutie = true;
							continue;
						}
						if(o=='quanqinjiang'){
							this.ruleForm.quanqinjiang = obj[o];
							this.ro.quanqinjiang = true;
							continue;
						}
						if(o=='jiabanfei'){
							this.ruleForm.jiabanfei = obj[o];
							this.ro.jiabanfei = true;
							continue;
						}
						if(o=='koujixiao'){
							this.ruleForm.koujixiao = obj[o];
							this.ro.koujixiao = true;
							continue;
						}
						if(o=='qitakoukuan'){
							this.ruleForm.qitakoukuan = obj[o];
							this.ro.qitakoukuan = true;
							continue;
						}
						if(o=='shifagongzi'){
							this.ruleForm.shifagongzi = obj[o];
							this.ro.shifagongzi = true;
							continue;
						}
						if(o=='gongzibeizhu'){
							this.ruleForm.gongzibeizhu = obj[o];
							this.ro.gongzibeizhu = true;
							continue;
						}
						if(o=='bumenzhanghao'){
							this.ruleForm.bumenzhanghao = obj[o];
							this.ro.bumenzhanghao = true;
							continue;
						}
						if(o=='bumenmingcheng'){
							this.ruleForm.bumenmingcheng = obj[o];
							this.ro.bumenmingcheng = true;
							continue;
						}
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
							continue;
						}
				}
				
















			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(((json.bumenzhanghao!=''&&json.bumenzhanghao) || json.bumenzhanghao==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.bumenzhanghao = json.bumenzhanghao
						this.ro.bumenzhanghao = true;
					}
					if(((json.bumenmingcheng!=''&&json.bumenmingcheng) || json.bumenmingcheng==0) && this.$storage.get("role")!="管理员"){
						this.ruleForm.bumenmingcheng = json.bumenmingcheng
						this.ro.bumenmingcheng = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/qingongzhuxue/gangweimingcheng`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.gangweimingchengOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.$http({
				url: `option/xuesheng/xuehao`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.xuehaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
			// 下二随
			xuehaoChange () {
				this.$http({
					url: `follow/xuesheng/xuehao?columnValue=`+ this.ruleForm.xuehao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.xueshengxingming){
							this.ruleForm.xueshengxingming = data.data.xueshengxingming
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `gongzijiesuan/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.shifagongzi = this.shifagongzi

































var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "gongzijiesuan/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `gongzijiesuan/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.gongzijiesuanCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `gongzijiesuan/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.gongzijiesuanCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.gongzijiesuanCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  text-shadow: 0 1px 10px #fff;
	  	  color: #666;
	  	  background: none;
	  	  display: inline-block;
	  	  width: 150px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 150px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  display: inline-block;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-width: 300px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #c7ebdb;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #c7ebdb;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #c7ebdb;
	  	  cursor: pointer;
	  	  border-radius: 4px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  color: #aaa;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #c7ebdb;
	  	  border-radius: 4px;
	  	  padding: 12px;
	  	  box-shadow: inset 0px 0px 24px 0px #e8f9f2;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  min-height: 150px;
	  	  min-width: 640px;
	  	  height: auto;
	  	}
</style>
