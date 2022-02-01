final class aqoz
  implements aqoy.b
{
  private boolean d(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] <= 0.05F;
  }
  
  private boolean e(float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[2] >= 0.95F;
  }
  
  private boolean f(float[] paramArrayOfFloat)
  {
    return (paramArrayOfFloat[0] >= 10.0F) && (paramArrayOfFloat[0] <= 37.0F) && (paramArrayOfFloat[1] <= 0.82F);
  }
  
  public boolean b(int paramInt, float[] paramArrayOfFloat)
  {
    return (!e(paramArrayOfFloat)) && (!d(paramArrayOfFloat)) && (!f(paramArrayOfFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqoz
 * JD-Core Version:    0.7.0.1
 */