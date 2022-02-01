package com.tencent.biz.pubaccount.AccountDetail.adapter;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import jtg;
import jtg.h;
import jts;
import jtt;
import jtu;
import jtv;
import kwz;
import noy;
import noz;

public class AccountDetailBaseAdapter$14
  implements Runnable
{
  public AccountDetailBaseAdapter$14(jtg paramjtg, long paramLong1, List paramList, int paramInt1, int paramInt2, long paramLong2) {}
  
  public void run()
  {
    if (jtg.a(this.this$0) != this.qD) {}
    label25:
    LinkedList localLinkedList;
    label38:
    label80:
    label232:
    do
    {
      do
      {
        return;
        int i;
        int j;
        if (this.fN == null)
        {
          i = 0;
          localLinkedList = new LinkedList();
          j = this.val$start;
          if (j >= this.val$start + this.aDo) {
            continue;
          }
          if ((j < i) && (j >= 0)) {
            break label80;
          }
        }
        for (;;)
        {
          j += 1;
          break label38;
          i = this.fN.size();
          break label25;
          if (jtg.a(this.this$0) != this.qD) {
            break;
          }
          try
          {
            jts localjts = (jts)this.fN.get(j);
            if (localjts == null) {
              continue;
            }
            if (localjts.jdField_a_of_type_Jtt.msgtype != 2) {
              break label232;
            }
            if (localjts.jdField_a_of_type_Jtv == null) {
              continue;
            }
            if (localjts.jdField_a_of_type_Jtv.large != 1) {
              break label201;
            }
            localLinkedList.add(jtg.h.a(new URL(localjts.jdField_a_of_type_Jtv.Un), kwz.i()));
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
          if (jtg.a(this.this$0) != this.qD)
          {
            return;
            localLinkedList.add(jtg.h.a(new URL(localException.jdField_a_of_type_Jtv.cover), kwz.d()));
            continue;
            if (localException.jdField_a_of_type_Jtu != null) {
              if (localException.jdField_a_of_type_Jtu.large == 1) {
                localLinkedList.add(jtg.h.a(new URL(localException.jdField_a_of_type_Jtu.Un), kwz.i()));
              } else {
                localLinkedList.add(jtg.h.a(new URL(localException.jdField_a_of_type_Jtu.cover), kwz.d()));
              }
            }
          }
        }
      } while (jtg.a(this.this$0) != this.qD);
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        jtg.h localh = (jtg.h)localIterator.next();
        if ((localh != null) && (localh.url != null))
        {
          noz localnoz = new noz();
          localnoz.url = localh.url;
          localnoz.reqWidth = ((Integer)localh.c.first).intValue();
          localnoz.reqHeight = ((Integer)localh.c.second).intValue();
          noy.a().a(localnoz, null);
        }
      }
    } while (!QLog.isColorLevel());
    label201:
    QLog.d("AccountDetailBaseAdapter", 2, "preloadImg size:" + localLinkedList.size() + " cost:" + (System.currentTimeMillis() - this.qE));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.adapter.AccountDetailBaseAdapter.14
 * JD-Core Version:    0.7.0.1
 */