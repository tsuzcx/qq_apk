import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class spr
  extends aehv<spq>
{
  @NonNull
  public spq a(int paramInt)
  {
    return new spq();
  }
  
  @Nullable
  public spq a(aeic[] paramArrayOfaeic)
  {
    if ((paramArrayOfaeic != null) && (paramArrayOfaeic.length > 0))
    {
      spq localspq = spq.a(paramArrayOfaeic[0].content);
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onParsed " + paramArrayOfaeic[0].content);
      a(localspq);
      return localspq;
    }
    QLog.e("Q.videostory.config.VSEntranceProcessor", 2, "onParsed conf content is null!");
    return null;
  }
  
  public void a(spq paramspq)
  {
    if (paramspq != null)
    {
      spp.a().m("mine_videostory_entrance", paramspq.nF());
      spp.a().m("enable_click_take_picture", paramspq.nG());
      spp.a().m("mine_videostory_drawer_entrance", paramspq.nH());
      QLog.i("Q.videostory.config.VSEntranceProcessor", 2, "onUpdate:" + paramspq.toString());
    }
  }
  
  public Class<spq> clazz()
  {
    return spq.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
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
    return 411;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     spr
 * JD-Core Version:    0.7.0.1
 */