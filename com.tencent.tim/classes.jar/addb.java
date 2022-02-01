public class addb
  extends addd
{
  float[] bd;
  int markerType;
  float[] projectionMatrix;
  float sY;
  float sZ;
  float ta;
  
  public addb(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    super(0);
    this.markerType = paramInt;
    this.sY = paramFloat1;
    this.sZ = paramFloat2;
    this.ta = paramFloat3;
    this.bd = paramArrayOfFloat1;
    this.projectionMatrix = paramArrayOfFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addb
 * JD-Core Version:    0.7.0.1
 */