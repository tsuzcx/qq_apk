package com.tencent.qqmail.namelist.fragment;

import com.tencent.qqmail.namelist.NameListAdapter;
import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Observer;

class NameListMainFragment$14
  implements Observer<HashMap<String, Integer>>
{
  NameListMainFragment$14(NameListMainFragment paramNameListMainFragment) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(HashMap<String, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    NameListMainFragment.access$300(this.this$0).setSectionMap(paramHashMap);
    if (paramHashMap != null) {
      localArrayList.addAll(paramHashMap.keySet());
    }
    NameListMainFragment.access$1800(this.this$0).setIndexList(localArrayList);
    NameListMainFragment.access$1800(this.this$0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.14
 * JD-Core Version:    0.7.0.1
 */