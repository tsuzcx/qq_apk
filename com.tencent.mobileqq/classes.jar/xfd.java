import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewMusicService;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.widget.TipsBar;

public class xfd
  implements View.OnClickListener
{
  public xfd(BannerManager paramBannerManager, TipsBar paramTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (!FileUtil.a(FileViewMusicService.a().b()))
    {
      FileViewMusicService.a().c();
      this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
      return;
    }
    paramView = new ForwardFileInfo();
    paramView.b(10008);
    Intent localIntent = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), FileBrowserActivity.class);
    localIntent.putExtra("fileinfo", paramView);
    BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).startActivity(localIntent);
    FileManagerReporter.a("0X8004BFE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfd
 * JD-Core Version:    0.7.0.1
 */