import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.cmd0xe36.cmd0xe36.RspBody;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class nvv
  extends jnm.d
{
  public nvv(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.i(BridgeModule.TAG, 1, "yyy_0xe36 error code: " + paramInt);
    if (paramInt == 0) {
      paramBundle = new cmd0xe36.RspBody();
    }
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = 0;
      paramArrayOfByte = "";
      if (paramBundle.code.has()) {
        paramInt = paramBundle.code.get();
      }
      if (paramBundle.wording.has()) {
        paramArrayOfByte = paramBundle.wording.get();
      }
      QLog.i(BridgeModule.TAG, 1, "yyy_0xe36 code: " + paramInt + "\nwording: " + paramArrayOfByte);
      if ((paramInt != 0) && (!TextUtils.isEmpty(paramArrayOfByte)))
      {
        paramBundle = new JSONObject();
        paramBundle.put("wording", paramArrayOfByte);
        this.this$0.invokeCallJS(this.val$callbackId, paramBundle);
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      QLog.i(BridgeModule.TAG, 1, "yyy_0xe36 error: " + paramArrayOfByte.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvv
 * JD-Core Version:    0.7.0.1
 */