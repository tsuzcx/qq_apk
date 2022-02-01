package com.tencent.qqmail.activity.contacts.fragment;

import com.tencent.qqmail.utilities.ui.QMSideIndexer;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Observer;

class ContactsListFragment$23
  implements Observer<HashMap<String, Integer>>
{
  ContactsListFragment$23(ContactsListFragment paramContactsListFragment) {}
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable) {}
  
  public void onNext(HashMap<String, Integer> paramHashMap)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramHashMap == null) {
      ContactsListFragment.access$3600(this.this$0).setIndexList(localArrayList);
    }
    for (;;)
    {
      ContactsListFragment.access$3600(this.this$0).show();
      return;
      ContactsListFragment.access$1200(this.this$0).setSectionMap(paramHashMap);
      if (ContactsListFragment.access$200(this.this$0) == 0) {
        localArrayList.add(0, "Ξ");
      }
      localArrayList.addAll(paramHashMap.keySet());
      ContactsListFragment.access$3600(this.this$0).setIndexList(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.fragment.ContactsListFragment.23
 * JD-Core Version:    0.7.0.1
 */