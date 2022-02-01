import com.tencent.widget.pull2refresh.XRecyclerView;

public class auxe
  extends ThreadLocal<Boolean>
{
  public auxe(XRecyclerView paramXRecyclerView) {}
  
  protected Boolean initialValue()
  {
    return Boolean.valueOf(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auxe
 * JD-Core Version:    0.7.0.1
 */