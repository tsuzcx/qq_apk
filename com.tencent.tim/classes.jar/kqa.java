import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder.1.1;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.b;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class kqa
  implements ReadInJoyUserInfoModule.a
{
  public kqa(ReadInjoyFriendsBiuComponentFragment.b paramb) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2)
  {
    QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, "setComments infoFailed. uin:" + paramString1 + " errMsg:" + paramString2);
  }
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((paramReadInJoyUserInfo != null) && (this.a.mContents != null)) {
      ThreadManager.getUIHandler().post(new ReadInjoyFriendsBiuComponentFragment.ViewHolder.1.1(this));
    }
    if (paramReadInJoyUserInfo != null) {}
    for (paramReadInJoyUserInfo = paramReadInJoyUserInfo.nick;; paramReadInJoyUserInfo = "null")
    {
      QLog.d("ReadInjoyFriendsBiuComponentFragment", 1, new Object[] { "setComments infoSuccess nick = ", paramReadInJoyUserInfo, "  uin:" + paramString, " mContents:" + this.a.mContents });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kqa
 * JD-Core Version:    0.7.0.1
 */