package cooperation.plugin;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import avgk;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class PluginIphoneTitleBarActivity
  extends PluginBaseActivity
{
  private Drawable ad;
  protected TextView agf;
  public TextView centerView;
  private boolean isRightHighlightButton;
  protected TextView leftView;
  protected float mDensity;
  protected boolean mNotShowLeftText = true;
  private Drawable[] mOldDrawables;
  private int mOldPadding;
  public View mTitleContainer;
  protected View.OnClickListener onBackListeger = new avgk(this);
  public ImageView rightViewImg;
  public TextView rightViewText;
  public RelativeLayout titleRoot;
  protected ViewGroup vg;
  
  @TargetApi(11)
  public static void setLayerType(View paramView)
  {
    if (paramView == null) {}
    while (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    paramView.setLayerType(1, null);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    if (paramBoolean)
    {
      requestWindowFeature(7);
      super.setContentView(paramView);
      getWindow().setFeatureInt(7, 2131559119);
      init(getIntent());
      return;
    }
    requestWindowFeature(1);
    super.setContentView(paramView);
  }
  
  protected void a(CharSequence paramCharSequence, View.OnClickListener paramOnClickListener)
  {
    this.isRightHighlightButton = false;
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(paramCharSequence);
    this.rightViewText.setEnabled(true);
    if (paramOnClickListener != null) {
      this.rightViewText.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void abG(int paramInt)
  {
    super.setContentView(paramInt);
  }
  
  protected void init(Intent paramIntent)
  {
    ((FrameLayout)findViewById(16908290)).setForeground(getResources().getDrawable(2130851111));
    if (this.leftView == null)
    {
      this.vg = ((ViewGroup)findViewById(2131377361));
      setLayerType(this.vg);
      onCreateLeftView();
      onCreateCenterView();
      onCreateRightView();
      setLeftViewName(paramIntent);
    }
  }
  
  public void je(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public void jf(View paramView)
  {
    super.setContentView(paramView);
  }
  
  public boolean onBackEvent()
  {
    finish();
    return false;
  }
  
  protected View onCreateCenterView()
  {
    this.centerView = ((TextView)findViewById(2131369627));
    return this.centerView;
  }
  
  protected View onCreateLeftView()
  {
    this.leftView = ((TextView)findViewById(2131369579));
    if (this.leftView != null)
    {
      this.leftView.setOnClickListener(this.onBackListeger);
      setLayerType(this.leftView);
    }
    return this.leftView;
  }
  
  protected View onCreateRightView()
  {
    this.rightViewText = ((TextView)findViewById(2131369612));
    this.rightViewImg = ((ImageView)findViewById(2131369594));
    this.agf = ((TextView)findViewById(2131380535));
    setLayerType(this.rightViewText);
    setLayerType(this.rightViewImg);
    return this.rightViewText;
  }
  
  public void setContentView(int paramInt)
  {
    int i = 1;
    Object localObject1 = getIntent();
    if (localObject1 != null) {}
    for (boolean bool = ((Intent)localObject1).getBooleanExtra("showTitleBar", true);; bool = true)
    {
      if (!this.mNeedStatusTrans)
      {
        if (bool) {
          requestWindowFeature(7);
        }
        super.setContentView(paramInt);
        if (bool) {
          getWindow().setFeatureInt(7, 2131559119);
        }
      }
      for (;;)
      {
        this.mDensity = getResources().getDisplayMetrics().density;
        if (bool) {
          init(getIntent());
        }
        return;
        if (bool)
        {
          Object localObject2 = LayoutInflater.from(this);
          localObject1 = ((LayoutInflater)localObject2).inflate(2131559121, null);
          try
          {
            localObject2 = ((LayoutInflater)localObject2).inflate(paramInt, (ViewGroup)localObject1, false);
            this.titleRoot = ((RelativeLayout)((View)localObject1).findViewById(2131379881));
            if (ImmersiveUtils.isSupporImmersive() == 1)
            {
              this.titleRoot.setFitsSystemWindows(true);
              this.titleRoot.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
            localObject1 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject1).addRule(3, 2131377361);
            this.titleRoot.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
            this.mContentView = ((View)localObject2);
            super.setContentView(this.titleRoot);
            i = 0;
          }
          catch (InflateException localInflateException)
          {
            for (;;)
            {
              localInflateException.printStackTrace();
            }
          }
          catch (RuntimeException localRuntimeException)
          {
            for (;;)
            {
              localRuntimeException.printStackTrace();
            }
          }
          if (i == 0) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.e("IphoneTitleBarActivity", 2, "layout with merge ,use framelayout to immersive" + getComponentName());
          }
          super.setContentView(paramInt);
          getWindow().setFeatureInt(7, 2131559119);
          if (this.mTitleContainer != null) {
            this.mTitleContainer.setVisibility(0);
          }
          this.mDensity = getResources().getDisplayMetrics().density;
          init(getIntent());
          return;
        }
        super.setContentView(paramInt);
      }
    }
  }
  
  public void setContentView(View paramView)
  {
    a(paramView, true);
  }
  
  public void setContentViewNoTitle(int paramInt)
  {
    this.mDensity = getResources().getDisplayMetrics().density;
    requestWindowFeature(1);
    super.setContentView(paramInt);
    init(getIntent());
  }
  
  protected String setLastActivityName()
  {
    if ((this.centerView == null) || (this.centerView.getText() == null) || (this.centerView.getText().length() == 0)) {
      return getString(2131691039);
    }
    return this.centerView.getText().toString();
  }
  
  protected void setLeftViewName(int paramInt)
  {
    TextView localTextView;
    String str1;
    if ((this.leftView != null) && ((this.leftView instanceof TextView)))
    {
      String str2 = getString(paramInt);
      localTextView = this.leftView;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = getString(2131691039);
      }
      if (this.mNotShowLeftText) {
        localTextView.setText("  ");
      }
    }
    else
    {
      return;
    }
    localTextView.setText(str1);
  }
  
  protected void setLeftViewName(Intent paramIntent)
  {
    TextView localTextView;
    if ((this.leftView != null) && ((this.leftView instanceof TextView)) && (paramIntent != null) && (paramIntent.getExtras() != null))
    {
      localTextView = this.leftView;
      String str = paramIntent.getExtras().getString("leftViewText");
      paramIntent = str;
      if (str == null) {
        paramIntent = getString(2131691039);
      }
      if (this.mNotShowLeftText) {
        localTextView.setText("  ");
      }
    }
    else
    {
      return;
    }
    localTextView.setText(paramIntent);
  }
  
  protected void setRightButton(int paramInt, View.OnClickListener paramOnClickListener)
  {
    a(getString(paramInt), paramOnClickListener);
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if ((this.centerView != null) && ((this.centerView instanceof TextView)))
    {
      this.centerView.setText(paramCharSequence);
      super.setTitle(paramCharSequence);
    }
  }
  
  public boolean startTitleProgress()
  {
    if (this.ad == null)
    {
      this.ad = getResources().getDrawable(2130839657);
      this.mOldDrawables = this.centerView.getCompoundDrawables();
      this.mOldPadding = this.centerView.getCompoundDrawablePadding();
      this.centerView.setCompoundDrawablePadding(10);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.ad, this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      ((Animatable)this.ad).start();
      return true;
    }
    return false;
  }
  
  public boolean stopTitleProgress()
  {
    if (this.ad != null)
    {
      ((Animatable)this.ad).stop();
      this.ad = null;
      this.centerView.setCompoundDrawablePadding(this.mOldPadding);
      this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.mOldDrawables[0], this.mOldDrawables[1], this.mOldDrawables[2], this.mOldDrawables[3]);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.plugin.PluginIphoneTitleBarActivity
 * JD-Core Version:    0.7.0.1
 */