import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class abmo
  implements aqrb.b
{
  abmo(abmm paramabmm, List paramList, String paramString1, String paramString2, int paramInt) {}
  
  public boolean a(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    this.hL.remove(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA onGetBaseInfo uin:" + ApolloUtil.iY(paramString));
    if (this.hL.isEmpty())
    {
      int i = abhh.c(ApolloUtil.a(), this.val$selfUin, true);
      int j = abhh.c(ApolloUtil.a(), this.SO, true);
      paramString = new Bundle();
      paramString.putInt("selfUinStatus", i);
      paramString.putInt("friendUinStatus", j);
      paramString = EIPCResult.createSuccessResult(paramString);
      this.this$0.callbackResult(this.val$callbackId, paramString);
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString, ApolloBaseInfo paramApolloBaseInfo)
  {
    this.hL.remove(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow ACTION_RENDER_VIEW_INIT_CMSHOW_DATA onDressUpdated uin:" + ApolloUtil.iY(paramString));
    if (this.hL.isEmpty())
    {
      int i = abhh.c(ApolloUtil.a(), this.val$selfUin, true);
      int j = abhh.c(ApolloUtil.a(), this.SO, true);
      paramString = new Bundle();
      paramString.putInt("selfUinStatus", i);
      paramString.putInt("friendUinStatus", j);
      paramString = EIPCResult.createSuccessResult(paramString);
      this.this$0.callbackResult(this.val$callbackId, paramString);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmo
 * JD-Core Version:    0.7.0.1
 */