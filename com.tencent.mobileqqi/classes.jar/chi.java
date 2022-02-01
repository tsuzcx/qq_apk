import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class chi
  implements DialogInterface.OnClickListener
{
  public chi(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = DiscussionInfoCardActivity.a(this.a).getInputValue();
    if ((paramDialogInterface != null) && (!paramDialogInterface.equals("")) && (!paramDialogInterface.equals(DiscussionInfoCardActivity.b(this.a))))
    {
      if (NetworkUtil.e(this.a))
      {
        DiscussionInfoCardActivity.a(this.a).a(Long.valueOf(DiscussionInfoCardActivity.a(this.a)).longValue(), paramDialogInterface);
        DiscussionInfoCardActivity.a(this.a).setRightText(paramDialogInterface);
        this.a.a(this.a.getString(2131561664));
        DiscussionInfoCardActivity.a(this.a).show();
      }
    }
    else {
      return;
    }
    this.a.a(2130837949, this.a.getString(2131562488));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chi
 * JD-Core Version:    0.7.0.1
 */