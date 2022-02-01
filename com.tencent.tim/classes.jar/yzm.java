import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class yzm
  extends acfd
{
  yzm(yzf paramyzf) {}
  
  public void onConversationRecommendTypeChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MayknowRecommendManager.ContactsViewController", 2, "onConversationRecommendTypeChange newType is: " + paramInt);
    }
    yzf.c(this.b, paramInt);
  }
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactsViewController", 2, "onMayKnowEntryStateChanged isSuccess=" + paramBoolean);
    }
    if (paramBoolean) {
      yzf.a(this.b, false, false);
    }
  }
  
  public void onRecommendTroopJoinedOrDeleted(String paramString)
  {
    if ((yzf.a(this.b) instanceof zce)) {
      ((zce)yzf.a(this.b)).onRecommendTroopJoinedOrDeleted(paramString);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ContactsViewController", 2, "onUpdateFriendList. mOccurSwitchAccountChangeTab:" + yzf.b(this.b));
    }
    if (yzf.b(this.b))
    {
      int i = yzf.a(this.b, false);
      if (QLog.isColorLevel()) {
        QLog.i("ContactsViewController", 2, "onUpdateFriendList. mCurrentTabPos:" + yzf.b(this.b) + "  defaultPos:" + i);
      }
      if (yzf.b(this.b) != i)
      {
        yzf.c(this.b, true);
        yzf.b(this.b, i);
        yzf.c(this.b, false);
      }
      yzf.b(this.b, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzm
 * JD-Core Version:    0.7.0.1
 */