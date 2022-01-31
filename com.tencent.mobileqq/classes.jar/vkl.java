import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.NativeVideoImage;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.WatermarkVideoRunnable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.Gallery;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class vkl
  implements ActionSheet.OnButtonClickListener
{
  public vkl(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOShortVideoData paramAIOShortVideoData, File paramFile, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    Object localObject = AIOGalleryScene.P(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources();
    if (paramView.equals(((Resources)localObject).getString(2131435854))) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.g);
        if (paramView != null)
        {
          paramView.putExtra("NeedReportForwardShortVideo", true);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a() != null)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a().a;
            if ((localObject instanceof AIOShortVideoData))
            {
              localObject = (AIOShortVideoData)localObject;
              paramInt = ((AIOShortVideoData)localObject).jdField_e_of_type_Int;
              AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
              if ((paramInt == LocalMediaInfo.REDBAG_TYPE_GET) && (localAppRuntime.getAccount().equals(((AIOShortVideoData)localObject).d)))
              {
                paramView.putExtra("param_key_redbag_type", paramInt);
                paramView.putExtra("param_key_redbag_video_id", ((AIOShortVideoData)localObject).c);
                paramView.putExtra("from_session_uin", ((AIOShortVideoData)localObject).jdField_e_of_type_JavaLangString);
              }
              if (((AIOShortVideoData)localObject).j == 2) {
                paramView.putExtra("special_video_type", ((AIOShortVideoData)localObject).j);
              }
            }
          }
          ForwardBaseOption.a(AIOGalleryScene.Q(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), paramView);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(((Resources)localObject).getString(2131437366)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOGalleryScene", 2, "click menu to share to qzone");
        }
        paramView = QZoneHelper.UserInfo.a();
        paramView.a = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b;
        QZoneHelper.b(AIOGalleryScene.R(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), paramView, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 10001);
        ReportController.b(null, "dc00898", "", "", "0X8007539", "0X8007539", 0, 0, "", "", "", "");
      }
      else if (paramView.equals(((Resources)localObject).getString(2131435865)))
      {
        ReportController.b(null, "CliOper", "", "", "0X8005623", "0X8005623", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.s();
      }
      else if (paramView.equals(((Resources)localObject).getString(2131435860)))
      {
        paramView = this.jdField_a_of_type_JavaIoFile.getParentFile().getName().toLowerCase(Locale.US) + ".mp4";
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_MqqOsMqqHandler, paramView, false));
        ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
        try
        {
          paramView = (PeakActivity)AIOGalleryScene.S(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene);
          localObject = AIOGalleryScene.T(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getIntent();
          if (localObject == null) {
            continue;
          }
          paramInt = ((Intent)localObject).getIntExtra("forward_source_uin_type", -1);
          localObject = ((Intent)localObject).getStringExtra("uin");
          new DCShortVideo(AIOGalleryScene.U(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getApplication().getBaseContext()).a(paramView.a, 2001, paramInt, (String)localObject);
        }
        catch (ClassCastException paramView) {}
      }
      else if (paramView.equals(((Resources)localObject).getString(2131435861)))
      {
        ShortVideoUtils.a(AIOGalleryScene.V(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile);
      }
      else if (paramView.equals(((Resources)localObject).getString(2131435858)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOShortVideoData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.g);
          if (paramView != null)
          {
            QfavBuilder.a(paramView).a(AIOGalleryScene.W(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), BaseApplicationImpl.getApplication().getRuntime().getAccount());
            QfavReport.a(BaseApplicationImpl.getApplication().getRuntime(), 6, 5);
          }
        }
      }
      else if (paramView.equals(AIOGalleryScene.X(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435866)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.t();
      }
      else if (paramView.equals(AIOGalleryScene.Y(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131435878)))
      {
        paramView = null;
        switch (this.jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          if (paramView != null) {
            ReportController.b(null, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
          }
          paramView = (PeakActivity)AIOGalleryScene.Z(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene);
          if (AIOGalleryScene.aa(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getIntent() != null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("AIOGalleryScene", 2, "save video failed, intent is null");
          }
          QQToast.a(paramView, 1, "保存失败", 0).a();
          return;
          paramView = "0X8007A24";
          continue;
          paramView = "0X8007A25";
        }
        NativeVideoImage.pauseAll();
        paramInt = AIOGalleryScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getFirstVisiblePosition();
        int i = AIOGalleryScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getChildCount();
        int j = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
        if ((j >= paramInt) && (j <= i + paramInt - 1))
        {
          localObject = AIOGalleryScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getChildAt(j - paramInt);
          if (AIOGalleryAdapter.GalleryImageStruct.class.isInstance(localObject)) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryAdapter.a(j, (AIOGalleryAdapter.GalleryImageStruct)localObject);
          }
        }
        localObject = ShortVideoUtils.b();
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, new ShortVideoUtils.WatermarkVideoRunnable(paramView, AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_MqqOsMqqHandler));
        ThreadManager.getFileThreadHandler().post(AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(paramView, "正在保存...", false, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.o = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.h = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.d(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.v();
        ReportController.b(null, "CliOper", "", "", "0X800610F", "0X800610F", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vkl
 * JD-Core Version:    0.7.0.1
 */