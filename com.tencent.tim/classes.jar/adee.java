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

public class adee
{
  public static int E(String paramString1, String paramString2)
  {
    int i = -5;
    for (;;)
    {
      try
      {
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + paramString1 + ", soResMd5FromConfig = " + paramString2);
        ader.C("arcloud", "v8.2.0.1", "arcloud", paramString2);
        paramString2 = ader.z("arcloud", "v8.2.0.1", paramString2);
        try
        {
          aden.fn(paramString1, paramString2);
          localObject1 = paramString2 + File.separator + "md5_config.xml";
          localObject2 = new File((String)localObject1);
          if (!((File)localObject2).exists()) {
            break label587;
          }
          new HashMap();
        }
        catch (IOException localIOException)
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          String str;
          i = -6;
          aqhq.delete(paramString2, false);
          paramString2 = new File(paramString1);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = " + -6 + ", soResFilename = " + paramString1);
          continue;
        }
      }
      finally {}
      try
      {
        localObject1 = q(aqhq.readFileToString((File)localObject2));
        if (((HashMap)localObject1).size() <= 0) {
          break label557;
        }
        paramString1 = ((HashMap)localObject1).entrySet().iterator();
        if (!paramString1.hasNext()) {
          break label628;
        }
        localObject2 = (Map.Entry)paramString1.next();
        localObject3 = (String)((Map.Entry)localObject2).getKey();
        localObject1 = paramString2 + File.separator + (String)localObject3 + ".so";
        ader.C("arcloud", "v8.2.0.1", (String)localObject3, (String)((Map.Entry)localObject2).getValue());
        localObject3 = new File((String)localObject1);
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + (String)localObject1);
        if (!((File)localObject3).exists()) {
          break label516;
        }
        str = alab.getFileMD5String((String)localObject1);
        localObject2 = (String)((Map.Entry)localObject2).getValue();
        if (((String)localObject2).equalsIgnoreCase(str)) {
          continue;
        }
        ((File)localObject3).delete();
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = " + -3 + ", filename = " + (String)localObject1 + ", md5FromCalc = " + str + ", md5FromConfig = " + (String)localObject2);
        i = -3;
      }
      catch (IOException paramString2)
      {
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", filename = " + localIOException);
        i = -2;
        continue;
        i = -1;
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = " + -1);
        continue;
      }
      return i;
      label516:
      label557:
      label587:
      QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", configFilename = " + localIOException);
      i = -2;
      continue;
      label628:
      QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. result = " + 0);
      i = 0;
    }
  }
  
  public static boolean adM()
  {
    return new File(ader.z("arcloud", "v8.2.0.1", ader.A("arcloud", "v8.2.0.1", "arcloud")) + File.separator + sk() + ".so").exists();
  }
  
  public static int cF(String paramString)
  {
    try
    {
      int i = ader.c("arcloud", "v8.2.0.1", ader.A("arcloud", "v8.2.0.1", "arcloud"), paramString);
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
        String str = ader.z("arcloud", "v8.2.0.1", ader.A("arcloud", "v8.2.0.1", "arcloud")) + File.separator + paramString + ".so";
        Object localObject = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist soFile=" + str + ", exist=" + ((File)localObject).exists());
        }
        if (((File)localObject).exists())
        {
          paramString = ader.A("arcloud", "v8.2.0.1", paramString);
          localObject = alab.getFileMD5String(str);
          boolean bool2 = paramString.equalsIgnoreCase((String)localObject);
          if (bool2)
          {
            bool1 = true;
            return bool1;
          }
          QLog.i("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist. check md5 failed. soFilename = " + str + ", md5FromConfig = " + paramString + ", md5FromCalc = " + (String)localObject);
          continue;
        }
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist. so not exist. soFilename = " + str);
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
        QLog.e("AREngine_ArCloudNativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + localException.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      break label178;
      str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("libARCloud"))
      {
        localHashMap.put("libARCloud", localXmlPullParser.nextText());
      }
      else if (str.equalsIgnoreCase("libARCloud_64"))
      {
        localHashMap.put("libARCloud_64", localException.nextText());
        label178:
        while (i == 1)
        {
          String str;
          QLog.d("AREngine_ArCloudNativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static String sk()
  {
    return "libARCloud";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adee
 * JD-Core Version:    0.7.0.1
 */