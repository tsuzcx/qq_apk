import ProfileLogic.QC.setUserProfileRsp;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.businessCard.activity.CardPicGalleryActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class adzi
  extends aclh
{
  public adzi(CardPicGalleryActivity paramCardPicGalleryActivity) {}
  
  public void aI(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof setUserProfileRsp)))
    {
      i = ((setUserProfileRsp)paramObject).ret;
      if (QLog.isColorLevel()) {
        QLog.d("qqBaseActivity", 2, "mSvipObserver: [setUserProfileRsp] ret=" + i);
      }
      if (i == 0)
      {
        if (this.a.app != null)
        {
          paramObject = new ProfileActivity.AllInOne(this.a.app.getCurrentAccountUin(), 0);
          paramObject.bIZ = 1;
          paramObject.bJa = 8;
          ProfileActivity.b(this.a, paramObject);
          QQToast.a(this.a, 0, 2131721433, 0).show();
        }
        this.a.finish();
      }
    }
    while (!"profilelogic.setUserProfile".equals(paramObject))
    {
      int i;
      return;
      QQToast.a(this.a, 1, 2131721430, 0).show();
      return;
    }
    QQToast.a(this.a, 1, 2131721430, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adzi
 * JD-Core Version:    0.7.0.1
 */