import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class oib
  extends aehv<oia>
{
  @NonNull
  public oia a(int paramInt)
  {
    return new oia();
  }
  
  @Nullable
  public oia a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      ooz.e("WeSeeConfigProcessor", "onParsed:" + paramArrayOfaeic[0].content);
      oia localoia = new oia();
      localoia.bj(paramArrayOfaeic[0].content);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfaeic[0].content);
      }
      return localoia;
    }
    return null;
  }
  
  public void a(oia paramoia)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramoia);
    }
  }
  
  public Class<oia> clazz()
  {
    return oia.class;
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
    return 447;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oib
 * JD-Core Version:    0.7.0.1
 */