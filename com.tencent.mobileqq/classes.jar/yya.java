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

class yya
  extends SimpleObserver<zih>
{
  yya(yxt paramyxt, zih paramzih, long paramLong) {}
  
  public void a(zih paramzih)
  {
    super.onNext(paramzih);
    this.jdField_a_of_type_Yxt.o();
    if (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
      this.jdField_a_of_type_Yxt.jdField_b_of_type_Boolean = false;
    }
    if (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 106) {
      this.jdField_a_of_type_Yxt.jdField_b_of_type_Boolean = false;
    }
    yuk.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
    Object localObject = this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((yxr)((Iterator)localObject).next()).b(paramzih);
    }
    String str;
    if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditRecordVideoSource))
    {
      i = 1;
      yup.b("edit_video", "publish_cost", 0, 0, new String[] { String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(i) });
      Intent localIntent = this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.getActivity().getIntent();
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
      if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
      {
        if (bday.a().a != 1) {
          break label396;
        }
        i = 1;
        label242:
        bbgf.b(i, (String)localObject);
      }
      if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource)) {
        if (bday.a().a != 1) {
          break label401;
        }
      }
    }
    label396:
    label401:
    for (int i = 1;; i = 2)
    {
      bbgf.a(i, (String)localObject);
      if (yxt.a(this.jdField_a_of_type_Yxt, paramzih)) {
        yxt.a(this.jdField_a_of_type_Yxt);
      }
      if (this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() <= 0) {
        break label406;
      }
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
      return;
      if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalVideoSource))
      {
        i = 2;
        break;
      }
      if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakePhotoSource))
      {
        i = 3;
        break;
      }
      if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalPhotoSource))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditTakeVideoSource))
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
    if ((yxt.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.b, 32768)) && (yxt.b(this.jdField_a_of_type_Yxt) > 0))
    {
      i = yxt.b(this.jdField_a_of_type_Yxt);
      if (!this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.d()) {
        break label641;
      }
    }
    label641:
    for (localObject = "0";; localObject = "1")
    {
      yup.a("video_edit", "pub_edit_one", 0, 0, new String[] { String.valueOf(i), localObject });
      if (paramzih.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 101) {
        this.jdField_a_of_type_Yxt.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.b();
      if (!this.jdField_a_of_type_Yxt.jdField_b_of_type_JavaUtilList.isEmpty()) {
        break label793;
      }
      paramzih = this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.getActivity();
      if (paramzih == null) {
        break;
      }
      if (!(this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource instanceof EditLocalGifSource)) {
        break label672;
      }
      localObject = this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.a(this.jdField_a_of_type_Zih);
      str = ((Intent)localObject).getStringExtra("PhotoConst.PLUGIN_APK");
      boolean bool = ((Intent)localObject).getBooleanExtra("DirectBackToQzone", false);
      if ((!"qzone_plugin.apk".equals(str)) || (!bool)) {
        break label648;
      }
      bmtd.a(paramzih, "", (Intent)localObject, -1);
      this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.a(-1, null, 2130772029, 0);
      return;
    }
    label648:
    paramzih.startActivity((Intent)localObject);
    this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.a(-1, null, 2130772029, 0);
    return;
    label672:
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a() == 1) {
      StoryTransitionActivity.a(paramzih);
    }
    localObject = this.jdField_a_of_type_Zih.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
    yuk.b("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + localObject);
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_AndroidContentIntent == null) {}
    for (paramzih = new Intent();; paramzih = this.jdField_a_of_type_Yxt.jdField_a_of_type_AndroidContentIntent)
    {
      paramzih.putExtra(PublishParam.a, (Parcelable)localObject);
      paramzih.putExtra("PUBLISH_STORY", true);
      this.jdField_a_of_type_Yxt.a(paramzih, this.jdField_a_of_type_Yxt.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a(), (PublishParam)localObject);
      return;
    }
    label793:
    paramzih = this.jdField_a_of_type_Yxt.jdField_b_of_type_JavaUtilList.iterator();
    while (paramzih.hasNext()) {
      yuk.c("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", (Error)paramzih.next());
    }
    QQToast.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.a(), this.jdField_a_of_type_Yxt.jdField_b_of_type_JavaUtilList.size() + anzj.a(2131702645), 0).a();
    paramzih = (yyf)this.jdField_a_of_type_Yxt.a(yyf.class);
    if (paramzih != null) {
      paramzih.k();
    }
    this.jdField_a_of_type_Yxt.jdField_b_of_type_Boolean = false;
  }
  
  public void onCancel()
  {
    super.onCancel();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    yuk.e("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error ：" + paramError);
    Iterator localIterator = this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((yxr)localIterator.next()).a(paramError);
    }
    yup.b("video_edit", "pub_error", 0, 0, new String[] { paramError.toString() });
    this.jdField_a_of_type_Yxt.jdField_b_of_type_JavaUtilList.add(paramError);
    if (this.jdField_a_of_type_Yxt.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet() > 0) {
      yuk.d("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
    }
    do
    {
      return;
      this.jdField_a_of_type_Yxt.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.b();
      QQToast.a(this.jdField_a_of_type_Yxt.jdField_a_of_type_Yze.a(), anzj.a(2131702676), 0).a();
      paramError = (yyf)this.jdField_a_of_type_Yxt.a(yyf.class);
    } while (paramError == null);
    paramError.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yya
 * JD-Core Version:    0.7.0.1
 */