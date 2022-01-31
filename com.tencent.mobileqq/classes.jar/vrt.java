import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.activity.ScanOcrActivity;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.File;

public class vrt
  implements ActionSheet.OnButtonClickListener
{
  public vrt(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOFilePicData paramAIOFilePicData, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
    if (paramView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty(paramView))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.jdField_d_of_type_Boolean) && (!paramView.equals(AIOGalleryScene.ab(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435899))) && (!paramView.equals(AIOGalleryScene.ac(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435898))))
    {
      QQToast.a(AIOGalleryScene.ad(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.ae(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131428188), 0).a();
      return;
    }
    if (paramView.equals(AIOGalleryScene.af(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435887))) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.f, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(paramView);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(AIOGalleryScene.ag(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131428294)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder())
        {
          long l1 = FMConfig.a();
          long l2 = FMConfig.b();
          if ((FileManagerUtil.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.a > l1) && (MessageCache.a() - this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.b > l2) && (!"I:N".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.jdField_d_of_type_JavaLangString)) && (FileUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.jdField_d_of_type_JavaLangString)))
          {
            try
            {
              DialogUtil.a(AIOGalleryScene.ah(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), 230, AIOGalleryScene.ai(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131428241), AIOGalleryScene.aj(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131428237), "取消", "继续", new vru(this), new vrv(this)).show();
            }
            catch (Throwable paramView) {}
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.g);
            QQToast.a(AIOGalleryScene.am(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.an(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131428195), 0).a();
          }
        }
      }
      else if (paramView.equals(AIOGalleryScene.ao(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435893)))
      {
        AIOGalleryUtils.a(AIOGalleryScene.ap(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
      }
      else if (paramView.equals(AIOGalleryScene.aq(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435891)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.asBinder().pingBinder()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOFilePicData.g);
        }
      }
      else if (paramView.equals(AIOGalleryScene.ar(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435898)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.s();
      }
      else if (paramView.equals(AIOGalleryScene.as(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435899)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.t();
      }
      else if (paramView.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_a_of_type_JavaLangString))
      {
        if (this.jdField_a_of_type_JavaIoFile != null) {
          ScanOcrActivity.a(AIOGalleryScene.at(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), 1);
        }
      }
      else if (paramView.equals(AIOGalleryScene.au(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131435890)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.jdField_g_of_type_JavaLangString);
        ReportController.b(null, "P_CliOper", "qrcode", "", "0X80059A4", "0X80059A4", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vrt
 * JD-Core Version:    0.7.0.1
 */