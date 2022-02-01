import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.widget.CircleFileStateView;
import com.tencent.qphone.base.util.QLog;

public class aghf
  extends aghj
{
  public aghf(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean g(FileManagerEntity paramFileManagerEntity)
  {
    return ((paramFileManagerEntity.nOpType == 7) || (paramFileManagerEntity.nOpType == 28) || (paramFileManagerEntity.nOpType == 21) || (paramFileManagerEntity.nOpType == 22) || (paramFileManagerEntity.nOpType == 3) || (paramFileManagerEntity.nOpType == 24) || (paramFileManagerEntity.nOpType == 25)) && ((paramFileManagerEntity.status == 1) || (paramFileManagerEntity.status == -1));
  }
  
  private boolean h(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nOpType != 1) {}
    while ((paramFileManagerEntity.status != -1) && (paramFileManagerEntity.status != 3) && (paramFileManagerEntity.status != 0) && (paramFileManagerEntity.status != 13)) {
      return false;
    }
    return true;
  }
  
  private boolean i(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity.nOpType != 0) {}
    while ((paramFileManagerEntity.status != 1) && (paramFileManagerEntity.status != -1)) {
      return false;
    }
    if (!aqhq.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath())) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected boolean I(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForFile))) {}
    boolean bool;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            return false;
            paramChatMessage = (MessageForFile)paramChatMessage;
            paramChatMessage = ahav.a(this.mApp, paramChatMessage);
          } while (paramChatMessage == null);
          i = ahav.getFileType(paramChatMessage.fileName);
        } while ((i == 0) || (i == 2));
        if (QLog.isColorLevel()) {
          QLog.i("OfflineFileBubbleDownloadHandler", 1, "needShowDownloadIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "] fileName[" + paramChatMessage.fileName + "] uniseq[" + paramChatMessage.uniseq + "]");
        }
      } while (16 == paramChatMessage.status);
      if (((paramChatMessage.nOpType != -1) || (paramChatMessage.status != -1)) || (((paramChatMessage.nOpType != 0) && (paramChatMessage.nOpType != 11)) || ((paramChatMessage.getCloudType() != 1) || (paramChatMessage.status != 1)) || ((paramChatMessage.nOpType == 11) && (paramChatMessage.getCloudType() == 1) && (paramChatMessage.status == 13)))) {}
      g(paramChatMessage);
      h(paramChatMessage);
      bool = i(paramChatMessage);
    } while ((bool) && (aqhq.fileExistsAndNotEmpty(paramChatMessage.getFilePath())));
    return bool;
  }
  
  protected boolean J(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
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
          } while (!(paramChatMessage instanceof MessageForFile));
          paramChatMessage = (MessageForFile)paramChatMessage;
          paramChatMessage = ahav.a(this.mApp, paramChatMessage);
        } while (paramChatMessage == null);
        i = ahav.getFileType(paramChatMessage.fileName);
      } while ((i == 0) || (i == 2));
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleDownloadHandler", 1, "needShowPauseIcon: current file nOpType[" + paramChatMessage.nOpType + "] status[" + paramChatMessage.status + "]");
      }
    } while ((paramChatMessage.nOpType != 1) || ((paramChatMessage.status != 2) && (paramChatMessage.status != 18)));
    return true;
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
          return;
          QLog.i("OfflineFileBubbleDownloadHandler", 1, "handleDownloadClick: type[" + paramInt + "]");
        } while ((paramInt == -1) || (!(paramChatMessage instanceof MessageForFile)));
        paramView = (MessageForFile)paramChatMessage;
        paramView = ahav.a(this.mApp, paramView);
      } while (paramView == null);
      if (paramInt == 0)
      {
        anot.a(this.mApp, "dc00898", "", "", "0X800A888", "0X800A888", 0, 0, "", "", "", "");
        if (paramView.getCloudType() == 0)
        {
          this.mApp.a().js(paramView.nSessionId);
          return;
        }
        this.mApp.a().bZ(paramView.nSessionId);
        return;
      }
    } while (paramInt != 1);
    anot.a(this.mApp, "dc00898", "", "", "0X800A887", "0X800A887", 0, 0, "", "", "", "");
    agzy.a(paramView).a(false, this.mContext, new aghg(this, paramView));
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
 * Qualified Name:     aghf
 * JD-Core Version:    0.7.0.1
 */