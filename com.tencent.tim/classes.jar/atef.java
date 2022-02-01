import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class atef
  implements View.OnClickListener
{
  atef(ated paramated) {}
  
  public void onClick(View paramView)
  {
    ausj localausj = (ausj)auss.a(ated.a(this.b), null);
    atio localatio = (atio)paramView.getTag();
    this.b.Km.clear();
    this.b.Km.add(localatio);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(atjr.c);
    localArrayList.add(atjr.b);
    localArrayList.add(atjr.e);
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      atiw localatiw = (atiw)localIterator.next();
      localausj.addButton(ated.a(this.b).getResources().getString(localatiw.KB()), 1);
    }
    localausj.addCancelButton(2131721058);
    localausj.a(new ateg(this, localArrayList, localatio, localausj));
    localausj.show();
    anpc.report("tim_mine_tab_file_click_cloud_space_click");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atef
 * JD-Core Version:    0.7.0.1
 */