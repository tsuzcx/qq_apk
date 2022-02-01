public class adcu
{
  private adcv jdField_a_of_type_Adcv = new adcv();
  private adcw jdField_a_of_type_Adcw = new adcw();
  
  public adcu()
  {
    this.jdField_a_of_type_Adcv.init();
    this.jdField_a_of_type_Adcw.init();
  }
  
  public void drawTexture(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if (paramInt1 == 36197)
    {
      this.jdField_a_of_type_Adcw.drawTexture(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    if (paramInt1 == 3553)
    {
      this.jdField_a_of_type_Adcv.drawTexture(paramInt2, paramArrayOfFloat1, paramArrayOfFloat2);
      return;
    }
    throw new RuntimeException("textureType must be GLES11Ext.GL_TEXTURE_EXTERNAL_OES or GLES20.GL_TEXTURE_2D.");
  }
  
  public void release()
  {
    this.jdField_a_of_type_Adcv.destroy();
    this.jdField_a_of_type_Adcw.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adcu
 * JD-Core Version:    0.7.0.1
 */