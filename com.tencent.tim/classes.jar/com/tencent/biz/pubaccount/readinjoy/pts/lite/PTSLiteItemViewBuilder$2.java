package com.tencent.biz.pubaccount.readinjoy.pts.lite;

import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import luy;
import lwc;
import lwc.a;

public class PTSLiteItemViewBuilder$2
  implements Runnable
{
  public PTSLiteItemViewBuilder$2(luy paramluy, PTSItemData paramPTSItemData) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    if ((luy.a(this.this$0).contains(this.a.getItemID())) && ((QLog.isColorLevel()) || (QLog.isDebugVersion())))
    {
      QLog.i("PTSLiteItemViewBuilder", 2, "[reportItemExposure], itemId : " + this.a.getItemID() + " has exposed.");
      return;
    }
    lwc.f("0X800A9DD", "", "", "", new lwc.a().a("page_name", this.a.getPageName()).a("item_id", this.a.getItemID()).build());
    luy.a(this.this$0).add(this.a.getItemID());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder.2
 * JD-Core Version:    0.7.0.1
 */