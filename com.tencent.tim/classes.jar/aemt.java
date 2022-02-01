import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.io.File;

public class aemt
  extends aehv<axvw.b>
{
  @NonNull
  public axvw.b a(int paramInt)
  {
    return new axvw.b();
  }
  
  @Nullable
  public axvw.b a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic == null) || (paramArrayOfaeic.length == 0)) {
      return null;
    }
    paramArrayOfaeic = paramArrayOfaeic[0].content;
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onParsed, content:" + paramArrayOfaeic);
    }
    return new axvw().a(paramArrayOfaeic, QIMMusicConfigManager.bl.getAbsolutePath(), "temp_music_zip", new aemu(this));
  }
  
  public void a(axvw.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onUpdate");
    }
  }
  
  public Class<axvw.b> clazz()
  {
    return axvw.b.class;
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
    if (!QIMMusicConfigManager.aPB()) {
      return 0;
    }
    return aqmj.bm(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMMusicConfigProcessor", 2, "handleGetQIMMusicConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!QIMMusicConfigManager.aPB())
    {
      QLog.i("QIMMusicConfigProcessor", 1, "config file not exist");
      aeif.a().hJ(305, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 305;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemt
 * JD-Core Version:    0.7.0.1
 */