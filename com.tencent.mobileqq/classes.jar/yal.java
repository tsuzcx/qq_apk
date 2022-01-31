import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.os.MqqHandler;

public class yal
  implements ActionSheet.OnButtonClickListener
{
  public yal(ShortVideoPlayActivity paramShortVideoPlayActivity, ActionSheet paramActionSheet, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5, String paramString6) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.jdField_a_of_type_JavaLangString)) {
        break label174;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "click menu to forward shortVideo......");
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity;
      Bundle localBundle = ShortVideoPlayActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity).getExtras();
      localBundle.putInt("forward_type", 21);
      localBundle.putBoolean("forward_need_sendmsg", true);
      localBundle.putString("forward_thumb", ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.h, "jpg"));
      localBundle.putString("file_send_path", this.b);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      ForwardBaseOption.a(paramView, localIntent);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Int != 0) {
        ShortVideoPlayActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X80052CC", "0X80052CC", 0, 0, "", "2", "", "");
    }
    label174:
    do
    {
      return;
      if (paramView.equals(this.c))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPlayActivity", 2, "click menu to share to qzone, finalVideoExists=" + this.jdField_a_of_type_Boolean);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          ShortVideoPlayActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity);
          return;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext, 0, 2131437375, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
        return;
      }
      if (paramView.equals(this.d))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext, 0, 2131437375, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.e, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.g + ".mp4", false));
        if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "1", "", "");
          this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
        }
        for (;;)
        {
          new DCShortVideo(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, 2002, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.e, this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.j);
          return;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d == 3000)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "2", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d == 1)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "3", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004675", "0X8004675", 0, 0, "", "4", "", "");
            this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
          }
        }
      }
    } while (!paramView.equals(this.f));
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext, 0, 2131437375, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.e), "video/*");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.startActivity(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "1", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d == 3000)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "2", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.d == 1)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "3", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.app, "CliOper", "", "", "0X8004676", "0X8004676", 0, 0, "", "4", "", "");
    this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPlayActivity.jdField_b_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yal
 * JD-Core Version:    0.7.0.1
 */