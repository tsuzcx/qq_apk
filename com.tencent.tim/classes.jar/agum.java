import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.MPFileFailedView;
import com.tencent.mobileqq.filemanager.activity.MPFileVerifyPwdView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class agum
  extends agts
{
  View CQ = null;
  private View O;
  private achq jdField_a_of_type_Achq = new agur(this);
  aqlh jdField_a_of_type_Aqlh;
  private MPFileFailedView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView;
  private MPFileVerifyPwdView jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView;
  private long bG;
  private long bH;
  private long bI;
  private BroadcastReceiver bh;
  private INetEventHandler c;
  private boolean da = true;
  protected String fB;
  private int kJ;
  private int kK;
  private boolean mCanceled;
  
  public agum(BaseActivity paramBaseActivity, List<agsd> paramList, int paramInt)
  {
    super(paramBaseActivity);
    if (QLog.isColorLevel()) {
      QLog.i("MPcFileModel<FileAssistant>", 1, "FileBrowserModel init: type = mpc");
    }
    V(paramList, paramInt);
  }
  
  private void Ox(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.gb();
    }
    djI();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = new MPFileFailedView(this.e.getActivity(), this.mAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.ga();
    this.CQ = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.a(this.e.a(), new aguo(this), paramInt, this.kJ);
    this.e.a().setVisibility(0);
    this.e.a().removeAllViews();
    this.e.a().addView(this.CQ);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.CQ.setLayoutParams(localLayoutParams);
  }
  
  private void ag(int paramInt)
  {
    if ((paramInt & 0x2) == 2)
    {
      this.kJ = 1;
      return;
    }
    this.kJ = 0;
  }
  
  private void jN(long paramLong)
  {
    acde localacde = (acde)this.mAppInterface.getBusinessHandler(8);
    if (!this.da)
    {
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,connPcSessionId:" + paramLong + ",mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
    this.bH = NetConnInfoCenter.getServerTimeMillis();
    this.mCanceled = true;
    paramLong = localacde.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramLong, this.kJ);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
      }
      ahao.OS(2131695433);
      return;
    }
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.status = 2;
  }
  
  public agss a()
  {
    if (this.jdField_a_of_type_Agss == null) {
      this.jdField_a_of_type_Agss = new agus(this);
    }
    return this.jdField_a_of_type_Agss;
  }
  
  public agsv a()
  {
    return this.jdField_a_of_type_Agsv;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    if (!ahbj.isFileExists(getFilePath())) {
      return null;
    }
    return super.a();
  }
  
  public String aC()
  {
    return "";
  }
  
  public String ax()
  {
    return "biz_src_jc_file";
  }
  
  public aebf b()
  {
    String str = getFilePath();
    if (aqhq.fileExistsAndNotEmpty(str)) {
      return new agso(str);
    }
    return new agsm();
  }
  
  public void b(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      this.fB = new JSONObject(paramArrayOfByte).getString("nonce");
      if (paramBoolean) {
        this.kK += 1;
      }
      if (this.kK >= 3)
      {
        this.jdField_a_of_type_Aqlh = new aqlh(this.mContext, 2131756467);
        this.jdField_a_of_type_Aqlh.setContentView(2131559153);
        this.jdField_a_of_type_Aqlh.setTitle(2131696019);
        this.jdField_a_of_type_Aqlh.a(2131696018);
        this.jdField_a_of_type_Aqlh.a(0, 0, null);
        this.jdField_a_of_type_Aqlh.a(2131695421, new aguq(this));
        this.jdField_a_of_type_Aqlh.show();
      }
      if ((paramBoolean) && (this.kK < 3)) {
        ahao.OS(2131696047);
      }
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "RelayHttpMgrInfo roomno:" + this.fB);
      if (this.e != null) {
        this.e.ar(false);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null) {
        fK();
      }
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public int bE()
  {
    int i = getFileType();
    int j = super.bE();
    if (j != 0) {
      return j;
    }
    switch (i)
    {
    default: 
      return 1;
    }
    return 6;
  }
  
  public int bM()
  {
    int j = 2;
    int i = getFileType();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      if (aqhq.fileExistsAndNotEmpty(getFilePath())) {
        if ((this.e != null) && (this.e.bZ())) {
          i = j;
        }
      }
      for (;;)
      {
        return i;
        i = 1;
        continue;
        i = 0;
      }
    }
  }
  
  public void djI()
  {
    if (this.O != null)
    {
      this.O.setVisibility(8);
      this.e.a().removeView(this.O);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.finish();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = null;
    }
  }
  
  protected void djJ()
  {
    if (this.CQ != null)
    {
      this.CQ.setVisibility(8);
      this.e.a().removeView(this.CQ);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView.finish();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileFailedView = null;
    }
  }
  
  public void djK()
  {
    this.da = true;
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:" + this.da);
    this.kK = 0;
    jN(this.bG);
    Object localObject = (InputMethodManager)this.e.a().getContext().getSystemService("input_method");
    boolean bool = ((InputMethodManager)localObject).isActive();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) && (bool))
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.getWindowToken(), 0);
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.e.a().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.gb();
    }
    localObject = this.jdField_c_of_type_Agsd.b();
    if (!this.da)
    {
      ((FileManagerEntity)localObject).mContext = "needMPFileC2C";
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + this.da + ",create mEntity.mContext");
    }
    for (;;)
    {
      djI();
      djJ();
      this.e.a().removeAllViews();
      this.e.ir();
      this.e.it();
      return;
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + this.da + "mEntity.mContext = null");
      ((FileManagerEntity)localObject).mContext = null;
    }
  }
  
  protected void djL()
  {
    acde localacde = (acde)this.mAppInterface.getBusinessHandler(8);
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:" + this.da);
    if (!this.da) {
      if (localacde.a().aT())
      {
        this.bG = localacde.a().f(1);
        QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:" + this.bG);
      }
    }
    label298:
    do
    {
      long l;
      do
      {
        return;
        this.bG = localacde.a().f(2);
        break;
        QLog.d("MPcFileModel<FileAssistant>", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
        this.bH = NetConnInfoCenter.getServerTimeMillis();
        this.mCanceled = true;
        l = localacde.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize);
        if (l != -1L) {
          break label298;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
        ahao.OS(2131695433);
      } while (this.jdField_a_of_type_Aguk$d == null);
      this.jdField_a_of_type_Aguk$d.djH();
      return;
      localFileManagerEntity.uniseq = l;
      localFileManagerEntity.status = 2;
    } while (this.jdField_a_of_type_Aguk$d == null);
    this.jdField_a_of_type_Aguk$d.djE();
  }
  
  protected void djM()
  {
    this.mCanceled = true;
    acde localacde = (acde)this.mAppInterface.getBusinessHandler(8);
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    localacde.a().Z(localFileManagerEntity.strDataLineMPFileID);
    localFileManagerEntity.status = 3;
  }
  
  public Intent f()
  {
    return super.f();
  }
  
  protected void fK()
  {
    djJ();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView = new MPFileVerifyPwdView(this.e.getActivity(), this.mAppInterface);
    this.O = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.a(this.e.a(), new agup(this));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.ga();
    this.e.a().setVisibility(0);
    this.e.a().removeAllViews();
    this.e.a().addView(this.O);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.O.setLayoutParams(localLayoutParams);
  }
  
  public void fL()
  {
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc CS_RES_403CHECK!");
  }
  
  public void fM()
  {
    this.da = false;
    QLog.d("MPcFileModel<FileAssistant>", 1, "pc disconnect!");
  }
  
  protected void ix()
  {
    if (this.bh == null)
    {
      this.bh = new agum.a();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(avin.cKW);
      localIntentFilter.addAction(avin.cKZ);
      localIntentFilter.setPriority(200);
      this.mContext.registerReceiver(this.bh, localIntentFilter);
    }
    this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new agun(this);
    AppNetConnInfo.registerNetChangeReceiver(this.mContext, this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void p(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      i = new JSONObject(paramArrayOfByte).getInt("changePwd");
      if (i == 1)
      {
        ahao.OT(2131696011);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView != null) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.gd();
        }
        return;
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          int i = 0;
        }
        ahao.OS(2131696010);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityMPFileVerifyPwdView.gd();
    }
  }
  
  protected void removeObserver()
  {
    if (this.bh != null) {
      this.mContext.unregisterReceiver(this.bh);
    }
    if (this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler != null) {
      AppNetConnInfo.unregisterNetEventHandler(this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    }
    this.bh = null;
    this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = null;
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    private void a(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
    {
      if (paramIntent.getLongExtra("token_task_id", 0L) != paramFileManagerEntity.uniseq) {}
      for (;;)
      {
        return;
        long l1 = paramIntent.getLongExtra("token_current_size", 0L);
        long l2 = paramIntent.getLongExtra("token_total_size", 0L);
        paramFileManagerEntity.status = 2;
        if (l2 != 0L) {}
        for (paramFileManagerEntity.fProgress = ((float)l1 / (float)l2); agum.this.a != null; paramFileManagerEntity.fProgress = 1.0F)
        {
          agum.this.a.aO(paramFileManagerEntity.fProgress);
          return;
        }
      }
    }
    
    private void b(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
    {
      long l1 = paramIntent.getLongExtra("token_task_id", 0L);
      if (l1 != paramFileManagerEntity.uniseq) {
        return;
      }
      agum.b(agum.this, NetConnInfoCenter.getServerTimeMillis());
      long l2 = paramIntent.getLongExtra("token_current_size", 0L);
      boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
      int j = paramIntent.getIntExtra("token_http_code", 0);
      QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
      paramIntent = new ReportItem();
      paramIntent.uSessionID = l1;
      paramIntent.uChannelType = 6;
      paramIntent.bSend = false;
      paramIntent.uNotifyTime = agum.a(agum.this);
      paramIntent.uFileSize = l2;
      paramIntent.bFileExist = false;
      paramIntent.uStartPos = 0L;
      paramIntent.uTaskStart = agum.a(agum.this);
      paramIntent.uTaskEnd = agum.b(agum.this);
      paramIntent.uDuration = (agum.b(agum.this) - agum.a(agum.this));
      paramIntent.bUserRetry = false;
      paramIntent.sSuffix = "";
      int i;
      if (bool)
      {
        i = 2;
        paramIntent.emResult = i;
        paramIntent.nFailCode = 0;
        paramIntent.nUserCode = j;
        Object localObject = ((acde)agum.this.mAppInterface.getBusinessHandler(8)).a().a();
        if (localObject == null) {
          break label489;
        }
        paramIntent.dwServerIP = ct.k(((avip)localObject).serverIp);
        paramIntent.wServerPort = ((short)((avip)localObject).serverPort);
        label281:
        paramIntent.dwClientIP = ct.k(ct.K());
        localObject = agum.this.mAppInterface;
        if (paramFileManagerEntity.peerDin != 0L) {
          break label502;
        }
        i = dt.dM;
        label313:
        dt.a((QQAppInterface)localObject, paramIntent, i);
        if (bool) {
          break label595;
        }
        paramFileManagerEntity.status = 3;
        if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
          break label509;
        }
        ahao.OS(2131696023);
        label366:
        if (agum.this.a != null) {
          agum.this.a.djH();
        }
      }
      label697:
      for (;;)
      {
        ((acde)agum.this.mAppInterface.getBusinessHandler(8)).a().a(paramFileManagerEntity.strDataLineMPFileID);
        if (agum.a(agum.this)) {
          break label699;
        }
        paramFileManagerEntity.mContext = "needMPFileC2C";
        QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + agum.a(agum.this) + ",create mEntity.mContext");
        return;
        if (agum.b(agum.this))
        {
          i = 32;
          break;
        }
        i = 41;
        break;
        label489:
        paramIntent.dwServerIP = 0;
        paramIntent.wServerPort = 0;
        break label281;
        label502:
        i = dt.dO;
        break label313;
        label509:
        if (j == 1)
        {
          ahao.OS(2131696021);
          break label366;
        }
        if (j == 1004)
        {
          ahao.OS(2131696022);
          break label366;
        }
        if (j == 11)
        {
          QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file download!");
          break label366;
        }
        if (j == 12)
        {
          QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file predownload!");
          break label366;
        }
        agum.a(agum.this, j + 2100);
        break label366;
        label595:
        paramFileManagerEntity.status = 1;
        paramIntent = ((acde)agum.this.mAppInterface.getBusinessHandler(8)).a().ae();
        if (paramIntent == null) {
          if (QLog.isColorLevel()) {
            QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
          }
        }
        for (;;)
        {
          if (agum.this.a == null) {
            break label697;
          }
          agum.this.a.djG();
          break;
          paramFileManagerEntity.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramFileManagerEntity.fileName }));
          paramFileManagerEntity.setCloudType(3);
        }
      }
      label699:
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + agum.a(agum.this) + "mEntity.mContext = null");
      paramFileManagerEntity.mContext = null;
    }
    
    private void c(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
    {
      paramFileManagerEntity = paramIntent.getExtras();
      long l = paramIntent.getLongExtra(avin.cKY, 0L);
      int i = paramFileManagerEntity.getInt(avin.cKX);
      int j = paramFileManagerEntity.getInt("result");
      if ((i == 0) && (j == 0)) {
        agum.a(agum.this, true);
      }
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
      if (agum.c(agum.this) != l) {}
      do
      {
        boolean bool;
        do
        {
          return;
          if (i != 0) {
            break;
          }
          i = paramFileManagerEntity.getInt("result");
          paramIntent = paramFileManagerEntity.getByteArray("bytes_json");
          j = paramFileManagerEntity.getInt("power");
          agum.b(agum.this, j);
          bool = paramFileManagerEntity.getBoolean("inputPwdError", false);
          switch (i)
          {
          default: 
            QLog.d("MPcFileModel<FileAssistant>", 1, "andorid 6.3.0 accept valid C2C response:" + i);
            return;
          case 0: 
            agum.this.djK();
            return;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
            agum.a(agum.this, i + 2000);
          }
        } while (agum.this.e == null);
        agum.this.e.ar(false);
        return;
        agum.this.b(paramIntent, bool);
        return;
        agum.this.p(paramIntent);
        return;
        agum.this.fL();
        return;
        agum.this.fM();
        return;
        if (i == 1013)
        {
          ahao.OS(2131696012);
          return;
        }
        if (i == 1014)
        {
          ahao.OS(2131696038);
          return;
        }
        agum.a(agum.this, i);
      } while (agum.this.e == null);
      agum.this.e.ar(false);
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = agum.this.c.b();
      if (paramIntent == null) {}
      String str;
      do
      {
        do
        {
          return;
          str = paramIntent.getAction();
        } while (str == null);
        if (str.equals("com.dataline.mpfile.download_progress"))
        {
          a(paramIntent, paramContext);
          return;
        }
        if (str.equals("com.dataline.mpfile.download_completed"))
        {
          b(paramIntent, paramContext);
          return;
        }
        if (avin.cKW.equalsIgnoreCase(str))
        {
          c(paramIntent, paramContext);
          return;
        }
      } while (!avin.cKZ.equalsIgnoreCase(str));
      agum.a(agum.this, false);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
      ahao.OS(2131696022);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agum
 * JD-Core Version:    0.7.0.1
 */