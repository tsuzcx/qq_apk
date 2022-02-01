package com.tencent.qqmail.utilities.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.QMApplicationContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

public abstract class QMPopupWindow
{
  protected static final long N_TOUCH_INTERVAL = 500L;
  public Context context;
  protected ListAdapter mAdapter;
  protected View mAnchor;
  protected long mLastShowTime;
  protected PopupWindow mWindow;
  FrameLayout mask;
  
  public QMPopupWindow(Context paramContext, View paramView, ListAdapter paramListAdapter)
  {
    this(paramContext, false);
    setAdapter(paramListAdapter);
    setAnchor(paramView);
  }
  
  public QMPopupWindow(Context paramContext, boolean paramBoolean)
  {
    View localView = initContentView(paramContext);
    this.context = paramContext;
    this.mask = new FrameLayout(this.context);
    this.mask.setBackgroundColor(paramContext.getResources().getColor(2131166031));
    this.mask.setAnimation(AnimationUtils.loadAnimation(this.context, 2130772023));
    this.mWindow = new PopupWindow(localView, QMApplicationContext.sharedInstance().getResources().getDimensionPixelSize(2131297654), -2, true);
    this.mWindow.setBackgroundDrawable(new ColorDrawable());
    this.mWindow.setOutsideTouchable(true);
    this.mWindow.setFocusable(true);
    if (paramBoolean) {
      localView.setOnKeyListener(new QMPopupWindow.1(this));
    }
    this.mWindow.setOnDismissListener(new QMPopupWindow.2(this));
  }
  
  private static PopupMenuItem getShareMenuItemInfo(TypedArray paramTypedArray, Context paramContext)
  {
    if (paramTypedArray == null) {
      throw new IllegalArgumentException();
    }
    PopupMenuItem localPopupMenuItem = new PopupMenuItem();
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      if (k == R.styleable.QMShareMenuItemView_title_id) {
        localPopupMenuItem.setTitle(paramContext.getString(paramTypedArray.getResourceId(k, 0)));
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == R.styleable.QMShareMenuItemView_icon_id) {
          localPopupMenuItem.setIconResId(paramTypedArray.getResourceId(k, 0));
        } else if (k == R.styleable.QMShareMenuItemView_app_id) {
          localPopupMenuItem.setAppId(paramTypedArray.getString(k));
        } else if (k == R.styleable.QMShareMenuItemView_button_id) {
          localPopupMenuItem.setButtonId(paramTypedArray.getResourceId(k, -1));
        } else if (k == R.styleable.QMShareMenuItemView_visiable) {
          localPopupMenuItem.setVisiable(paramTypedArray.getBoolean(k, true));
        }
      }
    }
    return localPopupMenuItem;
  }
  
  public static List<PopupMenuItem> praseShareMenuItem(int paramInt, Context paramContext)
  {
    Object localObject2 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    Object localObject3 = localObject1;
    Object localObject4 = localObject5;
    for (;;)
    {
      try
      {
        localXmlResourceParser = paramContext.getResources().getXml(paramInt);
        localObject3 = localObject1;
        localObject4 = localObject5;
        localAttributeSet = Xml.asAttributeSet(localXmlResourceParser);
        localObject3 = localObject1;
        localObject4 = localObject5;
        paramInt = localXmlResourceParser.getEventType();
        localObject1 = localObject2;
      }
      catch (IOException paramContext)
      {
        XmlResourceParser localXmlResourceParser;
        AttributeSet localAttributeSet;
        return localObject3;
        if (paramInt == 1) {
          continue;
        }
        localObject2 = localObject1;
        switch (paramInt)
        {
        }
        localObject2 = localObject1;
        continue;
      }
      catch (XmlPullParserException paramContext) {}
      localObject3 = localObject2;
      localObject4 = localObject2;
      paramInt = localXmlResourceParser.next();
      localObject1 = localObject2;
      continue;
      localObject3 = localObject1;
      localObject4 = localObject1;
      localObject5 = localXmlResourceParser.getName();
      localObject3 = localObject1;
      localObject4 = localObject1;
      if ("sharemenu".equals(localObject5))
      {
        localObject3 = localObject1;
        localObject4 = localObject1;
        localObject2 = new ArrayList();
      }
      else
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject4 = localObject1;
        if ("sharemenu_item".equals(localObject5))
        {
          localObject3 = localObject1;
          localObject4 = localObject1;
          localObject2 = paramContext.obtainStyledAttributes(localAttributeSet, R.styleable.QMShareMenuItemView);
          localObject3 = localObject1;
          localObject4 = localObject1;
          localObject5 = getShareMenuItemInfo((TypedArray)localObject2, paramContext);
          if (localObject5 != null)
          {
            localObject3 = localObject1;
            localObject4 = localObject1;
            localObject1.add(localObject5);
          }
          localObject3 = localObject1;
          localObject4 = localObject1;
          ((TypedArray)localObject2).recycle();
          localObject2 = localObject1;
          continue;
          localObject3 = localObject1;
          localObject4 = localObject1;
          localXmlResourceParser.close();
          return localObject1;
        }
      }
    }
    return localObject4;
  }
  
  private void resetWindowAnimation()
  {
    PopupWindow localPopupWindow = this.mWindow;
    if (this.mWindow.isAboveAnchor()) {}
    for (int i = 2131755054;; i = 2131755053)
    {
      localPopupWindow.setAnimationStyle(i);
      this.mWindow.update();
      return;
    }
  }
  
  public void deMask()
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this.context, 2130772025);
    localAnimation.setAnimationListener(new QMPopupWindow.3(this));
    this.mask.startAnimation(localAnimation);
  }
  
  public void dismiss()
  {
    this.mWindow.dismiss();
    release();
  }
  
  public void doMask()
  {
    if (!(this.context instanceof Activity)) {}
    for (;;)
    {
      return;
      ViewGroup localViewGroup = (ViewGroup)((Activity)this.context).getWindow().getDecorView();
      try
      {
        if ((localViewGroup.getTag(-1) == null) || (!localViewGroup.getTag(-1).equals("isMask")))
        {
          localViewGroup.setTag(-1, "isMask");
          localViewGroup.addView(this.mask);
          this.mask.startAnimation(AnimationUtils.loadAnimation(this.context, 2130772023));
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  protected abstract View initContentView(Context paramContext);
  
  public boolean isShowing()
  {
    return this.mWindow.isShowing();
  }
  
  public void release() {}
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.mAdapter = paramListAdapter;
  }
  
  public void setAnchor(View paramView)
  {
    this.mAnchor = paramView;
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.mWindow.setOnDismissListener(new QMPopupWindow.4(this, paramOnDismissListener));
  }
  
  public void show()
  {
    this.mWindow.showAsDropDown(this.mAnchor);
    this.mLastShowTime = System.currentTimeMillis();
    resetWindowAnimation();
    doMask();
  }
  
  public void showDown()
  {
    this.mWindow.showAsDropDown(this.mAnchor, 0, -QMUIKit.dpToPx(4) - 2);
    this.mLastShowTime = System.currentTimeMillis();
    resetWindowAnimation();
    doMask();
  }
  
  public static class PopupMenuItem
  {
    private String appId;
    private int buttonId;
    private int iconResId;
    private String title;
    private boolean visiable = true;
    
    public String getAppId()
    {
      return this.appId;
    }
    
    public int getButtonId()
    {
      return this.buttonId;
    }
    
    public int getIconResId()
    {
      return this.iconResId;
    }
    
    public String getTitle()
    {
      return this.title;
    }
    
    public boolean isVisiable()
    {
      return this.visiable;
    }
    
    public void setAppId(String paramString)
    {
      this.appId = paramString;
    }
    
    public void setButtonId(int paramInt)
    {
      this.buttonId = paramInt;
    }
    
    public void setIconResId(int paramInt)
    {
      this.iconResId = paramInt;
    }
    
    public void setTitle(String paramString)
    {
      this.title = paramString;
    }
    
    public void setVisiable(boolean paramBoolean)
    {
      this.visiable = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMPopupWindow
 * JD-Core Version:    0.7.0.1
 */