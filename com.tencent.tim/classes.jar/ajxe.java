import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

public final class ajxe
  implements ShareActionSheet.OnItemClickListener
{
  ajxe(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, QQAppInterface paramQQAppInterface) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    int i = paramActionSheetItem.action;
    paramShareActionSheet.dismiss();
    switch (i)
    {
    default: 
      QLog.e("ShortVideoShareUtil", 1, "handleShareChatItemClick with invalid case:" + i);
      return;
    case 2: 
    case 73: 
      ajxd.a(this.val$activity, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, this.bop, false);
      return;
    case 3: 
      ajxd.b(this.val$activity, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, this.bop);
      return;
    case 9: 
      ajxd.a(this.val$activity, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, this.val$localPath, new ajxf(this));
      return;
    case 10: 
      ajxd.b(this.val$activity, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, this.val$localPath, new ajxg(this));
      return;
    }
    ajxd.a(this.val$activity, this.val$name, this.val$title, this.aHr, this.val$jumpUrl, this.bop, false, paramActionSheetItem.uinType, paramActionSheetItem.uin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajxe
 * JD-Core Version:    0.7.0.1
 */