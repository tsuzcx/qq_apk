import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;

final class aofm
  implements ausj.a
{
  aofm(int paramInt, String paramString1, Context paramContext, String paramString2, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if (this.dOr == 2)
      {
        paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.chR)), this.val$context.getString(2131695601));
        paramView.putExtra("big_brother_source_key", this.ckC);
        this.val$context.startActivity(paramView);
      }
      else
      {
        paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.chR));
        paramView.putExtra("big_brother_source_key", this.ckC);
        this.val$context.startActivity(paramView);
        aofk.access$300("1", "2");
        continue;
        ((ClipboardManager)this.val$context.getSystemService("clipboard")).setText(this.chR);
        aofk.access$300("2", "1");
        continue;
        aofk.ca(this.val$context, this.chR);
        aofk.hF("0X800A00A", "0X800A00A");
        continue;
        AddFriendActivity.a(this.val$context, false, this.chR, true);
        aofk.access$300("3", "1");
        continue;
        AddFriendActivity.a(this.val$context, true, this.chR, true);
        aofk.access$300("4", "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofm
 * JD-Core Version:    0.7.0.1
 */