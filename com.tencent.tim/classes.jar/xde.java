import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.TicketManager;

class xde
  extends ClickableSpan
{
  xde(xci paramxci, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i;
    if (this.val$url.startsWith("mqqapi")) {
      if ((this.val$url.contains("c2c")) && (this.this$0.sessionInfo.cZ == 0))
      {
        paramView = ausj.b(this.this$0.mContext);
        paramView.addButton(2131721238);
        paramView.addCancelButton(2131721058);
        paramView.a(new xdf(this));
        paramView.a(new xdg(this, paramView));
        paramView.show();
        anot.a(this.this$0.app, "CliOper", "", "", "0X8005973", "0X8005973", 0, 0, "", "", "", "");
        i = 1;
      }
    }
    for (;;)
    {
      paramView = this.this$0.app;
      label144:
      Object localObject;
      if (this.this$0.sessionInfo.cZ == 0)
      {
        anot.a(paramView, "CliOper", "", "", "0X800416C", "0X800416C", 0, 0, String.valueOf(j), String.valueOf(2), String.valueOf(i), this.val$taskid);
        return;
        if ((!this.val$url.contains("discussion")) || (this.this$0.sessionInfo.cZ != 3000)) {
          break label519;
        }
        paramView = ausj.b(this.this$0.mContext);
        paramView.addButton(2131721252);
        paramView.addCancelButton(2131721058);
        paramView.a(new xdh(this));
        paramView.a(new xdi(this, paramView));
        paramView.show();
        anot.a(this.this$0.app, "CliOper", "", "", "0X8005975", "0X8005975", 0, 0, "", "", "", "");
        i = 1;
        continue;
        if (!this.val$url.startsWith("http")) {
          break label519;
        }
        paramView = this.val$url;
        if (TextUtils.isEmpty(paramView)) {
          break label516;
        }
        if (paramView.contains("?"))
        {
          localObject = (TicketManager)this.this$0.app.getManager(2);
          paramView = paramView + "&sid=" + ((TicketManager)localObject).getSkey(this.this$0.app.getCurrentAccountUin());
        }
      }
      label516:
      for (;;)
      {
        localObject = new Intent(this.this$0.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("hide_left_button", true);
        ((Intent)localObject).putExtra("show_right_close_button", true);
        ((Intent)localObject).putExtra("finish_animation_up_down", true);
        this.this$0.mContext.startActivity((Intent)localObject);
        i = 2;
        break;
        localObject = (TicketManager)this.this$0.app.getManager(2);
        paramView = paramView + "?sid=" + ((TicketManager)localObject).getSkey(this.this$0.app.getCurrentAccountUin());
        continue;
        j = 2;
        break label144;
      }
      label519:
      i = 1;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14782465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xde
 * JD-Core Version:    0.7.0.1
 */