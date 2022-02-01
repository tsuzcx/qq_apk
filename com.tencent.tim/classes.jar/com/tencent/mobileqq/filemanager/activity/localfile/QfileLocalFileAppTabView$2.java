package com.tencent.mobileqq.filemanager.activity.localfile;

import ahaf;
import ahap;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QfileLocalFileAppTabView$2
  implements Runnable
{
  QfileLocalFileAppTabView$2(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    Object localObject;
    if (this.this$0.cdi)
    {
      ahap.a(this.this$0.a, this.this$0);
      ahap.a(true, ahaf.a().vZ(), ".apk", "", localHashMap, this.this$0);
      localObject = ahaf.a().vY();
      if (localObject != null) {
        ahap.a(true, (String)localObject, ".apk", "", localHashMap, null);
      }
    }
    for (;;)
    {
      ahap.ai(localHashMap);
      QfileLocalFileAppTabView.a(this.this$0, new QfileLocalFileAppTabView.2.1(this));
      return;
      localObject = this.this$0.AS.iterator();
      while (((Iterator)localObject).hasNext()) {
        ahap.a(true, ((QfileTabBarView.a)((Iterator)localObject).next()).wd(), ".apk", "", localHashMap, this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2
 * JD-Core Version:    0.7.0.1
 */