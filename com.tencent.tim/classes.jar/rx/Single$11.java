package rx;

import rx.functions.Func7;
import rx.functions.FuncN;

final class Single$11
  implements FuncN<R>
{
  Single$11(Func7 paramFunc7) {}
  
  public R call(Object... paramVarArgs)
  {
    return this.val$zipFunction.call(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], paramVarArgs[4], paramVarArgs[5], paramVarArgs[6]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.Single.11
 * JD-Core Version:    0.7.0.1
 */