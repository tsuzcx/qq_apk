import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class gfh
  implements View.OnClickListener
{
  private static final long jdField_a_of_type_Long = 1000L;
  private long b = 0L;
  
  public gfh(QzonePhotoView paramQzonePhotoView) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.b) < 1000L) {}
    do
    {
      do
      {
        do
        {
          return;
          this.b = l;
        } while ((paramView == null) || (!(paramView.getTag() instanceof DataTag)));
        paramView = (DataTag)paramView.getTag();
      } while (paramView == null);
      int i = paramView.C;
      paramView = QzonePhotoView.a(this.a).a.a;
      switch (i)
      {
      default: 
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ProfileCard.QzonePhotoView", 2, "View.OnClickListener click type is photo wall view");
      }
      paramView = this.a.a();
    } while (paramView == null);
    paramView.type = "PhotoWallCover";
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
    localUserInfo.a = this.a.a.a();
    localUserInfo.b = this.a.a.e();
    localUserInfo.c = this.a.a.getSid();
    QZoneHelper.b(QzonePhotoView.a(this.a), localUserInfo, paramView, 1008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gfh
 * JD-Core Version:    0.7.0.1
 */