import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class spv
  extends aehv<spu>
{
  private void cQ(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate() apply new widget config");
    if (!TextUtils.isEmpty(paramString2))
    {
      spp.a().m("KEY_BOOLEAN_APPLY_WIDGET_CONFIG", Boolean.valueOf(true));
      spp.a().m("KEY_VS_ENTRANCE_WIDGET_MD5", paramString1);
      spp.a().m("KEY_VS_ENTRANCE_WIDGET_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public spu a(int paramInt)
  {
    return new spu();
  }
  
  @Nullable
  public spu a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      spu localspu = spu.a(paramArrayOfaeic[0].content);
      if (localspu == null)
      {
        QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)spp.a().getValue("KEY_VS_ENTRANCE_WIDGET_MD5", "");
      if ((!TextUtils.isEmpty(localspu.getMd5())) && (!localspu.getMd5().equals(str)))
      {
        sqh.a().b(localspu);
        cQ(localspu.getMd5(), paramArrayOfaeic[0].content);
      }
      return localspu;
    }
    QLog.e("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(spu paramspu)
  {
    if (paramspu != null) {
      QLog.i("Q.videostory.config.VSEntranceWidgetProcessor", 2, "onUpdate:" + paramspu.toString());
    }
  }
  
  public Class<spu> clazz()
  {
    return spu.class;
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
    return 474;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spv
 * JD-Core Version:    0.7.0.1
 */