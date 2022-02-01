import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class agjs
{
  private MessageForTroopFile c;
  public boolean cdE = true;
  private MessageForFile d;
  protected SessionInfo h;
  public QQAppInterface mApp;
  protected Context mContext;
  private ChatMessage r;
  private ChatMessage s;
  
  public agjs(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.h = paramSessionInfo;
  }
  
  private ChatMessage d(ChatMessage paramChatMessage)
  {
    int i = -2005;
    Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    if ((paramChatMessage.isMultiMsg) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.i("QFileBubbleModel", 1, "getRealChatMessage log, fileType[" + (String)localObject + "]");
      int j = Integer.parseInt((String)localObject);
      if (j == 3)
      {
        if (this.c == null) {
          this.c = ((MessageForTroopFile)anbi.d(-2017));
        }
        ahav.U(this.c);
        localObject = this.c;
        ((ChatMessage)localObject).isMultiMsg = paramChatMessage.isMultiMsg;
        ((ChatMessage)localObject).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        ((ChatMessage)localObject).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        ahav.a(paramChatMessage, this.c);
        ((ChatMessage)localObject).istroop = 1;
        if ((j == 1) || (j == 2)) {
          ahav.a(this.mApp, ((ChatMessage)localObject).uniseq, ((ChatMessage)localObject).frienduin, ((ChatMessage)localObject).istroop, paramChatMessage);
        }
        return localObject;
      }
      if ((j == 1) || (j == 2))
      {
        if (j == 1) {}
        for (;;)
        {
          if (this.d == null) {
            this.d = ((MessageForFile)anbi.d(i));
          }
          ahav.U(this.d);
          localObject = this.d;
          ((ChatMessage)localObject).isMultiMsg = paramChatMessage.isMultiMsg;
          ((ChatMessage)localObject).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          ((ChatMessage)localObject).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          ahbr.a(this.mApp, (MessageRecord)localObject, paramChatMessage);
          ahav.a(paramChatMessage, this.d);
          break;
          i = -2014;
        }
      }
      QLog.e("QFileBubbleModel", 1, "getRealChatMessage error, not support fileType. fileType[" + (String)localObject + "] extInfo[" + paramChatMessage.extStr + "]");
      return (ChatMessage)anbi.d(-2005);
    }
    QLog.e("QFileBubbleModel", 1, "getRealChatMessage error, not exist fileType. isMultiMsg[" + paramChatMessage.isMultiMsg + "] extInfo[" + paramChatMessage.extStr + "]");
    return (ChatMessage)anbi.d(-2005);
  }
  
  public abstract int Eh();
  
  public abstract int Ei();
  
  public abstract int Ej();
  
  public abstract int Ek();
  
  public int El()
  {
    return 0;
  }
  
  protected void N(ChatMessage paramChatMessage)
  {
    this.mApp.b().t(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = this.mApp.a().y(paramChatMessage.frienduin, paramChatMessage.uniseq);
      this.mApp.a().oy(paramChatMessage);
    }
  }
  
  public abstract void NU(int paramInt);
  
  protected abstract void R(ChatMessage paramChatMessage);
  
  public void S(ChatMessage paramChatMessage)
  {
    this.r = paramChatMessage;
    if (this.r.isMultiMsg) {}
    for (this.s = d(paramChatMessage);; this.s = paramChatMessage)
    {
      R(this.s);
      return;
    }
  }
  
  public abstract aghj a();
  
  public abstract aghl a();
  
  public abstract List<Integer> ab(int paramInt);
  
  public abstract List<Integer> ac(int paramInt);
  
  public abstract boolean alo();
  
  public boolean alp()
  {
    return false;
  }
  
  public boolean alq()
  {
    return false;
  }
  
  public abstract int bF();
  
  public ChatMessage d()
  {
    return this.s;
  }
  
  public abstract void dgX();
  
  public void dgY() {}
  
  public void dha() {}
  
  public void dhd() {}
  
  protected void dhe()
  {
    this.cdE = false;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QFileBubbleModel.1(this), 1000L);
  }
  
  public long fE()
  {
    return 0L;
  }
  
  public abstract String getFileName();
  
  public abstract long getFileSize();
  
  public void ia(int paramInt1, int paramInt2) {}
  
  public abstract void u(int paramInt, View paramView);
  
  public abstract String uZ();
  
  public String va()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjs
 * JD-Core Version:    0.7.0.1
 */