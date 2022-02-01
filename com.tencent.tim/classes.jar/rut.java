import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;

public class rut
  implements ShareActionSheet.OnItemClickListener
{
  public rut(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    paramShareActionSheet.dismiss();
    QLog.d("QRDisplayActivity", 2, " showMyQrCodeActionSheet() click item = " + paramActionSheetItem.action);
    switch (paramActionSheetItem.action)
    {
    default: 
      return;
    case 26: 
      QRDisplayActivity.a(this.this$0, 6000, acbn.bkw);
      return;
    case 72: 
      QRDisplayActivity.a(this.this$0, paramActionSheetItem.uinType, paramActionSheetItem.uin);
      return;
    case 2: 
      this.this$0.atU = 0;
      QRDisplayActivity.a(this.this$0);
      return;
    case 3: 
      this.this$0.atU = 1;
      QRDisplayActivity.a(this.this$0);
      return;
    case 9: 
      this.this$0.atU = 2;
      QRDisplayActivity.a(this.this$0);
      return;
    case 10: 
      this.this$0.atU = 3;
      QRDisplayActivity.a(this.this$0);
      return;
    case 39: 
      this.this$0.bwA();
      return;
    }
    this.this$0.atU = 4;
    QRDisplayActivity.d(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rut
 * JD-Core Version:    0.7.0.1
 */