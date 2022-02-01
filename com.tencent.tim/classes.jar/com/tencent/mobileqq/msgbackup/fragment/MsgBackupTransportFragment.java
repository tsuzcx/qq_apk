package com.tencent.mobileqq.msgbackup.fragment;

import acfp;
import ajdt;
import ajee;
import ajeo;
import ajfz;
import ajga;
import ajgb;
import ajgc;
import ajgp;
import ajgt;
import ajgv;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqha;
import aqiw;
import aqju;
import aqnm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupTransportFragment
  extends MsgBackupBaseFragment
{
  private boolean col;
  private boolean com = true;
  private int diS;
  
  private void b(ajeo paramajeo)
  {
    if (paramajeo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp confim qr, data is null!");
      }
    }
    String str1;
    String str2;
    int i;
    MsgBackupEndPoint localMsgBackupEndPoint1;
    MsgBackupEndPoint localMsgBackupEndPoint2;
    Object localObject;
    do
    {
      return;
      str1 = paramajeo.xl();
      str2 = paramajeo.xl();
      i = paramajeo.Gi();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = ajgv.dB(paramajeo.a().getIp());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localObject = paramajeo.a().fE();
    } while (((List)localObject).size() != 2);
    localMsgBackupEndPoint1.port = ((Integer)((List)localObject).get(0)).intValue();
    localMsgBackupEndPoint2.port = ((Integer)((List)localObject).get(1)).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "processConfirmRsp: server ip = " + paramajeo.a().getIp() + ", udpport = " + ((List)localObject).get(1) + ", tcpport = " + ((List)localObject).get(0));
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "扫码成功了，可以发起直连了！");
    }
    paramajeo = ajee.a();
    if (paramajeo != null)
    {
      localObject = paramajeo.a();
      ((ajgp)localObject).Mw(str1);
      paramajeo.b().QE(i);
      paramajeo.b().setToken(str2);
      ((ajgp)localObject).d(localMsgBackupEndPoint1);
      ((ajgp)localObject).c(localMsgBackupEndPoint2);
      ((ajgp)localObject).QM(1);
      ((ajgp)localObject).QL(1);
      ((ajgp)localObject).QO(1);
      return;
    }
    QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager为空了", new Throwable());
  }
  
  private void dxa()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    if (this.UK != null)
    {
      this.UK.setVisibility(0);
      this.UK.setTextColor(getResources().getColor(2131166105));
      this.UK.setText(2131690734);
    }
    if (this.diS == 2)
    {
      ajgt.cN("0X800A241", 1);
      return;
    }
    ajgt.cN("0X800A250", 1);
  }
  
  private void dxb()
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.UK == null) {
      return;
    }
    this.UK.setVisibility(0);
    this.UK.setTextColor(getResources().getColor(2131166106));
    this.UK.setText(2131690737);
  }
  
  private void dxj()
  {
    int i = 1;
    if (this.diS == 1)
    {
      if (this.com) {
        break label27;
      }
      i = 6;
    }
    for (;;)
    {
      ajgt.cN("0X800A252", i);
      return;
      label27:
      if (this.isStart) {
        i = 3;
      }
    }
  }
  
  public void LT(boolean paramBoolean)
  {
    super.LT(paramBoolean);
    if ((!paramBoolean) && (this.hc != null)) {
      this.t.post(this.hc);
    }
    Message localMessage = this.mUIHandler.obtainMessage(10007);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localMessage.arg1 = i;
      this.mUIHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void LU(boolean paramBoolean)
  {
    super.LU(paramBoolean);
    this.isStart = paramBoolean;
    if (this.diS == 2)
    {
      ajgt.report("0X800A23D");
      return;
    }
    ajgt.report("0X800A248");
  }
  
  protected void aZv()
  {
    super.aZv();
    this.jm.setVisibility(0);
    if (this.dix == 4)
    {
      if (this.Bd != null)
      {
        if (this.diS != 1) {
          break label315;
        }
        this.Bd.setImageResource(2130842116);
      }
      if (this.UJ != null)
      {
        this.UJ.setText(getActivity().getResources().getString(2131690751));
        this.mUIHandler.removeMessages(10014);
        this.mUIHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      if (this.UK != null) {
        this.UK.setVisibility(8);
      }
      if (this.diS == 1) {
        ajgt.report("0X800A246");
      }
    }
    int i;
    String str2;
    if (this.dix == 5)
    {
      if (this.Bd != null) {
        this.Bd.setImageResource(2130842116);
      }
      ajee.cnG = false;
      int j = ajee.a().Gj();
      this.diq = j;
      i = j;
      if (j != ajee.dio) {
        i = j + 1;
      }
      if (ajgp.b().getRole() != 1) {
        break label328;
      }
      str2 = getActivity().getResources().getString(2131690761);
    }
    for (String str1 = i + "/" + ajee.dio;; str1 = i + "/" + ajee.dio)
    {
      if (this.UJ != null)
      {
        String str3 = ajgv.bw(this.ach);
        this.UJ.setText(String.format(str2, new Object[] { str1, str3 + "/S" }));
      }
      if (this.UK != null) {
        this.UK.setText(2131690737);
      }
      ajgt.report("0X800A24A");
      return;
      label315:
      this.Bd.setImageResource(2130842117);
      break;
      label328:
      str2 = getActivity().getResources().getString(2131690764);
    }
  }
  
  protected void bC(boolean paramBoolean, Object paramObject)
  {
    int i = 6;
    super.bC(paramBoolean, paramObject);
    this.com = true;
    this.diS = ajgp.b().getRole();
    if (paramBoolean)
    {
      paramObject = (ajeo)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onConfirmQrResponse: " + paramObject + ", isSuccess: " + paramBoolean);
      }
      b(paramObject);
    }
    while (!(paramObject instanceof Integer)) {
      return;
    }
    int j = ((Integer)paramObject).intValue();
    ajgv.c("MsgBackup.MsgBackupTransportFragment", "processConfirmQRRsp  result = %d", new Object[] { Integer.valueOf(j) });
    if (j == 1006)
    {
      setViewText(this.UJ, getString(2131690741));
      aqnm.setVisible(this.ak, 8);
      this.com = false;
      i = 3;
    }
    for (;;)
    {
      if (this.Bd != null) {
        this.Bd.setImageResource(2130842121);
      }
      this.mUIHandler.removeMessages(10014);
      if (this.diS != 1) {
        break;
      }
      ajgt.cN("0X800A245", i);
      return;
      if (j == 1021)
      {
        setViewText(this.UJ, getString(2131690742));
        aqnm.setVisible(this.ak, 8);
      }
      else if (j == 1022)
      {
        setViewText(this.UJ, getString(2131690744));
        aqnm.setVisible(this.ak, 8);
        i = 1;
      }
    }
  }
  
  protected void bindData()
  {
    super.bindData();
    this.mTotalCount = ajee.dio;
    ajgv.aqD();
    if (ajgp.b().getRole() == 1) {
      this.t.postDelayed(this.hb, 15000L);
    }
    ajgv.o("MsgBackup.MsgBackupTransportFragment-loadData ..start toPage = %d", new Object[] { Integer.valueOf(this.dix) });
    if (this.dix == 4)
    {
      if (this.a != null) {
        getActivity().app.removeObserver(this.a);
      }
      localajee = ajee.a();
      localajee.a().b(this);
      getActivity().app.addObserver(this.a);
      localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("qr_sig=");
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "scan QRCode sig = " + localObject[1]);
        }
        localajee.b().Mr(localObject[1]);
        localajee.b().QE(3);
        localajee.dwE();
        ajee.cnH = true;
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "MsgBackupManager.sIsTranferingStatus = " + ajee.cnH);
        }
        this.col = false;
        if (aqiw.getSystemNetwork(getActivity()) != 1) {
          ajgt.cN("0X800A245", 2);
        }
      }
    }
    while (this.dix != 5)
    {
      ajee localajee;
      Object localObject;
      return;
      if (QLog.isColorLevel()) {
        QLog.e("MsgBackup.MsgBackupTransportFragment", 2, "server recv  qrCode callback page status....!");
      }
      if (this.UJ != null)
      {
        this.UJ.setText(getActivity().getString(2131690751));
        this.mUIHandler.removeMessages(10014);
        this.mUIHandler.sendEmptyMessageDelayed(10014, 800L);
      }
      this.col = true;
      return;
    }
    this.isStart = true;
    this.ach = ajee.a().gn();
    iH(this.diq, this.mTotalCount);
    if (this.a != null) {
      getActivity().app.removeObserver(this.a);
    }
    if (ajgp.b().aqA()) {
      dxb();
    }
    for (;;)
    {
      ajee.a().a().b(this);
      getActivity().app.addObserver(this.a);
      return;
      dxa();
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "doOnKeyDown! ------>KEYCODE_BACK");
      }
      if (this.isStart)
      {
        dwZ();
        return true;
      }
      if (this.diS == 1)
      {
        onBackEvent();
        return true;
      }
      ca(getActivity());
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void dwL()
  {
    super.dwL();
    if (this.diS == 1) {
      ajgt.cN("0X800A250", 6);
    }
  }
  
  protected void dwO()
  {
    super.dwO();
    if (getActivity() != null)
    {
      if (this.Bd != null) {
        this.Bd.setImageResource(2130842114);
      }
      if (this.UJ != null) {
        this.UJ.setText(getString(2131690763));
      }
      if (this.UK != null)
      {
        this.UK.setTextColor(getResources().getColor(2131166106));
        this.UK.setText(getString(2131690762));
      }
      aqnm.setVisible(this.mProgressBar, 8);
      aqnm.setVisible(this.ak, 8);
      this.vg.hideLeftText();
      if ((this.diS == 1) && (!this.isStart)) {
        ajgt.cN("0X800A241", 2);
      }
    }
  }
  
  public void dwZ()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    aqha.b(localFragmentActivity, 0, localFragmentActivity.getString(2131690756), localFragmentActivity.getString(2131690752), localFragmentActivity.getString(2131690754), localFragmentActivity.getString(2131690755), new ajga(this), new ajgb(this)).show();
  }
  
  public void dxc()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
      return;
    }
    String str = acfp.m(2131708488);
    aqha.b(localFragmentActivity, 0, null, acfp.m(2131708479), null, str, new ajgc(this), null).show();
  }
  
  public void dxk()
  {
    ajee.a().a().exit();
    ajee.a().a().b(null);
    dwN();
  }
  
  public void exit(boolean paramBoolean)
  {
    super.exit(paramBoolean);
    Message localMessage = this.mUIHandler.obtainMessage(10008);
    this.mUIHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    label142:
    String str3;
    int j;
    String str2;
    String str1;
    label326:
    label459:
    int k;
    switch (paramMessage.what)
    {
    default: 
    case 10002: 
    case 10003: 
      do
      {
        do
        {
          return super.handleMessage(paramMessage);
          if ((this.isStart) && (ajee.a().a().getRole() != 2)) {
            this.vg.setLeftButton(2131690740);
          }
        } while ((!this.isStart) && (!ajee.cnK));
        if (this.cnU)
        {
          this.cnU = false;
          if (this.Bd != null)
          {
            if (this.diS != 1) {
              break label326;
            }
            this.Bd.setImageResource(2130842116);
          }
        }
        str3 = ajgv.bw(this.ach);
        ajgv.c("MsgBackup.MsgBackupTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.ach), str3 });
        j = this.diq;
        i = j;
        if (j != ajee.dio) {
          i = j + 1;
        }
        if (ajgp.b().getRole() == 1) {
          str2 = getString(2131690761);
        }
        for (str1 = i + "/" + ajee.dio;; str1 = i + "/" + ajee.dio)
        {
          str1 = String.format(str2, new Object[] { str1, str3 + "B/s" });
          if (this.UJ != null) {
            this.UJ.setText(str1);
          }
          if (this.UK == null) {
            break;
          }
          this.UK.setVisibility(0);
          this.UK.setText(2131690737);
          break;
          this.Bd.setImageResource(2130842117);
          break label142;
          str2 = getString(2131690764);
        }
        if ((this.isStart) && (ajee.a().a().getRole() != 2)) {
          this.vg.setLeftButton(2131690740);
        }
      } while ((!this.isStart) && (!ajee.cnK));
      if (this.cnU)
      {
        this.cnU = false;
        if (this.Bd != null)
        {
          if (this.diS != 1) {
            break;
          }
          this.Bd.setImageResource(2130842116);
        }
      }
      str3 = ajgv.bw(this.ach);
      j = paramMessage.arg1;
      k = paramMessage.arg2;
      iH(j, k);
      if (j == k) {}
      break;
    }
    for (int i = j + 1;; i = j)
    {
      if (ajgp.b().getRole() == 1) {
        str2 = getString(2131690761);
      }
      for (str1 = i + "/" + ajee.dio;; str1 = i + "/" + ajee.dio)
      {
        if (this.UJ != null) {
          this.UJ.setText(String.format(str2, new Object[] { str1, str3 + "B/s" }));
        }
        if (this.UK != null)
        {
          this.UK.setVisibility(0);
          this.UK.setText(2131690737);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionCompleted!!!>>>>>>>>>>>");
        }
        if (ajgp.b().getRole() != 2) {
          break label721;
        }
        MsgBackupCompleteFragment.m(getActivity(), this.mTotalCount, this.diq);
        break;
        this.Bd.setImageResource(2130842117);
        break label459;
        str2 = getString(2131690764);
      }
      label721:
      MsgBackupCompleteFragment.p(getActivity(), this.mTotalCount, this.diq);
      break;
      dxc();
      break;
      if (paramMessage.arg1 == 1)
      {
        dxb();
        break;
      }
      dxa();
      break;
      if ((this.UJ == null) || (this.UJ.getVisibility() != 0) || (this.isStart)) {
        break;
      }
      str1 = getActivity().getString(2131690751);
      i = this.diz + 1;
      this.diz = i;
      str1 = str1.substring(0, str1.length() - (2 - i % 3));
      ajgv.c("MsgBackup.MsgBackupTransportFragment", "refreshThreeDot text = %s,threeIdottime = %d", new Object[] { str1, Integer.valueOf(this.diz) });
      this.UJ.setText(str1);
      this.mUIHandler.removeMessages(10014);
      this.mUIHandler.sendEmptyMessageDelayed(10014, 800L);
      break;
    }
  }
  
  public void iC(int paramInt1, int paramInt2)
  {
    super.iC(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "sessionProgress!!! finishedSessions = " + paramInt1 + ", totalSession" + paramInt2 + ", start = " + this.isStart);
    }
    if ((!this.isStart) || (this.isCompleted)) {
      return;
    }
    if (paramInt1 == paramInt2) {
      this.isCompleted = true;
    }
    this.mTotalCount = paramInt2;
    this.diq = paramInt1;
    Message localMessage = this.mUIHandler.obtainMessage(10003);
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    this.mUIHandler.sendMessage(localMessage);
  }
  
  protected void iH(int paramInt1, int paramInt2)
  {
    ajgv.c("MsgBackup.MsgBackupTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == 0) {}
    do
    {
      return;
      paramInt1 = paramInt1 * 100 / paramInt2;
    } while (this.mProgressBar == null);
    if (this.mProgressBar.getVisibility() != 0) {
      this.mProgressBar.setVisibility(0);
    }
    this.mProgressBar.setProgress(paramInt1);
  }
  
  protected void initTitle()
  {
    super.initTitle();
    Object localObject = getActivity().getIntent().getStringExtra("msgbackup_qr_sig");
    this.diS = ajgp.b().getRole();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.diS = 1;
    }
    localObject = getActivity().getIntent();
    if (localObject != null)
    {
      this.dix = ((Intent)localObject).getIntExtra("param_start", -1);
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "toPage = " + this.dix + "; mBizType = " + this.diy);
      }
    }
    if ((this.dix == 4) || (this.dix == 5))
    {
      setTitle(getActivity().getString(2131690732));
      this.vg.setLeftBackVisible(8);
      this.vg.setRightButton(2131690716);
      this.vg.setLeftButton(2131690740);
      if ((this.dix == 4) || (ajee.a().a().getRole() == 2)) {
        this.vg.hideLeft();
      }
      this.vg.setOnItemSelectListener(new ajfz(this));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null) {
      paramActivity.overridePendingTransition(2130772156, 2130772155);
    }
  }
  
  public void kg(long paramLong)
  {
    super.kg(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.isStart + ", MsgBackupManager.isTransportStart = " + ajee.cnK);
    }
    if ((this.isStart) || (ajee.cnK))
    {
      this.ach = paramLong;
      Message localMessage = this.mUIHandler.obtainMessage(10002);
      this.mUIHandler.sendMessage(localMessage);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.a != null)) {
      getActivity().app.removeObserver(this.a);
    }
    ajee localajee = ajee.a();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup.MsgBackupTransportFragment", 2, "onDestroy called! MsgBackupManager.sIsShouQiBtnClick = " + ajee.cnG + ", topage = " + this.dix);
    }
    if (!ajee.cnG)
    {
      localajee.onDestroy();
      ajee.cnJ = false;
      if (ajgp.b().getRole() == 2) {
        localajee.dwG();
      }
      localajee.a().b(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ajee.a().bZ(getActivity());
  }
  
  public void onResume()
  {
    super.onResume();
    ajgv.c("MsgBackup.MsgBackupTransportFragment", "onResume is called!", new Object[0]);
    ajee.a().bY(getActivity());
    ajee.cnL = true;
  }
  
  public void onStop()
  {
    asB();
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment
 * JD-Core Version:    0.7.0.1
 */