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

class yod
  extends SimpleObserver<yya>
{
  yod(ynw paramynw, yya paramyya, long paramLong) {}
  
  public void a(yya paramyya)
  {
    super.onNext(paramyya);
    this.jdField_a_of_type_Ynw.o();
    ykq.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ynu)((Iterator)localObject).next()).b(paramyya);
    }
    String str;
    if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      ykv.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (bdax.a().a != 1) {
          break label356;
        }
        i = 1;
        label202:
        bbhl.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (bdax.a().a != 1) {
          break label361;
        }
      }
    }
    label356:
    label361:
    for (int i = 1;; i = 2)
    {
      bbhl.a(i, (String)localObject);
      if (ynw.a(this.jdField_a_of_type_Ynw, paramyya)) {
        ynw.a(this.jdField_a_of_type_Ynw);
      }
      if (this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label366;
      }
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((ynw.a(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEnableMasks, 32768)) && (ynw.b(this.jdField_a_of_type_Ynw) > 0))
    {
      i = ynw.b(this.jdField_a_of_type_Ynw);
      if (!this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.isEditLocal()) {
        break label579;
      }
    }
    label579:
    for (paramyya = "0";; paramyya = "1")
    {
      ykv.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), paramyya });
      this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.b();
      if (!this.jdField_a_of_type_Ynw.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label731;
      }
      paramyya = this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.getActivity();
      if (paramyya == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mEditSource instanceof EditLocalGifSource)) {
        break label609;
      }
      localObject = this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.a(this.jdField_a_of_type_Yya);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label585;
      }
      QZoneHelper.launchQZone(paramyya, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.a(-1, null, 2130772030, 0);
      return;
    }
    label585:
    paramyya.startActivity((Intent)localObject);
    this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.a(-1, null, 2130772030, 0);
    return;
    label609:
    if (this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId() == 1) {
      StoryTransitionActivity.a(paramyya);
    }
    localObject = this.jdField_a_of_type_Yya.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    ykq.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Ynw.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramyya = new Intent();; paramyya = this.jdField_a_of_type_Ynw.jdField_a_of_type_AndroidContentIntent)
    {
      paramyya.putExtra(PublishParam.a, (Parcelable)localObject);
      paramyya.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Ynw.a(paramyya, this.jdField_a_of_type_Ynw.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.getBussinessId(), (PublishParam)localObject);
      return;
    }
    label731:
    paramyya = this.jdField_a_of_type_Ynw.jdField_b_of_type_JavaUtilList.iterator();
    while (paramyya.hasNext()) {
      ykq.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramyya.next());
    }
    QQToast.a(this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.a(), this.jdField_a_of_type_Ynw.jdField_b_of_type_JavaUtilList.size() + anvx.a(2131703231), 0).a();
    paramyya = (yoi)this.jdField_a_of_type_Ynw.a(yoi.class);
    if (paramyya != null) {
      paramyya.i();
    }
    this.jdField_a_of_type_Ynw.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    ykq.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ynu)localIterator.next()).a(paramError);
    }
    ykv.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Ynw.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Ynw.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      ykq.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Ynw.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.b();
      QQToast.a(this.jdField_a_of_type_Ynw.jdField_a_of_type_Ypg.a(), anvx.a(2131703262), 0).a();
      paramError = (yoi)this.jdField_a_of_type_Ynw.a(yoi.class);
    } while (paramError == null);
    paramError.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yod
 * JD-Core Version:    0.7.0.1
 */