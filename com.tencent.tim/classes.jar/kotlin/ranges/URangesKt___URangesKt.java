package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/ranges/URangesKt")
class URangesKt___URangesKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short coerceAtLeast-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) < 0) {
      return paramShort2;
    }
    return paramShort1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceAtLeast-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) < 0) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte coerceAtLeast-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) < 0) {
      return paramByte2;
    }
    return paramByte1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceAtLeast-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) < 0) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short coerceAtMost-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort1 & 0xFFFF, 0xFFFF & paramShort2) > 0) {
      return paramShort2;
    }
    return paramShort1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceAtMost-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) > 0) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte coerceAtMost-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) > 0) {
      return paramByte2;
    }
    return paramByte1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceAtMost-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) > 0) {
      return paramLong2;
    }
    return paramLong1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceIn-JPwROB0(long paramLong, @NotNull ClosedRange<ULong> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    long l;
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      l = ((ULong)RangesKt.coerceIn(ULong.box-impl(paramLong), (ClosedFloatingPointRange)paramClosedRange)).unbox-impl();
    }
    do
    {
      return l;
      if (paramClosedRange.isEmpty()) {
        throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: " + paramClosedRange + '.'));
      }
      if (UnsignedKt.ulongCompare(paramLong, ((ULong)paramClosedRange.getStart()).unbox-impl()) < 0) {
        return ((ULong)paramClosedRange.getStart()).unbox-impl();
      }
      l = paramLong;
    } while (UnsignedKt.ulongCompare(paramLong, ((ULong)paramClosedRange.getEndInclusive()).unbox-impl()) <= 0);
    return ((ULong)paramClosedRange.getEndInclusive()).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final short coerceIn-VKSA0NQ(short paramShort1, short paramShort2, short paramShort3)
  {
    if (Intrinsics.compare(paramShort2 & 0xFFFF, paramShort3 & 0xFFFF) > 0) {
      throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.toString-impl(paramShort3) + " is less than minimum " + UShort.toString-impl(paramShort2) + '.'));
    }
    if (Intrinsics.compare(paramShort1 & 0xFFFF, paramShort2 & 0xFFFF) < 0) {
      return paramShort2;
    }
    if (Intrinsics.compare(paramShort1 & 0xFFFF, paramShort3 & 0xFFFF) > 0) {
      return paramShort3;
    }
    return paramShort1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceIn-WZ9TVnA(int paramInt1, int paramInt2, int paramInt3)
  {
    if (UnsignedKt.uintCompare(paramInt2, paramInt3) > 0) {
      throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.toString-impl(paramInt3) + " is less than minimum " + UInt.toString-impl(paramInt2) + '.'));
    }
    if (UnsignedKt.uintCompare(paramInt1, paramInt2) < 0) {
      return paramInt2;
    }
    if (UnsignedKt.uintCompare(paramInt1, paramInt3) > 0) {
      return paramInt3;
    }
    return paramInt1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final byte coerceIn-b33U2AM(byte paramByte1, byte paramByte2, byte paramByte3)
  {
    if (Intrinsics.compare(paramByte2 & 0xFF, paramByte3 & 0xFF) > 0) {
      throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.toString-impl(paramByte3) + " is less than minimum " + UByte.toString-impl(paramByte2) + '.'));
    }
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte2 & 0xFF) < 0) {
      return paramByte2;
    }
    if (Intrinsics.compare(paramByte1 & 0xFF, paramByte3 & 0xFF) > 0) {
      return paramByte3;
    }
    return paramByte1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long coerceIn-sambcqE(long paramLong1, long paramLong2, long paramLong3)
  {
    if (UnsignedKt.ulongCompare(paramLong2, paramLong3) > 0) {
      throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.toString-impl(paramLong3) + " is less than minimum " + ULong.toString-impl(paramLong2) + '.'));
    }
    if (UnsignedKt.ulongCompare(paramLong1, paramLong2) < 0) {
      return paramLong2;
    }
    if (UnsignedKt.ulongCompare(paramLong1, paramLong3) > 0) {
      return paramLong3;
    }
    return paramLong1;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int coerceIn-wuiCnnA(int paramInt, @NotNull ClosedRange<UInt> paramClosedRange)
  {
    Intrinsics.checkParameterIsNotNull(paramClosedRange, "range");
    int i;
    if ((paramClosedRange instanceof ClosedFloatingPointRange)) {
      i = ((UInt)RangesKt.coerceIn(UInt.box-impl(paramInt), (ClosedFloatingPointRange)paramClosedRange)).unbox-impl();
    }
    do
    {
      return i;
      if (paramClosedRange.isEmpty()) {
        throw ((Throwable)new IllegalArgumentException("Cannot coerce value to an empty range: " + paramClosedRange + '.'));
      }
      if (UnsignedKt.uintCompare(paramInt, ((UInt)paramClosedRange.getStart()).unbox-impl()) < 0) {
        return ((UInt)paramClosedRange.getStart()).unbox-impl();
      }
      i = paramInt;
    } while (UnsignedKt.uintCompare(paramInt, ((UInt)paramClosedRange.getEndInclusive()).unbox-impl()) <= 0);
    return ((UInt)paramClosedRange.getEndInclusive()).unbox-impl();
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-68kG9v0(@NotNull UIntRange paramUIntRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return paramUIntRange.contains-WZ4Q5Ns(UInt.constructor-impl(paramByte & 0xFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains-GYNo2lE(@NotNull ULongRange paramULongRange, ULong paramULong)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return (paramULong != null) && (paramULongRange.contains-VKZWuLQ(paramULong.unbox-impl()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-Gab390E(@NotNull ULongRange paramULongRange, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return paramULongRange.contains-VKZWuLQ(ULong.constructor-impl(paramInt & 0xFFFFFFFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-ULb-yJY(@NotNull ULongRange paramULongRange, byte paramByte)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return paramULongRange.contains-VKZWuLQ(ULong.constructor-impl(paramByte & 0xFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-ZsK3CEQ(@NotNull UIntRange paramUIntRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return paramUIntRange.contains-WZ4Q5Ns(UInt.constructor-impl(0xFFFF & paramShort));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final boolean contains-biwQdVI(@NotNull UIntRange paramUIntRange, UInt paramUInt)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return (paramUInt != null) && (paramUIntRange.contains-WZ4Q5Ns(paramUInt.unbox-impl()));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-fz5IDCE(@NotNull UIntRange paramUIntRange, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$contains");
    return (ULong.constructor-impl(paramLong >>> 32) == 0L) && (paramUIntRange.contains-WZ4Q5Ns(UInt.constructor-impl((int)paramLong)));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final boolean contains-uhHAxoY(@NotNull ULongRange paramULongRange, short paramShort)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$contains");
    return paramULongRange.contains-VKZWuLQ(ULong.constructor-impl(paramShort & 0xFFFF));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression downTo-5PvTz6A(short paramShort1, short paramShort2)
  {
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(0xFFFF & paramShort2), -1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression downTo-J1ME1BU(int paramInt1, int paramInt2)
  {
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(paramInt1, paramInt2, -1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression downTo-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(paramByte2 & 0xFF), -1);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongProgression downTo-eb3DHEI(long paramLong1, long paramLong2)
  {
    return ULongProgression.Companion.fromClosedRange-7ftBX0g(paramLong1, paramLong2, -1L);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int random(@NotNull UIntRange paramUIntRange)
  {
    return URangesKt.random(paramUIntRange, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final int random(@NotNull UIntRange paramUIntRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      int i = URandomKt.nextUInt(paramRandom, paramUIntRange);
      return i;
    }
    catch (IllegalArgumentException paramUIntRange)
    {
      throw ((Throwable)new NoSuchElementException(paramUIntRange.getMessage()));
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long random(@NotNull ULongRange paramULongRange)
  {
    return URangesKt.random(paramULongRange, (Random)Random.Default);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  public static final long random(@NotNull ULongRange paramULongRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$random");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    try
    {
      long l = URandomKt.nextULong(paramRandom, paramULongRange);
      return l;
    }
    catch (IllegalArgumentException paramULongRange)
    {
      throw ((Throwable)new NoSuchElementException(paramULongRange.getMessage()));
    }
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final UInt randomOrNull(@NotNull UIntRange paramUIntRange)
  {
    return URangesKt.randomOrNull(paramUIntRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final UInt randomOrNull(@NotNull UIntRange paramUIntRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramUIntRange.isEmpty()) {
      return null;
    }
    return UInt.box-impl(URandomKt.nextUInt(paramRandom, paramUIntRange));
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final ULong randomOrNull(@NotNull ULongRange paramULongRange)
  {
    return URangesKt.randomOrNull(paramULongRange, (Random)Random.Default);
  }
  
  @ExperimentalStdlibApi
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @Nullable
  public static final ULong randomOrNull(@NotNull ULongRange paramULongRange, @NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramULongRange, "$this$randomOrNull");
    Intrinsics.checkParameterIsNotNull(paramRandom, "random");
    if (paramULongRange.isEmpty()) {
      return null;
    }
    return ULong.box-impl(URandomKt.nextULong(paramRandom, paramULongRange));
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression reversed(@NotNull UIntProgression paramUIntProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntProgression, "$this$reversed");
    return UIntProgression.Companion.fromClosedRange-Nkh28Cs(paramUIntProgression.getLast(), paramUIntProgression.getFirst(), -paramUIntProgression.getStep());
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongProgression reversed(@NotNull ULongProgression paramULongProgression)
  {
    Intrinsics.checkParameterIsNotNull(paramULongProgression, "$this$reversed");
    return ULongProgression.Companion.fromClosedRange-7ftBX0g(paramULongProgression.getLast(), paramULongProgression.getFirst(), -paramULongProgression.getStep());
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntProgression step(@NotNull UIntProgression paramUIntProgression, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramUIntProgression, "$this$step");
    boolean bool;
    UIntProgression.Companion localCompanion;
    int i;
    int j;
    if (paramInt > 0)
    {
      bool = true;
      RangesKt.checkStepIsPositive(bool, (Number)Integer.valueOf(paramInt));
      localCompanion = UIntProgression.Companion;
      i = paramUIntProgression.getFirst();
      j = paramUIntProgression.getLast();
      if (paramUIntProgression.getStep() <= 0) {
        break label63;
      }
    }
    for (;;)
    {
      return localCompanion.fromClosedRange-Nkh28Cs(i, j, paramInt);
      bool = false;
      break;
      label63:
      paramInt = -paramInt;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongProgression step(@NotNull ULongProgression paramULongProgression, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramULongProgression, "$this$step");
    boolean bool;
    ULongProgression.Companion localCompanion;
    long l1;
    long l2;
    if (paramLong > 0L)
    {
      bool = true;
      RangesKt.checkStepIsPositive(bool, (Number)Long.valueOf(paramLong));
      localCompanion = ULongProgression.Companion;
      l1 = paramULongProgression.getFirst();
      l2 = paramULongProgression.getLast();
      if (paramULongProgression.getStep() <= 0L) {
        break label69;
      }
    }
    for (;;)
    {
      return localCompanion.fromClosedRange-7ftBX0g(l1, l2, paramLong);
      bool = false;
      break;
      label69:
      paramLong = -paramLong;
    }
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntRange until-5PvTz6A(short paramShort1, short paramShort2)
  {
    if (Intrinsics.compare(paramShort2 & 0xFFFF, 0) <= 0) {
      return UIntRange.Companion.getEMPTY();
    }
    return new UIntRange(UInt.constructor-impl(paramShort1 & 0xFFFF), UInt.constructor-impl(UInt.constructor-impl(0xFFFF & paramShort2) - 1), null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntRange until-J1ME1BU(int paramInt1, int paramInt2)
  {
    if (UnsignedKt.uintCompare(paramInt2, 0) <= 0) {
      return UIntRange.Companion.getEMPTY();
    }
    return new UIntRange(paramInt1, UInt.constructor-impl(paramInt2 - 1), null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final UIntRange until-Kr8caGY(byte paramByte1, byte paramByte2)
  {
    if (Intrinsics.compare(paramByte2 & 0xFF, 0) <= 0) {
      return UIntRange.Companion.getEMPTY();
    }
    return new UIntRange(UInt.constructor-impl(paramByte1 & 0xFF), UInt.constructor-impl(UInt.constructor-impl(paramByte2 & 0xFF) - 1), null);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final ULongRange until-eb3DHEI(long paramLong1, long paramLong2)
  {
    if (UnsignedKt.ulongCompare(paramLong2, 0L) <= 0) {
      return ULongRange.Companion.getEMPTY();
    }
    return new ULongRange(paramLong1, ULong.constructor-impl(paramLong2 - ULong.constructor-impl(1 & 0xFFFFFFFF)), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ranges.URangesKt___URangesKt
 * JD-Core Version:    0.7.0.1
 */