package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public abstract class AbstractDoubleTimeSource
  implements TimeSource
{
  @NotNull
  private final TimeUnit unit;
  
  public AbstractDoubleTimeSource(@NotNull TimeUnit paramTimeUnit)
  {
    this.unit = paramTimeUnit;
  }
  
  @NotNull
  protected final TimeUnit getUnit()
  {
    return this.unit;
  }
  
  @NotNull
  public TimeMark markNow()
  {
    return (TimeMark)new DoubleTimeMark(read(), this, Duration.Companion.getZERO(), null);
  }
  
  protected abstract double read();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class DoubleTimeMark
    extends TimeMark
  {
    private final double offset;
    private final double startedAt;
    private final AbstractDoubleTimeSource timeSource;
    
    private DoubleTimeMark(double paramDouble1, AbstractDoubleTimeSource paramAbstractDoubleTimeSource, double paramDouble2)
    {
      this.startedAt = paramDouble1;
      this.timeSource = paramAbstractDoubleTimeSource;
      this.offset = paramDouble2;
    }
    
    public double elapsedNow()
    {
      return Duration.minus-LRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
    }
    
    @NotNull
    public TimeMark plus-LRDsOJo(double paramDouble)
    {
      return (TimeMark)new DoubleTimeMark(this.startedAt, this.timeSource, Duration.plus-LRDsOJo(this.offset, paramDouble), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.time.AbstractDoubleTimeSource
 * JD-Core Version:    0.7.0.1
 */