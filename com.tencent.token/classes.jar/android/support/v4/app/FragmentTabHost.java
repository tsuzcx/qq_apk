package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import com.tencent.token.cs;
import com.tencent.token.cv;
import java.util.ArrayList;

public class FragmentTabHost
  extends TabHost
  implements TabHost.OnTabChangeListener
{
  private final ArrayList<a> a = new ArrayList();
  private Context b;
  private cs c;
  private int d;
  private TabHost.OnTabChangeListener e;
  private a f;
  private boolean g;
  
  public FragmentTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { 16842995 }, 0, 0);
    this.d = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    super.setOnTabChangedListener(this);
  }
  
  private a a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.a.get(i);
      if (locala.a.equals(paramString)) {
        return locala;
      }
      i += 1;
    }
    return null;
  }
  
  private cv a(String paramString, cv paramcv)
  {
    a locala = a(paramString);
    paramString = paramcv;
    if (this.f != locala)
    {
      paramString = paramcv;
      if (paramcv == null) {
        paramString = this.c.a();
      }
      paramcv = this.f;
      if ((paramcv != null) && (paramcv.d != null)) {
        paramString.a(this.f.d);
      }
      if (locala != null) {
        if (locala.d == null)
        {
          locala.d = Fragment.a(this.b, locala.b.getName(), locala.c);
          paramString.a(this.d, locala.d, locala.a);
        }
        else
        {
          paramString.b(locala.d);
        }
      }
      this.f = locala;
    }
    return paramString;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    String str = getCurrentTabTag();
    int j = this.a.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      a locala = (a)this.a.get(i);
      locala.d = this.c.a(locala.a);
      Object localObject2 = localObject1;
      if (locala.d != null)
      {
        localObject2 = localObject1;
        if (!locala.d.C) {
          if (locala.a.equals(str))
          {
            this.f = locala;
            localObject2 = localObject1;
          }
          else
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = this.c.a();
            }
            ((cv)localObject2).a(locala.d);
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    this.g = true;
    localObject1 = a(str, (cv)localObject1);
    if (localObject1 != null)
    {
      ((cv)localObject1).b();
      this.c.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g = false;
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setCurrentTabByTag(paramParcelable.a);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = getCurrentTabTag();
    return localSavedState;
  }
  
  public void onTabChanged(String paramString)
  {
    if (this.g)
    {
      localObject = a(paramString, null);
      if (localObject != null) {
        ((cv)localObject).b();
      }
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((TabHost.OnTabChangeListener)localObject).onTabChanged(paramString);
    }
  }
  
  public void setOnTabChangedListener(TabHost.OnTabChangeListener paramOnTabChangeListener)
  {
    this.e = paramOnTabChangeListener;
  }
  
  @Deprecated
  public void setup()
  {
    throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    String a;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("FragmentTabHost.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" curTab=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
    }
  }
  
  static final class a
  {
    final String a;
    final Class<?> b;
    final Bundle c;
    Fragment d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.FragmentTabHost
 * JD-Core Version:    0.7.0.1
 */