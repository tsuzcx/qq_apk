import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class ruc
  implements View.OnClickListener
{
  public ruc(QRCardActivity paramQRCardActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof Integer)) {
      if (((Integer)localObject).intValue() != 0) {
        break label110;
      }
    }
    label110:
    for (String str = (String)((TextView)paramView.findViewById(2131365360)).getText();; str = null)
    {
      if (((Integer)localObject).intValue() == 1) {
        this.this$0.sL((String)this.this$0.a.fD.get(this.this$0.aCh));
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        QRCardActivity.a(this.this$0, paramView.getContext(), ((Integer)localObject).intValue(), null, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ruc
 * JD-Core Version:    0.7.0.1
 */