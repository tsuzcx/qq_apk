import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.gdtad.api.motivevideo.GdtMvAppBtnData;
import com.tencent.gdtad.api.motivevideo.GdtMvAppBtnView;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnManager;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.1;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.2;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.3;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.4;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.5;
import com.tencent.gdtad.api.motivevideo.GdtMvDownloadBtnPresenter.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class tjb
{
  private GdtMvAppBtnView jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView;
  private GdtMvDownloadBtnManager jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager;
  private GdtMvAppBtnView b;
  private String btnTitle;
  private boolean firstClick = true;
  public boolean resumeDownload;
  
  public tjb(String paramString, GdtMvAppBtnView paramGdtMvAppBtnView1, GdtMvAppBtnView paramGdtMvAppBtnView2, GdtMvDownloadBtnManager paramGdtMvDownloadBtnManager)
  {
    tkw.d("GdtMvDownloadBtnPresenter", "GdtMvDownloadBtnPresenter: ");
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView = paramGdtMvAppBtnView1;
    this.b = paramGdtMvAppBtnView2;
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager = paramGdtMvDownloadBtnManager;
    this.btnTitle = paramString;
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if ((paramDownloadInfo == null) || (paramGdtMvAppBtnData == null) || (TextUtils.isEmpty(paramDownloadInfo.packageName)) || (TextUtils.isEmpty(paramDownloadInfo.appId)) || (TextUtils.isEmpty(paramGdtMvAppBtnData.packageName)) || (TextUtils.isEmpty(paramGdtMvAppBtnData.mGdtAd_appId))) {}
    while ((!paramDownloadInfo.packageName.equals(paramGdtMvAppBtnData.packageName)) || (!paramDownloadInfo.appId.equals(paramGdtMvAppBtnData.mGdtAd_appId))) {
      return false;
    }
    return true;
  }
  
  private void c(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a(paramGdtMvAppBtnData, 0);
    }
  }
  
  private void d(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) && (paramGdtMvAppBtnData.cState == 4)) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a(paramGdtMvAppBtnData, paramGdtMvAppBtnData.cProgerss);
    }
  }
  
  private void e(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    String str1 = paramGdtMvAppBtnData.packageName;
    String str2 = paramGdtMvAppBtnData.mGdtAd_appId;
    String str3 = paramGdtMvAppBtnData.apkUrlhttp;
    paramGdtMvAppBtnData = paramGdtMvAppBtnData.name;
    Bundle localBundle = new Bundle();
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 5);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, str1);
    localBundle.putString(aryv.PARAM_SNG_APPID, str2);
    localBundle.putString(aryv.PARAM_URL, str3);
    localBundle.putString(aryv.PARAM_APPNAME, paramGdtMvAppBtnData);
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvDownloadBtnPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramGdtMvAppBtnData + ", url:" + str3);
    }
    arvz.G(localBundle);
  }
  
  private void f(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.1(this, paramGdtMvAppBtnData));
    }
    while ((paramGdtMvAppBtnData == null) || (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || ((paramGdtMvAppBtnData.cState != 3) && (paramGdtMvAppBtnData.cState != 4))) {
      return;
    }
    tkw.i("GdtMvDownloadBtnPresenter", "pauseDownloadUi " + paramGdtMvAppBtnData.packageName);
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(acfp.m(2131706895));
    this.b.setDownloadingUI(acfp.m(2131706892));
    paramGdtMvAppBtnData.cState = 4;
    paramGdtMvAppBtnData.cProgerss = ((int)this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.getProgress());
    arvv.a().fx(paramGdtMvAppBtnData.apkUrlhttp);
  }
  
  private void i(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    j(paramGdtMvAppBtnData);
  }
  
  private void k(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.6(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.resetUI();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(acfp.m(2131706896));
    this.b.resetUI();
    this.b.setText(acfp.m(2131706884));
    paramGdtMvAppBtnData.cState = 2;
  }
  
  private void launchApp(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("big_brother_source_key", "biz_src_ads");
    AdAppUtil.launch(paramContext, paramString, localBundle);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      paramGdtMvAppBtnData.cState = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      f(paramGdtMvAppBtnData);
    }
  }
  
  public void a(String paramString1, String paramString2, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    if (a(localDownloadInfo, paramGdtMvAppBtnData)) {
      h(paramGdtMvAppBtnData);
    }
  }
  
  public void b(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager == null)
    {
      tkw.e("GdtMvDownloadBtnPresenter", "updatUIByClick mGdtAppDownloadManager == null");
      return;
    }
    if (paramGdtMvAppBtnData == null)
    {
      tkw.e("GdtMvDownloadBtnPresenter", "updatUIByClick cGdtMvAppBtnData == null");
      if (this.resumeDownload)
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(acfp.m(2131706893));
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(0);
        this.b.setDownloadingUI(acfp.m(2131706881));
        this.b.setProgress(0);
        if (this.resumeDownload) {
          break label136;
        }
      }
      for (;;)
      {
        this.resumeDownload = bool;
        return;
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI("0%");
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(0);
        this.b.setDownloadingUI("0%");
        this.b.setProgress(0);
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.fetchAppData();
        break;
        label136:
        bool = false;
      }
    }
    if (this.firstClick) {
      this.firstClick = false;
    }
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvDownloadBtnManager.a(paramGdtMvAppBtnData, 0);
      return;
    case 1: 
      launchApp(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.getContext(), paramGdtMvAppBtnData.packageName);
      return;
    case 3: 
      this.resumeDownload = false;
      f(paramGdtMvAppBtnData);
      return;
    case 4: 
      this.resumeDownload = true;
      d(paramGdtMvAppBtnData);
      return;
    case 5: 
      e(paramGdtMvAppBtnData);
      return;
    }
    c(paramGdtMvAppBtnData);
  }
  
  public void b(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData) {}
  
  public void b(String paramString1, String paramString2, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    if (a(localDownloadInfo, paramGdtMvAppBtnData)) {
      i(paramGdtMvAppBtnData);
    }
  }
  
  public void c(GdtMvAppBtnData paramGdtMvAppBtnData, int paramInt)
  {
    tkw.i("GdtMvDownloadBtnPresenter", "updateBtnProgressUI " + paramInt);
    if (Looper.myLooper() != Looper.getMainLooper()) {}
    do
    {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.2(this, paramGdtMvAppBtnData, paramInt));
      do
      {
        return;
      } while ((paramGdtMvAppBtnData == null) || (paramGdtMvAppBtnData.cState != 3));
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null) && (paramInt >= 0))
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(paramInt + "%");
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(paramInt);
      }
    } while ((this.b == null) || (paramInt < 0));
    tkw.i("GdtMvDownloadBtnPresenter", "updateBtnProgressUI " + paramInt);
    this.b.setDownloadingUI(paramInt + "%");
    this.b.setProgress(paramInt);
  }
  
  public void c(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      j(paramGdtMvAppBtnData);
    }
  }
  
  public void c(String paramString1, String paramString2, GdtMvAppBtnData paramGdtMvAppBtnData) {}
  
  public void d(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtMvAppBtnData)) {
      g(paramGdtMvAppBtnData);
    }
  }
  
  public void e(DownloadInfo paramDownloadInfo, GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    tkw.d("GdtMvDownloadBtnPresenter", "onDownloadUpdate: ");
    paramGdtMvAppBtnData.cState = 3;
    c(paramGdtMvAppBtnData, paramDownloadInfo.progress);
  }
  
  public void g(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.3(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.resetUI();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(acfp.m(2131706883));
    this.b.resetUI();
    this.b.setText(acfp.m(2131706894));
    paramGdtMvAppBtnData.cState = 5;
  }
  
  public void h(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.4(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.resetUI();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(acfp.m(2131706882));
    this.b.resetUI();
    this.b.setText(acfp.m(2131706890));
    paramGdtMvAppBtnData.cState = 1;
  }
  
  public void j(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtMvDownloadBtnPresenter.5(this, paramGdtMvAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView == null) || (paramGdtMvAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.resetUI();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(this.btnTitle);
    this.b.resetUI();
    this.b.setText(this.btnTitle);
    paramGdtMvAppBtnData.cState = 0;
  }
  
  public void l(GdtMvAppBtnData paramGdtMvAppBtnData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMvDownloadBtnPresenter", 2, "onCGdtMvAppBtnDataChanged() called with: gdtMvAppBtnData = [" + paramGdtMvAppBtnData + "]");
    }
    switch (paramGdtMvAppBtnData.cState)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
          {
            this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.resetUI();
            this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(acfp.m(2131706886));
          }
        } while (this.b == null);
        this.b.resetUI();
        this.b.setText(acfp.m(2131706885));
        return;
        c(paramGdtMvAppBtnData, paramGdtMvAppBtnData.cProgerss);
        return;
        if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null)
        {
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setProgress(paramGdtMvAppBtnData.cProgerss);
          this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setDownloadingUI(acfp.m(2131706887));
        }
      } while (this.b == null);
      this.b.setProgress(paramGdtMvAppBtnData.cProgerss);
      this.b.setDownloadingUI(acfp.m(2131706891));
      return;
      if ((paramGdtMvAppBtnData.cProgerss == 100) && (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView != null))
      {
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.resetUI();
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvAppBtnView.setText(acfp.m(2131706888));
      }
    } while ((paramGdtMvAppBtnData.cProgerss != 100) || (this.b == null));
    this.b.resetUI();
    this.b.setText(acfp.m(2131706889));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tjb
 * JD-Core Version:    0.7.0.1
 */