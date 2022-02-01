package com.tencent.mobileqq.fragment;

import ajds;
import ajgp;
import ajgv;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.a;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupEndPoint;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupJniProxy;
import com.tencent.mobileqq.msgbackup.transport.MsgBackupNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class MsgBackupSettingFragment$8
  implements Runnable
{
  MsgBackupSettingFragment$8(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "loadSo msgbackup start for client");
    }
    Object localObject = BaseApplicationImpl.getContext();
    this.this$0.a = new MsgBackupJniProxy((Context)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "loadSo msgbackup end for client");
    }
    MsgBackupSettingFragment.a(this.this$0, 1);
    this.this$0.session = this.this$0.a.createSession(1, Long.parseLong(this.this$0.getActivity().app.getCurrentAccountUin()), new MsgBackupNotifier());
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "createSession end, operator = " + this.this$0.session);
    }
    MsgBackupSettingFragment.b(this.this$0, new MsgBackupEndPoint());
    MsgBackupSettingFragment.a(this.this$0, new MsgBackupEndPoint());
    int i = this.this$0.a.start(this.this$0.session, MsgBackupSettingFragment.a(this.this$0), MsgBackupSettingFragment.b(this.this$0));
    if (QLog.isColorLevel()) {
      QLog.d("MsgBackup", 2, "after start called with ret = " + i + ", ipv4 = " + ajgv.ez(MsgBackupSettingFragment.a(this.this$0).ipv4) + ", udpport = " + MsgBackupSettingFragment.a(this.this$0).port + ", tcpport = " + MsgBackupSettingFragment.b(this.this$0).port);
    }
    localObject = new MsgBackupUserData.a();
    ((MsgBackupUserData.a)localObject).c(MsgBackupSettingFragment.a(this.this$0)[1]);
    ((MsgBackupUserData.a)localObject).b(MsgBackupSettingFragment.a(this.this$0)[0]);
    ArrayList localArrayList = new ArrayList(2);
    ((MsgBackupUserData.a)localObject).a(ajgv.ez(ajgp.b().b().ipv4));
    localArrayList.add(Integer.valueOf(ajgp.b().b().port));
    localArrayList.add(Integer.valueOf(ajgp.b().a().port));
    ((MsgBackupUserData.a)localObject).a(localArrayList);
    localObject = ((MsgBackupUserData.a)localObject).b();
    ((ajds)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(162)).a((MsgBackupUserData)localObject, MsgBackupSettingFragment.c(this.this$0), MsgBackupSettingFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.MsgBackupSettingFragment.8
 * JD-Core Version:    0.7.0.1
 */