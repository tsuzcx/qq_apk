import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class jqy
  extends jqz
{
  protected int aCE;
  protected int aCF;
  
  public static jqy a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, new jqy());
  }
  
  public static jqy a(ByteBuffer paramByteBuffer, jqy paramjqy)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (paramByteBuffer.capacity() < paramByteBuffer.position() + 4) {
      return null;
    }
    return paramjqy.a(paramByteBuffer.getInt(paramByteBuffer.position()) + paramByteBuffer.position(), paramByteBuffer);
  }
  
  private int cP(int paramInt)
  {
    paramInt = (paramInt + 2) * 2;
    if (paramInt < this.aCF) {
      return this.l.getShort(paramInt + this.aCE);
    }
    return 0;
  }
  
  public jqx a(int paramInt)
  {
    return a(paramInt, new jqx());
  }
  
  public jqx a(int paramInt, jqx paramjqx)
  {
    paramInt = cP(paramInt);
    if (paramInt != 0) {
      return paramjqx.a(cQ(paramInt + this.aCG), this.l);
    }
    return null;
  }
  
  public jqy a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt < 0) || (paramByteBuffer.capacity() < paramInt + 4)) {
      paramByteBuffer = null;
    }
    do
    {
      return paramByteBuffer;
      this.aCG = paramInt;
      this.l = paramByteBuffer;
      this.aCE = (this.aCG - this.l.getInt(this.aCG));
      if (!S(this.aCE, 2)) {
        return null;
      }
      this.aCF = this.l.getShort(this.aCE);
      paramByteBuffer = this;
    } while (S(this.aCE, this.aCF));
    return null;
  }
  
  public long getLong(int paramInt, long paramLong)
  {
    paramInt = cP(paramInt);
    if (paramInt != 0) {
      paramLong = this.l.getLong(paramInt + this.aCG);
    }
    return paramLong;
  }
  
  public String getString(int paramInt)
  {
    paramInt = cP(paramInt);
    if (paramInt != 0) {
      return aX(paramInt + this.aCG);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqy
 * JD-Core Version:    0.7.0.1
 */