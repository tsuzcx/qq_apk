import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.GrayTipsSpan;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class acqn
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, ArrayList<GrayTipsSpan> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + aqft.pk(paramString2));
    }
    if ((paramBoolean1) && (top.fw(paramInt)) && (QLog.isColorLevel())) {
      QLog.d("AddMessageHelper", 2, "-----addGrayTipsMessage faild : no troop uin");
    }
    long l = anaz.gQ();
    if (paramBoolean1) {}
    for (int i = -5001;; i = -5000)
    {
      QQMessageFacade.Message localMessage = paramQQAppInterface.b().a(paramString1, paramInt);
      MessageForNewGrayTips localMessageForNewGrayTips = (MessageForNewGrayTips)anbi.d(i);
      localMessageForNewGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, i, paramInt, l);
      if (localMessage != null) {
        localMessageForNewGrayTips.shmsgseq = localMessage.shmsgseq;
      }
      localMessageForNewGrayTips.isread = paramBoolean3;
      localMessageForNewGrayTips.spans = paramArrayList;
      localMessageForNewGrayTips.updateMsgData();
      if ((!paramBoolean2) || (!achp.a(paramQQAppInterface, localMessageForNewGrayTips, false))) {
        paramQQAppInterface.b().b(localMessageForNewGrayTips, paramQQAppInterface.getCurrentAccountUin());
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramString1, paramString2, paramInt, null, paramBoolean1, paramBoolean2, true);
  }
  
  public static void e(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddMessageHelper", 2, "-----addDatingSafetyGrayTipsMessage  frienduin:" + paramString1 + " istroop：" + paramInt + " msg:" + aqft.pk(paramString2));
    }
    long l = anaz.gQ();
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)anbi.d(-1028);
    localMessageForGrayTips.init(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, l, -1028, paramInt, l);
    localMessageForGrayTips.isread = true;
    if (!achp.f(paramQQAppInterface, localMessageForGrayTips)) {
      paramQQAppInterface.b().b(localMessageForGrayTips, paramQQAppInterface.getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqn
 * JD-Core Version:    0.7.0.1
 */