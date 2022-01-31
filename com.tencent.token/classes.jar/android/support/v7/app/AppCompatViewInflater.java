package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.TintContextWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final String LOG_TAG = "AppCompatViewInflater";
  private static final String[] sClassPrefixList = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map sConstructorMap = new ArrayMap();
  private static final Class[] sConstructorSignature = { Context.class, AttributeSet.class };
  private static final int[] sOnClickAttrs = { 16843375 };
  private final Object[] mConstructorArgs = new Object[2];
  
  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if ((!(localObject instanceof ContextWrapper)) || ((Build.VERSION.SDK_INT >= 15) && (!ViewCompat.hasOnClickListeners(paramView)))) {
      return;
    }
    paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
    localObject = paramAttributeSet.getString(0);
    if (localObject != null) {
      paramView.setOnClickListener(new AppCompatViewInflater.DeclaredOnClickListener(paramView, (String)localObject));
    }
    paramAttributeSet.recycle();
  }
  
  private View createViewByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 != null) {}
      for (paramContext = paramString2 + paramString1;; paramContext = paramString1)
      {
        localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(sConstructorSignature);
        sConstructorMap.put(paramString1, localObject);
        ((Constructor)localObject).setAccessible(true);
        paramContext = (View)((Constructor)localObject).newInstance(this.mConstructorArgs);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext) {}
  }
  
  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    String str = paramString;
    if (paramString.equals("view")) {
      str = paramAttributeSet.getAttributeValue(null, "class");
    }
    try
    {
      this.mConstructorArgs[0] = paramContext;
      this.mConstructorArgs[1] = paramAttributeSet;
      if (-1 == str.indexOf('.'))
      {
        int i = 0;
        while (i < sClassPrefixList.length)
        {
          paramString = createViewByPrefix(paramContext, str, sClassPrefixList[i]);
          if (paramString != null) {
            return paramString;
          }
          i += 1;
        }
        return null;
      }
      paramContext = createViewByPrefix(paramContext, str, null);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      return null;
    }
    finally
    {
      this.mConstructorArgs[0] = null;
      this.mConstructorArgs[1] = null;
    }
  }
  
  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    if (paramBoolean1) {}
    for (int i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);; i = 0)
    {
      int j = i;
      if (paramBoolean2)
      {
        j = i;
        if (i == 0)
        {
          i = paramAttributeSet.getResourceId(R.styleable.View_theme, 0);
          j = i;
          if (i != 0)
          {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            j = i;
          }
        }
      }
      paramAttributeSet.recycle();
      paramAttributeSet = paramContext;
      if (j != 0) {
        if ((paramContext instanceof ContextThemeWrapper))
        {
          paramAttributeSet = paramContext;
          if (((ContextThemeWrapper)paramContext).getThemeResId() == j) {}
        }
        else
        {
          paramAttributeSet = new ContextThemeWrapper(paramContext, j);
        }
      }
      return paramAttributeSet;
    }
  }
  
  private void verifyNotNull(View paramView, String paramString)
  {
    if (paramView == null) {
      throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + paramString + ">, but returned null");
    }
  }
  
  @NonNull
  protected AppCompatAutoCompleteTextView createAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatButton(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatCheckBox createCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckBox(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatCheckedTextView createCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatCheckedTextView(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatEditText createEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatEditText(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatImageButton createImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageButton(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatImageView createImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatImageView(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatMultiAutoCompleteTextView(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatRadioButton createRadioButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRadioButton(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatRatingBar createRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatRatingBar(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatSeekBar createSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSeekBar(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatSpinner createSpinner(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatSpinner(paramContext, paramAttributeSet);
  }
  
  @NonNull
  protected AppCompatTextView createTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new AppCompatTextView(paramContext, paramAttributeSet);
  }
  
  @Nullable
  protected View createView(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  final View createView(View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((paramBoolean1) && (paramView != null)) {}
    for (Object localObject = paramView.getContext();; localObject = paramContext)
    {
      if (!paramBoolean2)
      {
        paramView = (View)localObject;
        if (!paramBoolean3) {}
      }
      else
      {
        paramView = themifyContext((Context)localObject, paramAttributeSet, paramBoolean2, paramBoolean3);
      }
      localObject = paramView;
      if (paramBoolean4) {
        localObject = TintContextWrapper.wrap(paramView);
      }
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramView = createView((Context)localObject, paramString, paramAttributeSet);
          label254:
          if ((paramView == null) && (paramContext != localObject)) {
            paramView = createViewFromTag((Context)localObject, paramString, paramAttributeSet);
          }
          break;
        }
        break;
      }
      for (;;)
      {
        if (paramView != null) {
          checkOnClickListener(paramView, paramAttributeSet);
        }
        return paramView;
        if (!paramString.equals("TextView")) {
          break;
        }
        i = 0;
        break;
        if (!paramString.equals("ImageView")) {
          break;
        }
        i = 1;
        break;
        if (!paramString.equals("Button")) {
          break;
        }
        i = 2;
        break;
        if (!paramString.equals("EditText")) {
          break;
        }
        i = 3;
        break;
        if (!paramString.equals("Spinner")) {
          break;
        }
        i = 4;
        break;
        if (!paramString.equals("ImageButton")) {
          break;
        }
        i = 5;
        break;
        if (!paramString.equals("CheckBox")) {
          break;
        }
        i = 6;
        break;
        if (!paramString.equals("RadioButton")) {
          break;
        }
        i = 7;
        break;
        if (!paramString.equals("CheckedTextView")) {
          break;
        }
        i = 8;
        break;
        if (!paramString.equals("AutoCompleteTextView")) {
          break;
        }
        i = 9;
        break;
        if (!paramString.equals("MultiAutoCompleteTextView")) {
          break;
        }
        i = 10;
        break;
        if (!paramString.equals("RatingBar")) {
          break;
        }
        i = 11;
        break;
        if (!paramString.equals("SeekBar")) {
          break;
        }
        i = 12;
        break;
        paramView = createTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createImageView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createButton((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createEditText((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createSpinner((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createImageButton((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createCheckBox((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createRadioButton((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createCheckedTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createAutoCompleteTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createRatingBar((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
        paramView = createSeekBar((Context)localObject, paramAttributeSet);
        verifyNotNull(paramView, paramString);
        break label254;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater
 * JD-Core Version:    0.7.0.1
 */