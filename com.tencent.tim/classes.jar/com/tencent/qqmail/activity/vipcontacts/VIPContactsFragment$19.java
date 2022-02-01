package com.tencent.qqmail.activity.vipcontacts;

import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Observer;

class VIPContactsFragment$19
  implements Observer<HashMap<String, Integer>>
{
  VIPContactsFragment$19(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(HashMap<String, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramHashMap == null) {
      VIPContactsFragment.access$2900(this.this$0).setIndexList(localArrayList);
    }
    for (;;)
    {
      VIPContactsFragment.access$2900(this.this$0).show();
      return;
      VIPContactsFragment.access$2000(this.this$0).setSectionMap(paramHashMap);
      if (VIPContactsFragment.access$700(this.this$0) == 0) {
        localArrayList.add(0, "Ξ");
      }
      localArrayList.addAll(paramHashMap.keySet());
      VIPContactsFragment.access$2900(this.this$0).setIndexList(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.19
 * JD-Core Version:    0.7.0.1
 */