import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import java.io.File;

public class aemp
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
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onParsed, content:" + paramArrayOfaeic);
    }
    return new axvw().a(paramArrayOfaeic, DynamicTextConfigManager.bp.getAbsolutePath(), "temp_dynamic_text_zip", new aemq(this));
  }
  
  public void a(axvw.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onUpdate");
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
    if (!DynamicTextConfigManager.aPM()) {
      return 0;
    }
    return aqmj.a(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMDynamicTextConfigProcessor", 2, "handleQIMDynamicTextConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!DynamicTextConfigManager.aPM())
    {
      QLog.i("QIMDynamicTextConfigProcessor", 1, "config file not exist");
      aeif.a().hJ(309, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 309;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemp
 * JD-Core Version:    0.7.0.1
 */