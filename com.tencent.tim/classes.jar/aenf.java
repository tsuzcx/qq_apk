import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class aenf
  extends aehv<aenf.c>
{
  @NonNull
  public aenf.c a(int paramInt)
  {
    return new aenf.c();
  }
  
  @Nullable
  public aenf.c a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0)) {
      return aenf.c.b(paramArrayOfaeic);
    }
    return null;
  }
  
  public void b(aenf.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSysAndEmojiConfProcessor", 2, "QQSysAndEmojiConfProcessor onUpdate");
    }
    if (paramc != null) {
      aenf.c.c(paramc);
    }
    afkv.a().daa();
  }
  
  public Class<aenf.c> clazz()
  {
    return aenf.c.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 545;
  }
  
  public static class a
  {
    public String bzJ = "";
    public String bzK = "";
    
    public static a a(JSONObject paramJSONObject)
    {
      a locala = new a();
      if (paramJSONObject == null) {}
      do
      {
        do
        {
          return locala;
          paramJSONObject = paramJSONObject.optJSONObject("anim_emoticon_count");
        } while (paramJSONObject == null);
        if (QLog.isColorLevel()) {
          QLog.i("QQSysAndEmojiConfProcessor", 2, "parse AnimCountConfBean: ");
        }
        if (paramJSONObject.has("model")) {
          locala.bzJ = paramJSONObject.optString("model");
        }
      } while (!paramJSONObject.has("version"));
      locala.bzK = paramJSONObject.optString("version");
      return locala;
    }
    
    public String toString()
    {
      return "{mAnimEmoVersion=" + this.bzK + ", mAnimEmoModel=" + this.bzJ + "}";
    }
  }
  
  public static class b
  {
    public String Sw = "";
    public long WC;
    public String bzL = "";
    public int cNT = -1;
    public int cNU = -1;
    public int mHeight;
    public int mOpen;
    public int mVersion;
    public int mWidth;
    
    public static b a(JSONObject paramJSONObject)
    {
      b localb = new b();
      if (paramJSONObject == null) {}
      do
      {
        do
        {
          do
          {
            return localb;
            paramJSONObject = paramJSONObject.optJSONObject("emoticon_guide_config");
          } while (paramJSONObject == null);
          if (QLog.isColorLevel()) {
            QLog.i("QQSysAndEmojiConfProcessor", 2, "parse GuideConfBean: ");
          }
          if (paramJSONObject.has("emoticon_guide_url")) {
            localb.Sw = paramJSONObject.optString("emoticon_guide_url");
          }
          if (paramJSONObject.has("emoticon_guide_night_url")) {
            localb.bzL = paramJSONObject.optString("emoticon_guide_night_url");
          }
          if (paramJSONObject.has("emoticon_guide_serverid")) {
            localb.cNT = paramJSONObject.optInt("emoticon_guide_serverid", -1);
          }
          if (paramJSONObject.has("emoticon_guide_serverid_type")) {
            localb.cNU = paramJSONObject.optInt("emoticon_guide_serverid_type", -1);
          }
          if (paramJSONObject.has("emoticon_guide_width")) {
            localb.mWidth = paramJSONObject.optInt("emoticon_guide_width", 0);
          }
          if (paramJSONObject.has("emoticon_guide_height")) {
            localb.mHeight = paramJSONObject.optInt("emoticon_guide_height", 0);
          }
          if (paramJSONObject.has("emoticon_guide_open")) {
            localb.mOpen = paramJSONObject.optInt("emoticon_guide_open", 0);
          }
          if (paramJSONObject.has("emoticon_guide_version")) {
            localb.mVersion = paramJSONObject.optInt("emoticon_guide_version", 0);
          }
        } while (!paramJSONObject.has("emoticon_guide_invalid_time"));
        paramJSONObject = paramJSONObject.optString("emoticon_guide_invalid_time", null);
      } while (TextUtils.isEmpty(paramJSONObject));
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
      try
      {
        localb.WC = localSimpleDateFormat.parse(paramJSONObject).getTime();
        return localb;
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("QQSysAndEmojiConfProcessor", 2, "parse invalidTime failed!", paramJSONObject);
      }
      return localb;
    }
    
    boolean ahn()
    {
      int i = aqmj.getInt("key_emoticon_guide_version");
      if (this.mVersion > i)
      {
        aqmj.z("key_emoticon_guide_version", Integer.valueOf(this.mVersion));
        aqmj.z("key_show_emoticon_guide", Boolean.valueOf(true));
        return true;
      }
      return false;
    }
    
    public boolean isOpen()
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQSysAndEmojiConfProcessor", 2, "currentTimeMillis: " + System.currentTimeMillis() + " mInvalidTime: " + this.WC);
      }
      return (this.mOpen == 1) && (System.currentTimeMillis() < this.WC);
    }
    
    public String toString()
    {
      return "{mOpen=" + this.mOpen + ", mDrawableUrl='" + this.Sw + '\'' + ", mNightDrawableUrl=" + this.bzL + ", mServerId=" + this.cNT + ", mEmoType=" + this.cNU + ", mInvalidTime=" + this.WC + '}';
    }
  }
  
  public static class c
  {
    public aenf.a a;
    public aenf.b a;
    public String brr = "";
    public String bzM = "";
    public String bzN = "";
    public String bzO = "";
    public String bzP = "";
    public String bzQ = "";
    
    public c()
    {
      this.jdField_a_of_type_Aenf$b = new aenf.b();
      this.jdField_a_of_type_Aenf$a = new aenf.a();
    }
    
    public static c b(aeic[] paramArrayOfaeic)
    {
      c localc = new c();
      int j;
      int i;
      try
      {
        j = paramArrayOfaeic.length;
        i = 0;
      }
      catch (Throwable paramArrayOfaeic)
      {
        boolean bool;
        QLog.d("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean failed!", paramArrayOfaeic);
        return localc;
      }
      Object localObject = ((aeic)localObject).content;
      bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          if (localJSONObject.has("config_url")) {
            localc.brr = localJSONObject.optString("config_url");
          }
          if (localJSONObject.has("config_md5")) {
            localc.bzM = localJSONObject.optString("config_md5");
          }
          if (localJSONObject.has("sysface_res_url")) {
            localc.bzN = localJSONObject.optString("sysface_res_url");
          }
          if (localJSONObject.has("sysface_res_md5")) {
            localc.bzO = localJSONObject.optString("sysface_res_md5");
          }
          if (localJSONObject.has("emoji_res_url")) {
            localc.bzP = localJSONObject.optString("emoji_res_url");
          }
          if (localJSONObject.has("emoji_res_md5")) {
            localc.bzQ = localJSONObject.optString("emoji_res_md5");
          }
          localc.jdField_a_of_type_Aenf$b = aenf.b.a(localJSONObject);
          localc.jdField_a_of_type_Aenf$a = aenf.a.a(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("QQSysAndEmojiConfProcessor", 2, "parse S$EConfBean: " + (String)localObject);
        }
      }
      label283:
      for (;;)
      {
        localc.cXj();
        return localc;
        for (;;)
        {
          if (i >= j) {
            break label283;
          }
          localObject = paramArrayOfaeic[i];
          if (localObject != null) {
            break;
          }
          i += 1;
        }
      }
    }
    
    private void cXj()
    {
      if (this.jdField_a_of_type_Aenf$b.ahn())
      {
        String str = this.jdField_a_of_type_Aenf$b.Sw;
        if (!TextUtils.isEmpty(str)) {
          URLDrawable.getDrawable(str).startDownload(false);
        }
        str = this.jdField_a_of_type_Aenf$b.bzL;
        if (!TextUtils.isEmpty(str)) {
          URLDrawable.getDrawable(str).startDownload(false);
        }
      }
    }
    
    public String toString()
    {
      new StringBuilder().append(", mConfigUrl:").append(this.brr).append(", mConfigMD5:").append(this.bzM).append(", mSysFaceUrl").append(this.bzN).append(", mSysFaceMD5").append(this.bzO).append(", mEmojiUrl").append(this.bzP).append(", mEmojiMD5").append(this.bzQ).append(", mEmoticonGuideConfBean").append(this.jdField_a_of_type_Aenf$b.toString());
      return super.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aenf
 * JD-Core Version:    0.7.0.1
 */