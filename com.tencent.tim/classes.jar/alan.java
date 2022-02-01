import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.InflaterInputStream;
import org.xmlpull.v1.XmlPullParser;

public class alan
{
  public static void B(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface.getApp().getSharedPreferences("PRECOVER_SP_NAME", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static String G(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return mI(paramString1) + paramString2;
  }
  
  public static boolean V(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (Math.abs(System.currentTimeMillis() - paramContext.getSharedPreferences("PRECOVER_SP_NAME", 0).getLong(paramString, -1L)) > 86400000L) {
      bool = true;
    }
    return bool;
  }
  
  public static String a(ConfigurationService.Content paramContent)
  {
    if (paramContent == null) {
      return null;
    }
    String str = "";
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramContent.compress.get() == 1)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        paramContent = new InflaterInputStream(new ByteArrayInputStream(paramContent.content.get().toByteArray()));
        byte[] arrayOfByte = new byte[256];
        for (;;)
        {
          int i = paramContent.read(arrayOfByte);
          if (-1 == i) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        if (paramContent != null) {
          break label128;
        }
      }
      catch (Throwable paramContent)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("PrecoverUtils", 2, "uncompressConfigContent");
          paramContent.printStackTrace();
        }
        paramContent = null;
      }
      QLog.d("PrecoverUtils", 1, "uncompressConfigContent, uncompress failed");
      paramContent = str;
    }
    for (;;)
    {
      return paramContent;
      paramContent = localByteArrayOutputStream.toByteArray();
      break;
      try
      {
        label128:
        str = new String(paramContent, "UTF-8");
        paramContent = str;
      }
      catch (UnsupportedEncodingException paramContent)
      {
        if (QLog.isColorLevel()) {
          paramContent.printStackTrace();
        }
        QLog.d("PrecoverUtils", 1, "uncompressConfigContent, exception=" + paramContent.getMessage());
        paramContent = null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          localOutOfMemoryError.printStackTrace();
        }
        QLog.d("PrecoverUtils", 1, "uncompressConfigContent, oom=" + localOutOfMemoryError.getMessage());
        System.gc();
        try
        {
          paramContent = new String(paramContent, "UTF-8");
        }
        catch (Throwable paramContent)
        {
          paramContent = null;
        }
      }
      continue;
      paramContent = paramContent.content.get().toStringUtf8();
    }
  }
  
  public static boolean aK(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      paramString1 = G(paramString1, paramString2);
    } while (TextUtils.isEmpty(paramString1));
    return new File(paramString1).exists();
  }
  
  public static void bL(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("PRECOVER_SP_NAME", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  public static int c(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    return paramQQAppInterface.getApp().getSharedPreferences("PRECOVER_SP_NAME", 0).getInt(paramString, paramInt);
  }
  
  public static Pair<alag, List<PrecoverResource>> g(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrecoverUtils", 2, "parseConfig, xmlContent is empty!");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverUtils", 2, "parseConfig, xmlContent=" + paramString);
    }
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
        str = null;
        localObject1 = "";
        paramString = null;
        localObject3 = paramString;
        if (i == 1) {
          continue;
        }
        localObject5 = paramString;
        localObject8 = str;
        localObject7 = localObject1;
        localObject3 = paramString;
        localObject6 = str;
        localObject4 = localObject1;
        switch (i)
        {
        default: 
          localObject7 = localObject1;
          localObject8 = str;
          localObject5 = paramString;
        case 1: 
          label173:
          paramString = (String)localObject8;
          localObject1 = localObject7;
        }
      }
      catch (Exception paramString)
      {
        int i;
        String str;
        Object localObject1;
        Object localObject3;
        Object localObject8;
        Object localObject7;
        Object localObject6;
        Object localObject4;
        Object localObject2 = null;
        continue;
        continue;
        Object localObject5 = paramString;
        paramString = str;
        continue;
      }
      localObject2 = localObject5;
      try
      {
        i = localXmlPullParser.next();
        str = paramString;
        paramString = (String)localObject5;
      }
      catch (Exception paramString) {}
      localObject5 = paramString;
      localObject8 = str;
      localObject7 = localObject1;
      localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        localObject2 = paramString;
        QLog.d("PrecoverUtils", 2, "parseConfig, START_DOCUMENT");
        localObject5 = paramString;
        paramString = str;
      }
    }
    localObject2 = paramString;
    localObject5 = localXmlPullParser.getName();
    localObject2 = paramString;
    if (QLog.isColorLevel())
    {
      localObject2 = paramString;
      QLog.d("PrecoverUtils", 2, "parseConfig, START_TAG, tag=" + (String)localObject5);
    }
    localObject2 = paramString;
    if ("PrecoverInfo".equalsIgnoreCase((String)localObject5))
    {
      localObject4 = localObject5;
      localObject6 = str;
      localObject3 = paramString;
    }
    for (;;)
    {
      localObject5 = localObject3;
      localObject8 = localObject6;
      localObject7 = localObject4;
      localObject2 = localObject3;
      if (!QLog.isColorLevel()) {
        break label173;
      }
      localObject2 = localObject3;
      QLog.d("PrecoverUtils", 2, "parseConfig, START_TAG, tag=" + localXmlPullParser.getName());
      localObject5 = localObject3;
      localObject8 = localObject6;
      localObject7 = localObject4;
      break label173;
      QLog.d("PrecoverUtils", 1, new Object[] { "parseConfig, exception=", paramString.getMessage() });
      localObject3 = localObject2;
      if (QLog.isColorLevel())
      {
        paramString.printStackTrace();
        localObject3 = localObject2;
      }
      if ((localObject3 == null) || (!((alag)localObject3).isValid()) || (localArrayList.size() <= 0)) {
        break;
      }
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (PrecoverResource)paramString.next();
        if (localObject1 != null) {
          ((PrecoverResource)localObject1).businessId = ((alag)localObject3).businessId;
        }
      }
      localObject2 = paramString;
      if ("PrecoverRes".equalsIgnoreCase((String)localObject5))
      {
        localObject4 = localObject5;
        localObject3 = paramString;
        localObject6 = str;
      }
      else
      {
        localObject2 = paramString;
        if ("PrecoverInfo".equalsIgnoreCase((String)localObject1))
        {
          localObject2 = paramString;
          if ("id".equalsIgnoreCase((String)localObject5))
          {
            localObject2 = paramString;
            paramString = new alag();
          }
        }
      }
      try
      {
        paramString.businessId = localXmlPullParser.nextText();
        localObject3 = paramString;
        localObject6 = str;
        localObject4 = localObject1;
      }
      catch (Exception localException)
      {
        localObject2 = paramString;
        paramString = localException;
      }
      localObject3 = paramString;
      localObject6 = str;
      localObject4 = localObject1;
      localObject2 = paramString;
      if ("name".equalsIgnoreCase((String)localObject5)) {
        if (paramString != null)
        {
          localObject2 = paramString;
          paramString.name = localXmlPullParser.nextText();
          localObject3 = paramString;
          localObject6 = str;
          localObject4 = localObject1;
        }
        else
        {
          localObject3 = paramString;
          localObject6 = str;
          localObject4 = localObject1;
          localObject2 = paramString;
          if (QLog.isColorLevel())
          {
            localObject2 = paramString;
            QLog.d("PrecoverUtils", 2, "parseConfig, info == null!");
            localObject3 = paramString;
            localObject6 = str;
            localObject4 = localObject1;
            continue;
            localObject3 = paramString;
            localObject6 = str;
            localObject4 = localObject1;
            localObject2 = paramString;
            if ("PrecoverRes".equalsIgnoreCase((String)localObject1))
            {
              localObject2 = paramString;
              if ("ResId".equalsIgnoreCase((String)localObject5))
              {
                localObject2 = paramString;
                localObject6 = new PrecoverResource();
                localObject2 = paramString;
                ((PrecoverResource)localObject6).resId = localXmlPullParser.nextText();
                localObject3 = paramString;
                localObject4 = localObject1;
              }
              else
              {
                localObject2 = paramString;
                if ("url".equalsIgnoreCase((String)localObject5))
                {
                  if (str != null)
                  {
                    localObject2 = paramString;
                    str.url = localXmlPullParser.nextText();
                    localObject3 = paramString;
                    localObject6 = str;
                    localObject4 = localObject1;
                  }
                  else
                  {
                    localObject3 = paramString;
                    localObject6 = str;
                    localObject4 = localObject1;
                    localObject2 = paramString;
                    if (QLog.isColorLevel())
                    {
                      localObject2 = paramString;
                      QLog.d("PrecoverUtils", 2, "parseConfig, tmpRes == null!");
                      localObject3 = paramString;
                      localObject6 = str;
                      localObject4 = localObject1;
                    }
                  }
                }
                else
                {
                  localObject3 = paramString;
                  localObject6 = str;
                  localObject4 = localObject1;
                  localObject2 = paramString;
                  if ("md5".equalsIgnoreCase((String)localObject5)) {
                    if (str != null)
                    {
                      localObject2 = paramString;
                      str.md5 = localXmlPullParser.nextText();
                      localObject2 = paramString;
                      localArrayList.add(str);
                      localObject3 = paramString;
                      localObject6 = str;
                      localObject4 = localObject1;
                    }
                    else
                    {
                      localObject3 = paramString;
                      localObject6 = str;
                      localObject4 = localObject1;
                      localObject2 = paramString;
                      if (QLog.isColorLevel())
                      {
                        localObject2 = paramString;
                        QLog.d("PrecoverUtils", 2, "parseConfig, tmpRes == null!");
                        localObject3 = paramString;
                        localObject6 = str;
                        localObject4 = localObject1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return new Pair(localObject3, localArrayList);
  }
  
  public static void j(Context paramContext, int paramInt, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("precover_config_version_" + paramString, paramInt);
    paramContext.commit();
  }
  
  public static int k(Context paramContext, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("precover_config_version_" + paramString, 0);
  }
  
  public static String mD(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("http://hb.url.cn/")) {
        return paramString.substring("http://hb.url.cn/".length());
      }
      str = paramString;
    } while (!paramString.startsWith("http://"));
    return paramString.substring("http://".length());
  }
  
  public static String mI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return wi() + File.separator + paramString + File.separator;
  }
  
  public static String wi()
  {
    if (aqfo.isExistSDCard()) {
      return acbn.SDCARD_PATH + "pddata/prd/" + "res_precover";
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "res_precover";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alan
 * JD-Core Version:    0.7.0.1
 */