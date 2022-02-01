package com.tencent.mobileqq.businessCard;

import adyp;
import com.tencent.mobileqq.businessCard.data.BusinessCard;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BusinessCardManager$1
  implements Runnable
{
  public BusinessCardManager$1(adyp paramadyp) {}
  
  public void run()
  {
    Object localObject = this.this$0.eo();
    if (localObject != null) {}
    for (int i = ((List)localObject).size();; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessCard_Manager", 2, "Init cache from DB,count=" + i);
      }
      this.this$0.eT.clear();
      if (i <= 0) {
        break;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BusinessCard localBusinessCard = (BusinessCard)((Iterator)localObject).next();
        this.this$0.eT.put(localBusinessCard.cardId, localBusinessCard);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.BusinessCardManager.1
 * JD-Core Version:    0.7.0.1
 */