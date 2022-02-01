package com.tencent.mobileqq.webview;

import aqym;
import com.tencent.widget.ListView;
import java.lang.ref.WeakReference;
import wki;

public class UrlSecurityCheckManager$2
  implements Runnable
{
  public UrlSecurityCheckManager$2(aqym paramaqym, WeakReference paramWeakReference1, WeakReference paramWeakReference2) {}
  
  public void run()
  {
    ListView localListView = (ListView)this.W.get();
    wki localwki = (wki)this.iA.get();
    if ((localListView != null) && (localwki != null)) {
      aqym.a(this.this$0, localListView, localwki);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.2
 * JD-Core Version:    0.7.0.1
 */