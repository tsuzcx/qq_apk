package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", "", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@PublishedApi
@SinceKotlin(version="1.3")
public enum CoroutineSingletons
{
  static
  {
    CoroutineSingletons localCoroutineSingletons1 = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
    COROUTINE_SUSPENDED = localCoroutineSingletons1;
    CoroutineSingletons localCoroutineSingletons2 = new CoroutineSingletons("UNDECIDED", 1);
    UNDECIDED = localCoroutineSingletons2;
    CoroutineSingletons localCoroutineSingletons3 = new CoroutineSingletons("RESUMED", 2);
    RESUMED = localCoroutineSingletons3;
    $VALUES = new CoroutineSingletons[] { localCoroutineSingletons1, localCoroutineSingletons2, localCoroutineSingletons3 };
  }
  
  private CoroutineSingletons() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.coroutines.intrinsics.CoroutineSingletons
 * JD-Core Version:    0.7.0.1
 */