package kotlin.jvm.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableIterable;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.jvm.internal.markers.KMutableMap.Entry;
import kotlin.jvm.internal.markers.KMutableSet;

public class TypeIntrinsics
{
  public static Collection asMutableCollection(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableCollection))) {
      throwCce(paramObject, "kotlin.collections.MutableCollection");
    }
    return castToCollection(paramObject);
  }
  
  public static Collection asMutableCollection(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableCollection))) {
      throwCce(paramString);
    }
    return castToCollection(paramObject);
  }
  
  public static Iterable asMutableIterable(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableIterable))) {
      throwCce(paramObject, "kotlin.collections.MutableIterable");
    }
    return castToIterable(paramObject);
  }
  
  public static Iterable asMutableIterable(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableIterable))) {
      throwCce(paramString);
    }
    return castToIterable(paramObject);
  }
  
  public static Iterator asMutableIterator(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableIterator))) {
      throwCce(paramObject, "kotlin.collections.MutableIterator");
    }
    return castToIterator(paramObject);
  }
  
  public static Iterator asMutableIterator(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableIterator))) {
      throwCce(paramString);
    }
    return castToIterator(paramObject);
  }
  
  public static List asMutableList(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableList))) {
      throwCce(paramObject, "kotlin.collections.MutableList");
    }
    return castToList(paramObject);
  }
  
  public static List asMutableList(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableList))) {
      throwCce(paramString);
    }
    return castToList(paramObject);
  }
  
  public static ListIterator asMutableListIterator(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableListIterator))) {
      throwCce(paramObject, "kotlin.collections.MutableListIterator");
    }
    return castToListIterator(paramObject);
  }
  
  public static ListIterator asMutableListIterator(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableListIterator))) {
      throwCce(paramString);
    }
    return castToListIterator(paramObject);
  }
  
  public static Map asMutableMap(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableMap))) {
      throwCce(paramObject, "kotlin.collections.MutableMap");
    }
    return castToMap(paramObject);
  }
  
  public static Map asMutableMap(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableMap))) {
      throwCce(paramString);
    }
    return castToMap(paramObject);
  }
  
  public static Map.Entry asMutableMapEntry(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableMap.Entry))) {
      throwCce(paramObject, "kotlin.collections.MutableMap.MutableEntry");
    }
    return castToMapEntry(paramObject);
  }
  
  public static Map.Entry asMutableMapEntry(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableMap.Entry))) {
      throwCce(paramString);
    }
    return castToMapEntry(paramObject);
  }
  
  public static Set asMutableSet(Object paramObject)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableSet))) {
      throwCce(paramObject, "kotlin.collections.MutableSet");
    }
    return castToSet(paramObject);
  }
  
  public static Set asMutableSet(Object paramObject, String paramString)
  {
    if (((paramObject instanceof KMappedMarker)) && (!(paramObject instanceof KMutableSet))) {
      throwCce(paramString);
    }
    return castToSet(paramObject);
  }
  
  public static Object beforeCheckcastToFunctionOfArity(Object paramObject, int paramInt)
  {
    if ((paramObject != null) && (!isFunctionOfArity(paramObject, paramInt))) {
      throwCce(paramObject, "kotlin.jvm.functions.Function" + paramInt);
    }
    return paramObject;
  }
  
  public static Object beforeCheckcastToFunctionOfArity(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject != null) && (!isFunctionOfArity(paramObject, paramInt))) {
      throwCce(paramString);
    }
    return paramObject;
  }
  
  public static Collection castToCollection(Object paramObject)
  {
    try
    {
      paramObject = (Collection)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static Iterable castToIterable(Object paramObject)
  {
    try
    {
      paramObject = (Iterable)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static Iterator castToIterator(Object paramObject)
  {
    try
    {
      paramObject = (Iterator)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static List castToList(Object paramObject)
  {
    try
    {
      paramObject = (List)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static ListIterator castToListIterator(Object paramObject)
  {
    try
    {
      paramObject = (ListIterator)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static Map castToMap(Object paramObject)
  {
    try
    {
      paramObject = (Map)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static Map.Entry castToMapEntry(Object paramObject)
  {
    try
    {
      paramObject = (Map.Entry)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static Set castToSet(Object paramObject)
  {
    try
    {
      paramObject = (Set)paramObject;
      return paramObject;
    }
    catch (ClassCastException paramObject)
    {
      throw throwCce(paramObject);
    }
  }
  
  public static int getFunctionArity(Object paramObject)
  {
    if ((paramObject instanceof FunctionBase)) {
      return ((FunctionBase)paramObject).getArity();
    }
    if ((paramObject instanceof Function0)) {
      return 0;
    }
    if ((paramObject instanceof Function1)) {
      return 1;
    }
    if ((paramObject instanceof Function2)) {
      return 2;
    }
    if ((paramObject instanceof Function3)) {
      return 3;
    }
    if ((paramObject instanceof Function4)) {
      return 4;
    }
    if ((paramObject instanceof Function5)) {
      return 5;
    }
    if ((paramObject instanceof Function6)) {
      return 6;
    }
    if ((paramObject instanceof Function7)) {
      return 7;
    }
    if ((paramObject instanceof Function8)) {
      return 8;
    }
    if ((paramObject instanceof Function9)) {
      return 9;
    }
    if ((paramObject instanceof Function10)) {
      return 10;
    }
    if ((paramObject instanceof Function11)) {
      return 11;
    }
    if ((paramObject instanceof Function12)) {
      return 12;
    }
    if ((paramObject instanceof Function13)) {
      return 13;
    }
    if ((paramObject instanceof Function14)) {
      return 14;
    }
    if ((paramObject instanceof Function15)) {
      return 15;
    }
    if ((paramObject instanceof Function16)) {
      return 16;
    }
    if ((paramObject instanceof Function17)) {
      return 17;
    }
    if ((paramObject instanceof Function18)) {
      return 18;
    }
    if ((paramObject instanceof Function19)) {
      return 19;
    }
    if ((paramObject instanceof Function20)) {
      return 20;
    }
    if ((paramObject instanceof Function21)) {
      return 21;
    }
    if ((paramObject instanceof Function22)) {
      return 22;
    }
    return -1;
  }
  
  public static boolean isFunctionOfArity(Object paramObject, int paramInt)
  {
    return ((paramObject instanceof Function)) && (getFunctionArity(paramObject) == paramInt);
  }
  
  public static boolean isMutableCollection(Object paramObject)
  {
    return ((paramObject instanceof Collection)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableCollection)));
  }
  
  public static boolean isMutableIterable(Object paramObject)
  {
    return ((paramObject instanceof Iterable)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableIterable)));
  }
  
  public static boolean isMutableIterator(Object paramObject)
  {
    return ((paramObject instanceof Iterator)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableIterator)));
  }
  
  public static boolean isMutableList(Object paramObject)
  {
    return ((paramObject instanceof List)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableList)));
  }
  
  public static boolean isMutableListIterator(Object paramObject)
  {
    return ((paramObject instanceof ListIterator)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableListIterator)));
  }
  
  public static boolean isMutableMap(Object paramObject)
  {
    return ((paramObject instanceof Map)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableMap)));
  }
  
  public static boolean isMutableMapEntry(Object paramObject)
  {
    return ((paramObject instanceof Map.Entry)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableMap.Entry)));
  }
  
  public static boolean isMutableSet(Object paramObject)
  {
    return ((paramObject instanceof Set)) && ((!(paramObject instanceof KMappedMarker)) || ((paramObject instanceof KMutableSet)));
  }
  
  private static <T extends Throwable> T sanitizeStackTrace(T paramT)
  {
    return Intrinsics.sanitizeStackTrace(paramT, TypeIntrinsics.class.getName());
  }
  
  public static ClassCastException throwCce(ClassCastException paramClassCastException)
  {
    throw ((ClassCastException)sanitizeStackTrace(paramClassCastException));
  }
  
  public static void throwCce(Object paramObject, String paramString)
  {
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().getName())
    {
      throwCce(paramObject + " cannot be cast to " + paramString);
      return;
    }
  }
  
  public static void throwCce(String paramString)
  {
    throw throwCce(new ClassCastException(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.TypeIntrinsics
 * JD-Core Version:    0.7.0.1
 */