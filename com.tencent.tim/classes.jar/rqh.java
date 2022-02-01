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

public class rqh
  extends AsyncTask<Void, String, rpy>
{
  public Boolean Q = Boolean.valueOf(false);
  public Process a;
  public final rqw a;
  public boolean aJn;
  public boolean aJo;
  public final String[] cb;
  public final rqi e;
  public Context mContext;
  public long startTime;
  public final long timeout;
  public StringBuilder z;
  
  rqh(Context paramContext, String[] paramArrayOfString, long paramLong, boolean paramBoolean, rqi paramrqi)
  {
    this.mContext = paramContext;
    this.cb = paramArrayOfString;
    this.timeout = paramLong;
    this.aJo = paramBoolean;
    this.e = paramrqi;
    this.jdField_a_of_type_Rqw = new rqw();
    this.z = new StringBuilder();
  }
  
  private rpy b()
  {
    rpy localrpy = rpy.a();
    if (this.aJo)
    {
      b(localrpy);
      localrpy.isDone = true;
    }
    return localrpy;
  }
  
  private rpy b(Process paramProcess)
  {
    paramProcess = rpy.a(paramProcess);
    if (this.aJo)
    {
      b(paramProcess);
      paramProcess.isDone = true;
    }
    return paramProcess;
  }
  
  private void b(rpy paramrpy)
  {
    if (this.e != null)
    {
      this.z.append(paramrpy.aBI);
      if (!paramrpy.success) {
        break label92;
      }
      this.e.onSuccess(this.z.toString());
    }
    for (;;)
    {
      this.e.onFinish(paramrpy.success);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
      }
      return;
      label92:
      this.e.onFailure(this.z.toString());
    }
  }
  
  private void bvS()
    throws TimeoutException, InterruptedException
  {
    if (!rqx.a(this.jdField_a_of_type_JavaLangProcess))
    {
      if ((this.timeout != 9223372036854775807L) && (SystemClock.uptimeMillis() > this.startTime + this.timeout))
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
          this.z.append(str).append("\n");
          if (this.aJo)
          {
            if ((TextUtils.isEmpty(str)) || (this.e == null)) {
              continue;
            }
            this.e.onProgress(str);
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
  
  boolean LU()
  {
    return rqx.a(this.jdField_a_of_type_JavaLangProcess);
  }
  
  protected rpy a(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      if (!this.aJn) {
        this.aJn = rqx.v(new File(rqs.am(this.mContext)));
      }
      ram.w("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute start cmd=" + Arrays.toString(this.cb));
      this.jdField_a_of_type_JavaLangProcess = this.jdField_a_of_type_Rqw.a(this.cb);
      paramVarArgs = this.jdField_a_of_type_JavaLangProcess;
      if (paramVarArgs == null)
      {
        paramVarArgs = b();
        return paramVarArgs;
      }
      if (this.Q.booleanValue())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = this.cb;
        int j = arrayOfString.length;
        while (i < j)
        {
          localStringBuilder.append(arrayOfString[i]);
          localStringBuilder.append(' ');
          i += 1;
        }
        publishProgress(new String[] { localStringBuilder.toString() });
      }
      bvS();
      paramVarArgs = b(paramVarArgs);
      return paramVarArgs;
    }
    catch (TimeoutException paramVarArgs)
    {
      ram.e("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "FFmpeg timed out", paramVarArgs);
      paramVarArgs = new rpy(false, paramVarArgs.getMessage());
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      ram.e("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "Error running FFmpeg", paramVarArgs);
      return b();
    }
    finally
    {
      rqx.a(this.jdField_a_of_type_JavaLangProcess);
      ram.w("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", "[story_ffmpeg]execute end cmd=" + Arrays.toString(this.cb));
    }
  }
  
  protected void a(rpy paramrpy)
  {
    if (!paramrpy.isDone) {
      b(paramrpy);
    }
  }
  
  protected void onPreExecute()
  {
    this.startTime = SystemClock.uptimeMillis();
    if (this.e != null)
    {
      if (this.aJo) {
        ThreadManager.post(new FFmpegExecuteAsyncTask.1(this), 5, null, true);
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.ffmpeg.FFmpegExecuteAsyncTask", 2, "ThreadName:" + Thread.currentThread().getName());
    }
    this.e.onStart();
  }
  
  protected void s(String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs[0] != null) && (this.e != null)) {
      this.e.onProgress(paramVarArgs[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqh
 * JD-Core Version:    0.7.0.1
 */