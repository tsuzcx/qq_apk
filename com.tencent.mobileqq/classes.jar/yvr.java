import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class yvr
  extends SimpleObserver<zih>
{
  yvr(yvq paramyvq, zih paramzih) {}
  
  public void a(zih paramzih)
  {
    int i = 1;
    super.onNext(paramzih);
    this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.b();
    if ((!this.jdField_a_of_type_Zih.a.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Zih.a.a)) {
      this.jdField_a_of_type_Yvq.jdField_a_of_type_JavaLangString = paramzih.a.jdField_b_of_type_JavaLangString;
    }
    paramzih = this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramzih != null) && (!paramzih.isFinishing()))
    {
      yuk.b("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Zih.a.jdField_b_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.a(this.jdField_a_of_type_Zih);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Yvq.b();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramzih, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramzih.startActivity((Intent)localObject1);
        paramzih.setResult(-1);
        paramzih.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramzih = (zih)localObject1;
      if (j != -1)
      {
        paramzih = (zih)localObject1;
        if (j != 1)
        {
          paramzih = (zih)localObject1;
          if (j != 3000) {
            paramzih = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (bday.a().a != 1) {
        break label401;
      }
    }
    for (;;)
    {
      bbgf.a(i, paramzih);
      return;
      if (!bool2)
      {
        bmtd.a(paramzih, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.a(-1, null, 2130772029, 0);
        break;
      }
      this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.a(-1, (Intent)localObject1, 2130772029, 0);
      break;
      label378:
      this.jdField_a_of_type_Yvq.a(paramzih, this.jdField_a_of_type_Yvq.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    yuk.d("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.b();
    QQToast.a(this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.a(), anzj.a(2131702576), 0).a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.b();
    QQToast.a(this.jdField_a_of_type_Yvq.jdField_a_of_type_Yze.a(), anzj.a(2131702573) + paramError, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvr
 * JD-Core Version:    0.7.0.1
 */