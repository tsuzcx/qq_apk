import com.tencent.mobileqq.activity.contacts.base.CardViewController;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;

public class wry
  extends FriendListObserver
{
  public wry(CardViewController paramCardViewController) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "onCancelMayKnowRecommend isCancelRemote =" + CardViewController.a(this.a) + "， isSuccess = " + paramBoolean + ", mState = " + CardViewController.a(this.a));
    }
    if (paramBoolean)
    {
      if (CardViewController.a(this.a))
      {
        CardViewController.a(this.a);
        int i = CardViewController.b(this.a);
        if (QLog.isColorLevel()) {
          QLog.d("CardViewController", 2, "onCancelMayKnowRecommend increaseIgnore times now = " + i);
        }
        CardViewController.a(this.a, paramString, null);
        CardViewController.a(this.a, false);
      }
    }
    else {
      return;
    }
    CardViewController.b(this.a);
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "onGetMayKnowRecommend isSuccess = " + paramBoolean + ", isRefreshingRemote =" + CardViewController.b(this.a) + ", waitingAccountChangeToRefresh =" + CardViewController.c(this.a));
    }
    if (CardViewController.b(this.a)) {
      CardViewController.c(this.a);
    }
    while ((!paramBoolean) || (!CardViewController.c(this.a))) {
      return;
    }
    CardViewController.b(this.a, false);
    CardViewController.a(this.a, false, false);
  }
  
  protected void onMayknowStateChanged(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardViewController", 2, "onMayknowStateChanged isSuccess = " + paramBoolean + ", waitingAccountChangeToRefresh =" + CardViewController.c(this.a));
    }
    if (paramBoolean) {
      CardViewController.a(this.a, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wry
 * JD-Core Version:    0.7.0.1
 */