package com.tencent.qqmail.model.contact;

import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import java.util.HashMap;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

class QMContactManager$2
  implements Observable.OnSubscribe<HashMap<String, Integer>>
{
  QMContactManager$2(QMContactManager paramQMContactManager, ContactBaseListCursor paramContactBaseListCursor) {}
  
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
 * Qualified Name:     com.tencent.qqmail.model.contact.QMContactManager.2
 * JD-Core Version:    0.7.0.1
 */