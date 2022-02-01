package com.tencent.qqmail.uma;

import java.util.ArrayList;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

class QMUmaManager$62
  extends ArrayList<Cookie>
{
  QMUmaManager$62(QMUmaManager paramQMUmaManager, QMUmaManager.QMUmaSession paramQMUmaSession)
  {
    add(new BasicClientCookie("v", String.valueOf(this.val$session.umaId)));
    add(new BasicClientCookie("av", QMUmaManager.access$1700(this.this$0)));
    add(new BasicClientCookie("o", "Android REL"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.uma.QMUmaManager.62
 * JD-Core Version:    0.7.0.1
 */