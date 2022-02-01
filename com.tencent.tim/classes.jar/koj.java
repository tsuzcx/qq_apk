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
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdPopSheetDialog.2;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyAdPopSheetDialog.3;
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

public class koj
  extends ReportDialog
  implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener
{
  private static final String LOG_TAG = koj.class.getName();
  private RelativeLayout X;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private SoftKeyboardStateHelper jdField_a_of_type_ComTencentMobileqqMiniUtilSoftKeyboardStateHelper;
  private koj.a jdField_a_of_type_Koj$a;
  private tmt jdField_a_of_type_Tmt;
  private arju jdField_b_of_type_Arju;
  private WebViewProgressBar jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBar;
  private RelativeLayout cI;
  private Activity mActivity;
  private String mAdRl;
  private String mAdTraceId;
  private String mUrl;
  private long sB;
  private long sC;
  private long time = -1L;
  
  public koj(Activity paramActivity)
  {
    super(paramActivity, 2131756467);
    initView();
    this.mActivity = paramActivity;
  }
  
  public koj(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    this(paramActivity);
    if (paramString1 != null)
    {
      this.mUrl = paramString1;
      this.mAdRl = paramString2;
      this.mAdTraceId = paramString3;
    }
    this.sC = SystemClock.currentThreadTimeMillis();
  }
  
  public static koj a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    return new koj(paramActivity, paramString1, paramString2, paramString3);
  }
  
  private void aF(Activity paramActivity)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(paramActivity);
    this.cI.removeAllViews();
    this.cI.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView, new RelativeLayout.LayoutParams(-1, -1));
    this.cI.setVisibility(0);
    this.jdField_a_of_type_Tmt = new koo(this, paramActivity.getApplicationContext(), paramActivity, null, localAppInterface);
    this.jdField_a_of_type_Tmt.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new aqyx(this.jdField_a_of_type_Tmt).a(null, localAppInterface, null);
  }
  
  private void aFs()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.mAdRl + "&acttype=9000&rsptype=1";
        l = SystemClock.currentThreadTimeMillis();
        localObject3 = "";
        Object localObject4 = new Bundle();
        localObject1 = jqc.a(BaseApplicationImpl.getContext(), (String)localObject1, "GET", null, (Bundle)localObject4);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = new String((byte[])localObject1);
        if (QLog.isColorLevel()) {
          QLog.d(LOG_TAG, 1, new Object[] { "loadForm result = ", localObject1 });
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
            QLog.d(LOG_TAG, 2, "loadForm clickid = " + (String)localObject3);
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
        QLog.d(LOG_TAG, 2, "loadForm exception:" + localException.getMessage());
        return;
        Object localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(LOG_TAG, 1, new Object[] { Integer.valueOf(2), "requestAdData bytes null" });
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = this.mAdTraceId;
      }
      if (QLog.isColorLevel()) {
        QLog.d(LOG_TAG, 2, "loadForm: get click id costTime=" + (SystemClock.currentThreadTimeMillis() - l));
      }
      localObject1 = this.mUrl + "&click_id=" + (String)localObject3;
      ThreadManager.getUIHandler().post(new ReadInJoyAdPopSheetDialog.3(this, (String)localObject1));
      return;
      localObject1 = localObject3;
      if (QLog.isColorLevel())
      {
        QLog.d(LOG_TAG, 2, "retCode = " + i);
        localObject1 = localObject3;
      }
    }
  }
  
  private void initView()
  {
    View localView = getLayoutInflater().inflate(2131560241, null);
    ((RelativeLayout)localView.findViewById(2131373498)).setOnClickListener(new kol(this));
    localView.setOnClickListener(new kom(this));
    this.jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBar = ((WebViewProgressBar)localView.findViewById(2131373669));
    this.jdField_b_of_type_Arju = new arju();
    this.jdField_b_of_type_Arju.a(this.jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBar);
    this.jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setController(this.jdField_b_of_type_Arju);
    this.cI = ((RelativeLayout)localView.findViewById(2131373501));
    this.jdField_a_of_type_ComTencentMobileqqMiniUtilSoftKeyboardStateHelper = new SoftKeyboardStateHelper(localView);
    this.X = ((RelativeLayout)localView.findViewById(2131373499));
    Object localObject = (RelativeLayout.LayoutParams)this.X.getLayoutParams();
    this.time = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqMiniUtilSoftKeyboardStateHelper.addSoftKeyboardStateListener(new kon(this, (RelativeLayout.LayoutParams)localObject));
    setOnDismissListener(this);
    setOnShowListener(this);
    localObject = BaseApplicationImpl.getContext();
    int i = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
    int j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
    int k = (int)(i * 0.85D);
    int m = (int)(k * 0.72D);
    localObject = (RelativeLayout)localView.findViewById(2131373499);
    if (localObject != null)
    {
      localObject = ((RelativeLayout)localObject).getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = k;
      ((ViewGroup.LayoutParams)localObject).height = k;
    }
    setContentView(localView);
    getWindow().setLayout(i, j);
  }
  
  public void a(koj.a parama)
  {
    this.jdField_a_of_type_Koj$a = parama;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LOG_TAG, 2, "onDismiss h5Url = " + this.mUrl);
    }
    if (this.jdField_a_of_type_Tmt != null)
    {
      this.jdField_a_of_type_Tmt.onDestroy();
      this.jdField_a_of_type_Tmt = null;
    }
    if (this.jdField_a_of_type_Koj$a != null) {
      this.jdField_a_of_type_Koj$a.onDismiss();
    }
  }
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(LOG_TAG, 2, "onShow h5Url = " + this.mUrl);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(0);
    }
    if (this.jdField_b_of_type_Arju != null) {
      this.jdField_b_of_type_Arju.enterStatus((byte)0);
    }
    if (this.cI != null) {
      this.cI.setVisibility(4);
    }
    ThreadManager.excute(new ReadInJoyAdPopSheetDialog.2(this), 128, null, true);
  }
  
  public void show()
  {
    getWindow().setFlags(8, 8);
    super.show();
    getWindow().getDecorView().setSystemUiVisibility(2);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new kok(this));
    getWindow().clearFlags(8);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     koj
 * JD-Core Version:    0.7.0.1
 */