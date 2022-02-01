package kotlin.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty;", "R", "Lkotlin/reflect/KCallable;", "getter", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "isConst", "", "isConst$annotations", "()V", "()Z", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KProperty<R>
  extends KCallable<R>
{
  @NotNull
  public abstract Getter<R> getGetter();
  
  public abstract boolean isConst();
  
  public abstract boolean isLateinit();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty$Accessor;", "R", "", "property", "Lkotlin/reflect/KProperty;", "getProperty", "()Lkotlin/reflect/KProperty;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static abstract interface Accessor<R>
  {
    @NotNull
    public abstract KProperty<R> getProperty();
  }
  
  @Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
  public static final class DefaultImpls {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty$Getter;", "R", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static abstract interface Getter<R>
    extends KFunction<R>, KProperty.Accessor<R>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KProperty
 * JD-Core Version:    0.7.0.1
 */