import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class yrw
  extends SimpleObserver<zem>
{
  yrw(yrv paramyrv, zem paramzem) {}
  
  public void a(zem paramzem)
  {
    int i = 1;
    super.onNext(paramzem);
    this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.b();
    if ((!this.jdField_a_of_type_Zem.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Zem.a.a)) {
      this.jdField_a_of_type_Yrv.jdField_a_of_type_JavaLangString = paramzem.a.jdField_b_of_type_JavaLangString;
    }
    paramzem = this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramzem != null) && (!paramzem.isFinishing()))
    {
      yqp.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Zem.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.a(this.jdField_a_of_type_Zem);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Yrv.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramzem, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramzem.startActivity((Intent)localObject1);
        paramzem.setResult(-1);
        paramzem.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramzem = (zem)localObject1;
      if (j != -1)
      {
        paramzem = (zem)localObject1;
        if (j != 1)
        {
          paramzem = (zem)localObject1;
          if (j != 3000) {
            paramzem = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (bcig.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      banm.a(i, paramzem);
      return;
      if (!bool2)
      {
        blsb.a(paramzem, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.a(-1, null, 2130772029, 0);
        break;
      }
      this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.a(-1, (Intent)localObject1, 2130772029, 0);
      break;
      label378:
      this.jdField_a_of_type_Yrv.a(paramzem, this.jdField_a_of_type_Yrv.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yqp.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.b();
    QQToast.a(this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.a(), anni.a(2131702469), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.b();
    QQToast.a(this.jdField_a_of_type_Yrv.jdField_a_of_type_Yvj.a(), anni.a(2131702466) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yrw
 * JD-Core Version:    0.7.0.1
 */