package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lit;

public class ReadInJoyUserInfoRepository$2
  implements Runnable
{
  public ReadInJoyUserInfoRepository$2(lit paramlit, int paramInt) {}
  
  public void run()
  {
    Object localObject = lit.a(this.this$0);
    int i = this.val$count;
    localObject = ((EntityManager)localObject).query(ReadInJoyUserInfo.class, true, "uin IS NOT NULL AND uin != ?", new String[] { "" }, null, null, null, String.valueOf(i));
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyUserInfo localReadInJoyUserInfo = (ReadInJoyUserInfo)localIterator.next();
        QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadReadInJoyUserInfoFromDB, userInfo = ", localReadInJoyUserInfo, Character.valueOf('\n') });
        this.this$0.a(localReadInJoyUserInfo.uin, localReadInJoyUserInfo, false, false);
      }
    }
    if (localObject != null) {}
    for (i = ((List)localObject).size();; i = 0)
    {
      QLog.d("ReadInJoyUserInfoRepository", 2, new Object[] { "loadReadInJoyUserInfoFromDB size = ", Integer.valueOf(i) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoRepository.2
 * JD-Core Version:    0.7.0.1
 */