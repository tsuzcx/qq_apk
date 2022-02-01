import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.vicon.ReadInJoyVIconHelper.1.1;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public final class mrl
  implements ReadInJoyUserInfoModule.a
{
  mrl(long paramLong, KandianUrlImageView paramKandianUrlImageView) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInJoyVIconHelper", 2, "bindVIcon: load fail");
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    QLog.d("ReadInJoyVIconHelper", 2, "bindVIcon: load success");
    if (TextUtils.equals(paramString, String.valueOf(this.wy))) {
      ThreadManager.getUIHandler().post(new ReadInJoyVIconHelper.1.1(this, paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrl
 * JD-Core Version:    0.7.0.1
 */