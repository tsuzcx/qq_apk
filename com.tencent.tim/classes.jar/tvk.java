public class tvk
{
  private final int[] colors;
  private final float[] positions;
  
  public tvk(float[] paramArrayOfFloat, int[] paramArrayOfInt)
  {
    this.positions = paramArrayOfFloat;
    this.colors = paramArrayOfInt;
  }
  
  public void a(tvk paramtvk1, tvk paramtvk2, float paramFloat)
  {
    if (paramtvk1.colors.length != paramtvk2.colors.length) {
      throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + paramtvk1.colors.length + " vs " + paramtvk2.colors.length + ")");
    }
    int i = 0;
    while (i < paramtvk1.colors.length)
    {
      this.positions[i] = twx.lerp(paramtvk1.positions[i], paramtvk2.positions[i], paramFloat);
      this.colors[i] = twr.evaluate(paramFloat, paramtvk1.colors[i], paramtvk2.colors[i]);
      i += 1;
    }
  }
  
  public int[] getColors()
  {
    return this.colors;
  }
  
  public float[] getPositions()
  {
    return this.positions;
  }
  
  public int getSize()
  {
    return this.colors.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvk
 * JD-Core Version:    0.7.0.1
 */