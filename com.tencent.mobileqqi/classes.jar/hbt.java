import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class hbt
{
  private final int jdField_a_of_type_Int;
  private DataInputStream jdField_a_of_type_JavaIoDataInputStream;
  private DataOutputStream jdField_a_of_type_JavaIoDataOutputStream;
  public FileInputStream a;
  FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private final String jdField_a_of_type_JavaLangString;
  
  public hbt(int paramInt, String paramString, FileInputStream paramFileInputStream, FileOutputStream paramFileOutputStream)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaIoFileInputStream = paramFileInputStream;
    this.jdField_a_of_type_JavaIoFileOutputStream = paramFileOutputStream;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public DataInputStream a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaIoFileInputStream != null) {}
      for (this.jdField_a_of_type_JavaIoDataInputStream = new DataInputStream(this.jdField_a_of_type_JavaIoFileInputStream);; this.jdField_a_of_type_JavaIoDataInputStream = null) {
        return this.jdField_a_of_type_JavaIoDataInputStream;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoDataInputStream = null;
      }
    }
  }
  
  public DataOutputStream a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoDataOutputStream != null)
        {
          this.jdField_a_of_type_JavaIoDataOutputStream.close();
          this.jdField_a_of_type_JavaIoDataOutputStream = null;
        }
        if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {
          continue;
        }
        this.jdField_a_of_type_JavaIoDataOutputStream = new DataOutputStream(this.jdField_a_of_type_JavaIoFileOutputStream);
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_JavaIoDataOutputStream = null;
        continue;
      }
      return this.jdField_a_of_type_JavaIoDataOutputStream;
      this.jdField_a_of_type_JavaIoDataOutputStream = null;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoDataInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoDataInputStream.close();
      label14:
      this.jdField_a_of_type_JavaIoDataInputStream = null;
      if (this.jdField_a_of_type_JavaIoDataOutputStream != null) {}
      try
      {
        this.jdField_a_of_type_JavaIoDataOutputStream.close();
        label33:
        this.jdField_a_of_type_JavaIoDataOutputStream = null;
        if (this.jdField_a_of_type_JavaIoFileInputStream != null) {}
        try
        {
          this.jdField_a_of_type_JavaIoFileInputStream.close();
          label52:
          this.jdField_a_of_type_JavaIoFileInputStream = null;
          if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
          try
          {
            this.jdField_a_of_type_JavaIoFileOutputStream.close();
            label71:
            this.jdField_a_of_type_JavaIoFileOutputStream = null;
            return;
          }
          catch (IOException localIOException1)
          {
            break label71;
          }
        }
        catch (IOException localIOException2)
        {
          break label52;
        }
      }
      catch (IOException localIOException3)
      {
        break label33;
      }
    }
    catch (IOException localIOException4)
    {
      break label14;
    }
  }
  
  public String b()
  {
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf('/');
    return this.jdField_a_of_type_JavaLangString.substring(i + 1, this.jdField_a_of_type_JavaLangString.length());
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaIoDataInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoDataInputStream.close();
      label14:
      this.jdField_a_of_type_JavaIoDataInputStream = null;
      if (this.jdField_a_of_type_JavaIoDataOutputStream != null) {}
      try
      {
        this.jdField_a_of_type_JavaIoDataOutputStream.close();
        label33:
        this.jdField_a_of_type_JavaIoDataOutputStream = null;
        try
        {
          if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
            this.jdField_a_of_type_JavaIoFileInputStream.close();
          }
          label52:
          if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
          try
          {
            this.jdField_a_of_type_JavaIoFileOutputStream.close();
            label66:
            this.jdField_a_of_type_JavaIoFileOutputStream = null;
            return;
          }
          catch (IOException localIOException1)
          {
            break label66;
          }
        }
        catch (Exception localException)
        {
          break label52;
        }
      }
      catch (IOException localIOException2)
      {
        break label33;
      }
    }
    catch (IOException localIOException3)
    {
      break label14;
    }
  }
  
  public String c()
  {
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf('/');
    String str = this.jdField_a_of_type_JavaLangString.substring(0, i + 1);
    return str.substring("file:///".length(), str.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hbt
 * JD-Core Version:    0.7.0.1
 */