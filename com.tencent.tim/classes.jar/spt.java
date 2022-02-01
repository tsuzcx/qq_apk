import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class spt
  extends aehv<sps>
{
  private void cQ(String paramString1, String paramString2)
  {
    QLog.d("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate() apply new style config");
    if (!TextUtils.isEmpty(paramString2))
    {
      spp.a().m("KEY_BOOLEAN_APPLY_STYLE_CONFIG", Boolean.valueOf(true));
      spp.a().m("KEY_VS_ENTRANCE_STYLE_MD5", paramString1);
      spp.a().m("KEY_VS_ENTRANCE_STYLE_CONTENT", paramString2);
    }
  }
  
  @NonNull
  public sps a(int paramInt)
  {
    return new sps();
  }
  
  @Nullable
  public sps a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      sps localsps = sps.a(paramArrayOfaeic[0].content);
      if (localsps == null)
      {
        QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed error!");
        return null;
      }
      String str = (String)spp.a().getValue("KEY_VS_ENTRANCE_STYLE_MD5", "");
      if ((!TextUtils.isEmpty(localsps.getMd5())) && (!localsps.getMd5().equals(str)))
      {
        sqh.a().b(localsps);
        cQ(localsps.getMd5(), paramArrayOfaeic[0].content);
      }
      return localsps;
    }
    QLog.e("Q.videostory.config.VSEntranceStyleProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(sps paramsps)
  {
    if (paramsps != null) {
      QLog.i("Q.videostory.config.VSEntranceStyleProcessor", 2, "onUpdate:" + paramsps.toString());
    }
  }
  
  public Class<sps> clazz()
  {
    return sps.class;
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
    return 473;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spt
 * JD-Core Version:    0.7.0.1
 */