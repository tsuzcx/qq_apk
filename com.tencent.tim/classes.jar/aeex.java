import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aeex
  extends aehv<aeex.a>
{
  private static boolean bTx;
  private static boolean bTy;
  
  public static boolean agA()
  {
    aeex.a locala = (aeex.a)aeif.a().o(579);
    if ((locala != null) && (!TextUtils.isEmpty(locala.bwG))) {
      bTy = "1".equals(locala.bwG);
    }
    return bTy;
  }
  
  public static boolean agz()
  {
    aeex.a locala = (aeex.a)aeif.a().o(579);
    if ((locala != null) && (!TextUtils.isEmpty(locala.bwF))) {
      bTx = "1".equals(locala.bwF);
    }
    return bTx;
  }
  
  @NonNull
  public aeex.a a(int paramInt)
  {
    return new aeex.a();
  }
  
  public aeex.a a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("IsImageImmersiveEnable");
      localObject = ((JSONObject)localObject).optString("IsVideoImmersiveEnable");
      if (QLog.isColorLevel()) {
        QLog.e("ImmersiveConfProcessor", 2, "ImmersiveConfBean, isImgEnable:" + paramString + ", isVdoEnable:" + (String)localObject);
      }
      paramString = new aeex.a(paramString.trim(), ((String)localObject).trim());
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  @Nullable
  public aeex.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aeex.a locala = a(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("ImmersiveConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      }
      return locala;
    }
    return new aeex.a();
  }
  
  public void a(aeex.a parama)
  {
    if (parama != null)
    {
      if (TextUtils.isEmpty(parama.bwF)) {
        bTx = "1".equals(parama.bwF);
      }
      if (TextUtils.isEmpty(parama.bwG)) {
        bTy = "1".equals(parama.bwG);
      }
    }
  }
  
  public Class<aeex.a> clazz()
  {
    return aeex.a.class;
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
    return 579;
  }
  
  public static class a
  {
    public String bwF = "";
    public String bwG = "";
    
    public a() {}
    
    public a(String paramString1, String paramString2)
    {
      this.bwF = paramString1;
      this.bwG = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeex
 * JD-Core Version:    0.7.0.1
 */