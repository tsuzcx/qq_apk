import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class zvx
  implements View.OnClickListener
{
  public zvx(QRCardActivity paramQRCardActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      if (((Integer)localObject).intValue() != 0) {
        break label110;
      }
    }
    label110:
    for (String str = (String)((TextView)paramView.findViewById(2131365046)).getText();; str = null)
    {
      if (((Integer)localObject).intValue() == 1) {
        this.a.a((String)this.a.a.d.get(this.a.h));
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        QRCardActivity.a(this.a, paramView.getContext(), ((Integer)localObject).intValue(), null, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvx
 * JD-Core Version:    0.7.0.1
 */