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

public class vnp
  extends AsyncTask<Void, String, vng>
{
  public final long a;
  public Context a;
  public Boolean a;
  public Process a;
  public StringBuilder a;
  public final vnq a;
  public final vog a;
  public boolean a;
  public final String[] a;
  public long b;
  public boolean b;
  
  vnp(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, vnq paramvnq)
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Vnq = paramvnq;
    this.jdField_a_of_type_Vog = new vog();
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  }
  
  private vng a()
  {
    vng localvng = vng.a();
    if (this.jdField_b_of_type_Boolean)
    {
      b(localvng);
      localvng.jdField_b_of_type_Boolean = true;
    }
    return localvng;
  }
  
  private vng a(Process paramProcess)
  {
    paramProcess = vng.a(paramProcess);
    if (this.jdField_b_of_type_Boolean)
    {
      b(paramProcess);
      paramProcess.jdField_b_of_type_Boolean = true;
    }
    return paramProcess;
  }
  
  private void a()
  {
    if (!voh.a(this.jdField_a_of_type_JavaLangProcess))
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
            if ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_Vnq == null)) {
              continue;
            }
            this.jdField_a_of_type_Vnq.onProgress(str);
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
  
  private void b(vng paramvng)
  {
    if (this.jdField_a_of_type_Vnq != null)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramvng.jdField_a_of_type_JavaLangString);
      if (!paramvng.jdField_a_of_type_Boolean) {
        break label92;
      }
      this.jdField_a_of_type_Vnq.onSuccess(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    for (;;)
    {
      this.jdField_a_of_type_Vnq.onFinish(paramvng.jdField_a_of_type_Boolean);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.jdField_a_of_type_Vnq.onFailure(this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  protected vng a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = voh.a(new File(vob.a(this.jdField_a_of_type_AndroidContentContext)));
      }
      urk.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Vog.a(this.jdField_a_of_type_ArrayOfJavaLangString);
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
      urk.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new vng(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      urk.c("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return a();
    }
    finally
    {
      voh.a(this.jdField_a_of_type_JavaLangProcess);
      urk.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString));
    }
  }
  
  protected void a(vng paramvng)
  {
    if (!paramvng.jdField_b_of_type_Boolean) {
      b(paramvng);
    }
  }
  
  protected void a(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.jdField_a_of_type_Vnq != null)) {
      this.jdField_a_of_type_Vnq.onProgress(paramVarArgs[0]);
    }
  }
  
  boolean a()
  {
    return voh.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected void onPreExecute()
  {
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_Vnq != null)
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
    this.jdField_a_of_type_Vnq.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */