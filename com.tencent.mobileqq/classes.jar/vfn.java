import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tribe.async.reactive.SimpleObserver;

class vfn
  extends SimpleObserver<vsd>
{
  vfn(vfm paramvfm, vsd paramvsd) {}
  
  public void a(vsd paramvsd)
  {
    int i = 1;
    super.onNext(paramvsd);
    this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.b();
    if ((!this.jdField_a_of_type_Vsd.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Vsd.a.a)) {
      this.jdField_a_of_type_Vfm.jdField_a_of_type_JavaLangString = paramvsd.a.jdField_b_of_type_JavaLangString;
    }
    paramvsd = this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramvsd != null) && (!paramvsd.isFinishing()))
    {
      veg.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Vsd.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.a(this.jdField_a_of_type_Vsd);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Vfm.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramvsd, PhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramvsd.startActivity((Intent)localObject1);
        paramvsd.setResult(-1);
        paramvsd.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramvsd = (vsd)localObject1;
      if (j != -1)
      {
        paramvsd = (vsd)localObject1;
        if (j != 1)
        {
          paramvsd = (vsd)localObject1;
          if (j != 3000) {
            paramvsd = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (axhp.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      avtb.a(i, paramvsd);
      return;
      if (!bool2)
      {
        bgxy.a(paramvsd, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.a(-1, null, 2130772028, 0);
        break;
      }
      this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.a(-1, (Intent)localObject1, 2130772028, 0);
      break;
      label378:
      this.jdField_a_of_type_Vfm.a(paramvsd, this.jdField_a_of_type_Vfm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    veg.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.b();
    bcpw.a(this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.a(), ajyc.a(2131703677), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.b();
    bcpw.a(this.jdField_a_of_type_Vfm.jdField_a_of_type_Vja.a(), ajyc.a(2131703674) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vfn
 * JD-Core Version:    0.7.0.1
 */