import java.util.List;

public abstract class rsj<T>
{
  private int buP;
  private List<T> mDatas;
  
  public rsj(int paramInt, List<T> paramList)
  {
    this.buP = paramInt;
    this.mDatas = paramList;
  }
  
  public abstract void a(int paramInt, T paramT, qyd paramqyd);
  
  public void c(int paramInt, qyd paramqyd)
  {
    a(paramInt, this.mDatas.get(paramInt), paramqyd);
  }
  
  public List<T> getDatas()
  {
    return this.mDatas;
  }
  
  public int tU()
  {
    return this.buP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsj
 * JD-Core Version:    0.7.0.1
 */