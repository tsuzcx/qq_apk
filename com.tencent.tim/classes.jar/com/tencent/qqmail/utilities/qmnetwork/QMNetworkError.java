package com.tencent.qqmail.utilities.qmnetwork;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.report.QMReportManager;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMNetworkError
  extends Throwable
{
  public static final int ERROR_ABORT_CODE = -10002;
  public static final String ERROR_ABORT_DESCRIPTION = "请求已经被取消";
  public static final int ERROR_ACCOUNT_ALIAS_EXIST_CODE = -10017;
  public static final String ERROR_ACCOUNT_ALIAS_EXIST_DESCRIPTION = "当前帐号与%s是相同邮箱帐号，无需重复登录";
  public static final int ERROR_ACCOUNT_CHANGED_CODE = -10005;
  public static final String ERROR_ACCOUNT_CHANGED_DESCRIPTION = "帐号已经切换";
  public static final int ERROR_ACCOUNT_EXIST_CODE = -10007;
  public static final String ERROR_ACCOUNT_EXIST_DESCRIPTION = "帐号已存在，无需重复登录";
  public static final int ERROR_ACCOUNT_EXIT_CODE = -10006;
  public static final String ERROR_ACCOUNT_EXIT_DESCRIPTION = "帐号已经退出";
  public static final int ERROR_CACHE_WRITE_EMPTYFILE_CODE = -10009;
  public static final String ERROR_CACHE_WRITE_EMPTYFILE_DESCRIPTION = "缓存文件为空，请重新下载";
  public static final int ERROR_CANNOT_CONNECT_CODE = -10001;
  public static final String ERROR_CANNOT_CONNECT_DESCRIPTION = "网络连接不可用，请稍候重试";
  public static final int ERROR_DEFAULT_CODE = -10000;
  public static final String ERROR_DEFAULT_DESCRIPTION = "网络错误";
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_CANNOT_RECEIVE_SEFL = -820;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_EMPTY_EMAIL = -811;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_INVALIATE_CODE = -814;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_LINK_EXPIRED = -824;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_MAIL_LINK_EXPIRED = -823;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_NOT_QQDOMAIN = -812;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_NOT_SHARE_TO_YOU = -810;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_SHARE_DELETED = -822;
  public static final int ERROR_FOLLOW_CALENDAR_ERROR_SHARE_STOP = -821;
  public static final int ERROR_GMAIL_AUTH_CODE = -10013;
  public static final String ERROR_GMAIL_AUTH_DESCRIPTION = "Gmail授权登录失败";
  public static final int ERROR_HTTP_FAILED_CODE = -10003;
  public static final String ERROR_HTTP_FAILED_DESCRIPTION = "网络错误，请查看http状态码";
  public static final int ERROR_INVALID_JSON_CODE = -10004;
  public static final String ERROR_INVALID_JSON_DESCRIPTION = "数据格式错误";
  public static final int ERROR_MAIL_APPLE_ID_VERIFY_EMPTY = -200;
  public static final int ERROR_MAIL_APPLE_ID_VERIFY_ERROR = -203;
  public static final int ERROR_MAIL_APPLE_ID_VERIFY_FREQ = -202;
  public static final int ERROR_MAIL_APPLE_ID_VERIFY_SYS_ERROR = -201;
  public static final int ERROR_MAIL_DELETED = -10011;
  public static final String ERROR_MAIL_DELETED_DESCRIPTION = "该邮件已被删除";
  public static final int ERROR_PARSEMAIL_CODE = -10008;
  public static final String ERROR_PARSEMAIL_DESCRIPTION = "邮件解析失败";
  public static final int ERROR_PARSE_ATTACHFOLDER_CODE = -10010;
  public static final String ERROR_PARSE_ATTACHFOLDER_DESCRIPTION = "附件夹数据解析失败";
  public static final int ERROR_PARSE_TRANSLATE_MAIL_CODE = -10016;
  public static final String ERROR_PARSE_TRANSLATE_MAIL_DESCRIPTION = "解析翻译邮件失败";
  public static final int ERROR_RECALL_MAIL_CODE = -10014;
  public static final String ERROR_RECALL_MAIL_DESCRIPTION = "撤回邮件失败";
  public static final int ERROR_RECALL_MAIL_QUERY_CODE = -10015;
  public static final String ERROR_RECALL_MAIL_QUERY_DESCRIPTION = "撤回邮件失败";
  public static final int ERROR_SHARE_CALENDAR_ERROR_NEED_VERIFY = -2;
  public static final int ERROR_SHARE_CALENDAR_ERROR_PROTOCOL_DOMAIN = -501;
  public static final int ERROR_SHARE_CALENDAR_ERROR_SHARE_HAS_INVITED = 1;
  public static final int ERROR_SHARE_CALENDAR_ERROR_SHARE_TO_SELF = -502;
  public static final int ERROR_SHARE_CALENDAR_ERROR_UNKNOWN = -1;
  public static final int ERROR_SHARE_CALENDAR_ERROR_VERIFY_ERROR = -141;
  public static final int ERROR_SSL_ERROR = -600;
  public static final int ERROR_ZIP_DATA_EXCEPTION_CODE = -10012;
  public static final String ERROR_ZIP_DATA_EXCEPTION_DESCRIPTION = "获取附件内容错误";
  public static final int GEN_QQ_SAFECODE_ERROR = -101;
  public static final int GEN_QQ_SAFECODE_ERROR_FREQ = -112;
  public static final int GEN_QQ_SAFECODE_FREQ = -102;
  public static final int GEN_WX_SAFECODE_ERROR = -111;
  public static final int GEN_WX_SAFECODE_UNBIND = -110;
  private static Matcher m;
  private static Pattern requestDetailPattern = Pattern.compile(".*?;.*?;.*?;");
  public final int code;
  public final String debugDescription;
  @NonNull
  public final String desp;
  public final String url;
  
  public QMNetworkError(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, "", "");
  }
  
  public QMNetworkError(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, paramString, paramString);
  }
  
  public QMNetworkError(int paramInt1, int paramInt2, @NonNull String paramString1, String paramString2)
  {
    ValidateHelper.notNull(paramString1);
    this.code = paramInt2;
    if (paramString1 == null) {}
    for (String str = "";; str = paramString1)
    {
      this.desp = str;
      this.url = "";
      this.debugDescription = paramString2;
      QMReportManager.reportNetworkError(this, paramInt1, paramInt2, paramString1, paramString2, null);
      if (((paramInt1 == 2) || (paramInt1 == 8)) && (!QMApplicationContext.sharedInstance().isStartCrashed()))
      {
        paramString1 = new StringBuilder();
        if ((paramInt2 == -10000) || (paramInt1 == 8))
        {
          if (!despContainsRequestDetail(paramString2)) {
            paramString1.append(";;;");
          }
          paramString1.append(paramString2);
        }
        if (paramInt1 != 8) {
          break;
        }
        if (paramInt2 != -1) {
          DataCollector.logException(paramInt1, paramInt2, "Event_Error", paramString1.toString(), false);
        }
      }
      return;
    }
    DataCollector.logException(paramInt1, paramInt2, "Event_Error", paramString1.toString(), false);
  }
  
  public QMNetworkError(int paramInt1, int paramInt2, @NonNull String paramString1, String paramString2, String paramString3)
  {
    ValidateHelper.notNull(paramString1);
    this.code = paramInt2;
    Object localObject;
    if (paramString1 == null) {
      localObject = "";
    }
    for (;;)
    {
      this.desp = ((String)localObject);
      this.url = paramString3;
      this.debugDescription = paramString2;
      QMReportManager.reportNetworkError(this, paramInt1, paramInt2, paramString1, paramString2, paramString3);
      if (((paramInt1 == 2) || (paramInt1 == 8)) && (!QMApplicationContext.sharedInstance().isStartCrashed())) {
        localObject = new StringBuilder();
      }
      try
      {
        ((StringBuilder)localObject).append(((JSONObject)JSONReader.parse(paramString1)).toJSONString());
        if (paramInt2 == -10000) {
          ((StringBuilder)localObject).append(",").append(paramString2);
        }
        if (!TextUtils.isEmpty(paramString3)) {}
        try
        {
          paramString1 = new URL(paramString3);
          ((StringBuilder)localObject).append(",").append(paramString1.getHost());
          paramString1 = paramString1.getPath();
          if ((paramString1 != null) && (paramString1.startsWith("/cgi-bin/")))
          {
            paramString1 = paramString1.substring("/cgi-bin/".length());
            ((StringBuilder)localObject).append(",").append(paramString1);
          }
        }
        catch (MalformedURLException paramString1)
        {
          label190:
          break label190;
        }
        DataCollector.logException(paramInt1, paramInt2, "Event_Error", ((StringBuilder)localObject).toString(), false);
        return;
        localObject = paramString1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ((StringBuilder)localObject).append(paramString1.replaceAll(";", "_"));
        }
      }
    }
  }
  
  public static boolean despContainsRequestDetail(String paramString)
  {
    m = requestDetailPattern.matcher(paramString);
    return m.find();
  }
  
  public int getCode()
  {
    return this.code;
  }
  
  public String toString()
  {
    return "{code: " + this.code + ", desp: " + this.desp + ", debugDescription: " + this.debugDescription + ", url: " + this.url + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMNetworkError
 * JD-Core Version:    0.7.0.1
 */