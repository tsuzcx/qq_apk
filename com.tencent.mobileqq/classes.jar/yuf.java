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

class yuf
  extends SimpleObserver<zem>
{
  yuf(yty paramyty, zem paramzem, long paramLong) {}
  
  public void a(zem paramzem)
  {
    super.onNext(paramzem);
    this.jdField_a_of_type_Yty.o();
    if (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Yty.jdField_b_of_type_Boolean = false;
    }
    if (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Yty.jdField_b_of_type_Boolean = false;
    }
    yqp.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ytw)((Iterator)localObject).next()).b(paramzem);
    }
    String str;
    if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      yqu.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (bcig.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        banm.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (bcig.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      banm.a(i, (String)localObject);
      if (yty.a(this.jdField_a_of_type_Yty, paramzem)) {
        yty.a(this.jdField_a_of_type_Yty);
      }
      if (this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      yqp.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((yty.a(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (yty.b(this.jdField_a_of_type_Yty) > 0))
    {
      i = yty.b(this.jdField_a_of_type_Yty);
      if (!this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      yqu.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramzem.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Yty.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.b();
      if (!this.jdField_a_of_type_Yty.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramzem = this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.getActivity();
      if (paramzem == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.a(this.jdField_a_of_type_Zem);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      blsb.a(paramzem, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.a(-1, null, 2130772029, 0);
      return;
    }
    label648:
    paramzem.startActivity((Intent)localObject);
    this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.a(-1, null, 2130772029, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramzem);
    }
    localObject = this.jdField_a_of_type_Zem.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    yqp.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Yty.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramzem = new Intent();; paramzem = this.jdField_a_of_type_Yty.jdField_a_of_type_AndroidContentIntent)
    {
      paramzem.putExtra(PublishParam.a, (Parcelable)localObject);
      paramzem.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Yty.a(paramzem, this.jdField_a_of_type_Yty.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramzem = this.jdField_a_of_type_Yty.jdField_b_of_type_JavaUtilList.iterator();
    while (paramzem.hasNext()) {
      yqp.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramzem.next());
    }
    QQToast.a(this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.a(), this.jdField_a_of_type_Yty.jdField_b_of_type_JavaUtilList.size() + anni.a(2131702538), 0).a();
    paramzem = (yuk)this.jdField_a_of_type_Yty.a(yuk.class);
    if (paramzem != null) {
      paramzem.k();
    }
    this.jdField_a_of_type_Yty.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yqp.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ytw)localIterator.next()).a(paramError);
    }
    yqu.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Yty.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Yty.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      yqp.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Yty.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.b();
      QQToast.a(this.jdField_a_of_type_Yty.jdField_a_of_type_Yvj.a(), anni.a(2131702569), 0).a();
      paramError = (yuk)this.jdField_a_of_type_Yty.a(yuk.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yuf
 * JD-Core Version:    0.7.0.1
 */