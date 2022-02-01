package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Subscriber;

class ComposeContactsActivity$20
  extends Subscriber<HashMap<String, Integer>>
{
  ComposeContactsActivity$20(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(HashMap<String, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramHashMap == null)
    {
      ComposeContactsActivity.access$2300(this.this$0).setIndexList(localArrayList);
      ComposeContactsActivity.access$2300(this.this$0).show();
      return;
    }
    if (!ComposeContactsActivity.access$1400(this.this$0).isHasShowAll()) {
      paramHashMap.put("&", Integer.valueOf(ComposeContactsActivity.access$1400(this.this$0).getDefaultShowCount()));
    }
    for (;;)
    {
      ComposeContactsActivity.access$1400(this.this$0).setSectionMap(paramHashMap);
      localArrayList.addAll(paramHashMap.keySet());
      ComposeContactsActivity.access$2300(this.this$0).setIndexList(localArrayList);
      break;
      paramHashMap.put("&", Integer.valueOf(ComposeContactsActivity.access$1400(this.this$0).getHistoryContactCount()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.20
 * JD-Core Version:    0.7.0.1
 */