import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class xl
  implements DialogInterface.OnClickListener
{
  public xl(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.a.app.a()).longValue();
      this.a.showDialog(2);
      this.a.a.a(l, Long.valueOf(AddRequestActivity.a(this.a)).longValue(), 1);
      return;
    }
    QQToast.a(this.a, 2131363516, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     xl
 * JD-Core Version:    0.7.0.1
 */