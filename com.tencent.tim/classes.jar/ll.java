public final class ll
{
  public static final ll a;
  private lm a;
  private int[] af;
  private int[] ag;
  private lm b;
  private final int iR;
  private boolean initialized;
  private final int size;
  
  static
  {
    jdField_a_of_type_Ll = new ll(285, 256);
  }
  
  public ll(int paramInt1, int paramInt2)
  {
    this.iR = paramInt1;
    this.size = paramInt2;
    if (paramInt2 <= 0) {
      initialize();
    }
  }
  
  private void eX()
  {
    if (!this.initialized) {
      initialize();
    }
  }
  
  private void initialize()
  {
    this.af = new int[this.size];
    this.ag = new int[this.size];
    int j = 0;
    int i = 1;
    while (j < this.size)
    {
      this.af[j] = i;
      int k = i << 1;
      i = k;
      if (k >= this.size) {
        i = (k ^ this.iR) & this.size - 1;
      }
      j += 1;
    }
    i = 0;
    while (i < this.size - 1)
    {
      this.ag[this.af[i]] = i;
      i += 1;
    }
    this.jdField_a_of_type_Lm = new lm(this, new int[] { 0 });
    this.b = new lm(this, new int[] { 1 });
    this.initialized = true;
  }
  
  static int j(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  int A(int paramInt)
  {
    eX();
    return this.af[paramInt];
  }
  
  int B(int paramInt)
  {
    eX();
    if (paramInt == 0) {
      throw new IllegalArgumentException();
    }
    return this.ag[paramInt];
  }
  
  int C(int paramInt)
  {
    eX();
    if (paramInt == 0) {
      throw new ArithmeticException();
    }
    return this.af[(this.size - this.ag[paramInt] - 1)];
  }
  
  lm a()
  {
    eX();
    return this.jdField_a_of_type_Lm;
  }
  
  lm a(int paramInt1, int paramInt2)
  {
    eX();
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return this.jdField_a_of_type_Lm;
    }
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new lm(this, arrayOfInt);
  }
  
  int k(int paramInt1, int paramInt2)
  {
    eX();
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0;
    }
    return this.af[((this.ag[paramInt1] + this.ag[paramInt2]) % (this.size - 1))];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ll
 * JD-Core Version:    0.7.0.1
 */