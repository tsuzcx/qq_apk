package com.tencent.weiyun.transmission.utils;

import android.util.SparseArray;

class ErrorMessages
{
  private static final String ERR_COMMON_TIPS = "出现错误 请重试!";
  private static final String ERR_DST_FILE_NOT_EXIST = "文件不存在或已经被删除";
  private static final String ERR_FILE_MODIFIED = "文件不存在或已经被删除";
  private static final String ERR_FILE_NOT_ACCESS = "读写文件失败";
  private static final String ERR_FILE_SIZE_EXCEED = "文件大小超出2G限制!";
  private static final String ERR_FILE_TYPE_NOT_SUPPORT = "该文件类型暂不支持!";
  private static final String ERR_INVALID_PARAMETER = "无效的参数!";
  private static final String ERR_INVALID_PROTO = "无效的协议!";
  private static final String ERR_NETWORK_EXCEPTION = "网络发生异常 请检查您的网络设置!";
  private static final String ERR_NETWORK_NOT_AVAILABLE = "当前网络不可用!";
  private static final String ERR_NETWORK_TIMEOUT = "网络超时 请检查您的网络设置!";
  private static final String ERR_NO_NETWORK = "没有网络!";
  private static final String ERR_QQDISK_ADD_UPLOAD_TASK_FAIL = "上传任务添加失败!";
  private static final String ERR_QQDISK_DOWNLOAD_DIR = "暂不支持下载目录!";
  private static final String ERR_QQDISK_DOWNLOAD_LACK_SPACE = "sd卡空间不足!";
  private static final String ERR_QQDISK_DOWNLOAD_UNABLE_OVERWRITE = "无法覆盖同名文件!";
  private static final String ERR_QQDISK_INVALID_RSP = "无效的响应!";
  private static final String ERR_QQDISK_NO_LOGIN = "您还没有登录 请先登录!";
  private static final String ERR_QQDISK_SERVER_ERROR = "服务器错误!";
  private static final String ERR_QQDISK_TOO_MANY_FILES = "文件数量太多!";
  private static final String ERR_QQDISK_UPLOAD_DIR = "暂时不支持上传目录!";
  private static final String ERR_QQDISK_UPLOAD_LACK_SPACE = "转存失败，微云空间不足!";
  private static final String ERR_QQDISK_UPLOAD_TO_ROOT = "不能上传到根目录!";
  private static final String ERR_RECV_FAILED = "接收数据失败!";
  private static final String ERR_REQUEST_UPLOAD_ADDRESS_TIME = "请求上传地址超时!";
  private static final String ERR_SEND_FAILED = "数据发送失败!";
  private static final String ERR_SEND_REQUEST_ERROR = "发送请求出错!";
  private static final String ERR_SRC_FILE_NOT_EXIST = "文件不存在或已经被删除";
  private static final String ERR_THUNBNAIL_NOT_EXIST = "缩略图不存在!";
  private static final String ERR_UNKNOWN_EXCEPTION = "操作出错 请重试！";
  private static final String ERR_UPLOAD_ADDRESS = "错误的上传地址!";
  private static final String ERR_USER_CANCELED = "取消了上传、下载过程!";
  private static final String ERR_WRONG_HTTP_RESPONSE = "下载失败 文件被删除或者没有权限下载!";
  private static final String TAG = "ErrorMessages";
  private static final SparseArray<String> sErrorMessageMap = new SparseArray();
  
  static
  {
    sErrorMessageMap.put(1830001, "网络超时 请检查您的网络设置!");
    sErrorMessageMap.put(1830002, "网络超时 请检查您的网络设置!");
    sErrorMessageMap.put(1830003, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830004, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830005, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830006, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830007, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830008, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830009, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830010, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830011, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830012, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830013, "无效的协议!");
    sErrorMessageMap.put(1830014, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830015, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830016, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830017, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830018, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830026, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830023, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830027, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830019, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830020, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830021, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1830022, "网络发生异常 请检查您的网络设置!");
    sErrorMessageMap.put(1829001, "无效的响应!");
    sErrorMessageMap.put(1829005, "无效的响应!");
    sErrorMessageMap.put(1829002, "无效的参数!");
    sErrorMessageMap.put(1829003, "无效的响应!");
    sErrorMessageMap.put(1810011, "发送请求出错!");
    sErrorMessageMap.put(1810040, "错误的上传地址!");
    sErrorMessageMap.put(1810035, "请求上传地址超时!");
    sErrorMessageMap.put(1810012, "无效的参数!");
    sErrorMessageMap.put(1810013, "无效的参数!");
    sErrorMessageMap.put(1810001, "无效的参数!");
    sErrorMessageMap.put(1810003, "没有网络!");
    sErrorMessageMap.put(1810004, "当前网络不可用!");
    sErrorMessageMap.put(1810005, "文件不存在或已经被删除");
    sErrorMessageMap.put(1810006, "文件不存在或已经被删除");
    sErrorMessageMap.put(1810007, "读写文件失败");
    sErrorMessageMap.put(1810016, "读写文件失败");
    sErrorMessageMap.put(1810010, "该文件类型暂不支持!");
    sErrorMessageMap.put(1810009, "文件不存在或已经被删除");
    sErrorMessageMap.put(1810015, "文件大小超出2G限制!");
    sErrorMessageMap.put(1829004, "缩略图不存在!");
    sErrorMessageMap.put(1810002, "取消了上传、下载过程!");
    sErrorMessageMap.put(1810014, "操作出错 请重试！");
    sErrorMessageMap.put(1810023, "服务器错误!");
    sErrorMessageMap.put(1810024, "无效的响应!");
    sErrorMessageMap.put(1810026, "您还没有登录 请先登录!");
    sErrorMessageMap.put(1810029, "转存失败，微云空间不足!");
    sErrorMessageMap.put(1810031, "sd卡空间不足!");
    sErrorMessageMap.put(1810030, "暂时不支持上传目录!");
  }
  
  static String getErrorString(int paramInt)
  {
    String str2 = (String)sErrorMessageMap.get(paramInt);
    String str1 = str2;
    if (str2 == null)
    {
      TsLog.w("ErrorMessages", "Not find the error string, please check classes ErrorCode and ErrorMessage.");
      str1 = null;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.utils.ErrorMessages
 * JD-Core Version:    0.7.0.1
 */