package kotlin.reflect;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/KClassifier;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract interface KTypeParameter
  extends KClassifier
{
  @NotNull
  public abstract String getName();
  
  @NotNull
  public abstract List<KType> getUpperBounds();
  
  @NotNull
  public abstract KVariance getVariance();
  
  public abstract boolean isReified();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KTypeParameter
 * JD-Core Version:    0.7.0.1
 */