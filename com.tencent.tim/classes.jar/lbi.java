import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.datamodule.DynamicChannelDataModule.6.1;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class lbi
  implements aprb.a
{
  lbi(lbg paramlbg, int paramInt) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "onResult result = ", paramJSONObject, ", requestCode = ", Integer.valueOf(paramInt) });
    if (lbg.a(this.this$0)) {
      lbg.a(this.this$0).execute(new DynamicChannelDataModule.6.1(this, paramBundle, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lbi
 * JD-Core Version:    0.7.0.1
 */