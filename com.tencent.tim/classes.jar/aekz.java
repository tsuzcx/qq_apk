import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class aekz
  extends aehv<aeky>
{
  public static boolean ahc()
  {
    aeky localaeky = (aeky)aeif.a().o(640);
    if (localaeky != null) {
      return localaeky.bUT;
    }
    return true;
  }
  
  @NonNull
  public aeky a(int paramInt)
  {
    return new aeky();
  }
  
  @Nullable
  public aeky a(aeic[] paramArrayOfaeic)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onParsed] config");
    Object localObject = null;
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0) && (paramArrayOfaeic[0] != null))
    {
      localaeky = aeky.a(paramArrayOfaeic[0].content);
      localObject = localaeky;
      if (QLog.isColorLevel())
      {
        QLog.d("MultiChannelReportProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
        localObject = localaeky;
      }
    }
    while (!QLog.isColorLevel())
    {
      aeky localaeky;
      return localObject;
    }
    QLog.d("MultiChannelReportProcessor", 2, "onParsed is null");
    return null;
  }
  
  public void a(aeky paramaeky)
  {
    QLog.i("MultiChannelReportProcessor", 1, "[onUpdate]");
  }
  
  public Class<aeky> clazz()
  {
    return aeky.class;
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
    QLog.i("MultiChannelReportProcessor", 1, "[onReqFailed] failCode=" + paramInt);
  }
  
  public int type()
  {
    return 640;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aekz
 * JD-Core Version:    0.7.0.1
 */