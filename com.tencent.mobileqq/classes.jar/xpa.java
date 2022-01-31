import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegExecuteAsyncTask.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

public class xpa
  extends AsyncTask<Void, String, xor>
{
  public final long a;
  public Context a;
  public Boolean a;
  public Process a;
  public StringBuilder a;
  public final xpb a;
  public final xpr a;
  public boolean a;
  public final String[] a;
  public long b;
  public boolean b;
  
  xpa(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, xpb paramxpb)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Xpb = paramxpb;
    this.jdField_a_of_type_Xpr = new xpr();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private xor a()
  {
    xor localxor = xor.a();
    if (this.jdField_b_of_type_Boolean)
    {
      b(localxor);
      localxor.jdField_b_of_type_Boolean = true;
    }
    return localxor;
  }
  
  private xor a(Process paramProcess)
  {
    paramProcess = xor.a(paramProcess);
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramProcess);
      paramProcess.jdField_b_of_type_Boolean = true;
    }
    return paramProcess;
  }
  
  private void a()
  {
    if (!xps.a(this.jdField_a_of_type_JavaLangProcess))
    {
      if ((this.jdField_a_of_type_Long != 9223372036854775807L) && (SystemClock.uptimeMillis() > this.jdField_b_of_type_Long + this.jdField_a_of_type_Long))
      {
        QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow]  timeout");
        throw new TimeoutException("FFmpeg timed out");
      }
      for (;;)
      {
        String str;
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(this.jdField_a_of_type_JavaLangProcess.getInputStream()));
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          if (isCancelled()) {
            return;
          }
          this.jdField_a_of_type_JavaLangStringBuilder.append(str).append("\n");
          if (this.jdField_b_of_type_Boolean)
          {
            if ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_Xpb == null)) {
              continue;
            }
            this.jdField_a_of_type_Xpb.onProgress(str);
            continue;
          }
        }
        catch (IOException localIOException)
        {
          QLog.i("Q.qqstory.ffmpeg.FFmpegCmd", 1, "[vs_publish_flow]  IOException");
          localIOException.printStackTrace();
        }
        publishProgress(new String[] { str });
      }
    }
  }
  
  private void b(xor paramxor)
  {
    if (this.jdField_a_of_type_Xpb != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramxor.jdField_a_of_type_JavaLangString);
      if (!paramxor.jdField_a_of_type_Boolean) {
        break label92;
      }
      this.jdField_a_of_type_Xpb.onSuccess(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    for (;;)
    {
      this.jdField_a_of_type_Xpb.onFinish(paramxor.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.jdField_a_of_type_Xpb.onFailure(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected xor a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = xps.a(new File(xpm.a(this.jdField_a_of_type_AndroidContentContext)));
      }
      wsv.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Xpr.a(this.jdField_a_of_type_ArrayOfJavaLangString);
      paramVarArgs = this.jdField_a_of_type_JavaLangProcess;
      if (paramVarArgs == null)
      {
        paramVarArgs = a();
        return paramVarArgs;
      }
      if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        int j = arrayOfString.length;
        while (i < j)
        {
          localStringBuilder.append(arrayOfString[i]);
          localStringBuilder.append(' ');
          i += 1;
        }
        publishProgress(new String[] { localStringBuilder.toString() });
      }
      a();
      paramVarArgs = a(paramVarArgs);
      return paramVarArgs;
    }
    catch (TimeoutException paramVarArgs)
    {
      wsv.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new xor(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      wsv.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return a();
    }
    finally
    {
      xps.a(this.jdField_a_of_type_JavaLangProcess);
      wsv.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    }
  }
  
  protected void a(xor paramxor)
  {
    if (!paramxor.jdField_b_of_type_Boolean) {
      b(paramxor);
    }
  }
  
  protected void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.jdField_a_of_type_Xpb != null)) {
      this.jdField_a_of_type_Xpb.onProgress(paramVarArgs[0]);
    }
  }
  
  boolean a()
  {
    return xps.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected void onPreExecute()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_Xpb != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        ThreadManager.post(new FFmpegExecuteAsyncTask.1(this), 5, null, true);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.jdField_a_of_type_Xpb.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xpa
 * JD-Core Version:    0.7.0.1
 */