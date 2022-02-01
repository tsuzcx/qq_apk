package kotlin.properties;

import kotlin.Metadata;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/properties/ReadOnlyProperty;", "R", "T", "", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface ReadOnlyProperty<R, T>
{
  public abstract T getValue(R paramR, @NotNull KProperty<?> paramKProperty);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.properties.ReadOnlyProperty
 * JD-Core Version:    0.7.0.1
 */