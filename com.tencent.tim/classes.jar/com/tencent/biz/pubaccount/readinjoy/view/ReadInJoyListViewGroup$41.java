package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import kxm;
import mqq.app.AppRuntime;

class ReadInJoyListViewGroup$41
  implements Runnable
{
  ReadInJoyListViewGroup$41(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).a();
    if (localKandianMsgBoxRedPntInfo == null)
    {
      ReadInJoyListViewGroup.b(this.this$0);
      return;
    }
    ReadInJoyListViewGroup.a(this.this$0, localKandianMsgBoxRedPntInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.41
 * JD-Core Version:    0.7.0.1
 */