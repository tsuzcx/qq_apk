import android.text.TextUtils;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.qphone.base.util.QLog;

class xqc
  implements URLDrawable.DownloadListener
{
  xqc(xqa paramxqa, URLDrawable paramURLDrawable, MessageForTroopGift paramMessageForTroopGift, xqa.b paramb) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
    {
      acie.i("gift_aio", "fail_obj", this.this$0.sessionInfo.aTl, "", "", "");
      return;
    }
    if (jof.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift)) {}
    for (paramInt = 2;; paramInt = 1)
    {
      anot.a(this.this$0.app, "P_CliOper", "Grp_flower", "", "grp_aio", "objicon_fail", paramInt, 0, this.this$0.sessionInfo.aTl, "", "0", "" + jlk.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), this.this$0.sessionInfo.aTl));
      return;
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    int i;
    if ((this.w.getCurrDrawable() instanceof RegionDrawable))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.objColor;
      if (i != 0) {
        break label136;
      }
      i = -2138570752;
    }
    label136:
    for (;;)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.interactId)) {
        this.this$0.a(((RegionDrawable)this.w.getCurrDrawable()).getBitmap(), i, this.jdField_a_of_type_Xqa$b.l, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "");
      }
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("TroopGiftMsgItemBuilder", 2, "drawable.getCurrDrawable() instanceof  RegionDrawable = " + (this.w.getCurrDrawable() instanceof RegionDrawable));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqc
 * JD-Core Version:    0.7.0.1
 */