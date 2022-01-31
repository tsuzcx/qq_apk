import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.common.galleryactivity.AbstractImageListScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListModel;
import com.tencent.mobileqq.activity.aio.photo.AIOImageListScene;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;

public class viy
  extends GalleryManager
{
  IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = new viz(this);
  
  public viy(AIOGalleryActivity paramAIOGalleryActivity) {}
  
  public AbstractGalleryScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    return new AIOGallerySceneWithBusiness(paramActivity, paramAbstractImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, AIOGalleryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public AbstractImageListModel a(Activity paramActivity)
  {
    paramActivity.getIntent().getIntExtra("forward_source_uin_type", -1);
    return new AIOImageListModel(false, false);
  }
  
  public AbstractImageListScene a(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel)
  {
    AIOImageListModel localAIOImageListModel = (AIOImageListModel)paramAbstractImageListModel;
    if ((localAIOImageListModel.b()) && (this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene != null)) {
      ((AIOGalleryScene)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryScene).u();
    }
    localAIOImageListModel.f = paramActivity.getIntent().getBooleanExtra("extra.IS_FROM_NEW_TROOP_CHAT_HISTORY", false);
    if (localAIOImageListModel.f) {
      ReportController.b(null, "dc00899", "Grp_chatRecord", "", "chatRecor_pic", "pic_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_JavaLangString, "", "", "");
    }
    localAIOImageListModel.d(4);
    localAIOImageListModel.a();
    return new AIOImageListScene(paramActivity, paramAbstractImageListModel, this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider, AIOGalleryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity));
  }
  
  public void a(Activity paramActivity)
  {
    if (AIOGalleryUtils.a != null) {
      AIOGalleryUtils.a.removeMessages(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider == null)
    {
      BinderWarpper localBinderWarpper = (BinderWarpper)paramActivity.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localBinderWarpper == null) {
        break label173;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = IAIOImageProvider.Stub.a(localBinderWarpper.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack);
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryActivity", 2, "IAIOImageProvider is " + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOGalleryActivity.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider);
      }
    }
    boolean bool = paramActivity.getIntent().getBooleanExtra("extra.IS_GOTO_IMAGELIST", false);
    super.a(paramActivity);
    if (bool)
    {
      this.jdField_a_of_type_Boolean = paramActivity.getIntent().getBooleanExtra("extra.NO_FIRST_ENTER_ANIMATION", false);
      super.a();
      if ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene != null) && ((this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene instanceof AIOImageListScene))) {
        ((AIOImageListScene)this.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractImageListScene).m();
      }
    }
    return;
    label173:
    throw new IllegalArgumentException("can't find Binder in Intent..");
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     viy
 * JD-Core Version:    0.7.0.1
 */