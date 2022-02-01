import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ApolloPanel.1.1;
import com.tencent.mobileqq.apollo.view.ApolloPanel.1.2;
import com.tencent.mobileqq.apollo.view.ApolloPanelGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class acah
  extends abyz
{
  public acah(ApolloPanel paramApolloPanel) {}
  
  public void cCN()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "tab download Done");
    }
  }
  
  public void h(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "action res done. action=" + paramApolloActionData.actionId);
    }
    this.this$0.l(paramApolloActionData);
    if (ApolloPanel.a(this.this$0) != null) {
      ApolloPanel.a(this.this$0).n(paramApolloActionData);
    }
  }
  
  public void n(Boolean paramBoolean)
  {
    if ((this.this$0.mBaseChatPie == null) || (this.this$0.mBaseChatPie.app == null)) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        do
        {
          return;
          localMqqHandler = this.this$0.mBaseChatPie.app.getHandler(ChatActivity.class);
        } while (localMqqHandler == null);
        localMqqHandler.post(new ApolloPanel.1.1(this));
        if (!paramBoolean.booleanValue()) {
          break;
        }
        this.this$0.Dj(this.this$0.mBaseChatPie.app.getCurrentAccountUin());
      } while (this.this$0.wY == null);
      this.this$0.wY.clear();
      this.this$0.Ix(this.this$0.bv(ApolloPanel.cuh));
      return;
    } while ((this.this$0.a == null) || (this.this$0.a.awS != 3));
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
    }
    localMqqHandler.post(new ApolloPanel.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acah
 * JD-Core Version:    0.7.0.1
 */