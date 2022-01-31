import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tribe.async.reactive.SimpleObserver;

class usr
  extends SimpleObserver<vfh>
{
  usr(usq paramusq, vfh paramvfh) {}
  
  public void a(vfh paramvfh)
  {
    int i = 1;
    super.onNext(paramvfh);
    this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.b();
    if ((!this.jdField_a_of_type_Vfh.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Vfh.a.a)) {
      this.jdField_a_of_type_Usq.jdField_a_of_type_JavaLangString = paramvfh.a.jdField_b_of_type_JavaLangString;
    }
    paramvfh = this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramvfh != null) && (!paramvfh.isFinishing()))
    {
      urk.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Vfh.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.a(this.jdField_a_of_type_Vfh);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Usq.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramvfh, PhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramvfh.startActivity((Intent)localObject1);
        paramvfh.setResult(-1);
        paramvfh.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramvfh = (vfh)localObject1;
      if (j != -1)
      {
        paramvfh = (vfh)localObject1;
        if (j != 1)
        {
          paramvfh = (vfh)localObject1;
          if (j != 3000) {
            paramvfh = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (awij.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      auts.a(i, paramvfh);
      return;
      if (!bool2)
      {
        bfpr.a(paramvfh, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.a(-1, null, 2130772028, 0);
        break;
      }
      this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.a(-1, (Intent)localObject1, 2130772028, 0);
      break;
      label378:
      this.jdField_a_of_type_Usq.a(paramvfh, this.jdField_a_of_type_Usq.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    urk.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.b();
    bbmy.a(this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.a(), ajjy.a(2131637892), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.b();
    bbmy.a(this.jdField_a_of_type_Usq.jdField_a_of_type_Uwe.a(), ajjy.a(2131637889) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usr
 * JD-Core Version:    0.7.0.1
 */