import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import cooperation.qzone.QZoneHelper;

class xxc
  extends SimpleObserver<yjh>
{
  xxc(xxb paramxxb, yjh paramyjh) {}
  
  public void a(yjh paramyjh)
  {
    int i = 1;
    super.onNext(paramyjh);
    this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.b();
    if ((!this.jdField_a_of_type_Yjh.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Yjh.a.a)) {
      this.jdField_a_of_type_Xxb.jdField_a_of_type_JavaLangString = paramyjh.a.jdField_b_of_type_JavaLangString;
    }
    paramyjh = this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramyjh != null) && (!paramyjh.isFinishing()))
    {
      xvv.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Yjh.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.a(this.jdField_a_of_type_Yjh);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Xxb.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramyjh, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramyjh.startActivity((Intent)localObject1);
        paramyjh.setResult(-1);
        paramyjh.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramyjh = (yjh)localObject1;
      if (j != -1)
      {
        paramyjh = (yjh)localObject1;
        if (j != 1)
        {
          paramyjh = (yjh)localObject1;
          if (j != 3000) {
            paramyjh = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (bbuc.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      babc.a(i, paramyjh);
      return;
      if (!bool2)
      {
        QZoneHelper.launchQZone(paramyjh, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.a(-1, null, 2130772030, 0);
        break;
      }
      this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.a(-1, (Intent)localObject1, 2130772030, 0);
      break;
      label378:
      this.jdField_a_of_type_Xxb.a(paramyjh, this.jdField_a_of_type_Xxb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    xvv.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.b();
    QQToast.a(this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.a(), amtj.a(2131702811), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.b();
    QQToast.a(this.jdField_a_of_type_Xxb.jdField_a_of_type_Yan.a(), amtj.a(2131702808) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xxc
 * JD-Core Version:    0.7.0.1
 */