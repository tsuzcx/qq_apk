import com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

public class afrd
  implements ShareActionSheet.OnItemClickListener
{
  public afrd(AIOEmotionFragment paramAIOEmotionFragment) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    this.this$0.d.dismiss();
    int i = paramActionSheetItem.action;
    this.this$0.c(i, paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrd
 * JD-Core Version:    0.7.0.1
 */