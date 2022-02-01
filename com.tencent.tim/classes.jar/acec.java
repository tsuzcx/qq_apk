public class acec
  implements acci
{
  protected void F(boolean paramBoolean, Object paramObject) {}
  
  protected void G(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      F(paramBoolean, paramObject);
      return;
    }
    G(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acec
 * JD-Core Version:    0.7.0.1
 */