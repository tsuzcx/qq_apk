package com.tencent.mobileqq.redtouch;

import acii;
import altk;
import altl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class NumRedMsgManager$2
  implements Runnable
{
  public NumRedMsgManager$2(altl paramaltl, long[] paramArrayOfLong, altk paramaltk, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    int k = 0;
    if ((this.ao.length < 1) || (this.a == null)) {
      return;
    }
    if (!this.this$0.gG.containsKey(Integer.valueOf(this.a.key))) {
      this.this$0.gG.put(Integer.valueOf(this.a.key), this.a);
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.this$0.a();
    int j;
    if (localObject != null)
    {
      localObject = ((NumRedMsg.NumMsgRspBody)localObject).rpt_num_red.get();
      if (localObject != null)
      {
        i = 0;
        if (i < this.ao.length)
        {
          j = 0;
          for (;;)
          {
            if (j >= ((List)localObject).size()) {
              break label355;
            }
            if (((NumRedMsg.NumMsgBusi)((List)localObject).get(j)).ui64_msgid.get() == this.ao[i])
            {
              localArrayList1.add(((List)localObject).get(j));
              j = 1;
              if (j == 0)
              {
                NumRedMsg.NumMsgBusi localNumMsgBusi = new NumRedMsg.NumMsgBusi();
                localNumMsgBusi.ui64_msgid.set(this.ao[i]);
                localArrayList2.add(localNumMsgBusi);
              }
              i += 1;
              break;
            }
            j += 1;
          }
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        i = k;
        while (i < this.ao.length)
        {
          localObject = new NumRedMsg.NumMsgBusi();
          ((NumRedMsg.NumMsgBusi)localObject).ui64_msgid.set(this.ao[i]);
          localArrayList2.add(localObject);
          i += 1;
        }
      }
      if ((localArrayList1.size() == this.ao.length) || (this.czg))
      {
        this.a.g(this.val$cmd, localArrayList1);
        return;
      }
      this.this$0.a.a(localArrayList2, this.a.key, this.val$cmd, this.ao);
      return;
      label355:
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager.2
 * JD-Core Version:    0.7.0.1
 */