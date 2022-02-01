import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class kdc
  implements aehx<String>
{
  private String Yb = "";
  private String Yc = "";
  private String Yd = "";
  private boolean adR;
  private boolean oA;
  
  public static kdc a()
  {
    kdc localkdc = new kdc();
    localkdc.Yb = obt.Yb;
    localkdc.Yc = obt.Yc;
    localkdc.Yd = obt.Yd;
    localkdc.adR = obt.adR;
    return localkdc;
  }
  
  private kdc a(kdc paramkdc, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return this;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("pacenter_url")) {
          this.Yb = paramkdc.Yb;
        }
        if (paramString.has("pacategory_url")) {
          this.Yc = paramkdc.Yc;
        }
        if (paramString.has("readinjoy_search_url")) {
          this.Yd = paramkdc.Yd;
        }
        if (paramString.has("image_collection_comment")) {
          this.adR = paramkdc.adR;
        }
        if (paramkdc.oA)
        {
          this.oA = true;
          return this;
        }
      }
      catch (Exception paramkdc)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramkdc);
        }
        paramkdc.printStackTrace();
      }
    }
    return this;
  }
  
  public static kdc a(aeic[] paramArrayOfaeic)
  {
    Object localObject = new kdc();
    int i = 0;
    String str;
    for (;;)
    {
      if (i >= paramArrayOfaeic.length) {
        return localObject;
      }
      str = paramArrayOfaeic[i].content;
      try
      {
        kdc localkdc = ((kdc)localObject).a((kdc)aeij.a(str, kdc.class), str);
        localObject = localkdc;
      }
      catch (QStorageInstantiateException localQStorageInstantiateException)
      {
        for (;;)
        {
          QLog.i("PublicAccountCenterUrlConfProcessor", 1, "loadConfig l :" + str, localQStorageInstantiateException);
        }
      }
      i += 1;
    }
    return localObject;
  }
  
  public void aBF()
  {
    obt.Yb = this.Yb;
    obt.Yc = this.Yc;
    obt.Yd = this.Yd;
    obt.adR = this.adR;
  }
  
  public void aBG()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      obt.aA((QQAppInterface)localAppRuntime);
    }
  }
  
  public void lR(String paramString)
  {
    boolean bool3 = true;
    for (;;)
    {
      boolean bool2;
      try
      {
        paramString = new JSONObject(paramString);
        String str1 = paramString.getString("pacenter_url");
        String str2 = paramString.getString("pacategory_url");
        if (!obt.et(str1)) {
          break label156;
        }
        this.Yb = str1;
        bool1 = true;
        if (obt.et(str2))
        {
          this.Yc = str2;
          bool1 = true;
        }
        bool2 = bool1;
        if (paramString.has("readinjoy_search_url"))
        {
          str1 = paramString.getString("readinjoy_search_url");
          bool2 = bool1;
          if (obt.et(str1))
          {
            this.Yd = str1;
            bool2 = true;
          }
        }
        if (paramString.has("image_collection_comment"))
        {
          this.adR = paramString.getBoolean("image_collection_comment");
          bool1 = bool3;
          this.oA = bool1;
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PublicAccountCenterUrlConfProcessor", 2, "checkPublicAccountCenterUrlConfigData error", paramString);
        }
        paramString.printStackTrace();
        this.oA = false;
        return;
      }
      boolean bool1 = bool2;
      continue;
      label156:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kdc
 * JD-Core Version:    0.7.0.1
 */