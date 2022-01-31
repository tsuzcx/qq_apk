import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestInfo;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.ArrayList;
import java.util.List;

public class wim
  implements Runnable
{
  public wim(QQOperateTips paramQQOperateTips) {}
  
  public void run()
  {
    Object localObject2 = QQOperateTips.a(this.a).a();
    Object localObject1;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      int j = ((List)localObject2).size();
      localObject1 = new ArrayList();
      int i;
      ChatMessage localChatMessage;
      if (QQOperateTips.a(this.a).jdField_a_of_type_Int == 0)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.time > QQOperateTips.a(this.a)))
          {
            if (localChatMessage.uniseq != QQOperateTips.b(this.a)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              QQOperateTips.a(this.a, localChatMessage.time);
            }
          }
        }
      }
      else if (QQOperateTips.a(this.a).jdField_a_of_type_Int == 3000)
      {
        i = j - 1;
        if (i >= 0)
        {
          localChatMessage = (ChatMessage)((List)localObject2).get(i);
          if ((localChatMessage != null) && (localChatMessage.shmsgseq > QQOperateTips.a(this.a)))
          {
            if (localChatMessage.uniseq != QQOperateTips.b(this.a)) {
              ((ArrayList)localObject1).add(localChatMessage);
            }
            for (;;)
            {
              i -= 1;
              break;
              QQOperateTips.a(this.a, localChatMessage.shmsgseq);
            }
          }
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject2 = (ChatMessage)((List)localObject2).get(j - 1);
        if (localObject2 != null)
        {
          if (QQOperateTips.a(this.a).jdField_a_of_type_Int != 0) {
            break label408;
          }
          QQOperateTips.a(this.a, ((ChatMessage)localObject2).time);
          QQOperateTips.b(this.a, ((ChatMessage)localObject2).uniseq);
        }
      }
    }
    for (;;)
    {
      localObject2 = QQOperateManager.a(QQOperateTips.a(this.a));
      localObject1 = ((QQOperateManager)localObject2).a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, QQOperateTips.a(this.a), (List)localObject1, false, -1);
      if (((QQOperationRequestInfo)localObject1).jdField_a_of_type_Boolean)
      {
        localObject1 = ((QQOperationRequestInfo)localObject1).jdField_a_of_type_JavaUtilArrayList;
        ((QQOperateManager)localObject2).a(QQOperateTips.a(this.a).jdField_a_of_type_JavaLangString, QQOperateTips.a(this.a).jdField_a_of_type_Int, (ArrayList)localObject1, QQOperateTips.a(this.a));
      }
      return;
      label408:
      if (QQOperateTips.a(this.a).jdField_a_of_type_Int == 3000)
      {
        QQOperateTips.a(this.a, ((ChatMessage)localObject2).shmsgseq);
        QQOperateTips.b(this.a, ((ChatMessage)localObject2).uniseq);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wim
 * JD-Core Version:    0.7.0.1
 */