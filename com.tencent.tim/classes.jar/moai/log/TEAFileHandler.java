package moai.log;

import java.nio.ByteBuffer;

public class TEAFileHandler
  extends FileHandlerDelegate
{
  private final byte[] key;
  
  public TEAFileHandler(FileHandler paramFileHandler, byte[] paramArrayOfByte)
  {
    super(paramFileHandler);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 16))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("key error: ");
      if (paramArrayOfByte != null) {}
      for (paramFileHandler = Integer.valueOf(paramArrayOfByte.length);; paramFileHandler = null) {
        throw new IllegalArgumentException(paramFileHandler);
      }
    }
    this.key = paramArrayOfByte;
  }
  
  protected boolean onWriteToBuf(FileHandler.LogData paramLogData, ByteBufferWrapper paramByteBufferWrapper)
  {
    super.onWriteToBuf(paramLogData, paramByteBufferWrapper);
    int m = paramByteBufferWrapper.position();
    int k = paramByteBufferWrapper.length() - m;
    if (k > 0)
    {
      int j = k / 8;
      if (k % 8 == 0)
      {
        i = 0;
        i = (i + j) * 8;
        j = i;
        if (m + i < 65536) {
          break label172;
        }
        if (paramLogData.msg != null) {
          break label154;
        }
        j = 0;
        label74:
        if (paramLogData.throwable == null) {
          break label166;
        }
      }
      label154:
      label166:
      for (boolean bool = true;; bool = false)
      {
        appendDebugLog(String.format("errtea:pos:%d:len:%d:msg:%d:th:%b", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Boolean.valueOf(bool) }));
        for (;;)
        {
          j = i;
          if (m + i < 65536) {
            break;
          }
          i -= 8;
        }
        i = 1;
        break;
        j = paramLogData.msg.length();
        break label74;
      }
      label172:
      int i = k;
      while (i < j)
      {
        paramByteBufferWrapper.toBuffer().array()[(i + m)] = 0;
        i += 1;
      }
      TEA.encrypt16(paramByteBufferWrapper.toBuffer().array(), m, j, this.key, paramByteBufferWrapper.toBuffer().array(), m);
      paramByteBufferWrapper.setLength(m + j);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.TEAFileHandler
 * JD-Core Version:    0.7.0.1
 */