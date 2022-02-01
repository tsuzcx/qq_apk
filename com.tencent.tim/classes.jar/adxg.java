import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class adxg
  extends aehv<adxg.a>
{
  @NonNull
  public adxg.a a(int paramInt)
  {
    return new adxg.a();
  }
  
  @Nullable
  public adxg.a a(aeic[] paramArrayOfaeic)
  {
    adxg.a locala = new adxg.a();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      adxg.a.a(locala, paramArrayOfaeic[0].content);
    }
    return locala;
  }
  
  public void a(adxg.a parama) {}
  
  public Class<adxg.a> clazz()
  {
    return adxg.a.class;
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
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 416;
  }
  
  public static class a
  {
    public boolean bRA = false;
    public int cKy = 10000;
    public int cKz = 5000;
    public ArraySet<String> d = new ArraySet();
    private ArraySet<String> e = new ArraySet();
    private ArraySet<String> f = new ArraySet();
    
    private void parse(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TeleScreenConfig", 2, "telescreen config: " + paramString);
      }
      if (TextUtils.isEmpty(paramString))
      {
        this.cKy = 0;
        this.cKz = 0;
        this.bRA = false;
        this.d.clear();
        this.e.clear();
        return;
      }
      for (;;)
      {
        int i;
        try
        {
          paramString = new JSONObject(paramString);
          this.cKy = ((int)(paramString.optDouble("download_timeout") * 1000.0D));
          if (this.cKy <= 0)
          {
            i = 10000;
            this.cKy = i;
            this.cKz = ((int)(paramString.optDouble("jump_timeout") * 1000.0D));
            if (this.cKz <= 0)
            {
              i = 5000;
              this.cKz = i;
              if (paramString.optInt("use_block_mode", 1) != 0) {
                break label385;
              }
              bool = true;
              this.bRA = bool;
              localJSONArray = paramString.optJSONArray("check_white_list");
              this.d.clear();
              if (localJSONArray == null) {
                continue;
              }
              i = localJSONArray.length() - 1;
              if (i < 0) {
                continue;
              }
              if (TextUtils.isEmpty(localJSONArray.getString(i))) {
                break label378;
              }
              this.d.add(localJSONArray.getString(i));
              break label378;
            }
          }
          else
          {
            i = this.cKy;
            continue;
          }
          i = this.cKz;
          continue;
          JSONArray localJSONArray = paramString.optJSONArray("scheme_white_list");
          this.e.clear();
          if (localJSONArray != null)
          {
            i = localJSONArray.length() - 1;
            if (i >= 0)
            {
              if (TextUtils.isEmpty(localJSONArray.getString(i))) {
                break label390;
              }
              this.e.add(localJSONArray.getString(i));
              break label390;
            }
          }
          paramString = paramString.optJSONArray("md5");
          this.f.clear();
          if (paramString == null) {
            break;
          }
          i = paramString.length() - 1;
          if (i < 0) {
            break;
          }
          if (!TextUtils.isEmpty(paramString.getString(i))) {
            this.f.add(new String(Base64.decode(paramString.getString(i), 0)));
          }
          i -= 1;
          continue;
          i -= 1;
        }
        catch (JSONException paramString)
        {
          QLog.e("TeleScreenConfig", 1, paramString, new Object[0]);
          return;
        }
        label378:
        continue;
        label385:
        boolean bool = false;
        continue;
        label390:
        i -= 1;
      }
    }
    
    public boolean aM(String paramString1, String paramString2)
    {
      if (this.d.contains(paramString1)) {
        return true;
      }
      if (paramString2 != null)
      {
        paramString1 = this.e.iterator();
        while (paramString1.hasNext()) {
          if (paramString2.startsWith((String)paramString1.next())) {
            return true;
          }
        }
      }
      return false;
    }
    
    public boolean lk(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        if (paramString.startsWith((String)localIterator.next())) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxg
 * JD-Core Version:    0.7.0.1
 */