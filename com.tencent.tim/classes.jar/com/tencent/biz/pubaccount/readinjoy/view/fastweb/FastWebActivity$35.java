package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import java.util.List;
import nlc;

class FastWebActivity$35
  implements Runnable
{
  FastWebActivity$35(FastWebActivity paramFastWebActivity, BaseData paramBaseData) {}
  
  public void run()
  {
    int j = FastWebActivity.a(this.this$0).size();
    int i = 0;
    if (i < j)
    {
      BaseData localBaseData = (BaseData)FastWebActivity.a(this.this$0).get(i);
      if (((localBaseData.type == 10) || (localBaseData.type == 17) || (localBaseData.type == 22) || (localBaseData.type == 24) || (localBaseData.type == 9)) && (localBaseData == this.e)) {
        FastWebActivity.a(this.this$0).remove(i);
      }
    }
    for (;;)
    {
      if (i >= 0) {
        FastWebActivity.a(this.this$0).dl(i, j);
      }
      FastWebActivity.a(this.this$0).notifyDataSetChanged();
      return;
      i += 1;
      break;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.35
 * JD-Core Version:    0.7.0.1
 */