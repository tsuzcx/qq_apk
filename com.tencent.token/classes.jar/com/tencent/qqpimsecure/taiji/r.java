package com.tencent.qqpimsecure.taiji;

import Protocol.MMGRAuth.CSPullSolutionInfo;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import taiji.cl;
import tmsdk.common.module.pgsdk.manager.ITaijiReportManager;
import tmsdk.common.module.pgsdk.manager.shark.ISharkCallBack;

class r
  implements ISharkCallBack
{
  r(o paramo, CSPullSolutionInfo paramCSPullSolutionInfo) {}
  
  public void onFinish(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    cl.b("Taiji", "onFinish pull cmdId:" + paramInt2);
    if ((paramInt3 != 0) || (paramInt4 != 0))
    {
      cl.b("Taiji", "onFinish pull shark error:" + paramInt3 + "|dataRetCode:" + paramInt4);
      if (this.a.pullType == 2)
      {
        u.a(o.a(this.b)).a(0L);
        if (o.d(this.b) + 1 >= 3) {
          break label195;
        }
        o.a(this.b, true);
        o.e(this.b);
        o.c(this.b).sendMessageDelayed(o.c(this.b).obtainMessage(1, null), 500L);
        cl.b("Taiji", "retry pull all");
        if (paramInt3 == 0) {
          break label216;
        }
        paramJceStruct = new ArrayList(1);
        paramJceStruct.add(String.valueOf(paramInt3));
        f.a().e().reportString(266935, paramJceStruct);
      }
      label195:
      label216:
      while (paramInt4 == 0)
      {
        return;
        o.a(this.b, false);
        o.a(this.b, 0);
        break;
      }
      paramJceStruct = new ArrayList(1);
      paramJceStruct.add(String.valueOf(paramInt4));
      f.a().e().reportString(266935, paramJceStruct);
      return;
    }
    o.a(this.b, paramJceStruct, true, this.a.pullType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.taiji.r
 * JD-Core Version:    0.7.0.1
 */