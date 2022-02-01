import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lei
  implements View.OnClickListener
{
  public lei(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    this.this$0.b(this.this$0.getActivity(), this.iO);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lei
 * JD-Core Version:    0.7.0.1
 */