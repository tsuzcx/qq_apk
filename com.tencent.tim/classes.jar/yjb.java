import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;

class yjb
  implements View.OnClickListener
{
  yjb(yja paramyja, QQOperationViopTipTask paramQQOperationViopTipTask) {}
  
  public void onClick(View paramView)
  {
    if ((yja.a(this.this$0) == null) || (yja.a(this.this$0).get() == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    yih.u(yja.a(this.this$0), yja.a(this.this$0).aTl);
    int i;
    if (this.a.url.startsWith("mqqapi")) {
      if ((this.a.url.contains("c2c")) && (yja.a(this.this$0).cZ == 0))
      {
        ChatActivityUtils.a(yja.a(this.this$0), (Context)yja.a(this.this$0).get(), yja.a(this.this$0).cZ, yja.a(this.this$0).aTl, yja.a(this.this$0).aTn, null, true, yja.a(this.this$0).troopUin, true, true, null, "from_internal");
        i = 1;
      }
    }
    for (;;)
    {
      label167:
      Object localObject1 = yja.a(this.this$0);
      if (yja.a(this.this$0).cZ == 0) {}
      for (int j = 1;; j = 2)
      {
        anot.a((QQAppInterface)localObject1, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(1), String.valueOf(i), String.valueOf(this.a.taskid));
        break;
        if ((!this.a.url.contains("discussion")) || (yja.a(this.this$0).cZ != 3000)) {
          break label576;
        }
        ChatActivityUtils.a(yja.a(this.this$0), (Context)yja.a(this.this$0).get(), yja.a(this.this$0).cZ, yja.a(this.this$0).aTl, true, true, null, null);
        i = 1;
        break label167;
        if (!this.a.url.startsWith("http")) {
          break label571;
        }
        Object localObject2 = this.a.url;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!((String)localObject2).contains("?")) {
            break label505;
          }
          localObject1 = (TicketManager)yja.a(this.this$0).getManager(2);
        }
        for (localObject1 = (String)localObject2 + "&sid=" + ((TicketManager)localObject1).getSkey(yja.a(this.this$0).getCurrentAccountUin());; localObject1 = (String)localObject2 + "?sid=" + ((TicketManager)localObject1).getSkey(yja.a(this.this$0).getCurrentAccountUin()))
        {
          localObject2 = new Intent((Context)yja.a(this.this$0).get(), QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", (String)localObject1);
          ((Intent)localObject2).putExtra("hide_left_button", true);
          ((Intent)localObject2).putExtra("show_right_close_button", true);
          ((Intent)localObject2).putExtra("finish_animation_up_down", true);
          ((Context)yja.a(this.this$0).get()).startActivity((Intent)localObject2);
          i = 2;
          break;
          label505:
          localObject1 = (TicketManager)yja.a(this.this$0).getManager(2);
        }
      }
      label571:
      i = 1;
      continue;
      label576:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yjb
 * JD-Core Version:    0.7.0.1
 */