package com.tencent.biz.pubaccount.readinjoy.pts;

import com.tencent.pts.core.itemview.PTSItemData;
import lwc;
import lwc.a;

public class PTSItemViewBuilder$2
  implements Runnable
{
  public void run()
  {
    lwc.f("0X800A9DC", "", "", "", new lwc.a().a("page_name", this.val$itemData.getPageName()).a("get_view_cost", String.valueOf(this.val$cost)).build());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.PTSItemViewBuilder.2
 * JD-Core Version:    0.7.0.1
 */