import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class axvw
{
  public axvw.b a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip TextUtils.isEmpty(config) return");
      }
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString);
        if (!((JSONObject)localObject).has("pendantMD5")) {
          break label142;
        }
        paramString = ((JSONObject)localObject).getString("pendantMD5");
        if (!((JSONObject)localObject).has("pendantUrl")) {
          break label136;
        }
        str = ((JSONObject)localObject).getString("pendantUrl");
        if (!((JSONObject)localObject).has("pendantName")) {
          break label130;
        }
        localObject = ((JSONObject)localObject).getString("pendantName");
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(str)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.w("ConfigSimplifier_PTV", 2, "zipMd5 or zipUrl empty return!");
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new axvw.b((String)localObject, str, paramString);
      return paramString;
      label130:
      Object localObject = "";
      continue;
      label136:
      String str = "";
      continue;
      label142:
      paramString = "";
    }
  }
  
  public axvw.b a(String paramString1, String paramString2, String paramString3, axvw.a parama)
  {
    axvw.b localb = a(paramString1);
    if (localb == null) {
      paramString1 = null;
    }
    do
    {
      for (;;)
      {
        return paramString1;
        if (QLog.isColorLevel()) {
          QLog.d("ConfigSimplifier_PTV", 2, "parseConfigZip md5=" + localb.cWs + " url=" + localb.cWr + " name=" + localb.cWq);
        }
        try
        {
          paramString1 = paramString2 + File.separator;
          String str = paramString2 + File.separator + localb.cWq;
          File localFile = new File(paramString2, paramString3);
          if (localFile.exists())
          {
            localFile.delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip file.delete()");
            }
          }
          localObject = new File(str);
          if (((File)localObject).exists())
          {
            ((File)localObject).delete();
            if (QLog.isColorLevel()) {
              QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip filejson.delete()");
            }
          }
          localObject = new aoll();
          ((aoll)localObject).f = new axvx(this, paramString2, paramString3, localb, paramString1, str, parama);
          ((aoll)localObject).bZ = localb.cWr;
          ((aoll)localObject).mHttpMethod = 0;
          ((aoll)localObject).atY = localFile.getPath();
          ((aoll)localObject).mContinuErrorLimit = aqiw.kb(aomi.a().getNetType());
        }
        catch (Exception paramString2)
        {
          try
          {
            Object localObject;
            paramString1 = BaseApplicationImpl.getApplication().getRuntime();
            if (QQAppInterface.class.isInstance(paramString1))
            {
              ((QQAppInterface)paramString1).getNetEngine(0).a((aomg)localObject);
              paramString1 = localb;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ConfigSimplifier", 2, "startDownloadFilterConfigZip, url: " + localb.cWr);
              return localb;
            }
            paramString1 = localb;
            if (axol.getAppInterface() == null) {
              continue;
            }
            axol.getAppInterface().getNetEngine(0).a((aomg)localObject);
            return localb;
          }
          catch (Exception paramString1) {}
          paramString2 = paramString2;
          paramString1 = localb;
        }
      }
    } while (!QLog.isColorLevel());
    paramString2.printStackTrace();
    return localb;
    return localb;
  }
  
  public static abstract interface a
  {
    public abstract void Hr(String paramString);
  }
  
  public static class b
  {
    String cWq = "";
    String cWr = "";
    String cWs = "";
    
    public b() {}
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      this.cWq = paramString1;
      this.cWr = paramString2;
      this.cWs = paramString3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axvw
 * JD-Core Version:    0.7.0.1
 */