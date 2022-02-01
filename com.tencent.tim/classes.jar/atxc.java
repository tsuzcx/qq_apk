import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.tim.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class atxc
  implements atyr
{
  public atxc(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void as(boolean paramBoolean)
  {
    FileBrowserActivity.a(this.this$0, paramBoolean);
    View localView = this.this$0.findViewById(2131377364);
    if (!FileBrowserActivity.b(this.this$0))
    {
      localView.setVisibility(0);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.mSystemBarComp != null))
      {
        int i = this.this$0.getResources().getColor(2131167361);
        if (ImmersiveUtils.a(this.this$0.getActivity().getWindow(), true)) {
          i = this.this$0.getResources().getColor(2131167562);
        }
        this.this$0.mSystemBarComp.setStatusColor(i);
        this.this$0.mSystemBarComp.setStatusBarColor(i);
      }
      this.this$0.getWindow().setFlags(0, 1024);
      return;
    }
    localView.setVisibility(8);
    this.this$0.euC();
    this.this$0.euE();
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.mSystemBarComp != null))
    {
      this.this$0.mSystemBarComp.setStatusColor(0);
      this.this$0.mSystemBarComp.setStatusBarColor(0);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        this.this$0.mSystemBarComp.setStatusDrawable(null);
      }
    }
    this.this$0.getWindow().setFlags(1024, 1024);
  }
  
  public void av(int paramInt)
  {
    FileBrowserActivity.a(this.this$0);
  }
  
  @TargetApi(14)
  public void iw()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.findViewById(2131377547);
      localRelativeLayout.setFitsSystemWindows(true);
      localRelativeLayout.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.this$0), 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxc
 * JD-Core Version:    0.7.0.1
 */