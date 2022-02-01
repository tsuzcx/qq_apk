import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class agxe
  implements ShareActionSheet.OnItemClickListener
{
  agxe(agxa paramagxa) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    do
    {
      return;
      agxa.a(this.this$0).dismiss();
      if (paramActionSheetItem.listener != null)
      {
        paramActionSheetItem.listener.onClick(null);
        return;
      }
    } while (this.this$0.a == null);
    this.this$0.a.a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agxe
 * JD-Core Version:    0.7.0.1
 */