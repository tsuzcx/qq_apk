import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;

public class ugg
  extends aqkz<ugf>
{
  @NonNull
  public ugf a(int paramInt)
  {
    return new ugf();
  }
  
  @Nullable
  public ugf a(aqlg[] paramArrayOfaqlg)
  {
    if ((paramArrayOfaqlg != null) && (paramArrayOfaqlg.length > 0))
    {
      upe.d("WeSeeConfigProcessor", "onParsed:" + paramArrayOfaqlg[0].a);
      ugf localugf = new ugf();
      localugf.a(paramArrayOfaqlg[0].a);
      if (QLog.isColorLevel()) {
        QLog.d("WeSeeConfigProcessor", 0, "onParsed " + paramArrayOfaqlg[0].a);
      }
      return localugf;
    }
    return null;
  }
  
  public void a(ugf paramugf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WeSeeConfigProcessor", 0, "onUpdate " + paramugf);
    }
  }
  
  public Class<ugf> clazz()
  {
    return ugf.class;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ugg
 * JD-Core Version:    0.7.0.1
 */