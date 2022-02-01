import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class aedz
  extends BroadcastReceiver
{
  public aedz(ColorNoteSmallScreenService paramColorNoteSmallScreenService) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getAction();
    paramContext = null;
    for (;;)
    {
      Object localObject;
      try
      {
        String str1 = paramIntent.getStringExtra("process_name");
        localObject = str1;
        paramContext = str1;
        if (QLog.isDevelopLevel())
        {
          paramContext = str1;
          QLog.w("ColorNoteSmallScreenService", 1, "mReceiver action : " + str2 + ", process_name :" + str1);
          localObject = str1;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteSmallScreenService", 1, "action: " + str2, localException);
        localObject = paramContext;
        continue;
        this.this$0.bTc = paramIntent.getBooleanExtra("param_not_in_colornote_list", true);
      }
      try
      {
        if (this.this$0.gi == null) {
          break;
        }
        this.this$0.b().removeCallbacks(this.this$0.gi);
        if (!str2.equals("action_update_cn_smallscreen_state")) {
          break label549;
        }
        i = paramIntent.getIntExtra("param_from", -1);
        if (!QLog.isDevelopLevel()) {
          break label690;
        }
        QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : " + i);
      }
      catch (Throwable paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorNoteSmallScreenService", 2, "mReceiver fail", paramContext);
        return;
      }
      if (i != 0)
      {
        this.this$0.b().removeCallbacks(this.this$0.gi);
        this.this$0.b().postDelayed(this.this$0.gi, 200L);
      }
      return;
      ColorNoteSmallScreenService.mShouldShow = paramIntent.getBooleanExtra("param_shoule_show_smallscreen", true);
      if (QLog.isDevelopLevel())
      {
        QLog.w("ColorNoteSmallScreenService", 1, "mReceiver from : FromType_BusinessLimit mShouldShow = " + ColorNoteSmallScreenService.mShouldShow);
        break label728;
        paramContext = this.this$0.mApp.a().a().ep();
        if ((paramContext != null) && (paramContext.size() != 0))
        {
          this.this$0.cMi = paramContext.size();
          this.this$0.b.jH(paramContext);
          if (aebs.ao(paramContext)) {
            ColorNoteSmallScreenService.a(this.this$0).ciO();
          }
          if (QLog.isColorLevel())
          {
            aebs.fv("ColorNoteSmallScreenService", "[onReceive->FromType_UpdateData]\n[visibleColorNotes]: " + this.this$0.cMi + "\n" + aebs.G(paramContext));
            break label728;
            paramContext = this.this$0.mApp.a().a().ep();
            if ((!aebd.agm()) && (((paramContext.size() == 1) && (aebs.h((ColorNote)paramContext.get(0)))) || (paramContext.size() == 0)))
            {
              this.this$0.cWl();
              break label728;
              boolean bool = paramIntent.getBooleanExtra("param_custom_night_mode", false);
              this.this$0.b.setCustomNightMode(bool);
              aebs.fv("ColorNoteSmallScreenService", "[onReceive->FromType_CustomNightMode]\n[setCustomNightMode]: " + bool);
              break label728;
              label549:
              if ("mqq.intent.action.QQ_BACKGROUND".equals(str2))
              {
                this.this$0.Vp = false;
                this.this$0.bTd = false;
                i = 1;
              }
              else if ("mqq.intent.action.QQ_FOREGROUND".equals(str2))
              {
                if ((localObject == null) || (!((String)localObject).contains("openSdk"))) {
                  break label733;
                }
              }
            }
          }
        }
      }
    }
    label690:
    label728:
    label733:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.this$0.Vp = true;
        this.this$0.bTd = false;
        i = 1;
        break;
      }
      if (this.this$0.mApp.a().a().Cf() > 0)
      {
        this.this$0.bTd = true;
        i = 0;
        break;
      }
      this.this$0.Vp = true;
      this.this$0.bTd = false;
      i = 0;
      break;
      i = 1;
      break;
      switch (i)
      {
      }
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedz
 * JD-Core Version:    0.7.0.1
 */