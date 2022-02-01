package kotlin;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Lazy;", "T", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface Lazy<T>
{
  public abstract T getValue();
  
  public abstract boolean isInitialized();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.Lazy
 * JD-Core Version:    0.7.0.1
 */