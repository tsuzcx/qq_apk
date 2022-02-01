package cooperation.vip.ar.util;

import aeoq.a;
import ahbj;
import awkt;
import awll;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;

public class VipQGLoaderManager$1
  implements Runnable
{
  public VipQGLoaderManager$1(awll paramawll, String paramString1, String paramString2, awkt paramawkt, aeoq.a parama) {}
  
  public void run()
  {
    if (ahbj.isFileExists(this.cRi))
    {
      QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file exist save to map");
      if (awll.a(this.this$0) != null) {
        awll.a(this.this$0).put(this.zx, this.cRi);
      }
      if (this.jdField_a_of_type_Awkt != null) {
        this.jdField_a_of_type_Awkt.abS(this.cRi);
      }
      return;
    }
    QZLog.i("VipARQGLoaderManager", 1, "getQGModelData file not exist start to download");
    this.this$0.b(this.jdField_a_of_type_Aeoq$a, this.jdField_a_of_type_Awkt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.ar.util.VipQGLoaderManager.1
 * JD-Core Version:    0.7.0.1
 */