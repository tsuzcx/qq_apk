import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.1.1;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView.1.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class lsu
  implements ReadInJoyUserInfoModule.a
{
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.equals(this.afw))) {
      ThreadManager.getUIHandler().post(new ReadInjoyTextView.1.2(this));
    }
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramString != null) && (paramString.equals(this.afw))) {
      ThreadManager.getUIHandler().post(new ReadInjoyTextView.1.1(this, paramReadInJoyUserInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsu
 * JD-Core Version:    0.7.0.1
 */