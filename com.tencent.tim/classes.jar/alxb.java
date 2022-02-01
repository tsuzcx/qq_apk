import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView.a;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;

public class alxb
  implements DialogInterface.OnDismissListener, ProviderView.a
{
  public static final int[] mQ = { 0, 25, 43, 60, 78, 95 };
  aash a;
  public CaptureVideoFilterViewPager a;
  public EffectsCameraCaptureView a;
  public AppInterface mApp;
  public View mRootView;
  
  void Pr(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mRootView.getContext() != null)) {}
    try
    {
      Intent localIntent = new Intent(this.mRootView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.mRootView.getContext().startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("EffectsListenerController", 1, "start QQBrowserActivity catch an Exception.", paramString);
    }
  }
  
  public void TJ(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) && (paramInt >= 0) && (paramInt <= 5))
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putInt("sv_beauty_level", paramInt).commit();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setBeauty(mQ[paramInt]);
      if (QLog.isColorLevel()) {
        QLog.d("sv_beauty_level", 2, "beauty level : " + mQ[paramInt]);
      }
      alwx.TA(paramInt);
    }
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, String paramString)
  {
    EffectsCameraCaptureView localEffectsCameraCaptureView;
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null)
    {
      alwd.a();
      if (anjo.lC(alwd.dyy))
      {
        localEffectsCameraCaptureView = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView;
        if (paramPtvTemplateInfo.funcType != PtvTemplateManager.PtvTemplateInfo.FUNC_REDBAG_GET) {
          break label53;
        }
      }
    }
    label53:
    for (boolean bool = true;; bool = false)
    {
      localEffectsCameraCaptureView.OA(bool);
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect(paramString);
      return;
    }
  }
  
  void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt, boolean paramBoolean)
  {
    if ((this.mRootView != null) && (this.jdField_a_of_type_Aash == null))
    {
      aash localaash = new aash(this.mRootView.getContext());
      this.jdField_a_of_type_Aash = localaash;
      localaash.x(paramString1, paramString2, paramString3, paramString7);
      localaash.a(new alxc(this, paramInt, paramBoolean, paramString4, paramString5, paramString6));
      localaash.initView();
      this.jdField_a_of_type_Aash.setOnDismissListener(this);
      this.jdField_a_of_type_Aash.show();
      paramString1 = this.jdField_a_of_type_Aash.getWindow().getAttributes();
      paramString1.width = -1;
      paramString1.height = -1;
      this.jdField_a_of_type_Aash.getWindow().setAttributes(paramString1);
    }
  }
  
  void aR(String paramString1, String paramString2, String paramString3)
  {
    if (oB(paramString1))
    {
      hf(paramString1, paramString2);
      return;
    }
    Pr(paramString3);
  }
  
  public void b(FilterCategoryItem paramFilterCategoryItem)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager.setCurrentItem(paramFilterCategoryItem);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFilter(paramFilterCategoryItem);
    }
  }
  
  public void c(FilterCategoryItem paramFilterCategoryItem)
  {
    if (paramFilterCategoryItem == null) {
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800859F", "0X800859F", 2, 0, "", "", paramFilterCategoryItem.id, "");
    if (paramFilterCategoryItem.popup)
    {
      boolean bool = oB(paramFilterCategoryItem.androidopenurlheader);
      if (bool) {}
      for (String str = "1";; str = "0")
      {
        anot.a(null, "dc00898", "", "", "0X80085A0", "0X80085A0", 2, 0, str, "", "", "");
        if (!bool) {
          break;
        }
        a(paramFilterCategoryItem.popupimgurl, paramFilterCategoryItem.popupcontent, paramFilterCategoryItem.popupbtn, paramFilterCategoryItem.androidopenurlheader, paramFilterCategoryItem.openurl, paramFilterCategoryItem.storeurl, paramFilterCategoryItem.buttonbgcolor, 2, bool);
        return;
      }
      a(paramFilterCategoryItem.popupimgurl, paramFilterCategoryItem.popupcontent2, paramFilterCategoryItem.popupbtn2, paramFilterCategoryItem.androidopenurlheader, paramFilterCategoryItem.openurl, paramFilterCategoryItem.storeurl, paramFilterCategoryItem.buttonbgcolor, 2, bool);
      return;
    }
    aR(paramFilterCategoryItem.androidopenurlheader, paramFilterCategoryItem.openurl, paramFilterCategoryItem.storeurl);
  }
  
  public void d(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo)
  {
    if (paramPtvTemplateInfo == null) {
      return;
    }
    anot.a(null, "dc00898", "", "", "0X800859F", "0X800859F", 1, 0, "", "", paramPtvTemplateInfo.id, "");
    if (paramPtvTemplateInfo.popup)
    {
      boolean bool = oB(paramPtvTemplateInfo.androidopenurlheader);
      if (bool) {}
      for (String str = "1";; str = "0")
      {
        anot.a(null, "dc00898", "", "", "0X80085A0", "0X80085A0", 1, 0, str, "", "", "");
        if (!bool) {
          break;
        }
        a(paramPtvTemplateInfo.popupimgurl, paramPtvTemplateInfo.popupcontent, paramPtvTemplateInfo.popupbtn, paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl, paramPtvTemplateInfo.buttonbgcolor, 1, bool);
        return;
      }
      a(paramPtvTemplateInfo.popupimgurl, paramPtvTemplateInfo.popupcontent2, paramPtvTemplateInfo.popupbtn2, paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl, paramPtvTemplateInfo.buttonbgcolor, 1, bool);
      return;
    }
    aR(paramPtvTemplateInfo.androidopenurlheader, paramPtvTemplateInfo.openurl, paramPtvTemplateInfo.storeurl);
  }
  
  public void dC(int paramInt, String paramString)
  {
    SubtitleLayout localSubtitleLayout = (SubtitleLayout)this.mRootView.findViewById(2131379004);
    if (localSubtitleLayout != null)
    {
      aauj.a().aYL = aatg.fN(paramInt);
      if (paramInt == 0)
      {
        localSubtitleLayout.setAnimType(0, null, null, 0, 0);
        localSubtitleLayout.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    localSubtitleLayout.setVisibility(0);
    localSubtitleLayout.setAnimType(paramInt, paramString, null, 0, 0);
  }
  
  void hf(String paramString1, String paramString2)
  {
    try
    {
      if (!aqmr.isEmpty(paramString2)) {}
      for (paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString2)); paramString1 != null; paramString1 = this.mRootView.getContext().getPackageManager().getLaunchIntentForPackage(paramString1))
      {
        paramString1.addCategory("android.intent.category.DEFAULT");
        this.mRootView.getContext().startActivity(paramString1);
        return;
      }
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("EffectsListenerController", 1, "TryJumpToQIM catch an Exception.", paramString1);
      new arie(this.mApp.getApp()).p(acfp.m(2131705764), 100, 0, 1);
    }
  }
  
  public boolean oB(String paramString)
  {
    QLog.d("EffectsListenerController", 1, "start CheckJumpAPPisInstall appPackageName is " + paramString);
    if (aqmr.isEmpty(paramString)) {}
    do
    {
      return false;
      try
      {
        paramString = this.mRootView.getContext().getPackageManager().getPackageInfo(paramString, 1);
        if (paramString == null)
        {
          QLog.d("EffectsListenerController", 1, "CheckJumpAPPisInstall PackageInfo is null");
          return false;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("EffectsListenerController", 1, "CheckJumpAPPisInstall catch an Exception.", paramString);
        return false;
      }
      paramString = paramString.activities[0].name;
      QLog.d("EffectsListenerController", 1, "start CheckJumpAPPisInstall qqAppActivity is " + paramString);
    } while (paramString == null);
    return true;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Aash = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxb
 * JD-Core Version:    0.7.0.1
 */