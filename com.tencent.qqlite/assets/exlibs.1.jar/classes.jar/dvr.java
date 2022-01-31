import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.PreviewingOfflineFileViewBase;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.FilePreviewAnim;
import com.tencent.mobileqq.filemanager.util.FilePreviewAnimQueue.eAnimType;
import com.tencent.qphone.base.util.QLog;

public class dvr
  implements Runnable
{
  public dvr(PreviewingOfflineFileViewBase paramPreviewingOfflineFileViewBase) {}
  
  public void run()
  {
    if (PreviewingOfflineFileViewBase.a(this.a) == null) {
      PreviewingOfflineFileViewBase.a(this.a, (LinearLayout)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298046));
    }
    if (PreviewingOfflineFileViewBase.b(this.a)) {
      PreviewingOfflineFileViewBase.a(this.a, 20);
    }
    for (;;)
    {
      if (PreviewingOfflineFileViewBase.b(this.a) == null) {
        PreviewingOfflineFileViewBase.b(this.a, new FilePreviewAnimQueue(PreviewingOfflineFileViewBase.a(this.a)));
      }
      ((ProgressBar)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298047)).setVisibility(0);
      ((TextView)PreviewingOfflineFileViewBase.a(this.a).findViewById(2131298048)).setText(2131363577);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.5F, 1.0F);
      localAlphaAnimation.setFillAfter(true);
      FilePreviewAnimQueue.FilePreviewAnim localFilePreviewAnim = new FilePreviewAnimQueue.FilePreviewAnim();
      localFilePreviewAnim.jdField_a_of_type_JavaLangObject = localAlphaAnimation;
      localFilePreviewAnim.jdField_a_of_type_Boolean = true;
      localFilePreviewAnim.jdField_a_of_type_ComTencentMobileqqFilemanagerUtilFilePreviewAnimQueue$eAnimType = FilePreviewAnimQueue.eAnimType.eAlphaAnim;
      localFilePreviewAnim.jdField_a_of_type_Int = 500;
      PreviewingOfflineFileViewBase.b(this.a).a(localFilePreviewAnim);
      PreviewingOfflineFileViewBase.b(this.a).a();
      if (QLog.isColorLevel()) {
        QLog.i("PreviewingOfflineFileViewBase<FileAssistant>", 2, "showGetmore(1000)");
      }
      return;
      PreviewingOfflineFileViewBase.a(this.a, 140);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dvr
 * JD-Core Version:    0.7.0.1
 */