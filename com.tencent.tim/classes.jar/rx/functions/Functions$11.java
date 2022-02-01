package rx.functions;

final class Functions$11
  implements FuncN<Void>
{
  Functions$11(Action0 paramAction0) {}
  
  public Void call(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      throw new RuntimeException("Action0 expecting 0 arguments.");
    }
    this.val$f.call();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.functions.Functions.11
 * JD-Core Version:    0.7.0.1
 */