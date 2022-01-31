import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class zzk
{
  private String jdField_a_of_type_JavaLangString = "";
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  private FileLock jdField_a_of_type_JavaNioChannelsFileLock;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public zzk(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramString)
    {
      zyw.a("KingKongUtils", "Initial FileChannel exception : " + paramString);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    zyw.a("KingKongUtils", "Release Inter-Process Lock " + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaNioChannelsFileLock != null) {}
    try
    {
      this.jdField_a_of_type_JavaNioChannelsFileLock.release();
      if (this.jdField_a_of_type_JavaNioChannelsFileChannel == null) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        this.jdField_a_of_type_JavaNioChannelsFileChannel.close();
        this.b = false;
        return;
        localIOException1 = localIOException1;
        zyw.a("KingKongUtils", "Release Inter-Process Lock " + this.jdField_a_of_type_JavaLangString + " exception : " + localIOException1);
        localIOException1.printStackTrace();
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          zyw.a("KingKongUtils", "Release Inter-Process Lock " + this.jdField_a_of_type_JavaLangString + " exception : " + localIOException2);
        }
      }
    }
  }
  
  public boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.b)) {
      return false;
    }
    zyw.a("KingKongUtils", "Do Inter-Process Lock " + this.jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_JavaNioChannelsFileChannel = new RandomAccessFile(new File(this.jdField_a_of_type_JavaLangString), "rw").getChannel();
      this.jdField_a_of_type_JavaNioChannelsFileLock = this.jdField_a_of_type_JavaNioChannelsFileChannel.lock();
      this.b = true;
      zyw.a("KingKongUtils", "Do Inter-Process Lock OK " + this.jdField_a_of_type_JavaLangString);
      return true;
    }
    catch (Exception localException)
    {
      zyw.a("KingKongUtils", "Do Inter-Process Lock " + this.jdField_a_of_type_JavaLangString + " exception : " + localException);
      if (this.jdField_a_of_type_JavaNioChannelsFileLock == null) {}
    }
    try
    {
      this.jdField_a_of_type_JavaNioChannelsFileLock.release();
      label166:
      if (this.jdField_a_of_type_JavaNioChannelsFileChannel != null) {}
      try
      {
        this.jdField_a_of_type_JavaNioChannelsFileChannel.close();
        label180:
        zyw.a("KingKongUtils", "Do Inter-Process Lock failed " + this.jdField_a_of_type_JavaLangString);
        return false;
      }
      catch (IOException localIOException1)
      {
        break label180;
      }
    }
    catch (IOException localIOException2)
    {
      break label166;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     zzk
 * JD-Core Version:    0.7.0.1
 */