import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.3;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.4;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class agwv
  extends agwc
  implements aguk.d
{
  private aobe a;
  public SimpleFileViewer a;
  private agrd.a jdField_b_of_type_Agrd$a = new agwx(this);
  private agrj.a jdField_b_of_type_Agrj$a = new agwy(this);
  private boolean cfA;
  private boolean cfB;
  protected boolean cfm = true;
  private boolean cfv;
  private volatile boolean cfw;
  private boolean cfx;
  private boolean cfy;
  private boolean cfz;
  private Runnable gw;
  private boolean isFinish;
  private boolean isPause;
  private Handler mHandler = new Handler();
  
  public agwv(aguk paramaguk, Activity paramActivity)
  {
    super(paramaguk, paramActivity);
    this.jdField_a_of_type_Aobe = new agwv.a(null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.mContext);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  private final void JH(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Agsb != null) {
      this.jdField_b_of_type_Agsb.as(paramBoolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.amE()) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkv();
    }
    while (((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.cb() == null) && (!this.jdField_a_of_type_Aguk.co())) || (paramBoolean) || ((this.cfy) && (!this.cfz))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Aguk.a());
  }
  
  private void bm(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    Object localObject = aeue.a();
    int i;
    if (paramBoolean)
    {
      localObject = ((aeud)localObject).bBC;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        i = j;
        if (paramInt != 1)
        {
          if (paramInt != 3000) {
            break label80;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, i, 0, "", "", "", "");
      return;
      localObject = ((aeud)localObject).bBE;
      break;
      label80:
      if (paramInt == 0) {
        i = 0;
      } else {
        i = 3;
      }
    }
  }
  
  private void dkg()
  {
    this.gw = new SimpleFilePresenter.3(this);
  }
  
  private void dkh()
  {
    if (this.gw != null)
    {
      this.mHandler.removeCallbacks(this.gw);
      this.gw = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OK(8);
    }
    this.cfv = true;
  }
  
  private final void dki()
  {
    if (aobw.g(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_a_of_type_Aguk.getFileName(), this.jdField_a_of_type_Aguk.getFileSize()))
    {
      this.jdField_a_of_type_Aguk.aI(13);
      aoag.h(this.jdField_a_of_type_Aguk.a());
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return;
        if (aobw.h(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_a_of_type_Aguk.getFileName(), this.jdField_a_of_type_Aguk.getFileSize()))
        {
          this.jdField_a_of_type_Aguk.aI(11);
          aoag.h(this.jdField_a_of_type_Aguk.a());
          return;
        }
      } while (!this.jdField_a_of_type_Aguk.co());
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Aguk.a();
      aoag.g(localTeamWorkFileImportInfo);
    } while ((this.cfy) && (!this.cfz));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(localTeamWorkFileImportInfo);
  }
  
  public void a(List<String> paramList, String paramString, boolean paramBoolean, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    ThreadManager.excute(new SimpleFilePresenter.2(this, paramString, paramBoolean, paramInt, paramList), 128, null, false);
  }
  
  public void aO(float paramFloat)
  {
    aP(paramFloat);
    String str = this.jdField_a_of_type_Aguk.vM();
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OK(0);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jo(str);
    } while (this.gw != null);
    dkg();
    this.mHandler.post(this.gw);
    this.cfv = false;
  }
  
  public boolean amj()
  {
    if (this.cfy) {
      this.mContext.setRequestedOrientation(4);
    }
    while ((!this.cfm) && (!this.cfy))
    {
      return true;
      if (this.cfm) {
        this.mContext.setRequestedOrientation(1);
      }
    }
    return false;
  }
  
  public boolean amk()
  {
    return (this.cfm) && (!this.cfy);
  }
  
  public void c(Configuration paramConfiguration)
  {
    super.c(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.mContext.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int i = paramConfiguration.widthPixels;
    int j = paramConfiguration.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.ig(i, j);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.ih(i, j);
  }
  
  public void cqt()
  {
    if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_Aobe);
    }
    this.isFinish = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkx();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkz();
    }
    agrd.a().onDestroy(this.mContext);
    agrj.a().onDestroy(this.mContext);
    dkh();
    super.cqt();
  }
  
  public void djE()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(true);
    aP(this.jdField_a_of_type_Aguk.k());
    int i = this.jdField_a_of_type_Aguk.bK();
    if ((i != 1) && (i == 4)) {}
  }
  
  public void djF()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    djT();
    djU();
    dkh();
  }
  
  public void djG()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    djT();
    djU();
    if (this.jdField_b_of_type_Agsa != null)
    {
      if ((BaseApplicationImpl.sProcessId != 1) || (!avlx.a().L(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_a_of_type_Aguk.getFileSize()))) {
        break label98;
      }
      avlx.a().L(this.jdField_b_of_type_Agsa.getActivity(), this.jdField_a_of_type_Aguk.getFilePath(), true);
      this.jdField_b_of_type_Agsa.is();
    }
    for (;;)
    {
      dkh();
      return;
      label98:
      this.jdField_b_of_type_Agsa.ir();
    }
  }
  
  public void djH()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(false);
    djT();
    djU();
    dkh();
  }
  
  protected void djR()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Aguk.getFileName() + "]");
    }
    if (this.jdField_a_of_type_Aguk.getFileType() == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OP(2130845117);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Ju(this.jdField_a_of_type_Aguk.aB());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aguk.aC())) && (16 != this.jdField_a_of_type_Aguk.bF())) {
        break label162;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JR(false);
      label113:
      if (this.jdField_a_of_type_Aguk.bF() != 16) {
        break label179;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131693595));
    }
    label162:
    label179:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OO(ahav.r(this.jdField_a_of_type_Aguk.getFileName()));
        break;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aC());
        break label113;
        if (this.jdField_a_of_type_Aguk.isFromProcessingForward2c2cOrDiscItem())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131693824));
          return;
        }
        if (this.jdField_a_of_type_Aguk.ci())
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(BaseApplicationImpl.getContext().getString(2131693595));
          return;
        }
        if (!this.jdField_a_of_type_Aguk.cn()) {
          break label287;
        }
      } while (this.jdField_a_of_type_Aguk.a() == null);
      this.jdField_a_of_type_Aguk.a().iE();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JK(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JJ(false);
      aP(0.0F);
      return;
    } while (!aobw.i(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_a_of_type_Aguk.getFileName(), this.jdField_a_of_type_Aguk.getFileSize()));
    label287:
    this.jdField_a_of_type_Aguk.aI(7);
    aoag.a(this.jdField_a_of_type_Aguk.a(), "SimpleFilePresenter<FileAssistant>");
  }
  
  protected void djU()
  {
    if ((aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) && (QbSdk.isSuportOpenFile(ahav.lb(this.jdField_a_of_type_Aguk.getFileName()), 2)))
    {
      String str = this.mContext.getString(2131696669);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(str, new agww(this));
    }
  }
  
  protected void djW()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Aguk.getFileName() + "] filePath[" + this.jdField_a_of_type_Aguk.getFilePath() + "]");
    }
    if (this.jdField_a_of_type_Aguk.bL() == 2) {
      agrj.a().a(this.mContext, this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_b_of_type_Agrj$a, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OO(ahav.r(this.jdField_a_of_type_Aguk.getFileName()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Js(this.jdField_a_of_type_Aguk.aA());
    this.mContext.getString(2131693595);
    if (this.jdField_a_of_type_Aguk.bF() == 16)
    {
      String str = BaseApplicationImpl.getContext().getString(2131693595);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jt(str);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.showTip(true);
    }
    djU();
  }
  
  protected void djX()
  {
    super.djX();
    djU();
  }
  
  protected void dkj()
  {
    if (aqhq.fileExistsAndNotEmpty(this.jdField_a_of_type_Aguk.getFilePath())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JS(false);
    }
    String str;
    do
    {
      return;
      str = aequ.d().c.tG();
    } while ((!aqiw.isNetworkAvailable(this.mContext)) || (aqiw.isWifiConnected(this.mContext)) || (!aequ.d().c.enable) || (aqvn.a().pz()) || (TextUtils.isEmpty(str)));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.G(new agwz(this, str));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.isPause = true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.cfA)
    {
      if (this.cfx) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_b_of_type_Agrd$a);
      }
      if (this.cfy) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(this.jdField_a_of_type_Aguk.getFilePath(), this.jdField_b_of_type_Agrj$a);
      }
    }
    this.cfA = true;
    this.isPause = false;
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    if ((this.jdField_a_of_type_Aguk != null) && (this.jdField_a_of_type_Aguk.a() != null))
    {
      localTeamWorkFileImportInfo = this.jdField_a_of_type_Aguk.a();
      if (!localTeamWorkFileImportInfo.azu()) {
        break label153;
      }
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface))
      {
        localaoar = (aoar)((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getBusinessHandler(120);
        if ((localaoar != null) && (!localaoar.e(localTeamWorkFileImportInfo))) {
          aoag.a(localTeamWorkFileImportInfo, "SimpleFilePresenter<FileAssistant>");
        }
      }
    }
    label153:
    while ((!localTeamWorkFileImportInfo.azt()) || (!this.cfB))
    {
      aoar localaoar;
      return;
    }
    this.cfB = false;
    aoag.h(localTeamWorkFileImportInfo);
  }
  
  public void init()
  {
    if (this.cfw)
    {
      this.cfw = false;
      return;
    }
    super.init();
    if (QLog.isColorLevel()) {
      QLog.i("SimpleFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JQ(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.showTip(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jr(this.jdField_a_of_type_Aguk.getFileName());
    if (ahav.isLocalFile(this.jdField_a_of_type_Aguk.getFilePath())) {
      djW();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aguk.a(this);
      if ((BaseApplicationImpl.sApplication.getRuntime() instanceof QQAppInterface)) {
        ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).addObserver(this.jdField_a_of_type_Aobe);
      }
      dkj();
      return;
      djR();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 2864)
    {
      if (paramInt2 != 0) {
        break label55;
      }
      paramIntent = this.jdField_a_of_type_Aguk.a();
      if ((paramIntent != null) && (paramIntent.aTw != null)) {
        ThreadManager.excute(new SimpleFilePresenter.1(this, paramIntent), 128, null, false);
      }
    }
    label54:
    label55:
    Object localObject1;
    do
    {
      do
      {
        do
        {
          break label54;
          do
          {
            return;
          } while (paramInt2 != -1);
          aodb.aN(null, "0X800A5A4");
          aodb.aN(null, "0X800A5A3");
          localObject1 = BaseApplicationImpl.sApplication.getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject2 = (aoar)((QQAppInterface)localObject1).getBusinessHandler(120);
        localObject1 = this.jdField_a_of_type_Aguk.a();
      } while ((localObject2 == null) || (localObject1 == null));
      localObject2 = ((aoar)localObject2).c((TeamWorkFileImportInfo)localObject1);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.cv(0, (String)localObject2);
      }
      localObject2 = paramIntent.getExtras();
      paramIntent = ((Bundle)localObject2).getString("uin");
      paramInt1 = ((Bundle)localObject2).getInt("uintype", 0);
    } while ((localObject1 == null) || (((TeamWorkFileImportInfo)localObject1).aTw == null));
    Object localObject2 = new ArrayList(1);
    ((List)localObject2).add(paramIntent);
    boolean bool = aeue.a().lJ(((TeamWorkFileImportInfo)localObject1).fileName);
    a((List)localObject2, ((TeamWorkFileImportInfo)localObject1).aTw, bool, paramInt1);
  }
  
  public class a
    extends aobe
  {
    private a() {}
    
    private void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
    {
      try
      {
        if (paramJSONObject.getInt("retcode") != 0)
        {
          agwv.this.mContext.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.2(this));
          if (paramTeamWorkFileImportInfo.azs()) {
            aobh.bA(paramTeamWorkFileImportInfo.aTw, agwv.this.jdField_a_of_type_Aguk.getCurrentAccountUin());
          }
          anot.a(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
          return;
        }
        b(paramJSONObject, paramTeamWorkFileImportInfo, paramString);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        anot.a(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
        QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", paramJSONObject);
        QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131721071, 0).show();
      }
    }
    
    private void b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      ThreadManager.excute(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1(this, paramString, paramTeamWorkFileImportInfo), 128, null, false);
    }
    
    private void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
      throws JSONException
    {
      TencentDocData localTencentDocData = new TencentDocData();
      TencentDocData.obtainFromJsonObject(paramJSONObject, null, localTencentDocData);
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("key_flag_from_plugin", true);
      paramJSONObject.putExtra("k_forward_show_direct_share_tips", true);
      if (paramTeamWorkFileImportInfo.azr())
      {
        paramJSONObject.setClass(agwv.this.mContext, ForwardRecentActivity.class);
        aqmf.a(agwv.this.mContext, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, agwv.this.mContext.getString(2131698632, new Object[] { localTencentDocData.title }), paramString, "web", null, null, null, "web", null, null, null, aobw.cjU, agwv.this.mContext.getString(2131720970), "", paramJSONObject, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        aodb.aN(null, "0X800A21F");
      }
      while (!paramTeamWorkFileImportInfo.azs()) {
        return;
      }
      if (!agwv.c(agwv.this))
      {
        long l = aodb.aO(paramTeamWorkFileImportInfo.traceId + "-" + paramTeamWorkFileImportInfo.dNQ);
        if (l > 0L) {
          anot.a(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        paramJSONObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localTencentDocData.docUrl = paramString;
        aobw.a(paramJSONObject, agwv.this.mContext, localTencentDocData, paramTeamWorkFileImportInfo);
        return;
      }
      aobh.bA(paramTeamWorkFileImportInfo.aTw, agwv.this.jdField_a_of_type_Aguk.getCurrentAccountUin());
    }
    
    private void c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      boolean bool;
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.azt()))
      {
        if (paramTeamWorkFileImportInfo.dNU != 2) {
          break label194;
        }
        bool = true;
        if (!bool) {
          break label200;
        }
        aodb.aN(null, "0X800ABA7");
        label34:
        if ((!bool) && (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a != null)) {
          agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.q(1, paramString, bool);
        }
        if ((agwv.d(agwv.this)) && (bool)) {
          agwv.e(agwv.this, true);
        }
        if (!bool) {
          if (((paramTeamWorkFileImportInfo.peerType != 1) && (paramTeamWorkFileImportInfo.peerType != 0) && (paramTeamWorkFileImportInfo.peerType != 3000)) || (paramTeamWorkFileImportInfo.peerUin == agwv.this.jdField_a_of_type_Aguk.getCurrentAccountUin())) {
            break label210;
          }
        }
      }
      label194:
      label200:
      label210:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramString = new ArrayList(1);
          paramString.add(paramTeamWorkFileImportInfo.peerUin);
          agwv.this.a(paramString, paramTeamWorkFileImportInfo.cjI, true, paramTeamWorkFileImportInfo.peerType);
        }
        paramTeamWorkFileImportInfo.cjI = null;
        paramTeamWorkFileImportInfo.dNU = 0;
        return;
        bool = false;
        break;
        aodb.aN(null, "0X800ABA8");
        break label34;
      }
    }
    
    public void JI(boolean paramBoolean)
    {
      super.JI(paramBoolean);
      if (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
        agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.JI(paramBoolean);
      }
    }
    
    public void OI(int paramInt)
    {
      super.OI(paramInt);
      if (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
        agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.OQ(paramInt);
      }
    }
    
    public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      super.a(paramTeamWorkFileImportInfo);
      if (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
        agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkx();
      }
      QQAppInterface localQQAppInterface;
      if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.azr()) || ((paramTeamWorkFileImportInfo.azs()) && (paramTeamWorkFileImportInfo.dNR == 0))))
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramTeamWorkFileImportInfo.azs()) {
          anot.a(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
        }
        if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.cjF)) {
          break label137;
        }
        QQToast.a(localQQAppInterface.getApp(), 1, paramTeamWorkFileImportInfo.cjF, 0).show();
      }
      for (;;)
      {
        if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.azt())) {
          aodb.aN(null, "0X800ABAD");
        }
        return;
        label137:
        QQToast.a(localQQAppInterface.getApp(), 1, 2131721071, 0).show();
      }
    }
    
    public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      super.a(paramString, paramTeamWorkFileImportInfo);
      c(paramString, paramTeamWorkFileImportInfo);
      if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.azr()) || ((paramTeamWorkFileImportInfo.azs()) && (paramTeamWorkFileImportInfo.dNR == 0)))) {
        b(paramString, paramTeamWorkFileImportInfo);
      }
      while (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null) {
        return;
      }
      agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.dkx();
    }
    
    public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      super.a(paramString1, paramString2, paramTeamWorkFileImportInfo);
      QQAppInterface localQQAppInterface;
      if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.azs()))
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        aeud localaeud = aeue.a();
        ThreadManager.getFileThreadHandler().post(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.3(this, localaeud, paramTeamWorkFileImportInfo, paramString2, localQQAppInterface, paramString1));
      }
      if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.azt()))
      {
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (paramTeamWorkFileImportInfo.dNU != 2) {
          break label125;
        }
      }
      label125:
      for (boolean bool = true;; bool = false)
      {
        paramTeamWorkFileImportInfo.dNU = 0;
        ThreadManager.getFileThreadHandler().post(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.4(this, bool, paramString2, localQQAppInterface, paramTeamWorkFileImportInfo, paramString1));
        return;
      }
    }
    
    public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      super.b(paramTeamWorkFileImportInfo);
      if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.azr()) || ((paramTeamWorkFileImportInfo.azs()) && (paramTeamWorkFileImportInfo.dNR == 0))) && (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null))
      {
        String str = agwv.this.mContext.getString(2131700604);
        if (paramTeamWorkFileImportInfo.azs()) {
          str = acfp.m(2131714597);
        }
        agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.Jx(str);
        aodb.aN(null, "0X800A21E");
      }
    }
    
    public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
    {
      super.c(paramTeamWorkFileImportInfo);
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.azs())) {
        if (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null)
        {
          agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(paramTeamWorkFileImportInfo);
          agwv.a(agwv.this, true, paramTeamWorkFileImportInfo.peerType);
        }
      }
      while ((paramTeamWorkFileImportInfo == null) || (!paramTeamWorkFileImportInfo.azt()) || (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null)) {
        return;
      }
      if (agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a == null)
      {
        aodb.aN(null, "0X800ABA4");
        agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(paramTeamWorkFileImportInfo);
        return;
      }
      agwv.this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.dmw();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agwv
 * JD-Core Version:    0.7.0.1
 */