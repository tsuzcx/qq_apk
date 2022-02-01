import KQQ.BatchResponse;
import KQQ.RespBatchProcess;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class adpc
  extends acnd
{
  adpc(adpa paramadpa) {}
  
  protected void a(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle)
  {
    this.this$0.getAppInterface().removeObserver(this);
    paramBundle = new TroopInfoData();
    paramBundle.isMember = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("onBatchGetTroopInfoResp, isSucc=").append(paramBoolean).append(", resp IsNull=");
      if (paramRespBatchProcess == null)
      {
        paramBoolean = true;
        QLog.d("ark.Troop", 2, paramBoolean);
      }
    }
    else
    {
      if ((paramRespBatchProcess != null) && (paramRespBatchProcess.batch_response_list != null) && (paramRespBatchProcess.batch_response_list.size() != 0)) {
        break label121;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ark.Troop", 2, "onBatchGetTroopInfoResp, return");
      }
    }
    label121:
    int j;
    do
    {
      return;
      paramBoolean = false;
      break;
      j = paramRespBatchProcess.batch_response_list.size();
      int i = 0;
      if (i < j)
      {
        localObject = (BatchResponse)paramRespBatchProcess.batch_response_list.get(i);
        if ((localObject == null) || (((BatchResponse)localObject).result != 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((BatchResponse)localObject).type == 1)
          {
            TroopInfo localTroopInfo = ((TroopManager)this.this$0.getAppInterface().getManager(52)).b(this.this$0.buS);
            this.this$0.a((BatchResponse)localObject, paramBundle, localTroopInfo);
          }
        }
      }
    } while (j <= 0);
    adpa.a(this.this$0, this.this$0.buS, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpc
 * JD-Core Version:    0.7.0.1
 */