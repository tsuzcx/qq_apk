package com.tencent.av.service;

import android.app.Notification;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.widget.Toast;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.BeautyToolbar.a;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import igd;
import igv;
import iiv;
import iiv.b;
import iju.a;
import ikl.a;
import ilg.a;
import itx;
import ity.a;
import java.util.ArrayList;
import java.util.Iterator;
import jfq;
import mqq.app.AppService;

public class AVServiceForQQ
  extends AppService
{
  String TAG = "AVServiceForQQ";
  private boolean Ve;
  Notification jdField_a_of_type_AndroidAppNotification = null;
  private a jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a;
  private TraeHelper jdField_a_of_type_ComTencentAvUtilsTraeHelper;
  private int aqx = 10;
  private int asi = 13;
  VideoAppInterface c = null;
  public String mSessionId;
  
  public IBinder onBind(Intent paramIntent)
  {
    boolean bool2 = false;
    if ((this.app instanceof VideoAppInterface)) {
      this.c = ((VideoAppInterface)this.app);
    }
    paramIntent = this.TAG;
    if (this.c != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a != null) {
        bool2 = true;
      }
      igd.aK(paramIntent, String.format("onBind, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a;
    }
  }
  
  public void onCreate()
  {
    boolean bool2 = false;
    try
    {
      super.onCreate();
      if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a == null) {
        this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a = new a(null);
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 18) {
          startForeground(3886, new Notification());
        }
        label48:
        String str1 = this.TAG;
        if (this.c != null) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a != null) {
              bool2 = true;
            }
            igd.aK(str1, String.format("onCreate, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
            return;
            localException1 = localException1;
            QLog.d(this.TAG, 1, "AVServiceForQQ onCreate, Fail", localException1);
            String str2 = super.getString(2131721703) + " 0x0a";
            try
            {
              Toast.makeText(super.getBaseContext(), str2, 0).show();
            }
            catch (Exception localException2) {}
          }
          break;
        }
      }
      catch (Exception localException3)
      {
        break label48;
      }
    }
  }
  
  public void onDestroy()
  {
    boolean bool2 = false;
    try
    {
      if ((Build.VERSION.SDK_INT < 18) || (this.jdField_a_of_type_AndroidAppNotification != null))
      {
        stopForeground(true);
        this.jdField_a_of_type_AndroidAppNotification = null;
      }
    }
    catch (Exception localException)
    {
      label27:
      String str;
      boolean bool1;
      break label27;
    }
    super.onDestroy();
    str = this.TAG;
    if (this.c != null) {}
    for (bool1 = true;; bool1 = false)
    {
      if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a != null) {
        bool2 = true;
      }
      igd.aK(str, String.format("onDestroy, appInterface[%b], AVServiceForQQ[%b]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((this.app instanceof VideoAppInterface)) {
      this.c = ((VideoAppInterface)this.app);
    }
    String str;
    boolean bool1;
    if (QLog.isDevelopLevel())
    {
      str = this.TAG;
      if (this.c == null) {
        break label143;
      }
      bool1 = true;
      if (this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a == null) {
        break label149;
      }
    }
    label143:
    label149:
    for (boolean bool2 = true;; bool2 = false)
    {
      QLog.d(str, 4, String.format("onCreate, appInterface[%b], AVServiceForQQ[%b], flags[%d], startId[%d]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      if ((paramIntent != null) && (paramIntent.getBooleanExtra("setForeground", false)))
      {
        bool1 = paramIntent.getBooleanExtra("foreground", false);
        paramIntent = (Notification)paramIntent.getParcelableExtra("notification");
      }
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceAVServiceForQQ$a.b(bool1, paramIntent);
        return 2;
      }
      catch (Throwable paramIntent)
      {
        QLog.e(this.TAG, 1, "", paramIntent);
      }
      bool1 = false;
      break;
    }
    return 2;
  }
  
  class a
    extends ity.a
  {
    private a() {}
    
    public void D(byte[] paramArrayOfByte)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        if (localVideoController != null) {
          localVideoController.w(paramArrayOfByte);
        }
        return;
      }
    }
    
    public void F(byte[] paramArrayOfByte)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        if (localVideoController != null) {
          localVideoController.x(paramArrayOfByte);
        }
        return;
      }
    }
    
    public void G(byte[] paramArrayOfByte)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        if (localVideoController != null) {
          localVideoController.z(paramArrayOfByte);
        }
        return;
      }
    }
    
    public AVPbInfo a(byte[] paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d(AVServiceForQQ.this.TAG, 2, "processQCallPush in AVServiceForQQ");
      }
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b(); localVideoController != null; localVideoController = VideoController.a()) {
        return localVideoController.a(paramArrayOfByte);
      }
      return null;
    }
    
    public void a(itx paramitx)
      throws RemoteException
    {}
    
    public void aqG()
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        int i = localVideoController.kB();
        localVideoController.a("startSpeak", localVideoController.kJ, true, true, -1);
        localVideoController.f(-1L, i, localVideoController.kB());
        return;
      }
    }
    
    public void aqH()
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        int i = localVideoController.kB();
        localVideoController.a("stopSpeak", localVideoController.kJ, false, true, -1);
        localVideoController.f(-1L, i, localVideoController.kB());
        return;
      }
    }
    
    public void aqI()
      throws RemoteException
    {
      long l = AudioHelper.hG();
      QLog.w(AVServiceForQQ.this.TAG, 1, "exitQQCall, seq[" + l + "]");
      VideoController localVideoController;
      if (AVServiceForQQ.this.c != null)
      {
        localVideoController = AVServiceForQQ.this.c.b();
        TraeHelper.a().dN(l);
        localVideoController.b().PU = false;
        localVideoController.O(localVideoController.b().peerUin, 224);
        localVideoController.ko(224);
        if (localVideoController.b().ana == -1) {
          break label230;
        }
      }
      for (;;)
      {
        localVideoController.b().Qh = true;
        igd.aJ(AVServiceForQQ.this.TAG, "DataReport onClose: ");
        iju.a.c(AVServiceForQQ.this.c);
        ilg.a.h(AVServiceForQQ.this.c);
        ikl.a.a(AVServiceForQQ.this.TAG, AVServiceForQQ.this.c);
        BeautyToolbar.a.jS(AVServiceForQQ.this.c.getCurrentAccountUin());
        jfq.f(localVideoController.b());
        localVideoController.P(localVideoController.b().peerUin, localVideoController.b().ana);
        localVideoController.b().O("exitQQCall", false);
        localVideoController.b().Z("exitQQCall", 0);
        return;
        localVideoController = VideoController.a();
        break;
        label230:
        localVideoController.b().ana = 0;
      }
    }
    
    public void b(boolean paramBoolean, Notification paramNotification)
      throws RemoteException
    {
      if (Build.VERSION.SDK_INT < 18) {}
      for (;;)
      {
        return;
        if (!paramBoolean) {
          break;
        }
        if (paramNotification != null) {}
        for (AVServiceForQQ.this.a = paramNotification; AVServiceForQQ.this.c != null; AVServiceForQQ.this.a = new Notification())
        {
          AVServiceForQQ.this.c.getHandler().post(new AVServiceForQQ.AVServiceForQQStub.1(this));
          return;
        }
      }
      try
      {
        AVServiceForQQ.this.stopForeground(true);
        QLog.d(AVServiceForQQ.this.TAG, 1, "setAvServiceForegroud stop foreground.");
        AVServiceForQQ.this.a = null;
        return;
      }
      catch (Throwable paramNotification)
      {
        for (;;)
        {
          QLog.d(AVServiceForQQ.this.TAG, 1, "setAvServiceForegroud stop foreground fail", paramNotification);
        }
      }
    }
    
    public void cB(long paramLong)
      throws RemoteException
    {
      aqH();
      VideoController localVideoController;
      if (AVServiceForQQ.this.c != null)
      {
        localVideoController = AVServiceForQQ.this.c.b();
        if (!localVideoController.OB) {
          break label90;
        }
        if (paramLong == 0L) {
          paramLong = localVideoController.kJ;
        }
        localVideoController.b(localVideoController.alr, localVideoController.kJ, 95);
      }
      for (;;)
      {
        localVideoController.e(0, 0, null);
        igv.a().a().amG();
        igv.a().a().amH();
        return;
        localVideoController = VideoController.a();
        break;
        label90:
        localVideoController.b(AVServiceForQQ.a(AVServiceForQQ.this), paramLong, 96);
      }
    }
    
    public int d(long paramLong, int paramInt)
    {
      Object localObject;
      label72:
      int i;
      if (AVServiceForQQ.this.c != null)
      {
        localObject = AVServiceForQQ.this.c.b();
        if ((localObject == null) || (!((VideoController)localObject).OB) || (((VideoController)localObject).b().relationType != paramInt) || (((VideoController)localObject).b().ll != paramLong)) {
          break label117;
        }
        localObject = ((VideoController)localObject).aN().iterator();
        paramInt = 0;
        i = paramInt;
        if (!((Iterator)localObject).hasNext()) {
          break label120;
        }
        if (((VideoController.b)((Iterator)localObject).next()).accountType != 1) {
          break label123;
        }
        paramInt += 1;
      }
      label117:
      label120:
      label123:
      for (;;)
      {
        break label72;
        localObject = VideoController.a();
        break;
        i = 0;
        return i;
      }
    }
    
    public void g(String paramString, Bitmap paramBitmap)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        if (localVideoController != null) {
          localVideoController.d(paramString, paramBitmap);
        }
        return;
      }
    }
    
    public void jB(String paramString)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        if (localVideoController != null) {
          localVideoController.in(paramString);
        }
        return;
      }
    }
    
    public void r(long paramLong, String paramString)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b(); (localVideoController.OB) && (localVideoController.b().isGameRoom); localVideoController = VideoController.a()) {
        return;
      }
      long l = AudioHelper.hG();
      QLog.w(AVServiceForQQ.this.TAG, 1, "enterRoom, groupId[" + paramLong + "], nickname[" + paramString + "], seq[" + l + "]");
      localVideoController.b().P("enterRoom", true);
      AVServiceForQQ.a(AVServiceForQQ.this, TraeHelper.a());
      AVServiceForQQ.a(AVServiceForQQ.this).d(null);
      AVServiceForQQ.a(AVServiceForQQ.this).axJ();
      AVServiceForQQ.a(AVServiceForQQ.this).axK();
      if ((igv.a().a().jdField_a_of_type_Iiv$b.chatType == 3) && ((paramLong == -1L) || (paramLong == igv.a().a().jdField_a_of_type_Iiv$b.groupId)))
      {
        AVServiceForQQ.a(AVServiceForQQ.this, true);
        AVServiceForQQ.this.mSessionId = igv.a().a().sessionId;
        if ((!AVServiceForQQ.a(AVServiceForQQ.this)) && (localVideoController.OB))
        {
          localVideoController.b(localVideoController.alr, localVideoController.kJ, 94);
          igv.a().a().amH();
          igv.a().a().amG();
        }
        igv.a().cj(AVServiceForQQ.this.mSessionId);
        if (AVServiceForQQ.a(AVServiceForQQ.this)) {
          break label464;
        }
        AVServiceForQQ.a(AVServiceForQQ.this).axI();
        AVServiceForQQ.a(AVServiceForQQ.this).startService("DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;");
        AVServiceForQQ.a(AVServiceForQQ.this).axH();
        localVideoController.setAudioOpt(false);
        label349:
        if (!localVideoController.OB) {
          break label623;
        }
        if (QLog.isColorLevel()) {
          QLog.d(AVServiceForQQ.this.TAG, 2, "StartOrEnterGAudio already in room");
        }
      }
      for (;;)
      {
        localVideoController.b().e(l, "enterRoom", 3);
        localVideoController.b().jdField_a_of_type_Iiv$a.nickName = paramString;
        localVideoController.b().isGameRoom = true;
        return;
        AVServiceForQQ.this.mSessionId = igv.a(AVServiceForQQ.a(AVServiceForQQ.this), String.valueOf(paramLong), new int[0]);
        igv.a().a(AVServiceForQQ.this.mSessionId, false);
        AVServiceForQQ.a(AVServiceForQQ.this, false);
        break;
        label464:
        if (QLog.isColorLevel()) {
          QLog.d(AVServiceForQQ.this.TAG, 2, "IsAccompanyReturn");
        }
        AVServiceForQQ.a(AVServiceForQQ.this).axH();
        if (igv.a().c(AVServiceForQQ.this.mSessionId).PV)
        {
          i = localVideoController.kB();
          localVideoController.a("enterRoom", igv.a().c(AVServiceForQQ.this.mSessionId).jdField_a_of_type_Iiv$b.groupId, false, false, -1);
          localVideoController.f(-1L, i, localVideoController.kB());
          break label349;
        }
        int i = localVideoController.kB();
        localVideoController.a("enterRoom", igv.a().c(AVServiceForQQ.this.mSessionId).jdField_a_of_type_Iiv$b.groupId, true, false, -1);
        localVideoController.f(-1L, i, localVideoController.kB());
        break label349;
        label623:
        i = localVideoController.a(AVServiceForQQ.a(AVServiceForQQ.this), paramLong, AVServiceForQQ.b(AVServiceForQQ.this), new long[] { AVServiceForQQ.this.c.getLongAccountUin() }, false);
        if (QLog.isColorLevel()) {
          QLog.d(AVServiceForQQ.this.TAG, 2, "enterRoom result = " + i);
        }
        new Handler(Looper.getMainLooper()).post(new AVServiceForQQ.AVServiceForQQStub.2(this, i));
      }
    }
    
    public void setSoundEnable(boolean paramBoolean)
      throws RemoteException
    {
      if (AVServiceForQQ.this.c != null) {}
      for (VideoController localVideoController = AVServiceForQQ.this.c.b();; localVideoController = VideoController.a())
      {
        localVideoController.setSoundEnable(paramBoolean);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ
 * JD-Core Version:    0.7.0.1
 */