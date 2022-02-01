package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.RestrictTo;

public abstract class ActionMode
{
  private Object mTag;
  private boolean mTitleOptionalHint;
  
  public abstract void finish();
  
  public abstract View getCustomView();
  
  public abstract Menu getMenu();
  
  public abstract MenuInflater getMenuInflater();
  
  public abstract CharSequence getSubtitle();
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public abstract CharSequence getTitle();
  
  public boolean getTitleOptionalHint()
  {
    return this.mTitleOptionalHint;
  }
  
  public abstract void invalidate();
  
  public boolean isTitleOptional()
  {
    return false;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean isUiFocusable()
  {
    return true;
  }
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setSubtitle(int paramInt);
  
  public abstract void setSubtitle(CharSequence paramCharSequence);
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public abstract void setTitle(int paramInt);
  
  public abstract void setTitle(CharSequence paramCharSequence);
  
  public void setTitleOptionalHint(boolean paramBoolean)
  {
    this.mTitleOptionalHint = paramBoolean;
  }
  
  public static abstract interface Callback
  {
    public abstract boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem);
    
    public abstract boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu);
    
    public abstract void onDestroyActionMode(ActionMode paramActionMode);
    
    public abstract boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.view.ActionMode
 * JD-Core Version:    0.7.0.1
 */