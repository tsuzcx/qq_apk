import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class sdd
  implements View.OnClickListener
{
  sdd(scw.d paramd, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)scw.c(this.b.this$0).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      ClipData localClipData = ClipData.newPlainText("", this.f.content.get());
      alkw.a(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
      scw.a(this.b.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sdd
 * JD-Core Version:    0.7.0.1
 */