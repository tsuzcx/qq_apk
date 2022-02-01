import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.utils.QQCustomArkDialogForAio.3;
import com.tencent.qphone.base.util.QLog;

public class aqjq
  extends aqju
{
  private wyw.b a = new aqjr(this);
  ArkAppLoadLayout b;
  ArkAppView c;
  wyw d;
  int dZC = 0;
  int dZD = 0;
  int dZE = 0;
  int dZF = 0;
  int dZG = -1;
  private ArkViewImplement.LoadCallback mLoadCallback = new aqjs(this);
  int mWidth = 0;
  int minWidth = 0;
  
  public aqjq(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void Xx(int paramInt)
  {
    if (paramInt != 1)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.addRule(14);
      localLayoutParams.width = this.mWidth;
      localLayoutParams.height = this.mWidth;
      localLayoutParams.setMargins(0, 0, 0, 0);
      this.rBtn.setEnabled(false);
      this.rBtn.setTextColor(Color.parseColor("#656565"));
      return;
    }
    this.rBtn.setEnabled(true);
  }
  
  private wyw a(aqjq.a parama)
  {
    this.d = new wyv();
    int i = this.c.getWidth();
    int j = this.c.getHeight();
    if (QLog.isDebugVersion()) {
      QLog.d("QQCustomArkDialog", 4, "w=" + i + ",h=" + j + ", appName:" + parama.appName);
    }
    this.d.a(parama.appName, parama.appView, parama.appMinVersion, parama.metaData, parama.scale, parama.d);
    if ((this.dZE != 0) && (this.dZF != 0)) {
      this.d.setFixSize(this.dZE, this.dZF);
    }
    for (;;)
    {
      adnq.b.bPX = false;
      return this.d;
      this.d.setFixSize(this.mWidth, this.dZG);
      this.d.setMaxSize(this.mWidth, this.dZC);
      this.d.setMinSize(this.minWidth, this.dZD);
    }
  }
  
  private void init(Bundle paramBundle)
  {
    paramBundle = a(new aqjq.a(paramBundle));
    paramBundle.a(this.a);
    if (QLog.isColorLevel()) {
      QLog.w("QQCustomArkDialog", 2, "init");
    }
    this.c.a(paramBundle, this.b);
  }
  
  public void dismiss()
  {
    if (this.d != null) {
      this.d.doOnEvent(2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomArkDialog", 2, "dismiss");
    }
    adnq.b.bPX = true;
    super.dismiss();
  }
  
  public void j(Context paramContext, Bundle paramBundle)
  {
    try
    {
      getWindow().setFlags(16777216, 16777216);
      if (QLog.isColorLevel()) {
        QLog.i("QQCustomArkDialog", 2, "initArkView:" + paramBundle);
      }
      setContentView(2131559151);
      View localView = LayoutInflater.from(paramContext).inflate(2131558896, null);
      localView.setPadding(0, 0, 0, 0);
      this.c = ((ArkAppView)localView.findViewById(2131362952));
      this.b = ((ArkAppLoadLayout)localView.findViewById(2131370776));
      localView.findViewById(2131362975).setPadding(0, 0, 0, 0);
      ((LinearLayout)localView.findViewById(2131362959)).setVisibility(8);
      this.c.setBorderType(0);
      this.c.setLoadCallback(this.mLoadCallback);
      boolean bool1 = paramBundle.getBoolean("is_ark_display_share", false);
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomArkDialog", 2, "from Forward:" + bool1);
      }
      Object localObject1 = new ArkAppMessage.Config();
      Object localObject2 = paramBundle.getString("forward_ark_app_config");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((ArkAppMessage.Config)localObject1).fromString((String)localObject2);
      }
      if ("card".equals(((ArkAppMessage.Config)localObject1).type)) {
        this.dZG = BaseChatItemLayout.bNS;
      }
      boolean bool2 = MessageForArkApp.isSetSizeByConfig((ArkAppMessage.Config)localObject1);
      if (bool2)
      {
        localObject2 = MessageForArkApp.limitToSizeRange(adqr.getDensity(), ((ArkAppMessage.Config)localObject1).width.intValue(), ((ArkAppMessage.Config)localObject1).height.intValue());
        if (localObject2 != null)
        {
          this.dZE = ((MessageForArkApp.Size)localObject2).width;
          if ((((ArkAppMessage.Config)localObject1).autoSize != null) && (((ArkAppMessage.Config)localObject1).autoSize.intValue() == 1)) {
            this.dZE = BaseChatItemLayout.bNS;
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
      if (this.bodyLayout != null) {
        localObject1 = (RelativeLayout.LayoutParams)this.bodyLayout.getLayoutParams();
      }
      this.rootView.setPadding(0, 0, 0, 0);
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
        i = 0;
        localObject1 = new LinearLayout.LayoutParams(-1, -2);
        j = MessageForArkApp.dp2px(1.0F);
        ((LinearLayout.LayoutParams)localObject1).setMargins(j, j, j, j);
        localObject2 = new GradientDrawable();
        ((GradientDrawable)localObject2).setStroke(j, 436207616);
        if (this.bodyLayout != null)
        {
          if (!bool2) {
            this.bodyLayout.setBackgroundDrawable((Drawable)localObject2);
          }
          addCenterView(localView, (LinearLayout.LayoutParams)localObject1);
        }
        this.dZC = MessageForArkApp.dp2px(390.0F);
        this.minWidth = MessageForArkApp.dp2px(30.0F);
        this.dZD = MessageForArkApp.dp2px(30.0F);
        this.mWidth = (MessageForArkApp.dp2px(296.0F) - i - j * 2);
        localObject1 = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).addRule(14);
        ((RelativeLayout.LayoutParams)localObject1).width = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).height = this.mWidth;
        ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
        this.c.post(new QQCustomArkDialogForAio.3(this, paramBundle));
        this.c.setInputHolderAnchor((ViewGroup)this.c.getRootView());
        if (!(paramContext instanceof Activity)) {
          break label901;
        }
        paramContext = (Activity)paramContext;
        if (paramContext != null) {
          adrr.a(paramContext, this.c);
        }
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
            j = localException.rightMargin + i;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("QQCustomArkDialog", 2, "margin=" + j);
              i = j;
              continue;
              label901:
              paramContext = null;
            }
          }
          else
          {
            i = 0;
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
  
  public static class a
  {
    public String appMinVersion;
    public String appName;
    public String appView;
    public SessionInfo d;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqjq
 * JD-Core Version:    0.7.0.1
 */