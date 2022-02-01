package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
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
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class AppCompatViewInflater
{
  private static final String LOG_TAG = "AppCompatViewInflater";
  private static final String[] sClassPrefixList = { "android.widget.", "android.view.", "android.webkit." };
  private static final Map<String, Constructor<? extends View>> sConstructorMap = new ArrayMap();
  private static final Class<?>[] sConstructorSignature = { Context.class, AttributeSet.class };
  private static final int[] sOnClickAttrs = { 16843375 };
  private final Object[] mConstructorArgs = new Object[2];
  
  private void checkOnClickListener(View paramView, AttributeSet paramAttributeSet)
  {
    Object localObject = paramView.getContext();
    if ((localObject instanceof ContextWrapper))
    {
      if ((Build.VERSION.SDK_INT >= 15) && (!ViewCompat.hasOnClickListeners(paramView))) {
        return;
      }
      paramAttributeSet = ((Context)localObject).obtainStyledAttributes(paramAttributeSet, sOnClickAttrs);
      localObject = paramAttributeSet.getString(0);
      if (localObject != null) {
        paramView.setOnClickListener(new DeclaredOnClickListener(paramView, (String)localObject));
      }
      paramAttributeSet.recycle();
      return;
    }
  }
  
  private View createViewByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    Constructor localConstructor = (Constructor)sConstructorMap.get(paramString1);
    Object localObject = localConstructor;
    if (localConstructor == null) {}
    try
    {
      localObject = paramContext.getClassLoader();
      if (paramString2 == null) {
        break label119;
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString2);
      paramContext.append(paramString1);
      paramContext = paramContext.toString();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        continue;
        paramContext = paramString1;
      }
    }
    localObject = ((ClassLoader)localObject).loadClass(paramContext).asSubclass(View.class).getConstructor(sConstructorSignature);
    sConstructorMap.put(paramString1, localObject);
    ((Constructor)localObject).setAccessible(true);
    paramContext = (View)((Constructor)localObject).newInstance(this.mConstructorArgs);
    return paramContext;
    return null;
  }
  
  /* Error */
  private View createViewFromTag(Context paramContext, String paramString, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 5
    //   3: aload_2
    //   4: ldc 156
    //   6: invokevirtual 160	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifeq +14 -> 23
    //   12: aload_3
    //   13: aconst_null
    //   14: ldc 162
    //   16: invokeinterface 166 3 0
    //   21: astore 5
    //   23: aload_0
    //   24: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   27: iconst_0
    //   28: aload_1
    //   29: aastore
    //   30: aload_0
    //   31: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   34: iconst_1
    //   35: aload_3
    //   36: aastore
    //   37: iconst_m1
    //   38: aload 5
    //   40: bipush 46
    //   42: invokevirtual 170	java/lang/String:indexOf	(I)I
    //   45: if_icmpne +72 -> 117
    //   48: iconst_0
    //   49: istore 4
    //   51: iload 4
    //   53: getstatic 46	android/support/v7/app/AppCompatViewInflater:sClassPrefixList	[Ljava/lang/String;
    //   56: arraylength
    //   57: if_icmpge +45 -> 102
    //   60: aload_0
    //   61: aload_1
    //   62: aload 5
    //   64: getstatic 46	android/support/v7/app/AppCompatViewInflater:sClassPrefixList	[Ljava/lang/String;
    //   67: iload 4
    //   69: aaload
    //   70: invokespecial 172	android/support/v7/app/AppCompatViewInflater:createViewByPrefix	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +18 -> 93
    //   78: aload_0
    //   79: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   82: astore_1
    //   83: aload_1
    //   84: iconst_0
    //   85: aconst_null
    //   86: aastore
    //   87: aload_1
    //   88: iconst_1
    //   89: aconst_null
    //   90: aastore
    //   91: aload_2
    //   92: areturn
    //   93: iload 4
    //   95: iconst_1
    //   96: iadd
    //   97: istore 4
    //   99: goto -48 -> 51
    //   102: aload_0
    //   103: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   106: astore_1
    //   107: aload_1
    //   108: iconst_0
    //   109: aconst_null
    //   110: aastore
    //   111: aload_1
    //   112: iconst_1
    //   113: aconst_null
    //   114: aastore
    //   115: aconst_null
    //   116: areturn
    //   117: aload_0
    //   118: aload_1
    //   119: aload 5
    //   121: aconst_null
    //   122: invokespecial 172	android/support/v7/app/AppCompatViewInflater:createViewByPrefix	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/view/View;
    //   125: astore_1
    //   126: aload_0
    //   127: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   130: astore_2
    //   131: aload_2
    //   132: iconst_0
    //   133: aconst_null
    //   134: aastore
    //   135: aload_2
    //   136: iconst_1
    //   137: aconst_null
    //   138: aastore
    //   139: aload_1
    //   140: areturn
    //   141: astore_1
    //   142: aload_0
    //   143: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   146: astore_2
    //   147: aload_2
    //   148: iconst_0
    //   149: aconst_null
    //   150: aastore
    //   151: aload_2
    //   152: iconst_1
    //   153: aconst_null
    //   154: aastore
    //   155: aload_1
    //   156: athrow
    //   157: aload_0
    //   158: getfield 57	android/support/v7/app/AppCompatViewInflater:mConstructorArgs	[Ljava/lang/Object;
    //   161: astore_1
    //   162: aload_1
    //   163: iconst_0
    //   164: aconst_null
    //   165: aastore
    //   166: aload_1
    //   167: iconst_1
    //   168: aconst_null
    //   169: aastore
    //   170: aconst_null
    //   171: areturn
    //   172: astore_1
    //   173: goto -16 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	AppCompatViewInflater
    //   0	176	1	paramContext	Context
    //   0	176	2	paramString	String
    //   0	176	3	paramAttributeSet	AttributeSet
    //   49	49	4	i	int
    //   1	119	5	str	String
    // Exception table:
    //   from	to	target	type
    //   23	48	141	finally
    //   51	74	141	finally
    //   117	126	141	finally
    //   23	48	172	java/lang/Exception
    //   51	74	172	java/lang/Exception
    //   117	126	172	java/lang/Exception
  }
  
  private static Context themifyContext(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.View, 0, 0);
    int i;
    if (paramBoolean1) {
      i = paramAttributeSet.getResourceId(R.styleable.View_android_theme, 0);
    } else {
      i = 0;
    }
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
  
  private void verifyNotNull(View paramView, String paramString)
  {
    if (paramView != null) {
      return;
    }
    paramView = new StringBuilder();
    paramView.append(getClass().getName());
    paramView.append(" asked to inflate view for <");
    paramView.append(paramString);
    paramView.append(">, but returned null");
    throw new IllegalStateException(paramView.toString());
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
    if ((paramBoolean1) && (paramView != null)) {
      localObject = paramView.getContext();
    } else {
      localObject = paramContext;
    }
    if (!paramBoolean2)
    {
      paramView = (View)localObject;
      if (!paramBoolean3) {}
    }
    else
    {
      paramView = themifyContext((Context)localObject, paramAttributeSet, paramBoolean2, paramBoolean3);
    }
    Object localObject = paramView;
    if (paramBoolean4) {
      localObject = TintContextWrapper.wrap(paramView);
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2001146706: 
      if (paramString.equals("Button")) {
        i = 2;
      }
      break;
    case 1666676343: 
      if (paramString.equals("EditText")) {
        i = 3;
      }
      break;
    case 1601505219: 
      if (paramString.equals("CheckBox")) {
        i = 6;
      }
      break;
    case 1413872058: 
      if (paramString.equals("AutoCompleteTextView")) {
        i = 9;
      }
      break;
    case 1125864064: 
      if (paramString.equals("ImageView")) {
        i = 1;
      }
      break;
    case 776382189: 
      if (paramString.equals("RadioButton")) {
        i = 7;
      }
      break;
    case -339785223: 
      if (paramString.equals("Spinner")) {
        i = 4;
      }
      break;
    case -658531749: 
      if (paramString.equals("SeekBar")) {
        i = 12;
      }
      break;
    case -937446323: 
      if (paramString.equals("ImageButton")) {
        i = 5;
      }
      break;
    case -938935918: 
      if (paramString.equals("TextView")) {
        i = 0;
      }
      break;
    case -1346021293: 
      if (paramString.equals("MultiAutoCompleteTextView")) {
        i = 10;
      }
      break;
    case -1455429095: 
      if (paramString.equals("CheckedTextView")) {
        i = 8;
      }
      break;
    case -1946472170: 
      if (paramString.equals("RatingBar")) {
        i = 11;
      }
      break;
    }
    switch (i)
    {
    default: 
      paramView = createView((Context)localObject, paramString, paramAttributeSet);
      break;
    case 12: 
      paramView = createSeekBar((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 11: 
      paramView = createRatingBar((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 10: 
      paramView = createMultiAutoCompleteTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 9: 
      paramView = createAutoCompleteTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 8: 
      paramView = createCheckedTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 7: 
      paramView = createRadioButton((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 6: 
      paramView = createCheckBox((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 5: 
      paramView = createImageButton((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 4: 
      paramView = createSpinner((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 3: 
      paramView = createEditText((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 2: 
      paramView = createButton((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 1: 
      paramView = createImageView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
      break;
    case 0: 
      paramView = createTextView((Context)localObject, paramAttributeSet);
      verifyNotNull(paramView, paramString);
    }
    View localView = paramView;
    if (paramView == null)
    {
      localView = paramView;
      if (paramContext != localObject) {
        localView = createViewFromTag((Context)localObject, paramString, paramAttributeSet);
      }
    }
    if (localView != null) {
      checkOnClickListener(localView, paramAttributeSet);
    }
    return localView;
  }
  
  private static class DeclaredOnClickListener
    implements View.OnClickListener
  {
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;
    
    public DeclaredOnClickListener(@NonNull View paramView, @NonNull String paramString)
    {
      this.mHostView = paramView;
      this.mMethodName = paramString;
    }
    
    @NonNull
    private void resolveMethod(@Nullable Context paramContext, @NonNull String paramString)
    {
      while (paramContext != null)
      {
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
          label47:
          int i;
          break label47;
        }
        if ((paramContext instanceof ContextWrapper)) {
          paramContext = ((ContextWrapper)paramContext).getBaseContext();
        } else {
          paramContext = null;
        }
      }
      i = this.mHostView.getId();
      if (i == -1)
      {
        paramContext = "";
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append(" with id '");
        paramContext.append(this.mHostView.getContext().getResources().getResourceEntryName(i));
        paramContext.append("'");
        paramContext = paramContext.toString();
      }
      paramString = new StringBuilder();
      paramString.append("Could not find method ");
      paramString.append(this.mMethodName);
      paramString.append("(View) in a parent or ancestor Context for android:onClick ");
      paramString.append("attribute defined on view ");
      paramString.append(this.mHostView.getClass());
      paramString.append(paramContext);
      throw new IllegalStateException(paramString.toString());
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
      catch (InvocationTargetException paramView)
      {
        throw new IllegalStateException("Could not execute method for android:onClick", paramView);
      }
      catch (IllegalAccessException paramView)
      {
        throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater
 * JD-Core Version:    0.7.0.1
 */