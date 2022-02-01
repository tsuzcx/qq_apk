package kotlin;

import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UninitializedPropertyAccessException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class UninitializedPropertyAccessException
  extends RuntimeException
{
  public UninitializedPropertyAccessException() {}
  
  public UninitializedPropertyAccessException(@Nullable String paramString)
  {
    super(paramString);
  }
  
  public UninitializedPropertyAccessException(@Nullable String paramString, @Nullable Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public UninitializedPropertyAccessException(@Nullable Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.UninitializedPropertyAccessException
 * JD-Core Version:    0.7.0.1
 */