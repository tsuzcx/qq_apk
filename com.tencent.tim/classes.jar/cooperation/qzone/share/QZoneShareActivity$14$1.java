package cooperation.qzone.share;

import acfp;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.widget.QQToast;

class QZoneShareActivity$14$1
  implements Runnable
{
  QZoneShareActivity$14$1(QZoneShareActivity.14 param14, int paramInt) {}
  
  public void run()
  {
    if (this.a.this$0.agx == null) {}
    do
    {
      do
      {
        return;
        if (this.ezB <= 0) {
          break;
        }
        String str = acfp.m(2131713367) + this.ezB + acfp.m(2131713377);
        int i = this.a.this$0.getResources().getColor(2131167028);
        this.a.this$0.agx.setTextColor(i);
        this.a.this$0.agx.setText(str);
        if (this.a.this$0.agx.getVisibility() != 0) {
          this.a.this$0.agx.setVisibility(0);
        }
      } while (!this.a.this$0.dpz);
      QQToast.a(this.a.this$0, 2131718313, 0).show();
      this.a.this$0.dpz = false;
      return;
    } while (this.a.this$0.agx.getVisibility() == 8);
    this.a.this$0.agx.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14.1
 * JD-Core Version:    0.7.0.1
 */