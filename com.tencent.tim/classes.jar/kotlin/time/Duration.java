package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/Duration;", "", "value", "", "constructor-impl", "(D)D", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(D)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMicroseconds", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds-impl", "inMinutes", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "compareTo", "other", "compareTo-LRDsOJo", "(DD)I", "div", "scale", "div-impl", "(DD)D", "(DI)D", "div-LRDsOJo", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(D)Z", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "plus", "plus-LRDsOJo", "precision", "precision-impl", "times", "times-impl", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(D)Ljava/lang/String;", "toLong", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "(D)J", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public final class Duration
  implements Comparable<Duration>
{
  public static final Companion Companion = new Companion(null);
  private static final double INFINITE = constructor-impl(DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY());
  private static final double ZERO = constructor-impl(0.0D);
  private final double value;
  
  public static int compareTo-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return Double.compare(paramDouble1, paramDouble2);
  }
  
  public static double constructor-impl(double paramDouble)
  {
    return paramDouble;
  }
  
  public static final double div-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 / paramDouble2;
  }
  
  public static final double div-impl(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 / paramDouble2);
  }
  
  public static final double div-impl(double paramDouble, int paramInt)
  {
    return constructor-impl(paramDouble / paramInt);
  }
  
  public static boolean equals-impl(double paramDouble, @Nullable Object paramObject)
  {
    return ((paramObject instanceof Duration)) && (Double.compare(paramDouble, ((Duration)paramObject).unbox-impl()) == 0);
  }
  
  public static final boolean equals-impl0(double paramDouble1, double paramDouble2)
  {
    return Double.compare(paramDouble1, paramDouble2) == 0;
  }
  
  public static final double getAbsoluteValue-impl(double paramDouble)
  {
    double d = paramDouble;
    if (isNegative-impl(paramDouble)) {
      d = unaryMinus-impl(paramDouble);
    }
    return d;
  }
  
  public static final int getHoursComponent-impl(double paramDouble)
  {
    return (int)(getInHours-impl(paramDouble) % 24);
  }
  
  public static final double getInDays-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.DAYS);
  }
  
  public static final double getInHours-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.HOURS);
  }
  
  public static final double getInMicroseconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.MICROSECONDS);
  }
  
  public static final double getInMilliseconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.MILLISECONDS);
  }
  
  public static final double getInMinutes-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.MINUTES);
  }
  
  public static final double getInNanoseconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.NANOSECONDS);
  }
  
  public static final double getInSeconds-impl(double paramDouble)
  {
    return toDouble-impl(paramDouble, TimeUnit.SECONDS);
  }
  
  public static final int getMinutesComponent-impl(double paramDouble)
  {
    return (int)(getInMinutes-impl(paramDouble) % 60);
  }
  
  public static final int getNanosecondsComponent-impl(double paramDouble)
  {
    return (int)(getInNanoseconds-impl(paramDouble) % 1000000000.0D);
  }
  
  public static final int getSecondsComponent-impl(double paramDouble)
  {
    return (int)(getInSeconds-impl(paramDouble) % 60);
  }
  
  public static int hashCode-impl(double paramDouble)
  {
    long l = Double.doubleToLongBits(paramDouble);
    return (int)(l ^ l >>> 32);
  }
  
  public static final boolean isFinite-impl(double paramDouble)
  {
    return (!Double.isInfinite(paramDouble)) && (!Double.isNaN(paramDouble));
  }
  
  public static final boolean isInfinite-impl(double paramDouble)
  {
    return Double.isInfinite(paramDouble);
  }
  
  public static final boolean isNegative-impl(double paramDouble)
  {
    boolean bool = false;
    if (paramDouble < 0) {
      bool = true;
    }
    return bool;
  }
  
  public static final boolean isPositive-impl(double paramDouble)
  {
    boolean bool = false;
    if (paramDouble > 0) {
      bool = true;
    }
    return bool;
  }
  
  public static final double minus-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 - paramDouble2);
  }
  
  public static final double plus-LRDsOJo(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 + paramDouble2);
  }
  
  private static final int precision-impl(double paramDouble1, double paramDouble2)
  {
    int i = 1;
    if (paramDouble2 < 1) {
      i = 3;
    }
    do
    {
      return i;
      if (paramDouble2 < 10) {
        return 2;
      }
    } while (paramDouble2 < 100);
    return 0;
  }
  
  public static final double times-impl(double paramDouble1, double paramDouble2)
  {
    return constructor-impl(paramDouble1 * paramDouble2);
  }
  
  public static final double times-impl(double paramDouble, int paramInt)
  {
    return constructor-impl(paramInt * paramDouble);
  }
  
  public static final <T> T toComponents-impl(double paramDouble, @NotNull Function2<? super Long, ? super Integer, ? extends T> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "action");
    return paramFunction2.invoke(Long.valueOf(getInSeconds-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final <T> T toComponents-impl(double paramDouble, @NotNull Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "action");
    return paramFunction3.invoke(Integer.valueOf((int)getInMinutes-impl(paramDouble)), Integer.valueOf(getSecondsComponent-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final <T> T toComponents-impl(double paramDouble, @NotNull Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction4, "action");
    return paramFunction4.invoke(Integer.valueOf((int)getInHours-impl(paramDouble)), Integer.valueOf(getMinutesComponent-impl(paramDouble)), Integer.valueOf(getSecondsComponent-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final <T> T toComponents-impl(double paramDouble, @NotNull Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> paramFunction5)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction5, "action");
    return paramFunction5.invoke(Integer.valueOf((int)getInDays-impl(paramDouble)), Integer.valueOf(getHoursComponent-impl(paramDouble)), Integer.valueOf(getMinutesComponent-impl(paramDouble)), Integer.valueOf(getSecondsComponent-impl(paramDouble)), Integer.valueOf(getNanosecondsComponent-impl(paramDouble)));
  }
  
  public static final double toDouble-impl(double paramDouble, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return DurationUnitKt.convertDurationUnit(paramDouble, DurationKt.access$getStorageUnit$p(), paramTimeUnit);
  }
  
  public static final int toInt-impl(double paramDouble, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return (int)toDouble-impl(paramDouble, paramTimeUnit);
  }
  
  @NotNull
  public static final String toIsoString-impl(double paramDouble)
  {
    int m = 1;
    Object localObject = new StringBuilder();
    if (isNegative-impl(paramDouble)) {
      ((StringBuilder)localObject).append('-');
    }
    ((StringBuilder)localObject).append("PT");
    paramDouble = getAbsoluteValue-impl(paramDouble);
    int n = (int)getInHours-impl(paramDouble);
    int i1 = getMinutesComponent-impl(paramDouble);
    int i2 = getSecondsComponent-impl(paramDouble);
    int i3 = getNanosecondsComponent-impl(paramDouble);
    int i;
    int j;
    label85:
    int k;
    label106:
    String str;
    if (n != 0)
    {
      i = 1;
      if ((i2 == 0) && (i3 == 0)) {
        break label247;
      }
      j = 1;
      k = m;
      if (i1 == 0)
      {
        if ((j == 0) || (i == 0)) {
          break label252;
        }
        k = m;
      }
      if (i != 0) {
        ((StringBuilder)localObject).append(n).append('H');
      }
      if (k != 0) {
        ((StringBuilder)localObject).append(i1).append('M');
      }
      if ((j != 0) || ((i == 0) && (k == 0)))
      {
        ((StringBuilder)localObject).append(i2);
        if (i3 != 0)
        {
          ((StringBuilder)localObject).append('.');
          str = StringsKt.padStart(String.valueOf(i3), 9, '0');
          if (i3 % 1000000 != 0) {
            break label258;
          }
          Intrinsics.checkExpressionValueIsNotNull(((StringBuilder)localObject).append((CharSequence)str, 0, 3), "this.append(value, startIndex, endIndex)");
        }
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject).append('S');
      localObject = ((StringBuilder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "StringBuilder().apply(builderAction).toString()");
      return localObject;
      i = 0;
      break;
      label247:
      j = 0;
      break label85;
      label252:
      k = 0;
      break label106;
      label258:
      if (i3 % 1000 == 0) {
        Intrinsics.checkExpressionValueIsNotNull(((StringBuilder)localObject).append((CharSequence)str, 0, 6), "this.append(value, startIndex, endIndex)");
      } else {
        ((StringBuilder)localObject).append(str);
      }
    }
  }
  
  public static final long toLong-impl(double paramDouble, @NotNull TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return toDouble-impl(paramDouble, paramTimeUnit);
  }
  
  public static final long toLongMilliseconds-impl(double paramDouble)
  {
    return toLong-impl(paramDouble, TimeUnit.MILLISECONDS);
  }
  
  public static final long toLongNanoseconds-impl(double paramDouble)
  {
    return toLong-impl(paramDouble, TimeUnit.NANOSECONDS);
  }
  
  @NotNull
  public static String toString-impl(double paramDouble)
  {
    int j = 0;
    int i = 1;
    if (isInfinite-impl(paramDouble)) {
      return String.valueOf(paramDouble);
    }
    if (paramDouble == 0.0D) {
      return "0s";
    }
    double d = getInNanoseconds-impl(getAbsoluteValue-impl(paramDouble));
    TimeUnit localTimeUnit;
    StringBuilder localStringBuilder;
    String str;
    if (d < 1.0E-006D)
    {
      localTimeUnit = TimeUnit.SECONDS;
      d = toDouble-impl(paramDouble, localTimeUnit);
      localStringBuilder = new StringBuilder();
      if (i == 0) {
        break label258;
      }
      str = FormatToDecimalsKt.formatScientific(d);
    }
    for (;;)
    {
      return str + DurationUnitKt.shortName(localTimeUnit);
      if (d < 1)
      {
        localTimeUnit = TimeUnit.NANOSECONDS;
        i = 0;
        j = 7;
        break;
      }
      if (d < 1000.0D)
      {
        localTimeUnit = TimeUnit.NANOSECONDS;
        i = 0;
        break;
      }
      if (d < 1000000.0D)
      {
        localTimeUnit = TimeUnit.MICROSECONDS;
        i = 0;
        break;
      }
      if (d < 1000000000.0D)
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        i = 0;
        break;
      }
      if (d < 1000000000000.0D)
      {
        localTimeUnit = TimeUnit.SECONDS;
        i = 0;
        break;
      }
      if (d < 60000000000000.0D)
      {
        localTimeUnit = TimeUnit.MINUTES;
        i = 0;
        break;
      }
      if (d < 3600000000000000.0D)
      {
        localTimeUnit = TimeUnit.HOURS;
        i = 0;
        break;
      }
      if (d < 8.64E+020D)
      {
        localTimeUnit = TimeUnit.DAYS;
        i = 0;
        break;
      }
      localTimeUnit = TimeUnit.DAYS;
      break;
      label258:
      if (j > 0) {
        str = FormatToDecimalsKt.formatUpToDecimals(d, j);
      } else {
        str = FormatToDecimalsKt.formatToExactDecimals(d, precision-impl(paramDouble, Math.abs(d)));
      }
    }
  }
  
  @NotNull
  public static final String toString-impl(double paramDouble, @NotNull TimeUnit paramTimeUnit, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalArgumentException(("decimals must be not negative, but was " + paramInt).toString()));
    }
    if (isInfinite-impl(paramDouble)) {
      return String.valueOf(paramDouble);
    }
    paramDouble = toDouble-impl(paramDouble, paramTimeUnit);
    StringBuilder localStringBuilder = new StringBuilder();
    if (Math.abs(paramDouble) < 100000000000000.0D) {}
    for (String str = FormatToDecimalsKt.formatToExactDecimals(paramDouble, RangesKt.coerceAtMost(paramInt, 12));; str = FormatToDecimalsKt.formatScientific(paramDouble)) {
      return str + DurationUnitKt.shortName(paramTimeUnit);
    }
  }
  
  public static final double unaryMinus-impl(double paramDouble)
  {
    return constructor-impl(-paramDouble);
  }
  
  public int compareTo-LRDsOJo(double paramDouble)
  {
    return compareTo-LRDsOJo(this.value, paramDouble);
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.value, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.value);
  }
  
  @NotNull
  public String toString()
  {
    return toString-impl(this.value);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE", "()D", "D", "ZERO", "getZERO", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final double convert(double paramDouble, @NotNull TimeUnit paramTimeUnit1, @NotNull TimeUnit paramTimeUnit2)
    {
      Intrinsics.checkParameterIsNotNull(paramTimeUnit1, "sourceUnit");
      Intrinsics.checkParameterIsNotNull(paramTimeUnit2, "targetUnit");
      return DurationUnitKt.convertDurationUnit(paramDouble, paramTimeUnit1, paramTimeUnit2);
    }
    
    public final double getINFINITE()
    {
      return Duration.access$getINFINITE$cp();
    }
    
    public final double getZERO()
    {
      return Duration.access$getZERO$cp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.time.Duration
 * JD-Core Version:    0.7.0.1
 */