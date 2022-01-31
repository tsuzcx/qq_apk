import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class wyl
  extends SimpleObserver<xlb>
{
  wyl(wyk paramwyk, xlb paramxlb) {}
  
  public void a(xlb paramxlb)
  {
    int i = 1;
    super.onNext(paramxlb);
    this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.b();
    if ((!this.jdField_a_of_type_Xlb.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Xlb.a.a)) {
      this.jdField_a_of_type_Wyk.jdField_a_of_type_JavaLangString = paramxlb.a.jdField_b_of_type_JavaLangString;
    }
    paramxlb = this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramxlb != null) && (!paramxlb.isFinishing()))
    {
      wxe.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Xlb.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.a(this.jdField_a_of_type_Xlb);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Wyk.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramxlb, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramxlb.startActivity((Intent)localObject1);
        paramxlb.setResult(-1);
        paramxlb.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramxlb = (xlb)localObject1;
      if (j != -1)
      {
        paramxlb = (xlb)localObject1;
        if (j != 1)
        {
          paramxlb = (xlb)localObject1;
          if (j != 3000) {
            paramxlb = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (azhg.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      axpl.a(i, paramxlb);
      return;
      if (!bool2)
      {
        bjdt.a(paramxlb, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.a(-1, null, 2130772028, 0);
        break;
      }
      this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.a(-1, (Intent)localObject1, 2130772028, 0);
      break;
      label378:
      this.jdField_a_of_type_Wyk.a(paramxlb, this.jdField_a_of_type_Wyk.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wxe.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.b();
    QQToast.a(this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.a(), alud.a(2131704072), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.b();
    QQToast.a(this.jdField_a_of_type_Wyk.jdField_a_of_type_Xby.a(), alud.a(2131704069) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wyl
 * JD-Core Version:    0.7.0.1
 */