import android.annotation.TargetApi;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class agqg
  implements agsb
{
  public agqg(FileBrowserActivity paramFileBrowserActivity) {}
  
  public void as(boolean paramBoolean)
  {
    FileBrowserActivity.a(this.this$0, paramBoolean);
    View localView = this.this$0.findViewById(2131377364);
    if (!FileBrowserActivity.a(this.this$0))
    {
      localView.setVisibility(0);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.mSystemBarComp != null))
      {
        int i = this.this$0.getResources().getColor(2131167361);
        this.this$0.mSystemBarComp.setStatusColor(i);
        this.this$0.mSystemBarComp.setStatusBarColor(i);
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.this$0.mSystemBarComp.setStatusBarDrawable(this.this$0.getResources().getDrawable(2130847060));
        }
      }
      this.this$0.getWindow().setFlags(0, 1024);
      return;
    }
    localView.setVisibility(8);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.this$0.mSystemBarComp != null))
    {
      this.this$0.mSystemBarComp.setStatusColor(0);
      this.this$0.mSystemBarComp.setStatusBarColor(0);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.this$0.mSystemBarComp.setStatusBarDrawable(null);
      }
    }
    this.this$0.getWindow().setFlags(1024, 1024);
  }
  
  public void av(int paramInt)
  {
    FileBrowserActivity.a(this.this$0, (TextView)this.this$0.findViewById(2131369627));
    FileBrowserActivity.a(this.this$0).setTextSize(1, 19.0F);
    FileBrowserActivity.a(this.this$0).setText(this.this$0.a.vE());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agqg
 * JD-Core Version:    0.7.0.1
 */