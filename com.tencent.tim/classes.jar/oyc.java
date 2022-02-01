import com.tribe.async.dispatch.Dispatcher.Dispatchable;

public class oyc
  implements Dispatcher.Dispatchable
{
  public int bgK;
  public Object params;
  
  public oyc(int paramInt, Object... paramVarArgs)
  {
    this.bgK = paramInt;
    this.params = paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oyc
 * JD-Core Version:    0.7.0.1
 */