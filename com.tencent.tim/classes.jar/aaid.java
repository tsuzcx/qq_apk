import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aaid
  implements View.OnClickListener
{
  aaid(aahb paramaahb, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (aahb.a(this.this$0) != null)
    {
      localObject1 = aahb.a(this.this$0).obtainMessage(30);
      aahb.a(this.this$0).sendMessageDelayed((Message)localObject1, 2500L);
    }
    Object localObject1 = this.ap.getString("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = Class.forName((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new Intent(aahb.a(this.this$0).getApplicationContext(), (Class)localObject1);
        String str = this.ap.getString("action");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).setAction(str);
        }
        str = this.ap.getString("category");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).addCategory(str);
        }
        str = this.ap.getString("url");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).putExtra("url", str);
        }
        ((Intent)localObject1).setFlags(this.ap.getInt("flags", 0));
        ((Intent)localObject1).putExtra("force_no_reload", true);
        aahb.a(this.this$0).startActivity((Intent)localObject1);
      }
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE3", "0X8009EE3", 4, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaid
 * JD-Core Version:    0.7.0.1
 */