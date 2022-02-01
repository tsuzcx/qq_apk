import UserGrowth.stSimpleMetaComment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ohq
  implements View.OnClickListener
{
  ohq(ohl.b paramb, stSimpleMetaComment paramstSimpleMetaComment) {}
  
  public void onClick(View paramView)
  {
    ClipboardManager localClipboardManager = (ClipboardManager)ohl.a(this.b.this$0).getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      ClipData localClipData = ClipData.newPlainText("", this.d.wording);
      alkw.a(localClipboardManager, localClipData);
      localClipboardManager.setPrimaryClip(localClipData);
      ohl.a(this.b.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohq
 * JD-Core Version:    0.7.0.1
 */