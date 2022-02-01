import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianProgressView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ndd
  implements View.OnClickListener
{
  public ndd(KandianProgressView paramKandianProgressView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365697: 
      case 2131365714: 
        this.a.a.aK(this.a.mBundle);
        break;
      case 2131377222: 
      case 2131377230: 
        this.a.a.f(this.a.ajb, this.a.mBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndd
 * JD-Core Version:    0.7.0.1
 */