package com.tencent.mobileqq.troop.filemanager;

import achq.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import apdy;
import apef.b;
import aqnv;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import jnm.d;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.observer.CheckConErroObserver;

public class TroopFileProtoReqMgr
{
  private ConcurrentHashMap<Intent, c> iF = new ConcurrentHashMap();
  private AppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  void a(Intent paramIntent, c paramc)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].finished = true;
    paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].finishTime = System.currentTimeMillis();
  }
  
  void a(ProtoRequestRunnable paramProtoRequestRunnable, long paramLong)
  {
    paramProtoRequestRunnable.cNf = true;
    this.mHandler.postDelayed(paramProtoRequestRunnable, paramLong);
  }
  
  public void a(b paramb)
  {
    int k = 0;
    if (paramb != null) {}
    for (;;)
    {
      try
      {
        apef.b.i("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + paramb.cookie + "> sendProtoRequest. ssocmd:" + paramb.clW + " tryCount:" + paramb.tryCount + " fixtryCount:" + paramb.dPR + " fastResend:" + paramb.cNd + " RemindSlowNet:" + paramb.cNe);
        c localc = new c();
        paramb.b = localc;
        localc.b = paramb;
        localc.startTime = System.currentTimeMillis();
        localc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new ProtoRequestRunnable[paramb.tryCount];
        int i = 0;
        int j = k;
        if (i < paramb.tryCount)
        {
          Object localObject = new ProtoRequestRunnable();
          localc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((ProtoRequestRunnable)localObject).b = localc;
          ((ProtoRequestRunnable)localObject).l = new NewIntent(this.mApp.getApp(), apdy.class);
          localObject = ((ProtoRequestRunnable)localObject).l;
          if (paramb.bo != null) {
            ((NewIntent)localObject).putExtras(paramb.bo);
          }
          ((NewIntent)localObject).putExtra("data", paramb.fW);
          ((NewIntent)localObject).putExtra("cmd", paramb.clW);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", paramb.cNd);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramb.cNe);
          i += 1;
          continue;
        }
        if (j < paramb.dPR)
        {
          long l1 = paramb.daB * j / paramb.dPR;
          long l2 = paramb.daB;
          long l3 = paramb.dPS * j;
          localc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].timeOut = (l2 - l1 - l3);
          a(localc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localc.dPU = paramb.dPR;
        return;
      }
      finally {}
      apef.b.e("TroopFileProtoReqMgr", apef.b.USR, "sendProtoRequest req=null");
    }
  }
  
  void a(c paramc)
  {
    paramc.cNg = true;
    int i = 0;
    while (i < paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.iF.remove(paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].l);
      this.mHandler.removeCallbacks(paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
      i += 1;
    }
  }
  
  boolean a(c paramc)
  {
    int i = 0;
    while (i < paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].finished) && ((paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].atH == true) || (paramc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].cNf == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(b paramb)
  {
    if (paramb != null) {}
    try
    {
      if (paramb.b != null)
      {
        apef.b.i("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + paramb.cookie + "> cancelRequest.");
        a(paramb.b);
      }
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  void c(NewIntent paramNewIntent)
  {
    this.mApp.startServlet(paramNewIntent);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    jnm.d locald = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localc = (c)this.iF.get(paramIntent);
        if (localc == null) {
          break label739;
        }
        if (localc.cNg)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = locald;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label634;
            }
            apef.b.i("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + localc.b.cookie + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localc.jdField_a_of_type_Achq$a.retryCount);
            ((jnm.d)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localc);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localc.b;
          i = ((b)localObject2).dTN;
          localc.g = paramFromServiceMsg;
          localc.jdField_a_of_type_Achq$a.errCode = localc.g.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          apef.b.i("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + localc.b.cookie + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localc);
            this.iF.remove(paramIntent);
            k = 1;
            if (((b)localObject2).c == null) {
              break label729;
            }
            ((Bundle)localObject1).putByteArray("data", aqnv.J(paramFromServiceMsg.getWupBuffer()));
            locald = ((b)localObject2).c;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = locald;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localc.startTime;
            if ((l1 < ((b)localObject2).dPT) && (localc.dPU < ((b)localObject2).tryCount))
            {
              long l2 = ((b)localObject2).daB;
              paramIntent = localc.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localc.dPU];
              localc.dPU += 1;
              paramIntent.timeOut = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = locald;
              continue;
            }
            apef.b.d("TroopFileProtoReqMgr", apef.b.CLR, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localc.dPU);
          }
          k = m;
          if (!a(localc)) {
            break label729;
          }
          a(localc);
          this.iF.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new a(localc, (b)localObject2));
            paramIntent.putExtra("action", 2201);
            this.mApp.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = locald;
            continue;
          }
          k = m;
          if (((b)localObject2).c == null) {
            break label729;
          }
          locald = ((b)localObject2).c;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = locald;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label634:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      apef.b.e("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + localc.b.cookie + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localc.jdField_a_of_type_Achq$a.retryCount);
      ((jnm.d)localObject1).a(-1, null, paramIntent);
      return;
      label729:
      paramIntent = (Intent)localObject1;
      Object localObject1 = locald;
      continue;
      label739:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = locald;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      c localc = null;
      i = 1;
      localObject1 = locald;
    }
  }
  
  class ProtoRequestRunnable
    implements Runnable
  {
    boolean atH = false;
    TroopFileProtoReqMgr.c b;
    boolean cNf = false;
    long finishTime;
    boolean finished = false;
    NewIntent l;
    long startTime;
    long timeOut;
    
    ProtoRequestRunnable() {}
    
    public void run()
    {
      int i = this.l.getIntExtra("key_runnable_index", 0);
      apef.b.i("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + this.b.b.cookie + "> sendToMsf. scheduleIndex:" + i + " timeOut:" + this.timeOut);
      this.atH = true;
      this.startTime = System.currentTimeMillis();
      this.l.putExtra("timeout", this.timeOut);
      achq.a locala = this.b.a;
      locala.retryCount += 1;
      TroopFileProtoReqMgr.a(TroopFileProtoReqMgr.this).put(this.l, this.b);
      TroopFileProtoReqMgr.this.c(this.l);
    }
  }
  
  public class a
    extends CheckConErroObserver
  {
    TroopFileProtoReqMgr.b jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b;
    TroopFileProtoReqMgr.c jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c;
    
    public a(TroopFileProtoReqMgr.c paramc, TroopFileProtoReqMgr.b paramb)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c = paramc;
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b = paramb;
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      Object localObject = "";
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("msf_con_erro");
        paramBundle = (Bundle)localObject;
        if (localObject == null) {
          paramBundle = "";
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopFileProtoReqMgr", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
        }
        localObject = paramBundle;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c != null)
        {
          FromServiceMsg localFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.g;
          localObject = paramBundle;
          if (localFromServiceMsg != null)
          {
            localFromServiceMsg.addAttribute("_tag_socket_connerror", paramBundle);
            localObject = paramBundle;
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b.c != null))
      {
        paramBundle = new Bundle();
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b.bo != null) {
          paramBundle.putAll(this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b.bo);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.g == null) {
          break label287;
        }
        paramBundle.putString("data_error_msg", this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.g.getBusinessFailMsg());
        paramBundle.putInt("data_error_code", this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.g.getBusinessFailCode());
        apef.b.e("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.b.cookie + "> onProtoResponse fail end. failCode:" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.g.getBusinessFailCode() + " retryCount:" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.a.retryCount + " msfConErro:" + (String)localObject);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b.c.a(-1, null, this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$b.bo);
        return;
        label287:
        apef.b.e("TroopFileProtoReqMgr", apef.b.USR, "cookie<" + this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$c.b.cookie + "> onProtoResponse fail end. msfConErro:" + (String)localObject);
      }
    }
  }
  
  public static class b
  {
    static long arj;
    TroopFileProtoReqMgr.c b;
    public Bundle bo;
    public jnm.d c;
    public boolean cNd = true;
    public boolean cNe = true;
    public String clW;
    long cookie;
    public int dPR = 3;
    public int dPS = 25;
    public int dPT = 450000;
    public int dTN = 1;
    public int daB = 480000;
    public byte[] fW;
    public int tryCount = 9;
    
    public b()
    {
      long l = arj + 1L;
      arj = l;
      this.cookie = l;
    }
  }
  
  public static class c
  {
    public achq.a a = new achq.a();
    public TroopFileProtoReqMgr.ProtoRequestRunnable[] a;
    public TroopFileProtoReqMgr.b b;
    boolean cNg = false;
    public int dPU;
    public FromServiceMsg g;
    public long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */