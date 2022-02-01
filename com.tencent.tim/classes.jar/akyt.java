import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class akyt
  extends aehv<akyt.b>
{
  abstract int Hn();
  
  @NonNull
  public akyt.b a(int paramInt)
  {
    return new akyt.b();
  }
  
  @Nullable
  public akyt.b a(aeic[] paramArrayOfaeic)
  {
    akyt.b localb = new akyt.b();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      akyt.b.a(localb, paramArrayOfaeic[0].content);
    }
    return localb;
  }
  
  public void a(akyt.b paramb) {}
  
  public Class<akyt.b> clazz()
  {
    return akyt.b.class;
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
    return Hn();
  }
  
  public static final class a
    extends akyt
  {
    protected int Hn()
    {
      return 496;
    }
  }
  
  public static final class b
  {
    public final List<akyu> items = new ArrayList();
    
    private void parse(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("c2c");
          if (paramString.length() > 0)
          {
            int j = paramString.length();
            int i = 0;
            while (i < j)
            {
              akyu localakyu = new akyu();
              JSONObject localJSONObject = paramString.getJSONObject(i);
              localakyu.id = localJSONObject.optInt("appid");
              localakyu.contentDescription = localJSONObject.optString("title");
              localakyu.nV = localJSONObject.optString("iconNormal");
              localakyu.iconPress = localJSONObject.optString("iconPress");
              localakyu.bUQ = localJSONObject.optString("iconNightNormal");
              localakyu.bUR = localJSONObject.optString("iconNightPress");
              localakyu.dqk = localJSONObject.optInt("redDotID");
              localakyu.bUP = localJSONObject.optString("redDotPath");
              localakyu.actionType = localJSONObject.optString("actionType");
              localakyu.action = localJSONObject.optString("action");
              localakyu.order = localJSONObject.optInt("order");
              localakyu.aM();
              localakyu.aN();
              this.items.add(localakyu);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramString)
        {
          QLog.e("AIOPanelIconConfigProcessor", 1, paramString, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyt
 * JD-Core Version:    0.7.0.1
 */