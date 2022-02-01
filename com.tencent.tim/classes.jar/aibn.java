public class aibn
  implements acci
{
  protected void aR(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void aS(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void bp(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      bp(paramBoolean, paramObject);
      return;
    case 2: 
      aS(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    aR(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aibn
 * JD-Core Version:    0.7.0.1
 */