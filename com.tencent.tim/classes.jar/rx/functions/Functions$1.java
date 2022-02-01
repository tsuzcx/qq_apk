package rx.functions;

final class Functions$1
  implements FuncN<R>
{
  Functions$1(Func0 paramFunc0) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      throw new RuntimeException("Func0 expecting 0 arguments.");
    }
    return this.val$f.call();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.functions.Functions.1
 * JD-Core Version:    0.7.0.1
 */