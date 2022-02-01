package com.tencent.pts.ui;

import android.graphics.Paint.FontMetricsInt;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeContainer;
import com.tencent.pts.ui.vnode.PTSNodeImage;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSTimeCostUtil;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PTSNodeFactory
{
  private static final String TAG = "PTSNodeFactory";
  private static HashMap<String, Constructor<? extends PTSNodeVirtual>> sNodeConstructors = new HashMap();
  private static HashMap<String, Constructor<? extends View>> sNodeViewConstructors = new HashMap();
  
  static
  {
    registerNodeVirtual("view", PTSNodeContainer.class);
    registerNodeVirtual("page", PTSNodeContainer.class);
    registerNodeVirtual("block", PTSNodeContainer.class);
    registerNodeVirtual("text", PTSNodeText.class);
    registerNodeVirtual("img", PTSNodeImage.class);
    registerNodeVirtual("swiper", PTSNodeSwiper.class);
    registerNodeVirtual("swiper-item", PTSNodeContainer.class);
  }
  
  private static void addToListMap(String paramString, PTSNodeVirtual paramPTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPTSNodeVirtual == null) || (paramHashMap == null)) {
      return;
    }
    List localList = (List)paramHashMap.get(paramString);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      paramHashMap.put(paramString, localObject);
    }
    ((List)localObject).add(paramPTSNodeVirtual);
  }
  
  public static PTSNodeVirtual bindData(PTSAppInstance paramPTSAppInstance, PTSNodeInfo paramPTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((paramPTSAppInstance == null) || (paramPTSNodeInfo == null) || (paramHashMap == null)) {
      return null;
    }
    hideAllNodeOfListMap(paramHashMap);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramPTSNodeInfo);
    paramPTSNodeInfo = null;
    label303:
    label305:
    for (;;)
    {
      PTSNodeInfo localPTSNodeInfo;
      Object localObject;
      PTSNodeVirtual localPTSNodeVirtual1;
      String str;
      Iterator localIterator;
      if (!localLinkedList.isEmpty())
      {
        localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
        localObject = getReusableNodeFromListMap(localPTSNodeInfo.getAttributes().getViewID(), paramHashMap);
        if (localObject == null)
        {
          localPTSNodeVirtual1 = buildVirtualNodeBFS(localPTSNodeInfo, paramPTSAppInstance, paramHashMap);
          if (localPTSNodeVirtual1 != null) {
            localPTSNodeVirtual1.bindNodeInfo(localPTSNodeInfo);
          }
          localObject = localPTSNodeVirtual1;
          if (localPTSNodeInfo.hasParent())
          {
            str = localPTSNodeInfo.getParentID();
            localIterator = paramHashMap.values().iterator();
          }
        }
      }
      for (;;)
      {
        localObject = localPTSNodeVirtual1;
        if (localIterator.hasNext())
        {
          localObject = (List)localIterator.next();
          if (localObject != null)
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              PTSNodeVirtual localPTSNodeVirtual2 = (PTSNodeVirtual)((Iterator)localObject).next();
              if ((localPTSNodeVirtual2 != null) && (localPTSNodeVirtual2.getNodeInfo() != null) && (TextUtils.equals(localPTSNodeVirtual2.getNodeInfo().getUniqueID(), str))) {
                localPTSNodeVirtual2.addChild(localPTSNodeVirtual1);
              }
            }
          }
        }
        else
        {
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label303;
            }
            localObject = localPTSNodeVirtual1;
            label232:
            if (localPTSNodeInfo.isRootNode()) {
              paramPTSNodeInfo = (PTSNodeInfo)localObject;
            }
            for (;;)
            {
              if (localObject != null)
              {
                ((PTSNodeVirtual)localObject).showNode();
                ((PTSNodeVirtual)localObject).setReusable(false);
              }
              if (!localPTSNodeInfo.isContainer()) {
                break label305;
              }
              localLinkedList.addAll(localPTSNodeInfo.getChildren());
              break;
              ((PTSNodeVirtual)localObject).bindNodeInfo(localPTSNodeInfo);
              break label232;
              makeAllNodeReusableOfListMap(paramHashMap);
              return paramPTSNodeInfo;
            }
          }
        }
      }
    }
  }
  
  public static PTSNodeVirtual buildVirtualNode(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance)
  {
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNode, nodeInfo or appInstance is null.");
      paramPTSNodeInfo = null;
      return paramPTSNodeInfo;
    }
    Object localObject = "";
    if (paramPTSNodeInfo.getAttributes() != null) {
      localObject = PTSValueConvertUtil.getString(paramPTSNodeInfo.getAttributes().get("pts:custom-view"));
    }
    String str = getKey(paramPTSNodeInfo.getNodeType(), (String)localObject);
    localObject = (Constructor)sNodeConstructors.get(str);
    if (localObject != null) {
      PTSTimeCostUtil.start("[buildVirtualNode]-" + paramPTSNodeInfo.getUniqueID());
    }
    for (;;)
    {
      try
      {
        localObject = (PTSNodeVirtual)((Constructor)localObject).newInstance(new Object[] { paramPTSAppInstance });
      }
      catch (Exception localException1)
      {
        try
        {
          ((PTSNodeVirtual)localObject).setViewID(paramPTSNodeInfo.getAttributes().getViewID());
          PTSTimeCostUtil.end("[buildVirtualNode]-" + paramPTSNodeInfo.getUniqueID());
          paramPTSNodeInfo = (PTSNodeInfo)localObject;
          if (localObject != null) {
            break;
          }
          if (!PTSLog.isDebug()) {
            break label247;
          }
          throw new IllegalArgumentException("[buildVirtualNode] error, the node type constructor does not exist, key = " + str);
        }
        catch (Exception localException2)
        {
          break label188;
        }
        localException1 = localException1;
        localObject = null;
      }
      label188:
      PTSLog.e("PTSNodeFactory", "[buildVirtualNode] error, e = " + localException1);
      if (PTSLog.isDebug())
      {
        throw new IllegalArgumentException("[buildVirtualNode] error, the node type constructor does not exist, key = " + str);
        label247:
        return new PTSNodeView(paramPTSAppInstance);
        localObject = null;
      }
    }
  }
  
  public static PTSNodeVirtual buildVirtualNodeBFS(PTSNodeInfo paramPTSNodeInfo, PTSAppInstance paramPTSAppInstance, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((paramPTSNodeInfo == null) || (paramPTSAppInstance == null))
    {
      PTSLog.e("PTSNodeFactory", "can not buildVirtualNodeBFS, nodeInfo or appInstance is null.");
      localObject = null;
    }
    HashMap localHashMap;
    LinkedList localLinkedList;
    do
    {
      return localObject;
      localHashMap = new HashMap();
      localLinkedList = new LinkedList();
      localLinkedList.add(paramPTSNodeInfo);
      paramPTSNodeInfo = null;
      localObject = paramPTSNodeInfo;
    } while (localLinkedList.isEmpty());
    PTSNodeInfo localPTSNodeInfo = (PTSNodeInfo)localLinkedList.remove();
    PTSNodeVirtual localPTSNodeVirtual = buildVirtualNode(localPTSNodeInfo, paramPTSAppInstance);
    String str = localPTSNodeInfo.getAttributes().getViewID();
    Object localObject = paramPTSNodeInfo;
    if (paramPTSNodeInfo == null) {
      localObject = localPTSNodeVirtual;
    }
    if (localPTSNodeVirtual == null)
    {
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentNode is null.");
      throw new IllegalArgumentException("[buildVirtualNodeBFS], currentNode is null.");
    }
    if (localPTSNodeInfo.hasParent())
    {
      paramPTSNodeInfo = (PTSNodeVirtual)localHashMap.get(localPTSNodeInfo.getParentID());
      if (paramPTSNodeInfo != null) {
        paramPTSNodeInfo.addChild(localPTSNodeVirtual);
      }
    }
    else
    {
      label150:
      localHashMap.put(localPTSNodeInfo.getUniqueID(), localPTSNodeVirtual);
      if (TextUtils.isEmpty(str)) {
        break label220;
      }
      if (paramHashMap != null) {
        addToListMap(str, localPTSNodeVirtual, paramHashMap);
      }
    }
    for (;;)
    {
      paramPTSNodeInfo = (PTSNodeInfo)localObject;
      if (!localPTSNodeInfo.isContainer()) {
        break;
      }
      localLinkedList.addAll(localPTSNodeInfo.getChildren());
      paramPTSNodeInfo = (PTSNodeInfo)localObject;
      break;
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], parentNode is null.");
      break label150;
      label220:
      PTSLog.e("PTSNodeFactory", "[buildVirtualNodeBFS], currentViewID is null.");
    }
  }
  
  public static float[] getCustomTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    float[] arrayOfFloat = new float[2];
    if (!TextUtils.isEmpty(paramString5))
    {
      paramString5 = getKey("text", paramString5);
      Object localObject = (Constructor)sNodeConstructors.get(paramString5);
      if (localObject != null)
      {
        try
        {
          localObject = (PTSNodeVirtual)((Constructor)localObject).newInstance(new Object[] { null });
          paramArrayOfFloat = (float[])localObject.getClass().getMethod("getTextMeasuredSize", new Class[] { [F.class, String.class, String.class, String.class, String.class }).invoke(localObject, new Object[] { paramArrayOfFloat, paramString1, paramString2, paramString3, paramString4 });
          if ((paramArrayOfFloat != null) && (paramArrayOfFloat.length >= 2))
          {
            arrayOfFloat[0] = paramArrayOfFloat[0];
            arrayOfFloat[1] = paramArrayOfFloat[1];
            return arrayOfFloat;
          }
          PTSLog.e("PTSNodeFactory", "[getCustomTextMeasuredSize] failed, measuredSize is not valid, key = " + paramString5);
          return arrayOfFloat;
        }
        catch (Exception paramArrayOfFloat)
        {
          PTSLog.e("PTSNodeFactory", "[getCustomTextMeasuredSize] error, e = " + paramArrayOfFloat);
          if (!PTSLog.isDebug()) {
            break label292;
          }
        }
        throw new IllegalArgumentException("[getCustomTextMeasuredSize] error, the node type constructor does not exist, key = " + paramString5);
      }
      else if (PTSLog.isDebug())
      {
        throw new IllegalArgumentException("[getCustomTextMeasuredSize] error, the node type constructor does not exist, key = " + paramString5);
      }
    }
    label292:
    return arrayOfFloat;
  }
  
  private static String getKey(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (!TextUtils.isEmpty(paramString2)) {
      str = paramString1 + "-" + paramString2;
    }
    return str;
  }
  
  public static Constructor<? extends View> getNodeViewConstructor(Class<? extends PTSNodeVirtual> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    paramClass = paramClass.getName();
    return (Constructor)sNodeViewConstructors.get(paramClass);
  }
  
  private static PTSNodeVirtual getReusableNodeFromListMap(String paramString, HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null)) {
      return null;
    }
    paramString = (List)paramHashMap.get(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {
      return null;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      paramHashMap = (PTSNodeVirtual)paramString.next();
      if ((paramHashMap != null) && (paramHashMap.getReusable())) {
        return paramHashMap;
      }
    }
    return null;
  }
  
  public static float[] getTextMeasuredSize(float[] paramArrayOfFloat, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < 2))
    {
      PTSLog.e("PTSNodeFactory", "[getTextMeasuredSize] constrainedSize is not valid.");
      return paramArrayOfFloat;
    }
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setAntiAlias(true);
    float f1 = PTSValueConvertUtil.dp2px(PTSValueConvertUtil.getFloat(paramString2));
    localTextPaint.setTextSize(f1);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramArrayOfFloat[0];
    arrayOfFloat[1] = paramArrayOfFloat[1];
    float f2 = PTSValueConvertUtil.dp2px(PTSNodeTextBase.getLineSpacing(PTSValueConvertUtil.getFloat(paramString3), PTSValueConvertUtil.getFloat(paramString2)));
    int j = PTSValueConvertUtil.getInt(paramString4);
    int k = (int)PTSDeviceUtil.dp2px(Math.min(paramArrayOfFloat[0], PTSDeviceUtil.getScreenWidthDp()));
    int i;
    if (TextUtils.isEmpty(paramString1))
    {
      i = 0;
      if (Build.VERSION.SDK_INT < 23) {
        break label366;
      }
      paramArrayOfFloat = StaticLayout.Builder.obtain(paramString1, 0, i, localTextPaint, k).setEllipsizedWidth(k).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(j).setLineSpacing(f2, 1.0F).setText(paramString1).setEllipsize(TextUtils.TruncateAt.END).build();
    }
    for (;;)
    {
      f2 = PTSDeviceUtil.px2dp(Layout.getDesiredWidth(paramString1, localTextPaint));
      float f3 = PTSDeviceUtil.px2dp(paramArrayOfFloat.getWidth());
      float f4 = PTSDeviceUtil.px2dp(paramArrayOfFloat.getHeight());
      f1 = PTSDeviceUtil.px2dp(PTSNodeTextBase.getHeightOffset(f1, paramArrayOfFloat.getLineCount()));
      arrayOfFloat[0] = Math.min(f2, f3);
      arrayOfFloat[1] = (f4 + f1);
      if (PTSLog.isDebug()) {
        PTSLog.i("PTSNodeFactory", "[getTextMeasuredSizeImpNew], measuredWidth = " + arrayOfFloat[0] + ", measureHeight = " + arrayOfFloat[1] + ", content = " + paramString1 + ", fontSize = " + paramString2 + ", lineHeight = " + paramString3 + ", lineClamp = " + paramString4 + ", layoutHeightOffset = " + f1 + ", actualLineCount = " + paramArrayOfFloat.getLineCount());
      }
      return arrayOfFloat;
      i = paramString1.length();
      break;
      label366:
      paramArrayOfFloat = new StaticLayout(paramString1, 0, i, localTextPaint, k, Layout.Alignment.ALIGN_NORMAL, 1.0F, f2, false, TextUtils.TruncateAt.END, k);
      try
      {
        Object localObject1 = paramArrayOfFloat.getClass();
        Field localField1 = ((Class)localObject1).getDeclaredField("mMaximumVisibleLineCount");
        localField1.setAccessible(true);
        localField1.set(paramArrayOfFloat, Integer.valueOf(j));
        localField1 = ((Class)localObject1).getDeclaredField("mFontMetricsInt");
        localField1.setAccessible(true);
        localField1.set(paramArrayOfFloat, new Paint.FontMetricsInt());
        Object localObject2 = Class.forName("android.text.TextDirectionHeuristic");
        Field localField2 = Class.forName("android.text.TextDirectionHeuristics").getDeclaredField("FIRSTSTRONG_LTR");
        localField2.setAccessible(true);
        Method localMethod = ((Class)localObject1).getDeclaredMethod("prepare", new Class[0]);
        localObject2 = ((Class)localObject1).getDeclaredMethod("generate", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, localObject2, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, TextUtils.TruncateAt.class });
        localObject1 = ((Class)localObject1).getDeclaredMethod("finish", new Class[0]);
        localMethod.setAccessible(true);
        ((Method)localObject2).setAccessible(true);
        ((Method)localObject1).setAccessible(true);
        localMethod.invoke(paramArrayOfFloat, new Object[0]);
        ((Method)localObject2).invoke(paramArrayOfFloat, new Object[] { paramString1, Integer.valueOf(0), Integer.valueOf(i), localTextPaint, Integer.valueOf(k), localField2.get(null), Float.valueOf(1.0F), Float.valueOf(f2), Boolean.valueOf(false), Boolean.valueOf(false), Float.valueOf(k), TextUtils.TruncateAt.END });
        ((Method)localObject1).invoke(paramArrayOfFloat, new Object[0]);
        localField1.set(paramArrayOfFloat, null);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localNoSuchFieldException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localIllegalAccessException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localNoSuchMethodException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] e = " + localInvocationTargetException);
        PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew] trace = " + localInvocationTargetException.getTargetException());
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        PTSLog.e("PTSNodeFactory", "[getTextMeasuredSizeImpNew], e = " + localClassNotFoundException);
      }
    }
  }
  
  private static void hideAllNodeOfListMap(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.hideNode();
          }
        }
      }
    }
  }
  
  private static void makeAllNodeReusableOfListMap(HashMap<String, List<PTSNodeVirtual>> paramHashMap)
  {
    paramHashMap = paramHashMap.values().iterator();
    while (paramHashMap.hasNext())
    {
      Object localObject = (List)paramHashMap.next();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PTSNodeVirtual localPTSNodeVirtual = (PTSNodeVirtual)((Iterator)localObject).next();
          if (localPTSNodeVirtual != null) {
            localPTSNodeVirtual.setReusable(true);
          }
        }
      }
    }
  }
  
  public static void registerCustomViewNodeVirtual(String paramString1, String paramString2, Class<? extends PTSNodeVirtual> paramClass)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramClass == null)) {
      return;
    }
    registerNodeVirtualImp(getKey(paramString1, paramString2), paramClass);
  }
  
  public static void registerNodeVirtual(String paramString, Class<? extends PTSNodeVirtual> paramClass)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramClass == null)) {
      return;
    }
    registerNodeVirtualImp(paramString, paramClass);
  }
  
  private static void registerNodeVirtualImp(String paramString, Class<? extends PTSNodeVirtual> paramClass)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramClass == null)) {
      return;
    }
    PTSLog.i("PTSNodeFactory", "[registerNodeVirtualImp] key = " + paramString + ", class = " + paramClass.getName());
    try
    {
      Constructor localConstructor = paramClass.getDeclaredConstructor(new Class[] { PTSAppInstance.class });
      localConstructor.setAccessible(true);
      sNodeConstructors.put(paramString, localConstructor);
      paramString = paramClass.getName();
      try
      {
        localConstructor = ((Class)((java.lang.reflect.ParameterizedType)paramClass.getGenericSuperclass()).getActualTypeArguments()[0]).getDeclaredConstructor(new Class[] { paramClass });
        localConstructor.setAccessible(true);
        sNodeViewConstructors.put(paramString, localConstructor);
        return;
      }
      catch (Exception paramString)
      {
        if (!PTSLog.isDebug()) {
          break label269;
        }
      }
      throw new IllegalArgumentException("[registerNodeVirtual] register view constructor error, e = " + paramString + ", clz = " + paramClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        if (PTSLog.isDebug()) {
          throw new IllegalArgumentException("[registerNodeVirtual] register node constructor error, e = " + localNoSuchMethodException + ", clz = " + paramClass);
        }
        PTSLog.e("PTSNodeFactory", "[registerNodeVirtualImp] error, e = " + localNoSuchMethodException + ", key = " + paramString + ", class = " + paramClass.getName());
      }
      label269:
      PTSLog.e("PTSNodeFactory", "[registerNodeVirtualImp] error, e = " + paramString + ", clz = " + paramClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.PTSNodeFactory
 * JD-Core Version:    0.7.0.1
 */