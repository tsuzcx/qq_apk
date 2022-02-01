import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nod
  implements View.OnClickListener
{
  nod(noc paramnoc) {}
  
  public void onClick(View paramView)
  {
    kxm.aJ(paramView.getContext(), this.a.a.amV);
    kbp.a(null, "", "0X8009BA1", "0X8009BA1", 0, 0, ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentAccountUin(), "", "", "", false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nod
 * JD-Core Version:    0.7.0.1
 */