package com.tencent.qqmail;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import moai.patch.util.VersionUtil;

public class QuickLaunchActivity
  extends Activity
{
  public static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;
  private static final String KEY_QUICK_LAUNCH_VISIBLE = "quick_launch_visible_";
  private static final String SP_NAME = "quick_launch_info";
  private static final String TAG = "QuickLaunchActivity";
  private int mIndicator = 0;
  private ProgressBar mProgressBar;
  private ProgressRunnable mProgressRunnable = new ProgressRunnable();
  private TextView mTextView;
  private String mUpdateDataDesc = "正在更新数据（%1$s%%）";
  
  private void doAnimate()
  {
    this.mProgressBar.setProgress(this.mIndicator);
    this.mTextView.setText(String.format(this.mUpdateDataDesc, new Object[] { Integer.valueOf(this.mIndicator) }));
    this.mProgressBar.postDelayed(this.mProgressRunnable, 30L);
  }
  
  public static int dpToPx(int paramInt)
  {
    return (int)(paramInt * DENSITY + 0.5F);
  }
  
  public LayerDrawable createProgressDrawable()
  {
    Object localObject = new ShapeDrawable();
    float f = dpToPx(2);
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = f;
    arrayOfFloat[1] = f;
    arrayOfFloat[2] = f;
    arrayOfFloat[3] = f;
    arrayOfFloat[4] = f;
    arrayOfFloat[5] = f;
    arrayOfFloat[6] = f;
    arrayOfFloat[7] = f;
    ((ShapeDrawable)localObject).setShape(new RoundRectShape(arrayOfFloat, null, null));
    ((ShapeDrawable)localObject).getPaint().setColor(-2894377);
    ((ShapeDrawable)localObject).getPaint().setStyle(Paint.Style.FILL);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(new RoundRectShape(arrayOfFloat, null, null));
    localShapeDrawable.getPaint().setColor(-13924912);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localObject = new LayerDrawable(new Drawable[] { localObject, new ClipDrawable(localShapeDrawable, 3, 1) });
    ((LayerDrawable)localObject).setId(0, 16908288);
    ((LayerDrawable)localObject).setId(1, 16908301);
    return localObject;
  }
  
  protected void initUI()
  {
    FrameLayout localFrameLayout = new FrameLayout(this);
    localFrameLayout.setBackgroundColor(-1447447);
    localFrameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    Object localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localFrameLayout.addView(localLinearLayout);
    this.mProgressBar = new ProgressBar(this, null, 16973855);
    this.mProgressBar.setProgressDrawable(createProgressDrawable());
    this.mProgressBar.setProgress(0);
    this.mProgressBar.setMax(100);
    localObject = new LinearLayout.LayoutParams(-1, dpToPx(4));
    ((LinearLayout.LayoutParams)localObject).leftMargin = dpToPx(16);
    ((LinearLayout.LayoutParams)localObject).rightMargin = dpToPx(16);
    this.mProgressBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.addView(this.mProgressBar);
    this.mTextView = new TextView(this);
    this.mTextView.setTextSize(16.0F);
    this.mTextView.setTextColor(-8749954);
    this.mTextView.setGravity(17);
    localObject = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject).topMargin = dpToPx(48);
    ((LinearLayout.LayoutParams)localObject).leftMargin = dpToPx(16);
    ((LinearLayout.LayoutParams)localObject).rightMargin = dpToPx(16);
    this.mTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localLinearLayout.addView(this.mTextView);
    setContentView(localFrameLayout);
    this.mIndicator = 0;
    doAnimate();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("QuickLaunchActivity", "onCreate@" + Integer.toHexString(hashCode()));
    initUI();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Log.i("QuickLaunchActivity", "onDestroy@" + Integer.toHexString(hashCode()));
    Process.killProcess(Process.myPid());
  }
  
  protected void onResume()
  {
    super.onResume();
    Log.i("QuickLaunchActivity", "onResume@" + Integer.toHexString(hashCode()));
    overridePendingTransition(2130772023, 2130772025);
    Object localObject = getIntent();
    if (localObject != null)
    {
      long l = ((Intent)localObject).getLongExtra("begin", 0L);
      localObject = "quick_launch_visible_" + VersionUtil.getVersionCode(this);
      SharedPreferences localSharedPreferences = getSharedPreferences("quick_launch_info", 0);
      if (localSharedPreferences.getLong((String)localObject, -1L) == -1L)
      {
        l = SystemClock.uptimeMillis() - l;
        localSharedPreferences.edit().putLong((String)localObject, l).apply();
        Log.i("QuickLaunchActivity", "quick launch activity visible cost: " + l + "ms");
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Log.i("QuickLaunchActivity", "onStop@" + Integer.toHexString(hashCode()));
    finish();
    overridePendingTransition(2130772023, 2130772025);
  }
  
  class ProgressRunnable
    implements Runnable
  {
    ProgressRunnable() {}
    
    public void run()
    {
      QuickLaunchActivity.access$008(QuickLaunchActivity.this);
      if (QuickLaunchActivity.this.mIndicator <= 99) {
        QuickLaunchActivity.this.doAnimate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.QuickLaunchActivity
 * JD-Core Version:    0.7.0.1
 */