import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class mrh
{
  public static final String TAG = mrh.class.getSimpleName();
  private static mrh jdField_a_of_type_Mrh;
  private SocializeFeedsInfo.UGCVoiceInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo;
  private boolean anz;
  private AudioManager audioManager = (AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio");
  private Runnable cK = new ReadInJoyVoicePlayController.3(this);
  private WeakReference<mrh.a> ck;
  private Handler handler = new Handler(Looper.getMainLooper());
  private MediaPlayer mMediaPlayer;
  
  public static mrh a()
  {
    if (jdField_a_of_type_Mrh == null) {}
    try
    {
      if (jdField_a_of_type_Mrh == null) {
        jdField_a_of_type_Mrh = new mrh();
      }
      return jdField_a_of_type_Mrh;
    }
    finally {}
  }
  
  public void a(mrh.a parama, SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo)
  {
    if (this.mMediaPlayer == null) {
      this.mMediaPlayer = new MediaPlayer();
    }
    aRx();
    this.mMediaPlayer.reset();
    this.ck = new WeakReference(parama);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo = paramUGCVoiceInfo;
    this.mMediaPlayer.setOnPreparedListener(new mri(this));
    this.mMediaPlayer.setOnCompletionListener(new mrj(this));
    try
    {
      this.mMediaPlayer.setDataSource(paramUGCVoiceInfo.voiceUrl);
      this.mMediaPlayer.prepareAsync();
      return;
    }
    catch (IOException parama)
    {
      parama.printStackTrace();
    }
  }
  
  public void aRx()
  {
    if (this.mMediaPlayer != null) {}
    try
    {
      this.mMediaPlayer.stop();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo.isPlaying = false;
        if (this.ck != null)
        {
          mrh.a locala = (mrh.a)this.ck.get();
          if (locala != null)
          {
            locala.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCVoiceInfo);
            z(false, "ugc voice play");
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  /* Error */
  public void z(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 94	mrh:anz	Z
    //   7: aload_0
    //   8: getfield 51	mrh:handler	Landroid/os/Handler;
    //   11: ifnull +81 -> 92
    //   14: aload_0
    //   15: getfield 58	mrh:cK	Ljava/lang/Runnable;
    //   18: ifnull +74 -> 92
    //   21: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +38 -> 62
    //   27: getstatic 34	mrh:TAG	Ljava/lang/String;
    //   30: iconst_2
    //   31: new 173	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   38: ldc 176
    //   40: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc 185
    //   49: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_2
    //   53: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_0
    //   63: getfield 51	mrh:handler	Landroid/os/Handler;
    //   66: aload_0
    //   67: getfield 58	mrh:cK	Ljava/lang/Runnable;
    //   70: invokevirtual 196	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   73: aload_0
    //   74: getfield 94	mrh:anz	Z
    //   77: ifeq +18 -> 95
    //   80: aload_0
    //   81: getfield 51	mrh:handler	Landroid/os/Handler;
    //   84: aload_0
    //   85: getfield 58	mrh:cK	Ljava/lang/Runnable;
    //   88: invokevirtual 200	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   91: pop
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: aload_0
    //   96: getfield 51	mrh:handler	Landroid/os/Handler;
    //   99: aload_0
    //   100: getfield 58	mrh:cK	Ljava/lang/Runnable;
    //   103: ldc2_w 201
    //   106: invokevirtual 206	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   109: pop
    //   110: goto -18 -> 92
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	mrh
    //   0	118	1	paramBoolean	boolean
    //   0	118	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	62	113	finally
    //   62	92	113	finally
    //   95	110	113	finally
  }
  
  public static abstract interface a
  {
    public abstract void a(SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo);
    
    public abstract void b(SocializeFeedsInfo.UGCVoiceInfo paramUGCVoiceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrh
 * JD-Core Version:    0.7.0.1
 */