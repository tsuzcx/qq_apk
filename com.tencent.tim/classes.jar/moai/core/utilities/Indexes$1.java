package moai.core.utilities;

import java.nio.ByteBuffer;

final class Indexes$1
  extends ThreadLocal<ByteBuffer>
{
  public ByteBuffer get()
  {
    ByteBuffer localByteBuffer = (ByteBuffer)super.get();
    localByteBuffer.clear();
    return localByteBuffer;
  }
  
  protected ByteBuffer initialValue()
  {
    return ByteBuffer.allocate(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Indexes.1
 * JD-Core Version:    0.7.0.1
 */