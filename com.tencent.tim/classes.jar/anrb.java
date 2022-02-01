import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;

final class anrb
  implements ausj.a
{
  anrb(String paramString, Context paramContext) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      anra.a().dismiss();
      return;
      paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.chR));
      this.val$context.startActivity(paramView);
      continue;
      ((ClipboardManager)this.val$context.getSystemService("clipboard")).setText(this.chR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anrb
 * JD-Core Version:    0.7.0.1
 */