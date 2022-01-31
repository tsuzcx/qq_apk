package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import protocol.KQQConfig.GetResourceRespInfo;

public class EarlyDataFactory
{
  public static XmlData a(Class paramClass)
  {
    if (paramClass == null) {
      paramClass = null;
    }
    for (;;)
    {
      return paramClass;
      for (;;)
      {
        try
        {
          localXmlData = (XmlData)paramClass.newInstance();
        }
        catch (IllegalAccessException paramClass)
        {
          Object localObject;
          Field[] arrayOfField;
          int j;
          String str;
          Class localClass;
          localXmlData = null;
          continue;
        }
        catch (InstantiationException paramClass)
        {
          int i;
          XmlData localXmlData = null;
          continue;
          i += 1;
          continue;
        }
        try
        {
          localObject = localXmlData.getSharedPreferencesName();
          localObject = BaseApplication.getContext().getSharedPreferences((String)localObject, 0);
          arrayOfField = a(paramClass);
          paramClass = localXmlData;
          if (arrayOfField == null) {
            break;
          }
          j = arrayOfField.length;
          i = 0;
          paramClass = localXmlData;
          if (i >= j) {
            break;
          }
          paramClass = arrayOfField[i];
          if (!paramClass.isAnnotationPresent(saveInSP.class)) {
            continue;
          }
          if (!paramClass.isAccessible()) {
            paramClass.setAccessible(true);
          }
          str = paramClass.getName();
          localClass = paramClass.getType();
          if (localClass == String.class) {
            paramClass.set(localXmlData, ((SharedPreferences)localObject).getString(str, null));
          } else if (localClass == Long.TYPE) {
            paramClass.setLong(localXmlData, ((SharedPreferences)localObject).getLong(str, 0L));
          }
        }
        catch (InstantiationException paramClass)
        {
          paramClass.printStackTrace();
          return localXmlData;
          if (localClass == Integer.TYPE) {
            paramClass.setInt(localXmlData, ((SharedPreferences)localObject).getInt(str, 0));
          }
        }
        catch (IllegalAccessException paramClass)
        {
          paramClass.printStackTrace();
          return localXmlData;
        }
      }
    }
    if (localClass == Float.TYPE) {
      paramClass.setFloat(localXmlData, ((SharedPreferences)localObject).getFloat(str, 0.0F));
    } else if (localClass == Boolean.TYPE) {
      paramClass.setBoolean(localXmlData, ((SharedPreferences)localObject).getBoolean(str, false));
    } else {
      throw new RuntimeException("Member name:" + str + "->Type:" + localClass.toString() + " is NOT SUPPORT!");
    }
  }
  
  public static XmlData a(GetResourceRespInfo paramGetResourceRespInfo, EarlyHandler paramEarlyHandler)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramGetResourceRespInfo == null)
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("EarlyDown", 2, "parse() return null. respInfo == null.");
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return localObject1;
      if (paramGetResourceRespInfo.strResName == null)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("EarlyDown", 2, "parse() return null. respInfo.strResName == null.");
        return null;
      }
      if (paramEarlyHandler == null)
      {
        localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("EarlyDown", 2, "can't find EarlyHandler by pkgName:" + paramGetResourceRespInfo.strPkgName);
        return null;
      }
      try
      {
        paramEarlyHandler = new EarlyXmlParser(paramEarlyHandler.a());
        SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramGetResourceRespInfo.strResConf.getBytes()), paramEarlyHandler);
        paramEarlyHandler = paramEarlyHandler.a();
        localObject1 = paramEarlyHandler;
        if (paramEarlyHandler == null) {
          continue;
        }
        paramEarlyHandler.strResURL_big = paramGetResourceRespInfo.strResURL_big;
        paramEarlyHandler.strResURL_small = paramGetResourceRespInfo.strResURL_small;
        paramEarlyHandler.Version = ((int)paramGetResourceRespInfo.uiNewVer);
        return paramEarlyHandler;
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        for (;;)
        {
          paramEarlyHandler = (EarlyHandler)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("EarlyDown", 2, "parse() throw Exception:" + localParserConfigurationException.getMessage());
            paramEarlyHandler = (EarlyHandler)localObject1;
          }
        }
      }
      catch (SAXException localSAXException)
      {
        for (;;)
        {
          paramEarlyHandler = (EarlyHandler)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("EarlyDown", 2, "parse() throw Exception:" + localSAXException.getMessage());
            paramEarlyHandler = (EarlyHandler)localObject1;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramEarlyHandler = (EarlyHandler)localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("EarlyDown", 2, "parse() throw Exception:" + localIOException.getMessage());
            paramEarlyHandler = (EarlyHandler)localObject1;
          }
        }
      }
    }
  }
  
  /* Error */
  public static Field a(Class paramClass, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload 4
    //   7: astore_2
    //   8: aload_0
    //   9: ifnull +20 -> 29
    //   12: aload 4
    //   14: astore_2
    //   15: aload_1
    //   16: ifnull +13 -> 29
    //   19: aload_1
    //   20: invokevirtual 255	java/lang/String:length	()I
    //   23: ifne +20 -> 43
    //   26: aload 4
    //   28: astore_2
    //   29: aload_2
    //   30: areturn
    //   31: astore_2
    //   32: aload_3
    //   33: astore_2
    //   34: aload_3
    //   35: ifnonnull -6 -> 29
    //   38: aload_0
    //   39: invokevirtual 258	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   42: astore_0
    //   43: aload_3
    //   44: astore_2
    //   45: aload_0
    //   46: ldc_w 260
    //   49: if_acmpeq -20 -> 29
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 264	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   57: astore_2
    //   58: aload_2
    //   59: astore_3
    //   60: goto -28 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramClass	Class
    //   0	63	1	paramString	String
    //   7	23	2	localObject1	Object
    //   31	1	2	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   33	26	2	localObject2	Object
    //   1	59	3	localObject3	Object
    //   3	24	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	58	31	java/lang/NoSuchFieldException
  }
  
  public static void a(XmlData paramXmlData, String... paramVarArgs)
  {
    int j = 0;
    if (paramXmlData == null) {
      return;
    }
    Object localObject1 = paramXmlData.getSharedPreferencesName();
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences((String)localObject1, 0).edit();
    Object localObject3 = paramXmlData.getClass();
    int i;
    label63:
    Object localObject2;
    if ((paramVarArgs == null) || (paramVarArgs.length == 0))
    {
      localObject1 = a((Class)localObject3);
      if (localObject1 != null)
      {
        int k = localObject1.length;
        i = j;
        if (i < k) {
          localObject2 = localObject1[i];
        }
      }
    }
    else
    {
      for (;;)
      {
        try
        {
          if ((((Field)localObject2).isAnnotationPresent(saveInSP.class)) && (((saveInSP)((Field)localObject2).getAnnotation(saveInSP.class)).b()))
          {
            if (!((Field)localObject2).isAccessible()) {
              ((Field)localObject2).setAccessible(true);
            }
            paramVarArgs = ((Field)localObject2).getName();
            localObject3 = ((Field)localObject2).get(paramXmlData);
            if (!(localObject3 instanceof String)) {
              continue;
            }
            localEditor.putString(paramVarArgs, String.valueOf(localObject3));
          }
        }
        catch (IllegalArgumentException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          continue;
          if (!(localObject3 instanceof Integer)) {
            continue;
          }
          localEditor.putInt(paramVarArgs, ((Integer)localObject3).intValue());
          continue;
        }
        catch (IllegalAccessException paramVarArgs)
        {
          paramVarArgs.printStackTrace();
          continue;
          if (!(localObject3 instanceof Float)) {
            continue;
          }
          localEditor.putFloat(paramVarArgs, ((Float)localObject3).floatValue());
          continue;
          if (!(localObject3 instanceof Boolean)) {
            continue;
          }
          localEditor.putBoolean(paramVarArgs, ((Boolean)localObject3).booleanValue());
          continue;
          localObject2 = new StringBuilder().append("Member name:").append(paramVarArgs).append("->Type:");
          if (localObject3 != null) {
            break label400;
          }
        }
        i += 1;
        break label63;
        localObject2 = new Field[paramVarArgs.length];
        i = 0;
        localObject1 = localObject2;
        if (i >= paramVarArgs.length) {
          break;
        }
        localObject1 = paramVarArgs[i];
        if ((localObject1 == null) || (((String)localObject1).length() == 0))
        {
          i += 1;
        }
        else
        {
          localObject2[i] = a((Class)localObject3, (String)localObject1);
          continue;
          if (!(localObject3 instanceof Long)) {
            continue;
          }
          localEditor.putLong(paramVarArgs, ((Long)localObject3).longValue());
        }
      }
      label400:
      for (paramVarArgs = "NULL";; paramVarArgs = localObject3.getClass().getSimpleName().toString()) {
        throw new RuntimeException(paramVarArgs + " is NOT SUPPORT!");
      }
    }
    localEditor.commit();
  }
  
  public static Field[] a(Class paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != Entity.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if (arrayOfField != null)
      {
        j = arrayOfField.length;
        i = 0;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          if ((localField != null) && (!Modifier.isStatic(localField.getModifiers()))) {
            localArrayList.add(localField);
          }
          i += 1;
        }
      }
      paramClass = paramClass.getSuperclass();
    }
    int j = localArrayList.size();
    paramClass = new Field[j];
    int i = 0;
    while (i < j)
    {
      paramClass[i] = ((Field)localArrayList.get(i));
      i += 1;
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDataFactory
 * JD-Core Version:    0.7.0.1
 */