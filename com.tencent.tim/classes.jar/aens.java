import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aens
  extends aehv<aens.a>
{
  public static aens.a a()
  {
    return (aens.a)aeif.a().o(564);
  }
  
  @NonNull
  public aens.a a(int paramInt)
  {
    return new aens.a();
  }
  
  @Nullable
  public aens.a a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      return null;
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor onParsed, content:" + paramArrayOfaeic);
    }
    return aens.a.a(paramArrayOfaeic);
  }
  
  public void a(aens.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichTitleConfProcessor", 2, "RichTitleConfProcessor update.");
    }
    if (parama != null) {
      amey.dBH = (int)(parama.cv * 60.0D * 60.0D);
    }
  }
  
  public Class<aens.a> clazz()
  {
    return aens.a.class;
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
    return 564;
  }
  
  public static class a
  {
    @aiin("c2c_time_interval")
    public double cv = 72.0D;
    
    public static a a(String paramString)
    {
      return (a)aiio.convertFromJSONObject(paramString, a.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aens
 * JD-Core Version:    0.7.0.1
 */