package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.ThreadManager;
import liq;
import mjp;
import mjr;
import mqq.os.MqqHandler;

public class ReadInJoyDraftboxAdapter$2$1
  implements Runnable
{
  public ReadInJoyDraftboxAdapter$2$1(mjr parammjr) {}
  
  public void run()
  {
    boolean bool = mjp.a(this.a.jdField_a_of_type_Mjp).aQ(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem.getId());
    ThreadManager.getUIHandler().post(new ReadInJoyDraftboxAdapter.2.1.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */