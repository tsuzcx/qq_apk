package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
@ExperimentalTime
public abstract interface TimeSource
{
  public static final Companion Companion = Companion.$$INSTANCE;
  
  @NotNull
  public abstract TimeMark markNow();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeMark;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Monotonic
    implements TimeSource
  {
    public static final Monotonic INSTANCE = new Monotonic();
    
    @NotNull
    public TimeMark markNow()
    {
      return this.$$delegate_0.markNow();
    }
    
    @NotNull
    public String toString()
    {
      return MonotonicTimeSource.INSTANCE.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.time.TimeSource
 * JD-Core Version:    0.7.0.1
 */