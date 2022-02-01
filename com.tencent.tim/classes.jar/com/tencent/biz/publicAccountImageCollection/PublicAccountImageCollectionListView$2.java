package com.tencent.biz.publicAccountImageCollection;

import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import noy;
import noz;
import otd;
import oub.c;

class PublicAccountImageCollectionListView$2
  implements Runnable
{
  PublicAccountImageCollectionListView$2(PublicAccountImageCollectionListView paramPublicAccountImageCollectionListView, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (PublicAccountImageCollectionListView.a(this.this$0) != this.qD) {}
    label25:
    LinkedList localLinkedList;
    label39:
    label82:
    do
    {
      Object localObject;
      do
      {
        return;
        int i;
        int j;
        if (this.li == null)
        {
          i = 0;
          localLinkedList = new LinkedList();
          j = this.val$start;
          if (j >= this.val$start + this.aDo) {
            continue;
          }
          if ((j <= i) && (j >= 1)) {
            break label82;
          }
        }
        do
        {
          for (;;)
          {
            j += 1;
            break label39;
            i = this.li.size();
            break label25;
            if (PublicAccountImageCollectionListView.a(this.this$0) != this.qD) {
              break;
            }
            try
            {
              oub.c localc = (oub.c)this.li.get(j - 1);
              if (localc != null)
              {
                localObject = ((otd)this.this$0.getAdapter()).e(localc.url);
                if (localObject == null) {
                  break;
                }
                int k = ((otd)this.this$0.getAdapter()).a(localc)[0];
                int m = ((otd)this.this$0.getAdapter()).a(localc)[1];
                localLinkedList.add(PublicAccountImageCollectionListView.b.a((URL)localObject, k, m));
                if (QLog.isColorLevel()) {
                  QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg index:" + j + "  reqWidth = " + k + " reqHeight = " + m);
                }
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        } while (PublicAccountImageCollectionListView.a(this.this$0) == this.qD);
        return;
      } while (PublicAccountImageCollectionListView.a(this.this$0) != this.qD);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (PublicAccountImageCollectionListView.b)localIterator.next();
        if ((localObject != null) && (((PublicAccountImageCollectionListView.b)localObject).url != null))
        {
          noz localnoz = new noz();
          localnoz.url = ((PublicAccountImageCollectionListView.b)localObject).url;
          localnoz.reqWidth = ((PublicAccountImageCollectionListView.b)localObject).reqWidth;
          localnoz.reqHeight = ((PublicAccountImageCollectionListView.b)localObject).reqHeight;
          noy.a().a(localnoz, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.qE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionListView.2
 * JD-Core Version:    0.7.0.1
 */