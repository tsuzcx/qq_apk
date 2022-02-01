import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.b;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.3;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.6;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.CookieManager;
import dov.com.tencent.biz.qqstory.takevideo.EditPicActivity;
import org.json.JSONArray;

public class arbo
  extends araz.a
  implements Handler.Callback, AdapterView.OnItemClickListener, oea.a
{
  private nnu a;
  boolean ayo = false;
  int bgd;
  ElasticHorScrView c;
  public WebViewFragment c;
  public boolean cXB = false;
  public boolean cXC = false;
  private final String czf = "https://post.mp.qq.com/tmpl/default/client/article/html/jump.html?action=openUrl&url=";
  public String czg = null;
  public String czh;
  oea d = null;
  public Bitmap gC = null;
  LinearLayout lh = null;
  int mScreenHeight = 0;
  int mScreenWidth = 0;
  public Activity s;
  float sG = 0.0F;
  public Handler uiHandler = new auru(Looper.getMainLooper(), this);
  
  private void initParam()
  {
    this.jdField_a_of_type_Nnu = new nnu(this.s);
    this.jdField_a_of_type_Nnu.setItemClickListener(this);
    Object localObject = this.s.getIntent();
    if (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) {
      localObject = this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getIntent();
    }
    String str = ((Intent)localObject).getStringExtra("url");
    if (str == null)
    {
      str = ((Intent)localObject).getStringExtra("key_params_qq");
      localObject = str;
      if (str != null) {}
    }
    for (localObject = "";; localObject = str)
    {
      this.jdField_a_of_type_Nnu.setUrl((String)localObject);
      return;
    }
  }
  
  public void P(int paramInt, Bundle paramBundle)
  {
    super.P(paramInt, paramBundle);
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          eha();
          if (this.uiHandler != null) {
            this.uiHandler.removeCallbacksAndMessages(null);
          }
        } while (this.jdField_a_of_type_Nnu == null);
        this.jdField_a_of_type_Nnu.onDestroy();
        return;
      } while (!aGe());
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "ScreenshotResume!");
      }
      this.uiHandler.postDelayed(new SwiftBrowserScreenShotHandler.1(this), 1000L);
      return;
      if ((this.jdField_a_of_type_Nnu != null) && (this.jdField_a_of_type_Nnu.a() != null)) {
        this.jdField_a_of_type_Nnu.a().onConfigurationChanged();
      }
      paramInt = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels;
    } while (this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView == null);
    if (paramInt < this.bgd)
    {
      this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
    }
    this.jdField_c_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
  
  public void VY(String paramString)
  {
    if (this.jdField_a_of_type_Nnu != null) {
      this.jdField_a_of_type_Nnu.setUrl(paramString);
    }
  }
  
  public void VZ(String paramString)
  {
    if ((this.d == null) && (this.s != null))
    {
      Object localObject = new DisplayMetrics();
      this.s.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
      this.sG = ((DisplayMetrics)localObject).density;
      this.d = new oea(this.s, this.mScreenWidth, this.mScreenHeight);
      this.d.a(this);
      localObject = getRootView();
      if (localObject != null)
      {
        ((View)localObject).setDrawingCacheEnabled(true);
        ((View)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new arbp(this, (View)localObject));
      }
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "registerScreenshotObserver->mScreenWidth:" + this.mScreenWidth + ", mScreenHeight:" + this.mScreenHeight + ", mScreenDensity:" + this.sG);
      }
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Nnu != null)) {
      this.jdField_a_of_type_Nnu.ol(paramString.replace("|", "｜"));
    }
    while ((this.jdField_a_of_type_Nnu == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_Nnu.kI())) || (this.s == null)) {
      return;
    }
    this.jdField_a_of_type_Nnu.ol(BaseApplicationImpl.getContext().getResources().getString(2131697452));
  }
  
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->fromType:" + paramInt);
    }
    if ((!(this.s instanceof BaseActivity)) || (!((BaseActivity)this.s).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->activity is not resume!");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->begin time:" + System.currentTimeMillis());
    }
    paramString = "";
    if (this.jdField_a_of_type_Nnu != null) {
      paramUri = this.jdField_a_of_type_Nnu.getUrl();
    }
    int i;
    for (;;)
    {
      paramUri = Uri.parse(paramUri);
      try
      {
        paramUri = paramUri.getQueryParameter("article_id");
        paramString = paramUri;
        if (paramUri == null) {
          paramString = "";
        }
        anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A69", "0X8006A69", 0, 0, "", paramString, "", "");
        kbp.d("0X8006A69", "", "", paramString, "", "");
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->after report time:" + System.currentTimeMillis());
        }
        paramUri = getRootView();
        if (paramUri == null)
        {
          QLog.e("SwiftBrowserScreenShotHandler", 1, "onDetectScreenshot error, root = null");
          return;
          paramUri = "";
        }
      }
      catch (Exception paramUri)
      {
        for (;;)
        {
          paramUri.printStackTrace();
          paramUri = paramString;
        }
        paramUri.buildDrawingCache();
        paramString = paramUri.getDrawingCache();
        if (QLog.isDevelopLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->get screenshot time:" + System.currentTimeMillis());
        }
        i = BaseApplicationImpl.getContext().getResources().getConfiguration().orientation;
        if (paramString == null) {
          break label483;
        }
      }
    }
    if ((this.gC != null) && (!this.gC.isRecycled()) && ((this.lh == null) || (this.lh.getVisibility() == 8))) {
      this.gC = null;
    }
    this.gC = nnt.a(this.s.getWindow(), paramString);
    if (this.gC != null)
    {
      if (this.jdField_a_of_type_Nnu != null) {
        this.jdField_a_of_type_Nnu.tO(paramInt);
      }
      if (paramInt != 1) {
        break label488;
      }
      this.cXB = true;
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.arg1 = i;
      this.uiHandler.sendMessage(localMessage);
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->send msg_show_pad time:" + System.currentTimeMillis());
      }
    }
    for (;;)
    {
      ThreadManager.executeOnFileThread(new SwiftBrowserScreenShotHandler.3(this, paramInt));
      paramString.recycle();
      label483:
      paramUri.destroyDrawingCache();
      return;
      label488:
      if (paramInt == 2) {
        QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697454, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
      }
    }
  }
  
  public boolean aGe()
  {
    return this.d != null;
  }
  
  void bK(boolean paramBoolean, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin isShow:" + paramBoolean + ", orientation:" + paramInt);
    }
    if (paramBoolean) {
      if (!this.ayo) {}
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((this.lh != null) && ((this.lh.getTag() instanceof Integer)))
          {
            int i = ((Integer)this.lh.getTag()).intValue();
            if (i != paramInt)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->orientation change old:" + i + ", new:" + paramInt);
              }
              localObject = (RelativeLayout)this.s.findViewById(2131363728);
              if ((this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd != null) && (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd.mRootView != null)) {
                this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd.mRootView.findViewById(2131363728);
              }
              this.lh.setVisibility(8);
              ((RelativeLayout)localObject).removeView(this.lh);
              this.lh = null;
            }
          }
          if (this.lh == null)
          {
            if (QLog.isDevelopLevel()) {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad create time:" + System.currentTimeMillis());
            }
            this.lh = ((LinearLayout)LayoutInflater.from(BaseApplicationImpl.getContext()).inflate(2131559835, null));
            localObject = (RelativeLayout)this.s.findViewById(2131363728);
            if ((this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd != null) && (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd.mRootView != null)) {
              this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd.mRootView.findViewById(2131363728);
            }
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
            localLayoutParams.addRule(11);
            localLayoutParams.addRule(12);
            localLayoutParams.setMargins(0, 0, wja.dp2px(10.0F, BaseApplicationImpl.getContext().getResources()), wja.dp2px(65.0F, BaseApplicationImpl.getContext().getResources()));
            ((RelativeLayout)localObject).addView(this.lh, localLayoutParams);
            this.lh.setTag(Integer.valueOf(paramInt));
            if (paramInt == 2)
            {
              localObject = (LinearLayout.LayoutParams)this.lh.findViewById(2131377744).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject).width = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298002);
              ((LinearLayout.LayoutParams)localObject).height = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298003);
            }
            this.lh.findViewById(2131377744).setOnClickListener(new arbq(this));
          }
          if (this.lh.getAnimation() != null)
          {
            this.lh.getAnimation().cancel();
            this.lh.clearAnimation();
          }
          ((ImageView)this.lh.findViewById(2131377744)).setImageBitmap(this.gC);
          this.lh.setVisibility(0);
        } while (!QLog.isDevelopLevel());
        QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad visible time:" + System.currentTimeMillis());
        return;
        if (QLog.isDevelopLevel())
        {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainer:" + this.lh);
          if (this.lh != null) {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->begin hide mScreenshotContainerVisibility:" + this.lh.getVisibility());
          }
        }
      } while ((this.lh == null) || (this.lh.getVisibility() != 0));
      Object localObject = new AlphaAnimation(1.0F, 0.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      ((AlphaAnimation)localObject).setAnimationListener(new arbr(this));
      this.lh.startAnimation((Animation)localObject);
    } while (!QLog.isDevelopLevel());
    QLog.d("SwiftBrowserScreenShotHandler", 2, "showScreenshotPad->pad gone time:" + System.currentTimeMillis());
  }
  
  public void jdMethod_do(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "doMultiShare->imgUrl:" + paramString + ", isGif:" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Bundle localBundle = new Bundle();
    Object localObject = CookieManager.getInstance();
    ((CookieManager)localObject).setAcceptCookie(true);
    localObject = ((CookieManager)localObject).getCookie(paramString);
    if (localObject != null) {
      localBundle.putString("Cookie", (String)localObject);
    }
    this.jdField_a_of_type_Nnu.a().show();
    this.czh = paramString;
    ThreadManager.executeOnSubThread(new SwiftBrowserScreenShotHandler.6(this, paramString, localBundle, paramBoolean));
  }
  
  public void egS()
  {
    super.egS();
    this.s = this.jdField_a_of_type_Araz$b.getActivity();
    this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = this.jdField_a_of_type_Araz$b.b();
    initParam();
  }
  
  public void eha()
  {
    if (this.d != null)
    {
      this.d.onDestroy();
      if (this.s != null)
      {
        View localView = getRootView();
        if (localView != null) {
          localView.setDrawingCacheEnabled(false);
        }
      }
      this.d = null;
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "unregisterScreenshotObserver!");
      }
    }
  }
  
  View getRootView()
  {
    Object localObject = (arcd)this.jdField_a_of_type_Araz$b.c().q(2);
    if ((((arcd)localObject).a.isFullScreen) || (((arcd)localObject).a.cYl)) {}
    for (int i = 2131363728;; i = 2131379881)
    {
      View localView = this.s.findViewById(i);
      localObject = localView;
      if (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        localObject = localView;
        if (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd != null)
        {
          localObject = localView;
          if (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_Arcd.mRootView != null) {
            localObject = this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
          }
        }
      }
      return localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_show_pad time:" + System.currentTimeMillis());
      }
      this.uiHandler.removeMessages(2);
      bK(true, paramMessage.arg1);
      this.uiHandler.sendEmptyMessageDelayed(2, 3000L);
    }
    for (;;)
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "handleMessage->recv msg_hide_pad time:" + System.currentTimeMillis());
      }
      bK(false, 0);
      continue;
      pn(this.czg);
    }
  }
  
  public String kH()
  {
    return this.jdField_a_of_type_Nnu.kH();
  }
  
  public void m(String paramString1, String paramString2, int paramInt)
  {
    if (this.jdField_a_of_type_Nnu != null) {
      this.jdField_a_of_type_Nnu.m(paramString1, paramString2, paramInt);
    }
  }
  
  public void ok(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Nnu != null)) {
      this.jdField_a_of_type_Nnu.ok(paramString);
    }
  }
  
  public void ol(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Nnu != null)) {
      this.jdField_a_of_type_Nnu.ol(paramString.replace("|", "｜"));
    }
  }
  
  public void on(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_Nnu != null)) {
      this.jdField_a_of_type_Nnu.on(paramString);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->begin!");
    }
    Object localObject1 = paramView.getTag();
    if (localObject1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->tag null!");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i = ((ShareActionSheetBuilder.b)localObject1).b.action;
      if (this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null)
      {
        str = this.jdField_c_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebView().getUrl();
        localObject1 = "";
        localObject2 = Uri.parse(str);
      }
      try
      {
        localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", localException, "", "");
          kbp.d("0X8006A1F", "", "1001", localException, "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action friend!");
            continue;
            anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", localException, "", "");
            kbp.d("0X8006A1F", "", "1002", localException, "", "");
            if (QLog.isColorLevel())
            {
              QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action qzone!");
              continue;
              anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", localException, "", "");
              kbp.d("0X8006A1F", "", "1003", localException, "", "");
              if (QLog.isColorLevel())
              {
                QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat!");
                continue;
                anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1004", localException, "", "");
                kbp.d("0X8006A1F", "", "1004", localException, "", "");
                if (QLog.isColorLevel())
                {
                  QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action wechat circle!");
                  continue;
                  kbp.a(null, "", "0X800787A", "0X800787A", 0, 0, localException, str, "", "");
                  anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1005", localException, "", "");
                  kbp.d("0X8006A1F", "", "1005", localException, "", "");
                  if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->do action sina weibo!");
                  }
                }
              }
            }
          }
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      switch (i)
      {
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 11: 
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserScreenShotHandler", 2, "onScreenShotItemClick->end!");
        }
        break;
      }
    }
  }
  
  public void pn(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      rwt.ez(1, 2131697457);
      return;
    }
    paramString = EditPicActivity.a(this.s, paramString, true, true, true, true, true, 4);
    paramString.putExtra("EditPicType", this.jdField_a_of_type_Nnu.qN());
    this.s.startActivity(paramString);
  }
  
  public void y(JSONArray paramJSONArray)
  {
    if (this.jdField_a_of_type_Nnu != null) {
      this.jdField_a_of_type_Nnu.h(paramJSONArray);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbo
 * JD-Core Version:    0.7.0.1
 */