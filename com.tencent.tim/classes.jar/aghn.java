import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class aghn
  extends aghj
{
  public aghn(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  protected boolean I(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    apcy localapcy;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              return false;
            } while (!(paramChatMessage instanceof MessageForTroopFile));
            paramChatMessage = (MessageForTroopFile)paramChatMessage;
            localapcy = apsv.a(this.mApp, paramChatMessage);
          } while ((localapcy == null) || ((paramChatMessage.lastTime != 0L) && (paramChatMessage.lastTime <= NetConnInfoCenter.getServerTime())));
          i = ahav.getFileType(localapcy.FileName);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file status[" + localapcy.Status + "]");
        }
        if ((localapcy.Status != 10) && (localapcy.Status != 9) && (localapcy.Status != 7)) {
          break;
        }
      } while (aqhq.fileExistsAndNotEmpty(localapcy.LocalFile));
      return true;
    } while ((localapcy.Status != 6) || (aqhq.fileExistsAndNotEmpty(localapcy.LocalFile)));
    return true;
  }
  
  protected boolean J(ChatMessage paramChatMessage)
  {
    boolean bool = true;
    if (paramChatMessage == null) {}
    int i;
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
      i = ahav.getFileType(paramChatMessage.FileName);
    } while ((i == 0) || (i == 2));
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleDownloadHandler", 1, "needShowPauseIcon: current file status[" + paramChatMessage.Status + "]");
    }
    if (paramChatMessage.Status == 8) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected CircleFileStateView a(BaseBubbleBuilder.e parame)
  {
    if (parame == null) {}
    while (!(parame instanceof xlc.a)) {
      return null;
    }
    return ((xlc.a)parame).a;
  }
  
  protected void a(View paramView, BaseBubbleBuilder.e parame, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {}
    do
    {
      do
      {
        do
        {
          TroopFileTransferManager localTroopFileTransferManager;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  QLog.i("TroopFileBubbleDownloadHandler", 1, "handlePauseClick: type[" + paramInt + "]");
                } while (paramInt == -1);
                paramView = (MessageForTroopFile)paramChatMessage;
                localTroopFileTransferManager = TroopFileTransferManager.a(this.mApp, Long.parseLong(paramChatMessage.frienduin));
              } while (localTroopFileTransferManager == null);
              parame = apsv.a(this.mApp, paramView);
            } while (parame == null);
            int i = aqiw.getSystemNetwork((Activity)this.mContext);
            if (paramInt != 0) {
              break;
            }
            anot.a(this.mApp, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
            if (i == 0)
            {
              apsd.ck(this.mContext, this.mContext.getString(2131699827));
              return;
            }
          } while (parame.Status != 8);
          localTroopFileTransferManager.d(parame.Id);
          return;
        } while (paramInt != 1);
        anot.a(this.mApp, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
        paramChatMessage = new apca(Long.parseLong(paramChatMessage.frienduin), this.mApp, (Activity)this.mContext);
        if ((parame.Status != 10) && (parame.Status != 9)) {
          break;
        }
      } while (parame.Id == null);
      paramChatMessage.b(parame.Id);
      return;
      if (parame.Status == 7)
      {
        paramChatMessage.i(paramView.url, parame.FileName, parame.ProgressTotal, parame.BusId);
        return;
      }
    } while ((parame.Status != 6) || (aqhq.fileExistsAndNotEmpty(parame.LocalFile)));
    paramChatMessage.i(paramView.url, parame.FileName, parame.ProgressTotal, parame.BusId);
  }
  
  protected void a(BaseBubbleBuilder.e parame, CircleFileStateView paramCircleFileStateView)
  {
    if (parame == null) {}
    while (!(parame instanceof xlc.a)) {
      return;
    }
    ((xlc.a)parame).a = paramCircleFileStateView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aghn
 * JD-Core Version:    0.7.0.1
 */