import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeew
  extends aehv<aeew.a>
{
  private static boolean bTw;
  
  public static boolean agy()
  {
    aeew.a locala = (aeew.a)aeif.a().o(576);
    if ((locala != null) && (!TextUtils.isEmpty(locala.bwE))) {
      bTw = "1".equals(locala.bwE);
    }
    return bTw;
  }
  
  @NonNull
  public aeew.a a(int paramInt)
  {
    return new aeew.a();
  }
  
  public aeew.a a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("IsDanmuEnable");
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "parse conf, IsDanmuEnable:" + paramString);
      }
      paramString = new aeew.a(paramString.trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aeew.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aeew.a locala = a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("DanmuConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return locala;
    }
    return new aeew.a();
  }
  
  public void a(aeew.a parama)
  {
    if ((parama != null) && (!TextUtils.isEmpty(parama.bwE)))
    {
      bTw = "1".equals(parama.bwE);
      if (QLog.isColorLevel()) {
        QLog.e("DanmuConfProcessor", 2, "onUpdate, isDanmuEnable:" + bTw);
      }
    }
  }
  
  public Class<aeew.a> clazz()
  {
    return aeew.a.class;
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
    return 576;
  }
  
  public static class a
  {
    public String bwE = "";
    
    public a() {}
    
    public a(String paramString)
    {
      this.bwE = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeew
 * JD-Core Version:    0.7.0.1
 */