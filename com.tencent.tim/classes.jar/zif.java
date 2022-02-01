import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class zif
  extends Handler
{
  public zif(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.this$0.getActivity() == null) || (this.this$0.getActivity().isFinishing())) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "handleMessage,msg.what:" + paramMessage.what);
          }
          switch (paramMessage.what)
          {
          case 3: 
          case 4: 
          case 10: 
          default: 
            return;
          case 1: 
          case 2: 
            for (;;)
            {
              ChatHistoryTroopMemberFragment.a(this.this$0, paramMessage);
              return;
              this.this$0.hg();
            }
          case 13: 
            paramMessage = this.this$0;
            paramMessage.bw += ChatHistoryTroopMemberFragment.bx;
          }
        } while ((this.this$0.bw <= this.this$0.mProgressBar.getProgress()) || (this.this$0.bw >= 90.0D) || (ChatHistoryTroopMemberFragment.a(this.this$0) <= 0));
        int i = (int)this.this$0.bw;
        int j = (int)(ChatHistoryTroopMemberFragment.a(this.this$0) * this.this$0.bw / 100.0D);
        ChatHistoryTroopMemberFragment.a(this.this$0, j, ChatHistoryTroopMemberFragment.a(this.this$0), i);
        this.this$0.mHandler.sendMessageDelayed(this.this$0.mHandler.obtainMessage(13), 800L);
        return;
        List localList;
        synchronized (this.this$0)
        {
          ChatHistoryTroopMemberFragment.b(this.this$0);
          localList = (List)paramMessage.obj;
          if ((localList == null) && (this.this$0.mFrom != 14)) {
            return;
          }
        }
        if (this.this$0.hi.getVisibility() == 0)
        {
          this.this$0.mHandler.removeMessages(13);
          double d = Math.min(0.9D + paramMessage.arg1 * 1.0D / ChatHistoryTroopMemberFragment.a(this.this$0), 1.0D);
          i = (int)(100.0D * d);
          if (i > this.this$0.mProgressBar.getProgress())
          {
            j = (int)(d * ChatHistoryTroopMemberFragment.a(this.this$0));
            ChatHistoryTroopMemberFragment.a(this.this$0, j, ChatHistoryTroopMemberFragment.a(this.this$0), i);
          }
        }
        if (localList != null) {
          this.this$0.pr.addAll(localList);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.history.BaseFragment", 2, "handleMessage, mJobCount left:" + ChatHistoryTroopMemberFragment.c(this.this$0) + "mATroopMemberList.size():" + this.this$0.pr.size());
        }
        if (ChatHistoryTroopMemberFragment.c(this.this$0) <= 0) {
          ChatHistoryTroopMemberFragment.b(this.this$0, true);
        }
        if ((ChatHistoryTroopMemberFragment.b(this.this$0)) && (ChatHistoryTroopMemberFragment.d(this.this$0)))
        {
          if (this.this$0.pr.isEmpty()) {
            return;
          }
          this.this$0.hg();
          if (QLog.isColorLevel()) {
            QLog.d("Q.history.BaseFragment", 2, "handleMessage real totalTime:" + (System.currentTimeMillis() - ChatHistoryTroopMemberFragment.a(this.this$0)) + "start refreshUI");
          }
          if (this.this$0.app.a() != null) {
            this.this$0.app.a().notifyRefreshTroopMember();
          }
          paramMessage.obj = this.this$0.a.c();
          ChatHistoryTroopMemberFragment.a(this.this$0, paramMessage);
        }
        return;
        this.this$0.hg();
        return;
        if (this.this$0.a != null)
        {
          if (this.this$0.a.ru != null) {
            this.this$0.a.ru.clear();
          }
          this.this$0.a.bSJ();
        }
        if ((this.this$0.G != null) && (this.this$0.G.isShowing())) {
          this.this$0.G.dismiss();
        }
        QQToast.a(this.this$0.getActivity(), this.this$0.getString(2131692496), 0).show(this.this$0.mTitleBar.getHeight());
        ChatHistoryTroopMemberFragment.a(this.this$0);
        return;
        if ((this.this$0.G != null) && (this.this$0.G.isShowing())) {
          this.this$0.G.dismiss();
        }
        QQToast.a(this.this$0.getActivity(), this.this$0.getString(2131692495), 0).show(this.this$0.mTitleBar.getHeight());
        return;
      } while ((this.this$0.G == null) || (!this.this$0.G.isShowing()));
      this.this$0.G.dismiss();
      return;
      paramMessage = (Object[])paramMessage.obj;
      bool = ((Boolean)paramMessage[0]).booleanValue();
      paramMessage = (ArrayList)paramMessage[1];
      ChatSettingForTroop.a(this.this$0.getActivity(), this.this$0.mTroopUin, bool, paramMessage);
      return;
    } while (this.this$0.a == null);
    this.this$0.a.bSJ();
    return;
    paramMessage = (TroopInfo)paramMessage.obj;
    if (paramMessage.troopowneruin != null) {
      this.this$0.aPW = paramMessage.troopowneruin;
    }
    if (paramMessage.Administrator != null) {
      this.this$0.aPX = paramMessage.Administrator;
    }
    ??? = this.this$0;
    if ((this.this$0.app.getCurrentAccountUin().equals(paramMessage.troopowneruin)) || ((this.this$0.aPX != null) && (this.this$0.aPX.contains(this.this$0.app.getCurrentAccountUin()))))
    {
      bool = true;
      label1105:
      ???.bap = bool;
      if ((this.this$0.aPW == null) || (!this.this$0.aPW.equals(this.this$0.app.getCurrentAccountUin()))) {
        break label1182;
      }
    }
    for (this.this$0.aQS = "0"; this.this$0.a != null; this.this$0.aQS = "1")
    {
      label1155:
      this.this$0.a.bSJ();
      return;
      bool = false;
      break label1105;
      label1182:
      if ((this.this$0.aPX == null) || (!this.this$0.aPX.contains(this.this$0.app.getCurrentAccountUin()))) {
        break label1155;
      }
    }
    this.this$0.hi.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zif
 * JD-Core Version:    0.7.0.1
 */