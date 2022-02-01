public class abpt
  implements acci
{
  protected void T(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetGameKey(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetGameOnlineCount(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return;
    case 2: 
      onGetGameKey(paramBoolean, paramObject);
      return;
    case 1: 
      onGetGameOnlineCount(paramBoolean, paramObject);
      return;
    }
    T(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abpt
 * JD-Core Version:    0.7.0.1
 */