package com.weiyun.sdk.job.api;

import com.weiyun.sdk.log.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class StoragePlatomProto
{
  public static final int BACKFORWARD_UPLOAD = 2;
  public static final long BIT64_HIGH32_MASK = -4294967296L;
  public static final long BIT64_LOW32_MASK = 4294967295L;
  public static final int CONT_UPLOAD = 0;
  public static final int FTN_ERR_UPFILE_SHA_NOEQUAL = -29200;
  public static final int FTN_HTTP_CMD_UPLOAD = 1000;
  public static final int FTN_HTTP_CMD_UPLOAD_SUPER4G_FILE = 1007;
  public static final int FTN_HTTP_HEADER_LEN = 16;
  public static final long FTN_HTTP_MAGIC_NUM = -1412589450L;
  public static final int FTN_HTTP_NORMAL_HEADER_LEN = 34;
  public static final int FTN_HTTP_SUPER4G_HEADER_LEN = 42;
  public static final int FTN_HTTP_UPLOAD_RSP_BODY_LEN = 5;
  public static final int FTN_HTTP_UPLOAD_SUPER4G_RSP_BODY_LEN = 9;
  public static final int FTN_INVALID_REQ_PARAMS = 100001;
  public static final int FTN_INVALID_RSP_FORMAT = 100002;
  public static final int FTN_UKEY_MAX_LEN = 20;
  private static final String TAG = "StoragePlatomProto";
  public static final int UPLOAD_DONE = 1;
  private final byte[] mCheckSum;
  private final short mCheckSumLength;
  private final int mCmd;
  private int mErrorCode;
  private final long mFileSize;
  private long mNextOffset;
  private short mRspFlag;
  private long mSeq;
  private final byte[] mUKey;
  
  public StoragePlatomProto(int paramInt, byte[] paramArrayOfByte1, long paramLong1, byte[] paramArrayOfByte2, long paramLong2)
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
    for (;;)
    {
      if (paramInt >= paramArrayOfByte1.length) {
        return;
      }
      this.mCheckSum[paramInt] = paramArrayOfByte1[paramInt];
      paramInt += 1;
    }
  }
  
  public int buildUploadReq(long paramLong1, byte[] paramArrayOfByte1, long paramLong2, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, byte[] paramArrayOfByte4)
  {
    int i = buildUploadRequestHead(paramLong2, paramInt, paramArrayOfByte4, 0, paramArrayOfByte4.length);
    System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte4, i, paramArrayOfByte3.length);
    return i + paramInt;
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
  
  public int getUploadRspErrCode()
  {
    return this.mErrorCode;
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
    if (l1 != -1412589450L)
    {
      Log.w("StoragePlatomProto", "Upload file recieved invalid MAGICNUM:" + l1);
      return 100002;
    }
    if (this.mErrorCode != 0) {
      return this.mErrorCode;
    }
    if (paramBoolean)
    {
      if ((paramInt != 5) && (paramInt != 9))
      {
        Log.w("StoragePlatomProto", "Upload file recieved invalid bodyLen: " + paramInt);
        return 100002;
      }
      this.mRspFlag = paramArrayOfByte.get();
      l1 = 0L;
      long l2 = paramArrayOfByte.getInt();
      if (this.mCmd == 1007) {
        l1 = paramArrayOfByte.getInt();
      }
      this.mNextOffset = ((0xFFFFFFFF & l2) + (l1 << 32 & 0x0));
    }
    return 0;
  }
  
  public void setSeq(long paramLong)
  {
    this.mSeq = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.api.StoragePlatomProto
 * JD-Core Version:    0.7.0.1
 */