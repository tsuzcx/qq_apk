package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import eto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class EnterConfigManager
{
  private static EnterConfigManager jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager = null;
  public static final String a = "EnterConfigManager";
  public static final String b = "enter_config_verion_code";
  public static final String c = "enter_config_file";
  private Context jdField_a_of_type_AndroidContentContext;
  public HashMap a;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  public String d;
  
  private EnterConfigManager(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.d = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Boolean = false;
  }
  
  /* Error */
  public static EnterConfigManager a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: ldc 9
    //   11: iconst_2
    //   12: new 50	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   19: ldc 53
    //   21: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   27: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: ldc 62
    //   32: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 70	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   48: ifnonnull +24 -> 72
    //   51: new 2	com/tencent/mobileqq/utils/EnterConfigManager
    //   54: dup
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 72	com/tencent/mobileqq/utils/EnterConfigManager:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   60: putstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   63: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   66: astore_0
    //   67: ldc 2
    //   69: monitorexit
    //   70: aload_0
    //   71: areturn
    //   72: aload_1
    //   73: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   76: getfield 36	com/tencent/mobileqq/utils/EnterConfigManager:d	Ljava/lang/String;
    //   79: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifne -19 -> 63
    //   85: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   88: iconst_0
    //   89: putfield 30	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_Boolean	Z
    //   92: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   95: aload_1
    //   96: putfield 36	com/tencent/mobileqq/utils/EnterConfigManager:d	Ljava/lang/String;
    //   99: getstatic 23	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_ComTencentMobileqqUtilsEnterConfigManager	Lcom/tencent/mobileqq/utils/EnterConfigManager;
    //   102: getfield 41	com/tencent/mobileqq/utils/EnterConfigManager:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   105: invokevirtual 81	java/util/HashMap:clear	()V
    //   108: goto -45 -> 63
    //   111: astore_0
    //   112: ldc 2
    //   114: monitorexit
    //   115: aload_0
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramContext	Context
    //   0	117	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	45	111	finally
    //   45	63	111	finally
    //   63	67	111	finally
    //   72	108	111	finally
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      return false;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(this.jdField_a_of_type_JavaUtilHashMap);
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return FileUtils.a(new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "enter_config_file_" + this.d).getAbsolutePath(), localByteArrayOutputStream.toByteArray(), false);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      this.b = false;
      return;
    }
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "enter_config_file_" + this.d);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      this.b = false;
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localObject = new ByteArrayInputStream(FileUtils.a((File)localObject));
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap = ((HashMap)new ObjectInputStream((InputStream)localObject).readObject());
      this.b = false;
      return;
    }
    catch (StreamCorruptedException localStreamCorruptedException)
    {
      for (;;)
      {
        localStreamCorruptedException.printStackTrace();
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
      }
    }
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    a();
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {}
    do
    {
      return paramInt;
      paramString1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_" + paramString2);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1)));
    try
    {
      paramInt = Integer.parseInt(paramString1);
      return paramInt;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramInt = 0;
      }
    }
  }
  
  public long a(String paramString1, String paramString2, long paramLong)
  {
    a();
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {}
    do
    {
      return paramLong;
      paramString1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_" + paramString2);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1)));
    try
    {
      paramLong = Long.parseLong(paramString1);
      return paramLong;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramLong = 0L;
      }
    }
  }
  
  public String a(String paramString1, String paramString2, String paramString3)
  {
    a();
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {}
    do
    {
      return paramString3;
      paramString1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_" + paramString2);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1)));
    return paramString1;
  }
  
  public void a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (!this.b))
    {
      this.b = true;
      ThreadManager.a().post(new eto(this));
    }
  }
  
  public void a(ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    if (paramRespGetConfig == null) {}
    Object localObject;
    label94:
    do
    {
      do
      {
        return;
      } while ((paramRespGetConfig.result == null) || (paramRespGetConfig.result.get() != 0) || (paramRespGetConfig.config_list == null) || (paramRespGetConfig.config_list.size() <= 0));
      localObject = paramRespGetConfig.config_list.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramRespGetConfig = (ConfigurationService.Config)((Iterator)localObject).next();
      } while ((paramRespGetConfig == null) || (paramRespGetConfig.type == null) || (paramRespGetConfig.type.get() != 13));
      if (paramRespGetConfig == null) {
        break label398;
      }
      if (paramRespGetConfig.version != null) {
        SharedPreUtils.a(this.jdField_a_of_type_AndroidContentContext, paramRespGetConfig.version.get(), this.d);
      }
      if ((paramRespGetConfig.content_list == null) || (paramRespGetConfig.content_list.size() <= 0)) {
        break label390;
      }
      paramRespGetConfig = (String)paramRespGetConfig.content_list.get().get(0);
      if ((paramRespGetConfig != null) && (!TextUtils.isEmpty(paramRespGetConfig))) {
        break;
      }
      paramRespGetConfig = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "enter_config_file_" + this.d);
    } while (!paramRespGetConfig.exists());
    label157:
    paramRespGetConfig.delete();
    return;
    this.jdField_a_of_type_Boolean = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramRespGetConfig.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
        paramRespGetConfig = "";
      }
      catch (XmlPullParserException paramRespGetConfig)
      {
        paramRespGetConfig.printStackTrace();
        a();
        return;
      }
      catch (IOException paramRespGetConfig)
      {
        paramRespGetConfig.printStackTrace();
        continue;
      }
      int i = localXmlPullParser.next();
      paramRespGetConfig = (ConfigurationService.RespGetConfig)localObject;
      if (localXmlPullParser.getDepth() == 2)
      {
        localObject = localXmlPullParser.getName();
      }
      else
      {
        localObject = paramRespGetConfig;
        if (localXmlPullParser.getDepth() == 3)
        {
          localObject = localXmlPullParser.getName();
          localXmlPullParser.next();
          this.jdField_a_of_type_JavaUtilHashMap.put(paramRespGetConfig + "_" + (String)localObject, localXmlPullParser.getText());
          localObject = paramRespGetConfig;
          continue;
          label390:
          paramRespGetConfig = null;
          break label157;
          paramRespGetConfig = null;
          break label94;
          label398:
          break;
          if (i != 1)
          {
            switch (i)
            {
            }
            localObject = paramRespGetConfig;
          }
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a();
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0)) {}
    do
    {
      return paramBoolean;
      paramString1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1 + "_" + paramString2);
    } while ((paramString1 == null) || (TextUtils.isEmpty(paramString1)));
    try
    {
      paramBoolean = Boolean.parseBoolean(paramString1);
      return paramBoolean;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.EnterConfigManager
 * JD-Core Version:    0.7.0.1
 */