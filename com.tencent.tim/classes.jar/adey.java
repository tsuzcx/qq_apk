import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class adey
{
  public static int E(String paramString1, String paramString2)
  {
    int i = -5;
    for (;;)
    {
      try
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + paramString1 + ", soResMd5FromConfig = " + paramString2);
        ader.C("arsdk2", so(), "arsdk2", paramString2);
        try
        {
          aden.fn(paramString1, ader.z("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2")));
          paramString2 = ader.z("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2")) + File.separator + "md5_config.xml";
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            break label654;
          }
          new HashMap();
        }
        catch (IOException paramString2)
        {
          Object localObject;
          File localFile;
          String str;
          i = -6;
          aqhq.delete(ader.z("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2")), false);
          paramString2 = new File(paramString1);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = " + -6 + ", soResFilename = " + paramString1);
          continue;
        }
      }
      finally {}
      try
      {
        paramString2 = q(aqhq.readFileToString((File)localObject));
        if (paramString2.size() <= 0) {
          break label624;
        }
        paramString2 = paramString2.entrySet().iterator();
        if (!paramString2.hasNext()) {
          break label695;
        }
        localObject = (Map.Entry)paramString2.next();
        paramString1 = "";
        if (((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libAlphaAR"))
        {
          paramString1 = ader.z("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
          ader.C("arsdk2", so(), "libAlphaAR", (String)((Map.Entry)localObject).getValue());
        }
        localFile = new File(paramString1);
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + paramString1);
        if (!localFile.exists()) {
          break label583;
        }
        str = alab.getFileMD5String(paramString1);
        localObject = (String)((Map.Entry)localObject).getValue();
        if (((String)localObject).equalsIgnoreCase(str)) {
          continue;
        }
        localFile.delete();
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = " + -3 + ", filename = " + paramString1 + ", md5FromCalc = " + str + ", md5FromConfig = " + (String)localObject);
        i = -3;
      }
      catch (IOException paramString2)
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", filename = " + paramString1);
        i = -2;
        continue;
        i = -1;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = " + -1);
        continue;
      }
      return i;
      label583:
      label624:
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", configFilename = " + paramString2);
      label654:
      i = -2;
      continue;
      label695:
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. result = " + 0);
      i = 0;
    }
  }
  
  public static boolean adM()
  {
    return new File(ader.z("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2")) + File.separator + "libAlphaAR" + ".so").exists();
  }
  
  public static int cF(String paramString)
  {
    try
    {
      int i = ader.c("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2"), paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static boolean kQ(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        String str = ader.z("arsdk2", so(), ader.A("arsdk2", so(), "arsdk2")) + File.separator + paramString + ".so";
        Object localObject = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist soFile=" + str + ", exist=" + ((File)localObject).exists());
        }
        if (((File)localObject).exists())
        {
          paramString = ader.A("arsdk2", so(), paramString);
          localObject = alab.getFileMD5String(str);
          boolean bool2 = paramString.equalsIgnoreCase((String)localObject);
          if (bool2)
          {
            bool1 = true;
            return bool1;
          }
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist. check md5 failed. soFilename = " + str + ", md5FromConfig = " + paramString + ", md5FromCalc = " + (String)localObject);
          continue;
        }
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist. so not exist. soFilename = " + str);
      }
      finally {}
    }
  }
  
  private static HashMap<String, String> q(String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception localException)
      {
        XmlPullParser localXmlPullParser;
        QLog.e("AREngine_ArSDK2NativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + localException.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      if (localXmlPullParser.getName().equalsIgnoreCase("libAlphaAR"))
      {
        localHashMap.put("libAlphaAR", localXmlPullParser.nextText());
        while (i == 1)
        {
          QLog.d("AREngine_ArSDK2NativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static String so()
  {
    return "v8.2.0.1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adey
 * JD-Core Version:    0.7.0.1
 */