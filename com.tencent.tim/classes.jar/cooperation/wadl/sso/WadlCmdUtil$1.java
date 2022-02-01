package cooperation.wadl.sso;

import awot;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import tbb;

public class WadlCmdUtil$1
  implements Runnable
{
  public WadlCmdUtil$1(awot paramawot, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    long l1 = tbb.P("LAST_GET_CONF_VERSION");
    if (QLog.isColorLevel()) {
      QLog.d(awot.TAG, 2, "checkConfigUpdate bForce=" + this.drd + ",newVersion=" + this.aBt + ",currVersion=" + l1);
    }
    if ((this.aBt > -1L) && (this.aBt == l1) && (awot.R().exists())) {}
    long l2;
    do
    {
      return;
      if (this.drd)
      {
        awot.a(this.this$0, l1);
        return;
      }
      if (awot.a(this.this$0) >= 3)
      {
        awot.a(this.this$0, System.currentTimeMillis());
        awot.a(this.this$0, (short)0);
        return;
      }
      if (awot.a(this.this$0) == -1L) {
        awot.a(this.this$0, tbb.P("LAST_GET_CONF_TIME"));
      }
      l2 = System.currentTimeMillis();
    } while ((awot.a(this.this$0) + 86400000L >= l2) && (awot.a(this.this$0) <= l2));
    awot.a(this.this$0, l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.wadl.sso.WadlCmdUtil.1
 * JD-Core Version:    0.7.0.1
 */