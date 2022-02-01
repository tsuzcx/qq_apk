import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;

class rbq
  extends SimpleObserver<rkm>
{
  rbq(rbp paramrbp, rkm paramrkm) {}
  
  public void b(rkm paramrkm)
  {
    int i = 1;
    super.onNext(paramrkm);
    this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.bpm();
    if ((!this.jdField_a_of_type_Rkm.a.aIF) && (this.jdField_a_of_type_Rkm.a.result)) {
      this.jdField_a_of_type_Rbp.picPath = paramrkm.a.aAZ;
    }
    paramrkm = this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.getActivity();
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if ((paramrkm != null) && (!paramrkm.isFinishing()))
    {
      ram.d("EditPicActivity.EditPicPartManager", "picDestPath = " + this.jdField_a_of_type_Rkm.a.aAZ);
      localObject1 = this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.a(this.jdField_a_of_type_Rkm);
      ((Intent)localObject1).putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Rbp.bsq();
      localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool1 = ((Intent)localObject1).getBooleanExtra("DirectBackToQzone", false);
      bool2 = ((Intent)localObject1).getBooleanExtra("go_publish_activity", false);
      boolean bool3 = ((Intent)localObject1).getBooleanExtra("extra_directly_back", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool1)) {
        break label378;
      }
      if (bool3)
      {
        ((Intent)localObject1).setClass(paramrkm, NewPhotoListActivity.class);
        ((Intent)localObject1).addFlags(536870912);
        paramrkm.startActivity((Intent)localObject1);
        paramrkm.setResult(-1);
        paramrkm.finish();
      }
    }
    else
    {
      localObject2 = this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.getActivity().getIntent();
      int j = ((Intent)localObject2).getIntExtra("uintype", -1000);
      localObject1 = "";
      paramrkm = (rkm)localObject1;
      if (j != -1)
      {
        paramrkm = (rkm)localObject1;
        if (j != 1)
        {
          paramrkm = (rkm)localObject1;
          if (j != 3000) {
            paramrkm = ((Intent)localObject2).getStringExtra("uin");
          }
        }
      }
      if (anij.a().dGP != 1) {
        break label401;
      }
    }
    for (;;)
    {
      alwx.dA(i, paramrkm);
      return;
      if (!bool2)
      {
        avpw.a(paramrkm, "", (Intent)localObject1, -1);
        this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.a(-1, null, 2130772067, 0);
        break;
      }
      this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.a(-1, (Intent)localObject1, 2130772067, 0);
      break;
      label378:
      this.jdField_a_of_type_Rbp.a(paramrkm, this.jdField_a_of_type_Rbp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), (Intent)localObject1);
      break;
      label401:
      i = 2;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
    ram.w("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.bpm();
    QQToast.a(this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.getContext(), acfp.m(2131705454), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("EditPicActivity.EditPicPartManager", "PIC PUBLISH error ：" + paramError);
    this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.bpm();
    QQToast.a(this.jdField_a_of_type_Rbp.jdField_a_of_type_Rel.getContext(), acfp.m(2131705451) + paramError, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rbq
 * JD-Core Version:    0.7.0.1
 */