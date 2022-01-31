import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceListAdapter;
import com.tencent.mobileqq.activity.aio.audiopanel.ChangeVoiceView;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.PttVoiceChangePreSender;
import com.tencent.mobileqq.ptt.preop.PttPreSendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.voicechange.VoiceChangeManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class uut
  extends Handler
{
  public uut(ListenChangeVoicePanel paramListenChangeVoicePanel, Looper paramLooper)
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
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              ListenChangeVoicePanel.a(this.a, -1);
              this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.b = 0;
              this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView = null;
              synchronized (this.a.b)
              {
                this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.a = this.a.b;
                this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceListAdapter.notifyDataSetChanged();
                return;
              }
            } while ((???.obj == null) || (!(???.obj instanceof Bundle)) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null));
            ??? = (Bundle)???.obj;
          } while (??? == null);
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(???.getInt("progress"), ???.getInt("playTime"), ???.getInt("level"));
          return;
        } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
        return;
        QQToast.a(ListenChangeVoicePanel.a(this.a).getApp(), "播放变音error", 0);
      } while (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView == null);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelChangeVoiceView.a(1);
      return;
    case 106: 
      VoiceChangeManager.a(ListenChangeVoicePanel.a(this.a).getApp(), ListenChangeVoicePanel.a(this.a), PressToChangeVoicePanel.a, this.a);
      int k = (int)ListenChangeVoicePanel.a(this.a);
      String str;
      QQRecorder.RecorderParam localRecorderParam;
      if (!PttPreSendManager.a(ListenChangeVoicePanel.a(this.a)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, ListenChangeVoicePanel.a(this.a)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttPreSendManager", 2, "presend not hit, do origin logic");
        }
        ??? = this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
        str = ListenChangeVoicePanel.a(this.a);
        localRecorderParam = ListenChangeVoicePanel.a(this.a);
        if (ListenChangeVoicePanel.a(this.a) <= 0) {
          break label583;
        }
      }
      label583:
      for (int i = 1;; i = 0)
      {
        ???.a(str, 4, 0, localRecorderParam, i, false);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(ListenChangeVoicePanel.a(this.a), null);
        if (ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender != null)
        {
          ListenChangeVoicePanel.jdField_a_of_type_ComTencentMobileqqPttPttVoiceChangePreSender.a(ListenChangeVoicePanel.a(this.a), ListenChangeVoicePanel.a(this.a));
          if (ListenChangeVoicePanel.a(this.a) > 0) {
            ReportController.b(ListenChangeVoicePanel.a(this.a), "CliOper", "", "", "changevoice", "0X8006F7C", 0, 0, "" + this.a.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.a, "" + ListenChangeVoicePanel.a(this.a), "", "");
          }
        }
        this.a.i();
        int j = ListenChangeVoicePanel.b(this.a);
        i = j;
        if (this.a.jdField_a_of_type_Boolean) {
          i = j + 10;
        }
        j = ListenChangeVoicePanel.a(this.a);
        int m = ListenChangeVoicePanel.c(this.a);
        this.a.a(j, m, k, i);
        return;
      }
    }
    this.a.a(???.arg1, ???.arg2, ???.obj, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uut
 * JD-Core Version:    0.7.0.1
 */