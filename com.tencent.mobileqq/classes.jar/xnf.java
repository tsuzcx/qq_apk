import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class xnf
  implements xmw
{
  xnf(xne paramxne) {}
  
  public void a(int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)xna.a().a().get(paramInt);
    if (localSlideItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(xne.a(this.a), 2, "slideItem is null, do not jump");
      }
      return;
    }
    int i = xna.a().a();
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
      if (!(xne.a(this.a) instanceof NewPhotoListActivity)) {
        break label329;
      }
      str = "0";
      label174:
      localIntent.putExtra("op_entrance_type", str);
      localIntent.putExtra("start_time", localSlideItemInfo.b);
      localIntent.putExtra("end_time", localSlideItemInfo.c);
      localIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      localIntent.setClass(xne.a(this.a), LocalVideoSelectActivity.class);
      xne.a(this.a).startActivityForResult(localIntent, 24747);
      if (i != 11) {
        break label335;
      }
      paramInt = 0;
      label256:
      if (!(xne.a(this.a) instanceof NewPhotoListActivity)) {
        break label340;
      }
    }
    label329:
    label335:
    label340:
    for (String str = "0";; str = "1")
    {
      wxj.a("pic_choose", "clk_cutVideo", paramInt, 0, new String[] { str, localSlideItemInfo.b + "-" + localSlideItemInfo.c });
      return;
      paramInt = 1;
      break;
      str = "1";
      break label174;
      paramInt = 1;
      break label256;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */