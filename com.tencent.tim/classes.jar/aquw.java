import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.plugin.PluginBaseActivity;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class aquw
  extends ReportDialog
  implements View.OnClickListener
{
  private ImageView Fl;
  private ImageView Fm;
  private aqux.b a;
  private String aRK;
  private TextView abF;
  private String cxU;
  private int edc = 2;
  private Button hv;
  private Button hw;
  private Activity mActivity;
  private int mSceneId;
  private SharedPreferences mSharedPreferences;
  private CustomWebView mWebView;
  
  public aquw(Activity paramActivity, aqux.b paramb, int paramInt1, String paramString, int paramInt2)
  {
    super(paramActivity, 2131756467);
    this.mActivity = paramActivity;
    this.a = paramb;
    this.cxU = paramString;
    this.mSceneId = paramInt1;
    this.edc = paramInt2;
    initView();
  }
  
  public aquw(Activity paramActivity, CustomWebView paramCustomWebView, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    super(paramActivity, 2131756467);
    this.mActivity = paramActivity;
    this.mWebView = paramCustomWebView;
    this.aRK = paramString1;
    this.cxU = paramString2;
    this.mSceneId = paramInt1;
    this.edc = paramInt2;
    initView();
  }
  
  private void efN()
  {
    if (this.a != null) {
      this.a.callback(3);
    }
    if (this.mWebView != null) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", 3);
      this.mWebView.callJs(this.aRK, new String[] { localJSONObject.toString() });
      if (this.edc == 2)
      {
        VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-3", this.cxU, 1, 0, 0, "", "", "");
        return;
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException);
        }
      } while (this.edc != 3);
      VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-3", this.cxU, 1, 0, 0, "", "", "");
    }
  }
  
  private void initView()
  {
    setContentView(2131559118);
    this.Fl = ((ImageView)findViewById(2131363280));
    this.abF = ((TextView)findViewById(2131371310));
    this.hv = ((Button)findViewById(2131365546));
    this.hw = ((Button)findViewById(2131365400));
    this.Fm = ((ImageView)findViewById(2131364221));
    this.mSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("CUKingCardFile_" + BaseApplicationImpl.getApplication().getRuntime().getAccount(), 4);
    Object localObject1 = this.mSharedPreferences.getString("guidePopupImgUrl_v2", "");
    if (QLog.isColorLevel()) {
      QLog.i("CUKingCardDialog", 2, "SP_KEY_GUIDE_POPUP_IMG_URL: " + (String)localObject1);
    }
    Object localObject2 = new ColorDrawable(this.mActivity.getResources().getColor(2131167646));
    Object localObject3;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject3 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = ((Drawable)localObject2);
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
      this.Fl.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      localObject1 = this.mSharedPreferences.getString("guidePopupText_v2", "");
      localObject2 = this.mSharedPreferences.getString("guideJumpText_v2", "");
      localObject3 = this.mSharedPreferences.getString("guideContinueText_v2", "");
      if (QLog.isColorLevel()) {
        QLog.i("CUKingCardDialog", 2, String.format("popUpType: %d, mSceneId: %d, popUpStr: %s, guideBtnStr: %s, continueBtnStr: %s", new Object[] { Integer.valueOf(this.edc), Integer.valueOf(this.mSceneId), localObject1, localObject2, localObject3 }));
      }
      this.abF.setText((CharSequence)localObject1);
      this.hv.setText((CharSequence)localObject2);
      this.hv.setOnClickListener(this);
      this.hw.setText((CharSequence)localObject3);
      this.hw.setOnClickListener(this);
      this.Fm.setOnClickListener(this);
      return;
      this.Fl.setImageDrawable((Drawable)localObject2);
    }
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    efN();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = aqux.pT(this.cxU);
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        if ((this.mActivity instanceof PluginBaseActivity))
        {
          localObject2 = (PluginBaseActivity)this.mActivity;
          Intent localIntent = new Intent(((PluginBaseActivity)localObject2).getOutActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", (String)localObject1);
          localIntent.setFlags(268435456);
          ((PluginBaseActivity)localObject2).getOutActivity().startActivity(localIntent);
          label125:
          if (this.edc != 2) {
            break label285;
          }
          VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-1", this.cxU, 1, 0, 0, "", "", "");
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (this.a != null) {
            this.a.callback(4);
          }
          dismiss();
          if (this.mWebView == null) {
            break;
          }
          try
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("result", 4);
            this.mWebView.callJs(this.aRK, new String[] { ((JSONObject)localObject1).toString() });
          }
          catch (Exception localException1)
          {
            QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException1);
          }
        }
        break;
        localObject2 = new Intent(this.mActivity, QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("url", localException1);
        this.mActivity.startActivity((Intent)localObject2);
        break label125;
        QLog.e("CUKingCardDialog", 1, "onClick cuGuideBtn url = null");
        break label125;
        label285:
        if (this.edc == 3) {
          VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-1", this.cxU, 1, 0, 0, "", "", "");
        }
      }
      if (this.a != null) {
        this.a.callback(1);
      }
      dismiss();
      if (this.mWebView != null) {}
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("result", 1);
        this.mWebView.callJs(this.aRK, new String[] { localJSONObject.toString() });
        if (this.edc == 2) {
          VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P2-2", this.cxU, 1, 0, 0, "", "", "");
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("CUKingCardDialog", 1, "onClick exception e = ", localException2);
        }
      }
      if (this.edc == 3)
      {
        VasWebviewUtil.reportCommercialDrainage("", "wkclub", "P3-2", this.cxU, 1, 0, 0, "", "", "");
        continue;
        dismiss();
        efN();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aquw
 * JD-Core Version:    0.7.0.1
 */