package btmsdkobf;

import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.base.utils.ConvertUtil;
import java.util.ArrayList;

class ey
  extends ConchService.IConchPushListener
{
  ey(bj parambj) {}
  
  public void onRecvPush(ConchService.ConchPushInfo paramConchPushInfo)
  {
    if (paramConchPushInfo != null) {}
    ad localad;
    for (;;)
    {
      Object localObject;
      try
      {
        localObject = paramConchPushInfo.mConch;
        if (localObject == null) {
          return;
        }
        localObject = ConchServiceProxy.getInstance();
        eg.e("ConchManager", "onRecvPush, cmdId:[" + paramConchPushInfo.mConch.cmdId + "]");
        if (519 == paramConchPushInfo.mConch.cmdId)
        {
          localad = (ad)cp.a(paramConchPushInfo.mConch.aZ, new ad(), false);
          if ((localad == null) || (localad.bm == null) || (localad.bm.size() <= 0))
          {
            ((ConchServiceProxy)localObject).reportConchResult(paramConchPushInfo, 3, 2);
            continue;
          }
          bq.Q().onRecvPush(paramConchPushInfo);
        }
      }
      finally {}
      while ((1589 == paramConchPushInfo.mConch.cmdId) || (1466 != paramConchPushInfo.mConch.cmdId))
      {
        ((ConchServiceProxy)localObject).reportConchResult(paramConchPushInfo, 3, 1);
        break;
      }
      localad = (ad)cp.a(paramConchPushInfo.mConch.aZ, new ad(), false);
      if ((localad != null) && (localad.bm != null) && (localad.bm.size() > 4)) {
        break;
      }
      ((ConchServiceProxy)localObject).reportConchResult(paramConchPushInfo, 3, 2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ey
 * JD-Core Version:    0.7.0.1
 */