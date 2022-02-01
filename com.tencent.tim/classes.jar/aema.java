import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aema
  extends aehv<aema.a>
{
  @NonNull
  public aema.a a(int paramInt)
  {
    return new aema.a();
  }
  
  @Nullable
  public aema.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0].content;
      if (QLog.isColorLevel()) {
        QLog.d("PicShareToWXConfigProcessor", 2, "onParsed, content:" + paramArrayOfaeic);
      }
      return aema.a.a(paramArrayOfaeic);
    }
    return new aema.a();
  }
  
  public void a(aema.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onUpdate");
    }
  }
  
  public Class clazz()
  {
    return aema.a.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicShareToWXConfigProcessor", 2, "onReqFailed");
    }
  }
  
  public int type()
  {
    return 530;
  }
  
  public static class a
  {
    public long Wz = 10485760L;
    public boolean bVa = false;
    public int cNK = 0;
    public String mDesc = "";
    public boolean mEnable = false;
    public String mPath = "/pages/gallery/gallery?";
    public String mTitle = "分享给你1张图片";
    public String mUserName = "gh_0fc5d8395610";
    
    public static a a(String paramString)
    {
      boolean bool2 = false;
      if (paramString == null)
      {
        paramString = null;
        return paramString;
      }
      a locala = new a();
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          if (localJSONObject.has("picShareToWeChatEnable"))
          {
            if (localJSONObject.getInt("picShareToWeChatEnable") == 1)
            {
              bool1 = true;
              locala.mEnable = bool1;
            }
          }
          else
          {
            if (localJSONObject.has("picShareToWeChatSize")) {
              locala.Wz = localJSONObject.getLong("picShareToWeChatSize");
            }
            if (localJSONObject.has("PicShareToWeChatUserName")) {
              locala.mUserName = localJSONObject.getString("PicShareToWeChatUserName");
            }
            if (localJSONObject.has("PicShareToWeChatPath")) {
              locala.mPath = localJSONObject.getString("PicShareToWeChatPath");
            }
            if (localJSONObject.has("PicShareToWeChatShareTicket"))
            {
              bool1 = bool2;
              if (localJSONObject.getInt("PicShareToWeChatShareTicket") == 1) {
                bool1 = true;
              }
              locala.bVa = bool1;
            }
            if (localJSONObject.has("PicShareToWeChatMiniType")) {
              locala.cNK = localJSONObject.getInt("PicShareToWeChatMiniType");
            }
            if (localJSONObject.has("PicShareToWeChatTitle")) {
              locala.mTitle = localJSONObject.getString("PicShareToWeChatTitle");
            }
            paramString = locala;
            if (!localJSONObject.has("PicShareToWeChatDescription")) {
              break;
            }
            locala.mDesc = localJSONObject.getString("PicShareToWeChatDescription");
            return locala;
          }
        }
        catch (JSONException paramString)
        {
          QLog.e("PicShareToWXConfigProcessor", 1, "parse error.", paramString);
          return locala;
        }
        boolean bool1 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aema
 * JD-Core Version:    0.7.0.1
 */