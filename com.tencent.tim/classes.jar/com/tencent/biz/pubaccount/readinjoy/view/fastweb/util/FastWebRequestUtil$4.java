package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import java.util.ArrayList;
import knb;
import nnc;
import nnc.c;

public final class FastWebRequestUtil$4
  implements Runnable
{
  public FastWebRequestUtil$4(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean, int paramInt1, long paramLong, String paramString7, int paramInt2, nnc.c paramc) {}
  
  public void run()
  {
    boolean bool2 = false;
    ArrayList localArrayList = new ArrayList();
    String str = nnc.b(nnc.b(this.XS, this.Vu, this.VM, this.val$tag, this.amq, this.amr, this.atz, 2, this.bav, this.xM), nnc.b(this.ams, this.bau));
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (nnc.b(str, this.Vu, localArrayList, knb.a(this.XS, this.val$tag, this.ams))) {
        bool1 = true;
      }
    }
    if (this.a != null) {
      this.a.q(bool1, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil.4
 * JD-Core Version:    0.7.0.1
 */