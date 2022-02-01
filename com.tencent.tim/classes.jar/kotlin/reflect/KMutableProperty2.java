package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KMutableProperty2;", "D", "E", "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty2$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty2$Setter;", "set", "", "receiver1", "receiver2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KMutableProperty2<D, E, R>
  extends KMutableProperty<R>, KProperty2<D, E, R>
{
  @NotNull
  public abstract Setter<D, E, R> getSetter();
  
  public abstract void set(D paramD, E paramE, R paramR);
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KMutableProperty2$Setter;", "D", "E", "R", "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/Function3;", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static abstract interface Setter<D, E, R>
    extends Function3<D, E, R, Unit>, KMutableProperty.Setter<R>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KMutableProperty2
 * JD-Core Version:    0.7.0.1
 */