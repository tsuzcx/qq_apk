import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class apaw
  implements Comparator<MessageRecord>
{
  apaw(apav paramapav) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    int j = 0;
    long l3 = 1L;
    long l1 = paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq;
    int i;
    long l2;
    label89:
    boolean bool2;
    if (l1 == 0L) {
      if ((paramMessageRecord1.msgtype == -1012) || (top.fB(paramMessageRecord1.msgtype)))
      {
        i = 1;
        if ((paramMessageRecord2.msgtype == -1012) || (top.fB(paramMessageRecord2.msgtype))) {
          j = 1;
        }
        if (i == 0) {
          break label165;
        }
        if (j == 0) {
          break label159;
        }
        l2 = paramMessageRecord1.time - paramMessageRecord2.time;
        l1 = l2;
        if (l2 == 0L)
        {
          boolean bool1 = top.fJ(paramMessageRecord1.msgtype);
          bool2 = top.fJ(paramMessageRecord2.msgtype);
          if (!bool1) {
            break label191;
          }
          if (!bool2) {
            break label185;
          }
          l1 = paramMessageRecord1.time - paramMessageRecord2.time;
        }
      }
    }
    for (;;)
    {
      label139:
      if (l1 > 0L) {
        l1 = l3;
      }
      for (;;)
      {
        return (int)l1;
        i = 0;
        break;
        label159:
        l2 = 1L;
        break label89;
        label165:
        if (j != 0)
        {
          l2 = -1L;
          break label89;
        }
        l2 = l1;
        break label89;
        label185:
        l1 = 1L;
        break label139;
        label191:
        l1 = l2;
        if (!bool2) {
          break label139;
        }
        l1 = -1L;
        break label139;
        if (l1 < 0L) {
          l1 = -1L;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apaw
 * JD-Core Version:    0.7.0.1
 */