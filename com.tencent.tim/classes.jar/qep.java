import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

final class qep
  implements DialogInterface.OnClickListener
{
  qep(StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ram.w("Q.qqstory.player.PlayModeUtils", "onClick delete =%s", new Object[] { this.a });
    pnx.qT(this.axc);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qep
 * JD-Core Version:    0.7.0.1
 */