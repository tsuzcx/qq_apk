import android.text.TextUtils;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.17.1;
import com.tencent.qphone.base.util.QLog;

public class akcl
  implements advm.a
{
  public akcl(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void ei(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDownloadUpdate  url:" + paramString + "   progress:" + paramInt);
    }
  }
  
  public void j(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.this$0.crG)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onDownloadFinish  url:" + paramString + "   isSuccess:" + paramBoolean1 + "  isFileExist:" + paramBoolean2);
    }
    this.this$0.runOnUiThread(new NearbyPeopleProfileActivity.17.1(this, paramString, paramBoolean1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akcl
 * JD-Core Version:    0.7.0.1
 */