package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EnumUtils
{
  private static final String CANNOT_STORE_S_S_VALUES_IN_S_BITS = "Cannot store %s %s values in %s bits";
  private static final String ENUM_CLASS_MUST_BE_DEFINED = "EnumClass must be defined.";
  private static final String NULL_ELEMENTS_NOT_PERMITTED = "null elements not permitted";
  private static final String S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE = "%s does not seem to be an Enum type";
  
  private static <E extends Enum<E>> Class<E> asEnum(Class<E> paramClass)
  {
    Validate.notNull(paramClass, "EnumClass must be defined.", new Object[0]);
    Validate.isTrue(paramClass.isEnum(), "%s does not seem to be an Enum type", new Object[] { paramClass });
    return paramClass;
  }
  
  private static <E extends Enum<E>> Class<E> checkBitVectorable(Class<E> paramClass)
  {
    Enum[] arrayOfEnum = (Enum[])asEnum(paramClass).getEnumConstants();
    if (arrayOfEnum.length <= 64) {}
    for (boolean bool = true;; bool = false)
    {
      Validate.isTrue(bool, "Cannot store %s %s values in %s bits", new Object[] { Integer.valueOf(arrayOfEnum.length), paramClass.getSimpleName(), Integer.valueOf(64) });
      return paramClass;
    }
  }
  
  public static <E extends Enum<E>> long generateBitVector(Class<E> paramClass, Iterable<? extends E> paramIterable)
  {
    checkBitVectorable(paramClass);
    Validate.notNull(paramIterable);
    paramClass = paramIterable.iterator();
    long l = 0L;
    if (paramClass.hasNext())
    {
      paramIterable = (Enum)paramClass.next();
      if (paramIterable != null) {}
      for (boolean bool = true;; bool = false)
      {
        Validate.isTrue(bool, "null elements not permitted", new Object[0]);
        l = 1 << paramIterable.ordinal() | l;
        break;
      }
    }
    return l;
  }
  
  public static <E extends Enum<E>> long generateBitVector(Class<E> paramClass, E... paramVarArgs)
  {
    Validate.noNullElements(paramVarArgs);
    return generateBitVector(paramClass, Arrays.asList(paramVarArgs));
  }
  
  public static <E extends Enum<E>> long[] generateBitVectors(Class<E> paramClass, Iterable<? extends E> paramIterable)
  {
    asEnum(paramClass);
    Validate.notNull(paramIterable);
    Object localObject = EnumSet.noneOf(paramClass);
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      Enum localEnum = (Enum)paramIterable.next();
      if (localEnum != null) {}
      for (boolean bool = true;; bool = false)
      {
        Validate.isTrue(bool, "null elements not permitted", new Object[0]);
        ((EnumSet)localObject).add(localEnum);
        break;
      }
    }
    paramClass = new long[(((Enum[])paramClass.getEnumConstants()).length - 1) / 64 + 1];
    paramIterable = ((EnumSet)localObject).iterator();
    while (paramIterable.hasNext())
    {
      localObject = (Enum)paramIterable.next();
      int i = ((Enum)localObject).ordinal() / 64;
      paramClass[i] |= 1 << ((Enum)localObject).ordinal() % 64;
    }
    ArrayUtils.reverse(paramClass);
    return paramClass;
  }
  
  public static <E extends Enum<E>> long[] generateBitVectors(Class<E> paramClass, E... paramVarArgs)
  {
    asEnum(paramClass);
    Validate.noNullElements(paramVarArgs);
    Object localObject = EnumSet.noneOf(paramClass);
    Collections.addAll((Collection)localObject, paramVarArgs);
    paramClass = new long[(((Enum[])paramClass.getEnumConstants()).length - 1) / 64 + 1];
    paramVarArgs = ((EnumSet)localObject).iterator();
    while (paramVarArgs.hasNext())
    {
      localObject = (Enum)paramVarArgs.next();
      int i = ((Enum)localObject).ordinal() / 64;
      paramClass[i] |= 1 << ((Enum)localObject).ordinal() % 64;
    }
    ArrayUtils.reverse(paramClass);
    return paramClass;
  }
  
  public static <E extends Enum<E>> E getEnum(Class<E> paramClass, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramClass = Enum.valueOf(paramClass, paramString);
      return paramClass;
    }
    catch (IllegalArgumentException paramClass) {}
    return null;
  }
  
  public static <E extends Enum<E>> List<E> getEnumList(Class<E> paramClass)
  {
    return new ArrayList(Arrays.asList(paramClass.getEnumConstants()));
  }
  
  public static <E extends Enum<E>> Map<String, E> getEnumMap(Class<E> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramClass = (Enum[])paramClass.getEnumConstants();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      localLinkedHashMap.put(localObject.name(), localObject);
      i += 1;
    }
    return localLinkedHashMap;
  }
  
  public static <E extends Enum<E>> boolean isValidEnum(Class<E> paramClass, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    try
    {
      Enum.valueOf(paramClass, paramString);
      return true;
    }
    catch (IllegalArgumentException paramClass) {}
    return false;
  }
  
  public static <E extends Enum<E>> EnumSet<E> processBitVector(Class<E> paramClass, long paramLong)
  {
    checkBitVectorable(paramClass).getEnumConstants();
    return processBitVectors(paramClass, new long[] { paramLong });
  }
  
  public static <E extends Enum<E>> EnumSet<E> processBitVectors(Class<E> paramClass, long... paramVarArgs)
  {
    EnumSet localEnumSet = EnumSet.noneOf(asEnum(paramClass));
    paramVarArgs = ArrayUtils.clone((long[])Validate.notNull(paramVarArgs));
    ArrayUtils.reverse(paramVarArgs);
    paramClass = (Enum[])paramClass.getEnumConstants();
    int j = paramClass.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramClass[i];
      int k = localObject.ordinal() / 64;
      if ((k < paramVarArgs.length) && ((paramVarArgs[k] & 1 << localObject.ordinal() % 64) != 0L)) {
        localEnumSet.add(localObject);
      }
      i += 1;
    }
    return localEnumSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.EnumUtils
 * JD-Core Version:    0.7.0.1
 */