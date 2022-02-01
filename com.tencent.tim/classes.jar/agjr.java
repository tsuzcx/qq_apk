import android.content.Context;
import android.text.TextUtils;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class agjr
{
  public static agjs a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty(str))
      {
        QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel, fileType[" + str + "] extInfo[" + paramChatMessage.extStr + "]");
        int i = Integer.parseInt(str);
        if (i == 3) {
          return new agjt(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        if (i == 1) {
          return new agjn(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        if (i == 2) {
          return new agjn(paramQQAppInterface, paramContext, paramSessionInfo);
        }
        QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel error, not support fileType. fileType[" + str + "] extInfo[" + paramChatMessage.extStr + "]");
        return new agjm(paramQQAppInterface, paramContext, paramSessionInfo);
      }
      QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel error,multi file not exist fileType. extInfo[" + paramChatMessage.extStr + "]");
      return new agjm(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    if ((paramChatMessage instanceof MessageForFile)) {
      return new agjn(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    if ((paramChatMessage instanceof MessageForTroopFile)) {
      return new agjt(paramQQAppInterface, paramContext, paramSessionInfo);
    }
    QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleModel error, is not file msg.");
    return new agjm(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  public static xlc a(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, ChatMessage paramChatMessage)
  {
    if (paramInt == 3) {
      paramBaseAdapter = new xle(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    }
    for (;;)
    {
      paramChatMessage = a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage);
      paramAIOAnimationConatiner = paramChatMessage;
      if (paramChatMessage == null)
      {
        QLog.e("QFileBubbleBuilderFactory", 1, "getFileBubbleItemBuilder error, bubbleModel is not.");
        paramAIOAnimationConatiner = new agjm(paramQQAppInterface, paramContext, paramSessionInfo);
      }
      paramBaseAdapter.a(paramAIOAnimationConatiner);
      return paramBaseAdapter;
      if (paramInt == 61)
      {
        paramBaseAdapter = new xlb(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
      else if (paramInt == 65)
      {
        paramBaseAdapter = new xlf(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
      else
      {
        QLog.e("QFileBubbleBuilderFactory", 1, "");
        paramBaseAdapter = new xle(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
      }
    }
  }
  
  public static int c(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int j = -1;
    int i;
    if (paramChatMessage.isMultiMsg) {
      i = ahav.e(paramChatMessage);
    }
    while ((paramChatMessage instanceof MessageForFile)) {
      if (i == 0)
      {
        return 61;
        if ((paramChatMessage instanceof MessageForFile))
        {
          paramQQAppInterface = paramQQAppInterface.a().a(paramChatMessage.uniseq, paramChatMessage.frienduin, paramChatMessage.istroop);
          i = j;
          if (paramQQAppInterface != null)
          {
            i = j;
            if (paramQQAppInterface.cloudType != 0) {
              i = ahav.getFileType(paramQQAppInterface.fileName);
            }
          }
        }
        else
        {
          i = j;
          if ((paramChatMessage instanceof MessageForTroopFile)) {
            i = ahav.getFileType(((MessageForTroopFile)paramChatMessage).fileName);
          }
        }
      }
      else
      {
        if (i == 2) {
          return 65;
        }
        return 3;
      }
    }
    if ((paramChatMessage instanceof MessageForTroopFile))
    {
      if (i == 0) {
        return 61;
      }
      if (i == 2) {
        return 65;
      }
      return 3;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjr
 * JD-Core Version:    0.7.0.1
 */