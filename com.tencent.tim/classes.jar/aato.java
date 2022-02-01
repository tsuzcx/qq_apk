public class aato
{
  private short[] b;
  private int mLen;
  private int mPos;
  
  public aato(int paramInt)
  {
    if (paramInt > 0) {
      this.b = new short[paramInt];
    }
    this.mPos = 0;
    this.mLen = 0;
  }
  
  public void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (this.b == null) {}
    do
    {
      do
      {
        return;
        if (this.b.length - this.mPos < paramInt2) {
          break;
        }
        System.arraycopy(paramArrayOfShort, paramInt1, this.b, this.mPos, paramInt2);
        this.mPos += paramInt2;
        if (this.mPos == this.b.length) {
          this.mPos = 0;
        }
        this.mLen += paramInt2;
      } while (this.mLen <= this.b.length);
      this.mLen = this.b.length;
      return;
      System.arraycopy(paramArrayOfShort, paramInt1, this.b, this.mPos, this.b.length - this.mPos);
      System.arraycopy(paramArrayOfShort, this.b.length + paramInt1 - this.mPos, this.b, 0, paramInt2 - (this.b.length - this.mPos));
      this.mPos = (paramInt2 - (this.b.length - this.mPos));
      if (this.mPos == this.b.length) {
        this.mPos = 0;
      }
      this.mLen += paramInt2;
    } while (this.mLen <= this.b.length);
    this.mLen = this.b.length;
  }
  
  public short[] a()
  {
    if ((this.b == null) || (this.mLen == 0) || (this.mLen > this.b.length)) {
      return null;
    }
    short[] arrayOfShort = new short[this.mLen];
    if (this.mPos >= this.mLen)
    {
      System.arraycopy(this.b, this.mPos - this.mLen, arrayOfShort, 0, this.mLen);
      return arrayOfShort;
    }
    System.arraycopy(this.b, this.b.length - (this.mLen - this.mPos), arrayOfShort, 0, this.mLen - this.mPos);
    System.arraycopy(this.b, 0, arrayOfShort, this.mLen - this.mPos, this.mPos);
    return arrayOfShort;
  }
  
  public void reset()
  {
    this.mPos = 0;
    this.mLen = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aato
 * JD-Core Version:    0.7.0.1
 */