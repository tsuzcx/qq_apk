package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Lkotlin/reflect/KDeclarationContainer;", "jClass", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface ClassBasedDeclarationContainer
  extends KDeclarationContainer
{
  @NotNull
  public abstract Class<?> getJClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.ClassBasedDeclarationContainer
 * JD-Core Version:    0.7.0.1
 */