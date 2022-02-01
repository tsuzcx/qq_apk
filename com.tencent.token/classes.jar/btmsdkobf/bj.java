package btmsdkobf;

import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.base.utils.ConvertUtil;
import java.util.ArrayList;

public class bj
{
  private static bj fQ;
  private ConchService.IConchPushListener fR = new ConchService.IConchPushListener()
  {
    public void onRecvPush(ConchService.ConchPushInfo paramAnonymousConchPushInfo)
    {
      if (paramAnonymousConchPushInfo != null) {}
      for (;;)
      {
        try
        {
          if (paramAnonymousConchPushInfo.mConch != null)
          {
            ConchServiceProxy localConchServiceProxy = ConchServiceProxy.getInstance();
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onRecvPush, cmdId:[");
            ((StringBuilder)localObject).append(paramAnonymousConchPushInfo.mConch.cmdId);
            ((StringBuilder)localObject).append("]");
            eg.e("ConchManager", ((StringBuilder)localObject).toString());
            int i = paramAnonymousConchPushInfo.mConch.cmdId;
            boolean bool2 = false;
            if (519 == i)
            {
              localObject = (ad)cp.a(paramAnonymousConchPushInfo.mConch.aZ, new ad(), false);
              if ((localObject != null) && (((ad)localObject).bm != null) && (((ad)localObject).bm.size() > 0)) {
                bq.Q().onRecvPush(paramAnonymousConchPushInfo);
              } else {
                localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 3, 2);
              }
            }
            else if ((1589 != paramAnonymousConchPushInfo.mConch.cmdId) && (1466 == paramAnonymousConchPushInfo.mConch.cmdId))
            {
              localObject = (ad)cp.a(paramAnonymousConchPushInfo.mConch.aZ, new ad(), false);
              if ((localObject != null) && (((ad)localObject).bm != null) && (((ad)localObject).bm.size() > 4))
              {
                if (ConvertUtil.stringToByte((String)((ad)localObject).bm.get(0)) != 1) {
                  break label387;
                }
                bool1 = true;
                be.b(bool1);
                if (ConvertUtil.stringToByte((String)((ad)localObject).bm.get(1)) != 1) {
                  break label392;
                }
                bool1 = true;
                du.b(bool1);
                ConvertUtil.stringToByte((String)((ad)localObject).bm.get(2));
                ConvertUtil.stringToByte((String)((ad)localObject).bm.get(3));
                bool1 = bool2;
                if (ConvertUtil.stringToByte((String)((ad)localObject).bm.get(4)) == 1) {
                  bool1 = true;
                }
                bi.b(bool1);
              }
              else
              {
                localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 3, 2);
                return;
              }
            }
            localConchServiceProxy.reportConchResult(paramAnonymousConchPushInfo, 3, 1);
            return;
          }
        }
        finally {}
        return;
        label387:
        boolean bool1 = false;
        continue;
        label392:
        bool1 = false;
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
    if (fQ == null) {
      try
      {
        if (fQ == null) {
          fQ = new bj();
        }
      }
      finally {}
    }
    return fQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bj
 * JD-Core Version:    0.7.0.1
 */