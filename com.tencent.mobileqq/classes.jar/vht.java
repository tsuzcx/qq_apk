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

class vht
  extends SimpleObserver<vsa>
{
  vht(vhm paramvhm, vsa paramvsa, long paramLong) {}
  
  public void a(vsa paramvsa)
  {
    super.onNext(paramvsa);
    this.jdField_a_of_type_Vhm.o();
    if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Vhm.jdField_b_of_type_Boolean = false;
    }
    if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Vhm.jdField_b_of_type_Boolean = false;
    }
    ved.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((vhk)((Iterator)localObject).next()).b(paramvsa);
    }
    String str;
    if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      vei.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (axhr.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        avtd.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (axhr.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      avtd.a(i, (String)localObject);
      if (vhm.a(this.jdField_a_of_type_Vhm, paramvsa)) {
        vhm.a(this.jdField_a_of_type_Vhm);
      }
      if (this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      ved.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((vhm.a(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (vhm.b(this.jdField_a_of_type_Vhm) > 0))
    {
      i = vhm.b(this.jdField_a_of_type_Vhm);
      if (!this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      vei.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramvsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Vhm.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.b();
      if (!this.jdField_a_of_type_Vhm.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramvsa = this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.getActivity();
      if (paramvsa == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.a(this.jdField_a_of_type_Vsa);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      bgyp.a(paramvsa, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.a(-1, null, 2130772028, 0);
      return;
    }
    label648:
    paramvsa.startActivity((Intent)localObject);
    this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.a(-1, null, 2130772028, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramvsa);
    }
    localObject = this.jdField_a_of_type_Vsa.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    ved.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Vhm.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramvsa = new Intent();; paramvsa = this.jdField_a_of_type_Vhm.jdField_a_of_type_AndroidContentIntent)
    {
      paramvsa.putExtra(PublishParam.a, (Parcelable)localObject);
      paramvsa.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Vhm.a(paramvsa, this.jdField_a_of_type_Vhm.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramvsa = this.jdField_a_of_type_Vhm.jdField_b_of_type_JavaUtilList.iterator();
    while (paramvsa.hasNext()) {
      ved.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramvsa.next());
    }
    bcql.a(this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.a(), this.jdField_a_of_type_Vhm.jdField_b_of_type_JavaUtilList.size() + ajya.a(2131703757), 0).a();
    paramvsa = (vhy)this.jdField_a_of_type_Vhm.a(vhy.class);
    if (paramvsa != null) {
      paramvsa.k();
    }
    this.jdField_a_of_type_Vhm.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ved.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((vhk)localIterator.next()).a(paramError);
    }
    vei.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Vhm.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Vhm.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      ved.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Vhm.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.b();
      bcql.a(this.jdField_a_of_type_Vhm.jdField_a_of_type_Vix.a(), ajya.a(2131703788), 0).a();
      paramError = (vhy)this.jdField_a_of_type_Vhm.a(vhy.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vht
 * JD-Core Version:    0.7.0.1
 */