import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.activity.MPFileFailedView;
import com.tencent.tim.filemanager.activity.MPFileVerifyPwdView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class auaa
  extends atzs
{
  View CQ = null;
  private View O;
  private achq jdField_a_of_type_Achq = new auag(this);
  aqlh jdField_a_of_type_Aqlh;
  private MPFileFailedView jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView;
  private MPFileVerifyPwdView jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView;
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
  
  public auaa(BaseActivity paramBaseActivity, List<agsd> paramList, int paramInt)
  {
    super(paramBaseActivity);
    V(paramList, paramInt);
  }
  
  private void Ox(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.gb();
    }
    djI();
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView = new MPFileFailedView(this.e.getActivity(), this.mAppInterface);
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView.ga();
    this.CQ = this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView.a(this.e.a(), new auad(this), paramInt, this.kJ);
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
      QLog.d("MPcFileModel[MPFile]", 1, "MPFileDoDownloadWithBuildConnection mConnPCSuc false!");
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    QLog.d("MPcFileModel", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,connPcSessionId:" + paramLong + ",mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
    this.bH = NetConnInfoCenter.getServerTimeMillis();
    this.mCanceled = true;
    paramLong = localacde.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize, paramLong, this.kJ);
    if (paramLong == -1L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MPcFileModel", 2, "doDownload , plugin service not started");
      }
      auds.OS(2131695433);
      return;
    }
    localFileManagerEntity.uniseq = paramLong;
    localFileManagerEntity.status = 2;
  }
  
  public atyz a()
  {
    if (this.jdField_a_of_type_Atyz == null) {
      this.jdField_a_of_type_Atyz = new auah(this);
    }
    return this.jdField_a_of_type_Atyz;
  }
  
  public atzb a()
  {
    return this.jdField_a_of_type_Atzb;
  }
  
  public String aC()
  {
    return "";
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
        this.jdField_a_of_type_Aqlh.a(2131695421, new auaf(this));
        this.jdField_a_of_type_Aqlh.show();
      }
      if ((paramBoolean) && (this.kK < 3)) {
        auds.OS(2131696047);
      }
      QLog.d("MPcFileModel[MPFile]", 1, "RelayHttpMgrInfo roomno:" + this.fB);
      if (this.e != null) {
        this.e.ar(false);
      }
      if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView == null) {
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
  
  public void djI()
  {
    if (this.O != null)
    {
      this.O.setVisibility(8);
      this.e.a().removeView(this.O);
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView != null)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.finish();
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView = null;
    }
  }
  
  protected void djJ()
  {
    if (this.CQ != null)
    {
      this.CQ.setVisibility(8);
      this.e.a().removeView(this.CQ);
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView != null)
    {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView.finish();
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileFailedView = null;
    }
  }
  
  public void djK()
  {
    this.da = true;
    QLog.d("MPcFileModel", 2, "CLOUD_TYPE_DATALINEMPFILE process_CS_SERVER_OK,mConnPCSuc:" + this.da);
    this.kK = 0;
    jN(this.bG);
    Object localObject = (InputMethodManager)this.e.a().getContext().getSystemService("input_method");
    boolean bool = ((InputMethodManager)localObject).isActive();
    if ((this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView != null) && (bool))
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.getWindowToken(), 0);
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.e.a().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView != null) {
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.gb();
    }
    localObject = this.jdField_c_of_type_Agsd.b();
    if (!this.da)
    {
      ((FileManagerEntity)localObject).mContext = "needMPFileC2C";
      QLog.d("MPcFileModel", 2, "mConnPCSuc:" + this.da + ",create mEntity.mContext");
    }
    for (;;)
    {
      djI();
      djJ();
      this.e.a().removeAllViews();
      this.e.ir();
      this.e.it();
      return;
      QLog.d("MPcFileModel", 2, "mConnPCSuc:" + this.da + "mEntity.mContext = null");
      ((FileManagerEntity)localObject).mContext = null;
    }
  }
  
  protected void djL()
  {
    acde localacde = (acde)this.mAppInterface.getBusinessHandler(8);
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    QLog.d("MPcFileModel", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mConnPCSuc:" + this.da);
    if (!this.da) {
      if (localacde.a().aT())
      {
        this.bG = localacde.a().f(1);
        QLog.d("MPcFileModel[MPFile]", 1, "MPFile doDownload() mConnPCSuc false,mConnectPcSessionId:" + this.bG);
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
        QLog.d("MPcFileModel", 2, "CLOUD_TYPE_DATALINEMPFILE doDownload,mEntity.uniseq:" + localFileManagerEntity.uniseq + ",mEntity.peerDin:" + localFileManagerEntity.peerDin + ",mEntity.strDataLineMPFileID:" + localFileManagerEntity.strDataLineMPFileID + " ,mEntity.fileName:" + localFileManagerEntity.fileName + ",mEntity.fileSize:" + localFileManagerEntity.fileSize);
        this.bH = NetConnInfoCenter.getServerTimeMillis();
        this.mCanceled = true;
        l = localacde.a().a(localFileManagerEntity.uniseq, localFileManagerEntity.peerDin, localFileManagerEntity.strDataLineMPFileID, localFileManagerEntity.fileName, localFileManagerEntity.fileSize);
        if (l != -1L) {
          break label298;
        }
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel", 2, "doDownload , plugin service not started");
        }
        auds.OS(2131695433);
      } while (this.jdField_a_of_type_Atzy$d == null);
      this.jdField_a_of_type_Atzy$d.djH();
      return;
      localFileManagerEntity.uniseq = l;
      localFileManagerEntity.status = 2;
    } while (this.jdField_a_of_type_Atzy$d == null);
    this.jdField_a_of_type_Atzy$d.djE();
  }
  
  protected void djM()
  {
    this.mCanceled = true;
    acde localacde = (acde)this.mAppInterface.getBusinessHandler(8);
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_Agsd.b();
    localacde.a().Z(localFileManagerEntity.strDataLineMPFileID);
    localFileManagerEntity.status = 3;
  }
  
  public ArrayList<aufa.b> er()
  {
    if (!aueh.isFileExists(getFilePath())) {
      return new ArrayList();
    }
    return super.er();
  }
  
  protected void fK()
  {
    djJ();
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView = new MPFileVerifyPwdView(this.e.getActivity(), this.mAppInterface);
    this.O = this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.a(this.e.a(), new auae(this));
    this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.ga();
    this.e.a().setVisibility(0);
    this.e.a().removeAllViews();
    this.e.a().addView(this.O);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.O.setLayoutParams(localLayoutParams);
  }
  
  public void fL()
  {
    QLog.d("MPcFileModel", 1, "pc CS_RES_403CHECK!");
  }
  
  public void fM()
  {
    this.da = false;
    QLog.d("MPcFileModel", 1, "pc disconnect!");
  }
  
  protected void ix()
  {
    if (this.bh == null)
    {
      this.bh = new auab(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.dataline.mpfile.download_progress");
      localIntentFilter.addAction("com.dataline.mpfile.download_completed");
      localIntentFilter.addAction(avin.cKW);
      localIntentFilter.addAction(avin.cKZ);
      localIntentFilter.setPriority(200);
      this.mContext.registerReceiver(this.bh, localIntentFilter);
    }
    this.jdField_c_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new auac(this);
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
        auds.OT(2131696011);
        if (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView != null) {
          this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.gd();
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
        auds.OS(2131696010);
      } while (this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView == null);
      this.jdField_a_of_type_ComTencentTimFilemanagerActivityMPFileVerifyPwdView.gd();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auaa
 * JD-Core Version:    0.7.0.1
 */