public class acbo
  implements acci
{
  protected void U(boolean paramBoolean, Object paramObject) {}
  
  protected void cGW() {}
  
  protected void cGX() {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
      return;
    case 0: 
      U(paramBoolean, paramObject);
      return;
    case 2: 
      cGX();
      return;
    case 3: 
      wc(((Integer)paramObject).intValue());
      return;
    }
    cGW();
  }
  
  protected void wc(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acbo
 * JD-Core Version:    0.7.0.1
 */