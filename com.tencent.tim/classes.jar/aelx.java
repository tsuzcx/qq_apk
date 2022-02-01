import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class aelx
  extends aehv<aelw>
{
  @NonNull
  public aelw a(int paramInt)
  {
    return new aelw();
  }
  
  public void a(aelw paramaelw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onUpdate " + paramaelw.toString());
    }
    SafeBitmapFactory.setNeedRegionDecode(paramaelw.needRegionDecode);
    SafeBitmapFactory.setPxThreshoidToSp(paramaelw.pxThreshold);
    SafeBitmapFactory.setRamThreshoidToSp(paramaelw.ramThreshold);
    SafeBitmapFactory.setThreadCountToSp(paramaelw.bvF);
    aopb.lH(paramaelw.Wk);
    aopb.lI(paramaelw.Wl);
    aooz.Sv(paramaelw.cNJ);
  }
  
  @Nullable
  public aelw b(aeic[] paramArrayOfaeic)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onParsed " + paramArrayOfaeic.length);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfaeic != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaeic.length > 0) {
        localObject1 = aelw.a(paramArrayOfaeic);
      }
    }
    return localObject1;
  }
  
  public Class<aelw> clazz()
  {
    return aelw.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PicCommonConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 251;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aelx
 * JD-Core Version:    0.7.0.1
 */