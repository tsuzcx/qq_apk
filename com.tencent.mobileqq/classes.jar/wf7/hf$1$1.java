package wf7;

import android.os.Message;
import com.qq.taf.jce.JceStruct;
import com.tencent.wifisdk.services.common.api.b.a;
import java.util.Set;

class hf$1$1
  implements b.a
{
  hf$1$1(hf.1 param1, Set paramSet) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0)) {
      Message.obtain(hf.c(this.tb.sZ), 4, this.ta).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hf.1.1
 * JD-Core Version:    0.7.0.1
 */