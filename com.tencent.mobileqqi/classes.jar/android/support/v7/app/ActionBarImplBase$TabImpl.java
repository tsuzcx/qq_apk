package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.widget.ScrollingTabContainerView;
import android.view.LayoutInflater;
import android.view.View;

public class ActionBarImplBase$TabImpl
  extends ActionBar.Tab
{
  private ActionBar.TabListener mCallback;
  private CharSequence mContentDesc;
  private View mCustomView;
  private Drawable mIcon;
  private int mPosition = -1;
  private Object mTag;
  private CharSequence mText;
  
  public ActionBarImplBase$TabImpl(ActionBarImplBase paramActionBarImplBase) {}
  
  public ActionBar.TabListener getCallback()
  {
    return this.mCallback;
  }
  
  public CharSequence getContentDescription()
  {
    return this.mContentDesc;
  }
  
  public View getCustomView()
  {
    return this.mCustomView;
  }
  
  public Drawable getIcon()
  {
    return this.mIcon;
  }
  
  public int getPosition()
  {
    return this.mPosition;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public CharSequence getText()
  {
    return this.mText;
  }
  
  public void select()
  {
    this.this$0.selectTab(this);
  }
  
  public ActionBar.Tab setContentDescription(int paramInt)
  {
    return setContentDescription(ActionBarImplBase.access$100(this.this$0).getResources().getText(paramInt));
  }
  
  public ActionBar.Tab setContentDescription(CharSequence paramCharSequence)
  {
    this.mContentDesc = paramCharSequence;
    if (this.mPosition >= 0) {
      ActionBarImplBase.access$000(this.this$0).updateTab(this.mPosition);
    }
    return this;
  }
  
  public ActionBar.Tab setCustomView(int paramInt)
  {
    return setCustomView(LayoutInflater.from(this.this$0.getThemedContext()).inflate(paramInt, null));
  }
  
  public ActionBar.Tab setCustomView(View paramView)
  {
    this.mCustomView = paramView;
    if (this.mPosition >= 0) {
      ActionBarImplBase.access$000(this.this$0).updateTab(this.mPosition);
    }
    return this;
  }
  
  public ActionBar.Tab setIcon(int paramInt)
  {
    return setIcon(ActionBarImplBase.access$100(this.this$0).getResources().getDrawable(paramInt));
  }
  
  public ActionBar.Tab setIcon(Drawable paramDrawable)
  {
    this.mIcon = paramDrawable;
    if (this.mPosition >= 0) {
      ActionBarImplBase.access$000(this.this$0).updateTab(this.mPosition);
    }
    return this;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
  
  public ActionBar.Tab setTabListener(ActionBar.TabListener paramTabListener)
  {
    this.mCallback = paramTabListener;
    return this;
  }
  
  public ActionBar.Tab setTag(Object paramObject)
  {
    this.mTag = paramObject;
    return this;
  }
  
  public ActionBar.Tab setText(int paramInt)
  {
    return setText(ActionBarImplBase.access$100(this.this$0).getResources().getText(paramInt));
  }
  
  public ActionBar.Tab setText(CharSequence paramCharSequence)
  {
    this.mText = paramCharSequence;
    if (this.mPosition >= 0) {
      ActionBarImplBase.access$000(this.this$0).updateTab(this.mPosition);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBarImplBase.TabImpl
 * JD-Core Version:    0.7.0.1
 */