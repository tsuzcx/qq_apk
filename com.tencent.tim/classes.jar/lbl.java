import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment.b;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelHeaderModule.2.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class lbl
  implements aprb.a
{
  lbl(lbk paramlbk, int paramInt, ReadInJoyDynamicChannelBaseFragment.b paramb) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.d("DynamicChannelHeaderModule", 2, new Object[] { "onResult result = ", paramJSONObject, ", requestCode = ", Integer.valueOf(paramInt) });
    if (lbk.a(this.this$0)) {
      lbk.a(this.this$0).execute(new DynamicChannelHeaderModule.2.1(this, paramJSONObject, paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbl
 * JD-Core Version:    0.7.0.1
 */