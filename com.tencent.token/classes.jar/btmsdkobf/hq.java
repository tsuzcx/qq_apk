package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class hq
  extends Handler
{
  hq(de paramde, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_OPEN");
      de.a(this.a);
      de.b(this.a).cp();
      return;
    case 1: 
      eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_CLOSE");
      this.a.ci();
      return;
    }
    eh.f("SharkTcpControler", "[tcp_control][shark_conf] MSG_EXE_RULE_CYCLE");
    de.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hq
 * JD-Core Version:    0.7.0.1
 */