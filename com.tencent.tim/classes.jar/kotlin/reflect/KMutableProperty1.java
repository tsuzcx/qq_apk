package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KMutableProperty1;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/KMutableProperty;", "setter", "Lkotlin/reflect/KMutableProperty1$Setter;", "getSetter", "()Lkotlin/reflect/KMutableProperty1$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KMutableProperty1<T, R>
  extends KMutableProperty<R>, KProperty1<T, R>
{
  @NotNull
  public abstract Setter<T, R> getSetter();
  
  public abstract void set(T paramT, R paramR);
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KMutableProperty1$Setter;", "T", "R", "Lkotlin/reflect/KMutableProperty$Setter;", "Lkotlin/Function2;", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static abstract interface Setter<T, R>
    extends Function2<T, R, Unit>, KMutableProperty.Setter<R>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KMutableProperty1
 * JD-Core Version:    0.7.0.1
 */