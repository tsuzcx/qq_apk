import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aahz
  implements View.OnClickListener
{
  aahz(aahb paramaahb, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    if (aahb.a(this.this$0) != null)
    {
      localObject1 = aahb.a(this.this$0).obtainMessage(1134042);
      aahb.a(this.this$0).sendMessage((Message)localObject1);
    }
    Object localObject1 = (String)this.ap.getCharSequence("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    try
    {
      localObject1 = Class.forName((String)localObject1);
      if (localObject1 != null)
      {
        localObject1 = new Intent(aahb.a(this.this$0).getApplicationContext(), (Class)localObject1);
        String str = (String)this.ap.getCharSequence("action");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).setAction(str);
        }
        str = (String)this.ap.getCharSequence("category");
        if (!TextUtils.isEmpty(str)) {
          ((Intent)localObject1).addCategory(str);
        }
        ((Intent)localObject1).setFlags(this.ap.getInt("flags", 0));
        aahb.a(this.this$0).startActivity((Intent)localObject1);
      }
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
 * Qualified Name:     aahz
 * JD-Core Version:    0.7.0.1
 */