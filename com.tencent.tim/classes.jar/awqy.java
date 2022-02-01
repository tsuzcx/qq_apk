import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class awqy
{
  private final byte[] mCheckSum;
  private final short mCheckSumLength;
  private final int mCmd;
  private int mErrorCode;
  private final long mFileSize;
  private long mNextOffset;
  private short mRspFlag;
  private long mSeq;
  private final byte[] mUKey;
  
  public awqy(int paramInt, byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
    throws IllegalArgumentException
  {
    this.mCmd = paramInt;
    this.mFileSize = paramLong1;
    this.mUKey = paramArrayOfByte2;
    this.mSeq = paramLong2;
    this.mCheckSum = new byte[20];
    if (paramArrayOfByte1.length > 20) {
      throw new IllegalArgumentException("file Hash is too long.");
    }
    this.mCheckSumLength = ((short)paramArrayOfByte1.length);
    paramInt = 0;
    while (paramInt < paramArrayOfByte1.length)
    {
      this.mCheckSum[paramInt] = paramArrayOfByte1[paramInt];
      paramInt += 1;
    }
  }
  
  public int buildUploadRequestHead(long paramLong, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, paramInt2, paramInt3);
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    }
    paramArrayOfByte.putInt(-1412589450);
    paramArrayOfByte.putInt(this.mCmd);
    paramArrayOfByte.putInt((int)this.mSeq);
    if (this.mCmd == 1000) {}
    for (paramInt2 = this.mUKey.length + 2 + 34 + paramInt1;; paramInt2 = this.mUKey.length + 2 + 42 + paramInt1)
    {
      paramArrayOfByte.putInt(paramInt2);
      short s = (short)this.mUKey.length;
      paramArrayOfByte.putShort(s);
      paramArrayOfByte.put(this.mUKey, 0, s);
      paramArrayOfByte.putShort(this.mCheckSumLength);
      paramArrayOfByte.put(this.mCheckSum);
      paramArrayOfByte.putInt((int)(this.mFileSize & 0xFFFFFFFF));
      paramArrayOfByte.putInt((int)(0xFFFFFFFF & paramLong));
      paramArrayOfByte.putInt(paramInt1);
      if (this.mCmd == 1007)
      {
        paramArrayOfByte.putInt((int)((this.mFileSize & 0x0) >> 32));
        paramArrayOfByte.putInt((int)((0x0 & paramLong) >> 32));
      }
      return paramInt2 + 16 - paramInt1;
    }
  }
  
  public int getHeadLength()
  {
    if (this.mCmd == 1000) {
      return this.mUKey.length + 2 + 34 + 16;
    }
    return this.mUKey.length + 2 + 42 + 16;
  }
  
  public short getUploadRspFlag()
  {
    return this.mRspFlag;
  }
  
  public long getUploadRspNextOffset()
  {
    return this.mNextOffset;
  }
  
  public int parseUploadRsp(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte, 0, paramInt);
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      paramArrayOfByte.order(ByteOrder.BIG_ENDIAN);
    }
    long l1 = paramArrayOfByte.getInt();
    this.mErrorCode = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    paramInt = paramArrayOfByte.getInt();
    if (l1 != -1412589450L) {}
    do
    {
      return 100002;
      if (this.mErrorCode != 0) {
        return this.mErrorCode;
      }
      if (!paramBoolean) {
        break;
      }
    } while ((paramInt != 5) && (paramInt != 9));
    this.mRspFlag = ((short)paramArrayOfByte.get());
    l1 = 0L;
    long l2 = paramArrayOfByte.getInt();
    if (this.mCmd == 1007) {
      l1 = paramArrayOfByte.getInt();
    }
    this.mNextOffset = ((l1 << 32 & 0x0) + (l2 & 0xFFFFFFFF));
    return 0;
  }
  
  public void setSeq(long paramLong)
  {
    this.mSeq = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awqy
 * JD-Core Version:    0.7.0.1
 */