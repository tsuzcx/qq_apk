import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

class abhk
  extends Handler
{
  abhk(abhh paramabhh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == abhh.coJ)
    {
      paramMessage = (aqrb)this.this$0.mApp.getBusinessHandler(71);
      if (paramMessage != null) {
        localObject = new ArrayList(abhh.u.size());
      }
    }
    while (paramMessage.what != abhh.coK)
    {
      try
      {
        Iterator localIterator = abhh.u.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!((ArrayList)localObject).contains(str)) {
            ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(str)));
          }
        }
        paramMessage.m((ArrayList)localObject, "troop");
      }
      catch (Exception localException) {}
      for (;;)
      {
        abhh.u.clear();
        if (abhh.v.size() > 0)
        {
          paramMessage.Z((String[])abhh.v.toArray(new String[0]));
          abhh.v.clear();
        }
        return;
        if ((abhh.a(this.this$0) != null) && (abhh.a(this.this$0).apolloLocalTS != abhh.a(this.this$0).apolloServerTS) && (!((ArrayList)localObject).contains(this.this$0.mApp.getCurrentUin()))) {
          ((ArrayList)localObject).add(Long.valueOf(this.this$0.mApp.getLongAccountUin()));
        }
      }
    }
    Object localObject = (String)paramMessage.obj;
    if (paramMessage.arg1 == 1) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!abhh.u.contains(localObject)))
      {
        abhh.u.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->dress uin:" + (String)localObject);
        }
      }
    }
    for (;;)
    {
      this.this$0.cr.removeMessages(abhh.coJ);
      this.this$0.cr.sendEmptyMessageDelayed(abhh.coJ, 200L);
      return;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!abhh.v.contains(localObject)))
      {
        abhh.v.add(localObject);
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "addToBulkPullMap-->info uin:" + (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abhk
 * JD-Core Version:    0.7.0.1
 */