package oicq.wlogin_sdk.request;

import android.text.TextPaint;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import oicq.wlogin_sdk.tools.ErrMsg;

class i
  implements Runnable
{
  i(h paramh) {}
  
  private void a(Toast paramToast, int paramInt)
  {
    if (paramInt > 5) {
      return;
    }
    paramToast.show();
    b(paramToast, paramInt);
  }
  
  private void b(Toast paramToast, int paramInt)
  {
    new Timer().schedule(new j(this, paramToast, paramInt), 30L);
  }
  
  public void run()
  {
    if ((h.a(this.a) != null) && (h.b(this.a) != null))
    {
      LinearLayout localLinearLayout = new LinearLayout(h.a(this.a));
      localLinearLayout.setOrientation(1);
      localLinearLayout.setBackgroundColor(-7829368);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      Object localObject = new TextView(h.a(this.a));
      ((TextView)localObject).getPaint().setFakeBoldText(true);
      ((TextView)localObject).setText(h.b(this.a).getTitle());
      localLinearLayout.addView((View)localObject, 0, new LinearLayout.LayoutParams(-1, -2));
      localObject = new TextView(h.a(this.a));
      ((TextView)localObject).setText(h.b(this.a).getMessage());
      localLinearLayout.addView((View)localObject, 1, new LinearLayout.LayoutParams(-1, -2));
      localObject = new Toast(h.a(this.a));
      ((Toast)localObject).setGravity(17, 0, 0);
      ((Toast)localObject).setDuration(1);
      ((Toast)localObject).setView(localLinearLayout);
      a((Toast)localObject, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.i
 * JD-Core Version:    0.7.0.1
 */