package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import hys;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceAndroid
{
  private TraeAudioSession _as = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private Context _context = null;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _dumpEnable = false;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private ReentrantLock _markLock = new ReentrantLock();
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sessionId = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private int apiLevel = 4;
  private boolean bmarked = false;
  
  AudioDeviceAndroid()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(960);
      this._recBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufPlay = new byte[960];
      this._tempBufRec = new byte[960];
      this.apiLevel = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "AudioDeviceAndroid apiLevel:" + this.apiLevel);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if (this.apiLevel <= 0) {
        this.apiLevel = 0;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "MODEL:" + Build.MODEL);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TRAE", 2, localException.getMessage());
        }
      }
    }
  }
  
  private int InitPlayback(int paramInt)
  {
    if (this._isPlaying)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "InitPlayback: sampleRate " + paramInt);
    }
    int j = AudioTrack.getMinBufferSize(paramInt, 4, 2);
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "InitPlayback: min play buf size is " + j);
    }
    int i = j;
    if (j < 6000) {
      i = j * 2;
    }
    this._bufferedPlaySamples = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "InitPlayback: play buf size is " + i);
    }
    if (this._audioTrack != null)
    {
      this._audioTrack.release();
      this._audioTrack = null;
    }
    j = getAudioStreamType();
    try
    {
      this._audioTrack = new AudioTrack(j, paramInt, 4, 2, i, 1);
      if (this._audioTrack.getState() != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TRAE", 2, "InitPlayback: play not initialized " + paramInt);
        }
        return -1;
      }
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, localException1.getMessage());
      }
      return -1;
    }
    this._playPosition = this._audioTrack.getPlaybackHeadPosition();
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "[Config] InitPlayback: streamType:" + j + " samplerate:" + paramInt + " _playPosition:" + this._playPosition);
    }
    if ((this._audioManager == null) && (this._context != null)) {}
    try
    {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
      if (this._audioManager == null) {
        return 0;
      }
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, localException2.getMessage());
      }
      return -1;
    }
    return 0;
  }
  
  private int InitRecording(int paramInt)
  {
    if (this._isRecording)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    int i = AudioRecord.getMinBufferSize(paramInt, 16, 2);
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "InitRecording: min rec buf size is " + i);
    }
    this._bufferedRecSamples = (paramInt * 5 / 200);
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
    }
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    int j = getAudioSource();
    try
    {
      this._audioRecord = new AudioRecord(j, paramInt, 16, 2, i * 2);
      if (this._audioRecord.getState() != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TRAE", 2, "InitRecording:  rec not initialized " + paramInt);
        }
        return -1;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, localException.getMessage());
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + j + " rec sample rate set to " + paramInt + " androidAEC:");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy);
    }
    return 0;
  }
  
  private int PlayAudio(int paramInt)
  {
    if (!this._isPlaying)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "PlayAudio: _isPlaying " + this._isPlaying);
      }
      return -1;
    }
    this._playLock.lock();
    int i;
    try
    {
      AudioTrack localAudioTrack = this._audioTrack;
      if (localAudioTrack == null) {
        return -2;
      }
      bool = this._doPlayInit;
      if (bool == true) {}
      try
      {
        Process.setThreadPriority(-19);
        this._doPlayInit = false;
        this._playBuffer.get(this._tempBufPlay);
        i = this._audioTrack.write(this._tempBufPlay, 0, paramInt);
        this._playBuffer.rewind();
        if (i < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TRAE", 2, "Could not write data from sc (write = " + i + ", length = " + paramInt + ")");
          }
          return -1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "Set play thread priority failed: " + localException.getMessage());
          }
        }
      }
      if (i == paramInt) {
        break label293;
      }
    }
    finally
    {
      this._playLock.unlock();
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, "Could not write all data from sc (write = " + i + ", length = " + paramInt + ")");
    }
    label293:
    boolean bool = this._dumpEnable;
    if (bool) {}
    try
    {
      this._play_out.write(this._tempBufPlay, 0, i);
      this._bufferedPlaySamples += (i >> 1);
      paramInt = this._audioTrack.getPlaybackHeadPosition();
      if (paramInt < this._playPosition) {
        this._playPosition = 0;
      }
      this._bufferedPlaySamples -= paramInt - this._playPosition;
      this._playPosition = paramInt;
      if (!this._isRecording) {
        paramInt = this._bufferedPlaySamples;
      }
      this._playLock.unlock();
      return i;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 137
    //   15: iconst_2
    //   16: new 139	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 317
    //   26: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   33: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   48: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   51: aload_0
    //   52: getfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnonnull +13 -> 72
    //   62: aload_0
    //   63: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   66: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: bipush 254
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 84	com/tencent/sharp/jni/AudioDeviceAndroid:_doRecInit	Z
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_1
    //   79: if_icmpne +13 -> 92
    //   82: bipush 237
    //   84: invokestatic 284	android/os/Process:setThreadPriority	(I)V
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 84	com/tencent/sharp/jni/AudioDeviceAndroid:_doRecInit	Z
    //   92: aload_0
    //   93: getfield 120	com/tencent/sharp/jni/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   96: invokevirtual 296	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   99: pop
    //   100: aload_0
    //   101: getfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   104: aload_0
    //   105: getfield 124	com/tencent/sharp/jni/AudioDeviceAndroid:_tempBufRec	[B
    //   108: iconst_0
    //   109: iload_1
    //   110: invokevirtual 320	android/media/AudioRecord:read	([BII)I
    //   113: istore_2
    //   114: iload_2
    //   115: ifge +150 -> 265
    //   118: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +45 -> 166
    //   124: ldc 137
    //   126: iconst_2
    //   127: new 139	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 322
    //   137: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 300
    //   147: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc_w 302
    //   157: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   170: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   173: iconst_m1
    //   174: ireturn
    //   175: astore 4
    //   177: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -93 -> 87
    //   183: ldc 137
    //   185: iconst_2
    //   186: new 139	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 324
    //   196: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 4
    //   201: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -126 -> 87
    //   216: astore 4
    //   218: iconst_0
    //   219: istore_2
    //   220: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +33 -> 256
    //   226: ldc 137
    //   228: iconst_2
    //   229: new 139	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 326
    //   239: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 4
    //   244: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_0
    //   257: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: iload_2
    //   264: ireturn
    //   265: aload_0
    //   266: getfield 120	com/tencent/sharp/jni/AudioDeviceAndroid:_recBuffer	Ljava/nio/ByteBuffer;
    //   269: aload_0
    //   270: getfield 124	com/tencent/sharp/jni/AudioDeviceAndroid:_tempBufRec	[B
    //   273: iconst_0
    //   274: iload_2
    //   275: invokevirtual 330	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   278: pop
    //   279: aload_0
    //   280: getfield 104	com/tencent/sharp/jni/AudioDeviceAndroid:_dumpEnable	Z
    //   283: istore_3
    //   284: iload_3
    //   285: ifeq +16 -> 301
    //   288: aload_0
    //   289: getfield 100	com/tencent/sharp/jni/AudioDeviceAndroid:_rec_out	Ljava/io/FileOutputStream;
    //   292: aload_0
    //   293: getfield 124	com/tencent/sharp/jni/AudioDeviceAndroid:_tempBufRec	[B
    //   296: iconst_0
    //   297: iload_2
    //   298: invokevirtual 311	java/io/FileOutputStream:write	([BII)V
    //   301: iload_2
    //   302: iload_1
    //   303: if_icmpeq +75 -> 378
    //   306: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +45 -> 354
    //   312: ldc 137
    //   314: iconst_2
    //   315: new 139	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 332
    //   325: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload_2
    //   329: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 300
    //   335: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: iload_1
    //   339: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: ldc_w 302
    //   345: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload_0
    //   355: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   358: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   361: iconst_m1
    //   362: ireturn
    //   363: astore 4
    //   365: aload 4
    //   367: invokevirtual 314	java/io/IOException:printStackTrace	()V
    //   370: goto -69 -> 301
    //   373: astore 4
    //   375: goto -155 -> 220
    //   378: aload_0
    //   379: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   382: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   385: iload_2
    //   386: ireturn
    //   387: astore 4
    //   389: aload_0
    //   390: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   393: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   396: aload 4
    //   398: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	AudioDeviceAndroid
    //   0	399	1	paramInt	int
    //   113	273	2	i	int
    //   76	209	3	bool	boolean
    //   55	3	4	localAudioRecord	AudioRecord
    //   175	25	4	localException1	Exception
    //   216	27	4	localException2	Exception
    //   363	3	4	localIOException	IOException
    //   373	1	4	localException3	Exception
    //   387	10	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	87	175	java/lang/Exception
    //   51	57	216	java/lang/Exception
    //   72	77	216	java/lang/Exception
    //   87	92	216	java/lang/Exception
    //   92	114	216	java/lang/Exception
    //   177	213	216	java/lang/Exception
    //   288	301	363	java/io/IOException
    //   118	166	373	java/lang/Exception
    //   265	284	373	java/lang/Exception
    //   288	301	373	java/lang/Exception
    //   306	354	373	java/lang/Exception
    //   365	370	373	java/lang/Exception
    //   51	57	387	finally
    //   72	77	387	finally
    //   82	87	387	finally
    //   87	92	387	finally
    //   92	114	387	finally
    //   118	166	387	finally
    //   177	213	387	finally
    //   220	256	387	finally
    //   265	284	387	finally
    //   288	301	387	finally
    //   306	354	387	finally
    //   365	370	387	finally
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   11: ifeq +27 -> 38
    //   14: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +12 -> 29
    //   20: ldc 137
    //   22: iconst_2
    //   23: ldc_w 339
    //   26: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   33: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   36: iconst_m1
    //   37: ireturn
    //   38: aload_0
    //   39: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   42: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   45: aload_0
    //   46: getfield 106	com/tencent/sharp/jni/AudioDeviceAndroid:bmarked	Z
    //   49: istore_1
    //   50: aload_0
    //   51: getfield 106	com/tencent/sharp/jni/AudioDeviceAndroid:bmarked	Z
    //   54: ifne +8 -> 62
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 106	com/tencent/sharp/jni/AudioDeviceAndroid:bmarked	Z
    //   62: aload_0
    //   63: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   66: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: iload_1
    //   70: ifne +8 -> 78
    //   73: aload_0
    //   74: invokevirtual 342	com/tencent/sharp/jni/AudioDeviceAndroid:call_preprocess	()I
    //   77: pop
    //   78: aload_0
    //   79: getfield 59	com/tencent/sharp/jni/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   82: invokevirtual 345	android/media/AudioTrack:play	()V
    //   85: aload_0
    //   86: getfield 104	com/tencent/sharp/jni/AudioDeviceAndroid:_dumpEnable	Z
    //   89: ifeq +54 -> 143
    //   92: aload_0
    //   93: new 347	java/io/File
    //   96: dup
    //   97: new 139	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   104: invokestatic 353	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   107: invokevirtual 356	java/io/File:getPath	()Ljava/lang/String;
    //   110: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 358
    //   116: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokespecial 361	java/io/File:<init>	(Ljava/lang/String;)V
    //   125: putfield 98	com/tencent/sharp/jni/AudioDeviceAndroid:_play_dump	Ljava/io/File;
    //   128: aload_0
    //   129: new 308	java/io/FileOutputStream
    //   132: dup
    //   133: aload_0
    //   134: getfield 98	com/tencent/sharp/jni/AudioDeviceAndroid:_play_dump	Ljava/io/File;
    //   137: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   140: putfield 102	com/tencent/sharp/jni/AudioDeviceAndroid:_play_out	Ljava/io/FileOutputStream;
    //   143: aload_0
    //   144: iconst_1
    //   145: putfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   148: aload_0
    //   149: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   152: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   155: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 137
    //   163: iconst_2
    //   164: ldc_w 366
    //   167: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore_2
    //   173: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +12 -> 188
    //   179: ldc 137
    //   181: iconst_2
    //   182: ldc_w 368
    //   185: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_2
    //   189: invokevirtual 369	java/lang/IllegalStateException:printStackTrace	()V
    //   192: aload_0
    //   193: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   196: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   199: iconst_m1
    //   200: ireturn
    //   201: astore_2
    //   202: aload_2
    //   203: invokevirtual 370	java/io/FileNotFoundException:printStackTrace	()V
    //   206: goto -63 -> 143
    //   209: astore_2
    //   210: aload_0
    //   211: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   214: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   217: aload_2
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	AudioDeviceAndroid
    //   49	21	1	bool	boolean
    //   172	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   201	2	2	localFileNotFoundException	java.io.FileNotFoundException
    //   209	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   78	85	172	java/lang/IllegalStateException
    //   128	143	201	java/io/FileNotFoundException
    //   7	29	209	finally
    //   38	62	209	finally
    //   62	69	209	finally
    //   73	78	209	finally
    //   78	85	209	finally
    //   85	128	209	finally
    //   128	143	209	finally
    //   143	148	209	finally
    //   173	188	209	finally
    //   188	192	209	finally
    //   202	206	209	finally
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   11: ifeq +47 -> 58
    //   14: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +32 -> 49
    //   20: ldc 137
    //   22: iconst_2
    //   23: new 139	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 373
    //   33: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   40: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   53: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   56: iconst_m1
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   62: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   65: aload_0
    //   66: getfield 106	com/tencent/sharp/jni/AudioDeviceAndroid:bmarked	Z
    //   69: istore_1
    //   70: aload_0
    //   71: getfield 106	com/tencent/sharp/jni/AudioDeviceAndroid:bmarked	Z
    //   74: ifne +8 -> 82
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 106	com/tencent/sharp/jni/AudioDeviceAndroid:bmarked	Z
    //   82: aload_0
    //   83: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   86: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   89: iload_1
    //   90: ifne +8 -> 98
    //   93: aload_0
    //   94: invokevirtual 342	com/tencent/sharp/jni/AudioDeviceAndroid:call_preprocess	()I
    //   97: pop
    //   98: aload_0
    //   99: getfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   102: invokevirtual 376	android/media/AudioRecord:startRecording	()V
    //   105: aload_0
    //   106: getfield 104	com/tencent/sharp/jni/AudioDeviceAndroid:_dumpEnable	Z
    //   109: ifeq +54 -> 163
    //   112: aload_0
    //   113: new 347	java/io/File
    //   116: dup
    //   117: new 139	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   124: invokestatic 353	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   127: invokevirtual 356	java/io/File:getPath	()Ljava/lang/String;
    //   130: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 378
    //   136: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokespecial 361	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: putfield 96	com/tencent/sharp/jni/AudioDeviceAndroid:_rec_dump	Ljava/io/File;
    //   148: aload_0
    //   149: new 308	java/io/FileOutputStream
    //   152: dup
    //   153: aload_0
    //   154: getfield 96	com/tencent/sharp/jni/AudioDeviceAndroid:_rec_dump	Ljava/io/File;
    //   157: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   160: putfield 100	com/tencent/sharp/jni/AudioDeviceAndroid:_rec_out	Ljava/io/FileOutputStream;
    //   163: aload_0
    //   164: iconst_1
    //   165: putfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   168: aload_0
    //   169: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   172: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   175: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq +12 -> 190
    //   181: ldc 137
    //   183: iconst_2
    //   184: ldc_w 380
    //   187: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_0
    //   191: getfield 73	com/tencent/sharp/jni/AudioDeviceAndroid:_audioManager	Landroid/media/AudioManager;
    //   194: ifnull +11 -> 205
    //   197: aload_0
    //   198: getfield 73	com/tencent/sharp/jni/AudioDeviceAndroid:_audioManager	Landroid/media/AudioManager;
    //   201: invokevirtual 383	android/media/AudioManager:getMode	()I
    //   204: pop
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_2
    //   208: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +12 -> 223
    //   214: ldc 137
    //   216: iconst_2
    //   217: ldc_w 385
    //   220: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: aload_2
    //   224: invokevirtual 369	java/lang/IllegalStateException:printStackTrace	()V
    //   227: aload_0
    //   228: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   231: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   234: iconst_m1
    //   235: ireturn
    //   236: astore_2
    //   237: aload_2
    //   238: invokevirtual 370	java/io/FileNotFoundException:printStackTrace	()V
    //   241: goto -78 -> 163
    //   244: astore_2
    //   245: aload_0
    //   246: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   249: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   252: aload_2
    //   253: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	AudioDeviceAndroid
    //   69	21	1	bool	boolean
    //   207	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   236	2	2	localFileNotFoundException	java.io.FileNotFoundException
    //   244	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   98	105	207	java/lang/IllegalStateException
    //   148	163	236	java/io/FileNotFoundException
    //   7	49	244	finally
    //   58	82	244	finally
    //   82	89	244	finally
    //   93	98	244	finally
    //   98	105	244	finally
    //   105	148	244	finally
    //   148	163	244	finally
    //   163	168	244	finally
    //   208	223	244	finally
    //   223	227	244	finally
    //   237	241	244	finally
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 137
    //   15: iconst_2
    //   16: new 139	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 388
    //   26: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   33: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +12 -> 59
    //   50: ldc 137
    //   52: iconst_2
    //   53: ldc_w 390
    //   56: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 59	com/tencent/sharp/jni/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   70: invokevirtual 393	android/media/AudioTrack:getPlayState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +47 -> 123
    //   79: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +12 -> 94
    //   85: ldc 137
    //   87: iconst_2
    //   88: ldc_w 395
    //   91: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_0
    //   95: getfield 59	com/tencent/sharp/jni/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   98: invokevirtual 398	android/media/AudioTrack:stop	()V
    //   101: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +12 -> 116
    //   107: ldc 137
    //   109: iconst_2
    //   110: ldc_w 400
    //   113: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: getfield 59	com/tencent/sharp/jni/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   120: invokevirtual 403	android/media/AudioTrack:flush	()V
    //   123: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +12 -> 138
    //   129: ldc 137
    //   131: iconst_2
    //   132: ldc_w 405
    //   135: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: aload_0
    //   139: getfield 59	com/tencent/sharp/jni/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   142: invokevirtual 201	android/media/AudioTrack:release	()V
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 59	com/tencent/sharp/jni/AudioDeviceAndroid:_audioTrack	Landroid/media/AudioTrack;
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   155: aload_0
    //   156: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   159: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   162: aload_0
    //   163: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   166: ifne +15 -> 181
    //   169: aload_0
    //   170: getfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   173: ifne +8 -> 181
    //   176: aload_0
    //   177: invokevirtual 408	com/tencent/sharp/jni/AudioDeviceAndroid:call_postprocess	()I
    //   180: pop
    //   181: aload_0
    //   182: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   185: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   188: aload_0
    //   189: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   192: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   195: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   198: ifeq +12 -> 210
    //   201: ldc 137
    //   203: iconst_2
    //   204: ldc_w 410
    //   207: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: iconst_0
    //   211: ireturn
    //   212: astore_2
    //   213: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq +12 -> 228
    //   219: ldc 137
    //   221: iconst_2
    //   222: ldc_w 412
    //   225: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload_2
    //   229: invokevirtual 369	java/lang/IllegalStateException:printStackTrace	()V
    //   232: aload_0
    //   233: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   236: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   239: iconst_m1
    //   240: ireturn
    //   241: astore_2
    //   242: aload_0
    //   243: getfield 78	com/tencent/sharp/jni/AudioDeviceAndroid:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   246: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   249: aload_2
    //   250: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	AudioDeviceAndroid
    //   73	4	1	i	int
    //   212	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   241	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	94	212	java/lang/IllegalStateException
    //   94	101	212	java/lang/IllegalStateException
    //   66	74	241	finally
    //   79	94	241	finally
    //   94	101	241	finally
    //   101	116	241	finally
    //   116	123	241	finally
    //   123	138	241	finally
    //   138	181	241	finally
    //   181	188	241	finally
    //   213	228	241	finally
    //   228	232	241	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 137
    //   15: iconst_2
    //   16: new 139	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 415
    //   26: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   33: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   47: ifeq +12 -> 59
    //   50: ldc 137
    //   52: iconst_2
    //   53: ldc_w 417
    //   56: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 420	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +25 -> 101
    //   79: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +12 -> 94
    //   85: ldc 137
    //   87: iconst_2
    //   88: ldc_w 422
    //   91: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   94: aload_0
    //   95: getfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   98: invokevirtual 423	android/media/AudioRecord:stop	()V
    //   101: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +12 -> 116
    //   107: ldc 137
    //   109: iconst_2
    //   110: ldc_w 425
    //   113: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_0
    //   117: getfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   120: invokevirtual 243	android/media/AudioRecord:release	()V
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield 61	com/tencent/sharp/jni/AudioDeviceAndroid:_audioRecord	Landroid/media/AudioRecord;
    //   128: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +12 -> 143
    //   134: ldc 137
    //   136: iconst_2
    //   137: ldc_w 427
    //   140: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_0
    //   144: iconst_0
    //   145: putfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   148: aload_0
    //   149: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   152: invokevirtual 275	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   155: aload_0
    //   156: getfield 86	com/tencent/sharp/jni/AudioDeviceAndroid:_isRecording	Z
    //   159: ifne +15 -> 174
    //   162: aload_0
    //   163: getfield 88	com/tencent/sharp/jni/AudioDeviceAndroid:_isPlaying	Z
    //   166: ifne +8 -> 174
    //   169: aload_0
    //   170: invokevirtual 408	com/tencent/sharp/jni/AudioDeviceAndroid:call_postprocess	()I
    //   173: pop
    //   174: aload_0
    //   175: getfield 108	com/tencent/sharp/jni/AudioDeviceAndroid:_markLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   178: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   181: aload_0
    //   182: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   185: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   188: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   191: ifeq +12 -> 203
    //   194: ldc 137
    //   196: iconst_2
    //   197: ldc_w 429
    //   200: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   203: aload_0
    //   204: getfield 73	com/tencent/sharp/jni/AudioDeviceAndroid:_audioManager	Landroid/media/AudioManager;
    //   207: ifnull +11 -> 218
    //   210: aload_0
    //   211: getfield 73	com/tencent/sharp/jni/AudioDeviceAndroid:_audioManager	Landroid/media/AudioManager;
    //   214: invokevirtual 383	android/media/AudioManager:getMode	()I
    //   217: pop
    //   218: iconst_0
    //   219: ireturn
    //   220: astore_2
    //   221: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +12 -> 236
    //   227: ldc 137
    //   229: iconst_2
    //   230: ldc_w 431
    //   233: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload_2
    //   237: invokevirtual 369	java/lang/IllegalStateException:printStackTrace	()V
    //   240: aload_0
    //   241: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   244: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   247: iconst_m1
    //   248: ireturn
    //   249: astore_2
    //   250: aload_0
    //   251: getfield 80	com/tencent/sharp/jni/AudioDeviceAndroid:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   254: invokevirtual 278	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   257: aload_2
    //   258: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	AudioDeviceAndroid
    //   73	4	1	i	int
    //   220	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   249	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	94	220	java/lang/IllegalStateException
    //   94	101	220	java/lang/IllegalStateException
    //   66	74	249	finally
    //   79	94	249	finally
    //   94	101	249	finally
    //   101	116	249	finally
    //   116	143	249	finally
    //   143	174	249	finally
    //   174	181	249	finally
    //   221	236	249	finally
    //   236	240	249	finally
  }
  
  private int getAudioSource()
  {
    int i = 0;
    if (this._audioSourcePolicy >= 0) {
      i = this._audioSourcePolicy;
    }
    while (this.apiLevel < 11) {
      return i;
    }
    return 7;
  }
  
  private int getAudioStreamType()
  {
    int i = 0;
    if (this._audioStreamTypePolicy >= 0) {
      i = this._audioStreamTypePolicy;
    }
    return i;
  }
  
  public int call_postprocess()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._as != null)
    {
      this._as.g();
      this._as.a();
    }
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new hys(this));
    }
    if (this._as != null) {
      this._as.a(this._modePolicy, getAudioStreamType());
    }
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.AudioDeviceAndroid
 * JD-Core Version:    0.7.0.1
 */