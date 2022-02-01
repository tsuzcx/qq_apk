package com.tencent.biz.pubaccount.readinjoy.ugc;

import java.util.List;
import kbp;
import mjp;
import mjr;

class ReadInJoyDraftboxAdapter$2$1$1
  implements Runnable
{
  ReadInJoyDraftboxAdapter$2$1$1(ReadInJoyDraftboxAdapter.2.1 param1, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$success)
    {
      kbp.a(null, "", "0X80096E0", "0X80096E0", 0, 0, mjp.a(this.a.a.jdField_a_of_type_Mjp, this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDraftboxItem) + "", "", "", "", false);
      mjp.a(this.a.a.jdField_a_of_type_Mjp).remove(this.a.a.val$position);
      this.a.a.jdField_a_of_type_Mjp.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxAdapter.2.1.1
 * JD-Core Version:    0.7.0.1
 */