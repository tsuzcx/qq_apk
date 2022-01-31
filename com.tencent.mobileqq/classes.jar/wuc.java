import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class wuc
  extends SimpleObserver<xgs>
{
  wuc(wub paramwub, xgs paramxgs) {}
  
  public void a(xgs paramxgs)
  {
    int i = 1;
    super.onNext(paramxgs);
    this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.b();
    if ((!this.jdField_a_of_type_Xgs.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Xgs.a.a)) {
      this.jdField_a_of_type_Wub.jdField_a_of_type_JavaLangString = paramxgs.a.jdField_b_of_type_JavaLangString;
    }
    paramxgs = this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramxgs != null) && (!paramxgs.isFinishing()))
    {
      wsv.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Xgs.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.a(this.jdField_a_of_type_Xgs);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Wub.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramxgs, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramxgs.startActivity((Intent)localObject1);
        paramxgs.setResult(-1);
        paramxgs.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramxgs = (xgs)localObject1;
      if (j != -1)
      {
        paramxgs = (xgs)localObject1;
        if (j != 1)
        {
          paramxgs = (xgs)localObject1;
          if (j != 3000) {
            paramxgs = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (azcx.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      axlc.a(i, paramxgs);
      return;
      if (!bool2)
      {
        bizm.a(paramxgs, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.a(-1, null, 2130772028, 0);
        break;
      }
      this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.a(-1, (Intent)localObject1, 2130772028, 0);
      break;
      label378:
      this.jdField_a_of_type_Wub.a(paramxgs, this.jdField_a_of_type_Wub.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    wsv.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.b();
    QQToast.a(this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.a(), alpo.a(2131704060), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.b();
    QQToast.a(this.jdField_a_of_type_Wub.jdField_a_of_type_Wxp.a(), alpo.a(2131704057) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wuc
 * JD-Core Version:    0.7.0.1
 */