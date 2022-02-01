import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.VideoFileSaveRunnable;
import com.tencent.mobileqq.widget.QQToast;
import mqq.os.MqqHandler;

class mwv
  implements ausj.a
{
  mwv(mwq parammwq, ausj paramausj, String paramString1, MessageForShortVideo paramMessageForShortVideo, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_c_of_type_Ausj.dismiss();
    paramView = this.jdField_c_of_type_Ausj.getContent(paramInt);
    if (paramView != null)
    {
      if (!paramView.equals(this.akz)) {
        break label91;
      }
      if (mwq.a(this.b) != null) {
        mwq.a(this.b, mwq.a(this.b));
      }
      mwq.a(this.b, "0", "0", "0", this.jdField_c_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_c_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
    }
    label91:
    do
    {
      return;
      if (paramView.equals(this.akA))
      {
        mwq.a(this.b, "click menu to share to qzone, finalVideoExists=" + this.apT);
        if (this.apT)
        {
          paramView = avpw.d.a();
          avpw.c(mwq.a(this.b), paramView, this.val$videoPath, 10001);
          mwq.a(this.b).oB(mwq.b(this.b));
        }
        for (;;)
        {
          mwq.a(this.b, "0", "1", "0", this.jdField_c_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5(), "0", this.jdField_c_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime, 0L, 0, -1, 0, null, true);
          return;
          QQToast.a(mwq.a(this.b), 0, 2131720229, 0).show(mwq.a(this.b).getResources().getDimensionPixelSize(2131299627));
        }
      }
      if (paramView.equals(this.akB))
      {
        if (!this.apT)
        {
          QQToast.a(mwq.a(this.b), 0, 2131720229, 0).show(mwq.a(this.b).getResources().getDimensionPixelSize(2131299627));
          return;
        }
        ThreadManager.getFileThreadHandler().post(new ShortVideoUtils.VideoFileSaveRunnable(this.val$videoPath, mwq.a(this.b), this.jdField_c_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + ".mp4", false));
        return;
      }
    } while (!paramView.equals(this.akC));
    if (!this.apT)
    {
      QQToast.a(mwq.a(this.b), 0, 2131720229, 0).show(mwq.a(this.b).getResources().getDimensionPixelSize(2131299627));
      return;
    }
    paramView = new Intent("android.intent.action.VIEW");
    paramView.setDataAndType(Uri.parse("file://" + this.val$videoPath), "video/*");
    paramView.putExtra("big_brother_source_key", kxm.bg(0));
    mwq.a(this.b).startActivity(paramView);
    mwq.a(this.b).oB(mwq.b(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwv
 * JD-Core Version:    0.7.0.1
 */