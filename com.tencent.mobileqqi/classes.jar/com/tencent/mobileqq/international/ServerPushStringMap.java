package com.tencent.mobileqq.international;

import java.util.HashMap;

public class ServerPushStringMap
  extends HashMap
{
  private static volatile ServerPushStringMap a;
  private static final long serialVersionUID = 1L;
  
  private ServerPushStringMap()
  {
    put("登录成功", Integer.valueOf(2131558613));
    put("帐号或密码错误，请重新输入。", Integer.valueOf(2131558667));
    put("请输入正确的帐号。", Integer.valueOf(2131558652));
    put("您长时间没有登录，为确保安全，请重新输入密码。", Integer.valueOf(2131558653));
    put("您的帐号因为存在安全风险，已进入安全保护状态，暂时不能登录。", Integer.valueOf(2131558654));
    put("您的帐号长期未登录已经冻结，建议您申请一个新号码使用。", Integer.valueOf(2131558655));
    put("您的帐号由于存在安全风险，建议前往安全中心解除限制。", Integer.valueOf(2131558656));
    put("本次登录存在异常，如需帮助请前往安全中心。", Integer.valueOf(2131558657));
    put("您的QQ号码服务已到期，请尽快续费。", Integer.valueOf(2131558658));
    put("您的帐号已锁定，前往QQ安全中心查看解锁方法。", Integer.valueOf(2131558659));
    put("您已禁止该帐号在手机、平板电脑登录，如需登录，前往安全中心修改设置。", Integer.valueOf(2131558660));
    put("短信频率限制，请您稍后登录。", Integer.valueOf(2131558661));
    put("取短信失败，请您稍后重试。", Integer.valueOf(2131558662));
    put("您的版本已停止使用，请下载最新的版本。", Integer.valueOf(2131558663));
    put("APP信息验证失败，无法跳转，请您输入帐号密码登录。", Integer.valueOf(2131558664));
    put("看到这个说明你接入了svr的测试环境或使用的appid==1，请一定要在提交AppStore前让我消失啊。", Integer.valueOf(2131558665));
    put("获取SID失败", Integer.valueOf(2131558614));
    put("请输入验证码", Integer.valueOf(2131558615));
    put("请发送短信进行激活", Integer.valueOf(2131558616));
    put("提示升级", Integer.valueOf(2131558617));
    put("禁止登录", Integer.valueOf(2131558618));
    put("操作失败", Integer.valueOf(2131558619));
    put("频率限制", Integer.valueOf(2131558620));
    put("帐号或密码错误", Integer.valueOf(2131558621));
    put("号码错误", Integer.valueOf(2131558622));
    put("验证码已过期 # sid错误", Integer.valueOf(2131558623));
    put("客户端参数错误", Integer.valueOf(2131558624));
    put("权限不足", Integer.valueOf(2131558625));
    put("验证码错误", Integer.valueOf(2131558626));
    put("key验证错误", Integer.valueOf(2131558627));
    put("没有开通微", Integer.valueOf(2131558628));
    put("此email未关联QQ帐号", Integer.valueOf(2131558629));
    put("帐号不合法", Integer.valueOf(2131558630));
    put("帐号不存在", Integer.valueOf(2131558631));
    put("后端服务器超时", Integer.valueOf(2131558632));
    put("获取票据类型非法", Integer.valueOf(2131558633));
    put("获取票据权限不足", Integer.valueOf(2131558634));
    put("appid错误", Integer.valueOf(2131558635));
    put("身份过期，请重新登录", Integer.valueOf(2131558636));
    put("帐号不存在，请检查是否输入正确", Integer.valueOf(2131558637));
    put("密码不正确且ip受限", Integer.valueOf(2131558639));
    put("IP受限", Integer.valueOf(2131558638));
    put("密码错误且IP受限,", Integer.valueOf(2131558639));
    put("帐号冻结", Integer.valueOf(2131558640));
    put("您的号码已暂时被限制登录，请联系0755-83765566按3号键查询", Integer.valueOf(2131558641));
    put("DNA被关注", Integer.valueOf(2131558642));
    put("员工帐号禁止登录", Integer.valueOf(2131558643));
    put("您的帐号暂时无法登录，请到http://aq.qq.com/007恢复正常使用", Integer.valueOf(2131558644));
    put("对不起，该号码的服务到期或已关闭。请访问http://my.qq.com/number登录查询您的号码状态。拨打16885886可为靓号快捷续费。", Integer.valueOf(2131558645));
    put("您的帐号已锁定，解锁详情请查看http://m.aq.qq.com/js", Integer.valueOf(2131558646));
    put("非财付通号码", Integer.valueOf(2131558647));
    put("不允许登录财付通账号", Integer.valueOf(2131558648));
    put("号码被回收", Integer.valueOf(2131558649));
    put("系统维护", Integer.valueOf(2131558650));
    put("服务器超时", Integer.valueOf(2131558651));
    put("请检查帐号是否输入正确，该帐号因长期未登录已经冻结，如有需要可以申请一个新号码使用。", Integer.valueOf(2131558668));
    put("请输入正确的账号。", Integer.valueOf(2131558669));
    put("查看相册", Integer.valueOf(2131559834));
    put("查看了你的相册", Integer.valueOf(2131559842));
    put("查看日志", Integer.valueOf(2131559835));
    put("查看了你的日志", Integer.valueOf(2131559842));
    put("查看说说", Integer.valueOf(2131559838));
    put("查看了你的说说", Integer.valueOf(2131559845));
    put("听了语音", Integer.valueOf(2131559841));
    put("收听了你的语音", Integer.valueOf(2131559848));
    put("看了视频", Integer.valueOf(2131559840));
    put("观看了你的视频", Integer.valueOf(2131559847));
    put("收听音乐", Integer.valueOf(2131559836));
    put("收听了你的音乐", Integer.valueOf(2131559843));
    put("查看分享", Integer.valueOf(2131559837));
    put("查看了你的分享", Integer.valueOf(2131559844));
    put("访问空间", Integer.valueOf(2131559839));
    put("访问了你的空间", Integer.valueOf(2131559846));
    put("没有找到符合搜索条件的用户", Integer.valueOf(2131559855));
    put("请让身边的人打开文件近传", Integer.valueOf(2131560876));
    put("开启设备锁，即使帐号被盗，他人也无法登录你的QQ。保障你的帐号财产安全。", Integer.valueOf(2131563211));
    put("开启保护", Integer.valueOf(2131562011));
    put("开启设备锁", Integer.valueOf(2131562008));
    put("在电脑上首次登录时，需要用QQ手机版扫描二维码。", Integer.valueOf(2131562682));
    put("在另一台手机上首次登录时，需要手机短信验证。", Integer.valueOf(2131562939));
    put("确认以下手机号码是你的常用号码吗？", Integer.valueOf(2131561861));
    put("开启设备锁后，在非常用手机上首次登录QQ时需要使用该号码接收验证短信。该号码是你设置的密保手机号。", Integer.valueOf(2131561622));
    put("功能介绍", Integer.valueOf(2131559852));
    put("认证资料", Integer.valueOf(2131559853));
    put("查看消息", Integer.valueOf(2131559850));
    put("查看历史消息", Integer.valueOf(2131559849));
    put("接收消息", Integer.valueOf(2131559851));
    put("消息提醒", Integer.valueOf(2131559854));
    put("连接失败，对方不在线或版本不支持，请让对方登录最新QQ手机版", Integer.valueOf(2131563321));
    put("您输入短信验证码有误，请重新提交。\n", Integer.valueOf(2131563322));
    put("位置分享", Integer.valueOf(2131562308));
    put("说说和日志相册", Integer.valueOf(2131563326));
    put("说说和日志相册，保存您在说说、日志中上传的照片。默认仅自己可...", Integer.valueOf(2131563327));
    put("你当前在新手机上登录，需通过密保手机短信验证确认你的身份。验证通过后下次登录无需再验证。", Integer.valueOf(2131563163));
    put("上传了照片", Integer.valueOf(2131563328));
    put("QQ空间", Integer.valueOf(2131562710));
  }
  
  public static ServerPushStringMap getInstance()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ServerPushStringMap();
      }
      return a;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.international.ServerPushStringMap
 * JD-Core Version:    0.7.0.1
 */