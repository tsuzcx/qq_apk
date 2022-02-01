import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

class asie
  extends BroadcastReceiver
{
  asie(asid paramasid) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet")) && (this.a.mRuntime.getActivity() != null))
    {
      paramContext = (ausj)auss.a((Activity)paramContext, null);
      paramContext.addButton(2131700352);
      paramContext.addCancelButton(2131721058);
      paramContext.a(new asif(this, paramIntent, paramContext));
      paramContext.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asie
 * JD-Core Version:    0.7.0.1
 */