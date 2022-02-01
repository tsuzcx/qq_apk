import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class arnh
  extends aehv<arng>
{
  @NonNull
  public static arng b()
  {
    arng localarng2 = (arng)aeif.a().o(736);
    arng localarng1 = localarng2;
    if (localarng2 == null) {
      localarng1 = arng.a();
    }
    return localarng1;
  }
  
  @NonNull
  public arng a(int paramInt)
  {
    return arng.a();
  }
  
  @Nullable
  public arng a(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExternalDirOperationConfigProcessor", 1, "onParsed:" + paramArrayOfaeic[0].content);
    }
    return arng.a(paramArrayOfaeic[0].content);
  }
  
  public void a(arng paramarng)
  {
    QLog.d("ExternalDirOperationConfigProcessor", 1, "onUpdate:" + paramarng);
    arng.Q(MobileQQ.getContext(), paramarng.dcm);
    arng.R(MobileQQ.getContext(), paramarng.dcn);
    arng.aW(MobileQQ.getContext(), paramarng.eeG);
  }
  
  public Class<arng> clazz()
  {
    return arng.class;
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
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("ExternalDirOperationConfigProcessor", 1, "onReqFailed:" + paramInt);
  }
  
  public int type()
  {
    return 736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arnh
 * JD-Core Version:    0.7.0.1
 */