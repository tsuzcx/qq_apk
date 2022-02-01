import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aeoj
  extends aehv<aekc>
{
  public static aekc a()
  {
    return (aekc)aeif.a().o(633);
  }
  
  @NonNull
  public aekc a(int paramInt)
  {
    return new aekc();
  }
  
  @Nullable
  public aekc a(aeic[] paramArrayOfaeic)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      localaekc = aekc.a(paramArrayOfaeic[0].content);
      localObject = localaekc;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
        localObject = localaekc;
      }
    }
    while (!QLog.isColorLevel())
    {
      aekc localaekc;
      return localObject;
    }
    QLog.d("TroopFoldMsgConfProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(aekc paramaekc)
  {
    QLog.i("TroopFoldMsgConfProcessor", 1, "[onUpdate]");
  }
  
  public Class<aekc> clazz()
  {
    return aekc.class;
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
    return 633;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeoj
 * JD-Core Version:    0.7.0.1
 */