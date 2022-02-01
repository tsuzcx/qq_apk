package com.tencent.biz.pubaccount.readinjoy.view.fastweb;

import java.util.ArrayList;
import java.util.List;

class FastWebActivity$RecommendAndAdCallback$1
  implements Runnable
{
  FastWebActivity$RecommendAndAdCallback$1(FastWebActivity.b paramb, List paramList1, List paramList2, FastWebActivity paramFastWebActivity, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    Object localObject2 = this.kg;
    List localList = this.kh;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    localObject2 = localList;
    if (localList == null) {
      localObject2 = new ArrayList();
    }
    FastWebActivity.a(this.e, this.val$isSucc, this.XS, (List)localObject1, (List)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.RecommendAndAdCallback.1
 * JD-Core Version:    0.7.0.1
 */