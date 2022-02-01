package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import yrr;
import yrw;
import yrx;
import yry;
import ysa;
import ysc;
import ysd;
import yse;
import ysf;
import ysl;
import ysr;
import yss;
import yst;
import ysu;
import ysv;
import ysw;
import ysx;
import ysy;
import ysz;
import yta;
import ytc;
import ytd;
import yto;
import ytp;
import ytq;
import ytr;
import yts;
import ytt;
import ytu;
import ytv;
import ytw;
import ytx;
import yty;
import ytz;
import yua;
import yub;
import yuc;
import yud;
import yue;
import yuf;
import yug;

class SystemMsgListAdapter$1$1
  implements Runnable
{
  SystemMsgListAdapter$1$1(SystemMsgListAdapter.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    ytd.a(this.a.this$0).clear();
    ytd.a(this.a.this$0).clear();
    Iterator localIterator = this.rm.iterator();
    boolean bool1 = false;
    int i = 0;
    ytv localytv;
    Object localObject;
    if (localIterator.hasNext())
    {
      localytv = (ytv)localIterator.next();
      if ((localytv instanceof yts))
      {
        localObject = new yry(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv, ytd.a(this.a.this$0));
        ((yry)localObject).Ex(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ytd.a(this.a.this$0).add(localObject);
      }
      break;
      if ((localytv instanceof ytp))
      {
        localObject = new yrx(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof yto))
      {
        if (ytd.a(this.a.this$0) == null)
        {
          localObject = new yrw(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
          ytd.a(this.a.this$0, (yrw)localObject);
        }
        else
        {
          localObject = ytd.a(this.a.this$0);
          ((ysa)localObject).a(localytv);
        }
      }
      else if ((localytv instanceof ytq))
      {
        localObject = new ytc(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
        if (((ytc)localObject).Ky != 0L) {
          ytd.a(this.a.this$0).add(Long.valueOf(((ytc)localObject).Ky));
        }
      }
      else if ((localytv instanceof yty))
      {
        localObject = new yss(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof ytw))
      {
        localObject = new ysl(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof ytt))
      {
        localObject = new ysc(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof ytu))
      {
        localObject = new ysd(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof yue))
      {
        localObject = new ysy(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof yuf))
      {
        localObject = new ysz(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof yug))
      {
        localObject = new yta(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof yud))
      {
        localObject = new ysx(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof ytz))
      {
        localObject = new yst(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof yua))
      {
        localObject = new ysu(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
        boolean bool2 = ytd.a(this.a.this$0, this.a.cbd);
        ((ysu)localObject).AJ(bool2);
      }
      else if ((localytv instanceof ytr))
      {
        localObject = new yse(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
      }
      else if ((localytv instanceof ytx))
      {
        localObject = new ysr(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
        Handler localHandler = this.a.this$0.mUiHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localytv));
        }
      }
      else if ((localytv instanceof yuc))
      {
        localObject = new ysw(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
        bool1 = true;
      }
      else if ((localytv instanceof yub))
      {
        localObject = new ysv(ytd.a(this.a.this$0), ytd.a(this.a.this$0), this.a.this$0, localytv);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + ytd.a(this.a.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          ytd.a(this.a.this$0).clb();
          ytd.a(this.a.this$0, i, this.a.cbd);
        }
        for (;;)
        {
          this.a.this$0.b.clB();
          this.a.this$0.notifyDataSetChanged();
          if (ytd.a(this.a.this$0))
          {
            if ((ytd.a(this.a.this$0) == 2) && (ytd.a(this.a.this$0).xp() == 0) && (ytd.a(this.a.this$0).xq() > 0) && (ytd.a(this.a.this$0).xn() >= 3))
            {
              i = ytd.a(this.a.this$0).xo();
              this.a.this$0.b.setSelection(i);
            }
            ytd.a(this.a.this$0, false);
          }
          return;
          ytd.a(this.a.this$0).reset();
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */