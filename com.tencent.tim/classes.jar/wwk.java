import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class wwk
  implements Handler.Callback, wvs
{
  private BaseChatPie c;
  private Handler mHandler;
  
  public wwk(BaseChatPie paramBaseChatPie)
  {
    this.c = paramBaseChatPie;
    this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private boolean Sc()
  {
    if ((aerb.c().stage <= 1) && (xla.bhz)) {
      return !aqvl.e(this.c.app, "have_add_ptt_gray_msg", false);
    }
    return false;
  }
  
  private void a(ChatMessage paramChatMessage, String paramString)
  {
    paramString = new ahwa(paramChatMessage.frienduin, paramChatMessage.selfuin, paramString, this.c.sessionInfo.cZ, -5020, 655392, paramChatMessage.time);
    MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
    if (paramChatMessage.istroop == 1) {
      localMessageForUniteGrayTip.shmsgseq = paramChatMessage.shmsgseq;
    }
    localMessageForUniteGrayTip.initGrayTipMsg(this.c.app, paramString);
    ahwb.a(this.c.app, localMessageForUniteGrayTip);
    QLog.e("vip_ptt.helper", 1, "It is need add gray msg and insert success");
  }
  
  private ChatMessage b()
  {
    List localList = this.c.a.getList();
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (QLog.isColorLevel()) {
        QLog.d("vip_ptt.helper", 1, "SHOW_FIRST:" + localChatMessage.msgtype);
      }
      if (localChatMessage.msgtype != -2002) {
        break label123;
      }
      QLog.e("vip_ptt.helper", 1, "SHOW_FIRST find the ptt msg");
      i = 1;
    }
    label123:
    for (;;)
    {
      break;
      if (i != 0) {
        return (ChatMessage)localList.get(localList.size() - 1);
      }
      return null;
    }
  }
  
  public int[] C()
  {
    return new int[] { 6, 7, 10 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 9: 
    default: 
    case 6: 
    case 7: 
      do
      {
        return;
        QLog.e("vip_ptt.helper", 1, "SHOW_FIRST_BEGIN");
        return;
      } while (!Sc());
      QLog.e("vip_ptt.helper", 1, "It is need add gray msg");
      ChatMessage localChatMessage = b();
      if (localChatMessage == null)
      {
        QLog.e("vip_ptt.helper", 1, "It is need add gray msg,but this aio not ptt msg");
        return;
      }
      this.mHandler.sendMessage(this.mHandler.obtainMessage(10102, localChatMessage));
      return;
    }
    this.mHandler.removeMessages(10102);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    paramMessage = (ChatMessage)paramMessage.obj;
    if (aerb.c().stage <= 1)
    {
      a(paramMessage, acfp.m(2131710174));
      aqvl.f(this.c.app, "have_add_ptt_gray_msg", true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wwk
 * JD-Core Version:    0.7.0.1
 */