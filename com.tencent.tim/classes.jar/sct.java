import com.tribe.async.dispatch.Dispatcher.Dispatchable;

public class sct
  implements Dispatcher.Dispatchable
{
  public int bgK;
  public Object params;
  
  public sct(int paramInt, Object... paramVarArgs)
  {
    this.bgK = paramInt;
    this.params = paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sct
 * JD-Core Version:    0.7.0.1
 */