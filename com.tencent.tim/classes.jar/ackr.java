public class ackr
  implements acci
{
  public void bI(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      z(paramBoolean, paramObject);
      return;
    }
    bI(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  public void z(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackr
 * JD-Core Version:    0.7.0.1
 */