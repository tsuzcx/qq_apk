import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;

public class bmf
  implements Runnable
{
  public bmf(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int i = this.a.c.getHeight();
    int j = this.a.b.getHeight();
    if (j < i)
    {
      View localView = this.a.findViewById(2131232577);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      int k = localLayoutParams.topMargin;
      localLayoutParams.topMargin = ((i - j) / 2 + k);
      localView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmf
 * JD-Core Version:    0.7.0.1
 */