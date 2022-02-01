import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;

public class agho
  extends aghl
{
  public agho(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected boolean J(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = apsv.a(this.mApp, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowPauseIcon: current file status[" + paramChatMessage.Status + "]");
      }
    } while ((paramChatMessage.Status != 0) && (paramChatMessage.Status != 1));
    return true;
  }
  
  protected boolean K(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (!(paramChatMessage instanceof MessageForTroopFile));
        paramChatMessage = (MessageForTroopFile)paramChatMessage;
        paramChatMessage = apsv.a(this.mApp, paramChatMessage);
      } while (paramChatMessage == null);
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubblePauseHandler", 1, "needShowResumeIcon: current file status[" + paramChatMessage.Status + "]");
      }
    } while ((paramChatMessage.Status != 3) && (paramChatMessage.Status != 2));
    return true;
  }
  
  protected ImageView a(BaseBubbleBuilder.e parame)
  {
    if (parame == null) {}
    while (!(parame instanceof xlc.a)) {
      return null;
    }
    return ((xlc.a)parame).tn;
  }
  
  protected void a(BaseBubbleBuilder.e parame, ImageView paramImageView)
  {
    if (parame == null) {}
    while (!(parame instanceof xlc.a)) {
      return;
    }
    ((xlc.a)parame).tn = paramImageView;
  }
  
  protected void b(View paramView, BaseBubbleBuilder.e parame, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {}
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
              QLog.i("TroopFileBubblePauseHandler", 1, "handlePauseClick: type[" + paramInt + "]");
            } while (paramInt == -1);
            parame = (MessageForTroopFile)paramChatMessage;
            paramView = TroopFileTransferManager.a(this.mApp, Long.parseLong(paramChatMessage.frienduin));
          } while (paramView == null);
          parame = apsv.a(this.mApp, parame);
        } while (parame == null);
        if (paramInt != 0) {
          break;
        }
      } while ((parame.Status != 0) && (parame.Status != 1));
      anot.a(this.mApp, "dc00898", "", "", "0X800A7F1", "0X800A7F1", 2, 0, "", "", "", "");
      paramView.a(parame.Id);
      return;
    } while ((paramInt != 1) || ((parame.Status != 2) && (parame.Status != 3)));
    anot.a(this.mApp, "dc00898", "", "", "0X800A7F2", "0X800A7F2", 2, 0, "", "", "", "");
    b(new aghp(this, paramChatMessage.frienduin, parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agho
 * JD-Core Version:    0.7.0.1
 */