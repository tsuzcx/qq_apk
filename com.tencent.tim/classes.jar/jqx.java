import java.nio.ByteBuffer;

public class jqx
  extends jqz
{
  public int length;
  
  public jqx a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt < 0) || (paramByteBuffer.capacity() < paramInt + 4)) {
      return null;
    }
    this.length = paramByteBuffer.getInt(paramInt);
    this.aCG = (paramInt + 4);
    this.l = paramByteBuffer;
    return this;
  }
  
  public jqx a(int paramInt, jqx paramjqx)
  {
    return paramjqx.a(cQ(this.aCG + paramInt * 4), this.l);
  }
  
  public jqy a(int paramInt)
  {
    return a(paramInt, new jqy());
  }
  
  public jqy a(int paramInt, jqy paramjqy)
  {
    return paramjqy.a(cQ(this.aCG + paramInt * 4), this.l);
  }
  
  public String getAsString()
  {
    return e(this.aCG - 4, true);
  }
  
  public byte getByte(int paramInt)
  {
    paramInt = this.aCG + paramInt;
    if (S(paramInt, 1)) {
      return this.l.get(paramInt);
    }
    return 0;
  }
  
  public String getString(int paramInt)
  {
    return aX(this.aCG + paramInt * 4);
  }
  
  public int length()
  {
    return this.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqx
 * JD-Core Version:    0.7.0.1
 */