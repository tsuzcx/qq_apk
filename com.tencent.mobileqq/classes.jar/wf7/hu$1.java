package wf7;

import com.wifisdk.ui.view.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class hu$1
  implements Runnable
{
  hu$1(hu paramhu, boolean paramBoolean) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    LinkedList localLinkedList;
    hu localhu;
    if ((hu.a(this.ui) & 0x1) != 0)
    {
      localLinkedList = hu.a(this.ui, 1);
      localhu = this.ui;
      hu.a(localhu, localLinkedList, hu.b(localhu));
      if (hj.a(localLinkedList))
      {
        hu.a(this.ui, localLinkedList);
        localArrayList.add(new ho("免费WiFi"));
        localArrayList.addAll(localLinkedList);
        if (!hu.c(this.ui))
        {
          hk.az(500777);
          hu.a(this.ui, true);
        }
      }
    }
    if ((hu.a(this.ui) & 0x2) != 0)
    {
      localLinkedList = hu.a(this.ui, 2);
      localhu = this.ui;
      hu.a(localhu, localLinkedList, hu.b(localhu));
      if (hj.a(localLinkedList))
      {
        hu.b(this.ui, localLinkedList);
        localArrayList.add(new ho("其他WiFi"));
        localArrayList.addAll(localLinkedList);
      }
    }
    if (hj.a(localArrayList))
    {
      hu.d(this.ui).fH();
      hu.d(this.ui).b(localArrayList, this.uh);
      return;
    }
    hu.d(this.ui).aD(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.hu.1
 * JD-Core Version:    0.7.0.1
 */