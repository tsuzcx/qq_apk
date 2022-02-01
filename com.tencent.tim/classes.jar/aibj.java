import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class aibj
  extends aehv<aibj.a>
{
  @NonNull
  public aibj.a a(int paramInt)
  {
    return new aibj.a();
  }
  
  @Nullable
  public aibj.a a(aeic[] paramArrayOfaeic)
  {
    aibj.a locala = new aibj.a();
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null)) {
      aibj.a.a(locala, paramArrayOfaeic[0].content);
    }
    return locala;
  }
  
  public void a(aibj.a parama) {}
  
  public Class<aibj.a> clazz()
  {
    return aibj.a.class;
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
    return 445;
  }
  
  public static final class a
  {
    public boolean cjJ;
    public boolean cjK = true;
    
    private void parse(String paramString)
    {
      if (!TextUtils.isEmpty(paramString)) {}
      try
      {
        paramString = new JSONObject(paramString);
        this.cjJ = paramString.optBoolean("input_status_gray_switch", false);
        this.cjK = paramString.optBoolean("expand_chat_input_status_switch", true);
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("InputStatusConfig", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibj
 * JD-Core Version:    0.7.0.1
 */