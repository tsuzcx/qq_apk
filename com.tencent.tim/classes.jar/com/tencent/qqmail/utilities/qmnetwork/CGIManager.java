package com.tencent.qqmail.utilities.qmnetwork;

import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.cookie.Cookie;
import org.apache.http.message.BasicNameValuePair;
import rx.Observable;

public class CGIManager
{
  public static final String APP_CODE = "app_code";
  public static final String APP_NAME = "app_name";
  public static final String CGI_EXCEPTION = "cgi exception";
  public static final String ERROR_MSG = "errmsg";
  private static final String TAG = "CGIManager";
  
  private static QMCGIError cgiError(int paramInt, String paramString1, String paramString2, String paramString3, QMNetworkResponse paramQMNetworkResponse)
  {
    return new QMCGIError(paramInt, 0, paramString1, paramString1, paramString2, paramString3, paramQMNetworkResponse);
  }
  
  public static String clearSid(String paramString)
  {
    return paramString.replaceAll("sid=.*?($|&)", "");
  }
  
  private static String getURL(String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localObject1 == null) || (!((Account)localObject1).isQQMail())) {
      return paramString;
    }
    Object localObject2 = ((QQMailAccount)localObject1).getSid();
    if (paramString.contains("sid="))
    {
      paramString = paramString.split("\\?");
      String str = paramString[0];
      Object localObject3 = StringExtention.parseParams(paramString[(paramString.length - 1)], "&");
      localObject1 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)((Iterator)localObject3).next();
        if (localNameValuePair.getName().equals("sid"))
        {
          if (paramBoolean) {
            ((ArrayList)localObject1).add(new BasicNameValuePair("sid", (String)localObject2));
          } else {
            ((ArrayList)localObject1).add(localNameValuePair);
          }
        }
        else {
          ((ArrayList)localObject1).add(localNameValuePair);
        }
      }
      localObject2 = new StringBuilder();
      if (paramString.length == 1) {}
      for (paramString = "";; paramString = str + "?") {
        return paramString + StringExtention.paramsString((List)localObject1);
      }
    }
    return paramString + "&sid=" + (String)localObject2;
  }
  
  public static QMNetworkRequest httpGet(int paramInt, String paramString1, String paramString2, QMCallback paramQMCallback)
  {
    return httpGet(paramInt, paramString1, paramString2, false, paramQMCallback);
  }
  
  public static QMNetworkRequest httpGet(int paramInt, String paramString1, String paramString2, boolean paramBoolean, QMCallback paramQMCallback)
  {
    char c = '?';
    ValidateHelper.notNullAndNotEmpty(paramString1);
    Object localObject = paramString1;
    if (paramString2 != null)
    {
      localObject = paramString1;
      if (paramString2.length() > 0)
      {
        localObject = new StringBuilder().append(paramString1);
        if (paramString1.indexOf('?') > 0) {
          c = '&';
        }
        localObject = c + paramString2;
      }
    }
    paramString2 = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (paramString1 = QMNetworkConfig.getCgiRequestHostHttps(paramInt);; paramString1 = QMNetworkConfig.getCgiRequestHost(paramInt))
    {
      paramString1 = new CGIRequest(paramInt, paramString1 + "/cgi-bin/" + (String)localObject, false, paramBoolean);
      paramString1.setRequestCallback(paramQMCallback);
      NetworkManager.sharedInstance().sendRequest(paramString1);
      return paramString1;
    }
  }
  
  public static Observable<QMNetworkResponse> httpGet(int paramInt, String paramString1, String paramString2)
  {
    return Observable.create(new CGIManager.3(paramInt, paramString1, paramString2));
  }
  
  public static QMNetworkRequest httpGetExcludeHttps(int paramInt, String paramString1, String paramString2, QMCallback paramQMCallback)
  {
    char c = '?';
    ValidateHelper.notNullAndNotEmpty(paramString1);
    Object localObject = paramString1;
    if (paramString2 != null)
    {
      localObject = paramString1;
      if (paramString2.length() > 0)
      {
        localObject = new StringBuilder().append(paramString1);
        if (paramString1.indexOf('?') > 0) {
          c = '&';
        }
        localObject = c + paramString2;
      }
    }
    paramString1 = new CGIRequest(paramInt, QMNetworkConfig.getCgiRequestHost(paramInt) + "/cgi-bin/" + (String)localObject);
    paramString1.setRequestCallback(paramQMCallback);
    NetworkManager.sharedInstance().sendRequest(paramString1);
    return paramString1;
  }
  
  public static QMNetworkRequest httpMultiPost(int paramInt, String paramString1, String paramString2, List<QMFileEntity> paramList, QMCallback paramQMCallback)
  {
    ValidateHelper.notNullAndNotEmpty(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (String str = QMNetworkConfig.getCgiRequestHostHttps(paramInt);; str = QMNetworkConfig.getCgiRequestHost(paramInt))
    {
      paramString1 = new CGIRequest(paramInt, str + "/cgi-bin/" + paramString1, QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART);
      paramString1.setRequestParams(paramString2);
      paramString1.setFileParams(paramList);
      paramString1.setRequestCallback(paramQMCallback);
      NetworkManager.sharedInstance().sendRequest(paramString1);
      return paramString1;
    }
  }
  
  public static QMNetworkRequest httpPost(int paramInt, String paramString1, String paramString2, QMCallback paramQMCallback)
  {
    return httpPost(paramInt, paramString1, paramString2, null, paramQMCallback);
  }
  
  public static QMNetworkRequest httpPost(int paramInt, String paramString1, String paramString2, ArrayList<Cookie> paramArrayList, QMCallback paramQMCallback)
  {
    ValidateHelper.notNullAndNotEmpty(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (String str = QMNetworkConfig.getCgiRequestHostHttps(paramInt);; str = QMNetworkConfig.getCgiRequestHost(paramInt))
    {
      paramString1 = new CGIRequest(paramInt, str + "/cgi-bin/" + paramString1, QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
      paramString1.setRequestCookies(paramArrayList);
      paramString1.setRequestParams(paramString2);
      paramString1.setRequestCallback(paramQMCallback);
      NetworkManager.sharedInstance().sendRequest(paramString1);
      return paramString1;
    }
  }
  
  private static QMCGIError jsonError(String paramString1, String paramString2, QMNetworkResponse paramQMNetworkResponse)
  {
    return new QMCGIError(0, 0, "数据格式错误", "", paramString1, paramString2, paramQMNetworkResponse);
  }
  
  private static QMCGIError parseError(QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    Object localObject6 = null;
    if ((paramQMNetworkResponse.getResponseType() != QMNetworkResponse.QMResponseType.QMResponseType_TEXT) || (!paramQMNetworkRequest.isSuggestParseResponseToJson())) {}
    for (;;)
    {
      return null;
      Object localObject1 = "";
      Object localObject3 = localObject1;
      if ((paramQMNetworkRequest instanceof CGIRequest))
      {
        localObject2 = (CGIRequest)paramQMNetworkRequest;
        localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(((CGIRequest)localObject2).accountId);
        localObject3 = localObject1;
        if (localObject2 != null) {
          localObject3 = ((Account)localObject2).getUin();
        }
      }
      Object localObject2 = paramQMNetworkResponse.getResponseString();
      if ((localObject2 == null) || (((String)localObject2).length() == 0))
      {
        QMLog.log(5, "CGIManager", "responseText empty");
        localObject1 = "";
        if (paramQMNetworkRequest.getRequestUrlString() != null) {
          localObject1 = CommonMatch.findCgiName(paramQMNetworkRequest.getRequestUrlString());
        }
        return jsonError((String)localObject1, (String)localObject3, paramQMNetworkResponse);
      }
      localObject1 = JSONReader.parse((String)localObject2);
      paramQMNetworkResponse.setResponseJson(localObject1);
      Object localObject4 = localObject1;
      Object localObject5 = localObject2;
      if (localObject1 == null)
      {
        QMLog.log(5, "CGIManager", "json error: " + (String)localObject2);
        localObject4 = Pattern.compile("\\{(.|\\r|\\n)*\\}").matcher((CharSequence)localObject2);
        if (((Matcher)localObject4).find())
        {
          localObject2 = ((Matcher)localObject4).group();
          localObject1 = JSONReader.parse((String)localObject2);
          paramQMNetworkResponse.setResponseJson(localObject1);
          QMLog.log(4, "CGIManager", "json match:" + (String)localObject2);
        }
        localObject4 = localObject1;
        localObject5 = localObject2;
        if (localObject1 == null)
        {
          QMLog.log(5, "CGIManager", "json still error: " + (String)localObject2);
          localObject1 = "";
          if (paramQMNetworkRequest.getRequestUrlString() != null) {
            localObject1 = CommonMatch.findCgiName(paramQMNetworkRequest.getRequestUrlString());
          }
          return jsonError((String)localObject1, (String)localObject3, paramQMNetworkResponse);
        }
      }
      if (((String)localObject5).contains("cgi exception"))
      {
        localObject5 = (JSONObject)localObject4;
        localObject1 = (String)((JSONObject)localObject5).get("app_code");
        localObject4 = ((JSONObject)localObject5).get("app_name");
        if ((localObject1 != null) && (((String)localObject1).matches("^(-)?[1-9]\\d*$"))) {}
        for (int i = Integer.parseInt((String)localObject1); i != 0; i = 0)
        {
          localObject2 = "";
          localObject1 = localObject2;
          if (paramQMNetworkRequest != null)
          {
            localObject1 = localObject2;
            if (paramQMNetworkRequest.getRequestUrlString() != null) {
              localObject1 = CommonMatch.findCgiName(paramQMNetworkRequest.getRequestUrlString());
            }
          }
          if ((localObject4 != null) && ("compose_send".equals(localObject4)))
          {
            if (i != QMSendMailCGIError.CGIERROR_SEND_MAIL_NEED_VERIFY) {
              break label611;
            }
            localObject2 = (String)((JSONObject)localObject5).get("verifymailid");
          }
          for (localObject4 = (String)((JSONObject)localObject5).get("verifykey");; localObject4 = localObject6)
          {
            paramQMNetworkResponse = sendMailCgiError(i, (String)((JSONObject)localObject5).get("errmsg"), (String)localObject1, (String)localObject3, paramQMNetworkResponse, (String)localObject2, (String)localObject4);
            if (paramQMNetworkResponse.isSessionTimeouted()) {
              QMLog.log(6, "CGIManager", "session time out");
            }
            for (;;)
            {
              QMLog.log(5, "CGIManager", "errcode: " + i);
              return paramQMNetworkResponse;
              paramQMNetworkResponse = cgiError(i, (String)((JSONObject)localObject5).get("errmsg"), (String)localObject1, (String)localObject3, paramQMNetworkResponse);
              break;
              if ((paramQMNetworkResponse.code == 1) || (paramQMNetworkResponse.code == 7)) {
                PasswordErrHandler.saveStateAndShowErr(((CGIRequest)paramQMNetworkRequest).accountId, -1);
              } else if (paramQMNetworkResponse.code == 6) {
                PasswordErrHandler.saveStateAndShowErr(((CGIRequest)paramQMNetworkRequest).accountId, -2);
              } else if (paramQMNetworkResponse.code == 4) {
                PasswordErrHandler.saveStateAndShowErr(((CGIRequest)paramQMNetworkRequest).accountId, -3);
              }
            }
            label611:
            localObject2 = null;
          }
        }
      }
    }
  }
  
  public static String removeSid(String paramString)
  {
    return getURL(paramString, false, -1);
  }
  
  private static QMSendMailCGIError sendMailCgiError(int paramInt, String paramString1, String paramString2, String paramString3, QMNetworkResponse paramQMNetworkResponse, String paramString4, String paramString5)
  {
    return new QMSendMailCGIError(paramInt, 0, paramString1, paramString1, paramString2, paramString3, paramQMNetworkResponse, paramString4, paramString5);
  }
  
  public static QMCallback wrapCGICallback(QMCallback paramQMCallback)
  {
    ValidateHelper.notNull(paramQMCallback);
    QMCallback localQMCallback = new QMCallback(paramQMCallback);
    localQMCallback.setOnSuccess(new CGIManager.1(paramQMCallback));
    localQMCallback.setOnError(new CGIManager.2(paramQMCallback));
    return localQMCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.CGIManager
 * JD-Core Version:    0.7.0.1
 */