import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper.DownloadTask;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qqcircle.QCircleConfig;

public class vwe
  extends ReportDialog
{
  private static RFWMultiDownloadHelper jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper = new RFWMultiDownloadHelper();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private final znw jdField_a_of_type_Znw = new vwf(this);
  
  static
  {
    jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip", QCircleConfig.getDownloadStrategy()));
    jdField_a_of_type_ComTencentBizRichframeworkDownloadRFWMultiDownloadHelper.start();
  }
  
  public vwe(@NonNull Context paramContext)
  {
    super(paramContext, 2131755899);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560754, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131374040));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130844049);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
  }
  
  private void c()
  {
    d();
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null) {}
    while (!this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null) {
      if (RFWDownloaderFactory.getDownloader(QCircleConfig.getDownloadStrategy()).isFileDownLoaded("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip"))
      {
        znp localznp = new znp("https://downv6.qq.com/video_story/qcircle/animation/pull_refresh_logo.zip");
        localznp.a(67);
        localznp.a(2147483647L);
        localznp.a(true);
        localznp.b(true);
        znq.a().a(hashCode(), localznp.a(), this.jdField_a_of_type_Znw);
      }
    }
    for (;;)
    {
      show();
      return;
      c();
      continue;
      b();
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    d();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.jdField_a_of_type_AndroidViewView);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle.getDecorView().setSystemUiVisibility(1280);
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(0);
    }
    for (;;)
    {
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      localLayoutParams.gravity = 17;
      paramBundle.setAttributes(localLayoutParams);
      setCanceledOnTouchOutside(false);
      return;
      getWindow().addFlags(67108864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vwe
 * JD-Core Version:    0.7.0.1
 */