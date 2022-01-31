import com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;

public class xlg
  implements Runnable
{
  public xlg(PreloadFlowControlConfig paramPreloadFlowControlConfig) {}
  
  public void run()
  {
    QWalletTools.a(this.a, PreloadFlowControlConfig.access$000(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlg
 * JD-Core Version:    0.7.0.1
 */