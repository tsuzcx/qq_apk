import android.content.Context;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/weaknet/WeakNetReportUtil;", "", "()V", "ACTION_NETWORK_CHANGED", "", "TAG", "report68bRequestNetworkChanged", "", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "result", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class udd
{
  public static final udd a = new udd();
  
  public final void a(@NotNull ToServiceMsg paramToServiceMsg, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    QLog.i("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged]");
    Object localObject = paramToServiceMsg.getAttribute("sendNetType");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int i = ((Integer)localObject).intValue();
    localObject = paramToServiceMsg.getAttribute("sendIsNetConnected");
    if (localObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
    boolean bool1 = ((Boolean)localObject).booleanValue();
    paramToServiceMsg = paramToServiceMsg.getAttribute("retryIndex");
    if (paramToServiceMsg == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    int j = ((Integer)paramToServiceMsg).intValue();
    localObject = pkh.a();
    int k = com.tencent.biz.common.util.NetworkUtil.getNetworkType((Context)BaseApplicationImpl.context);
    boolean bool2 = com.tencent.mobileqq.utils.NetworkUtil.isNetworkAvailable();
    paramToServiceMsg = new JSONObject();
    for (;;)
    {
      try
      {
        paramToServiceMsg.put("sendNetType", i);
        if (!bool1) {
          continue;
        }
        i = 1;
        paramToServiceMsg.put("sendIsNetConnected", i);
        paramToServiceMsg.put("retryIndex", j);
        paramToServiceMsg.put("receiveNetType", k);
        if (!bool2) {
          continue;
        }
        i = 1;
        paramToServiceMsg.put("receiveNetConnected", i);
        paramToServiceMsg.put("retCode", paramInt);
        paramToServiceMsg.put("uin", localObject);
        paramToServiceMsg.put("brand", Build.BRAND);
        paramToServiceMsg.put("model", Build.MODEL);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged], e = " + localJSONException);
        continue;
      }
      QLog.i("WeakNetReportUtil", 1, "[report68bRequestNetworkChanged], actionName = 0X800B6B4, r5 = " + paramToServiceMsg);
      olh.a(null, "", "0X800B6B4", "0X800B6B4", 0, 0, "", "", "", paramToServiceMsg.toString(), false);
      return;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udd
 * JD-Core Version:    0.7.0.1
 */