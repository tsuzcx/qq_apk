import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;

class ylv
  extends SimpleObserver<yya>
{
  ylv(ylu paramylu, yya paramyya) {}
  
  public void a(yya paramyya)
  {
    int i = 1;
    super.onNext(paramyya);
    this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.b();
    if ((!this.jdField_a_of_type_Yya.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Yya.a.a)) {
      this.jdField_a_of_type_Ylu.jdField_a_of_type_JavaLangString = paramyya.a.jdField_b_of_type_JavaLangString;
    }
    paramyya = this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramyya != null) && (!paramyya.isFinishing()))
    {
      ykq.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Yya.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.a(this.jdField_a_of_type_Yya);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Ylu.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramyya, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramyya.startActivity((Intent)localObject1);
        paramyya.setResult(-1);
        paramyya.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramyya = (yya)localObject1;
      if (j != -1)
      {
        paramyya = (yya)localObject1;
        if (j != 1)
        {
          paramyya = (yya)localObject1;
          if (j != 3000) {
            paramyya = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (bdax.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      bbhl.a(i, paramyya);
      return;
      if (!bool2)
      {
        QZoneHelper.launchQZone(paramyya, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.a(-1, null, 2130772030, 0);
        break;
      }
      this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.a(-1, (Intent)localObject1, 2130772030, 0);
      break;
      label378:
      this.jdField_a_of_type_Ylu.a(paramyya, this.jdField_a_of_type_Ylu.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ykq.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.b();
    QQToast.a(this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.a(), anvx.a(2131703162), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.b();
    QQToast.a(this.jdField_a_of_type_Ylu.jdField_a_of_type_Ypg.a(), anvx.a(2131703159) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylv
 * JD-Core Version:    0.7.0.1
 */