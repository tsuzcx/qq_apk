import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ad.tangram.util.AdAppUtil;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnData;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnUIPresenter.1;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnUIPresenter.2;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnUIPresenter.3;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnUIPresenter.4;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnUIPresenter.5;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtAppBtnUIPresenter.6;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtCanvasAppBtnView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ypp
{
  private GdtCanvasAppBtnView jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView;
  private String jdField_a_of_type_JavaLangString;
  private ypr jdField_a_of_type_Ypr;
  public boolean a;
  private boolean b = true;
  
  public ypp(String paramString, GdtCanvasAppBtnView paramGdtCanvasAppBtnView, ypr paramypr)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView = paramGdtCanvasAppBtnView;
    this.jdField_a_of_type_Ypr = paramypr;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private boolean a(DownloadInfo paramDownloadInfo, GdtAppBtnData paramGdtAppBtnData)
  {
    if ((paramDownloadInfo == null) || (paramGdtAppBtnData == null) || (TextUtils.isEmpty(paramDownloadInfo.e)) || (TextUtils.isEmpty(paramDownloadInfo.c)) || (TextUtils.isEmpty(paramGdtAppBtnData.packageName)) || (TextUtils.isEmpty(paramGdtAppBtnData.mGdtAd_appId))) {}
    while ((!paramDownloadInfo.e.equals(paramGdtAppBtnData.packageName)) || (!paramDownloadInfo.c.equals(paramGdtAppBtnData.mGdtAd_appId))) {
      return false;
    }
    return true;
  }
  
  private void d(GdtAppBtnData paramGdtAppBtnData)
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView != null) {
      this.jdField_a_of_type_Ypr.a(paramGdtAppBtnData, 0);
    }
  }
  
  private void e(GdtAppBtnData paramGdtAppBtnData)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView != null) && (paramGdtAppBtnData.cState == 4)) {
      this.jdField_a_of_type_Ypr.a(paramGdtAppBtnData, paramGdtAppBtnData.cProgerss);
    }
  }
  
  private void f(GdtAppBtnData paramGdtAppBtnData)
  {
    String str1 = paramGdtAppBtnData.packageName;
    String str2 = paramGdtAppBtnData.mGdtAd_appId;
    String str3 = paramGdtAppBtnData.apkUrlhttp;
    paramGdtAppBtnData = paramGdtAppBtnData.name;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bcgl.k, 5);
    localBundle.putString(bcgl.f, str1);
    localBundle.putString(bcgl.b, str2);
    localBundle.putString(bcgl.j, str3);
    localBundle.putString(bcgl.l, paramGdtAppBtnData);
    if (QLog.isColorLevel()) {
      QLog.d("GdtAppBtnUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramGdtAppBtnData + ", url:" + str3);
    }
    bccy.a(localBundle);
  }
  
  private void g(GdtAppBtnData paramGdtAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.1(this, paramGdtAppBtnData));
    }
    while ((paramGdtAppBtnData == null) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || ((paramGdtAppBtnData.cState != 3) && (paramGdtAppBtnData.cState != 4))) {
      return;
    }
    yny.b("GdtAppBtnUIPresenter", "pauseDownloadUi " + paramGdtAppBtnData.packageName);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajjy.a(2131639377));
    paramGdtAppBtnData.cState = 4;
    paramGdtAppBtnData.cProgerss = ((int)this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.a());
    bccu.a().a(paramGdtAppBtnData.apkUrlhttp);
    this.jdField_a_of_type_Ypr.g();
  }
  
  private void h(GdtAppBtnData paramGdtAppBtnData)
  {
    c(paramGdtAppBtnData);
  }
  
  private void i(GdtAppBtnData paramGdtAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.6(this, paramGdtAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || (paramGdtAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(ajjy.a(2131639374));
    paramGdtAppBtnData.cState = 2;
  }
  
  public void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_Ypr != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ypr.jdField_a_of_type_JavaLangString))) {
      localBundle.putString("big_brother_ref_source_key", this.jdField_a_of_type_Ypr.jdField_a_of_type_JavaLangString);
    }
    localBundle.putString("big_brother_source_key", "biz_src_ads");
    AdAppUtil.launch(paramContext, paramString, localBundle);
  }
  
  public void a(GdtAppBtnData paramGdtAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.3(this, paramGdtAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || (paramGdtAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(ajjy.a(2131639373));
    paramGdtAppBtnData.cState = 5;
  }
  
  public void a(GdtAppBtnData paramGdtAppBtnData, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Ypr == null)
    {
      yny.d("GdtAppBtnUIPresenter", "updatUIByClick mGdtAppDownloadManager == null");
      return;
    }
    if (paramGdtAppBtnData == null)
    {
      yny.d("GdtAppBtnUIPresenter", "updatUIByClick cgdtAppBtnData == null");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajjy.a(2131639372));
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setProgress(0);
        if (this.jdField_a_of_type_Boolean) {
          break label120;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajjy.a(2131639375) + 0 + "%");
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setProgress(0);
        this.jdField_a_of_type_Ypr.f();
        break;
        label120:
        bool = false;
      }
    }
    if (this.b)
    {
      ypr localypr = this.jdField_a_of_type_Ypr;
      if ((ypr.a()) && (!this.jdField_a_of_type_Ypr.b))
      {
        this.jdField_a_of_type_Ypr.h();
        this.b = false;
        return;
      }
    }
    this.b = false;
    switch (paramInt)
    {
    case 2: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Ypr.a(paramGdtAppBtnData, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.getContext(), paramGdtAppBtnData.packageName);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      g(paramGdtAppBtnData);
      return;
    case 4: 
      ypr.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = true;
      e(paramGdtAppBtnData);
      return;
    case 5: 
      f(paramGdtAppBtnData);
      return;
    }
    d(paramGdtAppBtnData);
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2, GdtAppBtnData paramGdtAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtAppBtnData)) {
      paramGdtAppBtnData.cState = 6;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, GdtAppBtnData paramGdtAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtAppBtnData)) {
      g(paramGdtAppBtnData);
    }
  }
  
  public void a(String paramString1, String paramString2, GdtAppBtnData paramGdtAppBtnData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramGdtAppBtnData)) {
      b(paramGdtAppBtnData);
    }
  }
  
  void a(List<DownloadInfo> paramList, GdtAppBtnData paramGdtAppBtnData)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (a(localDownloadInfo, paramGdtAppBtnData))
        {
          paramGdtAppBtnData.cState = 3;
          b(paramGdtAppBtnData, localDownloadInfo.f);
        }
      }
    }
  }
  
  public void b(GdtAppBtnData paramGdtAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.4(this, paramGdtAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || (paramGdtAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(ajjy.a(2131639376));
    paramGdtAppBtnData.cState = 1;
  }
  
  public void b(GdtAppBtnData paramGdtAppBtnData, int paramInt)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.2(this, paramGdtAppBtnData, paramInt));
    }
    while ((paramGdtAppBtnData == null) || (paramGdtAppBtnData.cState != 3) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || (paramInt < 0)) {
      return;
    }
    yny.b("GdtAppBtnUIPresenter", "updateBtnProgressUI " + paramInt);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajjy.a(2131639378) + paramInt + "%");
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setProgress(paramInt);
  }
  
  public void b(DownloadInfo paramDownloadInfo, GdtAppBtnData paramGdtAppBtnData) {}
  
  public void b(String paramString1, String paramString2, GdtAppBtnData paramGdtAppBtnData)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.c = paramString1;
    localDownloadInfo.e = paramString2;
    if (a(localDownloadInfo, paramGdtAppBtnData)) {
      h(paramGdtAppBtnData);
    }
  }
  
  public void c(GdtAppBtnData paramGdtAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.5(this, paramGdtAppBtnData));
    }
    while ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || (paramGdtAppBtnData == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.a();
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(this.jdField_a_of_type_JavaLangString);
    paramGdtAppBtnData.cState = 0;
  }
  
  void c(DownloadInfo paramDownloadInfo, GdtAppBtnData paramGdtAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtAppBtnData)) {
      c(paramGdtAppBtnData);
    }
  }
  
  public void c(String paramString1, String paramString2, GdtAppBtnData paramGdtAppBtnData) {}
  
  void d(DownloadInfo paramDownloadInfo, GdtAppBtnData paramGdtAppBtnData)
  {
    if (a(paramDownloadInfo, paramGdtAppBtnData)) {
      a(paramGdtAppBtnData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ypp
 * JD-Core Version:    0.7.0.1
 */