import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class rme
  implements rlv.b
{
  rme(rmd paramrmd) {}
  
  public void xI(int paramInt)
  {
    SlideItemInfo localSlideItemInfo = (SlideItemInfo)rma.a().getPhotoList().get(paramInt);
    if (localSlideItemInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(rmd.a(this.b), 2, "slideItem is null, do not jump");
      }
      return;
    }
    int i = rma.a().tF();
    Intent localIntent = new Intent();
    localIntent.putExtra("media_info", localSlideItemInfo.d);
    localIntent.putExtra("file_send_duration", localSlideItemInfo.mDuration);
    localIntent.putExtra("from_slideshow_to_share", true);
    localIntent.putExtra("video_index", paramInt);
    localIntent.putExtra("start_index", localSlideItemInfo.startIndex);
    localIntent.putExtra("end_index", localSlideItemInfo.endIndex);
    localIntent.putExtra("scroll_x", localSlideItemInfo.scrollX);
    if (i == 11)
    {
      paramInt = 0;
      localIntent.putExtra("entrance_type", paramInt);
      if (!(rmd.a(this.b) instanceof NewPhotoListActivity)) {
        break label329;
      }
      str = "0";
      label174:
      localIntent.putExtra("op_entrance_type", str);
      localIntent.putExtra("start_time", localSlideItemInfo.startTime);
      localIntent.putExtra("end_time", localSlideItemInfo.endTime);
      localIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      localIntent.setClass(rmd.a(this.b), LocalVideoSelectActivity.class);
      rmd.a(this.b).startActivityForResult(localIntent, 24747);
      if (i != 11) {
        break label335;
      }
      paramInt = 0;
      label256:
      if (!(rmd.a(this.b) instanceof NewPhotoListActivity)) {
        break label340;
      }
    }
    label329:
    label335:
    label340:
    for (String str = "0";; str = "1")
    {
      rar.a("pic_choose", "clk_cutVideo", paramInt, 0, new String[] { str, localSlideItemInfo.startTime + "-" + localSlideItemInfo.endTime });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rme
 * JD-Core Version:    0.7.0.1
 */