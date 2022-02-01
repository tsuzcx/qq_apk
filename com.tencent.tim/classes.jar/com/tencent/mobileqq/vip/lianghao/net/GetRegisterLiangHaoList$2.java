package com.tencent.mobileqq.vip.lianghao.net;

import aqwj;
import aqwq;
import aqwq.a;
import java.util.List;

public class GetRegisterLiangHaoList$2
  implements Runnable
{
  public GetRegisterLiangHaoList$2(aqwq paramaqwq, aqwj paramaqwj, aqwq.a parama) {}
  
  public void run()
  {
    if ((this.b != null) && (this.b.ret == 0) && (this.b.iD != null) && (this.b.iD.size() > 0))
    {
      this.c.a(this.b);
      return;
    }
    this.c.ea(-1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.lianghao.net.GetRegisterLiangHaoList.2
 * JD-Core Version:    0.7.0.1
 */