import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class tgt
  implements View.OnClickListener
{
  tgt(tgq paramtgq) {}
  
  public void onClick(View paramView)
  {
    this.this$0.jdField_a_of_type_Tgz.a(this.this$0.mActivity, paramView, this.this$0.jdField_a_of_type_Tgo.a());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tgt
 * JD-Core Version:    0.7.0.1
 */