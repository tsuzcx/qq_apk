import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class vhl
  implements vhc
{
  vhl(vhk paramvhk) {}
  
  public void a(int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)vhg.a().a().get(paramInt);
    if (localSlideItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(vhk.a(this.a), 2, "slideItem is null, do not jump");
      }
      return;
    }
    int i = vhg.a().a();
    Intent localIntent = new Intent();
    localIntent.putExtra("media_info", localSlideItemInfo.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    localIntent.putExtra("file_send_duration", localSlideItemInfo.jdField_a_of_type_Long);
    localIntent.putExtra("from_slideshow_to_share", true);
    localIntent.putExtra("video_index", paramInt);
    localIntent.putExtra("start_index", localSlideItemInfo.e);
    localIntent.putExtra("end_index", localSlideItemInfo.f);
    localIntent.putExtra("scroll_x", localSlideItemInfo.d);
    if (i == 11)
    {
      paramInt = 0;
      localIntent.putExtra("entrance_type", paramInt);
      if ((!(vhk.a(this.a) instanceof PhotoListActivity)) && (!(vhk.a(this.a) instanceof NewPhotoListActivity))) {
        break label355;
      }
      str = "0";
      label187:
      localIntent.putExtra("op_entrance_type", str);
      localIntent.putExtra("start_time", localSlideItemInfo.b);
      localIntent.putExtra("end_time", localSlideItemInfo.c);
      localIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      localIntent.setClass(vhk.a(this.a), LocalVideoSelectActivity.class);
      vhk.a(this.a).startActivityForResult(localIntent, 24747);
      if (i != 11) {
        break label361;
      }
      paramInt = 0;
      label269:
      if ((!(vhk.a(this.a) instanceof PhotoListActivity)) && (!(vhk.a(this.a) instanceof NewPhotoListActivity))) {
        break label366;
      }
    }
    label355:
    label361:
    label366:
    for (String str = "0";; str = "1")
    {
      urp.a("pic_choose", "clk_cutVideo", paramInt, 0, new String[] { str, localSlideItemInfo.b + "-" + localSlideItemInfo.c });
      return;
      paramInt = 1;
      break;
      str = "1";
      break label187;
      paramInt = 1;
      break label269;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vhl
 * JD-Core Version:    0.7.0.1
 */