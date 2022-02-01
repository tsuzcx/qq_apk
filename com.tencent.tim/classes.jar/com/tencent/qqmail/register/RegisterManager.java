package com.tencent.qqmail.register;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.MailManagerDefines;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.encryptionalgorithm.RsaEncryption;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class RegisterManager
{
  public static final String APPCODE = "app_code";
  public static final String CHECK_PHONE_MATCH = "1";
  public static final String CHECK_PHONE_NOT_MATCH = "0";
  public static final String CHECK_PHONE_UN_BIND = "2";
  private static final String ERRCODE = "errcode";
  public static final String ERRMSG = "errmsg";
  public static final String ERROR_ACTIVITE_FAIL = "-110";
  public static final String ERROR_BIND_FAIL = "-112";
  public static final String ERROR_MOBILE_MAIL_BIND_UIN_AND_UIN_BIND_ANOTHER_MOBILE = "-500";
  public static final String ERROR_MOBILE_QQ_COM_IS_EXIST = "-113";
  public static final String ERROR_OK = "0";
  public static final String MATCH = "match";
  private static final String TAG = "RegisterManager";
  public static final String TITLE = "title";
  
  public static void checkPhoneAndUinRelationship(String paramString1, String paramString2)
  {
    if (StringExtention.isNullOrEmpty(paramString1)) {
      throw new IllegalArgumentException("phone null");
    }
    if (StringExtention.isNullOrEmpty(paramString2)) {
      throw new IllegalArgumentException("uin null");
    }
    Object localObject2 = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (Object localObject1 = QMNetworkConfig.getCgiRequestHostHttps(0);; localObject1 = QMNetworkConfig.getCgiRequestHost(0))
    {
      localObject1 = new QMNetworkRequest((String)localObject1 + "/cgi-bin/" + "check_phone", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      localObject2 = paramString1 + "," + paramString2;
      ((QMNetworkRequest)localObject1).setRequestParams(MailManagerDefines.PARAM_CHECK_PHONE.replace("$info$", RsaEncryption.encryptInBlock((String)localObject2)));
      localObject2 = new QMCallback();
      ((QMCallback)localObject2).setOnSuccess(new RegisterManager.3(paramString1, paramString2));
      ((QMCallback)localObject2).setOnError(new RegisterManager.4(paramString1, paramString2));
      ((QMNetworkRequest)localObject1).setRequestCallback((QMCallback)localObject2);
      QMHttpUtil.asyncSend((QMNetworkRequest)localObject1);
      return;
    }
  }
  
  public static void registerByCGI(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if ((paramString3 == null) || (!paramString3.equals("")))
    {
      localObject = paramString3;
      if (paramString3 != null) {}
    }
    else
    {
      localObject = QMApplicationContext.sharedInstance().getString(2131718694);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (paramString3 = QMNetworkConfig.getCgiRequestHostHttps(0);; paramString3 = QMNetworkConfig.getCgiRequestHost(0))
    {
      paramString3 = new QMNetworkRequest(paramString3 + "/cgi-bin/" + "register", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      paramString3.setRequestParams(MailManagerDefines.PARAM_REGISTER.replace("$uindata$", Aes.encode(paramString2 + "|" + paramString1, Aes.getServerKey())).replace("$nickname$", (CharSequence)localObject).replace("$phonenum$", paramString1));
      localObject = new QMCallback();
      ((QMCallback)localObject).setOnSuccess(new RegisterManager.1(paramString1, paramString2));
      ((QMCallback)localObject).setOnError(new RegisterManager.2(paramString1, paramString2));
      paramString3.setRequestCallback((QMCallback)localObject);
      QMHttpUtil.asyncSend(paramString3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.register.RegisterManager
 * JD-Core Version:    0.7.0.1
 */