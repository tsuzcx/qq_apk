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

class wwl
  extends SimpleObserver<xgs>
{
  wwl(wwe paramwwe, xgs paramxgs, long paramLong) {}
  
  public void a(xgs paramxgs)
  {
    super.onNext(paramxgs);
    this.jdField_a_of_type_Wwe.o();
    if (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Wwe.jdField_b_of_type_Boolean = false;
    }
    if (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Wwe.jdField_b_of_type_Boolean = false;
    }
    wsv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((wwc)((Iterator)localObject).next()).b(paramxgs);
    }
    String str;
    if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      wta.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (azcx.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        axlc.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (azcx.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      axlc.a(i, (String)localObject);
      if (wwe.a(this.jdField_a_of_type_Wwe, paramxgs)) {
        wwe.a(this.jdField_a_of_type_Wwe);
      }
      if (this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((wwe.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (wwe.b(this.jdField_a_of_type_Wwe) > 0))
    {
      i = wwe.b(this.jdField_a_of_type_Wwe);
      if (!this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      wta.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramxgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Wwe.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.b();
      if (!this.jdField_a_of_type_Wwe.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramxgs = this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.getActivity();
      if (paramxgs == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.a(this.jdField_a_of_type_Xgs);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      bizm.a(paramxgs, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.a(-1, null, 2130772028, 0);
      return;
    }
    label648:
    paramxgs.startActivity((Intent)localObject);
    this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.a(-1, null, 2130772028, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramxgs);
    }
    localObject = this.jdField_a_of_type_Xgs.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    wsv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Wwe.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramxgs = new Intent();; paramxgs = this.jdField_a_of_type_Wwe.jdField_a_of_type_AndroidContentIntent)
    {
      paramxgs.putExtra(PublishParam.a, (Parcelable)localObject);
      paramxgs.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Wwe.a(paramxgs, this.jdField_a_of_type_Wwe.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramxgs = this.jdField_a_of_type_Wwe.jdField_b_of_type_JavaUtilList.iterator();
    while (paramxgs.hasNext()) {
      wsv.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramxgs.next());
    }
    QQToast.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.a(), this.jdField_a_of_type_Wwe.jdField_b_of_type_JavaUtilList.size() + alpo.a(2131704129), 0).a();
    paramxgs = (wwq)this.jdField_a_of_type_Wwe.a(wwq.class);
    if (paramxgs != null) {
      paramxgs.k();
    }
    this.jdField_a_of_type_Wwe.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wsv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((wwc)localIterator.next()).a(paramError);
    }
    wta.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Wwe.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Wwe.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      wsv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Wwe.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.b();
      QQToast.a(this.jdField_a_of_type_Wwe.jdField_a_of_type_Wxp.a(), alpo.a(2131704160), 0).a();
      paramError = (wwq)this.jdField_a_of_type_Wwe.a(wwq.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwl
 * JD-Core Version:    0.7.0.1
 */