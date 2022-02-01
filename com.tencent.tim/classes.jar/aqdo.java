import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aqdo
  implements aqdp.a
{
  aqdo(aqdn paramaqdn) {}
  
  public void Y(int paramInt, List<aqdq> paramList)
  {
    if ((paramInt != 1) || (paramList == null) || (paramList.isEmpty())) {
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(200);
      localStringBuilder.append("fetchInfoBatch size:").append(paramList.size()).append("  [");
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        aqdq localaqdq = (aqdq)paramList.next();
        if ((localaqdq != null) && (localaqdq.iType == 1) && (localaqdq.aBW()))
        {
          if ((localaqdq.strKey != null) && (localaqdq.strKey.length() > 0)) {
            localArrayList.add(localaqdq.strKey);
          }
          if (localStringBuilder != null) {
            localStringBuilder.append(localaqdq.strKey).append(",");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null))
      {
        localStringBuilder.append("]");
        QLog.i("FetchBuddyAndTroopNameHelper", 2, localStringBuilder.toString());
      }
      paramList = (FriendListHandler)aqdn.a(this.b).getBusinessHandler(1);
      if (paramList == null) {
        break;
      }
      paramList.B(localArrayList, false);
      return;
      localStringBuilder = null;
    }
  }
  
  public void a(aqdq paramaqdq)
  {
    if ((paramaqdq == null) || (!paramaqdq.aBW())) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (QLog.isColorLevel()) {
                QLog.d("FetchBuddyAndTroopNameHelper", 2, aqmr.makeLogMsg(new Object[] { "fetchInfo()", paramaqdq.toString() }));
              }
              if (paramaqdq.iType != 2) {
                break;
              }
              localObject = (acms)aqdn.a(this.b).getBusinessHandler(20);
            } while (localObject == null);
            ((acms)localObject).Fe(paramaqdq.strKey);
            return;
            if (paramaqdq.iType != 1) {
              break;
            }
            localObject = (FriendListHandler)aqdn.a(this.b).getBusinessHandler(1);
          } while (localObject == null);
          ((FriendListHandler)localObject).DG(paramaqdq.strKey);
          return;
          if (paramaqdq.iType != 3) {
            break;
          }
          localObject = (acms)aqdn.a(this.b).getBusinessHandler(20);
        } while (localObject == null);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramaqdq.strKey);
        if ((paramaqdq.br != null) && (paramaqdq.br.getInt(aqgv.ctc) == aqgv.dZg))
        {
          ((acms)localObject).a(paramaqdq.csq, localArrayList, false, paramaqdq.br);
          return;
        }
        ((acms)localObject).b(paramaqdq.csq, (String)paramaqdq.obj, localArrayList);
        return;
      } while (paramaqdq.iType != 4);
      localObject = (FriendListHandler)aqdn.a(this.b).getBusinessHandler(1);
    } while (localObject == null);
    ((FriendListHandler)localObject).bC(paramaqdq.strKey, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqdo
 * JD-Core Version:    0.7.0.1
 */