import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.channel.pb.WeiyunPB.MsgHead;

final class awpq
{
  private static String TAG = "PBSerialization-L";
  
  public static awpp a(byte[] paramArrayOfByte)
  {
    Object localObject = new awpo();
    if (paramArrayOfByte.length < awpo.oL)
    {
      QLog.w(TAG, 1, "buffer length is short than 16!");
      return null;
    }
    ((awpo)localObject).r(paramArrayOfByte);
    if (paramArrayOfByte.length < ((awpo)localObject).getLength())
    {
      QLog.w(TAG, 1, "buffer length is short!");
      return null;
    }
    int i = ((awpo)localObject).getLength() - ((awpo)localObject).bO() - awpo.oL;
    int j = ((awpo)localObject).bO();
    localObject = new byte[i];
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte, awpo.oL, localObject, 0, i);
    System.arraycopy(paramArrayOfByte, i + awpo.oL, arrayOfByte, 0, j);
    paramArrayOfByte = new WeiyunPB.MsgHead();
    try
    {
      paramArrayOfByte.mergeFrom((byte[])localObject);
      paramArrayOfByte = new awpp(paramArrayOfByte, arrayOfByte);
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.e(TAG, 1, "throw InvalidProtocolBufferException.");
    }
    return null;
  }
  
  public static byte[] a(awpp paramawpp)
  {
    byte[] arrayOfByte1 = paramawpp.a().toByteArray();
    paramawpp = paramawpp.getData();
    int i = awpo.oL + arrayOfByte1.length + paramawpp.length;
    Object localObject = new awpo();
    ((awpo)localObject).aL(paramawpp.length);
    ((awpo)localObject).setLength(i);
    localObject = ((awpo)localObject).toByteArray();
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
    i = localObject.length;
    System.arraycopy(paramawpp, 0, arrayOfByte2, arrayOfByte1.length + i, paramawpp.length);
    return arrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awpq
 * JD-Core Version:    0.7.0.1
 */