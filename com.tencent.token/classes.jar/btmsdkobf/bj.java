package btmsdkobf;

import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.base.utils.ConvertUtil;
import java.util.ArrayList;

public class bj
{
  private static bj fQ = null;
  private ConchService.IConchPushListener fR = new ConchService.IConchPushListener()
  {
    public void onRecvPush(ConchService.ConchPushInfo paramAnonymousConchPushInfo)
    {
      if (paramAnonymousConchPushInfo != null) {}
      ad localad;
      for (;;)
      {
        Object localObject;
        try
        {
          localObject = paramAnonymousConchPushInfo.mConch;
          if (localObject == null) {
            return;
          }
          localObject = ConchServiceProxy.getInstance();
          eg.e("ConchManager", "onRecvPush, cmdId:[" + paramAnonymousConchPushInfo.mConch.cmdId + "]");
          if (519 == paramAnonymousConchPushInfo.mConch.cmdId)
          {
            localad = (ad)cp.a(paramAnonymousConchPushInfo.mConch.aZ, new ad(), false);
            if ((localad == null) || (localad.bm == null) || (localad.bm.size() <= 0))
            {
              ((ConchServiceProxy)localObject).reportConchResult(paramAnonymousConchPushInfo, 3, 2);
              continue;
            }
            bq.Q().onRecvPush(paramAnonymousConchPushInfo);
          }
        }
        finally {}
        while ((1589 == paramAnonymousConchPushInfo.mConch.cmdId) || (1466 != paramAnonymousConchPushInfo.mConch.cmdId))
        {
          ((ConchServiceProxy)localObject).reportConchResult(paramAnonymousConchPushInfo, 3, 1);
          break;
        }
        localad = (ad)cp.a(paramAnonymousConchPushInfo.mConch.aZ, new ad(), false);
        if ((localad != null) && (localad.bm != null) && (localad.bm.size() > 4)) {
          break;
        }
        ((ConchServiceProxy)localObject).reportConchResult(paramAnonymousConchPushInfo, 3, 2);
      }
      if (ConvertUtil.stringToByte((String)localad.bm.get(0)) == 1)
      {
        bool = true;
        label254:
        be.b(bool);
        if (ConvertUtil.stringToByte((String)localad.bm.get(1)) != 1) {
          break label354;
        }
        bool = true;
        label279:
        du.b(bool);
        if ((ConvertUtil.stringToByte((String)localad.bm.get(2)) == 1) && ((ConvertUtil.stringToByte((String)localad.bm.get(3)) == 1) && (ConvertUtil.stringToByte((String)localad.bm.get(4)) != 1))) {
          break label359;
        }
      }
      label354:
      label359:
      for (boolean bool = true;; bool = false)
      {
        bi.b(bool);
        break;
        bool = false;
        break label254;
        bool = false;
        break label279;
      }
    }
  };
  
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