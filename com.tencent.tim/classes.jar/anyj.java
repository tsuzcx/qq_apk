public class anyj
  extends anyb
{
  private anyb jdField_a_of_type_Anyb;
  private anyb[] jdField_a_of_type_ArrayOfAnyb;
  private int mCurrentIndex;
  private int[] oi;
  
  public anyj(anyb... paramVarArgs)
  {
    super(0, 0, 0);
    this.jdField_a_of_type_ArrayOfAnyb = paramVarArgs;
    this.oi = new int[paramVarArgs.length];
    int i = 0;
    int j = 0;
    if (i < paramVarArgs.length)
    {
      if (i == 0) {
        this.oi[i] = 0;
      }
      for (;;)
      {
        j += paramVarArgs[i].duration;
        i += 1;
        break;
        this.oi[i] = j;
      }
    }
    this.duration = j;
    if (paramVarArgs.length > 0) {
      this.jdField_a_of_type_Anyb = paramVarArgs[this.mCurrentIndex];
    }
  }
  
  public void resume()
  {
    super.resume();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfAnyb.length)
    {
      this.oi[i] = ((int)(System.currentTimeMillis() - this.mPauseTime));
      i += 1;
    }
  }
  
  protected void s(int paramInt, float paramFloat)
  {
    if ((this.mCurrentIndex + 1 < this.jdField_a_of_type_ArrayOfAnyb.length) && (paramInt > this.oi[(this.mCurrentIndex + 1)]))
    {
      this.jdField_a_of_type_Anyb.stop();
      anyb[] arrayOfanyb = this.jdField_a_of_type_ArrayOfAnyb;
      i = this.mCurrentIndex + 1;
      this.mCurrentIndex = i;
      this.jdField_a_of_type_Anyb = arrayOfanyb[i];
    }
    this.type = this.jdField_a_of_type_Anyb.type;
    int i = paramInt - this.oi[this.mCurrentIndex];
    float f = i / this.jdField_a_of_type_Anyb.duration;
    if (this.jdField_a_of_type_Anyb.speedType == 1) {
      f = i * i / (this.jdField_a_of_type_Anyb.duration * this.jdField_a_of_type_Anyb.duration);
    }
    for (;;)
    {
      this.jdField_a_of_type_Anyb.s(i, f);
      if ((this.jdField_a_of_type_Anyb.type & 0x1) != 0)
      {
        this.x = this.jdField_a_of_type_Anyb.x;
        this.y = this.jdField_a_of_type_Anyb.y;
      }
      if ((this.jdField_a_of_type_Anyb.type & 0x10) != 0) {
        this.y = this.jdField_a_of_type_Anyb.y;
      }
      if ((this.jdField_a_of_type_Anyb.type & 0x2) != 0) {
        this.scale = this.jdField_a_of_type_Anyb.scale;
      }
      if ((this.jdField_a_of_type_Anyb.type & 0x4) != 0) {
        this.opacity = this.jdField_a_of_type_Anyb.opacity;
      }
      if ((this.jdField_a_of_type_Anyb.type & 0x8) != 0) {
        this.rotate = this.jdField_a_of_type_Anyb.rotate;
      }
      super.s(paramInt, paramFloat);
      return;
      if (this.jdField_a_of_type_Anyb.speedType == 2)
      {
        f = i / this.jdField_a_of_type_Anyb.duration;
        f *= (2.0F - f);
      }
    }
  }
  
  public void start()
  {
    super.start();
    this.mCurrentIndex = 0;
    if (this.jdField_a_of_type_ArrayOfAnyb.length > 0) {
      this.jdField_a_of_type_Anyb = this.jdField_a_of_type_ArrayOfAnyb[this.mCurrentIndex];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anyj
 * JD-Core Version:    0.7.0.1
 */