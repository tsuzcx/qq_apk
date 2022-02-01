package rx;

import rx.functions.Func2;
import rx.functions.FuncN;

final class Single$6
  implements FuncN<R>
{
  Single$6(Func2 paramFunc2) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.6
 * JD-Core Version:    0.7.0.1
 */