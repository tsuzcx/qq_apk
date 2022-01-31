package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AppCompatViewInflater$DeclaredOnClickListener
  implements View.OnClickListener
{
  private final View mHostView;
  private final String mMethodName;
  private Context mResolvedContext;
  private Method mResolvedMethod;
  
  public AppCompatViewInflater$DeclaredOnClickListener(@NonNull View paramView, @NonNull String paramString)
  {
    this.mHostView = paramView;
    this.mMethodName = paramString;
  }
  
  @NonNull
  private void resolveMethod(@Nullable Context paramContext, @NonNull String paramString)
  {
    while (paramContext != null) {
      try
      {
        if (!paramContext.isRestricted())
        {
          paramString = paramContext.getClass().getMethod(this.mMethodName, new Class[] { View.class });
          if (paramString != null)
          {
            this.mResolvedMethod = paramString;
            this.mResolvedContext = paramContext;
            return;
          }
        }
      }
      catch (NoSuchMethodException paramString)
      {
        if ((paramContext instanceof ContextWrapper)) {
          paramContext = ((ContextWrapper)paramContext).getBaseContext();
        } else {
          paramContext = null;
        }
      }
    }
    int i = this.mHostView.getId();
    if (i == -1) {}
    for (paramContext = "";; paramContext = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(i) + "'") {
      throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.mHostView.getClass() + paramContext);
    }
  }
  
  public void onClick(@NonNull View paramView)
  {
    if (this.mResolvedMethod == null) {
      resolveMethod(this.mHostView.getContext(), this.mMethodName);
    }
    try
    {
      this.mResolvedMethod.invoke(this.mResolvedContext, new Object[] { paramView });
      return;
    }
    catch (IllegalAccessException paramView)
    {
      throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
    }
    catch (InvocationTargetException paramView)
    {
      throw new IllegalStateException("Could not execute method for android:onClick", paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater.DeclaredOnClickListener
 * JD-Core Version:    0.7.0.1
 */