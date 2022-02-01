package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class KTypeProjection
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  private static final KTypeProjection STAR = new KTypeProjection(null, null);
  @Nullable
  private final KType type;
  @Nullable
  private final KVariance variance;
  
  public KTypeProjection(@Nullable KVariance paramKVariance, @Nullable KType paramKType)
  {
    this.variance = paramKVariance;
    this.type = paramKType;
  }
  
  @Nullable
  public final KVariance component1()
  {
    return this.variance;
  }
  
  @Nullable
  public final KType component2()
  {
    return this.type;
  }
  
  @NotNull
  public final KTypeProjection copy(@Nullable KVariance paramKVariance, @Nullable KType paramKType)
  {
    return new KTypeProjection(paramKVariance, paramKType);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof KTypeProjection))
      {
        paramObject = (KTypeProjection)paramObject;
        if ((!Intrinsics.areEqual(this.variance, paramObject.variance)) || (!Intrinsics.areEqual(this.type, paramObject.type))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @Nullable
  public final KType getType()
  {
    return this.type;
  }
  
  @Nullable
  public final KVariance getVariance()
  {
    return this.variance;
  }
  
  public int hashCode()
  {
    int j = 0;
    Object localObject = this.variance;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.type;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "KTypeProjection(variance=" + this.variance + ", type=" + this.type + ")";
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @NotNull
    public final KTypeProjection contravariant(@NotNull KType paramKType)
    {
      Intrinsics.checkParameterIsNotNull(paramKType, "type");
      return new KTypeProjection(KVariance.IN, paramKType);
    }
    
    @NotNull
    public final KTypeProjection covariant(@NotNull KType paramKType)
    {
      Intrinsics.checkParameterIsNotNull(paramKType, "type");
      return new KTypeProjection(KVariance.OUT, paramKType);
    }
    
    @NotNull
    public final KTypeProjection getSTAR()
    {
      return KTypeProjection.access$getSTAR$cp();
    }
    
    @NotNull
    public final KTypeProjection invariant(@NotNull KType paramKType)
    {
      Intrinsics.checkParameterIsNotNull(paramKType, "type");
      return new KTypeProjection(KVariance.INVARIANT, paramKType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KTypeProjection
 * JD-Core Version:    0.7.0.1
 */