import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;

class alcv
  extends BroadcastReceiver
{
  alcv(alcu paramalcu) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = this.a.mRuntime.getActivity();
    } while ((paramContext == null) || (paramContext.isFinishing()));
    paramIntent = this.a.mRuntime.a(this.a.mRuntime.getActivity());
    if ((paramIntent != null) && ((paramIntent instanceof ardm.o)))
    {
      paramIntent = ((ardm.o)paramIntent).getCurrentUrl();
      if ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains("entryId"))) {
        break label232;
      }
    }
    label232:
    for (this.a.drV = aurr.getInt(aurr.getArgumentsFromURL(paramIntent), "entryId", 2);; this.a.drV = 2)
    {
      paramContext.finish();
      paramContext = new Intent(this.a.mRuntime.getActivity(), FriendProfileCardActivity.class);
      paramIntent = new ProfileActivity.AllInOne(this.a.mRuntime.a().getCurrentAccountUin(), 0);
      if (this.a.drV == 0) {
        paramContext.setFlags(67108864);
      }
      paramContext.putExtra("AllInOne", paramIntent);
      this.a.mRuntime.getActivity().startActivity(paramContext);
      paramContext = new Intent();
      paramContext.putExtra("closeSpecialLogic", true);
      this.a.mRuntime.getActivity().setResult(-1, paramContext);
      this.a.mRuntime.getActivity().finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcv
 * JD-Core Version:    0.7.0.1
 */