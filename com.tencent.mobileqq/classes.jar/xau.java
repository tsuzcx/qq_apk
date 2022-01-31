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

class xau
  extends SimpleObserver<xlb>
{
  xau(xan paramxan, xlb paramxlb, long paramLong) {}
  
  public void a(xlb paramxlb)
  {
    super.onNext(paramxlb);
    this.jdField_a_of_type_Xan.o();
    if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Xan.jdField_b_of_type_Boolean = false;
    }
    if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Xan.jdField_b_of_type_Boolean = false;
    }
    wxe.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((xal)((Iterator)localObject).next()).b(paramxlb);
    }
    String str;
    if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      wxj.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (azhg.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        axpl.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (azhg.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      axpl.a(i, (String)localObject);
      if (xan.a(this.jdField_a_of_type_Xan, paramxlb)) {
        xan.a(this.jdField_a_of_type_Xan);
      }
      if (this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((xan.a(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (xan.b(this.jdField_a_of_type_Xan) > 0))
    {
      i = xan.b(this.jdField_a_of_type_Xan);
      if (!this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      wxj.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramxlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Xan.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.b();
      if (!this.jdField_a_of_type_Xan.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramxlb = this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.getActivity();
      if (paramxlb == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.a(this.jdField_a_of_type_Xlb);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      bjdt.a(paramxlb, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.a(-1, null, 2130772028, 0);
      return;
    }
    label648:
    paramxlb.startActivity((Intent)localObject);
    this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.a(-1, null, 2130772028, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramxlb);
    }
    localObject = this.jdField_a_of_type_Xlb.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    wxe.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramxlb = new Intent();; paramxlb = this.jdField_a_of_type_Xan.jdField_a_of_type_AndroidContentIntent)
    {
      paramxlb.putExtra(PublishParam.a, (Parcelable)localObject);
      paramxlb.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Xan.a(paramxlb, this.jdField_a_of_type_Xan.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramxlb = this.jdField_a_of_type_Xan.jdField_b_of_type_JavaUtilList.iterator();
    while (paramxlb.hasNext()) {
      wxe.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramxlb.next());
    }
    QQToast.a(this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.a(), this.jdField_a_of_type_Xan.jdField_b_of_type_JavaUtilList.size() + alud.a(2131704141), 0).a();
    paramxlb = (xaz)this.jdField_a_of_type_Xan.a(xaz.class);
    if (paramxlb != null) {
      paramxlb.k();
    }
    this.jdField_a_of_type_Xan.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    wxe.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xal)localIterator.next()).a(paramError);
    }
    wxj.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Xan.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Xan.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      wxe.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Xan.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.b();
      QQToast.a(this.jdField_a_of_type_Xan.jdField_a_of_type_Xby.a(), alud.a(2131704172), 0).a();
      paramError = (xaz)this.jdField_a_of_type_Xan.a(xaz.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xau
 * JD-Core Version:    0.7.0.1
 */