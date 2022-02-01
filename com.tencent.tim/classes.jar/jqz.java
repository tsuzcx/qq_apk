import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class jqz
{
  private static final ThreadLocal<CharsetDecoder> b = new jra();
  public static final ThreadLocal<Charset> d = new jrb();
  private static final ThreadLocal<CharBuffer> e = new ThreadLocal();
  protected int aCG;
  protected ByteBuffer l;
  
  public boolean S(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 + paramInt2 <= this.l.capacity());
  }
  
  protected String aX(int paramInt)
  {
    return e(paramInt, false);
  }
  
  protected int cQ(int paramInt)
  {
    if (S(paramInt, 4)) {
      return this.l.getInt(paramInt) + paramInt;
    }
    return -1;
  }
  
  protected String e(int paramInt, boolean paramBoolean)
  {
    CharsetDecoder localCharsetDecoder = (CharsetDecoder)b.get();
    localCharsetDecoder.reset();
    int i = paramInt;
    if (!paramBoolean)
    {
      if (!S(paramInt, 4)) {
        return null;
      }
      i = paramInt + this.l.getInt(paramInt);
    }
    if (!S(i, 4)) {
      return null;
    }
    ByteBuffer localByteBuffer = this.l.duplicate().order(ByteOrder.LITTLE_ENDIAN);
    paramInt = localByteBuffer.getInt(i);
    if (!S(i, paramInt + 4)) {
      return null;
    }
    localByteBuffer.position(i + 4);
    localByteBuffer.limit(i + 4 + paramInt);
    paramInt = (int)(paramInt * localCharsetDecoder.maxCharsPerByte());
    Object localObject2 = (CharBuffer)e.get();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((CharBuffer)localObject2).capacity() >= paramInt) {}
    }
    else
    {
      localObject1 = CharBuffer.allocate(paramInt);
      e.set(localObject1);
    }
    ((CharBuffer)localObject1).clear();
    try
    {
      localObject2 = localCharsetDecoder.decode(localByteBuffer, (CharBuffer)localObject1, true);
      if (!((CoderResult)localObject2).isUnderflow()) {
        ((CoderResult)localObject2).throwException();
      }
      return ((CharBuffer)localObject1).flip().toString();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FlatBuffersParser", 1, "convertString error", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jqz
 * JD-Core Version:    0.7.0.1
 */