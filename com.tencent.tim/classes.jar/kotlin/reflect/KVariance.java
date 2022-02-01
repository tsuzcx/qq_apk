package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public enum KVariance
{
  static
  {
    KVariance localKVariance1 = new KVariance("INVARIANT", 0);
    INVARIANT = localKVariance1;
    KVariance localKVariance2 = new KVariance("IN", 1);
    IN = localKVariance2;
    KVariance localKVariance3 = new KVariance("OUT", 2);
    OUT = localKVariance3;
    $VALUES = new KVariance[] { localKVariance1, localKVariance2, localKVariance3 };
  }
  
  private KVariance() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KVariance
 * JD-Core Version:    0.7.0.1
 */