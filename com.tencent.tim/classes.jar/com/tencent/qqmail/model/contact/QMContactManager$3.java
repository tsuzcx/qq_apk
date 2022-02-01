package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.namelist.cursor.NameListBaseCursor;
import java.util.HashMap;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMContactManager$3
  implements Observable.OnSubscribe<HashMap<String, Integer>>
{
  QMContactManager$3(QMContactManager paramQMContactManager, NameListBaseCursor paramNameListBaseCursor) {}
  
  public void call(Subscriber<? super HashMap<String, Integer>> paramSubscriber)
  {
    if (this.val$contactBaseListCursor == null) {}
    for (Object localObject = null;; localObject = this.val$contactBaseListCursor.getSectionMap())
    {
      paramSubscriber.onNext(localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.3
 * JD-Core Version:    0.7.0.1
 */