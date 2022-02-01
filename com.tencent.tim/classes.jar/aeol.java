import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeol
  extends aehv<aeok>
{
  public static aeok a()
  {
    return (aeok)aeif.a().o(635);
  }
  
  @NonNull
  public aeok a(int paramInt)
  {
    return new aeok();
  }
  
  @Nullable
  public aeok a(aeic[] paramArrayOfaeic)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    aeok localaeok2 = null;
    aeok localaeok1;
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      localaeok2 = aeok.a(paramArrayOfaeic[0].content);
      localaeok1 = localaeok2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
        localaeok1 = localaeok2;
      }
    }
    for (;;)
    {
      paramArrayOfaeic = localaeok1;
      if (localaeok1 == null) {
        paramArrayOfaeic = new aeok();
      }
      return paramArrayOfaeic;
      localaeok1 = localaeok2;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
        localaeok1 = localaeok2;
      }
    }
  }
  
  public void a(aeok paramaeok)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<aeok> clazz()
  {
    return aeok.class;
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
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 635;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeol
 * JD-Core Version:    0.7.0.1
 */