import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class atno
  extends AsyncTask<Void, Void, ArrayList<AddDiscussMemberInfo>>
{
  public atno(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, acdu paramacdu, String paramString, long paramLong, QQAppInterface paramQQAppInterface) {}
  
  protected ArrayList<AddDiscussMemberInfo> a(Void... paramVarArgs)
  {
    Object localObject = this.d.A(this.cHJ);
    paramVarArgs = new HashSet();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramVarArgs.add((String)((Iterator)localObject).next());
      }
    }
    localObject = new ArrayList();
    int i = DingdongPluginRemoteCmdHandler.a(this.this$0).size() - 1;
    if (i >= 0)
    {
      if (paramVarArgs.contains(((ResultRecord)DingdongPluginRemoteCmdHandler.a(this.this$0).get(i)).uin)) {}
      for (;;)
      {
        i -= 1;
        break;
        ResultRecord localResultRecord = (ResultRecord)DingdongPluginRemoteCmdHandler.a(this.this$0).get(i);
        AddDiscussMemberInfo localAddDiscussMemberInfo = new AddDiscussMemberInfo();
        if (localResultRecord.type == 4) {
          localAddDiscussMemberInfo.RefStr = localResultRecord.uin;
        }
        for (;;)
        {
          localAddDiscussMemberInfo.Type = localResultRecord.type;
          ((ArrayList)localObject).add(localAddDiscussMemberInfo);
          break;
          try
          {
            localAddDiscussMemberInfo.Uin = Long.valueOf(localResultRecord.uin).longValue();
            localAddDiscussMemberInfo.RefUin = Long.valueOf(localResultRecord.QD).longValue();
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        if (QLog.isColorLevel()) {
          QLog.d("DingdongPluginRemoteCmdHandler", 2, "doModifyDiscussForDingdong, NumberFormatException!!! uin=" + localResultRecord.uin);
        }
      }
    }
    return localObject;
  }
  
  protected void k(ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      paramArrayList = new Intent();
      paramArrayList.putExtra("reqCode", 7);
      paramArrayList.putExtra("isSuccess", true);
      paramArrayList.putExtra("roomId", this.FT);
      atni.K(11, paramArrayList);
    }
    acdt localacdt;
    do
    {
      return;
      localacdt = (acdt)this.val$app.getBusinessHandler(6);
    } while (localacdt == null);
    localacdt.j(this.FT, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atno
 * JD-Core Version:    0.7.0.1
 */