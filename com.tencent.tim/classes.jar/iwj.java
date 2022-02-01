import android.util.SparseArray;

public class iwj
{
  public short E = 320;
  public short F;
  public short G;
  public byte[] aZ;
  public short height = 240;
  
  public iwj(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ioh.a(paramArrayOfByte);
    iog localiog = (iog)paramArrayOfByte.get(4);
    if (localiog != null) {
      this.aZ = localiog.getValue();
    }
    if (this.aZ != null)
    {
      paramArrayOfByte = (iog)paramArrayOfByte.get(3);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.getValue();
        this.height = ((short)(paramArrayOfByte[0] << 8 | paramArrayOfByte[1] & 0xFF));
        this.E = ((short)(paramArrayOfByte[2] << 8 | paramArrayOfByte[3] & 0xFF));
        this.F = ((short)(paramArrayOfByte[4] << 8 | paramArrayOfByte[5] & 0xFF));
        int i = paramArrayOfByte[6];
        this.G = ((short)(paramArrayOfByte[7] & 0xFF | i << 8));
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("SwitchFaceItem face.length = ");
    if (this.aZ != null) {}
    for (int i = this.aZ.length;; i = 0) {
      return i + ", width = " + this.E + ", height = " + this.height + ", fameWidth = " + this.F + ", frameHeight = " + this.G;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iwj
 * JD-Core Version:    0.7.0.1
 */