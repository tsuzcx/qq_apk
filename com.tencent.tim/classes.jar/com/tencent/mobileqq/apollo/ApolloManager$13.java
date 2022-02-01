package com.tencent.mobileqq.apollo;

import abhh;
import abxk;
import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public final class ApolloManager$13
  implements Runnable
{
  public ApolloManager$13(AppInterface paramAppInterface) {}
  
  public void run()
  {
    if (this.b != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "[checkJsonParse]");
      }
      Object localObject = (abxk)this.b.getManager(155);
      abhh localabhh = (abhh)this.b.getManager(153);
      List localList = ((abxk)localObject).getActionList();
      SharedPreferences localSharedPreferences = this.b.getApplication().getSharedPreferences("apollo_sp", 0);
      boolean bool = localSharedPreferences.getBoolean("3.4.4" + this.b.getCurrentAccountUin(), false);
      int i = localSharedPreferences.getInt("apollo_json_version" + this.b.getCurrentAccountUin(), 0);
      int j = localSharedPreferences.getInt("apollo_json_version", 0);
      if ((localList == null) || (localList.size() == 0) || (!bool) || (i != j))
      {
        localabhh.Yb();
        QLog.d("ApolloManager", 1, "[checkJsonParse] parse action json");
      }
      localObject = ((abxk)localObject).dM();
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        ApolloGameUtil.i((QQAppInterface)this.b, 0L);
        QLog.d("ApolloManager", 1, "game list is null, set game request ts 0");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.13
 * JD-Core Version:    0.7.0.1
 */