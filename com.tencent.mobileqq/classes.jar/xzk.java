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
import cooperation.qzone.QZoneHelper;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class xzk
  extends SimpleObserver<yjh>
{
  xzk(xzd paramxzd, yjh paramyjh, long paramLong) {}
  
  public void a(yjh paramyjh)
  {
    super.onNext(paramyjh);
    this.jdField_a_of_type_Xzd.o();
    xvv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((xzb)((Iterator)localObject).next()).b(paramyjh);
    }
    String str;
    if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      xwa.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (bbuc.a().a != 1) {
          break label356;
        }
        i = 1;
        label202:
        babc.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (bbuc.a().a != 1) {
          break label361;
        }
      }
    }
    label356:
    label361:
    for (int i = 1;; i = 2)
    {
      babc.a(i, (String)localObject);
      if (xzd.a(this.jdField_a_of_type_Xzd, paramyjh)) {
        xzd.a(this.jdField_a_of_type_Xzd);
      }
      if (this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label366;
      }
      xvv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        i = 5;
        break;
      }
      i = 0;
      break;
      i = 2;
      break label202;
    }
    label366:
    if ((xzd.a(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEnableMasks, 32768)) && (xzd.b(this.jdField_a_of_type_Xzd) > 0))
    {
      i = xzd.b(this.jdField_a_of_type_Xzd);
      if (!this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocal()) {
        break label579;
      }
    }
    label579:
    for (paramyjh = "0";; paramyjh = "1")
    {
      xwa.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), paramyjh });
      this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.b();
      if (!this.jdField_a_of_type_Xzd.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label731;
      }
      paramyjh = this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.getActivity();
      if (paramyjh == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalGifSource)) {
        break label609;
      }
      localObject = this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.a(this.jdField_a_of_type_Yjh);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label585;
      }
      QZoneHelper.launchQZone(paramyjh, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.a(-1, null, 2130772030, 0);
      return;
    }
    label585:
    paramyjh.startActivity((Intent)localObject);
    this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.a(-1, null, 2130772030, 0);
    return;
    label609:
    if (this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId() == 1) {
      StoryTransitionActivity.a(paramyjh);
    }
    localObject = this.jdField_a_of_type_Yjh.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    xvv.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Xzd.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramyjh = new Intent();; paramyjh = this.jdField_a_of_type_Xzd.jdField_a_of_type_AndroidContentIntent)
    {
      paramyjh.putExtra(PublishParam.a, (Parcelable)localObject);
      paramyjh.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Xzd.a(paramyjh, this.jdField_a_of_type_Xzd.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId(), (PublishParam)localObject);
      return;
    }
    label731:
    paramyjh = this.jdField_a_of_type_Xzd.jdField_b_of_type_JavaUtilList.iterator();
    while (paramyjh.hasNext()) {
      xvv.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramyjh.next());
    }
    QQToast.a(this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.a(), this.jdField_a_of_type_Xzd.jdField_b_of_type_JavaUtilList.size() + amtj.a(2131702880), 0).a();
    paramyjh = (xzp)this.jdField_a_of_type_Xzd.a(xzp.class);
    if (paramyjh != null) {
      paramyjh.i();
    }
    this.jdField_a_of_type_Xzd.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    xvv.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((xzb)localIterator.next()).a(paramError);
    }
    xwa.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Xzd.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Xzd.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      xvv.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Xzd.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.b();
      QQToast.a(this.jdField_a_of_type_Xzd.jdField_a_of_type_Yan.a(), amtj.a(2131702911), 0).a();
      paramError = (xzp)this.jdField_a_of_type_Xzd.a(xzp.class);
    } while (paramError == null);
    paramError.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzk
 * JD-Core Version:    0.7.0.1
 */