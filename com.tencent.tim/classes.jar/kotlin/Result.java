package kotlin;

import java.io.Serializable;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Result;", "T", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "value", "", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "isFailure", "", "isFailure-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isSuccess-impl", "value$annotations", "()V", "equals", "other", "exceptionOrNull", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getOrNull", "getOrNull-impl", "hashCode", "", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "Failure", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public final class Result<T>
  implements Serializable
{
  public static final Companion Companion = new Companion(null);
  @Nullable
  private final Object value;
  
  @PublishedApi
  @NotNull
  public static Object constructor-impl(@Nullable Object paramObject)
  {
    return paramObject;
  }
  
  public static boolean equals-impl(Object paramObject1, @Nullable Object paramObject2)
  {
    return ((paramObject2 instanceof Result)) && (Intrinsics.areEqual(paramObject1, ((Result)paramObject2).unbox-impl()));
  }
  
  public static final boolean equals-impl0(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return Intrinsics.areEqual(paramObject1, paramObject2);
  }
  
  @Nullable
  public static final Throwable exceptionOrNull-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure)) {
      return ((Failure)paramObject).exception;
    }
    return null;
  }
  
  @InlineOnly
  private static final T getOrNull-impl(Object paramObject)
  {
    Object localObject = paramObject;
    if (isFailure-impl(paramObject)) {
      localObject = null;
    }
    return localObject;
  }
  
  public static int hashCode-impl(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  public static final boolean isFailure-impl(Object paramObject)
  {
    return paramObject instanceof Failure;
  }
  
  public static final boolean isSuccess-impl(Object paramObject)
  {
    return !(paramObject instanceof Failure);
  }
  
  @NotNull
  public static String toString-impl(Object paramObject)
  {
    if ((paramObject instanceof Failure)) {
      return paramObject.toString();
    }
    return "Success(" + paramObject + ')';
  }
  
  public boolean equals(Object paramObject)
  {
    return equals-impl(this.value, paramObject);
  }
  
  public int hashCode()
  {
    return hashCode-impl(this.value);
  }
  
  @NotNull
  public String toString()
  {
    return toString-impl(this.value);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Result$Companion;", "", "()V", "failure", "Lkotlin/Result;", "T", "exception", "", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "success", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    @InlineOnly
    private final <T> Object failure(Throwable paramThrowable)
    {
      return Result.constructor-impl(ResultKt.createFailure(paramThrowable));
    }
    
    @InlineOnly
    private final <T> Object success(T paramT)
    {
      return Result.constructor-impl(paramT);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  public static final class Failure
    implements Serializable
  {
    @JvmField
    @NotNull
    public final Throwable exception;
    
    public Failure(@NotNull Throwable paramThrowable)
    {
      this.exception = paramThrowable;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return ((paramObject instanceof Failure)) && (Intrinsics.areEqual(this.exception, ((Failure)paramObject).exception));
    }
    
    public int hashCode()
    {
      return this.exception.hashCode();
    }
    
    @NotNull
    public String toString()
    {
      return "Failure(" + this.exception + ')';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.Result
 * JD-Core Version:    0.7.0.1
 */