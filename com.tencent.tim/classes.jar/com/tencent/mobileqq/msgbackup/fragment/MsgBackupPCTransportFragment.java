package com.tencent.mobileqq.msgbackup.fragment;

import ajdt;
import ajee;
import ajek;
import ajeo;
import ajfr;
import ajgp;
import ajgt;
import ajgv;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqnm;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import mqq.os.MqqHandler;

public class MsgBackupPCTransportFragment
  extends MsgBackupPcBaseFragment
{
  private void dwY()
  {
    this.vg.setLeftBackVisible(8);
    this.vg.setLeftButton(2131690740);
    this.vg.setRightButton(2131690716);
    this.vg.setOnItemSelectListener(new ajfr(this));
    switch (this.dix)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return;
    }
    this.vg.hideLeft();
  }
  
  private void dxa()
  {
    this.cod = true;
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    if (this.UK != null)
    {
      this.UK.setVisibility(0);
      this.UK.setTextColor(getResources().getColor(2131166105));
      this.UK.setText(2131690734);
    }
    if (this.diy == 1)
    {
      ajgt.cN("0X800A264", 1);
      return;
    }
    ajgt.cN("0X800A287", 1);
  }
  
  private void dxb()
  {
    this.cod = false;
    if ((getActivity() == null) || (getActivity().isFinishing())) {}
    while (this.UK == null) {
      return;
    }
    this.UK.setVisibility(0);
    this.UK.setTextColor(getResources().getColor(2131166106));
    this.UK.setText(2131690737);
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
    super.LU(this.isStart);
    this.isStart = paramBoolean;
    if (this.diy == 1) {
      if (this.cnI) {
        ajgt.report("0X800A25F");
      }
    }
    while (this.diy != 2) {
      return;
    }
    ajgt.report("0X800A283");
  }
  
  protected void aZv()
  {
    super.aZv();
    aqnm.setVisible(this.jj, 8);
    aqnm.setVisible(this.jk, 8);
    aqnm.setVisible(this.jl, 8);
    aqnm.setVisible(this.jm, 0);
    if (this.diy == 1) {
      this.Bd.setImageResource(2130842119);
    }
    for (;;)
    {
      switch (this.dix)
      {
      case 3: 
      case 4: 
      default: 
        return;
        if (this.diy == 2) {
          this.Bd.setImageResource(2130842118);
        }
        break;
      }
    }
    dwY();
    this.cnT = ajgp.b().aqA();
    if (this.cnT)
    {
      dxb();
      return;
    }
    dxa();
    return;
    this.UJ.setText(2131690796);
    this.mUIHandler.removeMessages(10014);
    this.mUIHandler.sendEmptyMessageDelayed(10014, 800L);
    this.UK.setText(2131690737);
    dwY();
  }
  
  protected void bC(boolean paramBoolean, Object paramObject)
  {
    super.bC(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "mBizType = " + this.diy);
    }
    if (paramBoolean)
    {
      localObject1 = (ajeo)paramObject;
      if (this.diy != 1) {
        break label332;
      }
      if (paramObject != null) {
        break label77;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse, data is null!");
      }
    }
    label77:
    String str;
    int i;
    MsgBackupEndPoint localMsgBackupEndPoint1;
    MsgBackupEndPoint localMsgBackupEndPoint2;
    label332:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramObject = ((ajeo)localObject1).xl();
              str = ((ajeo)localObject1).getToken();
              i = ((ajeo)localObject1).Gi();
              localMsgBackupEndPoint1 = new MsgBackupEndPoint();
              localMsgBackupEndPoint2 = new MsgBackupEndPoint();
              j = ajgv.dB(((ajeo)localObject1).a().getIp());
              localMsgBackupEndPoint1.ipv4 = j;
              localMsgBackupEndPoint2.ipv4 = j;
              localObject2 = ((ajeo)localObject1).a().fE();
            } while (((List)localObject2).size() != 2);
            localMsgBackupEndPoint2.port = ((Integer)((List)localObject2).get(0)).intValue();
            localMsgBackupEndPoint1.port = ((Integer)((List)localObject2).get(1)).intValue();
            ajgp localajgp = ajee.a().a();
            ajdt localajdt = ajdt.a();
            localajgp.Mw(paramObject);
            localajdt.setToken(str);
            localajdt.QE(i);
            localajgp.b(localMsgBackupEndPoint2);
            localajgp.a(localMsgBackupEndPoint1);
            localajgp.QM(2);
            localajgp.QL(2);
          } while (!QLog.isColorLevel());
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse: client ip = " + ((ajeo)localObject1).a().getIp() + ", udpport = " + ((List)localObject2).get(1) + ", tcpport = " + ((List)localObject2).get(0));
          return;
        } while (this.diy != 2);
        if (paramObject != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "onConfirmQrResponse, data is null!");
      return;
      paramObject = ((ajeo)localObject1).xl();
      str = ((ajeo)localObject1).getToken();
      i = ((ajeo)localObject1).Gi();
      localMsgBackupEndPoint1 = new MsgBackupEndPoint();
      localMsgBackupEndPoint2 = new MsgBackupEndPoint();
      int j = ajgv.dB(((ajeo)localObject1).a().getIp());
      localMsgBackupEndPoint1.ipv4 = j;
      localMsgBackupEndPoint2.ipv4 = j;
      localObject2 = ((ajeo)localObject1).a().fE();
    } while (((List)localObject2).size() != 2);
    localMsgBackupEndPoint2.port = ((Integer)((List)localObject2).get(0)).intValue();
    localMsgBackupEndPoint1.port = ((Integer)((List)localObject2).get(1)).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "processConfirmRsp: server ip = " + ((ajeo)localObject1).a().getIp() + ", udpport = " + ((List)localObject2).get(1) + ", tcpport = " + ((List)localObject2).get(0));
    }
    Object localObject1 = ajee.a().a();
    Object localObject2 = ajdt.a();
    ((ajgp)localObject1).Mw(paramObject);
    ((ajdt)localObject2).setToken(str);
    ((ajdt)localObject2).QE(i);
    ((ajgp)localObject1).d(localMsgBackupEndPoint2);
    ((ajgp)localObject1).c(localMsgBackupEndPoint1);
    ((ajgp)localObject1).QM(1);
    ((ajgp)localObject1).QL(1);
  }
  
  protected void bindData()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    super.bindData();
    ajgv.aqD();
    this.mTotalCount = ajee.dio;
    if (ajgp.b().getRole() == 1) {
      this.t.postDelayed(this.hb, 15000L);
    }
    int i;
    Object localObject1;
    label162:
    Object localObject2;
    switch (this.dix)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 5: 
      this.isStart = true;
      this.ach = ajee.a().gn();
      ajee.cnG = false;
      int j = ajee.a().Gj();
      this.diq = j;
      iH(this.diq, this.mTotalCount);
      i = j;
      if (j != ajee.dio) {
        i = j + 1;
      }
      if (ajgp.b().getRole() == 1)
      {
        localObject1 = getActivity().getResources().getString(2131690798);
        if (this.UJ != null)
        {
          localObject2 = ajgv.bw(this.ach);
          this.UJ.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(i), Integer.valueOf(this.mTotalCount), (String)localObject2 + "B/s" }));
        }
        if (!ajgp.b().aqA()) {
          break label300;
        }
        dxb();
      }
      for (;;)
      {
        ajee.a().a().b(this);
        if (ajgp.b().getRole() != 2) {
          break label307;
        }
        if (!this.cnI) {
          break;
        }
        ajgt.report("0X800A261");
        return;
        localObject1 = getActivity().getResources().getString(2131690797);
        break label162;
        label300:
        dxa();
      }
      label307:
      ajgt.report("0X800A285");
      return;
    }
    long l2;
    long l1;
    if (ajee.a().b().Gi() == 1)
    {
      ajee.a().a().b(this);
      if (this.cnI) {
        ajee.a().ds(this.diy, this.mExtraData);
      }
      ajee.dio = ajee.a().bi.size();
      ajgt.dxs();
      ajgt.a.acq = ajee.dio;
      localObject1 = new ajek();
      localObject2 = new HashSet(ajee.a().bi.size());
      ((HashSet)localObject2).addAll(ajee.a().bi);
      ((ajek)localObject1).bj = ((HashSet)localObject2);
      ((ajek)localObject1).dir = 0;
      if (getActivity() == null) {
        break label662;
      }
      localObject2 = getActivity().getIntent();
      if (localObject2 == null) {
        break label662;
      }
      l2 = ((Intent)localObject2).getLongExtra("session_start_time", 0L);
      l1 = ((Intent)localObject2).getLongExtra("session_end_time", 0L);
      i = ((Intent)localObject2).getIntExtra("session_content_type", 1);
    }
    for (;;)
    {
      ajgv.c("MsgBackup_MsgBackupPCTransportFragment", "select params startTime = %d ,endTime = %d,contentType = %d ", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(i) });
      if ((l2 != 0L) && (l1 != 0L) && (l2 < l1))
      {
        ((ajek)localObject1).startTime = l2;
        ((ajek)localObject1).endTime = l1;
        if (i == 2) {}
        for (;;)
        {
          ((ajek)localObject1).cnN = bool1;
          ajee.a().d((ajek)localObject1);
          return;
          bool1 = false;
        }
      }
      ((ajek)localObject1).startTime = 0L;
      ((ajek)localObject1).endTime = 9223372036854775807L;
      if (i == 2) {}
      for (bool1 = bool2;; bool1 = false)
      {
        ((ajek)localObject1).cnN = bool1;
        break;
      }
      ajee.a().a().b(this);
      ajee.a().a().QO(4);
      if (!this.cnI) {
        break;
      }
      ajee.a().ds(this.diy, this.mExtraData);
      return;
      label662:
      i = 1;
      l1 = 0L;
      l2 = 0L;
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "doOnKeyDown is called! KEYCODE_BACK");
      }
      dwZ();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
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
        if (this.diy != 2) {
          break label120;
        }
        this.UK.setText(getString(2131690738));
      }
    }
    for (;;)
    {
      aqnm.setVisible(this.mProgressBar, 8);
      aqnm.setVisible(this.ak, 8);
      this.vg.hideLeftText();
      return;
      label120:
      this.UK.setText(getString(2131690705));
    }
  }
  
  public void dwZ()
  {
    super.dwZ();
    if ((this.cnI) && (this.diy == 1))
    {
      if (!this.cod) {
        break label56;
      }
      ajgt.cN("0X800A266", 3);
    }
    for (;;)
    {
      if (this.diy == 2)
      {
        if (this.cod) {
          break;
        }
        ajgt.cN("0X800A288", 1);
      }
      return;
      label56:
      if (!this.isStart) {
        ajgt.cN("0X800A266", 1);
      } else {
        ajgt.cN("0X800A266", 2);
      }
    }
    ajgt.cN("0X800A288", 2);
  }
  
  public void exit(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "pc退出了！------------------>exit called! ");
    }
    Message localMessage = this.mUIHandler.obtainMessage(10008);
    this.mUIHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    label111:
    String str2;
    int j;
    int k;
    switch (paramMessage.what)
    {
    default: 
    case 10008: 
    case 10003: 
      do
      {
        for (;;)
        {
          return super.handleMessage(paramMessage);
          dxc();
        }
      } while ((!this.isStart) && (!ajee.cnK));
      if (this.cnU)
      {
        this.cnU = false;
        if (this.diy == 1) {
          this.Bd.setImageResource(2130842119);
        }
      }
      else
      {
        this.vg.setLeftButton(2131690740);
        str2 = ajgv.bw(this.ach);
        j = paramMessage.arg1;
        k = paramMessage.arg2;
        iH(j, k);
        if (j == k) {
          break label753;
        }
      }
      break;
    }
    label357:
    label753:
    for (int i = j + 1;; i = j)
    {
      if (ajgp.b().getRole() == 1) {}
      for (String str1 = getActivity().getResources().getString(2131690798);; str1 = getActivity().getResources().getString(2131690797))
      {
        if (this.UJ != null) {
          this.UJ.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(k), str2 + "B/s" }));
        }
        if (this.UK != null) {
          this.UK.setText(2131690737);
        }
        if (j != k) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionCompleted->>>>>>>>");
        }
        ajee.a().a().b(null);
        if (ajgp.b().getRole() != 1) {
          break label357;
        }
        MsgBackupCompleteFragment.v(getActivity(), this.mTotalCount, this.diq);
        break;
        if (this.diy != 2) {
          break label111;
        }
        this.Bd.setImageResource(2130842118);
        break label111;
      }
      MsgBackupCompleteFragment.b(getActivity(), this.mTotalCount, this.diq, this.cnI);
      break;
      if ((!this.isStart) && (!ajee.cnK)) {
        break;
      }
      if (this.cnU)
      {
        this.cnU = false;
        if (this.diy == 1) {
          this.Bd.setImageResource(2130842119);
        }
      }
      else
      {
        this.vg.setLeftButton(2131690740);
        str2 = ajgv.bw(this.ach);
        ajgv.c("MsgBackup_MsgBackupPCTransportFragment", "transport speed ...xp.increaseLen = %d,compute result = %s", new Object[] { Long.valueOf(this.ach), str2 });
        j = this.diq;
        i = j;
        if (j != ajee.dio) {
          i = j + 1;
        }
        if (ajgp.b().getRole() != 1) {
          break label611;
        }
      }
      for (str1 = getActivity().getResources().getString(2131690798);; str1 = getActivity().getResources().getString(2131690797))
      {
        if (this.UJ != null) {
          this.UJ.setText(String.format(str1, new Object[] { Integer.valueOf(i), Integer.valueOf(ajee.dio), str2 + "B/s" }));
        }
        if (this.UK == null) {
          break;
        }
        this.UK.setText(2131690737);
        break;
        if (this.diy != 2) {
          break label421;
        }
        this.Bd.setImageResource(2130842118);
        break label421;
      }
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
      str1 = getActivity().getString(2131690796);
      i = this.diz + 1;
      this.diz = i;
      str1 = str1.substring(0, str1.length() - (2 - i % 3));
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
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "sessionProgress finishedSessions = " + paramInt1 + ", totalSession = " + paramInt2 + ", isStart = " + this.isStart);
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
    ajgv.c("MsgBackup_MsgBackupPCTransportFragment", "refreshProgress is called! finishedCount = %d, total = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity != null)
    {
      if ((this.diy == 2) || (this.cnI)) {
        paramActivity.overridePendingTransition(0, 0);
      }
    }
    else {
      return;
    }
    paramActivity.overridePendingTransition(2130772156, 2130772155);
  }
  
  public void kg(long paramLong)
  {
    super.kg(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup_MsgBackupPCTransportFragment", 2, "speedState!!! increment = " + paramLong + " , isStart = " + this.isStart + ", MsgBackupManager.isTransportStart = " + ajee.cnK);
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
    if (!ajee.cnG)
    {
      ajee.a().onDestroy();
      ajee.a().a().b(null);
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
 * Qualified Name:     com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCTransportFragment
 * JD-Core Version:    0.7.0.1
 */