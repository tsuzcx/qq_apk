import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class wut
  extends appa
{
  wut(wur paramwur, QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected void ac(long paramLong, boolean paramBoolean)
  {
    try
    {
      if ((paramLong != Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)) || (wur.a(this.this$0).aSY)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.");
      }
      if (wur.a(this.this$0) == null) {
        return;
      }
      if (wur.a(this.this$0).app == null) {
        return;
      }
      apoy localapoy = wur.a(this.this$0).a(Long.valueOf(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)));
      if (localapoy != null)
      {
        this.this$0.a(localapoy);
        if (localapoy.dU().size() <= 0) {
          return;
        }
        List localList = localapoy.gC();
        if (System.currentTimeMillis() <= localapoy.hy()) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo.getTroopShortcutBarAppIdsRedPoint.");
        }
        wur.a(this.this$0).a(Long.valueOf(paramLong), localList);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarAIOHelper", 1, localException.getMessage());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AppShortcutBarAIOHelper", 2, "onGetAIOShortcutBarInfo. info is null. Will not update UI and redpoint.");
    }
  }
  
  protected void ad(long paramLong, boolean paramBoolean)
  {
    try
    {
      if ((paramLong == Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)) && (!wur.a(this.this$0).aSY))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onGetTroopAppidsRedPoint.");
        }
        apoy localapoy = wur.a(this.this$0).a(Long.valueOf(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)));
        this.this$0.a(localapoy);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarAIOHelper", 1, localException.getMessage());
    }
  }
  
  protected void fZ(long paramLong)
  {
    try
    {
      if ((paramLong == Long.parseLong(wur.a(this.this$0).sessionInfo.aTl)) && (!wur.a(this.this$0).aSY))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated.");
        }
        TroopInfo localTroopInfo = ((TroopManager)wur.a(this.this$0).app.getManager(52)).b(wur.a(this.this$0).sessionInfo.aTl);
        if (localTroopInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. getTroopAIOShortCutBar.");
          }
          wur.a(this.this$0).aV(Long.parseLong(wur.a(this.this$0).sessionInfo.aTl), (int)localTroopInfo.dwGroupClassExt);
          return;
        }
        if (QLog.isColorLevel())
        {
          QLog.e("AppShortcutBarAIOHelper", 2, "onShortcutBarItemUpdated. TroopInfo is null!");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("AppShortcutBarAIOHelper", 1, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wut
 * JD-Core Version:    0.7.0.1
 */