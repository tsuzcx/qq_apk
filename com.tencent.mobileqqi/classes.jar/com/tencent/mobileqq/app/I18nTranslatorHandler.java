package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.rookery.translate.tencent.TranslateRespWrapper;
import com.tencent.i18n.translate.util.Translate.TranslateReq;
import com.tencent.i18n.translate.util.Translate.TranslateResp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import fcy;
import fcz;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class I18nTranslatorHandler
  extends BusinessHandler
{
  I18nTranslatorHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    try
    {
      Object localObject1 = new I18nTranslatorHandler.MyX509TrustManager();
      Object localObject2 = SSLContext.getInstance("SSL");
      SecureRandom localSecureRandom = new SecureRandom();
      ((SSLContext)localObject2).init(null, new TrustManager[] { localObject1 }, localSecureRandom);
      localObject1 = ((SSLContext)localObject2).getSocketFactory();
      paramString = (HttpsURLConnection)new URL(paramString).openConnection();
      paramString.setSSLSocketFactory((SSLSocketFactory)localObject1);
      paramString.setHostnameVerifier(new fcz(this));
      paramString = new BufferedReader(new InputStreamReader(paramString.getInputStream()));
      localObject1 = new StringBuffer();
      for (;;)
      {
        localObject2 = paramString.readLine();
        if (localObject2 == null) {
          break;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[cancel] cancel task" + localException);
        }
        str = null;
      }
      String str = str.toString();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
    return paramString;
  }
  
  private String b(String paramString)
  {
    String str;
    if (paramString.equals("zh_CN")) {
      str = "zh";
    }
    do
    {
      return str;
      if (paramString.equals("zh_TW")) {
        return "zh-TW";
      }
      if (paramString.equals("ja")) {
        return "jp";
      }
      if (paramString.equals("ko")) {
        return "kr";
      }
      str = paramString;
    } while (!paramString.equals("ja"));
    return "jp";
  }
  
  protected Class a()
  {
    return I18nTranslatorObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ("QQiSvc.translate".equals(paramToServiceMsg.getServiceCmd()))
    {
      bool = paramFromServiceMsg.isSuccess();
      paramFromServiceMsg = new TranslateRespWrapper();
      paramFromServiceMsg.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp = new Translate.TranslateResp();
      paramFromServiceMsg.jdField_a_of_type_JavaLangLong = Long.valueOf(paramToServiceMsg.extraData.getLong("request_time"));
    }
    try
    {
      paramFromServiceMsg.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp.mergeFrom((byte[])paramObject);
      a(80001, bool, paramFromServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp = null;
        a(80001, false, paramFromServiceMsg);
        paramToServiceMsg.printStackTrace();
      }
    }
    catch (Exception paramToServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.jdField_a_of_type_ComTencentI18nTranslateUtilTranslate$TranslateResp = null;
        a(80001, false, paramFromServiceMsg);
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, Long paramLong, List paramList, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.a.a(), "QQiSvc.translate");
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      localToServiceMsg.extraData.putLong("request_time", paramLong.longValue());
      Translate.TranslateReq localTranslateReq = new Translate.TranslateReq();
      localTranslateReq.target_language.set(paramString);
      localTranslateReq.array_text.set(paramList);
      localTranslateReq.request_time.set(paramLong.longValue());
      localToServiceMsg.putWupBuffer(localTranslateReq.toByteArray());
      b(localToServiceMsg);
      return;
    }
    new Thread(new fcy(this, paramString, paramLong, paramList)).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.I18nTranslatorHandler
 * JD-Core Version:    0.7.0.1
 */