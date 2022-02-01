package com.tencent.qqmail.utilities.qmnetwork;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;

public final class QMNetworkConfig
{
  public static final String APPLE_ID_MAIL_HELP_PAGE = "https://app.mail.qq.com/app/app_apple_id_verify_android_help.html";
  public static final String BIZ_HOST = "i.exmail.qq.com";
  public static final String CALENDAR_ICON_URL = "https://app.mail.qq.com/app/share/icon_share_cal.png";
  public static final String CGI_BIN = "/cgi-bin/";
  private static final String CGI_BIZ_HOST = "http://i.exmail.qq.com";
  private static final String CGI_BIZ_HOST_HTTPS = "https://i.exmail.qq.com";
  private static final String CGI_HOST = "http://i.mail.qq.com";
  private static final String CGI_HOST_HTTPS = "https://i.mail.qq.com";
  public static final String CGI_PARENT = "http://mail.qq.com";
  public static final String CGI_PARENT_HTTPS = "https://mail.qq.com";
  public static final String CGI_SNAP = "http://shot.mail.qq.com/cgi-bin/MailSnapShort?inputf=userdef&type=1";
  public static final String CHAR_SET = "UTF-8";
  public static final int CONNECT_TIME_OUT = 15000;
  public static final String FAQ_URL = "https://kf.qq.com/touch/product/mail_app.html?scene_id=kf1866";
  public static final String HOST = "i.mail.qq.com";
  public static final String HOST_AQ = "aq.qq.com";
  public static final String HOST_KF = "kf.qq.com";
  public static final String HOST_QUMAS = "qumas.mail.qq.com";
  public static final String HOST_RESCDN = "rescdn.qqmail.com";
  public static final String HOST_SHOT = "shot.mail.qq.com";
  public static final String HOST_UMASOCKET = "umasocksproxy.mail.qq.com";
  public static final String LOGIN_APP_REGISTER_PHONE_NUMBER_HELP_URL = "https://i.mail.qq.com/app/app_register_help/phonenumber_account.html";
  public static final String LOGIN_FIND_PWD_URL = "https://aq.qq.com/cn2/findpsw/mobile_v2/mobile_web_find_input_account?find_type=1&source_id=3194&from=qq";
  public static final String LOGIN_FIND_SECOND_PWD_URL = "https://aq.qq.com/cn2/findpsw/mobile_v2/mobile_web_find_input_account?find_type=2&source_id=3194&from=qq";
  public static final String LOGIN_ICLOUD_AUTH_URL = "https://i.mail.qq.com/app/app_register_help/icloud_login_help.html";
  public static final String LOGIN_IMAP_126_AUTH_URL = "https://i.mail.qq.com/app/app_register_help/forgetpassword_126.html";
  public static final String LOGIN_IMAP_126_DENIED_URL = "https://i.mail.qq.com/app/app_register_help/imap_126.html";
  public static final String LOGIN_IMAP_163_AUTH_URL = "https://i.mail.qq.com/app/app_register_help/forgetpassword_163.html";
  public static final String LOGIN_IMAP_163_DENIED_URL = "https://i.mail.qq.com/app/app_register_help/imap_163.html";
  public static final String LOGIN_IMAP_OUTLOOK_AUTH_URL = "https://i.mail.qq.com/app/app_register_help/outlook_login_help.html";
  public static final String LOGIN_IMAP_OUTLOOK_DENIED_URL = "https://i.mail.qq.com/app/app_register_help/outlook_login_help.html";
  public static final String LOGIN_IMAP_SINA_DENIED_URL = "https://i.mail.qq.com/app/app_register_help/sina_login_help.html";
  public static final String LOGIN_IMAP_YAHOO_AUTH_URL = "https://i.mail.qq.com/app/app_register_help/yahoo_login_help.html";
  public static final String LOGIN_IMAP_YAHOO_DENIED_URL = "https://i.mail.qq.com/app/app_register_help/yahoo_login_help.html";
  public static final String LOGIN_IMAP_YEAH_AUTH_URL = "https://i.mail.qq.com/app/app_register_help/forgetpassword_yeah.html";
  public static final String LOGIN_IMAP_YEAH_DENIED_URL = "https://i.mail.qq.com/app/app_register_help/imap_yeah.html";
  public static final String PARENT_HOST = "mail.qq.com";
  public static final int PORT = 80;
  public static final int PORT_443 = 443;
  public static final int PORT_8080 = 8080;
  public static final int PROXY_SOCKET_CONNECT_TIME_OUT = 10000;
  public static final String PROXY_SOCKET_DX = "113.108.20.85";
  public static final String PROXY_SOCKET_HK = "103.7.30.59";
  public static final String PROXY_SOCKET_LT = "163.177.65.221";
  public static final String PROXY_SOCKET_YD = "211.136.236.77";
  public static final int PUSH_CONNECT_TIME_OUT = 15000;
  public static final int PUSH_READ_TIME_OUT = 900000;
  public static final String QQ_DOWNLOAD_URL = "http://im.qq.com/download/";
  public static final String READ_TEMPLATE_URL = "https://mail.qq.com/cgi-bin/readtemplate?check=false&t=mail_clause";
  public static final int READ_TIME_OUT = 15000;
  public static final String REG_LICENSE_URL = "https://mail.qq.com/cgi-bin/readtemplate?check=false&t=mail_clause";
  public static final String REG_REGISTER_HELP = "https://i.mail.qq.com/app/app_register_help/setpassword_phonenumbermail.html";
  public static final String SAFE_CHECK_HOST = "url.qmail.com";
  public static final String SHOT_HOST = "http://shot.mail.qq.com";
  public static final String SUBSCRIBE_SERVICE = "http://rescdn.qqmail.com/riasharebook/";
  public static final String TEST_PREV_HOST = "http://wo4.mail.qq.com";
  public static final String USER_AGENT = "Mozilla/5.0(Linux;U;Android QQMail;zh-cn;QQMail) WebKit/553.1(KHTML,like Gecko) Version/4.0";
  public static final String WEWORK_AUTH_URL = "https://mail.qq.com/cgi-bin/readtemplate?check=false&t=rtx_auth";
  
  public static String getCgiRequestHost(int paramInt)
  {
    if (paramInt == 0) {
      return "http://i.mail.qq.com";
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && (localAccount.isBizMail())) {
      return "http://i.exmail.qq.com";
    }
    return "http://i.mail.qq.com";
  }
  
  public static String getCgiRequestHost(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "http://i.exmail.qq.com";
    }
    return "http://i.mail.qq.com";
  }
  
  public static String getCgiRequestHostHttps(int paramInt)
  {
    if (paramInt == 0) {
      return "https://i.mail.qq.com";
    }
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localAccount != null) && (localAccount.isBizMail())) {
      return "https://i.exmail.qq.com";
    }
    return "https://i.mail.qq.com";
  }
  
  public static String getCgiRequestHostHttps(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "https://i.exmail.qq.com";
    }
    return "https://i.mail.qq.com";
  }
  
  public static boolean isContainCgiButDropHost(String paramString1, String paramString2)
  {
    if (!paramString1.contains("/cgi-bin/" + paramString2)) {}
    while ((paramString1.contains("http://i.mail.qq.com")) || (paramString1.contains("http://i.exmail.qq.com"))) {
      return false;
    }
    return true;
  }
  
  public static boolean isContainGroupAttachButDropHost(String paramString)
  {
    return (!paramString.contains("http")) && (paramString.contains("xdisk"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig
 * JD-Core Version:    0.7.0.1
 */