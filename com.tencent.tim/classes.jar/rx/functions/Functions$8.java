package rx.functions;

final class Functions$8
  implements FuncN<R>
{
  Functions$8(Func7 paramFunc7) {}
  
  public R call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {
      throw new RuntimeException("Func7 expecting 7 arguments.");
    }
    return this.val$f.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.functions.Functions.8
 * JD-Core Version:    0.7.0.1
 */