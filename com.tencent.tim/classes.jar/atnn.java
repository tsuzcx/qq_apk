import QQService.AddDiscussMemberInfo;
import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginRemoteCmdHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class atnn
  extends AsyncTask<Void, Void, ArrayList<AddDiscussMemberInfo>>
{
  public atnn(DingdongPluginRemoteCmdHandler paramDingdongPluginRemoteCmdHandler, acdu paramacdu, String paramString1, String paramString2, long paramLong, QQAppInterface paramQQAppInterface) {}
  
  protected ArrayList<AddDiscussMemberInfo> a(Void... paramVarArgs)
  {
    Object localObject1 = this.d.z(this.cHJ);
    paramVarArgs = new HashSet();
    Object localObject2;
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DiscussionMemberInfo)((Iterator)localObject1).next();
        if (!this.val$selfUin.equals(((DiscussionMemberInfo)localObject2).memberUin)) {
          paramVarArgs.add(((DiscussionMemberInfo)localObject2).memberUin);
        }
      }
    }
    localObject1 = new ArrayList();
    int i = DingdongPluginRemoteCmdHandler.a(this.this$0).size() - 1;
    if (i >= 0)
    {
      if (paramVarArgs.contains(((ResultRecord)DingdongPluginRemoteCmdHandler.a(this.this$0).get(i)).uin)) {}
      for (;;)
      {
        i -= 1;
        break;
        localObject2 = (ResultRecord)DingdongPluginRemoteCmdHandler.a(this.this$0).get(i);
        AddDiscussMemberInfo localAddDiscussMemberInfo = new AddDiscussMemberInfo();
        if (((ResultRecord)localObject2).type == 4) {
          localAddDiscussMemberInfo.RefStr = ((ResultRecord)localObject2).uin;
        }
        for (;;)
        {
          localAddDiscussMemberInfo.Type = ((ResultRecord)localObject2).type;
          ((ArrayList)localObject1).add(localAddDiscussMemberInfo);
          break;
          try
          {
            localAddDiscussMemberInfo.Uin = Long.valueOf(((ResultRecord)localObject2).uin).longValue();
            localAddDiscussMemberInfo.RefUin = Long.valueOf(((ResultRecord)localObject2).QD).longValue();
          }
          catch (NumberFormatException localNumberFormatException) {}
        }
        if (QLog.isColorLevel()) {
          QLog.d("DingdongPluginRemoteCmdHandler", 2, "doModifyDiscussForDingdong, NumberFormatException!!! uin=" + ((ResultRecord)localObject2).uin);
        }
      }
    }
    return localObject1;
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
      if (!DingdongPluginRemoteCmdHandler.a(this.this$0))
      {
        this.val$app.addObserver(DingdongPluginRemoteCmdHandler.a(this.this$0));
        DingdongPluginRemoteCmdHandler.a(this.this$0, true);
      }
      localacdt = (acdt)this.val$app.getBusinessHandler(6);
    } while (localacdt == null);
    localacdt.j(this.FT, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnn
 * JD-Core Version:    0.7.0.1
 */