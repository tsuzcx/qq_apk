package btmsdkobf;

import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;

public class bj
{
  private static bj fQ = null;
  private ConchService.IConchPushListener fR = new ey(this);
  
  private bj()
  {
    eg.e("ConchManager", "ConchManager-ConchManager");
    ConchServiceProxy localConchServiceProxy = ConchServiceProxy.getInstance();
    localConchServiceProxy.registerSharkPush();
    localConchServiceProxy.registerConchPush(519, this.fR);
    localConchServiceProxy.registerConchPush(1589, this.fR);
    localConchServiceProxy.registerConchPush(1466, this.fR);
  }
  
  public static bj F()
  {
    if (fQ == null) {}
    try
    {
      if (fQ == null) {
        fQ = new bj();
      }
      return fQ;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bj
 * JD-Core Version:    0.7.0.1
 */