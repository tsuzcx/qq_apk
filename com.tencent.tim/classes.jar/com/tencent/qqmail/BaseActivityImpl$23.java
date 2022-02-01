package com.tencent.qqmail;

import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.ICallBack;
import java.util.Iterator;
import java.util.Set;

class BaseActivityImpl$23
  implements ICallBack
{
  BaseActivityImpl$23(BaseActivityImpl paramBaseActivityImpl) {}
  
  public void callback(Object paramObject)
  {
    int i;
    StringBuilder localStringBuilder;
    if (paramObject != null)
    {
      paramObject = (JSONObject)paramObject;
      Object localObject = paramObject.getString("a");
      if ((localObject != null) && (!((String)localObject).equals(""))) {
        try
        {
          i = Integer.valueOf((String)localObject).intValue();
          localObject = paramObject.keySet().iterator();
          localStringBuilder = new StringBuilder();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            localStringBuilder.append(str).append(":").append(paramObject.get(str).toString()).append(" ");
            continue;
            return;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          QMLog.log(6, "BaseActivityImpl", "handle kick off err:" + paramObject.toString());
        }
      }
    }
    do
    {
      QMLog.log(4, "BaseActivityImpl", "push kick off str:" + localStringBuilder.toString());
      paramObject = paramObject.get("t");
      if (paramObject == null) {
        break;
      }
    } while (!paramObject.toString().equals("devlock"));
    Log.d("mason", "push kick off devlock!!!!");
    QMLog.log(4, "BaseActivityImpl", "push kick off devlock");
    AccountManager.shareInstance().triggerAccountStateChange(i, -5, "");
    return;
    QMLog.log(4, "BaseActivityImpl", "push kick off:" + i);
    PasswordErrHandler.saveStateAndShowErr(i, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.BaseActivityImpl.23
 * JD-Core Version:    0.7.0.1
 */