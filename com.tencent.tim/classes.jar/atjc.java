import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.WeiYunFileListFragment;

public class atjc
  implements View.OnClickListener
{
  public atjc(WeiYunFileListFragment paramWeiYunFileListFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    this.a.getActivity().setResult(-1, localIntent);
    this.a.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjc
 * JD-Core Version:    0.7.0.1
 */