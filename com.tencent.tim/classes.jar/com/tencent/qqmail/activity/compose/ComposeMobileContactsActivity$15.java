package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Observer;

class ComposeMobileContactsActivity$15
  implements Observer<HashMap<String, Integer>>
{
  ComposeMobileContactsActivity$15(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(HashMap<String, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramHashMap == null) {
      ComposeMobileContactsActivity.access$2000(this.this$0).setIndexList(localArrayList);
    }
    for (;;)
    {
      ComposeMobileContactsActivity.access$2000(this.this$0).show();
      return;
      ComposeMobileContactsActivity.access$1100(this.this$0).setSectionMap(paramHashMap);
      localArrayList.addAll(paramHashMap.keySet());
      ComposeMobileContactsActivity.access$2000(this.this$0).setIndexList(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.15
 * JD-Core Version:    0.7.0.1
 */