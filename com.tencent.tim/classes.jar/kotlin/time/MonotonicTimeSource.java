package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource;", "()V", "read", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public final class MonotonicTimeSource
  extends AbstractLongTimeSource
  implements TimeSource
{
  public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();
  
  private MonotonicTimeSource()
  {
    super(TimeUnit.NANOSECONDS);
  }
  
  protected long read()
  {
    return System.nanoTime();
  }
  
  @NotNull
  public String toString()
  {
    return "TimeSource(System.nanoTime())";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.time.MonotonicTimeSource
 * JD-Core Version:    0.7.0.1
 */