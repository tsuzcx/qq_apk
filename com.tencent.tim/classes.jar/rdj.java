import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.takevideo.EditLocalGifSource;
import com.tencent.biz.qqstory.takevideo.EditLocalPhotoSource;
import com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import com.tencent.biz.qqstory.takevideo.EditRecordVideoSource;
import com.tencent.biz.qqstory.takevideo.EditTakePhotoSource;
import com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class rdj
  extends SimpleObserver<rkm>
{
  rdj(rdc paramrdc, rkm paramrkm, long paramLong) {}
  
  public void b(rkm paramrkm)
  {
    super.onNext(paramrkm);
    this.this$0.checkThread();
    if (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg() == 101) {
      this.this$0.aHd = false;
    }
    if (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg() == 106) {
      this.this$0.aHd = false;
    }
    ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.this$0.lu.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((rdb)((Iterator)localObject).next()).c(paramrkm);
    }
    String str;
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      rar.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.BL), String.valueOf(i) });
      Intent localIntent = this.this$0.jdField_a_of_type_Rel.getActivity().getIntent();
      i = localIntent.getIntExtra("uintype", -1);
      str = "";
      localObject = str;
      if (i != -1)
      {
        localObject = str;
        if (i != 1)
        {
          localObject = str;
          if (i != 3000) {
            localObject = localIntent.getStringExtra("uin");
          }
        }
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (anij.a().dGP != 1) {
          break label396;
        }
        i = 1;
        label242:
        alwx.dB(i, (String)localObject);
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (anij.a().dGP != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      alwx.dA(i, (String)localObject);
      if (rdc.a(this.this$0, paramrkm)) {
        rdc.a(this.this$0);
      }
      if (this.this$0.ar.decrementAndGet() <= 0) {
        break label406;
      }
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      i = 2;
      break label242;
    }
    label406:
    if ((rdc.al(this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.bqp, 32768)) && (rdc.b(this.this$0) > 0))
    {
      i = rdc.b(this.this$0);
      if (!this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.Ld()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      rar.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramrkm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg() == 101) {
        this.this$0.aHd = false;
      }
      this.this$0.jdField_a_of_type_Rel.bpm();
      if (!this.this$0.oC.isEmpty()) {
        break label794;
      }
      paramrkm = this.this$0.jdField_a_of_type_Rel.getActivity();
      if (paramrkm == null) {
        break;
      }
      if (!(this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.this$0.jdField_a_of_type_Rel.a(this.a);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      avpw.a(paramrkm, "", (Intent)localObject, -1);
      this.this$0.jdField_a_of_type_Rel.a(-1, null, 2130772067, 0);
      return;
    }
    label648:
    paramrkm.startActivity((Intent)localObject);
    this.this$0.jdField_a_of_type_Rel.a(-1, null, 2130772067, 0);
    return;
    label672:
    if (this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg() == 1) {
      StoryTransitionActivity.cD(paramrkm);
    }
    localObject = this.a.b;
    ram.d("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.this$0.w == null) {}
    for (paramrkm = new Intent();; paramrkm = this.this$0.w)
    {
      paramrkm.putExtra(PublishParam.BUNDLE_EXTRA_KEY, (Parcelable)localObject);
      paramrkm.putExtra("PUBLISH_STORY", true);
      this.this$0.a(paramrkm, this.this$0.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.tg(), (PublishParam)localObject);
      return;
    }
    label794:
    paramrkm = this.this$0.oC.iterator();
    while (paramrkm.hasNext()) {
      ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramrkm.next());
    }
    QQToast.a(this.this$0.jdField_a_of_type_Rel.getContext(), this.this$0.oC.size() + acfp.m(2131705523), 0).show();
    paramrkm = (rdo)this.this$0.a(rdo.class);
    if (paramrkm != null) {
      paramrkm.play();
    }
    this.this$0.aHd = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ram.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.this$0.lu.iterator();
    while (localIterator.hasNext()) {
      ((rdb)localIterator.next()).c(paramError);
    }
    rar.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.this$0.oC.add(paramError);
    if (this.this$0.ar.decrementAndGet() > 0) {
      ram.w("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.this$0.aHd = false;
      this.this$0.jdField_a_of_type_Rel.bpm();
      QQToast.a(this.this$0.jdField_a_of_type_Rel.getContext(), acfp.m(2131705554), 0).show();
      paramError = (rdo)this.this$0.a(rdo.class);
    } while (paramError == null);
    paramError.play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rdj
 * JD-Core Version:    0.7.0.1
 */