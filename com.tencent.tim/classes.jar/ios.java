public class ios
{
  boolean TF;
  int angle;
  public int ari;
  public int arj;
  public jjo b;
  byte[] data;
  int format;
  int height;
  long mn;
  long mo;
  int rotation;
  long timestamp;
  int width;
  
  ios() {}
  
  public ios(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.data = paramArrayOfByte;
    this.width = paramInt1;
    this.height = paramInt2;
    this.format = paramInt3;
    this.angle = paramInt4;
    this.rotation = paramInt5;
    this.TF = paramBoolean;
    this.mn = paramLong2;
    this.timestamp = paramLong3;
    this.mo = paramLong1;
    this.ari = 0;
    this.arj = 0;
  }
  
  ios(ios paramios)
  {
    this(paramios.mo, paramios.data, paramios.width, paramios.height, paramios.format, paramios.angle, paramios.rotation, paramios.TF, paramios.mn, paramios.timestamp);
    this.ari = paramios.ari;
    this.arj = paramios.arj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ios
 * JD-Core Version:    0.7.0.1
 */