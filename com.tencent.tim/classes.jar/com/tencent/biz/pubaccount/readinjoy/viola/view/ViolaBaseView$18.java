package com.tencent.biz.pubaccount.readinjoy.viola.view;

import aqhq;
import com.tencent.viola.utils.ViolaUtils;
import kxm;

class ViolaBaseView$18
  implements Runnable
{
  ViolaBaseView$18(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    Object localObject = aqhq.o("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.anN) + "_" + kxm.getAccount());
    if (localObject == null) {
      aqhq.y("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.anN) + "_" + kxm.getAccount(), ViolaBaseView.b(this.this$0));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.b(this.this$0).equals(localObject))) {
      return;
    }
    aqhq.y("viola_cache_file_viola_qq_page_data_" + ViolaUtils.getPageName(this.this$0.anN) + "_" + kxm.getAccount(), ViolaBaseView.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.18
 * JD-Core Version:    0.7.0.1
 */