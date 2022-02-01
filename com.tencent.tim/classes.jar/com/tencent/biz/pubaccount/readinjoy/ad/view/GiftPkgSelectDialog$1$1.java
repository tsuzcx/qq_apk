package com.tencent.biz.pubaccount.readinjoy.ad.view;

import com.tencent.biz.pubaccount.readinjoy.ad.data.GiftServiceBean;
import java.util.List;
import knw;
import knw.a;
import knx;

public class GiftPkgSelectDialog$1$1
  implements Runnable
{
  public GiftPkgSelectDialog$1$1(knx paramknx, int paramInt) {}
  
  public void run()
  {
    try
    {
      GiftServiceBean localGiftServiceBean = (GiftServiceBean)knw.a(this.a.b).get(this.val$position);
      if (knw.a(this.a.b) != null) {
        knw.a(this.a.b).a(localGiftServiceBean);
      }
      this.a.b.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.GiftPkgSelectDialog.1.1
 * JD-Core Version:    0.7.0.1
 */