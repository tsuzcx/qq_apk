package com.facebook.stetho.inspector.elements.android;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.FlagToString;
import android.view.ViewDebug.IntToString;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.helper.IntegerFormatter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ViewDescriptor
  extends AbstractChainedDescriptor<View>
  implements HighlightableDescriptor
{
  private static final String ID_NAME = "id";
  private static final String NONE_MAPPING = "<no mapping>";
  private static final String NONE_VALUE = "(none)";
  private final MethodInvoker mMethodInvoker;
  @Nullable
  @GuardedBy("this")
  private volatile List<ViewCSSProperty> mViewProperties;
  @Nullable
  private Pattern mWordBoundaryPattern;
  
  public ViewDescriptor()
  {
    this(new MethodInvoker());
  }
  
  public ViewDescriptor(MethodInvoker paramMethodInvoker)
  {
    this.mMethodInvoker = paramMethodInvoker;
  }
  
  private static boolean canFlagsBeMappedToString(@Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    return (paramExportedProperty != null) && (paramExportedProperty.flagMapping() != null) && (paramExportedProperty.flagMapping().length > 0);
  }
  
  private static boolean canIntBeMappedToString(@Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    return (paramExportedProperty != null) && (paramExportedProperty.mapping() != null) && (paramExportedProperty.mapping().length > 0);
  }
  
  private static String capitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (Character.isTitleCase(paramString.charAt(0)))) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    paramString.setCharAt(0, Character.toTitleCase(paramString.charAt(0)));
    return paramString.toString();
  }
  
  private String convertViewPropertyNameToCSSName(String paramString)
  {
    paramString = getWordBoundaryPattern().split(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length)
    {
      if ((paramString[i].equals("get")) || (paramString[i].equals("m"))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString[i].toLowerCase());
        if (i < paramString.length - 1) {
          localStringBuilder.append('-');
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  @Nullable
  private static String getIdAttribute(View paramView)
  {
    int i = paramView.getId();
    if (i == -1) {
      return null;
    }
    return ResourcesUtil.getIdStringQuietly(paramView, paramView.getResources(), i);
  }
  
  private void getIdStyle(View paramView, StyleAccumulator paramStyleAccumulator)
  {
    paramView = getIdAttribute(paramView);
    if (paramView == null)
    {
      paramStyleAccumulator.store("id", "(none)", false);
      return;
    }
    paramStyleAccumulator.store("id", paramView, false);
  }
  
  private void getStyleFromInteger(String paramString, Integer paramInteger, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    String str = IntegerFormatter.getInstance().format(paramInteger, paramExportedProperty);
    if (canIntBeMappedToString(paramExportedProperty))
    {
      paramStyleAccumulator.store(paramString, str + " (" + mapIntToStringUsingAnnotation(paramInteger.intValue(), paramExportedProperty) + ")", false);
      return;
    }
    if (canFlagsBeMappedToString(paramExportedProperty))
    {
      paramStyleAccumulator.store(paramString, str + " (" + mapFlagsToStringUsingAnnotation(paramInteger.intValue(), paramExportedProperty) + ")", false);
      return;
    }
    Boolean localBoolean = Boolean.valueOf(true);
    if ((paramInteger.intValue() == 0) && (!canFlagsBeMappedToString(paramExportedProperty)))
    {
      paramInteger = localBoolean;
      if (!canIntBeMappedToString(paramExportedProperty)) {}
    }
    else
    {
      paramInteger = Boolean.valueOf(false);
    }
    paramStyleAccumulator.store(paramString, str, paramInteger.booleanValue());
  }
  
  private void getStyleFromValue(View paramView, String paramString, Object paramObject, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool1 = true;
    if (paramString.equals("id"))
    {
      getIdStyle(paramView, paramStyleAccumulator);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      getStyleFromInteger(paramString, (Integer)paramObject, paramExportedProperty, paramStyleAccumulator);
      return;
    }
    if ((paramObject instanceof Float))
    {
      paramView = String.valueOf(paramObject);
      if (((Float)paramObject).floatValue() == 0.0F) {}
      for (;;)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
        bool1 = false;
      }
    }
    if ((paramObject instanceof Boolean))
    {
      paramStyleAccumulator.store(paramString, String.valueOf(paramObject), false);
      return;
    }
    if ((paramObject instanceof Short))
    {
      paramView = String.valueOf(paramObject);
      if (((Short)paramObject).shortValue() == 0) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
      }
    }
    if ((paramObject instanceof Long))
    {
      paramView = String.valueOf(paramObject);
      if (((Long)paramObject).longValue() == 0L) {}
      for (bool1 = bool3;; bool1 = false)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
      }
    }
    if ((paramObject instanceof Double))
    {
      paramView = String.valueOf(paramObject);
      if (((Double)paramObject).doubleValue() == 0.0D) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
      }
    }
    if ((paramObject instanceof Byte))
    {
      paramView = String.valueOf(paramObject);
      if (((Byte)paramObject).byteValue() == 0) {}
      for (bool1 = bool5;; bool1 = false)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
      }
    }
    if ((paramObject instanceof Character))
    {
      paramView = String.valueOf(paramObject);
      if (((Character)paramObject).charValue() == 0) {}
      for (bool1 = bool6;; bool1 = false)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
      }
    }
    if ((paramObject instanceof CharSequence))
    {
      paramView = String.valueOf(paramObject);
      if (((CharSequence)paramObject).length() == 0) {}
      for (bool1 = bool7;; bool1 = false)
      {
        paramStyleAccumulator.store(paramString, paramView, bool1);
        return;
      }
    }
    getStylesFromObject(paramView, paramString, paramObject, paramExportedProperty, paramStyleAccumulator);
  }
  
  private void getStylesFromObject(View paramView, String paramString, Object paramObject, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    if ((paramExportedProperty == null) || (!paramExportedProperty.deepExport()) || (paramObject == null)) {}
    Field localField;
    for (;;)
    {
      return;
      Field[] arrayOfField = paramObject.getClass().getFields();
      int k = arrayOfField.length;
      int j = 0;
      while (j < k)
      {
        localField = arrayOfField[j];
        if (!Modifier.isStatic(localField.getModifiers())) {
          break label71;
        }
        j += 1;
      }
    }
    for (;;)
    {
      label71:
      String str1;
      int i;
      String str2;
      try
      {
        localField.setAccessible(true);
        Object localObject = localField.get(paramObject);
        str1 = localField.getName();
        i = -1;
        switch (str1.hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            str2 = paramExportedProperty.prefix();
            if (str2 != null) {
              break label361;
            }
            str1 = convertViewPropertyNameToCSSName(str1);
            getStyleFromValue(paramView, str1, localObject, (ViewDebug.ExportedProperty)localField.getAnnotation(ViewDebug.ExportedProperty.class), paramStyleAccumulator);
          }
          break;
        }
      }
      catch (IllegalAccessException paramView)
      {
        LogUtil.e(paramView, "failed to get property of name: \"" + paramString + "\" of object: " + String.valueOf(paramObject));
        return;
      }
      if (str1.equals("bottomMargin"))
      {
        i = 0;
        continue;
        if (str1.equals("topMargin"))
        {
          i = 1;
          continue;
          if (str1.equals("leftMargin"))
          {
            i = 2;
            continue;
            if (str1.equals("rightMargin"))
            {
              i = 3;
              continue;
              str1 = "margin-bottom";
              continue;
              str1 = "margin-top";
              continue;
              str1 = "margin-left";
              continue;
              str1 = "margin-right";
              continue;
              label361:
              str1 = str2 + str1;
            }
          }
        }
      }
    }
  }
  
  private List<ViewCSSProperty> getViewProperties()
  {
    int j = 0;
    if (this.mViewProperties == null) {}
    for (;;)
    {
      int i;
      try
      {
        if (this.mViewProperties == null)
        {
          ArrayList localArrayList = new ArrayList();
          Object localObject2 = View.class.getDeclaredMethods();
          int k = localObject2.length;
          i = 0;
          Method localMethod;
          ViewDebug.ExportedProperty localExportedProperty;
          if (i < k)
          {
            localMethod = localObject2[i];
            localExportedProperty = (ViewDebug.ExportedProperty)localMethod.getAnnotation(ViewDebug.ExportedProperty.class);
            if (localExportedProperty != null) {
              localArrayList.add(new MethodBackedCSSProperty(localMethod, convertViewPropertyNameToCSSName(localMethod.getName()), localExportedProperty));
            }
          }
          else
          {
            localObject2 = View.class.getDeclaredFields();
            k = localObject2.length;
            i = j;
            if (i < k)
            {
              localMethod = localObject2[i];
              localExportedProperty = (ViewDebug.ExportedProperty)localMethod.getAnnotation(ViewDebug.ExportedProperty.class);
              if (localExportedProperty == null) {
                break label216;
              }
              localArrayList.add(new FieldBackedCSSProperty(localMethod, convertViewPropertyNameToCSSName(localMethod.getName()), localExportedProperty));
              break label216;
            }
            Collections.sort(localArrayList, new ViewDescriptor.1(this));
            this.mViewProperties = Collections.unmodifiableList(localArrayList);
          }
        }
        else
        {
          return this.mViewProperties;
        }
      }
      finally {}
      i += 1;
      continue;
      label216:
      i += 1;
    }
  }
  
  private Pattern getWordBoundaryPattern()
  {
    if (this.mWordBoundaryPattern == null) {
      this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
    }
    return this.mWordBoundaryPattern;
  }
  
  private static String mapFlagsToStringUsingAnnotation(int paramInt, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    if (!canFlagsBeMappedToString(paramExportedProperty)) {
      throw new IllegalStateException("Cannot map using this annotation");
    }
    Object localObject = null;
    ViewDebug.FlagToString[] arrayOfFlagToString = paramExportedProperty.flagMapping();
    int m = arrayOfFlagToString.length;
    int i = 0;
    int j = 0;
    paramExportedProperty = (ViewDebug.ExportedProperty)localObject;
    if (i < m)
    {
      ViewDebug.FlagToString localFlagToString = arrayOfFlagToString[i];
      boolean bool2 = localFlagToString.outputIf();
      if ((localFlagToString.mask() & paramInt) == localFlagToString.equals()) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        int k = j;
        localObject = paramExportedProperty;
        if (bool2 == bool1)
        {
          localObject = paramExportedProperty;
          if (paramExportedProperty == null) {
            localObject = new StringBuilder();
          }
          if (j != 0) {
            ((StringBuilder)localObject).append(" | ");
          }
          ((StringBuilder)localObject).append(localFlagToString.name());
          k = 1;
        }
        i += 1;
        j = k;
        paramExportedProperty = (ViewDebug.ExportedProperty)localObject;
        break;
      }
    }
    if (j != 0) {
      return paramExportedProperty.toString();
    }
    return "<no mapping>";
  }
  
  private static String mapIntToStringUsingAnnotation(int paramInt, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    if (!canIntBeMappedToString(paramExportedProperty)) {
      throw new IllegalStateException("Cannot map using this annotation");
    }
    paramExportedProperty = paramExportedProperty.mapping();
    int j = paramExportedProperty.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramExportedProperty[i];
      if (localObject.from() == paramInt) {
        return localObject.to();
      }
      i += 1;
    }
    return "<no mapping>";
  }
  
  public View getViewForHighlighting(Object paramObject)
  {
    return (View)paramObject;
  }
  
  protected void onGetAccessibilityStyles(View paramView, StyleAccumulator paramStyleAccumulator)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    ViewCompat.onInitializeAccessibilityNodeInfo(paramView, localAccessibilityNodeInfoCompat);
    boolean bool2 = AccessibilityNodeInfoWrapper.getIgnored(localAccessibilityNodeInfoCompat, paramView);
    getStyleFromValue(paramView, "ignored", Boolean.valueOf(bool2), null, paramStyleAccumulator);
    if (bool2) {
      getStyleFromValue(paramView, "ignored-reasons", AccessibilityNodeInfoWrapper.getIgnoredReasons(localAccessibilityNodeInfoCompat, paramView), null, paramStyleAccumulator);
    }
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      getStyleFromValue(paramView, "focusable", Boolean.valueOf(bool1), null, paramStyleAccumulator);
      if (!bool2)
      {
        getStyleFromValue(paramView, "focusable-reasons", AccessibilityNodeInfoWrapper.getFocusableReasons(localAccessibilityNodeInfoCompat, paramView), null, paramStyleAccumulator);
        getStyleFromValue(paramView, "focused", Boolean.valueOf(localAccessibilityNodeInfoCompat.isAccessibilityFocused()), null, paramStyleAccumulator);
        getStyleFromValue(paramView, "description", AccessibilityNodeInfoWrapper.getDescription(localAccessibilityNodeInfoCompat, paramView), null, paramStyleAccumulator);
        getStyleFromValue(paramView, "actions", AccessibilityNodeInfoWrapper.getActions(localAccessibilityNodeInfoCompat), null, paramStyleAccumulator);
      }
      localAccessibilityNodeInfoCompat.recycle();
      return;
    }
  }
  
  protected void onGetAttributes(View paramView, AttributeAccumulator paramAttributeAccumulator)
  {
    paramView = getIdAttribute(paramView);
    if (paramView != null) {
      paramAttributeAccumulator.store("id", paramView);
    }
  }
  
  protected String onGetNodeName(View paramView)
  {
    paramView = paramView.getClass().getName();
    return StringUtil.removePrefix(paramView, "android.view.", StringUtil.removePrefix(paramView, "android.widget."));
  }
  
  protected void onGetStyles(View paramView, StyleAccumulator paramStyleAccumulator)
  {
    List localList = getViewProperties();
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      ViewCSSProperty localViewCSSProperty = (ViewCSSProperty)localList.get(i);
      try
      {
        getStyleFromValue(paramView, localViewCSSProperty.getCSSName(), localViewCSSProperty.getValue(paramView), localViewCSSProperty.getAnnotation(), paramStyleAccumulator);
        i += 1;
      }
      catch (Exception localException)
      {
        while (((localException instanceof IllegalAccessException)) || ((localException instanceof InvocationTargetException))) {
          LogUtil.e(localException, "failed to get style property " + localViewCSSProperty.getCSSName() + " of element= " + paramView.toString());
        }
        throw ExceptionUtil.propagate(localException);
      }
    }
  }
  
  protected void onSetAttributesAsText(View paramView, String paramString)
  {
    paramString = parseSetAttributesAsTextArg(paramString).entrySet().iterator();
    while (paramString.hasNext())
    {
      Object localObject = (Map.Entry)paramString.next();
      String str = "set" + capitalize((String)((Map.Entry)localObject).getKey());
      localObject = (String)((Map.Entry)localObject).getValue();
      this.mMethodInvoker.invoke(paramView, str, (String)localObject);
    }
  }
  
  final class FieldBackedCSSProperty
    extends ViewDescriptor.ViewCSSProperty
  {
    private final Field mField;
    
    public FieldBackedCSSProperty(Field paramField, String paramString, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
    {
      super(paramString, paramExportedProperty);
      this.mField = paramField;
      this.mField.setAccessible(true);
    }
    
    public Object getValue(View paramView)
      throws InvocationTargetException, IllegalAccessException
    {
      return this.mField.get(paramView);
    }
  }
  
  final class MethodBackedCSSProperty
    extends ViewDescriptor.ViewCSSProperty
  {
    private final Method mMethod;
    
    public MethodBackedCSSProperty(Method paramMethod, String paramString, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
    {
      super(paramString, paramExportedProperty);
      this.mMethod = paramMethod;
      this.mMethod.setAccessible(true);
    }
    
    public Object getValue(View paramView)
      throws InvocationTargetException, IllegalAccessException
    {
      return this.mMethod.invoke(paramView, new Object[0]);
    }
  }
  
  abstract class ViewCSSProperty
  {
    private final ViewDebug.ExportedProperty mAnnotation;
    private final String mCSSName;
    
    public ViewCSSProperty(String paramString, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
    {
      this.mCSSName = paramString;
      this.mAnnotation = paramExportedProperty;
    }
    
    @Nullable
    public final ViewDebug.ExportedProperty getAnnotation()
    {
      return this.mAnnotation;
    }
    
    public final String getCSSName()
    {
      return this.mCSSName;
    }
    
    public abstract Object getValue(View paramView)
      throws InvocationTargetException, IllegalAccessException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.elements.android.ViewDescriptor
 * JD-Core Version:    0.7.0.1
 */