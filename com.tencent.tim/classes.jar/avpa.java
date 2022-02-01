import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class avpa
{
  private ByteArrayInputStream jdField_a_of_type_JavaIoByteArrayInputStream;
  private ObjectInputStream jdField_a_of_type_JavaIoObjectInputStream;
  private boolean dnK;
  
  private avpa() {}
  
  public avpa(byte[] paramArrayOfByte)
    throws Exception
  {
    this.jdField_a_of_type_JavaIoByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    this.jdField_a_of_type_JavaIoObjectInputStream = new ObjectInputStream(this.jdField_a_of_type_JavaIoByteArrayInputStream);
  }
  
  public boolean bO(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!this.dnK) {}
    try
    {
      bool = this.jdField_a_of_type_JavaIoObjectInputStream.readBoolean();
      return bool;
    }
    catch (Exception localException)
    {
      this.dnK = true;
    }
    return paramBoolean;
  }
  
  public void close()
  {
    try
    {
      this.jdField_a_of_type_JavaIoObjectInputStream.close();
      try
      {
        label7:
        this.jdField_a_of_type_JavaIoByteArrayInputStream.close();
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label7;
    }
  }
  
  public Object i(Object paramObject)
  {
    Object localObject = paramObject;
    if (!this.dnK) {}
    try
    {
      localObject = this.jdField_a_of_type_JavaIoObjectInputStream.readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      this.dnK = true;
    }
    return paramObject;
  }
  
  public String rO(String paramString)
  {
    String str = paramString;
    if (!this.dnK) {}
    try
    {
      str = this.jdField_a_of_type_JavaIoObjectInputStream.readUTF();
      return str;
    }
    catch (Exception localException)
    {
      this.dnK = true;
    }
    return paramString;
  }
  
  public boolean readBoolean()
  {
    return bO(false);
  }
  
  public int readInt()
  {
    return readInt(0);
  }
  
  public int readInt(int paramInt)
  {
    int i = paramInt;
    if (!this.dnK) {}
    try
    {
      i = this.jdField_a_of_type_JavaIoObjectInputStream.readInt();
      return i;
    }
    catch (Exception localException)
    {
      this.dnK = true;
    }
    return paramInt;
  }
  
  public String readUTF()
  {
    return rO("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avpa
 * JD-Core Version:    0.7.0.1
 */