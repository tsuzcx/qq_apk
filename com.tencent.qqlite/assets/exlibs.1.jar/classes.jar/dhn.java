import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

public class dhn
  implements View.OnClickListener
{
  public dhn(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (NetworkUtil.e(this.a.getActivity()))
    {
      UniformDownloadActivity.a(this.a).setVisibility(8);
      if (FileManagerUtil.a())
      {
        FMDialogUtil.a(this.a.getActivity(), 2131362018, 2131362038, new dho(this));
        return;
      }
      UniformDownloadActivity.a(this.a);
      this.a.finish();
      this.a.overridePendingTransition(0, 0);
      return;
    }
    FMToastUtil.a(2131363450);
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dhn
 * JD-Core Version:    0.7.0.1
 */