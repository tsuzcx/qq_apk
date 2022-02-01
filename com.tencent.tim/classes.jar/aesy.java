import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aesy
  extends aehv<aesy.a>
{
  @NonNull
  public aesy.a a(int paramInt)
  {
    return new aesy.a();
  }
  
  @Nullable
  public aesy.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      aesy.a locala = aesy.a.b(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.i("UinSearchConfProcessor", 2, "onParsed: " + paramArrayOfaeic[0].content);
      }
      return locala;
    }
    return new aesy.a();
  }
  
  public void a(aesy.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.i("UinSearchConfProcessor", 2, "onUpdate");
    }
  }
  
  public Class<aesy.a> clazz()
  {
    return aesy.a.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
      QLog.i("UinSearchConfProcessor", 2, "onReqFailed: " + paramInt);
    }
  }
  
  public int type()
  {
    return 589;
  }
  
  public static class a
  {
    public static int cOY = 1;
    public static int cOZ = 2;
    public int action = cOZ;
    
    private static a a(String paramString)
    {
      a locala = new a();
      try
      {
        locala.action = new JSONObject(paramString).optInt("action", cOZ);
        return locala;
      }
      catch (Throwable paramString)
      {
        QLog.e("UinSearchConfProcessor", 1, paramString, new Object[0]);
      }
      return locala;
    }
    
    public boolean ahM()
    {
      return this.action == cOY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesy
 * JD-Core Version:    0.7.0.1
 */