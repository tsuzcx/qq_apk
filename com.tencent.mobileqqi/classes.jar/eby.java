import android.app.Activity;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageInfo;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qqfav.QfavBuilder;
import java.io.File;

public class eby
  implements ActionSheet.OnButtonClickListener
{
  public eby(AIOGalleryScene paramAIOGalleryScene, ActionSheet paramActionSheet, AIOImageInfo paramAIOImageInfo, File paramFile) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet.a(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(AIOGalleryScene.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131562128))) {
          break label162;
        }
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Forward_Contacts", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo);
        if (!paramView.equals(AIOGalleryScene.j(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131561606))) {
          break label478;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.jdField_d_of_type_Int);
        if (paramView != null) {
          continue;
        }
        QfavBuilder.c(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()).a(AIOGalleryScene.k(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b);
      }
      catch (RemoteException paramView)
      {
        label162:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AIOGalleryScene", 2, "", paramView);
        QQToast.a(AIOGalleryScene.m(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getApplicationContext(), AIOGalleryScene.n(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getString(2131562064), 0).a();
        continue;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      if (paramView.equals(AIOGalleryScene.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131562777)))
      {
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Forward_Qzone", 0);
        AIOGalleryUtils.a(AIOGalleryScene.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo, AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene));
        break;
      }
      if (paramView.equals(AIOGalleryScene.f(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131562778)))
      {
        AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Forward_Grpalbum", 0);
        AIOGalleryUtils.a(AIOGalleryScene.g(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b, AIOGalleryScene.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.g, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo.a.b, -1);
        break;
      }
      if (!paramView.equals(AIOGalleryScene.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131562803))) {
        break;
      }
      AIOGalleryScene.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene, "Pic_Save", 0);
      AIOGalleryUtils.a(AIOGalleryScene.i(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_JavaIoFile, Utils.Crc64String(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()));
      break;
      new QfavBuilder(paramView).a(AIOGalleryScene.l(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene), this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.b);
      continue;
      label478:
      if (paramView.equals(AIOGalleryScene.o(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene).getResources().getString(2131563176))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryScene.q();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     eby
 * JD-Core Version:    0.7.0.1
 */