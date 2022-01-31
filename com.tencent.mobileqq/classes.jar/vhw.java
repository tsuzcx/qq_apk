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

class vhw
  extends SimpleObserver<vsd>
{
  vhw(vhp paramvhp, vsd paramvsd, long paramLong) {}
  
  public void a(vsd paramvsd)
  {
    super.onNext(paramvsd);
    this.jdField_a_of_type_Vhp.o();
    if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Vhp.jdField_b_of_type_Boolean = false;
    }
    if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Vhp.jdField_b_of_type_Boolean = false;
    }
    veg.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((vhn)((Iterator)localObject).next()).b(paramvsd);
    }
    String str;
    if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      vel.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (axhp.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        avtb.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (axhp.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      avtb.a(i, (String)localObject);
      if (vhp.a(this.jdField_a_of_type_Vhp, paramvsd)) {
        vhp.a(this.jdField_a_of_type_Vhp);
      }
      if (this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      veg.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((vhp.a(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (vhp.b(this.jdField_a_of_type_Vhp) > 0))
    {
      i = vhp.b(this.jdField_a_of_type_Vhp);
      if (!this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      vel.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramvsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Vhp.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.b();
      if (!this.jdField_a_of_type_Vhp.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramvsd = this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.getActivity();
      if (paramvsd == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.a(this.jdField_a_of_type_Vsd);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      bgxy.a(paramvsd, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.a(-1, null, 2130772028, 0);
      return;
    }
    label648:
    paramvsd.startActivity((Intent)localObject);
    this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.a(-1, null, 2130772028, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramvsd);
    }
    localObject = this.jdField_a_of_type_Vsd.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    veg.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Vhp.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramvsd = new Intent();; paramvsd = this.jdField_a_of_type_Vhp.jdField_a_of_type_AndroidContentIntent)
    {
      paramvsd.putExtra(PublishParam.a, (Parcelable)localObject);
      paramvsd.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Vhp.a(paramvsd, this.jdField_a_of_type_Vhp.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramvsd = this.jdField_a_of_type_Vhp.jdField_b_of_type_JavaUtilList.iterator();
    while (paramvsd.hasNext()) {
      veg.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramvsd.next());
    }
    bcpw.a(this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.a(), this.jdField_a_of_type_Vhp.jdField_b_of_type_JavaUtilList.size() + ajyc.a(2131703746), 0).a();
    paramvsd = (vib)this.jdField_a_of_type_Vhp.a(vib.class);
    if (paramvsd != null) {
      paramvsd.k();
    }
    this.jdField_a_of_type_Vhp.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    veg.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vhn)localIterator.next()).a(paramError);
    }
    vel.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Vhp.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Vhp.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      veg.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Vhp.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.b();
      bcpw.a(this.jdField_a_of_type_Vhp.jdField_a_of_type_Vja.a(), ajyc.a(2131703777), 0).a();
      paramError = (vib)this.jdField_a_of_type_Vhp.a(vib.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhw
 * JD-Core Version:    0.7.0.1
 */