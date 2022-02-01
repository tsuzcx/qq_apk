import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;

public class nvz
  extends aczc.b
{
  public nvz(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    super(paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      BridgeModule.access$1600(this.this$0, paramSosoLbsInfo, this.val$callback);
      return;
    }
    BridgeModule.access$1700(this.this$0, this.val$callback, "errorCode: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nvz
 * JD-Core Version:    0.7.0.1
 */