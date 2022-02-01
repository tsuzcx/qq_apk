package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RestrictTo;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipPopup
{
  private static final String TAG = "TooltipPopup";
  private final View mContentView;
  private final Context mContext;
  private final WindowManager.LayoutParams mLayoutParams = new WindowManager.LayoutParams();
  private final TextView mMessageView;
  private final int[] mTmpAnchorPos = new int[2];
  private final int[] mTmpAppPos = new int[2];
  private final Rect mTmpDisplayFrame = new Rect();
  
  TooltipPopup(Context paramContext)
  {
    this.mContext = paramContext;
    this.mContentView = LayoutInflater.from(this.mContext).inflate(2131558427, null);
    this.mMessageView = ((TextView)this.mContentView.findViewById(2131371310));
    this.mLayoutParams.setTitle(getClass().getSimpleName());
    this.mLayoutParams.packageName = this.mContext.getPackageName();
    this.mLayoutParams.type = 1002;
    this.mLayoutParams.width = -2;
    this.mLayoutParams.height = -2;
    this.mLayoutParams.format = -3;
    this.mLayoutParams.windowAnimations = 2131755028;
    this.mLayoutParams.flags = 24;
  }
  
  private void computePosition(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.token = paramView.getApplicationWindowToken();
    int i = this.mContext.getResources().getDimensionPixelOffset(2131299660);
    label74:
    Object localObject1;
    if (paramView.getWidth() >= i)
    {
      if (paramView.getHeight() < i) {
        break label138;
      }
      j = this.mContext.getResources().getDimensionPixelOffset(2131299659);
      i = paramInt2 + j;
      j = paramInt2 - j;
      paramInt2 = i;
      i = j;
      paramLayoutParams.gravity = 49;
      localObject1 = this.mContext.getResources();
      if (!paramBoolean) {
        break label149;
      }
    }
    int k;
    label138:
    label149:
    for (int j = 2131299663;; j = 2131299662)
    {
      k = ((Resources)localObject1).getDimensionPixelOffset(j);
      localObject1 = getAppRootView(paramView);
      if (localObject1 != null) {
        break label156;
      }
      Log.e("TooltipPopup", "Cannot find app view");
      return;
      paramInt1 = paramView.getWidth() / 2;
      break;
      paramInt2 = paramView.getHeight();
      i = 0;
      break label74;
    }
    label156:
    ((View)localObject1).getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
    Object localObject2;
    if ((this.mTmpDisplayFrame.left < 0) && (this.mTmpDisplayFrame.top < 0))
    {
      localObject2 = this.mContext.getResources();
      j = ((Resources)localObject2).getIdentifier("status_bar_height", "dimen", "android");
      if (j == 0) {
        break label391;
      }
    }
    label391:
    for (j = ((Resources)localObject2).getDimensionPixelSize(j);; j = 0)
    {
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      this.mTmpDisplayFrame.set(0, j, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
      ((View)localObject1).getLocationOnScreen(this.mTmpAppPos);
      paramView.getLocationOnScreen(this.mTmpAnchorPos);
      paramView = this.mTmpAnchorPos;
      paramView[0] -= this.mTmpAppPos[0];
      paramView = this.mTmpAnchorPos;
      paramView[1] -= this.mTmpAppPos[1];
      paramLayoutParams.x = (this.mTmpAnchorPos[0] + paramInt1 - ((View)localObject1).getWidth() / 2);
      paramInt1 = View.MeasureSpec.makeMeasureSpec(0, 0);
      this.mContentView.measure(paramInt1, paramInt1);
      paramInt1 = this.mContentView.getMeasuredHeight();
      i = i + this.mTmpAnchorPos[1] - k - paramInt1;
      paramInt2 = paramInt2 + this.mTmpAnchorPos[1] + k;
      if (!paramBoolean) {
        break label404;
      }
      if (i < 0) {
        break;
      }
      paramLayoutParams.y = i;
      return;
    }
    paramLayoutParams.y = paramInt2;
    return;
    label404:
    if (paramInt1 + paramInt2 <= this.mTmpDisplayFrame.height())
    {
      paramLayoutParams.y = paramInt2;
      return;
    }
    paramLayoutParams.y = i;
  }
  
  private static View getAppRootView(View paramView)
  {
    View localView = paramView.getRootView();
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    if (((localLayoutParams instanceof WindowManager.LayoutParams)) && (((WindowManager.LayoutParams)localLayoutParams).type == 2)) {
      return localView;
    }
    for (paramView = paramView.getContext(); (paramView instanceof ContextWrapper); paramView = ((ContextWrapper)paramView).getBaseContext()) {
      if ((paramView instanceof Activity)) {
        return ((Activity)paramView).getWindow().getDecorView();
      }
    }
    return localView;
  }
  
  void hide()
  {
    if (!isShowing()) {
      return;
    }
    ((WindowManager)this.mContext.getSystemService("window")).removeView(this.mContentView);
  }
  
  boolean isShowing()
  {
    return this.mContentView.getParent() != null;
  }
  
  void show(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, CharSequence paramCharSequence)
  {
    if (isShowing()) {
      hide();
    }
    this.mMessageView.setText(paramCharSequence);
    computePosition(paramView, paramInt1, paramInt2, paramBoolean, this.mLayoutParams);
    ((WindowManager)this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.TooltipPopup
 * JD-Core Version:    0.7.0.1
 */