package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "unit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "getUnit", "()Ljava/util/concurrent/TimeUnit;", "markNow", "Lkotlin/time/TimeMark;", "read", "", "LongTimeMark", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public abstract class AbstractLongTimeSource
  implements TimeSource
{
  @NotNull
  private final TimeUnit unit;
  
  public AbstractLongTimeSource(@NotNull TimeUnit paramTimeUnit)
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
    return (TimeMark)new LongTimeMark(read(), this, Duration.Companion.getZERO(), null);
  }
  
  protected abstract long read();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/TimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;DLkotlin/jvm/internal/DefaultConstructorMarker;)V", "D", "elapsedNow", "()D", "plus", "duration", "plus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class LongTimeMark
    extends TimeMark
  {
    private final double offset;
    private final long startedAt;
    private final AbstractLongTimeSource timeSource;
    
    private LongTimeMark(long paramLong, AbstractLongTimeSource paramAbstractLongTimeSource, double paramDouble)
    {
      this.startedAt = paramLong;
      this.timeSource = paramAbstractLongTimeSource;
      this.offset = paramDouble;
    }
    
    public double elapsedNow()
    {
      return Duration.minus-LRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
    }
    
    @NotNull
    public TimeMark plus-LRDsOJo(double paramDouble)
    {
      return (TimeMark)new LongTimeMark(this.startedAt, this.timeSource, Duration.plus-LRDsOJo(this.offset, paramDouble), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.time.AbstractLongTimeSource
 * JD-Core Version:    0.7.0.1
 */