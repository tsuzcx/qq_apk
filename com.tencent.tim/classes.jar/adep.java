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

public class adep
{
  public static int E(String paramString1, String paramString2)
  {
    int i = -5;
    for (;;)
    {
      try
      {
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + paramString1 + ", soResMd5FromConfig = " + paramString2);
        ader.C("arfeature", "v8.0.0", "arfeature", paramString2);
        try
        {
          aden.fn(paramString1, ader.z("arfeature", "v8.0.0", ader.A("arfeature", "v8.0.0", "arfeature")));
          paramString2 = ader.z("arfeature", "v8.0.0", ader.A("arfeature", "v8.0.0", "arfeature")) + File.separator + "md5_config.xml";
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            break label644;
          }
          new HashMap();
        }
        catch (IOException paramString2)
        {
          Object localObject;
          File localFile;
          String str;
          i = -6;
          aqhq.delete(ader.z("arfeature", "v8.0.0", ader.A("arfeature", "v8.0.0", "arfeature")), false);
          paramString2 = new File(paramString1);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = " + -6 + ", soResFilename = " + paramString1);
          continue;
        }
      }
      finally {}
      try
      {
        paramString2 = q(aqhq.readFileToString((File)localObject));
        if (paramString2.size() <= 0) {
          break label614;
        }
        paramString2 = paramString2.entrySet().iterator();
        if (!paramString2.hasNext()) {
          break label685;
        }
        localObject = (Map.Entry)paramString2.next();
        paramString1 = "";
        if (((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libARFeature"))
        {
          paramString1 = ader.z("arfeature", "v8.0.0", ader.A("arfeature", "v8.0.0", "arfeature")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
          ader.C("arfeature", "v8.0.0", "libARFeature", (String)((Map.Entry)localObject).getValue());
        }
        localFile = new File(paramString1);
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + paramString1);
        if (!localFile.exists()) {
          break label573;
        }
        str = alab.getFileMD5String(paramString1);
        localObject = (String)((Map.Entry)localObject).getValue();
        if (((String)localObject).equalsIgnoreCase(str)) {
          continue;
        }
        localFile.delete();
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = " + -3 + ", filename = " + paramString1 + ", md5FromCalc = " + str + ", md5FromConfig = " + (String)localObject);
        i = -3;
      }
      catch (IOException paramString2)
      {
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
      }
      catch (OutOfMemoryError paramString2)
      {
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", filename = " + paramString1);
        i = -2;
        continue;
        i = -1;
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = " + -1);
        continue;
      }
      return i;
      label573:
      label614:
      QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", configFilename = " + paramString2);
      label644:
      i = -2;
      continue;
      label685:
      QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, "doOnDownloadSuccess. result = " + 0);
      i = 0;
    }
  }
  
  public static boolean adM()
  {
    return new File(ader.z("arfeature", "v8.0.0", ader.A("arfeature", "v8.0.0", "arfeature")) + File.separator + "libARFeature" + ".so").exists();
  }
  
  public static int cF(String paramString)
  {
    try
    {
      int i = ader.c("arfeature", "v8.0.0", ader.A("arfeature", "v8.0.0", "arfeature"), paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
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
        QLog.e("AREngine_ArFeatureSwepNativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + localException.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      if (localXmlPullParser.getName().equalsIgnoreCase("libARFeature"))
      {
        localHashMap.put("libARFeature", localXmlPullParser.nextText());
        while (i == 1)
        {
          QLog.d("AREngine_ArFeatureSwepNativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adep
 * JD-Core Version:    0.7.0.1
 */