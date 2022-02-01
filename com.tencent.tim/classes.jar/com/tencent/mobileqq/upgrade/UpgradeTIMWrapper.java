package com.tencent.mobileqq.upgrade;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Xml;
import aqas;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import mqq.app.MobileQQ;
import org.xmlpull.v1.XmlPullParser;

public class UpgradeTIMWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<UpgradeTIMWrapper> CREATOR = new aqas();
  public String cja;
  public String cse;
  public String csf;
  public String csl;
  public int dYo;
  public String msgContent;
  public String title;
  public String url;
  
  public UpgradeTIMWrapper() {}
  
  public UpgradeTIMWrapper(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, String paramString7)
  {
    this.title = paramString1;
    this.msgContent = paramString2;
    this.url = paramString3;
    this.cse = paramString4;
    this.csf = paramString5;
    this.dYo = paramInt;
    this.csl = paramString6;
    this.cja = paramString7;
  }
  
  public static String BK()
  {
    Object localObject4;
    Object localObject2;
    try
    {
      Object localObject1 = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
      localObject1 = aqhq.fileToBytes(new File((String)localObject1 + "upgrade_config_tim_info"));
      if ((localObject1 == null) || (localObject1.length <= 0))
      {
        localObject4 = null;
        return localObject4;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        localObject2 = null;
      }
    }
    if (Build.VERSION.SDK_INT <= 8) {
      localObject2 = new String((byte[])localObject2);
    }
    for (;;)
    {
      localObject4 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper load local content:" + (String)localObject2);
      return localObject2;
      try
      {
        localObject2 = new String((byte[])localObject2, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        if (QLog.isDevelopLevel()) {
          localUnsupportedEncodingException.printStackTrace();
        }
        Object localObject3 = null;
      }
    }
  }
  
  public static void Uk(String paramString)
  {
    if ((TextUtils.isEmpty("upgrade_config_tim_info")) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      aqhq.z(new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath(), "upgrade_config_tim_info", paramString);
    } while (!QLog.isColorLevel());
    QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper save upgrade_config_tim to file finish.");
  }
  
  public static UpgradeTIMWrapper a()
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (aBQ())
      {
        String str = BK();
        localObject1 = localObject3;
        if (str != null) {
          localObject1 = a(str);
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public static UpgradeTIMWrapper a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("upgrade_tim_banner_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    UpgradeTIMWrapper localUpgradeTIMWrapper = new UpgradeTIMWrapper();
    localUpgradeTIMWrapper.dYo = paramQQAppInterface.getInt("upgrade_tim_banner_switch", 0);
    localUpgradeTIMWrapper.csl = paramQQAppInterface.getString("upgrade_tim_banner_title", "");
    localUpgradeTIMWrapper.cja = paramQQAppInterface.getString("upgrade_tim_banner_url", "");
    return localUpgradeTIMWrapper;
  }
  
  public static UpgradeTIMWrapper a(String paramString)
  {
    UpgradeTIMWrapper localUpgradeTIMWrapper = new UpgradeTIMWrapper();
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        int i = localXmlPullParser.getEventType();
        if (i != 1)
        {
          if (i == 2)
          {
            paramString = localXmlPullParser.getName();
            if (paramString.equalsIgnoreCase("title")) {
              localUpgradeTIMWrapper.title = localXmlPullParser.nextText();
            }
          }
          else
          {
            i = localXmlPullParser.next();
            continue;
          }
          if (paramString.equalsIgnoreCase("content"))
          {
            localUpgradeTIMWrapper.msgContent = localXmlPullParser.nextText();
            continue;
          }
        }
        else
        {
          return localUpgradeTIMWrapper;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeTIMWrapper", 4, "parseConfig UpgradeTIMWrapper : " + paramString.getMessage());
        }
        paramString.printStackTrace();
      }
      if (paramString.equalsIgnoreCase("downloadPageUrlAndroid"))
      {
        localUpgradeTIMWrapper.url = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("lBtnText"))
      {
        localUpgradeTIMWrapper.cse = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("rBtnText"))
      {
        localUpgradeTIMWrapper.csf = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("tipOn"))
      {
        paramString = localXmlPullParser.nextText();
        try
        {
          localUpgradeTIMWrapper.dYo = Integer.valueOf(paramString).intValue();
        }
        catch (NumberFormatException paramString)
        {
          paramString.printStackTrace();
          QLog.w("UpgradeTIMWrapper", 2, paramString.getMessage());
        }
      }
      else if (paramString.equalsIgnoreCase("tipTitle"))
      {
        localUpgradeTIMWrapper.csl = localXmlPullParser.nextText();
      }
      else if (paramString.equalsIgnoreCase("androidTipURL"))
      {
        localUpgradeTIMWrapper.cja = localXmlPullParser.nextText();
      }
    }
  }
  
  public static boolean aBQ()
  {
    if (TextUtils.isEmpty("upgrade_config_tim_info")) {
      return false;
    }
    String str = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
    return aqhq.fileExists(str + "upgrade_config_tim_info");
  }
  
  public static void c(QQAppInterface paramQQAppInterface, UpgradeTIMWrapper paramUpgradeTIMWrapper)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeTIMWrapper", 2, new Object[] { "save tim tip configs, banner on: ", Integer.valueOf(paramUpgradeTIMWrapper.dYo) });
    }
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("upgrade_tim_banner_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    try
    {
      paramQQAppInterface.putInt("upgrade_tim_banner_switch", paramUpgradeTIMWrapper.dYo);
      paramQQAppInterface.putString("upgrade_tim_banner_title", paramUpgradeTIMWrapper.csl);
      paramQQAppInterface.putString("upgrade_tim_banner_url", paramUpgradeTIMWrapper.cja);
      paramQQAppInterface.commit();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void edh()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper delUpgradeConfig");
      }
      if (aBQ())
      {
        String str = new File(BaseApplicationImpl.getApplication().getFilesDir(), "upgrade_config_tim").getAbsolutePath();
        aqhq.deleteFile(str + "upgrade_config_tim_info");
        if (QLog.isColorLevel()) {
          QLog.i("UpgradeTIMWrapper", 2, "UpgradeTIMWrapper delUpgradeConfig : " + str + "upgrade_config_tim_info");
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean aBP()
  {
    return this.dYo == 1;
  }
  
  public void auT()
  {
    this.dYo = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.msgContent);
    paramParcel.writeString(this.url);
    paramParcel.writeString(this.cse);
    paramParcel.writeString(this.csf);
    paramParcel.writeInt(this.dYo);
    paramParcel.writeString(this.csl);
    paramParcel.writeString(this.cja);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.upgrade.UpgradeTIMWrapper
 * JD-Core Version:    0.7.0.1
 */