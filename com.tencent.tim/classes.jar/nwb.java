import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.gdtad.api.GdtAd;
import org.json.JSONObject;

public class nwb
  implements tgl
{
  public nwb(BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(GdtAd paramGdtAd)
  {
    Object localObject = knf.a(paramGdtAd);
    paramGdtAd = new JSONObject();
    for (;;)
    {
      try
      {
        paramGdtAd.put("adInfo", localObject);
        if (localObject != null) {
          continue;
        }
        paramGdtAd.put("retCode", -1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      this.this$0.invokeCallJS(this.val$callBack, paramGdtAd);
      return;
      paramGdtAd.put("retCode", 0);
    }
  }
  
  public void a(GdtAd paramGdtAd, tgk paramtgk)
  {
    this.this$0.invokeErrorCallJS(this.val$callBack, paramtgk.getErrorMessage());
  }
  
  public void b(GdtAd paramGdtAd) {}
  
  public void c(GdtAd paramGdtAd) {}
  
  public void d(GdtAd paramGdtAd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nwb
 * JD-Core Version:    0.7.0.1
 */