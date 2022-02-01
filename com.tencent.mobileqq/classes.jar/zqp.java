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

public class zqp
  extends AsyncTask<Void, String, zqg>
{
  public final long a;
  public Context a;
  public Boolean a;
  public Process a;
  public StringBuilder a;
  public final zqq a;
  public final zrg a;
  public boolean a;
  public final String[] a;
  public long b;
  public boolean b;
  
  zqp(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, zqq paramzqq)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Zqq = paramzqq;
    this.jdField_a_of_type_Zrg = new zrg();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private zqg a()
  {
    zqg localzqg = zqg.a();
    if (this.jdField_b_of_type_Boolean)
    {
      b(localzqg);
      localzqg.jdField_b_of_type_Boolean = true;
    }
    return localzqg;
  }
  
  private zqg a(Process paramProcess)
  {
    paramProcess = zqg.a(paramProcess);
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramProcess);
      paramProcess.jdField_b_of_type_Boolean = true;
    }
    return paramProcess;
  }
  
  private void a()
  {
    if (!zrh.a(this.jdField_a_of_type_JavaLangProcess))
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
            if ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_Zqq == null)) {
              continue;
            }
            this.jdField_a_of_type_Zqq.onProgress(str);
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
  
  private void b(zqg paramzqg)
  {
    if (this.jdField_a_of_type_Zqq != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramzqg.jdField_a_of_type_JavaLangString);
      if (!paramzqg.jdField_a_of_type_Boolean) {
        break label92;
      }
      this.jdField_a_of_type_Zqq.onSuccess(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    for (;;)
    {
      this.jdField_a_of_type_Zqq.onFinish(paramzqg.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.jdField_a_of_type_Zqq.onFailure(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected zqg a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = zrh.a(new File(zrb.a(this.jdField_a_of_type_AndroidContentContext)));
      }
      yuk.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Zrg.a(this.jdField_a_of_type_ArrayOfJavaLangString);
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
      yuk.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new zqg(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      yuk.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return a();
    }
    finally
    {
      zrh.a(this.jdField_a_of_type_JavaLangProcess);
      yuk.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    }
  }
  
  protected void a(zqg paramzqg)
  {
    if (!paramzqg.jdField_b_of_type_Boolean) {
      b(paramzqg);
    }
  }
  
  protected void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.jdField_a_of_type_Zqq != null)) {
      this.jdField_a_of_type_Zqq.onProgress(paramVarArgs[0]);
    }
  }
  
  boolean a()
  {
    return zrh.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected void onPreExecute()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_Zqq != null)
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
    this.jdField_a_of_type_Zqq.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqp
 * JD-Core Version:    0.7.0.1
 */