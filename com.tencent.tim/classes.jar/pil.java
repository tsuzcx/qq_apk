import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pil
  implements View.OnClickListener
{
  pil(pik parampik) {}
  
  public void onClick(View paramView)
  {
    QCircleInitBean localQCircleInitBean = pik.a(this.a);
    if (localQCircleInitBean != null)
    {
      Intent localIntent = new Intent();
      pco.h("", 17, 3L);
      oux.a(BaseApplication.getContext(), localQCircleInitBean, localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pil
 * JD-Core Version:    0.7.0.1
 */