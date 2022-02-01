package com.tencent.mobileqq.msgbackup.fragment;

import acfp;
import ajdt;
import ajee;
import ajek;
import ajer;
import ajev;
import ajfv;
import ajgp;
import ajgt;
import ajgv;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqiw;
import aqnm;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import lk;
import lo;
import mqq.os.MqqHandler;
import wja;

public class MsgBackupQRFragment
  extends MsgBackupBaseFragment
{
  private ajer c;
  private boolean coe;
  private boolean cof;
  private boolean cog;
  private boolean coh;
  private Bitmap fv;
  private Runnable hd;
  private Runnable he = new MsgBackupQRFragment.6(this);
  
  private void LW(boolean paramBoolean)
  {
    Message localMessage = this.mUIHandler.obtainMessage(10005);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mUIHandler.sendMessage(localMessage);
      return;
    }
  }
  
  private void Q(Bitmap paramBitmap)
  {
    Message localMessage = this.mUIHandler.obtainMessage(10006);
    localMessage.obj = paramBitmap;
    this.mUIHandler.sendMessage(localMessage);
  }
  
  private void R(Bitmap paramBitmap)
  {
    int i = 1;
    boolean bool;
    Message localMessage;
    if (aqiw.getSystemNetwork(getActivity()) == 1)
    {
      bool = true;
      LW(bool);
      localMessage = this.mUIHandler.obtainMessage(10004);
      if (!bool) {
        break label64;
      }
    }
    for (;;)
    {
      localMessage.arg1 = i;
      localMessage.obj = paramBitmap;
      this.mUIHandler.sendMessage(localMessage);
      return;
      bool = false;
      break;
      label64:
      i = 0;
    }
  }
  
  private void b(ajer paramajer)
  {
    if (paramajer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "refreshQRLayout QRCode fail, data is null!");
      }
      return;
    }
    String str1 = paramajer.getToken();
    String str2 = paramajer.xm();
    String str3 = paramajer.xl();
    int i = paramajer.Gi();
    ajee localajee = ajee.a();
    ajgp localajgp = localajee.a();
    localajgp.Mw(str3);
    localajee.b().setToken(str1);
    localajee.b().Mr(str2);
    localajee.b().QE(i);
    localajgp.QM(2);
    this.t.postDelayed(this.he, 800L);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.t.post(new MsgBackupQRFragment.5(this, paramajer));
      return;
    }
    R(a(paramajer));
  }
  
  private void ci(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      this.t.post(new MsgBackupQRFragment.4(this, paramBoolean2, paramBoolean1));
    }
    for (;;)
    {
      ajgt.cN("0X800A241", 1);
      return;
      Q(a(null));
      if (paramBoolean2) {
        dxf();
      } else {
        LW(paramBoolean1);
      }
    }
  }
  
  private void dxe()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.t.post(new MsgBackupQRFragment.3(this));
      return;
    }
    Q(a(null));
  }
  
  private void dxf()
  {
    Message localMessage = this.mUIHandler.obtainMessage(10015);
    this.mUIHandler.sendMessage(localMessage);
  }
  
  public Bitmap a(ajer paramajer)
  {
    Object localObject;
    if (paramajer == null)
    {
      paramajer = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=1";
      localObject = new Hashtable();
      ((Hashtable)localObject).put(EncodeHintType.MARGIN, Integer.valueOf(0));
      ((Hashtable)localObject).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    }
    for (;;)
    {
      int i;
      int m;
      int j;
      try
      {
        i = wja.dp2px(200.0F, getResources());
        paramajer = new lo().b(paramajer, i, i, (Map)localObject);
        k = paramajer.getWidth();
        m = paramajer.getHeight();
        localObject = new int[k * m];
        i = 0;
      }
      catch (Exception paramajer)
      {
        int k;
        boolean bool;
        QLog.e("MsgBackup.MsgBackupQRFragment", 1, "Create QRCode fail", paramajer);
        return null;
      }
      if (j < k)
      {
        if (paramajer.get(j, i)) {
          localObject[(i * k + j)] = -16777216;
        }
        j += 1;
        continue;
        paramajer = "https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate&qr_sig=" + paramajer.xm();
        break;
      }
      i += 1;
      break label256;
      if (this.fv == null) {
        this.fv = Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888);
      }
      if (this.fv != null)
      {
        bool = true;
        ajgv.c("MsgBackup.MsgBackupQRFragment", "create qr bitmap is called! bitmap is not null!   -----> %b", new Object[] { Boolean.valueOf(bool) });
        this.fv.setPixels((int[])localObject, 0, k, 0, 0, k, m);
        paramajer = this.fv;
        return paramajer;
      }
      bool = false;
      continue;
      label256:
      if (i < m) {
        j = 0;
      }
    }
  }
  
  protected void a(ajer paramajer)
  {
    super.a(paramajer);
    this.coh = false;
    b(paramajer);
    ajee.a().dwJ();
  }
  
  protected void a(ajev paramajev)
  {
    super.a(paramajev);
    if (paramajev != null)
    {
      if (paramajev.getState() != 2) {
        break label334;
      }
      if (this.hd != null) {
        this.t.removeCallbacks(this.hd);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: " + paramajev);
      }
      if (!ajee.cnJ) {
        break label83;
      }
      QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp: has been started link page!");
    }
    label83:
    while ((paramajev.getState() == 1) || (paramajev.getState() == 3) || (paramajev.getState() != 4))
    {
      do
      {
        return;
        this.t.removeCallbacks(this.he);
        String str1 = paramajev.xl();
        String str2 = paramajev.getToken();
        int i = paramajev.Gi();
        MsgBackupEndPoint localMsgBackupEndPoint1 = new MsgBackupEndPoint();
        MsgBackupEndPoint localMsgBackupEndPoint2 = new MsgBackupEndPoint();
        int j = ajgv.dB(paramajev.a().getIp());
        localMsgBackupEndPoint1.ipv4 = j;
        localMsgBackupEndPoint2.ipv4 = j;
        paramajev = paramajev.a().fE();
        if (paramajev.size() == 2)
        {
          localMsgBackupEndPoint2.port = ((Integer)paramajev.get(0)).intValue();
          localMsgBackupEndPoint1.port = ((Integer)paramajev.get(1)).intValue();
        }
        paramajev = ajee.a();
        ajgp localajgp = paramajev.a();
        localajgp.Mw(str1);
        localajgp.b(localMsgBackupEndPoint2);
        localajgp.a(localMsgBackupEndPoint1);
        paramajev.b().QE(i);
        paramajev.b().setToken(str2);
        localajgp.QM(2);
        localajgp.QL(2);
        ajee.cnJ = true;
      } while ((getActivity() == null) || (getActivity().isFinishing()));
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "processQueryStateRsp has deal, so app will start transport page!");
      }
      paramajev = new Intent();
      paramajev.putExtra("param_start", 4);
      PublicFragmentActivity.startForResult(getActivity(), paramajev, MsgBackupTransportFragment.class, 1000);
      return;
    }
    label334:
  }
  
  protected void aZv()
  {
    super.aZv();
    if (AppSetting.enableTalkBack) {
      this.Bc.setContentDescription(acfp.m(2131708496));
    }
    this.UI.setText(getResources().getString(2131690799));
    this.UI.setTextColor(getResources().getColor(2131167304));
    this.jk.setVisibility(0);
    this.aj.setVisibility(0);
    this.Bc.setOnClickListener(this);
    this.hd = new MsgBackupQRFragment.2(this);
  }
  
  protected void bindData()
  {
    super.bindData();
    ajgv.o("MsgBackup.MsgBackupQRFragment-bindData ..start MsgBackupQRFragment", new Object[0]);
    if (this.a != null) {
      getActivity().app.removeObserver(this.a);
    }
    Object localObject = new HashSet(ajee.a().bi.size());
    ((HashSet)localObject).addAll(ajee.a().bi);
    ajee.dio = ajee.a().bi.size();
    ajgt.dxs();
    ajgt.a.acq = ajee.dio;
    ajek localajek = new ajek();
    ajgv.o("MsgBackup.MsgBackupQRFragment-loadData ..start toPage TO_QRCODE dataSize = %d", new Object[] { Integer.valueOf(((HashSet)localObject).size()) });
    localajek.bj = ((HashSet)localObject);
    localajek.dir = 0;
    long l3 = 0L;
    long l4 = 0L;
    int j = 1;
    int i = j;
    long l2 = l4;
    long l1 = l3;
    if (getActivity() != null)
    {
      localObject = getActivity().getIntent();
      i = j;
      l2 = l4;
      l1 = l3;
      if (localObject != null)
      {
        l1 = ((Intent)localObject).getLongExtra("session_start_time", 0L);
        l2 = ((Intent)localObject).getLongExtra("session_end_time", 0L);
        i = ((Intent)localObject).getIntExtra("session_content_type", 1);
        this.cof = ((Intent)localObject).getBooleanExtra("session_net_status", true);
      }
    }
    ajgv.c("MsgBackup.MsgBackupQRFragment", "select params startTime = %d ,endTime = %d,contentType = %d isNetStatusForSelectPage = %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Boolean.valueOf(this.cof) });
    if ((l1 != 0L) && (l2 != 0L) && (l1 < l2))
    {
      localajek.startTime = l1;
      localajek.endTime = l2;
      if (i == 2)
      {
        bool = true;
        localajek.cnN = bool;
        getActivity().app.addObserver(this.a);
        ajee.a().removeObserver();
        ajee.a().d(localajek);
        if (aqiw.getSystemNetwork(getActivity()) != 1) {
          break label541;
        }
      }
    }
    label541:
    for (boolean bool = true;; bool = false)
    {
      if ((!this.cof) && (bool))
      {
        ajee.a().LV(false);
        this.cog = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupQRFragment", 2, "bindData startServerProxy is called!");
        }
      }
      this.coe = bool;
      ajgv.c("MsgBackup.MsgBackupQRFragment", "bindData net state = %b", new Object[] { Boolean.valueOf(this.coe) });
      if (!bool) {
        ci(bool, false);
      }
      this.c = ajee.a().a();
      if ((this.c != null) && (bool))
      {
        ajgv.c("MsgBackup.MsgBackupQRFragment", "manager msgBackupGetQrRsp is existed!", new Object[0]);
        this.coh = false;
        b(this.c);
      }
      this.t.post(this.hd);
      return;
      bool = false;
      break;
      localajek.startTime = 0L;
      localajek.endTime = 9223372036854775807L;
      if (i == 2) {}
      for (bool = true;; bool = false)
      {
        localajek.cnN = bool;
        break;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupQRFragment", 2, "TO_QRCODE page click KEYCODE_BACK");
      }
      ajee.a().onDestroy();
      onBackEvent();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.handleMessage(paramMessage);
      if (paramMessage.arg1 == 1) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label136;
        }
        if (this.Bc == null) {
          break;
        }
        localObject = (Bitmap)paramMessage.obj;
        this.Bc.setImageBitmap((Bitmap)localObject);
        if (this.aj != null) {
          this.aj.setVisibility(8);
        }
        ajee.a().dwF();
        ajgt.cN("0X800A239", 1);
        break;
      }
      label136:
      dxe();
      ajgv.c("MsgBackup.MsgBackupQRFragment", "handleMessage MSG_WHAT_QR_SOURCE net state is XG!!!", new Object[0]);
      continue;
      if (paramMessage.arg1 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label196;
        }
        aqnm.setViewVisibility(this.jn, 0);
        aqnm.setViewVisibility(this.UI, 8);
        break;
      }
      label196:
      aqnm.setViewVisibility(this.jn, 8);
      this.UI.setText(getResources().getString(2131690799));
      this.UI.setTextColor(getResources().getColor(2131167304));
      aqnm.setViewVisibility(this.UI, 0);
      continue;
      aqnm.setViewVisibility(this.jn, 8);
      this.UI.setText(getResources().getString(2131690800));
      this.UI.setTextColor(getResources().getColor(2131166105));
      aqnm.setViewVisibility(this.UI, 0);
      continue;
      Object localObject = new BitmapDrawable((Bitmap)paramMessage.obj);
      ((BitmapDrawable)localObject).setColorFilter(872415231, PorterDuff.Mode.MULTIPLY);
      if (this.Bc != null)
      {
        this.Bc.setImageDrawable((Drawable)localObject);
        if ((this.aj != null) && (!this.coh)) {
          this.aj.setVisibility(8);
        }
        ajee.a().dwF();
      }
      ajgt.cN("0X800A239", 2);
      continue;
      aqnm.setVisible(this.aj, 0);
    }
  }
  
  protected void initTitle()
  {
    super.initTitle();
    setTitle(getActivity().getString(2131690732));
  }
  
  protected void kJ()
  {
    super.kJ();
    this.vg.setOnItemSelectListener(new ajfv(this));
  }
  
  protected void m(Integer paramInteger)
  {
    super.m(paramInteger);
    this.coh = false;
    ci(false, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.coh = true;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupQRFragment", 2, "qr_code_src request qr onclick, isWaitingQrRsp = " + this.coh);
      }
      Message localMessage = this.mUIHandler.obtainMessage(10013);
      this.mUIHandler.sendMessage(localMessage);
      this.t.post(new MsgBackupQRFragment.7(this));
      ajgt.report("0X800A23C");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.cog = false;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.a != null) {
      getActivity().app.removeObserver(this.a);
    }
    this.t.removeCallbacks(this.he);
    this.t.removeCallbacks(this.hd);
    ajee.a().dwG();
  }
  
  public void onPause()
  {
    super.onPause();
    ajee.a().bZ(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    ajee.a().bY(getActivity());
    ajee.cnL = false;
  }
  
  public void onStop()
  {
    asB();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupQRFragment
 * JD-Core Version:    0.7.0.1
 */