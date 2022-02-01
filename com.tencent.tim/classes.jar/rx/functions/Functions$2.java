package rx.functions;

final class Functions$2
  implements FuncN<R>
{
  Functions$2(Func1 paramFunc1) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 1) {
      throw new RuntimeException("Func1 expecting 1 argument.");
    }
    return this.val$f.call(paramVarArgs[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.functions.Functions.2
 * JD-Core Version:    0.7.0.1
 */