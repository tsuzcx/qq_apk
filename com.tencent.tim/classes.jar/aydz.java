import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

class aydz
  extends SimpleObserver<ayqb>
{
  aydz(aydy paramaydy) {}
  
  public void b(ayqb paramayqb)
  {
    super.onNext(paramayqb);
    this.this$0.jdField_a_of_type_Ayii.bpm();
    Activity localActivity = this.this$0.jdField_a_of_type_Ayii.getActivity();
    Intent localIntent;
    boolean bool;
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      ram.d("EditPicActivity.EditPicPartManager", "picDestPath = " + paramayqb.a.aAZ);
      localIntent = this.this$0.jdField_a_of_type_Ayii.a(paramayqb);
      if (!paramayqb.a.aIF)
      {
        if (paramayqb.a.aIF) {
          break label280;
        }
        bool = true;
        localIntent.putExtra("extra_is_edited_pic", bool);
      }
      this.this$0.bsq();
      ram.d("EditPicActivity.EditPicPartManager", "subBussinessId = " + this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.RL());
      if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2) {
        switch (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.RL())
        {
        default: 
          if (paramayqb.aQW()) {
            auqv.aY(true, paramayqb.a.aAZ);
          }
          break;
        }
      }
    }
    Object localObject;
    for (;;)
    {
      aydy.b(this.this$0);
      localObject = localIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = localIntent.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject)) || (!bool)) {
        break label320;
      }
      this.this$0.jdField_a_of_type_Ayii.a(-1, localIntent, 2130772067, 0);
      return;
      label280:
      bool = false;
      break;
      auqv.aY(true, paramayqb.a.aAZ);
      continue;
      if (paramayqb.aQW()) {
        auqv.dK(paramayqb.a.aAZ, true);
      }
    }
    label320:
    if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 1)
    {
      this.this$0.jdField_a_of_type_Ayii.getContext().sendBroadcast(new Intent("action_fire_create_story"));
      this.this$0.jdField_a_of_type_Ayii.a(-1, localIntent, 2130772067, 0, true);
      return;
    }
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2) && ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() == 122) || (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() == 133)))
    {
      paramayqb = localIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      aydy.a(this.this$0, localIntent);
      AIOLongShotHelper.a(localActivity, paramayqb, new ayea(this));
      return;
    }
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2) && (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th() == 125))
    {
      this.this$0.jdField_a_of_type_Ayii.a(-1, localIntent, 2130772067, 0, false);
      anot.a(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
      return;
    }
    if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2)
    {
      localObject = this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams;
      if (EditVideoParams.oA(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.th()))
      {
        aydy.a(this.this$0, localIntent);
        anot.a(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
        return;
      }
    }
    if ((this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.asi == 2) && (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aQz()))
    {
      if (!paramayqb.aQW()) {}
      for (bool = true;; bool = false)
      {
        localIntent.putExtra("PhotoConst.SEND_ORIGIN", bool);
        this.this$0.jdField_a_of_type_Ayii.a(-1, localIntent, 2130772067, 0, false);
        return;
      }
    }
    if (localIntent.getBooleanExtra("input_full_screen_mode", false))
    {
      this.this$0.jdField_a_of_type_Ayii.a(-1, localIntent, 2130772067, 0, false);
      return;
    }
    this.this$0.a(localActivity, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), localIntent);
  }
  
  public void onCancel()
  {
    super.onCancel();
    ram.w("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
    this.this$0.jdField_a_of_type_Ayii.bpm();
    QQToast.a(this.this$0.jdField_a_of_type_Ayii.getContext(), acfp.m(2131705453), 0).show();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    this.this$0.d(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aydz
 * JD-Core Version:    0.7.0.1
 */