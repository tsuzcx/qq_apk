import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig.a;
import com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig.b;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class aesn
  extends aeqp<SSOErrorInfoMapConfig>
{
  public static SSOErrorInfoMapConfig c()
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig2 = (SSOErrorInfoMapConfig)aeif.a().o(477);
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig1 = localSSOErrorInfoMapConfig2;
    if (localSSOErrorInfoMapConfig2 == null) {
      localSSOErrorInfoMapConfig1 = new SSOErrorInfoMapConfig();
    }
    return localSSOErrorInfoMapConfig1;
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  @NonNull
  public SSOErrorInfoMapConfig a(aeic[] paramArrayOfaeic)
  {
    SSOErrorInfoMapConfig localSSOErrorInfoMapConfig = new SSOErrorInfoMapConfig();
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    for (;;)
    {
      String str1;
      SSOErrorInfoMapConfig.a locala;
      String str2;
      SSOErrorInfoMapConfig.b localb;
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfaeic))
        {
          paramArrayOfaeic = new JSONObject(paramArrayOfaeic);
          Iterator localIterator1 = paramArrayOfaeic.keys();
          if (localIterator1.hasNext())
          {
            str1 = (String)localIterator1.next();
            JSONObject localJSONObject1 = paramArrayOfaeic.optJSONObject(str1);
            Iterator localIterator2 = localJSONObject1.keys();
            locala = new SSOErrorInfoMapConfig.a();
            if (!localIterator2.hasNext()) {
              break label220;
            }
            str2 = (String)localIterator2.next();
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(str2);
            Iterator localIterator3 = localJSONObject2.keys();
            localb = new SSOErrorInfoMapConfig.b();
            if (!localIterator3.hasNext()) {
              break label204;
            }
            String str3 = (String)localIterator3.next();
            String str4 = localJSONObject2.optString(str3);
            localb.kc.put(str3, str4);
            continue;
          }
        }
        return localSSOErrorInfoMapConfig;
      }
      catch (JSONException paramArrayOfaeic)
      {
        ram.e("SSOErrorInfoMapProcessor", "SSOErrorInfoMapConfig onParsed exception :" + paramArrayOfaeic.getMessage());
      }
      label204:
      locala.kb.put(str2, localb);
      continue;
      label220:
      localSSOErrorInfoMapConfig.mErrorMap.put(str1, locala);
    }
  }
  
  @NonNull
  public SSOErrorInfoMapConfig b()
  {
    return new SSOErrorInfoMapConfig();
  }
  
  public Class<SSOErrorInfoMapConfig> clazz()
  {
    return SSOErrorInfoMapConfig.class;
  }
  
  public int type()
  {
    return 477;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesn
 * JD-Core Version:    0.7.0.1
 */