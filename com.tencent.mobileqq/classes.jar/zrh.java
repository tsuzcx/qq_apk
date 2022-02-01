import android.annotation.TargetApi;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

@TargetApi(14)
class zrh
{
  static String a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      paramInputStream = localStringBuilder.toString();
    }
    catch (IOException paramInputStream)
    {
      yuk.c("Q.qqstory.ffmpeg.FFmpeg", "error converting input stream to string", paramInputStream);
      return null;
    }
    return paramInputStream;
  }
  
  static void a(Process paramProcess)
  {
    if (paramProcess != null) {
      paramProcess.destroy();
    }
  }
  
  static void a(zqp paramzqp)
  {
    if ((paramzqp != null) && (!paramzqp.a()))
    {
      if (paramzqp.jdField_a_of_type_JavaLangProcess != null)
      {
        paramzqp.jdField_a_of_type_JavaLangProcess.destroy();
        paramzqp.jdField_a_of_type_JavaLangProcess = null;
      }
      if (!paramzqp.isCancelled()) {
        paramzqp.cancel(true);
      }
      yuk.e("Q.qqstory.ffmpeg.FFmpeg", "kill ffmpeg task", new Object[] { Arrays.toString(paramzqp.jdField_a_of_type_ArrayOfJavaLangString) });
    }
  }
  
  static boolean a(File paramFile)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFile == null) || (!paramFile.exists())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramFile.canExecute());
      bool1 = bool2;
    } while (paramFile.setExecutable(true));
    return false;
  }
  
  static boolean a(Process paramProcess)
  {
    if (paramProcess == null) {}
    for (;;)
    {
      return true;
      try
      {
        paramProcess.exitValue();
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "isProcessCompleted: true  in  process.exitValue()");
          return true;
        }
      }
      catch (IllegalThreadStateException paramProcess)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.ffmpeg.FFmpegCmd", 2, "IllegalThreadStateException e, ", paramProcess);
        }
      }
    }
    return false;
  }
  
  static <T> T[] a(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    int i = paramArrayOfT1.length;
    int j = paramArrayOfT2.length;
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT1.getClass().getComponentType(), i + j);
    System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, i);
    System.arraycopy(paramArrayOfT2, 0, arrayOfObject, i, j);
    return arrayOfObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zrh
 * JD-Core Version:    0.7.0.1
 */