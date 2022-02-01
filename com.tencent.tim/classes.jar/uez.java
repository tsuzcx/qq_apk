import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class uez
  implements DialogInterface.OnClickListener
{
  public uez(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      long l = Long.valueOf(this.this$0.app.getCurrentAccountUin()).longValue();
      this.this$0.showDialog(2);
      this.this$0.a.j(l, Long.valueOf(this.this$0.aKN).longValue(), 1);
      return;
    }
    QQToast.a(this.this$0, 2131696272, 0).show(this.this$0.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uez
 * JD-Core Version:    0.7.0.1
 */