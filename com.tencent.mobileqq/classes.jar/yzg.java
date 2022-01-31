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

public class yzg
{
  private GdtCanvasAppBtnView jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView;
  private String jdField_a_of_type_JavaLangString;
  private yzi jdField_a_of_type_Yzi;
  public boolean a;
  private boolean b = true;
  
  public yzg(String paramString, GdtCanvasAppBtnView paramGdtCanvasAppBtnView, yzi paramyzi)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView = paramGdtCanvasAppBtnView;
    this.jdField_a_of_type_Yzi = paramyzi;
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
      this.jdField_a_of_type_Yzi.a(paramGdtAppBtnData, 0);
    }
  }
  
  private void e(GdtAppBtnData paramGdtAppBtnData)
  {
    if ((this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView != null) && (paramGdtAppBtnData.cState == 4)) {
      this.jdField_a_of_type_Yzi.a(paramGdtAppBtnData, paramGdtAppBtnData.cProgerss);
    }
  }
  
  private void f(GdtAppBtnData paramGdtAppBtnData)
  {
    String str1 = paramGdtAppBtnData.packageName;
    String str2 = paramGdtAppBtnData.mGdtAd_appId;
    String str3 = paramGdtAppBtnData.apkUrlhttp;
    paramGdtAppBtnData = paramGdtAppBtnData.name;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bdlb.k, 5);
    localBundle.putString(bdlb.f, str1);
    localBundle.putString(bdlb.b, str2);
    localBundle.putString(bdlb.j, str3);
    localBundle.putString(bdlb.l, paramGdtAppBtnData);
    if (QLog.isColorLevel()) {
      QLog.d("GdtAppBtnUIPresenter", 2, "installAppDownload:" + str1 + ", appid:" + str2 + ", name:" + paramGdtAppBtnData + ", url:" + str3);
    }
    bdho.a(localBundle);
  }
  
  private void g(GdtAppBtnData paramGdtAppBtnData)
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      ThreadManager.getUIHandler().post(new GdtAppBtnUIPresenter.1(this, paramGdtAppBtnData));
    }
    while ((paramGdtAppBtnData == null) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView == null) || ((paramGdtAppBtnData.cState != 3) && (paramGdtAppBtnData.cState != 4))) {
      return;
    }
    yxp.b("GdtAppBtnUIPresenter", "pauseDownloadUi " + paramGdtAppBtnData.packageName);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajya.a(2131705173));
    paramGdtAppBtnData.cState = 4;
    paramGdtAppBtnData.cProgerss = ((int)this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.a());
    bdhk.a().a(paramGdtAppBtnData.apkUrlhttp);
    this.jdField_a_of_type_Yzi.g();
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
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(ajya.a(2131705170));
    paramGdtAppBtnData.cState = 2;
  }
  
  public void a(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_Yzi != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Yzi.jdField_a_of_type_JavaLangString))) {
      localBundle.putString("big_brother_ref_source_key", this.jdField_a_of_type_Yzi.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(ajya.a(2131705169));
    paramGdtAppBtnData.cState = 5;
  }
  
  public void a(GdtAppBtnData paramGdtAppBtnData, int paramInt)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_Yzi == null)
    {
      yxp.d("GdtAppBtnUIPresenter", "updatUIByClick mGdtAppDownloadManager == null");
      return;
    }
    if (paramGdtAppBtnData == null)
    {
      yxp.d("GdtAppBtnUIPresenter", "updatUIByClick cgdtAppBtnData == null");
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajya.a(2131705168));
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setProgress(0);
        if (this.jdField_a_of_type_Boolean) {
          break label120;
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = bool;
        return;
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajya.a(2131705171) + 0 + "%");
        this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setProgress(0);
        this.jdField_a_of_type_Yzi.f();
        break;
        label120:
        bool = false;
      }
    }
    if (this.b)
    {
      yzi localyzi = this.jdField_a_of_type_Yzi;
      if ((yzi.a()) && (!this.jdField_a_of_type_Yzi.b))
      {
        this.jdField_a_of_type_Yzi.h();
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
      this.jdField_a_of_type_Yzi.a(paramGdtAppBtnData, 0);
      return;
    case 1: 
      a(this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.getContext(), paramGdtAppBtnData.packageName);
      return;
    case 3: 
      this.jdField_a_of_type_Boolean = false;
      g(paramGdtAppBtnData);
      return;
    case 4: 
      yzi.jdField_a_of_type_Boolean = false;
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
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setText(ajya.a(2131705172));
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
    yxp.b("GdtAppBtnUIPresenter", "updateBtnProgressUI " + paramInt);
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasComponentsAppbuttonGdtCanvasAppBtnView.setDownloadingUI(ajya.a(2131705174) + paramInt + "%");
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
 * Qualified Name:     yzg
 * JD-Core Version:    0.7.0.1
 */