import android.content.Context;
import android.media.MediaRecorder;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class aidu
{
  private static final String TAG = "PTT|" + aidu.class.getSimpleName();
  aidu.a jdField_a_of_type_Aidu$a;
  private aidu.b jdField_a_of_type_Aidu$b;
  private aidu.b b = new aidv(this);
  
  public aidu(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Aidu$a = new aidu.a(paramContext);
  }
  
  public int FA()
  {
    return this.jdField_a_of_type_Aidu$a.FA();
  }
  
  public int Fz()
  {
    this.jdField_a_of_type_Aidu$a.dsh();
    return 0;
  }
  
  public int StopRecording()
  {
    this.jdField_a_of_type_Aidu$a.dsg();
    return 0;
  }
  
  public void a(String paramString, aidu.b paramb)
  {
    this.jdField_a_of_type_Aidu$b = paramb;
    this.jdField_a_of_type_Aidu$a.b(paramString, this.b);
  }
  
  public String wO()
  {
    return ".m4a";
  }
  
  class a
  {
    private MediaRecorder jdField_a_of_type_AndroidMediaMediaRecorder;
    private File aB;
    private aidu.b c;
    private boolean isRecording;
    private Context mContext;
    private String targetName;
    
    public a(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private boolean aoV()
    {
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder = new MediaRecorder();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSource(1);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFormat(2);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioEncoder(3);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioChannels(1);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setAudioSamplingRate(16000);
        this.aB = new File(this.targetName);
        this.jdField_a_of_type_AndroidMediaMediaRecorder.setOutputFile(this.aB.getPath());
        return false;
      }
      catch (Exception localException)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.prepare();
          return true;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          Log.d("MediaRecorder", "IllegalStateException preparing MediaRecorder: " + localIllegalStateException.getMessage());
          cF(3, "prepare recorder exception=" + localIllegalStateException.getMessage());
          return false;
        }
        catch (IOException localIOException)
        {
          Log.d("MediaRecorder", "IOException preparing MediaRecorder: " + localIOException.getMessage());
          cF(4, "  recorder io exception=" + localIOException.getMessage());
        }
        localException = localException;
        localException.printStackTrace();
        Log.d("MediaRecorder", "Exception prepareRecord: ");
        cF(2, "init recorder   exception=" + localException.getMessage());
        return false;
      }
    }
    
    private void cF(int paramInt, String paramString)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaRecorder != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.reset();
        this.jdField_a_of_type_AndroidMediaMediaRecorder.release();
        this.jdField_a_of_type_AndroidMediaMediaRecorder = null;
        Log.d("Recorder", "release Recorder");
      }
      if (this.c != null) {
        this.c.onCompleted(paramInt, paramString);
      }
    }
    
    private void dsi()
    {
      if (aoV()) {}
      try
      {
        allc.a(this.jdField_a_of_type_AndroidMediaMediaRecorder);
        this.isRecording = true;
        Log.d("Recorder", "Start Record");
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        cF(5, "recorder RuntimeException r=" + localRuntimeException.getMessage());
        Log.d("Recorder", "RuntimeException: start() is called immediately after stop()");
      }
    }
    
    public int FA()
    {
      if (this.isRecording) {
        return this.jdField_a_of_type_AndroidMediaMediaRecorder.getMaxAmplitude() * 100 / 32768;
      }
      return 0;
    }
    
    public boolean aoU()
    {
      if ((this.aB != null) && (this.aB.exists())) {
        return this.aB.delete();
      }
      return false;
    }
    
    public void b(String paramString, aidu.b paramb)
    {
      this.targetName = paramString;
      this.c = paramb;
      if (this.isRecording) {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
          cF(1, "status is exception!");
          this.isRecording = false;
          return;
        }
        catch (RuntimeException paramString)
        {
          for (;;)
          {
            Log.d("PttRecorder", "RuntimeException: stop() is called immediately after start()");
            aoU();
          }
        }
      }
      dsi();
    }
    
    public void dsg()
    {
      Log.d("Recorder", "stopRecordSave");
      if (this.isRecording) {
        this.isRecording = false;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
        Log.d("Recorder", this.aB.getPath());
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        Log.d("Recorder", "RuntimeException: stop() is called immediately after start()");
        return;
      }
      finally
      {
        cF(0, this.targetName);
      }
    }
    
    public void dsh()
    {
      Log.d("Recorder", "stopRecordUnSave");
      if (this.isRecording) {
        this.isRecording = false;
      }
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaRecorder.stop();
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          Log.d("Recorder", "RuntimeException: stop() is called immediately after start()");
          aoU();
          cF(-1, "");
        }
      }
      finally
      {
        cF(-1, "");
      }
      if (this.aB.exists()) {
        this.aB.delete();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void onCompleted(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aidu
 * JD-Core Version:    0.7.0.1
 */