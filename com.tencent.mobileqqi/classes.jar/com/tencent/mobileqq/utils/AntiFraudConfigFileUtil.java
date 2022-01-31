package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AntiFraudGetConfigHandler;
import com.tencent.mobileqq.app.AntiFraudGetConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hfn;
import hfp;
import hfq;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class AntiFraudConfigFileUtil
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "SecWarningCfg";
  public static final String b = "BannerTTL";
  public static final String c = "BannerURL";
  public static final String d = "BannerWording";
  public static final String e = "AlertTitle";
  public static final String f = "AlertText";
  public static final String g = "AlertLeftBtnText";
  public static final String h = "AlertRightBtnText";
  public static final String i = "Version";
  public static final String j = "LastModifiedTime";
  public static final String k = "EffectTime";
  private static final String l = "UinSafety.WordingConfigFileUtil";
  private static final String m = "SecurityConfig";
  private static final String n = "SubConfig";
  private static final String o = "PublicElement";
  private static final String p = "Element";
  private static final String q = "Type";
  private static final String r = "Value";
  private Bundle jdField_a_of_type_AndroidOsBundle = null;
  private AntiFraudGetConfigObserver jdField_a_of_type_ComTencentMobileqqAppAntiFraudGetConfigObserver = new hfn(this);
  
  public static AntiFraudConfigFileUtil a()
  {
    return hfq.a;
  }
  
  private String a(String paramString)
  {
    return BaseApplication.getContext().getFilesDir().getPath() + "/" + paramString + ".xml";
  }
  
  private void a(Bundle paramBundle, Element paramElement)
  {
    for (paramElement = paramElement.getFirstChild(); paramElement != null; paramElement = paramElement.getNextSibling()) {
      if ((paramElement instanceof Element))
      {
        String str = paramElement.getNodeName();
        Node localNode = paramElement.getFirstChild();
        Object localObject2;
        for (Object localObject1 = ""; localNode != null; localObject1 = localObject2)
        {
          localObject2 = localObject1;
          if ((localNode instanceof Text)) {
            localObject2 = (String)localObject1 + localNode.getNodeValue();
          }
          localNode = localNode.getNextSibling();
        }
        if (QLog.isColorLevel()) {
          QLog.d("UinSafety.WordingConfigFileUtil", 2, "name:" + str + " value:" + (String)localObject1);
        }
        paramBundle.putString(str, (String)localObject1);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UinSafety.WordingConfigFileUtil", 2, "parse config file:" + paramString);
    }
    paramString = a(paramString);
    if (paramString != null) {
      b(paramString);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    new hfp(this, paramString1, paramString3, paramString2).run();
  }
  
  private void b(String paramString)
  {
    Object localObject2 = DocumentBuilderFactory.newInstance();
    try
    {
      Object localObject1 = new File(paramString);
      localObject2 = ((DocumentBuilderFactory)localObject2).newDocumentBuilder().parse((File)localObject1).getDocumentElement();
      paramString = new Bundle();
      Object localObject3 = ((Element)localObject2).getAttribute("Version");
      int i1;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        i1 = 0;
        paramString.putInt("Version", i1);
        localObject2 = ((Element)localObject2).getElementsByTagName("SubConfig");
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= ((NodeList)localObject2).getLength()) {
          break label282;
        }
        localObject3 = (Element)((NodeList)localObject2).item(i1);
        Bundle localBundle1 = new Bundle();
        Object localObject4 = ((Element)localObject3).getElementsByTagName("Element");
        int i2 = 0;
        Object localObject5;
        for (;;)
        {
          if (i2 < ((NodeList)localObject4).getLength())
          {
            localObject5 = (Element)((NodeList)localObject4).item(i2);
            Bundle localBundle2 = new Bundle();
            a(localBundle2, (Element)localObject5);
            localBundle1.putBundle(((Element)localObject5).getAttribute("Value"), localBundle2);
            i2 += 1;
            continue;
            i1 = Integer.parseInt((String)localObject3);
            break;
          }
        }
        localObject4 = ((Element)localObject3).getElementsByTagName("PublicElement");
        if (((NodeList)localObject4).getLength() > 0)
        {
          localObject4 = (Element)((NodeList)localObject4).item(0);
          localObject5 = new Bundle();
          a((Bundle)localObject5, (Element)localObject4);
          localBundle1.putBundle("PublicElement", (Bundle)localObject5);
        }
        paramString.putBundle(((Element)localObject3).getAttribute("Type"), localBundle1);
        i1 += 1;
      }
      label282:
      localObject1 = ((File)localObject1).getName();
      localObject1 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("."));
      this.jdField_a_of_type_AndroidOsBundle.putBundle((String)localObject1, paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UinSafety.WordingConfigFileUtil", 2, "exception occurred." + paramString.getMessage());
      }
      paramString.printStackTrace();
    }
  }
  
  public long a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "LastModifiedTime", 0L);
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_AndroidOsBundle.containsKey(paramString1)) {
      a(paramString1);
    }
    Object localObject = null;
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    paramString1 = localObject;
    if (localBundle != null) {
      paramString1 = localBundle.getString(paramString2);
    }
    return paramString1;
  }
  
  public String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_AndroidOsBundle.containsKey(paramString1)) {
      a(paramString1);
    }
    String str = null;
    Bundle localBundle1 = this.jdField_a_of_type_AndroidOsBundle.getBundle(paramString1);
    paramString1 = str;
    if (localBundle1 != null)
    {
      localBundle1 = localBundle1.getBundle(Integer.toString(paramInt1));
      paramString1 = str;
      if (localBundle1 != null)
      {
        Bundle localBundle2 = localBundle1.getBundle(Integer.toString(paramInt2));
        paramString1 = str;
        if (localBundle2 != null)
        {
          str = localBundle2.getString(paramString2);
          paramString1 = str;
          if (str == null)
          {
            localBundle1 = localBundle1.getBundle("PublicElement");
            paramString1 = str;
            if (localBundle1 != null) {
              paramString1 = localBundle1.getString(paramString2);
            }
          }
        }
      }
    }
    return paramString1;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l1;
    long l2;
    do
    {
      return;
      paramQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppAntiFraudGetConfigObserver);
      l1 = a(paramString);
      l2 = b(paramString);
    } while (System.currentTimeMillis() - l1 < l2 * 1000L);
    ((AntiFraudGetConfigHandler)paramQQAppInterface.a(41)).a(paramString);
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "LastModifiedTime", paramLong);
    localEditor.commit();
  }
  
  public long b(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getLong(paramString + "_" + "EffectTime", 0L);
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    localEditor.putLong(paramString + "_" + "EffectTime", paramLong);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.AntiFraudConfigFileUtil
 * JD-Core Version:    0.7.0.1
 */