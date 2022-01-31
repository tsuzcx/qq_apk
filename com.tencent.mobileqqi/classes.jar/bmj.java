import android.view.View;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class bmj
  implements ActionSheet.OnButtonClickListener
{
  public bmj(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.d) {
      return;
    }
    this.a.d = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      if (!this.a.a)
      {
        this.a.n_();
        continue;
        if (!this.a.a)
        {
          this.a.d();
          continue;
          if (!this.a.a) {
            this.a.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bmj
 * JD-Core Version:    0.7.0.1
 */