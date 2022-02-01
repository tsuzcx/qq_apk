package com.tencent.mobileqq.redtouch;

import acii;
import altk;
import altl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi;
import com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgRspBody;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.s2c.msgtype0x210.submsgtype0x89.Submsgtype0x89.NumRedBusiInfo;

public class NumRedMsgManager$1
  implements Runnable
{
  public NumRedMsgManager$1(altl paramaltl, List paramList, altk paramaltk, String paramString) {}
  
  public void run()
  {
    int k = 0;
    if ((this.Fo == null) || (this.Fo.size() < 1) || (this.a == null)) {
      return;
    }
    if ((this.this$0.gG != null) && (!this.this$0.gG.containsKey(Integer.valueOf(this.a.key)))) {
      this.this$0.gG.put(Integer.valueOf(this.a.key), this.a);
    }
    Object localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = this.this$0.a();
    int j;
    if (localObject2 != null)
    {
      localObject2 = ((NumRedMsg.NumMsgRspBody)localObject2).rpt_num_red.get();
      if (localObject2 != null)
      {
        i = 0;
        if (i < this.Fo.size())
        {
          j = 0;
          for (;;)
          {
            if (j >= ((List)localObject2).size()) {
              break label585;
            }
            if (((NumRedMsg.NumMsgBusi)((List)localObject2).get(j)).ui64_msgid.get() == ((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).uint32_app_id.get())
            {
              ((List)localObject1).add(((List)localObject2).get(j));
              j = 1;
              if (j == 0)
              {
                NumRedMsg.NumMsgBusi localNumMsgBusi = new NumRedMsg.NumMsgBusi();
                localNumMsgBusi.ui64_msgid.set(((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).uint64_msgid.get());
                localNumMsgBusi.ui_appid.set(((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).uint32_android_app_id.get());
                localNumMsgBusi.str_path.set(((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).str_android_path.get());
                localArrayList.add(localNumMsgBusi);
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
        i = 0;
        while (i < this.Fo.size())
        {
          localObject2 = new NumRedMsg.NumMsgBusi();
          ((NumRedMsg.NumMsgBusi)localObject2).ui64_msgid.set(((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).uint64_msgid.get());
          ((NumRedMsg.NumMsgBusi)localObject2).ui_appid.set(((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).uint32_android_app_id.get());
          ((NumRedMsg.NumMsgBusi)localObject2).str_path.set(((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).str_android_path.get());
          localArrayList.add(localObject2);
          i += 1;
        }
      }
      if (((List)localObject1).size() == this.Fo.size())
      {
        this.a.g(this.val$cmd, (List)localObject1);
        return;
      }
      localObject1 = new long[this.Fo.size()];
      i = k;
      while (i < this.Fo.size())
      {
        localObject1[i] = ((Submsgtype0x89.NumRedBusiInfo)this.Fo.get(i)).uint64_msgid.get();
        i += 1;
      }
      this.this$0.a.a(localArrayList, this.a.key, this.val$cmd, (long[])localObject1);
      return;
      label585:
      j = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.NumRedMsgManager.1
 * JD-Core Version:    0.7.0.1
 */