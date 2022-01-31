package com.tencent.mobileqq.config;

import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class SMSSender
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private SMSSenderListener jdField_a_of_type_ComTencentMobileqqConfigSMSSenderListener = null;
  private String jdField_a_of_type_JavaLangString = "1700";
  private String b = "";
  private String c = "sms://1700";
  
  public SMSSender(SMSSenderListener paramSMSSenderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigSMSSenderListener = paramSMSSenderListener;
  }
  
  private boolean a(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (!Character.isDigit(paramString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject = SmsManager.getDefault();
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, new Intent(), 0);
    if ((!MobileIssueSettings.b) && (KapalaiAdapterUtil.a().a()))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(this.b);
      KapalaiAdapterUtil.a().a(1, this.jdField_a_of_type_JavaLangString, null, (ArrayList)localObject, new ArrayList(), new ArrayList());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqConfigSMSSenderListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqConfigSMSSenderListener.a(2, i);
      }
      return;
      ((SmsManager)localObject).sendTextMessage(this.jdField_a_of_type_JavaLangString, null, this.b, localPendingIntent, null);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.b = null;
    this.c = null;
    this.jdField_a_of_type_ComTencentMobileqqConfigSMSSenderListener = null;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1.length() > 20) || (!a(paramString1))) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    new Thread(this).start();
    return true;
  }
  
  public void run()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.SMSSender
 * JD-Core Version:    0.7.0.1
 */