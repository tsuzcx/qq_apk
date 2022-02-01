import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class inw
{
  public ArrayList<ing> iz;
  public int retCode;
  public String tip;
  
  public static inw a(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      if (QLog.isColorLevel()) {
        QLog.i("MavInviteData", 2, "getInviteDataFromBuffer detail is null");
      }
    }
    do
    {
      return null;
      if (paramInt != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("MavInviteData", 2, "getInviteDataFromBuffer buflen == 0");
    return null;
    inw localinw = new inw();
    int i = d(paramArrayOfByte, 0);
    localinw.iz = new ArrayList();
    paramInt = 0;
    for (;;)
    {
      if (paramInt < i)
      {
        ing localing = new ing();
        localing.aqq = d(paramArrayOfByte, paramInt * 48 + 4);
        localing.lZ = b(paramArrayOfByte, paramInt * 48 + 4 + 8);
        try
        {
          localing.a.OH = new String(paramArrayOfByte, paramInt * 48 + 4 + 16, 5, "UTF-8");
          localing.a.OI = new String(paramArrayOfByte, paramInt * 48 + 4 + 21, 5, "UTF-8");
          localing.a.OJ = new String(paramArrayOfByte, paramInt * 48 + 4 + 26, 12, "UTF-8");
          localing.result = d(paramArrayOfByte, paramInt * 48 + 4 + 40);
          localing.aqr = d(paramArrayOfByte, paramInt * 48 + 4 + 44);
          localinw.iz.add(localing);
          paramInt += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("MavInviteData", 2, "getInviteDataFromBuffer", localUnsupportedEncodingException);
            }
          }
        }
      }
    }
    paramInt = i * 48 + 4;
    localinw.retCode = d(paramArrayOfByte, paramInt);
    paramInt += 4;
    i = d(paramArrayOfByte, paramInt);
    try
    {
      localinw.tip = new String(paramArrayOfByte, paramInt + 4, i, "UTF-8");
      QLog.e("MavInviteData", 2, String.format("getInviteDataFromBuffer retCode[%d], tips length[%d], tips[%s]", new Object[] { Integer.valueOf(localinw.retCode), Integer.valueOf(i), localinw.tip }));
      return localinw;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  private static long b(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l |= (paramArrayOfByte[(7 - i + paramInt)] & 0xFF) << (7 - i) * 8;
      i += 1;
    }
    return l;
  }
  
  private static int d(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j |= (paramArrayOfByte[(3 - i + paramInt)] & 0xFF) << (3 - i) * 4;
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     inw
 * JD-Core Version:    0.7.0.1
 */