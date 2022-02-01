import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class lkp
  implements View.OnClickListener
{
  lkp(lko paramlko, lie paramlie, nhk paramnhk) {}
  
  public void onClick(View paramView)
  {
    if (lko.a(this.a) == null) {
      lko.a(this.a, new autw(lko.a(this.a)));
    }
    lko.a(this.a).a((lis)this.jdField_b_of_type_Lie, this.jdField_b_of_type_Lie.a().mDislikeInfos);
    lko.a(this.a).a(paramView, new lkq(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lkp
 * JD-Core Version:    0.7.0.1
 */