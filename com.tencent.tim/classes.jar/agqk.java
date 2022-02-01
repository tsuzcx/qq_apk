import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;

class agqk
  implements ShareActionSheet.OnItemClickListener
{
  agqk(agqi paramagqi) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {}
    do
    {
      return;
      agqi.a(this.b).dismiss();
      if (paramActionSheetItem.listener != null)
      {
        paramActionSheetItem.listener.onClick(null);
        return;
      }
    } while (agqi.a(this.b) == null);
    agqi.a(this.b).a(paramActionSheetItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqk
 * JD-Core Version:    0.7.0.1
 */