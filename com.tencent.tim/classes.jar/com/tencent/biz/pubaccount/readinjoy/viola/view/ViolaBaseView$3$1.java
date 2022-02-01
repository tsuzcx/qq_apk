package com.tencent.biz.pubaccount.readinjoy.viola.view;

import aqhq;
import kxm;
import nxi;

public class ViolaBaseView$3$1
  implements Runnable
{
  public ViolaBaseView$3$1(nxi paramnxi) {}
  
  public void run()
  {
    Object localObject = aqhq.o("viola_cache_file_viola_qq_page_data_new_main_js_" + kxm.getAccount());
    if (localObject == null) {
      aqhq.y("viola_cache_file_viola_qq_page_data_new_main_js_" + kxm.getAccount(), ViolaBaseView.a(this.a.this$0));
    }
    while ((!(localObject instanceof String)) || (ViolaBaseView.a(this.a.this$0).equals(localObject))) {
      return;
    }
    aqhq.y("viola_cache_file_viola_qq_page_data_new_main_js_" + kxm.getAccount(), ViolaBaseView.a(this.a.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1
 * JD-Core Version:    0.7.0.1
 */