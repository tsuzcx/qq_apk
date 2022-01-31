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
import com.tribe.async.reactive.SimpleObserver;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class uva
  extends SimpleObserver<vfh>
{
  uva(uut paramuut, vfh paramvfh, long paramLong) {}
  
  public void a(vfh paramvfh)
  {
    super.onNext(paramvfh);
    this.jdField_a_of_type_Uut.o();
    if (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Uut.jdField_b_of_type_Boolean = false;
    }
    if (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Uut.jdField_b_of_type_Boolean = false;
    }
    urk.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((uur)((Iterator)localObject).next()).b(paramvfh);
    }
    String str;
    if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      urp.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (awij.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        auts.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (awij.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      auts.a(i, (String)localObject);
      if (uut.a(this.jdField_a_of_type_Uut, paramvfh)) {
        uut.a(this.jdField_a_of_type_Uut);
      }
      if (this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      urk.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((uut.a(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (uut.b(this.jdField_a_of_type_Uut) > 0))
    {
      i = uut.b(this.jdField_a_of_type_Uut);
      if (!this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      urp.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramvfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Uut.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.b();
      if (!this.jdField_a_of_type_Uut.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramvfh = this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.getActivity();
      if (paramvfh == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.a(this.jdField_a_of_type_Vfh);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      bfpr.a(paramvfh, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.a(-1, null, 2130772028, 0);
      return;
    }
    label648:
    paramvfh.startActivity((Intent)localObject);
    this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.a(-1, null, 2130772028, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramvfh);
    }
    localObject = this.jdField_a_of_type_Vfh.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    urk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Uut.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramvfh = new Intent();; paramvfh = this.jdField_a_of_type_Uut.jdField_a_of_type_AndroidContentIntent)
    {
      paramvfh.putExtra(PublishParam.a, (Parcelable)localObject);
      paramvfh.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Uut.a(paramvfh, this.jdField_a_of_type_Uut.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramvfh = this.jdField_a_of_type_Uut.jdField_b_of_type_JavaUtilList.iterator();
    while (paramvfh.hasNext()) {
      urk.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramvfh.next());
    }
    bbmy.a(this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.a(), this.jdField_a_of_type_Uut.jdField_b_of_type_JavaUtilList.size() + ajjy.a(2131637961), 0).a();
    paramvfh = (uvf)this.jdField_a_of_type_Uut.a(uvf.class);
    if (paramvfh != null) {
      paramvfh.k();
    }
    this.jdField_a_of_type_Uut.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    urk.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((uur)localIterator.next()).a(paramError);
    }
    urp.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Uut.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Uut.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      urk.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Uut.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.b();
      bbmy.a(this.jdField_a_of_type_Uut.jdField_a_of_type_Uwe.a(), ajjy.a(2131637992), 0).a();
      paramError = (uvf)this.jdField_a_of_type_Uut.a(uvf.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uva
 * JD-Core Version:    0.7.0.1
 */