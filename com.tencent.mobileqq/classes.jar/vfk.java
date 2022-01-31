import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tribe.async.reactive.SimpleObserver;

class vfk
  extends SimpleObserver<vsa>
{
  vfk(vfj paramvfj, vsa paramvsa) {}
  
  public void a(vsa paramvsa)
  {
    int i = 1;
    super.onNext(paramvsa);
    this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.b();
    if ((!this.jdField_a_of_type_Vsa.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Vsa.a.a)) {
      this.jdField_a_of_type_Vfj.jdField_a_of_type_JavaLangString = paramvsa.a.jdField_b_of_type_JavaLangString;
    }
    paramvsa = this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramvsa != null) && (!paramvsa.isFinishing()))
    {
      ved.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Vsa.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.a(this.jdField_a_of_type_Vsa);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Vfj.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramvsa, PhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramvsa.startActivity((Intent)localObject1);
        paramvsa.setResult(-1);
        paramvsa.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramvsa = (vsa)localObject1;
      if (j != -1)
      {
        paramvsa = (vsa)localObject1;
        if (j != 1)
        {
          paramvsa = (vsa)localObject1;
          if (j != 3000) {
            paramvsa = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (axhr.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      avtd.a(i, paramvsa);
      return;
      if (!bool2)
      {
        bgyp.a(paramvsa, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.a(-1, null, 2130772028, 0);
        break;
      }
      this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.a(-1, (Intent)localObject1, 2130772028, 0);
      break;
      label378:
      this.jdField_a_of_type_Vfj.a(paramvsa, this.jdField_a_of_type_Vfj.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ved.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.b();
    bcql.a(this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.a(), ajya.a(2131703688), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.b();
    bcql.a(this.jdField_a_of_type_Vfj.jdField_a_of_type_Vix.a(), ajya.a(2131703685) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfk
 * JD-Core Version:    0.7.0.1
 */