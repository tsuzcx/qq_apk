import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

public class avpb
{
  private ObjectOutputStream a = new ObjectOutputStream(this.h);
  private ByteArrayOutputStream h = new ByteArrayOutputStream();
  
  public avpb()
    throws Exception
  {}
  
  public byte[] aL()
  {
    try
    {
      this.a.close();
      try
      {
        label7:
        arrayOfByte1 = this.h.toByteArray();
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            byte[] arrayOfByte1;
            this.h.close();
            return arrayOfByte1;
          }
          catch (Exception localException3)
          {
            byte[] arrayOfByte2;
            return arrayOfByte2;
          }
          localException1 = localException1;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.qqwalletmsg", 2, "flushDataAndCloseStream toByteArray Exception", localException1);
          }
          arrayOfByte2 = null;
        }
      }
    }
    catch (Exception localException2)
    {
      break label7;
    }
  }
  
  public void jq(String paramString1, String paramString2)
    throws Exception
  {
    if (paramString1 == null)
    {
      this.a.writeUTF(paramString2);
      return;
    }
    this.a.writeUTF(paramString1);
  }
  
  public void writeBoolean(boolean paramBoolean)
    throws Exception
  {
    this.a.writeBoolean(paramBoolean);
  }
  
  public void writeInt(int paramInt)
    throws Exception
  {
    this.a.writeInt(paramInt);
  }
  
  public void writeObject(Object paramObject)
    throws Exception
  {
    this.a.writeObject(paramObject);
  }
  
  public void writeUTF(String paramString)
    throws Exception
  {
    jq(paramString, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpb
 * JD-Core Version:    0.7.0.1
 */