package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import aqmj;
import awit;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import kbp;
import kct;
import kxm;
import kxm.b;
import mfo;
import mfs;

class ReadInJoyListViewGroup$31
  implements Runnable
{
  ReadInJoyListViewGroup$31(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void run()
  {
    int m = 0;
    Object localObject2 = "0";
    int k = 0;
    if (!ReadInJoyListViewGroup.a(this.this$0)) {
      if (!(this.this$0.getCurrentActivity() instanceof BaseActivity)) {
        break label376;
      }
    }
    label357:
    label376:
    for (boolean bool = aqmj.aJ(this.this$0.getContext(), ((BaseActivity)this.this$0.getCurrentActivity()).getCurrentAccountUin());; bool = false)
    {
      if ((this.this$0.getContext() instanceof BaseActivity)) {}
      for (Object localObject1 = ((mfs)((BaseActivity)this.this$0.getContext()).app.getManager(261)).jM();; localObject1 = "0")
      {
        int i;
        if ((TextUtils.isEmpty((CharSequence)localObject1)) || (((String)localObject1).equals("0")))
        {
          j = 0;
          localObject1 = "0";
          i = 0;
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!(this.this$0.getContext() instanceof BaseActivity)) {
            break label357;
          }
          mfo localmfo = (mfo)((BaseActivity)this.this$0.getContext()).app.getManager(270);
          k = i;
          localObject2 = localObject1;
          m = j;
          if (localmfo.oH() != 1) {
            break label357;
          }
          k = i;
          localObject2 = localObject1;
          m = j;
          if (!localmfo.Dz()) {
            break label357;
          }
          localObject1 = localmfo.jL();
          i = 0;
        }
        for (int j = 2;; j = k)
        {
          if (this.this$0.mChannelID == 40677)
          {
            kbp.a(null, "CliOper", "", "", "0X8009294", "0X8009294", 0, 0, awit.sn("default_feeds_proteus_offline_bid"), "", "", kxm.a(this.this$0.mChannelID, (String)localObject1, i, j, false, -1).build(), false);
            kbp.d("0X8009294", "", "", "", "", kxm.bc(this.this$0.mChannelID));
          }
          if (this.this$0.mChannelID == 56) {
            kbp.a(null, "", "0X8007413", "0X8007413", 0, 0, "", "1", "", kct.a(this.this$0.mChannelID, null), false);
          }
          return;
          if (bool)
          {
            i = 1;
            j = 1;
            break;
          }
          i = 1;
          j = 2;
          break;
          localObject1 = localObject2;
          i = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.31
 * JD-Core Version:    0.7.0.1
 */