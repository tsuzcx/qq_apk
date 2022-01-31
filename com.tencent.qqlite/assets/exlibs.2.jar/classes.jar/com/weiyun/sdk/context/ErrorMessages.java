package com.weiyun.sdk.context;

import android.util.Log;
import android.util.SparseArray;

public class ErrorMessages
{
  public static final String ERR_COMMON_TIPS = "出现错误，请重试!";
  public static final String ERR_DST_FILE_NOT_EXIST = "文件不存在或已经被删除";
  public static final String ERR_FILE_MODIFIED = "文件不存在或已经被删除";
  public static final String ERR_FILE_NOT_ACCESS = "读写文件失败";
  public static final String ERR_FILE_SIZE_EXCEED = "文件大小超出2G限制!";
  public static final String ERR_FILE_TYPE_NOT_SUPPORT = "该文件类型暂不支持!";
  public static final String ERR_INVALID_PARAMETER = "无效的参数!";
  public static final String ERR_INVALID_PROTO = "无效的协议!";
  public static final String ERR_NETWORK_EXCEPTION = "网络发生异常，请检查您的网络设置!";
  public static final String ERR_NETWORK_NOT_AVAILABLE = "当前网络不可用!";
  public static final String ERR_NETWORK_TIMEOUT = "网络超时，请检查您的网络设置!";
  public static final String ERR_NO_NETWORK = "没有网络!";
  public static final String ERR_QQDISK_ADD_UPLOAD_TASK_FAIL = "上传任务添加失败!";
  public static final String ERR_QQDISK_DOWNLOAD_DIR = "暂不支持下载目录!";
  public static final String ERR_QQDISK_DOWNLOAD_LACK_SPACE = "sd卡空间不足!";
  public static final String ERR_QQDISK_DOWNLOAD_UNABLE_OVERWRITE = "无法覆盖同名文件!";
  public static final String ERR_QQDISK_INVALID_RSP = "无效的响应!";
  public static final String ERR_QQDISK_NO_LOGIN = "您还没有登录，请先登录!";
  public static final String ERR_QQDISK_SERVER_ERROR = "服务器错误!";
  public static final String ERR_QQDISK_TOO_MANY_FILES = "文件数量太多!";
  public static final String ERR_QQDISK_UPLOAD_DIR = "暂时不支持上传目录!";
  public static final String ERR_QQDISK_UPLOAD_LACK_SPACE = "转存失败，微云空间不足!";
  public static final String ERR_QQDISK_UPLOAD_TO_ROOT = "不能上传到根目录!";
  public static final String ERR_RECV_FAILED = "接收数据失败!";
  public static final String ERR_SEND_FAILED = "数据发送失败!";
  public static final String ERR_SRC_FILE_NOT_EXIST = "文件不存在或已经被删除";
  public static final String ERR_THUNBNAIL_NOT_EXIST = "缩略图不存在!";
  public static final String ERR_UNKOWN_EXCEPTION = "未知错误!";
  public static final String ERR_USER_CANCELED = "取消了上传、下载过程!";
  public static final String ERR_WRONG_HTTP_RESPONSE = "下载失败，文件被删除或者没有权限下载!";
  private static final String TAG = "ErrorMessages";
  private static final SparseArray<String> sErrorMessageMap = new SparseArray();
  
  static
  {
    sErrorMessageMap.put(-30001, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(-30002, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(-30028, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(-30029, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(-30003, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30004, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30005, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30006, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30007, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30008, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30009, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30010, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30011, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30012, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30013, "无效的协议!");
    sErrorMessageMap.put(-30014, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30015, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30016, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30017, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30018, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30024, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(-30025, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30026, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30023, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30027, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30090, "网络超时，请检查您的网络设置!");
    sErrorMessageMap.put(-30091, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30019, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30020, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30021, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-30022, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-29001, "下载失败，文件被删除或者没有权限下载!");
    sErrorMessageMap.put(-29005, "下载失败，文件被删除或者没有权限下载!");
    sErrorMessageMap.put(-29002, "无效的参数!");
    sErrorMessageMap.put(-29003, "下载失败，文件被删除或者没有权限下载!");
    sErrorMessageMap.put(-28001, "无效的协议!");
    sErrorMessageMap.put(-28002, "接收数据失败!");
    sErrorMessageMap.put(-28003, "无效的协议!");
    sErrorMessageMap.put(-28004, "接收数据失败!");
    sErrorMessageMap.put(-10011, "网络发生异常，请检查您的网络设置!");
    sErrorMessageMap.put(-10012, "无效的参数!");
    sErrorMessageMap.put(-10013, "无效的参数!");
    sErrorMessageMap.put(-10001, "无效的参数!");
    sErrorMessageMap.put(-10003, "没有网络!");
    sErrorMessageMap.put(-10004, "当前网络不可用!");
    sErrorMessageMap.put(-10005, "文件不存在或已经被删除");
    sErrorMessageMap.put(-10006, "文件不存在或已经被删除");
    sErrorMessageMap.put(-10008, "读写文件失败");
    sErrorMessageMap.put(-10007, "读写文件失败");
    sErrorMessageMap.put(-10016, "读写文件失败");
    sErrorMessageMap.put(-10010, "该文件类型暂不支持!");
    sErrorMessageMap.put(-10009, "文件不存在或已经被删除");
    sErrorMessageMap.put(-10015, "文件大小超出2G限制!");
    sErrorMessageMap.put(-29004, "缩略图不存在!");
    sErrorMessageMap.put(-10002, "取消了上传、下载过程!");
    sErrorMessageMap.put(-10014, "未知错误!");
    sErrorMessageMap.put(-10023, "服务器错误!");
    sErrorMessageMap.put(-10024, "无效的响应!");
    sErrorMessageMap.put(-10025, "上传任务添加失败!");
    sErrorMessageMap.put(-10026, "您还没有登录，请先登录!");
    sErrorMessageMap.put(-10027, "文件数量太多!");
    sErrorMessageMap.put(-10028, "不能上传到根目录!");
    sErrorMessageMap.put(-10029, "转存失败，微云空间不足!");
    sErrorMessageMap.put(-10030, "暂时不支持上传目录!");
    sErrorMessageMap.put(-10031, "sd卡空间不足!");
    sErrorMessageMap.put(-10032, "暂不支持下载目录!");
    sErrorMessageMap.put(-10033, "无法覆盖同名文件!");
  }
  
  public static String getErrorString(int paramInt)
  {
    try
    {
      String str2 = (String)sErrorMessageMap.get(paramInt);
      String str1 = str2;
      if (str2 == null)
      {
        Log.w("ErrorMessages", "do not find the error string,please check ErrorCode.java and ErrorMessage.java.");
        str1 = null;
      }
      return str1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.context.ErrorMessages
 * JD-Core Version:    0.7.0.1
 */