package com.tencent.mobileqq.transfile;

import achq.a;
import alig;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import aomp;
import aona;
import aqoj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mqq.observer.CheckConErroObserver;

public class ProtoReqManager
  implements DeviceProfileManager.a
{
  private boolean cNc;
  ConcurrentHashMap<Intent, d> iF = new ConcurrentHashMap();
  private AppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  private void a(Intent paramIntent, d paramd)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].finished = true;
    paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].finishTime = System.currentTimeMillis();
  }
  
  private void a(d paramd)
  {
    paramd.cNg = true;
    int i = 0;
    while (i < paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.iF.remove(paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].l);
      this.mHandler.removeCallbacks(paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(c paramc)
  {
    return ("PttStore.GroupPttUp".equals(paramc.clW)) || ("PttStore.GroupPttDown".equals(paramc.clW)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(paramc.clW)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramc.clW));
  }
  
  private boolean b(d paramd)
  {
    int i = 0;
    while (i < paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].finished) && ((paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].atH == true) || (paramd.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].cNf == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void c(c paramc)
  {
    paramc.daB = aona.KQ();
    paramc.tryCount = aona.KO();
    paramc.dPR = aona.KP();
  }
  
  private void d(c paramc)
  {
    if ((this.mApp instanceof QQAppInterface))
    {
      paramc.daB = alig.T((QQAppInterface)this.mApp);
      paramc.tryCount = alig.U((QQAppInterface)this.mApp);
      paramc.dPR = alig.V((QQAppInterface)this.mApp);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + paramc.daB + paramc.tryCount + paramc.dPR);
      }
    }
  }
  
  private void dVT()
  {
    if (DeviceProfileManager.a().Ap() == 4) {
      aona.Sa(DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  void a(ProtoReqRunnable paramProtoReqRunnable, long paramLong)
  {
    paramProtoReqRunnable.cNf = true;
    this.mHandler.postDelayed(paramProtoReqRunnable, paramLong);
  }
  
  public void b(c paramc)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramc.clW);
        }
        if (!this.cNc)
        {
          dVT();
          this.cNc = true;
        }
        localObject1 = this.mApp;
        if (localObject1 == null) {
          return;
        }
        if (paramc == null) {
          continue;
        }
        if ((paramc.clW != null) && ((paramc.clW.equals("ImgStore.GroupPicUp")) || (paramc.clW.equals("LongConn.OffPicUp")))) {
          c(paramc);
        }
        if ((paramc.clW != null) && ((paramc.clW.equals("PttStore.GroupPttUp")) || (paramc.clW.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(paramc);
        }
        localObject1 = new d();
        paramc.b = ((d)localObject1);
        ((d)localObject1).b = paramc;
        ((d)localObject1).startTime = System.currentTimeMillis();
        ((d)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqRunnable[paramc.tryCount];
        byte[] arrayOfByte = paramc.fW;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= paramc.tryCount) {
          break label513;
        }
        localObject2 = new ProtoReqRunnable();
        ((d)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqRunnable)localObject2).b = ((d)localObject1);
        ((ProtoReqRunnable)localObject2).l = new NewIntent(this.mApp.getApp(), aomp.class);
        localObject2 = ((ProtoReqRunnable)localObject2).l;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", paramc.clW);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", paramc.cNd);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramc.cNe);
        if ((!a(paramc)) || (!(this.mApp instanceof QQAppInterface)) || (!alig.bw((QQAppInterface)this.mApp))) {
          break label506;
        }
        ((NewIntent)localObject2).putExtra("quickSendEnable", true);
        ((NewIntent)localObject2).putExtra("quickSendStrategy", 1);
        if (!QLog.isColorLevel()) {
          break label506;
        }
        QLog.d("http_sideway", 2, "set");
      }
      finally {}
      if (i < paramc.dPR)
      {
        long l1 = paramc.daB * i / paramc.dPR;
        long l2 = paramc.daB;
        long l3 = paramc.dPS * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].timeOut = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((d)localObject1).dPU = paramc.dPR;
        continue;
        label506:
        i += 1;
        continue;
        label513:
        i = 0;
      }
    }
  }
  
  void c(NewIntent paramNewIntent)
  {
    if (this.mApp != null) {
      this.mApp.startServlet(paramNewIntent);
    }
  }
  
  public void e(c paramc)
  {
    if (paramc != null) {}
    try
    {
      if (paramc.b != null) {
        a(paramc.b);
      }
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.ProtoReqManager", 2, "onDestroy ");
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mApp = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    for (;;)
    {
      b localb;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label540;
        }
        localObject = (d)this.iF.get(paramIntent);
        if (localObject == null) {
          break label525;
        }
        if (((d)localObject).cNg)
        {
          localc = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localc;
          if (localObject != null) {
            ((b)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (d)localObject);
        localc = ((d)localObject).b;
        ((d)localObject).g = paramFromServiceMsg;
        ((d)localObject).jdField_a_of_type_Achq$a.errCode = ((d)localObject).g.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((d)localObject);
          this.iF.remove(paramIntent);
          if (localc.a != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            aqoj.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localb = localc.a;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localc;
            localObject = localb;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((d)localObject).startTime;
            if ((l1 < localc.dPT) && (((d)localObject).dPU < localc.tryCount))
            {
              long l2 = localc.daB;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.dPU];
              ((d)localObject).dPU += 1;
              paramIntent.timeOut = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localb = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localc;
              localObject = localb;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((d)localObject).dPU);
            }
          }
          if (b((d)localObject))
          {
            a((d)localObject);
            this.iF.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new a((d)localObject, localc));
              paramIntent.putExtra("action", 2201);
              this.mApp.startServlet(paramIntent);
              localb = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localc;
              localObject = localb;
              continue;
            }
            if (localc.a != null)
            {
              localb = localc.a;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localc;
              localObject = localb;
              continue;
            }
          }
        }
        localb = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localc;
      localObject = localb;
      continue;
      label525:
      c localc = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localc;
      continue;
      label540:
      paramIntent = null;
      localc = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localc;
    }
  }
  
  public void sr(boolean paramBoolean)
  {
    if (paramBoolean) {
      aona.Sa(DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  class ProtoReqRunnable
    implements Runnable
  {
    boolean atH = false;
    ProtoReqManager.d b;
    boolean cNf = false;
    long finishTime;
    boolean finished = false;
    NewIntent l;
    long startTime;
    long timeOut;
    
    ProtoReqRunnable() {}
    
    public void run()
    {
      QLog.d("Q.richmedia.ProtoReqManager", 2, "ProtoReqRunnable.run() : resp.startTime" + this.b.startTime);
      this.atH = true;
      this.startTime = System.currentTimeMillis();
      this.l.putExtra("key_timeout", this.timeOut);
      achq.a locala = this.b.a;
      locala.retryCount += 1;
      ProtoReqManager.this.iF.put(this.l, this.b);
      ProtoReqManager.this.c(this.l);
    }
  }
  
  public class a
    extends CheckConErroObserver
  {
    ProtoReqManager.c jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$c;
    ProtoReqManager.d jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$d;
    
    public a(ProtoReqManager.d paramd, ProtoReqManager.c paramc)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$d = paramd;
      this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$c = paramc;
    }
    
    public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        Object localObject = paramBundle.getString("msf_con_erro");
        paramBundle = (Bundle)localObject;
        if (localObject == null) {
          paramBundle = "";
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "CheckConErroObserverImp.onReceive -> msfConErro: " + paramBundle);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$d != null)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$d.g;
          if (localObject != null) {
            ((FromServiceMsg)localObject).addAttribute("_tag_socket_connerror", paramBundle);
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$c.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$c.a.a(this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$d, this.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager$c);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(ProtoReqManager.d paramd, ProtoReqManager.c paramc);
  }
  
  public static class c
  {
    public ProtoReqManager.b a;
    ProtoReqManager.d b;
    public boolean cNd = true;
    public boolean cNe = true;
    public String clW;
    public int dPR = 3;
    public int dPS = 25;
    public int dPT = 450000;
    public int daB = 480000;
    public byte[] fW;
    public Object fi;
    public int tryCount = 9;
    
    public void dVU()
    {
      this.daB = 30000;
      this.tryCount = 1;
      this.dPR = 1;
    }
  }
  
  public static class d
  {
    public achq.a a = new achq.a();
    public ProtoReqManager.ProtoReqRunnable[] a;
    public ProtoReqManager.c b;
    boolean cNg = false;
    public int dPU;
    public FromServiceMsg g;
    public long startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */