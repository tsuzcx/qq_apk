import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.utils.QQCustomArkDialog.3;
import com.tencent.mobileqq.utils.QQCustomArkDialog.4;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class aqjn
  extends aqkk
{
  private wyw.b a = new aqjo(this);
  ArkAppLoadLayout b;
  ArkAppView c;
  private boolean cUp;
  private boolean cUq;
  private boolean cUr;
  wyw d;
  int dZC = 0;
  int dZD = 0;
  int dZE = 0;
  int dZF = 0;
  int dZG = -1;
  private WeakReference<Activity> mActivityRef;
  private ArkViewImplement.LoadCallback mLoadCallback = new aqjp(this);
  int mWidth = 0;
  int minWidth = 0;
  
  public aqjn(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void Xv(int paramInt)
  {
    Object localObject;
    if (this.mActivityRef != null) {
      localObject = (Activity)this.mActivityRef.get();
    }
    while ((localObject != null) && (!((Activity)localObject).isFinishing())) {
      if (paramInt != 1)
      {
        localObject = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        ((RelativeLayout.LayoutParams)localObject).width = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject).height = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        this.rBtn.setEnabled(false);
        this.rBtn.setTextColor(Color.parseColor("#656565"));
        return;
        localObject = null;
      }
      else
      {
        this.rBtn.setEnabled(true);
        return;
      }
    }
    QLog.d("QQCustomArkDialog", 1, "onLoadFinish.right now activity is null or finished");
  }
  
  private wyw a(aqjn.a parama, Bundle paramBundle)
  {
    this.d = new wyw();
    int i = this.c.getWidth();
    int j = this.c.getHeight();
    if (QLog.isDebugVersion()) {
      QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + parama.appName);
    }
    i = paramBundle.getInt("req_type");
    if (ArkFullScreenAppActivity.t(paramBundle))
    {
      this.d.a(parama.appName, parama.appView, parama.appMinVersion, parama.metaData, parama.scale, parama.d);
      if ((this.dZE == 0) || (this.dZF == 0)) {
        break label230;
      }
      this.d.setFixSize(this.dZE, this.dZF);
    }
    for (;;)
    {
      adnq.b.bPX = false;
      return this.d;
      paramBundle = e(paramBundle, "com.tencent.structmsg");
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, ",metaData=" + paramBundle);
      }
      this.d.a("com.tencent.structmsg", aqgc.gd(i), "0.0.0.1", paramBundle, adqr.getDensity(), parama.d);
      break;
      label230:
      this.d.setFixSize(this.mWidth, this.dZG);
      this.d.setMaxSize(this.mWidth, this.dZC);
      this.d.setMinSize(this.minWidth, this.dZD);
    }
  }
  
  public static String e(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt("req_type");
    long l = paramBundle.getLong("req_share_id");
    Object localObject = paramBundle.getString("title");
    String str3 = paramBundle.getString("desc");
    String str4 = paramBundle.getString("struct_share_key_source_url");
    String str2 = paramBundle.getString("image_url_remote");
    String str6 = paramBundle.getString("image_url");
    paramBundle.getString("res_pkg_name");
    String str1 = paramBundle.getString("audio_url");
    String str5 = paramBundle.getString("app_name");
    paramBundle = "news";
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject2.put("title", localObject);
      if (i != 2) {
        break label326;
      }
      paramBundle = "music";
      localObject = pF(str1);
      localJSONObject2.put("musicUrl", localObject);
      str1 = str3;
      if (!TextUtils.isEmpty(str3))
      {
        str1 = str3;
        if (str3.contains(acfp.m(2131711608))) {
          str1 = str3.replace(acfp.m(2131711612), "");
        }
      }
      localJSONObject2.put("desc", str1);
      if (TextUtils.isEmpty(str2)) {
        break label346;
      }
      paramString = str2;
    }
    catch (Exception paramBundle)
    {
      label326:
      for (;;)
      {
        label214:
        label346:
        if (QLog.isColorLevel())
        {
          QLog.e("QQCustomArkDialog", 2, paramBundle.toString());
          continue;
          paramString = "";
        }
      }
    }
    localJSONObject2.put("preview", paramString);
    localJSONObject2.put("tag", str5);
    if (i == 2)
    {
      paramBundle = "music";
      localJSONObject2.put("musicUrl", localObject);
    }
    for (;;)
    {
      localJSONObject2.put("jumpUrl", pF(str4));
      localJSONObject2.put("appid", l);
      localJSONObject2.put("app_type", 1);
      localJSONObject1.put(paramBundle, localJSONObject2);
      paramString = localJSONObject1.toString();
      paramBundle = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        paramBundle = paramString.replace("\\/", "/");
      }
      return paramBundle;
      localObject = str1;
      if (i != 4) {
        break;
      }
      paramBundle = "video";
      localObject = str1;
      break;
      if (TextUtils.isEmpty(str6)) {
        break label457;
      }
      str1 = getFileName(str6);
      paramString = ArkEnvironmentManager.getInstance().getAppResPath(paramString);
      aqhq.copyFile(str6, paramString + File.separator + str1);
      paramString = "res:" + str1;
      break label214;
      if (i == 4) {
        paramBundle = "video";
      }
    }
  }
  
  public static String getFileName(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf(File.separator);
      str = paramString;
    } while (i == -1);
    return paramString.substring(i + 1);
  }
  
  private void init(Bundle paramBundle)
  {
    aqjn.a locala = new aqjn.a(paramBundle);
    locala.scale = adqr.getDensity();
    paramBundle = a(locala, paramBundle);
    paramBundle.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.c.a(paramBundle, this.b);
  }
  
  public static String pF(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("http://")) {
        str = paramString.replace("http://", "");
      }
      paramString = str;
    } while (!str.contains("https://"));
    return str.replace("https://", "");
  }
  
  public void UN(String paramString)
  {
    this.mt.setVisibility(0);
    this.title.setVisibility(8);
    this.mv.setVisibility(8);
    this.mu.setVisibility(8);
    ((TextView)this.mt.findViewById(2131381161)).setText(paramString);
  }
  
  public void Xw(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    this.d.doOnEvent(paramInt);
  }
  
  public void dismiss()
  {
    if (this.d != null) {
      this.d.doOnEvent(2);
    }
    QLog.d("QQCustomArkDialog", 1, "dismiss");
    adnq.b.bPX = true;
    super.dismiss();
  }
  
  public void eeb()
  {
    ((LinearLayout)findViewById(2131369288)).setVisibility(8);
  }
  
  public void j(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      QLog.i("QQCustomArkDialog", 1, "get init dialog stack", new Exception("InitQQCustomArkDialogStack"));
      Xz(7);
      setContentView(2131559161);
      View localView = LayoutInflater.from(paramContext).inflate(2131558896, null);
      localView.setPadding(0, 0, 0, 0);
      this.c = ((ArkAppView)localView.findViewById(2131362952));
      this.b = ((ArkAppLoadLayout)localView.findViewById(2131370776));
      Object localObject1 = localView.findViewById(2131362975);
      ((RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams()).addRule(14);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      ((LinearLayout)localView.findViewById(2131362959)).setVisibility(8);
      this.c.setBorderType(0);
      this.c.setLoadCallback(this.mLoadCallback);
      boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool1);
      }
      localObject1 = new ArkAppMessage.Config();
      Object localObject2 = paramBundle.getString("forward_ark_app_config");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
      }
      if ((ArkFullScreenAppActivity.t(paramBundle)) && ("card".equals(((ArkAppMessage.Config)localObject1).type))) {
        this.dZG = adqr.cJd;
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(adqr.getDensity(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject2 != null)
        {
          this.dZE = ((MessageForArkApp.Size)localObject2).width;
          if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
            this.dZE = adqr.cJd;
          }
          this.dZF = ((MessageForArkApp.Size)localObject2).height;
          if (QLog.isColorLevel())
          {
            float f = adqr.getDensity();
            i = (int)(((MessageForArkApp.Size)localObject2).width / f);
            j = (int)(((MessageForArkApp.Size)localObject2).height / f);
            QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + ((ArkAppMessage.Config)localObject1).width + ", height_from_sdk:" + ((ArkAppMessage.Config)localObject1).height + ", scale:" + f + ", realwidth:" + i + ", realheight:" + j);
          }
        }
      }
      localObject1 = null;
      if (this.bodyLayout != null)
      {
        localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)paramContext.getResources().getDimension(2131297122));
        ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)paramContext.getResources().getDimension(2131297093));
        ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)paramContext.getResources().getDimension(2131297094));
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramContext.getResources().getDimension(2131297118));
      }
      if (!bool1)
      {
        localObject2 = findViewById(2131363756);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        this.c.setOnTouchListener(this.c);
        localObject2 = findViewById(2131365826);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        localObject2 = findViewById(2131365844);
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(8);
        }
        if (localObject1 != null)
        {
          ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
          this.bodyLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        i = MessageForArkApp.dp2px(1.0F);
        ((LinearLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setStroke(i, 436207616);
        if (this.bodyLayout != null)
        {
          if (!bool2) {
            this.bodyLayout.setBackgroundDrawable(localGradientDrawable);
          }
          addCenterView(localView, (LinearLayout.LayoutParams)localObject2);
        }
        this.dZC = MessageForArkApp.dp2px(390.0F);
        this.minWidth = MessageForArkApp.dp2px(30.0F);
        this.dZD = MessageForArkApp.dp2px(30.0F);
        i = paramContext.getResources().getDimensionPixelSize(2131297117);
        j = ((RelativeLayout.LayoutParams)localObject1).leftMargin;
        j = ((RelativeLayout.LayoutParams)localObject1).rightMargin + j;
        QLog.i("QQCustomArkDialog", 1, "init bundle mWidth=" + this.mWidth + ", dialogWidth=" + i + ",bodyMargin=" + j);
        this.mWidth = (i - j);
        localObject1 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).width = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).height = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        ThreadManager.getUIHandler().post(new QQCustomArkDialog.3(this, paramBundle));
        this.c.setInputHolderAnchor((ViewGroup)this.c.getRootView());
        if (!(paramContext instanceof Activity)) {
          break label1096;
        }
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          adrr.a(paramContext, this.c);
          this.mActivityRef = new WeakReference(paramContext);
        }
        ThreadManager.getUIHandler().postDelayed(new QQCustomArkDialog.4(this), 200L);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        int j;
        if (QLog.isColorLevel())
        {
          QLog.w("QQCustomArkDialog", 2, localException.getMessage());
          continue;
          if (localException != null)
          {
            i = localException.leftMargin;
            j = localException.rightMargin;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomArkDialog", 2, "margin=" + (i + j));
              continue;
              label1096:
              paramContext = null;
            }
          }
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.c != null) && (paramMotionEvent.getAction() == 0) && ((paramMotionEvent.getX() < this.c.getX() - 10.0F) || (paramMotionEvent.getX() > this.c.getX() + this.c.getWidth() + 10.0F) || (paramMotionEvent.getY() < this.c.getY() - 10.0F) || (paramMotionEvent.getY() > this.c.getY() + this.c.getHeight() + 10.0F)))
    {
      this.c.mViewImpl.resetInputState();
      InputMethodManager localInputMethodManager = (InputMethodManager)this.c.getContext().getSystemService("input_method");
      if (localInputMethodManager != null) {
        localInputMethodManager.hideSoftInputFromWindow(this.c.getWindowToken(), 0);
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    super.setOnDismissListener(paramOnDismissListener);
  }
  
  public void show()
  {
    this.cUp = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, new Object[] { "dialog show,arkViewLoadFinish = ", Boolean.valueOf(this.cUq), ";alreadyShowDialog:", Boolean.valueOf(this.cUr) });
    }
    if (this.cUq)
    {
      this.cUr = true;
      super.show();
    }
  }
  
  public static class a
  {
    public String appMinVersion;
    public String appName;
    public String appView;
    public boolean cUs;
    public SessionInfo d;
    public wyw e;
    public String metaData;
    public float scale;
    public String title = "";
    
    public a(Bundle paramBundle)
    {
      this.appName = paramBundle.getString("appName");
      this.appView = paramBundle.getString("appView");
      this.appMinVersion = paramBundle.getString("appMinVersion");
      this.metaData = paramBundle.getString("metaData");
      this.scale = paramBundle.getFloat("scale", 1.0F);
      this.d = new SessionInfo();
      paramBundle = paramBundle.getString("troopUin");
      if (paramBundle != null)
      {
        this.d.cZ = 1;
        this.d.aTl = paramBundle;
      }
    }
    
    public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat, String paramString5, Bundle paramBundle)
    {
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putString("appName", paramString1);
      localBundle.putString("appMinVersion", paramString3);
      localBundle.putString("appView", paramString2);
      localBundle.putString("metaData", paramString4);
      localBundle.putFloat("scale", paramFloat);
      localBundle.putString("troopUin", paramString5);
      return localBundle;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjn
 * JD-Core Version:    0.7.0.1
 */