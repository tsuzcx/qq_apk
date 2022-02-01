import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;

public class aord
  implements View.OnClickListener
{
  public aord(TribeVideoPreviewFragment paramTribeVideoPreviewFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    FragmentActivity localFragmentActivity = this.this$0.getActivity();
    if (localFragmentActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
      this.this$0.Se(this.val$path);
    }
    for (;;)
    {
      anot.a(this.this$0.getActivity().app, "dc00899", "Grp_tribe", "", "post", "save_video", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localFragmentActivity.requestPermissions(new aore(this), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aord
 * JD-Core Version:    0.7.0.1
 */