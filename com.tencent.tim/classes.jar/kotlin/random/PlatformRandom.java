package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/PlatformRandom;", "Lkotlin/random/AbstractPlatformRandom;", "impl", "Ljava/util/Random;", "(Ljava/util/Random;)V", "getImpl", "()Ljava/util/Random;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class PlatformRandom
  extends AbstractPlatformRandom
{
  @NotNull
  private final Random impl;
  
  public PlatformRandom(@NotNull Random paramRandom)
  {
    this.impl = paramRandom;
  }
  
  @NotNull
  public Random getImpl()
  {
    return this.impl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.random.PlatformRandom
 * JD-Core Version:    0.7.0.1
 */