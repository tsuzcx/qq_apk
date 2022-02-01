import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class aejj
  extends aehv<aejj.a>
{
  @NonNull
  public aejj.a a(int paramInt)
  {
    return new aejj.a();
  }
  
  @Nullable
  public aejj.a a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      paramArrayOfaeic = paramArrayOfaeic[0].content;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfaeic);
      }
      aejj.a locala = aejj.a.a(paramArrayOfaeic);
      if (!TextUtils.isEmpty(paramArrayOfaeic))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfaeic).apply();
        MobileQQ.addBroadcastWhitList(locala.d);
      }
    }
    return new aejj.a();
  }
  
  public void a(aejj.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<aejj.a> clazz()
  {
    return aejj.a.class;
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
    return 567;
  }
  
  public static class a
  {
    public ArraySet<String> d = new ArraySet();
    
    public static a a(String paramString)
    {
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString).getJSONArray("white_list");
        int i = 0;
        while (i < paramString.length())
        {
          locala.d.add(paramString.optString(i, ""));
          i += 1;
        }
        return locala;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BroadcastConfProcessor", 2, paramString, new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejj
 * JD-Core Version:    0.7.0.1
 */