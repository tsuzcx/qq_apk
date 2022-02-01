import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.cloudfile.CloudFileListFragment;

public class atfw
  implements View.OnClickListener
{
  public atfw(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_file_info", CloudFileListFragment.a(this.this$0));
    this.this$0.getActivity().setResult(-1, localIntent);
    this.this$0.getActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfw
 * JD-Core Version:    0.7.0.1
 */