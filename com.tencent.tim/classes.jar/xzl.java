import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class xzl
  extends ahtk
{
  xzl(xzk paramxzk) {}
  
  protected void aI(Object paramObject)
  {
    QLog.i(xzk.TAG, 1, "[onGameUsrInfoChangedNotify]");
    for (;;)
    {
      ahsz localahsz;
      try
      {
        if ((paramObject instanceof ArrayList))
        {
          paramObject = ((ArrayList)paramObject).iterator();
          if (paramObject.hasNext())
          {
            localahsz = (ahsz)paramObject.next();
            if ((TextUtils.isEmpty(localahsz.mRoleId)) || (!localahsz.mRoleId.equals(this.a.sessionInfo.pj()))) {
              break label115;
            }
            xzk.a(this.a, localahsz);
            xzk.a(this.a, localahsz);
            QLog.i(xzk.TAG, 1, "update friend info.");
            continue;
          }
        }
        return;
      }
      catch (Throwable paramObject)
      {
        QLog.e(xzk.TAG, 1, paramObject.getMessage());
      }
      label115:
      if ((!TextUtils.isEmpty(localahsz.mRoleId)) && (localahsz.mRoleId.equals(this.a.sessionInfo.pk())))
      {
        xzk.b(this.a, localahsz);
        QLog.i(xzk.TAG, 1, "update my info.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzl
 * JD-Core Version:    0.7.0.1
 */