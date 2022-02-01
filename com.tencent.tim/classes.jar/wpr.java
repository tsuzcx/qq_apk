import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class wpr
  extends Handler
{
  public wpr(ListenChangeVoicePanel paramListenChangeVoicePanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    switch (???.what)
    {
    case 102: 
    default: 
    case 101: 
    case 103: 
    case 104: 
    case 105: 
    case 106: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                ListenChangeVoicePanel.a(this.this$0, -1);
                this.this$0.jdField_a_of_type_Wpo.bQb = 0;
                this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = null;
                synchronized (this.this$0.qn)
                {
                  this.this$0.jdField_a_of_type_Wpo.qe = this.this$0.qn;
                  this.this$0.jdField_a_of_type_Wpo.notifyDataSetChanged();
                  return;
                }
              } while ((???.obj == null) || (!(???.obj instanceof Bundle)) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null));
              ??? = (Bundle)???.obj;
            } while (??? == null);
            this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.as(???.getInt("progress"), ???.getInt("playTime"), ???.getInt("level"));
            return;
          } while (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null);
          this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.Cu(1);
          return;
          if (ListenChangeVoicePanel.a(this.this$0).get() != null) {
            QQToast.a(((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getApp(), "播放变音error", 0);
          }
        } while (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.Cu(1);
        return;
      } while ((ListenChangeVoicePanel.a(this.this$0).get() == null) || (this.this$0.dq.get() == null));
      aqxp.a(((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).getApp(), ListenChangeVoicePanel.a(this.this$0), PressToChangeVoicePanel.GW, this.this$0);
      int k = (int)ListenChangeVoicePanel.a(this.this$0);
      String str;
      QQRecorder.RecorderParam localRecorderParam;
      if (!alit.a((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get()).a((BaseChatPie)this.this$0.dq.get(), ListenChangeVoicePanel.a(this.this$0)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "presend not hit, do origin logic");
        }
        ??? = (BaseChatPie)this.this$0.dq.get();
        str = ListenChangeVoicePanel.a(this.this$0);
        localRecorderParam = ListenChangeVoicePanel.a(this.this$0);
        if (ListenChangeVoicePanel.a(this.this$0) <= 0) {
          break label677;
        }
      }
      label677:
      for (int i = 1;; i = 0)
      {
        ???.a(str, 4, 0, localRecorderParam, i, false, 0);
        ((BaseChatPie)this.this$0.dq.get()).f(ListenChangeVoicePanel.a(this.this$0), null);
        if (ListenChangeVoicePanel.jdField_a_of_type_Alik != null)
        {
          ListenChangeVoicePanel.jdField_a_of_type_Alik.F((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get(), ListenChangeVoicePanel.a(this.this$0));
          if (ListenChangeVoicePanel.a(this.this$0) > 0) {
            anot.a((QQAppInterface)ListenChangeVoicePanel.a(this.this$0).get(), "CliOper", "", "", "changevoice", "0X8006F7C", 0, 0, "" + ((BaseChatPie)this.this$0.dq.get()).sessionInfo.cZ, "" + ListenChangeVoicePanel.a(this.this$0), "", "");
          }
        }
        this.this$0.reset();
        int j = ListenChangeVoicePanel.b(this.this$0);
        i = j;
        if (this.this$0.bfa) {
          i = j + 10;
        }
        j = ListenChangeVoicePanel.a(this.this$0);
        int m = ListenChangeVoicePanel.c(this.this$0);
        this.this$0.B(j, m, k, i);
        return;
      }
    }
    this.this$0.a(???.arg1, ???.arg2, ???.obj, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wpr
 * JD-Core Version:    0.7.0.1
 */