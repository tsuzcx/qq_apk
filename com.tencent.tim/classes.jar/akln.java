import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.observer.QZoneObserver.1;
import com.tencent.mobileqq.observer.QZoneObserver.2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class akln
  implements BusinessObserver
{
  protected void E(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void L(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void M(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void N(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void O(boolean paramBoolean, Bundle paramBundle) {}
  
  public void P(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void Q(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void R(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1000)
    {
      boolean bool = paramBundle.getBoolean("new");
      long l = paramBundle.getLong("notify_type", 0L);
      if (QLog.isColorLevel())
      {
        if ((l >>> 17 & 1L) != 0L) {
          QLog.d("ZebraAlbum.UndealCount.QZoneObserver", 2, "onReceive QZONE_GET_UNREAD hasNew: " + bool + "type:" + l + "and then call onGetQZoneFeedCountFin");
        }
        QLog.d("UndealCount.UndealCount.QZoneObserver", 2, "qzone redtypeinfo:onReceive QZONE_GET_UNREAD hasNew: " + bool + ",type:" + l + " and then call onGetQZoneFeedCountFin");
      }
      b(paramBoolean, bool, l);
    }
    do
    {
      return;
      if (paramInt == 1001)
      {
        ThreadManagerV2.executeOnSubThread(new QZoneObserver.1(this, paramBoolean, paramBundle));
        return;
      }
      if (paramInt == 1002)
      {
        E(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1003)
      {
        L(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1004)
      {
        M(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1005)
      {
        N(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1006)
      {
        O(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1007)
      {
        ThreadManagerV2.executeOnSubThread(new QZoneObserver.2(this, paramBoolean, paramBundle));
        return;
      }
      if (paramInt == 1008)
      {
        Q(paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1009)
      {
        R(paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 1010);
    t(paramBoolean, paramBundle);
  }
  
  protected void t(boolean paramBoolean, Bundle paramBundle) {}
  
  public void u(boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akln
 * JD-Core Version:    0.7.0.1
 */