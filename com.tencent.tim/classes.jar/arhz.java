import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQProgressDialog.1;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class arhz
  extends ReportDialog
{
  private arhz.a b;
  private Animatable frameAnimation;
  private LinearLayout mBackground;
  String mContentDescription;
  private Context mContext;
  private float mDensity;
  private int mGravity = 48;
  private int mHeightParams = -2;
  private ImageView mImageShow;
  private LayoutInflater mInflater;
  private TextView mMsgTextView;
  private int mOffsetY;
  private ImageView mProgressImg;
  private View mRootView;
  
  public arhz(Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public arhz(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 2131561627, 48);
  }
  
  public arhz(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext, 2131756467);
    this.mContext = paramContext;
    this.mInflater = LayoutInflater.from(paramContext);
    this.mDensity = this.mContext.getResources().getDisplayMetrics().density;
    this.mRootView = this.mInflater.inflate(paramInt2, null);
    this.mBackground = ((LinearLayout)this.mRootView.findViewById(2131363555));
    this.mMsgTextView = ((TextView)this.mRootView.findViewById(2131371994));
    this.mOffsetY = paramInt1;
    this.mGravity = paramInt3;
    this.mImageShow = ((ImageView)this.mRootView.findViewById(2131379763));
    this.mProgressImg = ((ImageView)this.mRootView.findViewById(2131379764));
    this.frameAnimation = ((Animatable)this.mProgressImg.getDrawable());
  }
  
  public void a(arhz.a parama)
  {
    this.b = parama;
  }
  
  /* Error */
  public void dismiss()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 129	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 135	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 135	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 135	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	arhz
    //   9	1	1	localException	java.lang.Exception
    //   15	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (TextUtils.isEmpty(this.mContentDescription)) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    if (AppSetting.enableTalkBack) {
      QQAppInterface.EI(this.mContentDescription);
    }
    return true;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.b != null) {
      this.b.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setContentView(this.mRootView);
    WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.mHeightParams;
    localLayoutParams.gravity = this.mGravity;
    localLayoutParams.y += this.mOffsetY;
    paramBundle.setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
  }
  
  protected void onStart()
  {
    this.mProgressImg.postDelayed(new QQProgressDialog.1(this), 50L);
    super.onStart();
  }
  
  public void onStop()
  {
    if (this.frameAnimation.isRunning()) {
      this.frameAnimation.stop();
    }
    super.onStop();
  }
  
  public void setBackAndSearchFilter(boolean paramBoolean)
  {
    setOnKeyListener(new aria(this, paramBoolean));
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    this.mBackground.setBackgroundDrawable(paramDrawable);
  }
  
  public void setGravity(int paramInt)
  {
    this.mGravity = paramInt;
  }
  
  public void setHeightParams(int paramInt)
  {
    this.mHeightParams = paramInt;
  }
  
  public void setMessage(int paramInt)
  {
    this.mMsgTextView.setText(paramInt);
  }
  
  public void setMessage(String paramString)
  {
    this.mMsgTextView.setText(paramString);
  }
  
  public void setOffsetY(int paramInt)
  {
    this.mOffsetY = paramInt;
  }
  
  public void setProgressBackground(@DrawableRes int paramInt)
  {
    this.mProgressImg.setImageResource(paramInt);
  }
  
  public void setTipImageView(int paramInt)
  {
    if (this.mImageShow == null) {
      return;
    }
    this.mImageShow.setVisibility(0);
    this.mImageShow.setImageResource(paramInt);
  }
  
  public void showProgerss(boolean paramBoolean)
  {
    if (this.mProgressImg == null) {
      return;
    }
    if (paramBoolean)
    {
      if (!this.frameAnimation.isRunning()) {
        this.frameAnimation.start();
      }
      this.mProgressImg.setVisibility(0);
      return;
    }
    if (this.frameAnimation.isRunning()) {
      this.frameAnimation.stop();
    }
    this.mProgressImg.setVisibility(8);
  }
  
  public void showTipImageView(boolean paramBoolean)
  {
    if (this.mImageShow == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mImageShow.setVisibility(0);
      return;
    }
    this.mImageShow.setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     arhz
 * JD-Core Version:    0.7.0.1
 */