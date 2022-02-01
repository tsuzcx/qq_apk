package com.tencent.thumbplayer.adapter.strategy.utils;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils.OptionIdMapping;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.tplayer.TPOptionalIDInternal;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TPNativeKeyMapUtil
{
  private static final String REVERSE_MAP_NAME_SUFFIX = ".reverseMap";
  private static final String TAG = "TPNativeKeyMapUtil";
  private static final AtomicBoolean sHasOptionalIdMapInit = new AtomicBoolean(false);
  private static final Map<Class<?>, AtomicBoolean> sHasThisAnnotationInitMap;
  private static final Map<String, Map<Number, Number>> sNameToMap = new ConcurrentHashMap();
  private static final SparseArray<String> sOptionalIdKeyToNameMap;
  private static final SparseArray<TPThumbPlayerUtils.OptionIdMapping> sToNativeOptionalIdMap;
  
  static
  {
    sHasThisAnnotationInitMap = new ConcurrentHashMap();
    sToNativeOptionalIdMap = new SparseArray();
    sOptionalIdKeyToNameMap = new SparseArray();
  }
  
  private static <T extends Annotation> void buildBiDirectionMapForAnnotation(Class<T> paramClass)
    throws IllegalArgumentException, IllegalStateException
  {
    TPLogUtil.i("TPNativeKeyMapUtil", "buildBiDirectionMapForAnnotation, clazz=" + paramClass);
    label135:
    for (;;)
    {
      AtomicBoolean localAtomicBoolean;
      synchronized (sHasThisAnnotationInitMap)
      {
        localAtomicBoolean = (AtomicBoolean)sHasThisAnnotationInitMap.get(paramClass);
        if (localAtomicBoolean != null) {
          break label135;
        }
        localAtomicBoolean = new AtomicBoolean(false);
        sHasThisAnnotationInitMap.put(paramClass, localAtomicBoolean);
      }
      try
      {
        if (localAtomicBoolean.get())
        {
          TPLogUtil.i("TPNativeKeyMapUtil", "className=" + paramClass.getSimpleName() + " already init");
          return;
          paramClass = finally;
          throw paramClass;
        }
        searchClassToFillMap(paramClass);
        localAtomicBoolean.set(true);
        return;
      }
      finally {}
    }
  }
  
  private static void buildNativeInitConfigMap()
  {
    for (;;)
    {
      int i;
      try
      {
        Class localClass = Class.forName(TPOptionalID.class.getName());
        Field[] arrayOfField = localClass.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localField = arrayOfField[i];
          if (!localField.getType().toString().equals("int")) {
            break label170;
          }
          localMapInitConfig = (TPNativeKeyMap.MapInitConfig)localField.getAnnotation(TPNativeKeyMap.MapInitConfig.class);
          if (localMapInitConfig == null) {
            break label170;
          }
          k = localField.getInt(localClass);
          sOptionalIdKeyToNameMap.put(k, localMapInitConfig.keyName());
          if (localMapInitConfig.value() != -1) {
            continue;
          }
          sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping());
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Field localField;
        TPNativeKeyMap.MapInitConfig localMapInitConfig;
        int k;
        TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
        return;
        localField.setAccessible(true);
        sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping(localMapInitConfig.type(), localMapInitConfig.value()));
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
        return;
      }
      label170:
      i += 1;
    }
  }
  
  private static void buildNativeOptionalIdToMapInternal(Class<?> paramClass)
  {
    for (;;)
    {
      int i;
      Field localField;
      TPNativeKeyMap.MapOptionalId localMapOptionalId;
      int k;
      try
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localField = arrayOfField[i];
          if (!localField.getType().toString().equals("int")) {
            break label150;
          }
          localMapOptionalId = (TPNativeKeyMap.MapOptionalId)localField.getAnnotation(TPNativeKeyMap.MapOptionalId.class);
          if (localMapOptionalId == null) {
            break label150;
          }
          k = localField.getInt(paramClass);
          sOptionalIdKeyToNameMap.put(k, localMapOptionalId.keyName());
          if (localMapOptionalId.value() != -1) {
            break label116;
          }
          sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping());
        }
      }
      catch (IllegalAccessException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
      }
      return;
      label116:
      localField.setAccessible(true);
      sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping(localMapOptionalId.type(), localMapOptionalId.value()));
      label150:
      i += 1;
    }
  }
  
  private static void buildOptionalIdMap()
  {
    synchronized (sHasOptionalIdMapInit)
    {
      if (sToNativeOptionalIdMap.size() != 0) {
        return;
      }
      if (sHasOptionalIdMapInit.get()) {
        throw new IllegalStateException("构建Map错误，请查看【--keep class com.tencent.thumbplayer.api.** { *; }】是否加入反混淆");
      }
    }
    buildNativeInitConfigMap();
    buildPublicToNativeOptionalIdMap();
    buildPrivateToNativeOptionalIdMap();
    sHasOptionalIdMapInit.set(true);
  }
  
  private static void buildPrivateToNativeOptionalIdMap()
  {
    try
    {
      buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalIDInternal.class.getName()));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
  }
  
  private static void buildPublicToNativeOptionalIdMap()
  {
    try
    {
      buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalID.class.getName()));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
  }
  
  private static <T extends Annotation> void checkFillMapValidity(Class<T> paramClass, Map<Number, Number> paramMap1, Map<Number, Number> paramMap2, Class<?> paramClass1, Number paramNumber1, Number paramNumber2)
    throws IllegalStateException
  {
    if (paramMap1.containsKey(paramNumber2)) {
      throw new IllegalStateException(paramClass1.getName() + " 配置了重复的成员变量，注解=" + paramClass.getName() + " 成员变量值=" + paramNumber2 + " 请查找一下使用这个注解@" + paramClass.getName() + "的哪两个成员变量值相等");
    }
    if (paramMap2.containsKey(paramNumber1)) {
      throw new IllegalStateException(paramClass1.getName() + " 配置了重复的注解值，注解=" + paramClass.getName() + " 成员变量值=" + paramNumber2 + " 请查找一下@" + paramClass.getName() + "(这个值)在哪里重复了");
    }
  }
  
  public static TPThumbPlayerUtils.OptionIdMapping convertToNativeOptionalId(@TPCommonEnum.TPOptionalId int paramInt)
  {
    if (sToNativeOptionalIdMap.size() == 0) {
      buildOptionalIdMap();
    }
    return (TPThumbPlayerUtils.OptionIdMapping)sToNativeOptionalIdMap.get(paramInt, new TPThumbPlayerUtils.OptionIdMapping());
  }
  
  public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfToNativeMap(Class<T> paramClass)
  {
    return new HashSet(getMapForAnnotation(paramClass, true).entrySet());
  }
  
  public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfToTPMap(Class<T> paramClass)
  {
    return new HashSet(getMapForAnnotation(paramClass, false).entrySet());
  }
  
  private static <T extends Annotation> Map<Number, Number> getMapForAnnotation(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException, IllegalStateException
  {
    String str = getMapKey(paramClass, paramBoolean);
    Map localMap = (Map)sNameToMap.get(str);
    if ((localMap == null) || (localMap.size() == 0))
    {
      buildBiDirectionMapForAnnotation(paramClass);
      localMap = (Map)sNameToMap.get(str);
    }
    for (;;)
    {
      if ((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class) == null) {
        throw new IllegalArgumentException(paramClass.getSimpleName() + "has not SearchConfig annotation");
      }
      if ((localMap == null) || (localMap.size() == 0)) {
        throw new IllegalStateException(paramClass.getSimpleName() + " is null after buildBiDirectionMap");
      }
      return localMap;
    }
  }
  
  private static <T extends Annotation> String getMapKey(Class<T> paramClass, boolean paramBoolean)
  {
    paramClass = paramClass.getCanonicalName();
    if (paramBoolean) {
      return paramClass;
    }
    return paramClass + ".reverseMap";
  }
  
  public static String getOptionalIdName(int paramInt)
  {
    if (!sHasOptionalIdMapInit.get()) {
      buildOptionalIdMap();
    }
    return (String)sOptionalIdKeyToNameMap.get(paramInt, "");
  }
  
  public static void init()
    throws IllegalStateException
  {
    long l1 = System.currentTimeMillis();
    Class[] arrayOfClass = TPNativeKeyMap.class.getDeclaredClasses();
    TPLogUtil.i("TPNativeKeyMapUtil", "init BiDirectionMap for tp&native value");
    int j = arrayOfClass.length;
    int i = 0;
    if (i < j)
    {
      Class localClass = arrayOfClass[i];
      if (!localClass.isAnnotation()) {}
      for (;;)
      {
        i += 1;
        break;
        if ((Modifier.isPublic(localClass.getModifiers())) && ((TPNativeKeyMap.SearchConfig)localClass.getAnnotation(TPNativeKeyMap.SearchConfig.class) != null)) {
          buildBiDirectionMapForAnnotation(localClass);
        }
      }
    }
    long l2 = System.currentTimeMillis();
    TPLogUtil.i("TPNativeKeyMapUtil", "init cost time=" + (l2 - l1));
  }
  
  private static <T extends Annotation> void searchClassToFillMap(Class<T> paramClass)
    throws IllegalArgumentException, IllegalStateException
  {
    Object localObject4 = getMapKey(paramClass, true);
    Object localObject2 = (Map)sNameToMap.get(localObject4);
    Object localObject1 = getMapKey(paramClass, false);
    Object localObject3 = (Map)sNameToMap.get(localObject1);
    if ((localObject2 == null) || (localObject3 == null))
    {
      localObject2 = new ConcurrentHashMap();
      sNameToMap.put(localObject4, localObject2);
      localObject3 = new ConcurrentHashMap();
      sNameToMap.put(localObject1, localObject3);
    }
    for (;;)
    {
      TPNativeKeyMap.SearchConfig localSearchConfig;
      Class localClass;
      int i;
      Method localMethod;
      try
      {
        localSearchConfig = (TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class);
        if (localSearchConfig == null) {
          throw new IllegalArgumentException(paramClass.getCanonicalName() + "has not SearchConfig annotation");
        }
      }
      catch (IllegalAccessException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
        return;
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass + " toNativeMap.size=" + ((Map)localObject2).size() + " toTPMap.size=" + ((Map)localObject3).size());
        continue;
        localClass = localSearchConfig.searchClass();
        Field[] arrayOfField = localClass.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        localObject4 = arrayOfField[i];
        localObject1 = "";
        if (localSearchConfig.valueClass() == Integer.TYPE)
        {
          localObject1 = "int";
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          throw new IllegalArgumentException("代码还没实现对" + localSearchConfig.valueClass().getName() + "的支持");
        }
      }
      catch (NoSuchMethodException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
        throw new IllegalStateException("com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap下所有元素需要加到混淆中, 并且每个MapXXX注解需要有value方法");
        if (localSearchConfig.valueClass() != Long.TYPE) {
          continue;
        }
        localObject1 = "long";
        continue;
        if (!((Field)localObject4).getType().toString().equals(localObject1)) {
          break label570;
        }
        localObject1 = ((Field)localObject4).getAnnotation(paramClass);
        if (localObject1 == null) {
          break label570;
        }
        ((Field)localObject4).setAccessible(true);
        localMethod = paramClass.getDeclaredMethod("value", new Class[0]);
        localMethod.setAccessible(true);
        if (localSearchConfig.valueClass() == Integer.TYPE)
        {
          localObject1 = (Integer)localMethod.invoke(localObject1, new Object[0]);
          localObject4 = Integer.valueOf(((Field)localObject4).getInt(localClass));
          checkFillMapValidity(paramClass, (Map)localObject2, (Map)localObject3, localClass, (Number)localObject1, (Number)localObject4);
          ((Map)localObject2).put(localObject4, localObject1);
          ((Map)localObject3).put(localObject1, localObject4);
        }
      }
      catch (InvocationTargetException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
        return;
      }
      if (localSearchConfig.valueClass() == Long.TYPE)
      {
        localObject1 = (Long)localMethod.invoke(localObject1, new Object[0]);
        localObject4 = Long.valueOf(((Field)localObject4).getLong(localClass));
      }
      else
      {
        throw new IllegalArgumentException("代码还没实现对" + localSearchConfig.valueClass().getName() + "的支持");
        label570:
        i += 1;
      }
    }
  }
  
  public static <T extends Annotation> int toNativeIntValue(Class<T> paramClass, int paramInt)
  {
    Map localMap = getMapForAnnotation(paramClass, true);
    if (!localMap.containsKey(Integer.valueOf(paramInt)))
    {
      TPLogUtil.e("TPNativeKeyMapUtil", "toNativeValue, tpValue=" + paramInt + "return default value, clazz" + paramClass);
      return (int)((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }
    return ((Number)localMap.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public static <T extends Annotation> long toNativeLongValue(Class<T> paramClass, long paramLong)
  {
    Map localMap = getMapForAnnotation(paramClass, true);
    if (!localMap.containsKey(Long.valueOf(paramLong)))
    {
      TPLogUtil.e("TPNativeKeyMapUtil", "toNativeValue, tpValue=" + paramLong + "return default value, clazz" + paramClass);
      return ((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }
    return ((Number)localMap.get(Long.valueOf(paramLong))).longValue();
  }
  
  public static <T extends Annotation> int toTPIntValue(Class<T> paramClass, int paramInt)
    throws IllegalArgumentException, IllegalStateException
  {
    Map localMap = getMapForAnnotation(paramClass, false);
    if (!localMap.containsKey(Integer.valueOf(paramInt)))
    {
      TPLogUtil.i("TPNativeKeyMapUtil", "toTPValue, nativeValue=" + paramInt + "return default value, clazz" + paramClass);
      return (int)((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }
    return ((Number)localMap.get(Integer.valueOf(paramInt))).intValue();
  }
  
  public static <T extends Annotation> long toTPLongValue(Class<T> paramClass, long paramLong)
    throws IllegalArgumentException, IllegalStateException
  {
    Map localMap = getMapForAnnotation(paramClass, false);
    if (!localMap.containsKey(Long.valueOf(paramLong)))
    {
      TPLogUtil.i("TPNativeKeyMapUtil", "toTPValue, nativeValue=" + paramLong + "return default value, clazz" + paramClass);
      return ((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }
    return ((Number)localMap.get(Long.valueOf(paramLong))).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil
 * JD-Core Version:    0.7.0.1
 */