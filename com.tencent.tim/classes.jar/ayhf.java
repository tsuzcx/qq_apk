import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.activity.richmedia.SaveVideoActivity;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ayhf
  extends SimpleObserver<ayqb>
{
  ayhf(aygz paramaygz, long paramLong) {}
  
  public void b(ayqb paramayqb)
  {
    boolean bool = true;
    super.onNext(paramayqb);
    this.this$0.checkThread();
    this.this$0.aHd = false;
    ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject1 = this.this$0.lu.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((aygy)((Iterator)localObject1).next()).c(paramayqb);
    }
    int i;
    if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource)) {
      i = 1;
    }
    for (;;)
    {
      rar.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.BL), String.valueOf(i) });
      rar.b("publish_story", "publish_saveToEntry", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.BL) });
      if (aygz.a(this.this$0, paramayqb)) {
        aygz.a(this.this$0);
      }
      if (this.this$0.ar.decrementAndGet() <= 0) {
        break;
      }
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource)) {
        i = 2;
      } else if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        i = 3;
      } else if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource)) {
        i = 4;
      } else if ((paramayqb.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource)) {
        i = 5;
      } else {
        i = 0;
      }
    }
    if ((aygz.r(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.aCQ, 262144)) && (aygz.b(this.this$0) > 0))
    {
      i = aygz.b(this.this$0);
      if (!this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.Ld()) {
        break label475;
      }
    }
    Object localObject2;
    label475:
    for (localObject1 = "0";; localObject1 = "1")
    {
      rar.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject1 });
      this.this$0.aHd = false;
      this.this$0.jdField_a_of_type_Ayii.bpm();
      if (!this.this$0.oC.isEmpty()) {
        break label1127;
      }
      localObject1 = this.this$0.jdField_a_of_type_Ayii.getActivity();
      if (localObject1 == null) {
        break;
      }
      if (!(this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label506;
      }
      paramayqb = this.this$0.jdField_a_of_type_Ayii.a(paramayqb);
      localObject2 = paramayqb.getStringExtra("PhotoConst.PLUGIN_APK");
      bool = paramayqb.getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(localObject2)) || (!bool)) {
        break label482;
      }
      avpw.a((Activity)localObject1, "", paramayqb, -1);
      this.this$0.jdField_a_of_type_Ayii.a(-1, null, 2130772067, 0);
      return;
    }
    label482:
    ((Activity)localObject1).startActivity(paramayqb);
    this.this$0.jdField_a_of_type_Ayii.a(-1, null, 2130772067, 0);
    return;
    label506:
    if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1) {
      this.this$0.jdField_a_of_type_Ayii.getContext().sendBroadcast(new Intent("action_fire_create_story"));
    }
    do
    {
      do
      {
        for (;;)
        {
          localObject1 = paramayqb.b;
          ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
          localObject2 = this.this$0.jdField_a_of_type_Ayii.a(paramayqb);
          this.this$0.a((Intent)localObject2, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg(), (PublishParam)localObject1, paramayqb.jdField_a_of_type_ComTencentMobileqqTribeTribeVideoPublishParams);
          return;
          if (this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg() == 14)
          {
            ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
            localObject2 = this.this$0.jdField_a_of_type_Ayii.getActivity().getIntent();
            if ((!axcg.am((Intent)localObject2)) || (axcg.au((Intent)localObject2)) || (axcg.at((Intent)localObject2))) {
              break;
            }
            this.this$0.jdField_a_of_type_Ayii.getContext().sendBroadcast(new Intent("action_fire_create_video_story"));
          }
        }
      } while (this.this$0.jdField_a_of_type_Ayia == null);
      this.this$0.jdField_a_of_type_Ayia.d(acfp.m(2131705524), false, 0);
      this.this$0.jdField_a_of_type_Ayia.updateProgress(2);
      this.this$0.jdField_a_of_type_Ayia.updateProgress(5);
      localObject1 = paramayqb.b;
      ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject1);
    } while (this.this$0.jdField_a_of_type_Ayii.getActivity() == null);
    paramayqb = this.this$0.jdField_a_of_type_Ayii.getActivity().getIntent();
    int j;
    if (paramayqb != null)
    {
      j = paramayqb.getIntExtra("sv_total_frame_count", 0);
      i = paramayqb.getIntExtra("sv_total_record_time", 0);
    }
    for (;;)
    {
      Intent localIntent = SaveVideoActivity.a(this.this$0.jdField_a_of_type_Ayii.getContext(), ((PublishParam)localObject1).fakeVid, i, j, this.this$0.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.tg());
      this.this$0.jdField_a_of_type_Ayia.adB(((PublishParam)localObject1).fakeVid);
      i = ((Intent)localObject2).getIntExtra("VIDEO_STORY_FROM_TYPE", axcg.a.getId());
      localIntent.putExtra("mediacodec_encode_enable", true);
      if (((PublishParam)localObject1).bsX != 0)
      {
        localIntent.putExtra("video_edit_flag", bool);
        localIntent.putExtra("thumbfile_send_path", ((PublishParam)localObject1).thumbPath);
        localIntent.putExtra("VIDEO_STORY_FROM_TYPE", i);
        if (paramayqb != null)
        {
          localIntent.putExtra("widgetinfo", paramayqb.getStringExtra("widgetinfo"));
          localObject2 = paramayqb.getStringExtra("key_camera_material_name");
          axiy.i("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + (String)localObject2);
          localIntent.putExtra("key_camera_material_name", (String)localObject2);
          localIntent.putExtra("qqstory_slide_show_scene", paramayqb.getIntExtra("qqstory_slide_show_scene", -1));
        }
        if ((!axcg.l.ob(i)) && (!axcg.k.ob(i))) {
          break label1104;
        }
        this.this$0.jdField_a_of_type_Ayii.getActivity().startActivityForResult(localIntent, 21);
      }
      for (;;)
      {
        this.this$0.jdField_a_of_type_Ayia.az(5, ((PublishParam)localObject1).videoDuration);
        return;
        bool = false;
        break;
        label1104:
        this.this$0.jdField_a_of_type_Ayii.getActivity().startActivityForResult(localIntent, 211);
      }
      label1127:
      paramayqb = this.this$0.oC.iterator();
      while (paramayqb.hasNext()) {
        ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramayqb.next());
      }
      QQToast.a(this.this$0.jdField_a_of_type_Ayii.getContext(), this.this$0.oC.size() + acfp.m(2131705640), 0).show();
      paramayqb = (ayhm)this.this$0.a(ayhm.class);
      if (paramayqb == null) {
        break;
      }
      paramayqb.play();
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    rar.b("publish_story", "publish_saveToEntry", 0, -1, new String[] { paramError.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.BL) });
    this.this$0.d(paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayhf
 * JD-Core Version:    0.7.0.1
 */