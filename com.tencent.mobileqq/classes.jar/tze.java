import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.2;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog.3;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.util.SoftKeyboardStateHelper;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class tze
  extends ReportDialog
  implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener
{
  private static final String jdField_a_of_type_JavaLangString = tze.class.getName();
  private long jdField_a_of_type_Long;
  private abup jdField_a_of_type_Abup;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bhkb jdField_a_of_type_Bhkb;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqMiniUtilSoftKeyboardStateHelper;
  private WebViewProgressBar jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private tzk jdField_a_of_type_Tzk;
  private long jdField_b_of_type_Long;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private String jdField_b_of_type_JavaLangString;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  
  public tze(Activity paramActivity)
  {
    super(paramActivity, 2131755826);
    b();
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public tze(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    this(paramActivity);
    if (paramString1 != null)
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.d = paramString3;
    }
    this.jdField_b_of_type_Long = SystemClock.currentThreadTimeMillis();
  }
  
  public static tze a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    return new tze(paramActivity, paramString1, paramString2, paramString3);
  }
  
  private void a()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_c_of_type_JavaLangString + "&acttype=9000&rsptype=1";
        l = SystemClock.currentThreadTimeMillis();
        localObject3 = "";
        Object localObject4 = new Bundle();
        localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), (String)localObject1, "GET", null, (Bundle)localObject4);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "loadForm result = ", localObject1 });
        }
        localObject1 = new JSONObject((String)localObject1);
        i = ((JSONObject)localObject1).getInt("ret");
        if (i != 0) {
          continue;
        }
        localObject4 = ((JSONObject)localObject1).getJSONObject("data");
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          localObject3 = ((JSONObject)localObject4).optString("clickid");
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "loadForm clickid = " + (String)localObject3);
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        long l;
        Object localObject3;
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadForm exception:" + localException.getMessage());
        return;
        Object localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { Integer.valueOf(2), "requestAdData bytes null" });
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = this.d;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadForm: get click id costTime=" + (SystemClock.currentThreadTimeMillis() - l));
      }
      localObject1 = this.jdField_b_of_type_JavaLangString + "&click_id=" + (String)localObject3;
      ThreadManager.getUIHandler().post(new ReadInJoyAdPopSheetDialog.3(this, (String)localObject1));
      return;
      localObject1 = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "retCode = " + i);
        localObject1 = localObject3;
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, new RelativeLayout.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_Abup = new tzj(this, paramActivity.getApplicationContext(), paramActivity, null, localAppInterface);
    this.jdField_a_of_type_Abup.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new bgtj(this.jdField_a_of_type_Abup).a(null, localAppInterface, null);
  }
  
  private void b()
  {
    View localView = getLayoutInflater().inflate(2131560054, null);
    ((RelativeLayout)localView.findViewById(2131372844)).setOnClickListener(new tzg(this));
    localView.setOnClickListener(new tzh(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)localView.findViewById(2131373019));
    this.jdField_a_of_type_Bhkb = new bhkb();
    this.jdField_a_of_type_Bhkb.a(this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_a_of_type_Bhkb);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131372847));
    this.jdField_a_of_type_ComTencentMobileqqMiniUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(localView);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131372845));
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqMiniUtilSoftKeyboardStateHelper.addSoftKeyboardStateListener(new tzi(this, (RelativeLayout.LayoutParams)localObject));
    setOnDismissListener(this);
    setOnShowListener(this);
    localObject = BaseApplicationImpl.getContext();
    int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    int j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
    int k = (int)(i * 0.85D);
    int m = (int)(k * 0.72D);
    localObject = (RelativeLayout)localView.findViewById(2131372845);
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = k;
      ((ViewGroup.LayoutParams)localObject).height = k;
    }
    setContentView(localView);
    getWindow().setLayout(i, j);
  }
  
  public void a(tzk paramtzk)
  {
    this.jdField_a_of_type_Tzk = paramtzk;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDismiss h5Url = " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Abup != null)
    {
      this.jdField_a_of_type_Abup.c();
      this.jdField_a_of_type_Abup = null;
    }
    if (this.jdField_a_of_type_Tzk != null) {
      this.jdField_a_of_type_Tzk.a();
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onShow h5Url = " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(0);
    }
    if (this.jdField_a_of_type_Bhkb != null) {
      this.jdField_a_of_type_Bhkb.a((byte)0);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
    ThreadManager.excute(new ReadInJoyAdPopSheetDialog.2(this), 128, null, true);
  }
  
  public void show()
  {
    getWindow().setFlags(8, 8);
    super.show();
    getWindow().getDecorView().setSystemUiVisibility(2);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new tzf(this));
    getWindow().clearFlags(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tze
 * JD-Core Version:    0.7.0.1
 */