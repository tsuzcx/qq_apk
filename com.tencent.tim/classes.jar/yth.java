import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class yth
  extends acfd
{
  public yth(SystemMsgListView paramSystemMsgListView) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.this$0).refreshData();
    }
  }
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetConnectionsPerson " + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    if (paramBoolean)
    {
      localyrr = SystemMsgListView.a(this.this$0).a();
      if ((localyrr != null) && (localyrr.Ui()) && (localyrr.aCj == paramInt2) && (!SystemMsgListView.a(this.this$0, paramInt2, paramInt3))) {
        SystemMsgListView.a(this.this$0).gs(0L);
      }
    }
    while (paramInt1 != 1205)
    {
      yrr localyrr;
      return;
    }
    SystemMsgListView.a(this.this$0).gs(0L);
  }
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetMayKnowRecommend " + paramBoolean);
    }
    if (paramBoolean) {
      SystemMsgListView.a(this.this$0).refreshData();
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.this$0).refreshData();
    }
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (paramBoolean1)
    {
      paramString = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      paramBundle = paramBundle.getString("extra");
      if (((i == 3006) || (i == 3075)) && ("ContactMatchBuilder".equals(paramBundle))) {
        this.this$0.zk(paramString);
      }
      if (azcl.oD(i)) {
        SystemMsgListView.a(this.this$0).refreshData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yth
 * JD-Core Version:    0.7.0.1
 */