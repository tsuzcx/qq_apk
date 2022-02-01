package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"asList", "", "T", "", "([Ljava/lang/Object;)Ljava/util/List;", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "binarySearch", "element", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "fromIndex", "toIndex", "([Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;II)I", "([Ljava/lang/Object;Ljava/lang/Object;II)I", "contentDeepEquals", "other", "contentDeepEqualsInline", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepHashCode", "contentDeepHashCodeInline", "([Ljava/lang/Object;)I", "contentDeepToString", "", "contentDeepToStringInline", "([Ljava/lang/Object;)Ljava/lang/String;", "contentEquals", "contentHashCode", "contentToString", "copyInto", "destination", "destinationOffset", "startIndex", "endIndex", "([Ljava/lang/Object;[Ljava/lang/Object;III)[Ljava/lang/Object;", "copyOf", "([Ljava/lang/Object;)[Ljava/lang/Object;", "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRange", "copyOfRangeInline", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "copyOfRangeImpl", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "fill", "", "([Ljava/lang/Object;Ljava/lang/Object;II)V", "filterIsInstance", "R", "klass", "Ljava/lang/Class;", "([Ljava/lang/Object;Ljava/lang/Class;)Ljava/util/List;", "filterIsInstanceTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "plus", "([Ljava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "elements", "([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "plusElement", "sort", "([Ljava/lang/Object;)V", "", "([Ljava/lang/Comparable;)V", "([Ljava/lang/Object;II)V", "sortWith", "([Ljava/lang/Object;Ljava/util/Comparator;)V", "([Ljava/lang/Object;Ljava/util/Comparator;II)V", "toSortedSet", "Ljava/util/SortedSet;", "([Ljava/lang/Comparable;)Ljava/util/SortedSet;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/SortedSet;", "toTypedArray", "([Z)[Ljava/lang/Boolean;", "([B)[Ljava/lang/Byte;", "([C)[Ljava/lang/Character;", "([D)[Ljava/lang/Double;", "([F)[Ljava/lang/Float;", "([I)[Ljava/lang/Integer;", "([J)[Ljava/lang/Long;", "([S)[Ljava/lang/Short;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/ArraysKt")
public class ArraysKt___ArraysJvmKt
  extends ArraysKt__ArraysKt
{
  @NotNull
  public static final List<Byte> asList(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.1(paramArrayOfByte);
  }
  
  @NotNull
  public static final List<Character> asList(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.8(paramArrayOfChar);
  }
  
  @NotNull
  public static final List<Double> asList(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.6(paramArrayOfDouble);
  }
  
  @NotNull
  public static final List<Float> asList(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.5(paramArrayOfFloat);
  }
  
  @NotNull
  public static final List<Integer> asList(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.3(paramArrayOfInt);
  }
  
  @NotNull
  public static final List<Long> asList(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.4(paramArrayOfLong);
  }
  
  @NotNull
  public static final <T> List<T> asList(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$asList");
    paramArrayOfT = ArraysUtilJVM.asList(paramArrayOfT);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "ArraysUtilJVM.asList(this)");
    return paramArrayOfT;
  }
  
  @NotNull
  public static final List<Short> asList(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.2(paramArrayOfShort);
  }
  
  @NotNull
  public static final List<Boolean> asList(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$asList");
    return (List)new ArraysKt___ArraysJvmKt.asList.7(paramArrayOfBoolean);
  }
  
  public static final int binarySearch(@NotNull byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfByte, paramInt1, paramInt2, paramByte);
  }
  
  public static final int binarySearch(@NotNull char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfChar, paramInt1, paramInt2, paramChar);
  }
  
  public static final int binarySearch(@NotNull double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfDouble, paramInt1, paramInt2, paramDouble);
  }
  
  public static final int binarySearch(@NotNull float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfFloat, paramInt1, paramInt2, paramFloat);
  }
  
  public static final int binarySearch(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfInt, paramInt2, paramInt3, paramInt1);
  }
  
  public static final int binarySearch(@NotNull long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfLong, paramInt1, paramInt2, paramLong);
  }
  
  public static final <T> int binarySearch(@NotNull T[] paramArrayOfT, T paramT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfT, paramInt1, paramInt2, paramT);
  }
  
  public static final <T> int binarySearch(@NotNull T[] paramArrayOfT, T paramT, @NotNull Comparator<? super T> paramComparator, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$binarySearch");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return Arrays.binarySearch(paramArrayOfT, paramInt1, paramInt2, paramT, paramComparator);
  }
  
  public static final int binarySearch(@NotNull short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$binarySearch");
    return Arrays.binarySearch(paramArrayOfShort, paramInt1, paramInt2, paramShort);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  @JvmName(name="contentDeepEqualsInline")
  private static final <T> boolean contentDeepEqualsInline(@NotNull T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.contentDeepEquals(paramArrayOfT1, paramArrayOfT2);
    }
    return Arrays.deepEquals(paramArrayOfT1, paramArrayOfT2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  @JvmName(name="contentDeepHashCodeInline")
  private static final <T> int contentDeepHashCodeInline(@NotNull T[] paramArrayOfT)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.contentDeepHashCode(paramArrayOfT);
    }
    return Arrays.deepHashCode(paramArrayOfT);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  @JvmName(name="contentDeepToStringInline")
  private static final <T> String contentDeepToStringInline(@NotNull T[] paramArrayOfT)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.contentDeepToString(paramArrayOfT);
    }
    paramArrayOfT = Arrays.deepToString(paramArrayOfT);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.deepToString(this)");
    return paramArrayOfT;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return Arrays.equals(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    return Arrays.equals(paramArrayOfChar1, paramArrayOfChar2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    return Arrays.equals(paramArrayOfDouble1, paramArrayOfDouble2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    return Arrays.equals(paramArrayOfFloat1, paramArrayOfFloat2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return Arrays.equals(paramArrayOfInt1, paramArrayOfInt2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> boolean contentEquals(@NotNull T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    return Arrays.equals(paramArrayOfT1, paramArrayOfT2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    return Arrays.equals(paramArrayOfShort1, paramArrayOfShort2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final boolean contentEquals(@NotNull boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    return Arrays.equals(paramArrayOfBoolean1, paramArrayOfBoolean2);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull byte[] paramArrayOfByte)
  {
    return Arrays.hashCode(paramArrayOfByte);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull char[] paramArrayOfChar)
  {
    return Arrays.hashCode(paramArrayOfChar);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull double[] paramArrayOfDouble)
  {
    return Arrays.hashCode(paramArrayOfDouble);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull float[] paramArrayOfFloat)
  {
    return Arrays.hashCode(paramArrayOfFloat);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull int[] paramArrayOfInt)
  {
    return Arrays.hashCode(paramArrayOfInt);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull long[] paramArrayOfLong)
  {
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> int contentHashCode(@NotNull T[] paramArrayOfT)
  {
    return Arrays.hashCode(paramArrayOfT);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull short[] paramArrayOfShort)
  {
    return Arrays.hashCode(paramArrayOfShort);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final int contentHashCode(@NotNull boolean[] paramArrayOfBoolean)
  {
    return Arrays.hashCode(paramArrayOfBoolean);
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.toString(paramArrayOfByte);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.toString(this)");
    return paramArrayOfByte;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull char[] paramArrayOfChar)
  {
    paramArrayOfChar = Arrays.toString(paramArrayOfChar);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.toString(this)");
    return paramArrayOfChar;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = Arrays.toString(paramArrayOfDouble);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.toString(this)");
    return paramArrayOfDouble;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Arrays.toString(paramArrayOfFloat);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.toString(this)");
    return paramArrayOfFloat;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.toString(paramArrayOfInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.toString(this)");
    return paramArrayOfInt;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.toString(paramArrayOfLong);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.toString(this)");
    return paramArrayOfLong;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> String contentToString(@NotNull T[] paramArrayOfT)
  {
    paramArrayOfT = Arrays.toString(paramArrayOfT);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.toString(this)");
    return paramArrayOfT;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.toString(paramArrayOfShort);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.toString(this)");
    return paramArrayOfShort;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String contentToString(@NotNull boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean = Arrays.toString(paramArrayOfBoolean);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.toString(this)");
    return paramArrayOfBoolean;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] copyInto(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "destination");
    System.arraycopy(paramArrayOfByte1, paramInt2, paramArrayOfByte2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfByte2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final char[] copyInto(@NotNull char[] paramArrayOfChar1, @NotNull char[] paramArrayOfChar2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar2, "destination");
    System.arraycopy(paramArrayOfChar1, paramInt2, paramArrayOfChar2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfChar2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final double[] copyInto(@NotNull double[] paramArrayOfDouble1, @NotNull double[] paramArrayOfDouble2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble2, "destination");
    System.arraycopy(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfDouble2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final float[] copyInto(@NotNull float[] paramArrayOfFloat1, @NotNull float[] paramArrayOfFloat2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat2, "destination");
    System.arraycopy(paramArrayOfFloat1, paramInt2, paramArrayOfFloat2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfFloat2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] copyInto(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "destination");
    System.arraycopy(paramArrayOfInt1, paramInt2, paramArrayOfInt2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfInt2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] copyInto(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "destination");
    System.arraycopy(paramArrayOfLong1, paramInt2, paramArrayOfLong2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfLong2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final <T> T[] copyInto(@NotNull T[] paramArrayOfT1, @NotNull T[] paramArrayOfT2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT2, "destination");
    System.arraycopy(paramArrayOfT1, paramInt2, paramArrayOfT2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfT2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] copyInto(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "destination");
    System.arraycopy(paramArrayOfShort1, paramInt2, paramArrayOfShort2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfShort2;
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final boolean[] copyInto(@NotNull boolean[] paramArrayOfBoolean1, @NotNull boolean[] paramArrayOfBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean1, "$this$copyInto");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean2, "destination");
    System.arraycopy(paramArrayOfBoolean1, paramInt2, paramArrayOfBoolean2, paramInt1, paramInt3 - paramInt2);
    return paramArrayOfBoolean2;
  }
  
  @InlineOnly
  private static final byte[] copyOf(@NotNull byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfByte;
  }
  
  @InlineOnly
  private static final byte[] copyOf(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfByte;
  }
  
  @InlineOnly
  private static final char[] copyOf(@NotNull char[] paramArrayOfChar)
  {
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramArrayOfChar.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfChar;
  }
  
  @InlineOnly
  private static final char[] copyOf(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfChar;
  }
  
  @InlineOnly
  private static final double[] copyOf(@NotNull double[] paramArrayOfDouble)
  {
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramArrayOfDouble.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfDouble;
  }
  
  @InlineOnly
  private static final double[] copyOf(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfDouble;
  }
  
  @InlineOnly
  private static final float[] copyOf(@NotNull float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramArrayOfFloat.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfFloat;
  }
  
  @InlineOnly
  private static final float[] copyOf(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfFloat;
  }
  
  @InlineOnly
  private static final int[] copyOf(@NotNull int[] paramArrayOfInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramArrayOfInt.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfInt;
  }
  
  @InlineOnly
  private static final int[] copyOf(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfInt;
  }
  
  @InlineOnly
  private static final long[] copyOf(@NotNull long[] paramArrayOfLong)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramArrayOfLong.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfLong;
  }
  
  @InlineOnly
  private static final long[] copyOf(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfLong;
  }
  
  @InlineOnly
  private static final <T> T[] copyOf(@NotNull T[] paramArrayOfT)
  {
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramArrayOfT.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfT;
  }
  
  @InlineOnly
  private static final <T> T[] copyOf(@NotNull T[] paramArrayOfT, int paramInt)
  {
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfT;
  }
  
  @InlineOnly
  private static final short[] copyOf(@NotNull short[] paramArrayOfShort)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramArrayOfShort.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfShort;
  }
  
  @InlineOnly
  private static final short[] copyOf(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfShort;
  }
  
  @InlineOnly
  private static final boolean[] copyOf(@NotNull boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramArrayOfBoolean.length);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOf(this, size)");
    return paramArrayOfBoolean;
  }
  
  @InlineOnly
  private static final boolean[] copyOf(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOf(this, newSize)");
    return paramArrayOfBoolean;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final byte[] copyOfRange(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfByte.length);
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfByte;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final char[] copyOfRange(@NotNull char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfChar.length);
    paramArrayOfChar = Arrays.copyOfRange(paramArrayOfChar, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfChar;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final double[] copyOfRange(@NotNull double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfDouble.length);
    paramArrayOfDouble = Arrays.copyOfRange(paramArrayOfDouble, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfDouble;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final float[] copyOfRange(@NotNull float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfFloat.length);
    paramArrayOfFloat = Arrays.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfFloat;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final int[] copyOfRange(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfInt.length);
    paramArrayOfInt = Arrays.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfInt;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final long[] copyOfRange(@NotNull long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfLong.length);
    paramArrayOfLong = Arrays.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfLong;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final <T> T[] copyOfRange(@NotNull T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfT.length);
    paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfT;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final short[] copyOfRange(@NotNull short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfShort.length);
    paramArrayOfShort = Arrays.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfShort;
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="copyOfRange")
  @NotNull
  public static final boolean[] copyOfRange(@NotNull boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$copyOfRangeImpl");
    ArraysKt.copyOfRangeToIndexCheck(paramInt2, paramArrayOfBoolean.length);
    paramArrayOfBoolean = Arrays.copyOfRange(paramArrayOfBoolean, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfBoolean;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final byte[] copyOfRangeInline(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfByte.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfByte.length));
    }
    paramArrayOfByte = Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfByte;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final char[] copyOfRangeInline(@NotNull char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfChar, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfChar.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfChar.length));
    }
    paramArrayOfChar = Arrays.copyOfRange(paramArrayOfChar, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfChar;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final double[] copyOfRangeInline(@NotNull double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfDouble, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfDouble.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfDouble.length));
    }
    paramArrayOfDouble = Arrays.copyOfRange(paramArrayOfDouble, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfDouble;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final float[] copyOfRangeInline(@NotNull float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfFloat.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfFloat.length));
    }
    paramArrayOfFloat = Arrays.copyOfRange(paramArrayOfFloat, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfFloat;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final int[] copyOfRangeInline(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfInt.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfInt.length));
    }
    paramArrayOfInt = Arrays.copyOfRange(paramArrayOfInt, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfInt;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final long[] copyOfRangeInline(@NotNull long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfLong.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfLong.length));
    }
    paramArrayOfLong = Arrays.copyOfRange(paramArrayOfLong, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfLong;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final <T> T[] copyOfRangeInline(@NotNull T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfT.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfT.length));
    }
    paramArrayOfT = Arrays.copyOfRange(paramArrayOfT, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfT;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final short[] copyOfRangeInline(@NotNull short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfShort.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfShort.length));
    }
    paramArrayOfShort = Arrays.copyOfRange(paramArrayOfShort, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfShort;
  }
  
  @InlineOnly
  @JvmName(name="copyOfRangeInline")
  private static final boolean[] copyOfRangeInline(@NotNull boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 3, 0)) {
      return ArraysKt.copyOfRange(paramArrayOfBoolean, paramInt1, paramInt2);
    }
    if (paramInt2 > paramArrayOfBoolean.length) {
      throw ((Throwable)new IndexOutOfBoundsException("toIndex: " + paramInt2 + ", size: " + paramArrayOfBoolean.length));
    }
    paramArrayOfBoolean = Arrays.copyOfRange(paramArrayOfBoolean, paramInt1, paramInt2);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
    return paramArrayOfBoolean;
  }
  
  @InlineOnly
  private static final byte elementAt(@NotNull byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt];
  }
  
  @InlineOnly
  private static final char elementAt(@NotNull char[] paramArrayOfChar, int paramInt)
  {
    return paramArrayOfChar[paramInt];
  }
  
  @InlineOnly
  private static final double elementAt(@NotNull double[] paramArrayOfDouble, int paramInt)
  {
    return paramArrayOfDouble[paramInt];
  }
  
  @InlineOnly
  private static final float elementAt(@NotNull float[] paramArrayOfFloat, int paramInt)
  {
    return paramArrayOfFloat[paramInt];
  }
  
  @InlineOnly
  private static final int elementAt(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    return paramArrayOfInt[paramInt];
  }
  
  @InlineOnly
  private static final long elementAt(@NotNull long[] paramArrayOfLong, int paramInt)
  {
    return paramArrayOfLong[paramInt];
  }
  
  @InlineOnly
  private static final <T> T elementAt(@NotNull T[] paramArrayOfT, int paramInt)
  {
    return paramArrayOfT[paramInt];
  }
  
  @InlineOnly
  private static final short elementAt(@NotNull short[] paramArrayOfShort, int paramInt)
  {
    return paramArrayOfShort[paramInt];
  }
  
  @InlineOnly
  private static final boolean elementAt(@NotNull boolean[] paramArrayOfBoolean, int paramInt)
  {
    return paramArrayOfBoolean[paramInt];
  }
  
  public static final void fill(@NotNull byte[] paramArrayOfByte, byte paramByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$fill");
    Arrays.fill(paramArrayOfByte, paramInt1, paramInt2, paramByte);
  }
  
  public static final void fill(@NotNull char[] paramArrayOfChar, char paramChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$fill");
    Arrays.fill(paramArrayOfChar, paramInt1, paramInt2, paramChar);
  }
  
  public static final void fill(@NotNull double[] paramArrayOfDouble, double paramDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$fill");
    Arrays.fill(paramArrayOfDouble, paramInt1, paramInt2, paramDouble);
  }
  
  public static final void fill(@NotNull float[] paramArrayOfFloat, float paramFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$fill");
    Arrays.fill(paramArrayOfFloat, paramInt1, paramInt2, paramFloat);
  }
  
  public static final void fill(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$fill");
    Arrays.fill(paramArrayOfInt, paramInt2, paramInt3, paramInt1);
  }
  
  public static final void fill(@NotNull long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$fill");
    Arrays.fill(paramArrayOfLong, paramInt1, paramInt2, paramLong);
  }
  
  public static final <T> void fill(@NotNull T[] paramArrayOfT, T paramT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$fill");
    Arrays.fill(paramArrayOfT, paramInt1, paramInt2, paramT);
  }
  
  public static final void fill(@NotNull short[] paramArrayOfShort, short paramShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$fill");
    Arrays.fill(paramArrayOfShort, paramInt1, paramInt2, paramShort);
  }
  
  public static final void fill(@NotNull boolean[] paramArrayOfBoolean, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$fill");
    Arrays.fill(paramArrayOfBoolean, paramInt1, paramInt2, paramBoolean);
  }
  
  @NotNull
  public static final <R> List<R> filterIsInstance(@NotNull Object[] paramArrayOfObject, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "$this$filterIsInstance");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    return (List)ArraysKt.filterIsInstanceTo(paramArrayOfObject, (Collection)new ArrayList(), paramClass);
  }
  
  @NotNull
  public static final <C extends Collection<? super R>, R> C filterIsInstanceTo(@NotNull Object[] paramArrayOfObject, @NotNull C paramC, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "$this$filterIsInstanceTo");
    Intrinsics.checkParameterIsNotNull(paramC, "destination");
    Intrinsics.checkParameterIsNotNull(paramClass, "klass");
    int j = paramArrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfObject[i];
      if (paramClass.isInstance(localObject)) {
        paramC.add(localObject);
      }
      i += 1;
    }
    return paramC;
  }
  
  @NotNull
  public static final byte[] plus(@NotNull byte[] paramArrayOfByte, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$plus");
    int i = paramArrayOfByte.length;
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, i + 1);
    paramArrayOfByte[i] = paramByte;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "result");
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final byte[] plus(@NotNull byte[] paramArrayOfByte, @NotNull Collection<Byte> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfByte.length;
    paramArrayOfByte = Arrays.copyOf(paramArrayOfByte, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfByte[i] = ((Number)paramCollection.next()).byteValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "result");
    return paramArrayOfByte;
  }
  
  @NotNull
  public static final byte[] plus(@NotNull byte[] paramArrayOfByte1, @NotNull byte[] paramArrayOfByte2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte2, "elements");
    int i = paramArrayOfByte1.length;
    int j = paramArrayOfByte2.length;
    paramArrayOfByte1 = Arrays.copyOf(paramArrayOfByte1, i + j);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte1, "result");
    return paramArrayOfByte1;
  }
  
  @NotNull
  public static final char[] plus(@NotNull char[] paramArrayOfChar, char paramChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$plus");
    int i = paramArrayOfChar.length;
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, i + 1);
    paramArrayOfChar[i] = paramChar;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "result");
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final char[] plus(@NotNull char[] paramArrayOfChar, @NotNull Collection<Character> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfChar.length;
    paramArrayOfChar = Arrays.copyOf(paramArrayOfChar, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfChar[i] = ((Character)paramCollection.next()).charValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar, "result");
    return paramArrayOfChar;
  }
  
  @NotNull
  public static final char[] plus(@NotNull char[] paramArrayOfChar1, @NotNull char[] paramArrayOfChar2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar2, "elements");
    int i = paramArrayOfChar1.length;
    int j = paramArrayOfChar2.length;
    paramArrayOfChar1 = Arrays.copyOf(paramArrayOfChar1, i + j);
    System.arraycopy(paramArrayOfChar2, 0, paramArrayOfChar1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfChar1, "result");
    return paramArrayOfChar1;
  }
  
  @NotNull
  public static final double[] plus(@NotNull double[] paramArrayOfDouble, double paramDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$plus");
    int i = paramArrayOfDouble.length;
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, i + 1);
    paramArrayOfDouble[i] = paramDouble;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "result");
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final double[] plus(@NotNull double[] paramArrayOfDouble, @NotNull Collection<Double> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfDouble.length;
    paramArrayOfDouble = Arrays.copyOf(paramArrayOfDouble, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfDouble[i] = ((Number)paramCollection.next()).doubleValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble, "result");
    return paramArrayOfDouble;
  }
  
  @NotNull
  public static final double[] plus(@NotNull double[] paramArrayOfDouble1, @NotNull double[] paramArrayOfDouble2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble2, "elements");
    int i = paramArrayOfDouble1.length;
    int j = paramArrayOfDouble2.length;
    paramArrayOfDouble1 = Arrays.copyOf(paramArrayOfDouble1, i + j);
    System.arraycopy(paramArrayOfDouble2, 0, paramArrayOfDouble1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfDouble1, "result");
    return paramArrayOfDouble1;
  }
  
  @NotNull
  public static final float[] plus(@NotNull float[] paramArrayOfFloat, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$plus");
    int i = paramArrayOfFloat.length;
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, i + 1);
    paramArrayOfFloat[i] = paramFloat;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "result");
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final float[] plus(@NotNull float[] paramArrayOfFloat, @NotNull Collection<Float> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfFloat.length;
    paramArrayOfFloat = Arrays.copyOf(paramArrayOfFloat, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfFloat[i] = ((Number)paramCollection.next()).floatValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat, "result");
    return paramArrayOfFloat;
  }
  
  @NotNull
  public static final float[] plus(@NotNull float[] paramArrayOfFloat1, @NotNull float[] paramArrayOfFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat2, "elements");
    int i = paramArrayOfFloat1.length;
    int j = paramArrayOfFloat2.length;
    paramArrayOfFloat1 = Arrays.copyOf(paramArrayOfFloat1, i + j);
    System.arraycopy(paramArrayOfFloat2, 0, paramArrayOfFloat1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfFloat1, "result");
    return paramArrayOfFloat1;
  }
  
  @NotNull
  public static final int[] plus(@NotNull int[] paramArrayOfInt, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$plus");
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, i + 1);
    paramArrayOfInt[i] = paramInt;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "result");
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final int[] plus(@NotNull int[] paramArrayOfInt, @NotNull Collection<Integer> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfInt.length;
    paramArrayOfInt = Arrays.copyOf(paramArrayOfInt, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfInt[i] = ((Number)paramCollection.next()).intValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt, "result");
    return paramArrayOfInt;
  }
  
  @NotNull
  public static final int[] plus(@NotNull int[] paramArrayOfInt1, @NotNull int[] paramArrayOfInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt2, "elements");
    int i = paramArrayOfInt1.length;
    int j = paramArrayOfInt2.length;
    paramArrayOfInt1 = Arrays.copyOf(paramArrayOfInt1, i + j);
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfInt1, "result");
    return paramArrayOfInt1;
  }
  
  @NotNull
  public static final long[] plus(@NotNull long[] paramArrayOfLong, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$plus");
    int i = paramArrayOfLong.length;
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, i + 1);
    paramArrayOfLong[i] = paramLong;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "result");
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final long[] plus(@NotNull long[] paramArrayOfLong, @NotNull Collection<Long> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfLong.length;
    paramArrayOfLong = Arrays.copyOf(paramArrayOfLong, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfLong[i] = ((Number)paramCollection.next()).longValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "result");
    return paramArrayOfLong;
  }
  
  @NotNull
  public static final long[] plus(@NotNull long[] paramArrayOfLong1, @NotNull long[] paramArrayOfLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong2, "elements");
    int i = paramArrayOfLong1.length;
    int j = paramArrayOfLong2.length;
    paramArrayOfLong1 = Arrays.copyOf(paramArrayOfLong1, i + j);
    System.arraycopy(paramArrayOfLong2, 0, paramArrayOfLong1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong1, "result");
    return paramArrayOfLong1;
  }
  
  @NotNull
  public static final <T> T[] plus(@NotNull T[] paramArrayOfT, T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$plus");
    int i = paramArrayOfT.length;
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, i + 1);
    paramArrayOfT[i] = paramT;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "result");
    return paramArrayOfT;
  }
  
  @NotNull
  public static final <T> T[] plus(@NotNull T[] paramArrayOfT, @NotNull Collection<? extends T> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfT.length;
    paramArrayOfT = Arrays.copyOf(paramArrayOfT, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfT[i] = paramCollection.next();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "result");
    return paramArrayOfT;
  }
  
  @NotNull
  public static final <T> T[] plus(@NotNull T[] paramArrayOfT1, @NotNull T[] paramArrayOfT2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT2, "elements");
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    paramArrayOfT1 = Arrays.copyOf(paramArrayOfT1, i + j);
    System.arraycopy(paramArrayOfT2, 0, paramArrayOfT1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT1, "result");
    return paramArrayOfT1;
  }
  
  @NotNull
  public static final short[] plus(@NotNull short[] paramArrayOfShort, @NotNull Collection<Short> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfShort.length;
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfShort[i] = ((Number)paramCollection.next()).shortValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "result");
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final short[] plus(@NotNull short[] paramArrayOfShort, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$plus");
    int i = paramArrayOfShort.length;
    paramArrayOfShort = Arrays.copyOf(paramArrayOfShort, i + 1);
    paramArrayOfShort[i] = paramShort;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort, "result");
    return paramArrayOfShort;
  }
  
  @NotNull
  public static final short[] plus(@NotNull short[] paramArrayOfShort1, @NotNull short[] paramArrayOfShort2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort2, "elements");
    int i = paramArrayOfShort1.length;
    int j = paramArrayOfShort2.length;
    paramArrayOfShort1 = Arrays.copyOf(paramArrayOfShort1, i + j);
    System.arraycopy(paramArrayOfShort2, 0, paramArrayOfShort1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfShort1, "result");
    return paramArrayOfShort1;
  }
  
  @NotNull
  public static final boolean[] plus(@NotNull boolean[] paramArrayOfBoolean, @NotNull Collection<Boolean> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramCollection, "elements");
    int i = paramArrayOfBoolean.length;
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, paramCollection.size() + i);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      paramArrayOfBoolean[i] = ((Boolean)paramCollection.next()).booleanValue();
      i += 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "result");
    return paramArrayOfBoolean;
  }
  
  @NotNull
  public static final boolean[] plus(@NotNull boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$plus");
    int i = paramArrayOfBoolean.length;
    paramArrayOfBoolean = Arrays.copyOf(paramArrayOfBoolean, i + 1);
    paramArrayOfBoolean[i] = paramBoolean;
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean, "result");
    return paramArrayOfBoolean;
  }
  
  @NotNull
  public static final boolean[] plus(@NotNull boolean[] paramArrayOfBoolean1, @NotNull boolean[] paramArrayOfBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean1, "$this$plus");
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean2, "elements");
    int i = paramArrayOfBoolean1.length;
    int j = paramArrayOfBoolean2.length;
    paramArrayOfBoolean1 = Arrays.copyOf(paramArrayOfBoolean1, i + j);
    System.arraycopy(paramArrayOfBoolean2, 0, paramArrayOfBoolean1, i, j);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfBoolean1, "result");
    return paramArrayOfBoolean1;
  }
  
  @InlineOnly
  private static final <T> T[] plusElement(@NotNull T[] paramArrayOfT, T paramT)
  {
    return ArraysKt.plus(paramArrayOfT, paramT);
  }
  
  public static final void sort(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sort");
    if (paramArrayOfByte.length > 1) {
      Arrays.sort(paramArrayOfByte);
    }
  }
  
  public static final void sort(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$sort");
    Arrays.sort(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static final void sort(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sort");
    if (paramArrayOfChar.length > 1) {
      Arrays.sort(paramArrayOfChar);
    }
  }
  
  public static final void sort(@NotNull char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$sort");
    Arrays.sort(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public static final void sort(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sort");
    if (paramArrayOfDouble.length > 1) {
      Arrays.sort(paramArrayOfDouble);
    }
  }
  
  public static final void sort(@NotNull double[] paramArrayOfDouble, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$sort");
    Arrays.sort(paramArrayOfDouble, paramInt1, paramInt2);
  }
  
  public static final void sort(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sort");
    if (paramArrayOfFloat.length > 1) {
      Arrays.sort(paramArrayOfFloat);
    }
  }
  
  public static final void sort(@NotNull float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$sort");
    Arrays.sort(paramArrayOfFloat, paramInt1, paramInt2);
  }
  
  public static final void sort(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sort");
    if (paramArrayOfInt.length > 1) {
      Arrays.sort(paramArrayOfInt);
    }
  }
  
  public static final void sort(@NotNull int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$sort");
    Arrays.sort(paramArrayOfInt, paramInt1, paramInt2);
  }
  
  public static final void sort(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sort");
    if (paramArrayOfLong.length > 1) {
      Arrays.sort(paramArrayOfLong);
    }
  }
  
  public static final void sort(@NotNull long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$sort");
    Arrays.sort(paramArrayOfLong, paramInt1, paramInt2);
  }
  
  @InlineOnly
  private static final <T extends Comparable<? super T>> void sort(@NotNull T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    }
    ArraysKt.sort((Object[])paramArrayOfT);
  }
  
  public static final <T> void sort(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sort");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT);
    }
  }
  
  public static final <T> void sort(@NotNull T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sort");
    Arrays.sort(paramArrayOfT, paramInt1, paramInt2);
  }
  
  public static final void sort(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sort");
    if (paramArrayOfShort.length > 1) {
      Arrays.sort(paramArrayOfShort);
    }
  }
  
  public static final void sort(@NotNull short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$sort");
    Arrays.sort(paramArrayOfShort, paramInt1, paramInt2);
  }
  
  public static final <T> void sortWith(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    if (paramArrayOfT.length > 1) {
      Arrays.sort(paramArrayOfT, paramComparator);
    }
  }
  
  public static final <T> void sortWith(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$sortWith");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Arrays.sort(paramArrayOfT, paramInt1, paramInt2, paramComparator);
  }
  
  @NotNull
  public static final SortedSet<Byte> toSortedSet(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfByte, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final SortedSet<Character> toSortedSet(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfChar, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final SortedSet<Double> toSortedSet(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfDouble, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final SortedSet<Float> toSortedSet(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfFloat, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final SortedSet<Integer> toSortedSet(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfInt, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final SortedSet<Long> toSortedSet(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfLong, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final <T extends Comparable<? super T>> SortedSet<T> toSortedSet(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfT, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final <T> SortedSet<T> toSortedSet(@NotNull T[] paramArrayOfT, @NotNull Comparator<? super T> paramComparator)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$toSortedSet");
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfT, (Collection)new TreeSet(paramComparator));
  }
  
  @NotNull
  public static final SortedSet<Short> toSortedSet(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfShort, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final SortedSet<Boolean> toSortedSet(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toSortedSet");
    return (SortedSet)ArraysKt.toCollection(paramArrayOfBoolean, (Collection)new TreeSet());
  }
  
  @NotNull
  public static final Boolean[] toTypedArray(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "$this$toTypedArray");
    Boolean[] arrayOfBoolean = new Boolean[paramArrayOfBoolean.length];
    int i = 0;
    int j = paramArrayOfBoolean.length;
    while (i < j)
    {
      arrayOfBoolean[i] = Boolean.valueOf(paramArrayOfBoolean[i]);
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  @NotNull
  public static final Byte[] toTypedArray(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$toTypedArray");
    Byte[] arrayOfByte = new Byte[paramArrayOfByte.length];
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      arrayOfByte[i] = Byte.valueOf(paramArrayOfByte[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  @NotNull
  public static final Character[] toTypedArray(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$toTypedArray");
    Character[] arrayOfCharacter = new Character[paramArrayOfChar.length];
    int i = 0;
    int j = paramArrayOfChar.length;
    while (i < j)
    {
      arrayOfCharacter[i] = Character.valueOf(paramArrayOfChar[i]);
      i += 1;
    }
    return arrayOfCharacter;
  }
  
  @NotNull
  public static final Double[] toTypedArray(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "$this$toTypedArray");
    Double[] arrayOfDouble = new Double[paramArrayOfDouble.length];
    int i = 0;
    int j = paramArrayOfDouble.length;
    while (i < j)
    {
      arrayOfDouble[i] = Double.valueOf(paramArrayOfDouble[i]);
      i += 1;
    }
    return arrayOfDouble;
  }
  
  @NotNull
  public static final Float[] toTypedArray(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "$this$toTypedArray");
    Float[] arrayOfFloat = new Float[paramArrayOfFloat.length];
    int i = 0;
    int j = paramArrayOfFloat.length;
    while (i < j)
    {
      arrayOfFloat[i] = Float.valueOf(paramArrayOfFloat[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  @NotNull
  public static final Integer[] toTypedArray(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "$this$toTypedArray");
    Integer[] arrayOfInteger = new Integer[paramArrayOfInt.length];
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      arrayOfInteger[i] = Integer.valueOf(paramArrayOfInt[i]);
      i += 1;
    }
    return arrayOfInteger;
  }
  
  @NotNull
  public static final Long[] toTypedArray(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "$this$toTypedArray");
    Long[] arrayOfLong = new Long[paramArrayOfLong.length];
    int i = 0;
    int j = paramArrayOfLong.length;
    while (i < j)
    {
      arrayOfLong[i] = Long.valueOf(paramArrayOfLong[i]);
      i += 1;
    }
    return arrayOfLong;
  }
  
  @NotNull
  public static final Short[] toTypedArray(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$toTypedArray");
    Short[] arrayOfShort = new Short[paramArrayOfShort.length];
    int i = 0;
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      arrayOfShort[i] = Short.valueOf(paramArrayOfShort[i]);
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.ArraysKt___ArraysJvmKt
 * JD-Core Version:    0.7.0.1
 */