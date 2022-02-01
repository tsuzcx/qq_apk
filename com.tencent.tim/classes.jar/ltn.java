import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeUsersCommentsView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ltn
  implements View.OnClickListener
{
  public ltn(NativeUsersCommentsView paramNativeUsersCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.b.callOnClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ltn
 * JD-Core Version:    0.7.0.1
 */