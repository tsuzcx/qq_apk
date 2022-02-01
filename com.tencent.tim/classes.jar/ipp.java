import javax.microedition.khronos.opengles.GL11;

public abstract interface ipp
{
  public abstract int generateTexture();
  
  public abstract void glDeleteBuffers(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void glDeleteTextures(GL11 paramGL11, int paramInt1, int[] paramArrayOfInt, int paramInt2);
  
  public abstract void glGenBuffers(int paramInt1, int[] paramArrayOfInt, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ipp
 * JD-Core Version:    0.7.0.1
 */