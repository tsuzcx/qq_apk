package com.tencent.mobileqq.troop.data;

import apan;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TroopAioKeywordTipManager$1
  implements Runnable
{
  public TroopAioKeywordTipManager$1(apan paramapan, List paramList) {}
  
  public void run()
  {
    Object localObject1 = this.Hy.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      apan.a(this.this$0, (MessageRecord)localObject2);
    }
    localObject1 = null;
    Object localObject2 = this.Hy.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
      localObject3 = apan.a(this.this$0, (MessageRecord)localObject3);
      if (localObject3 == null) {
        break label133;
      }
      if (localObject1 != null) {
        break label130;
      }
      localObject1 = new ArrayList();
      label97:
      ((List)localObject1).addAll((Collection)localObject3);
    }
    label130:
    label133:
    for (;;)
    {
      break;
      if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
        apan.a(this.this$0, (List)localObject1);
      }
      return;
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.1
 * JD-Core Version:    0.7.0.1
 */