import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class aemv
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
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onParsed, content:" + paramArrayOfaeic);
    }
    return new axvw().a(paramArrayOfaeic, axtd.bl.getAbsolutePath(), "temp_sticker_zip", new aemw(this));
  }
  
  public void a(axvw.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onUpdate");
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
    if (!axtd.aPH()) {
      return 0;
    }
    return aqmj.bn(BaseApplicationImpl.getContext());
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMStickerConfigProcessor", 2, "handleGetQIMPasterConfig onReqFailed");
    }
  }
  
  public int onSend(int paramInt)
  {
    if (!axtd.aPH())
    {
      QLog.i("QIMStickerConfigProcessor", 1, "config file not exist");
      aeif.a().hJ(304, 0);
      return 0;
    }
    return super.onSend(paramInt);
  }
  
  public int type()
  {
    return 304;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aemv
 * JD-Core Version:    0.7.0.1
 */