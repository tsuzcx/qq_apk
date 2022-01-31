package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import hyt;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static boolean _dumpEnable = false;
  private static boolean _logEnable = true;
  private TraeAudioSession _as = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private boolean _audioRouteChanged = false;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context = null;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private int _playSamplerate = 8000;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sessionId = 0;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(960);
      this._recBuffer = ByteBuffer.allocateDirect(960);
      this._tempBufPlay = new byte[960];
      this._tempBufRec = new byte[960];
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if ((i > 0) || (QLog.isColorLevel())) {
        QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException.getMessage());
        }
      }
    }
  }
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback entry: sampleRate " + paramInt);
    }
    if ((this._isPlaying) || (this._audioTrack != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    for (;;)
    {
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        this._playSamplerate = paramInt;
        int j = AudioTrack.getMinBufferSize(paramInt, 4, 2);
        this._bufferedPlaySamples = 0;
        if (this._audioTrack != null)
        {
          this._audioTrack.release();
          this._audioTrack = null;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp147_145 = arrayOfInt;
        tmp147_145[0] = 0;
        int[] tmp151_147 = tmp147_145;
        tmp151_147[1] = 0;
        int[] tmp155_151 = tmp151_147;
        tmp155_151[2] = 3;
        int[] tmp159_155 = tmp155_151;
        tmp159_155[3] = 1;
        tmp159_155;
        this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
        if (!this._audioRouteChanged)
        {
          arrayOfInt[0] = this._streamType;
          paramInt = 0;
          if ((paramInt >= arrayOfInt.length) || (this._audioTrack != null)) {
            break;
          }
          this._streamType = arrayOfInt[paramInt];
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + j + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          i = 1;
          if (i > 2) {
            break label547;
          }
          k = j * i;
        }
      }
      catch (Exception localException1)
      {
        int i;
        int k;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      try
      {
        this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, 4, 2, k, 1);
        if (this._audioTrack.getState() == 1) {
          break label547;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + k + " sr:" + this._playSamplerate);
        }
        this._audioTrack.release();
        this._audioTrack = null;
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          break label525;
        }
        QLog.w("TRAE", 2, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
        if (this._audioTrack == null) {
          break label539;
        }
        this._audioTrack.release();
        this._audioTrack = null;
        continue;
      }
      i += 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
      }
      if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {}
      for (this._streamType = 3;; this._streamType = 0)
      {
        this._audioRouteChanged = false;
        break;
      }
      label525:
      label539:
      label547:
      paramInt += 1;
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitPlayback fail!!!");
      }
      return -1;
    }
    if ((this._as != null) && (this._audioManager != null)) {
      this._as.b(this._audioManager.getMode(), this._streamType);
    }
    this._playPosition = this._audioTrack.getPlaybackHeadPosition();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition);
    }
    AudioManager localAudioManager = this._audioManager;
    if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET")) {}
    for (paramInt = 6;; paramInt = this._audioTrack.getStreamType())
    {
      TraeAudioManager.a(localAudioManager, paramInt);
      return 0;
    }
  }
  
  private int InitRecording(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording entry:" + paramInt);
    }
    if ((this._isRecording) || (this._audioRecord != null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    int k = AudioRecord.getMinBufferSize(paramInt, 16, 2);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + k + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer());
    }
    this._bufferedRecSamples = (paramInt * 5 / 200);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
    }
    if (this._audioRecord != null)
    {
      this._audioRecord.release();
      this._audioRecord = null;
    }
    int[] arrayOfInt = new int[4];
    int[] tmp222_220 = arrayOfInt;
    tmp222_220[0] = 0;
    int[] tmp226_222 = tmp222_220;
    tmp226_222[1] = 1;
    int[] tmp230_226 = tmp226_222;
    tmp230_226[2] = 5;
    int[] tmp234_230 = tmp230_226;
    tmp234_230[3] = 0;
    tmp234_230;
    arrayOfInt[0] = TraeAudioManager.a(this._audioSourcePolicy);
    int i = 0;
    while ((i < arrayOfInt.length) && (this._audioRecord == null))
    {
      this._audioSource = arrayOfInt[i];
      int j = 1;
      for (;;)
      {
        if (j > 2) {
          break label460;
        }
        int m = k * j;
        try
        {
          this._audioRecord = new AudioRecord(this._audioSource, paramInt, 16, 2, m);
          if (this._audioRecord.getState() == 1) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + m + " sr:" + paramInt + " as:" + this._audioSource);
          }
          this._audioRecord.release();
          this._audioRecord = null;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("TRAE", 2, localIllegalArgumentException.getMessage() + " _audioRecord:" + this._audioRecord);
            }
            if (this._audioRecord != null) {
              this._audioRecord.release();
            }
            this._audioRecord = null;
          }
        }
        j += 1;
      }
      label460:
      i += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitRecording fail!!!");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt + " androidAEC:");
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording exit");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy);
    }
    return 0;
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {}
    do
    {
      return;
      paramString = getTraceInfo() + " entry:" + paramString;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, paramString);
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {}
    String str;
    do
    {
      return;
      str = getTraceInfo() + " exit";
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, str);
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   4: ifne +70 -> 74
    //   7: iconst_1
    //   8: istore_2
    //   9: aload_0
    //   10: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   13: ifnonnull +66 -> 79
    //   16: iconst_1
    //   17: istore_3
    //   18: iload_2
    //   19: iload_3
    //   20: ior
    //   21: ifeq +63 -> 84
    //   24: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +45 -> 72
    //   30: ldc 151
    //   32: iconst_2
    //   33: new 153	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 363
    //   43: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   50: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: ldc_w 365
    //   56: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   63: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: iconst_m1
    //   73: ireturn
    //   74: iconst_0
    //   75: istore_2
    //   76: goto -67 -> 9
    //   79: iconst_0
    //   80: istore_3
    //   81: goto -63 -> 18
    //   84: aload_0
    //   85: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   88: invokevirtual 368	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   91: aload_0
    //   92: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   95: astore 9
    //   97: aload 9
    //   99: ifnonnull +13 -> 112
    //   102: aload_0
    //   103: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   106: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   109: bipush 254
    //   111: ireturn
    //   112: aload_0
    //   113: getfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   116: istore 6
    //   118: iload 6
    //   120: iconst_1
    //   121: if_icmpne +13 -> 134
    //   124: bipush 237
    //   126: invokestatic 377	android/os/Process:setThreadPriority	(I)V
    //   129: aload_0
    //   130: iconst_0
    //   131: putfield 96	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   134: getstatic 57	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   137: ifeq +27 -> 164
    //   140: aload_0
    //   141: getfield 116	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   144: astore 9
    //   146: aload 9
    //   148: ifnull +16 -> 164
    //   151: aload_0
    //   152: getfield 116	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   155: aload_0
    //   156: getfield 136	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   159: iconst_0
    //   160: iconst_0
    //   161: invokevirtual 383	java/io/FileOutputStream:write	([BII)V
    //   164: aload_0
    //   165: getfield 124	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   168: ifne +587 -> 755
    //   171: iconst_0
    //   172: istore_2
    //   173: aload_0
    //   174: getfield 132	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   177: aload_0
    //   178: getfield 136	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   181: invokevirtual 387	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   184: pop
    //   185: iload_2
    //   186: ifeq +882 -> 1068
    //   189: aload_0
    //   190: getfield 132	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   193: invokevirtual 391	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   196: pop
    //   197: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   200: lstore 7
    //   202: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +48 -> 253
    //   208: ldc 151
    //   210: iconst_2
    //   211: new 153	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 399
    //   221: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_0
    //   225: getfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   228: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   231: ldc_w 401
    //   234: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   241: invokevirtual 291	android/media/AudioTrack:getStreamType	()I
    //   244: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   247: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload_0
    //   254: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   257: invokevirtual 404	android/media/AudioTrack:getPlayState	()I
    //   260: istore_2
    //   261: iload_2
    //   262: iconst_3
    //   263: if_icmpne +120 -> 383
    //   266: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 151
    //   274: iconst_2
    //   275: ldc_w 406
    //   278: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   285: invokevirtual 409	android/media/AudioTrack:stop	()V
    //   288: aload_0
    //   289: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   292: invokevirtual 412	android/media/AudioTrack:flush	()V
    //   295: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +35 -> 333
    //   301: ldc 151
    //   303: iconst_2
    //   304: new 153	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   311: ldc_w 414
    //   314: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   321: invokevirtual 404	android/media/AudioTrack:getPlayState	()I
    //   324: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload_0
    //   334: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   337: invokevirtual 224	android/media/AudioTrack:release	()V
    //   340: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +35 -> 378
    //   346: ldc 151
    //   348: iconst_2
    //   349: new 153	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 416
    //   359: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload_0
    //   363: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   366: invokevirtual 404	android/media/AudioTrack:getPlayState	()I
    //   369: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   372: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: aload_0
    //   379: aconst_null
    //   380: putfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   383: aload_0
    //   384: getfield 73	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   387: iconst_4
    //   388: iconst_2
    //   389: invokestatic 221	android/media/AudioTrack:getMinBufferSize	(III)I
    //   392: istore 4
    //   394: iconst_4
    //   395: newarray int
    //   397: astore 9
    //   399: aload 9
    //   401: dup
    //   402: iconst_0
    //   403: iconst_0
    //   404: iastore
    //   405: dup
    //   406: iconst_1
    //   407: iconst_0
    //   408: iastore
    //   409: dup
    //   410: iconst_2
    //   411: iconst_3
    //   412: iastore
    //   413: dup
    //   414: iconst_3
    //   415: iconst_1
    //   416: iastore
    //   417: pop
    //   418: aload 9
    //   420: iconst_0
    //   421: aload_0
    //   422: getfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   425: iastore
    //   426: iconst_0
    //   427: istore_2
    //   428: iload_2
    //   429: aload 9
    //   431: arraylength
    //   432: if_icmpge +504 -> 936
    //   435: aload_0
    //   436: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   439: ifnonnull +497 -> 936
    //   442: aload_0
    //   443: aload 9
    //   445: iload_2
    //   446: iaload
    //   447: putfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   450: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +44 -> 497
    //   456: ldc 151
    //   458: iconst_2
    //   459: new 153	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   466: ldc 231
    //   468: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: iload 4
    //   473: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   476: ldc 233
    //   478: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: aload_0
    //   482: getfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   485: invokestatic 236	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   488: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   497: iconst_1
    //   498: istore_3
    //   499: iload_3
    //   500: iconst_2
    //   501: if_icmpgt +791 -> 1292
    //   504: iload 4
    //   506: iload_3
    //   507: imul
    //   508: istore 5
    //   510: aload_0
    //   511: new 217	android/media/AudioTrack
    //   514: dup
    //   515: aload_0
    //   516: getfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   519: aload_0
    //   520: getfield 73	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   523: iconst_4
    //   524: iconst_2
    //   525: iload 5
    //   527: iconst_1
    //   528: invokespecial 239	android/media/AudioTrack:<init>	(IIIIII)V
    //   531: putfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   534: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +32 -> 569
    //   540: ldc 151
    //   542: iconst_2
    //   543: new 153	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 263
    //   553: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_0
    //   557: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   560: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: aload_0
    //   570: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   573: invokevirtual 242	android/media/AudioTrack:getState	()I
    //   576: iconst_1
    //   577: if_icmpeq +715 -> 1292
    //   580: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +41 -> 624
    //   586: ldc 151
    //   588: iconst_2
    //   589: new 153	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   596: ldc 244
    //   598: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 5
    //   603: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: ldc 246
    //   608: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_0
    //   612: getfield 73	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   615: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   621: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   624: aload_0
    //   625: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   628: invokevirtual 224	android/media/AudioTrack:release	()V
    //   631: aload_0
    //   632: aconst_null
    //   633: putfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   636: iload_3
    //   637: iconst_1
    //   638: iadd
    //   639: istore_3
    //   640: goto -141 -> 499
    //   643: astore 9
    //   645: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq -519 -> 129
    //   651: ldc 151
    //   653: iconst_2
    //   654: new 153	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 418
    //   664: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 9
    //   669: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   672: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: goto -552 -> 129
    //   684: astore 9
    //   686: iconst_0
    //   687: istore_1
    //   688: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq +33 -> 724
    //   694: ldc 151
    //   696: iconst_2
    //   697: new 153	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   704: ldc_w 420
    //   707: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload 9
    //   712: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   715: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   721: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   724: aload_0
    //   725: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   728: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   731: iload_1
    //   732: ireturn
    //   733: astore 9
    //   735: aload 9
    //   737: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   740: goto -576 -> 164
    //   743: astore 9
    //   745: aload_0
    //   746: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   749: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   752: aload 9
    //   754: athrow
    //   755: aload_0
    //   756: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   759: ifnonnull +26 -> 785
    //   762: aload_0
    //   763: getfield 79	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   766: ifnull +19 -> 785
    //   769: aload_0
    //   770: aload_0
    //   771: getfield 79	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   774: ldc 192
    //   776: invokevirtual 198	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   779: checkcast 200	android/media/AudioManager
    //   782: putfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   785: aload_0
    //   786: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   789: invokevirtual 253	android/media/AudioManager:getMode	()I
    //   792: ifne +44 -> 836
    //   795: aload_0
    //   796: getfield 122	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   799: ldc 255
    //   801: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   804: ifeq +32 -> 836
    //   807: aload_0
    //   808: iconst_3
    //   809: putfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   812: aload_0
    //   813: getfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   816: aload_0
    //   817: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   820: invokevirtual 291	android/media/AudioTrack:getStreamType	()I
    //   823: if_icmpne +21 -> 844
    //   826: iconst_0
    //   827: istore_2
    //   828: aload_0
    //   829: iconst_0
    //   830: putfield 124	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   833: goto -660 -> 173
    //   836: aload_0
    //   837: iconst_0
    //   838: putfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   841: goto -29 -> 812
    //   844: iconst_1
    //   845: istore_2
    //   846: goto -18 -> 828
    //   849: astore 9
    //   851: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   854: ifeq -471 -> 383
    //   857: ldc 151
    //   859: iconst_2
    //   860: ldc_w 425
    //   863: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: goto -483 -> 383
    //   869: astore 10
    //   871: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   874: ifeq +40 -> 914
    //   877: ldc 151
    //   879: iconst_2
    //   880: new 153	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   887: aload 10
    //   889: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   892: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: ldc_w 263
    //   898: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: aload_0
    //   902: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   905: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: aload_0
    //   915: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   918: ifnull +10 -> 928
    //   921: aload_0
    //   922: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   925: invokevirtual 224	android/media/AudioTrack:release	()V
    //   928: aload_0
    //   929: aconst_null
    //   930: putfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   933: goto -297 -> 636
    //   936: aload_0
    //   937: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   940: astore 9
    //   942: aload 9
    //   944: ifnull +57 -> 1001
    //   947: aload_0
    //   948: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   951: invokevirtual 428	android/media/AudioTrack:play	()V
    //   954: aload_0
    //   955: getfield 118	com/tencent/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   958: aload_0
    //   959: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   962: invokevirtual 253	android/media/AudioManager:getMode	()I
    //   965: aload_0
    //   966: getfield 71	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   969: invokevirtual 273	com/tencent/sharp/jni/TraeAudioSession:b	(II)I
    //   972: pop
    //   973: aload_0
    //   974: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   977: astore 9
    //   979: aload_0
    //   980: getfield 122	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   983: ldc_w 284
    //   986: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   989: ifeq +68 -> 1057
    //   992: bipush 6
    //   994: istore_2
    //   995: aload 9
    //   997: iload_2
    //   998: invokestatic 288	com/tencent/sharp/jni/TraeAudioManager:a	(Landroid/media/AudioManager;I)V
    //   1001: iload_1
    //   1002: istore_2
    //   1003: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1006: ifeq +42 -> 1048
    //   1009: ldc 151
    //   1011: iconst_2
    //   1012: new 153	java/lang/StringBuilder
    //   1015: dup
    //   1016: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1019: ldc_w 430
    //   1022: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: invokestatic 397	android/os/SystemClock:elapsedRealtime	()J
    //   1028: lload 7
    //   1030: lsub
    //   1031: invokevirtual 433	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1034: ldc_w 435
    //   1037: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1043: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1046: iload_1
    //   1047: istore_2
    //   1048: aload_0
    //   1049: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1052: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1055: iload_2
    //   1056: ireturn
    //   1057: aload_0
    //   1058: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1061: invokevirtual 291	android/media/AudioTrack:getStreamType	()I
    //   1064: istore_2
    //   1065: goto -70 -> 995
    //   1068: aload_0
    //   1069: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1072: aload_0
    //   1073: getfield 136	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1076: iconst_0
    //   1077: iload_1
    //   1078: invokevirtual 438	android/media/AudioTrack:write	([BII)I
    //   1081: istore_2
    //   1082: aload_0
    //   1083: getfield 132	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1086: invokevirtual 391	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1089: pop
    //   1090: iload_2
    //   1091: ifge +60 -> 1151
    //   1094: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1097: ifeq +45 -> 1142
    //   1100: ldc 151
    //   1102: iconst_2
    //   1103: new 153	java/lang/StringBuilder
    //   1106: dup
    //   1107: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1110: ldc_w 440
    //   1113: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: iload_2
    //   1117: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 442
    //   1123: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: iload_1
    //   1127: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1130: ldc_w 444
    //   1133: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1139: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1142: aload_0
    //   1143: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1146: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1149: iconst_m1
    //   1150: ireturn
    //   1151: iload_2
    //   1152: iload_1
    //   1153: if_icmpeq +51 -> 1204
    //   1156: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1159: ifeq +45 -> 1204
    //   1162: ldc 151
    //   1164: iconst_2
    //   1165: new 153	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   1172: ldc_w 446
    //   1175: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: iload_2
    //   1179: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: ldc_w 442
    //   1185: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: iload_1
    //   1189: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1192: ldc_w 444
    //   1195: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1204: aload_0
    //   1205: aload_0
    //   1206: getfield 106	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1209: iload_2
    //   1210: iconst_1
    //   1211: ishr
    //   1212: iadd
    //   1213: putfield 106	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1216: aload_0
    //   1217: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1220: invokevirtual 276	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1223: istore_1
    //   1224: iload_1
    //   1225: aload_0
    //   1226: getfield 108	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1229: if_icmpge +8 -> 1237
    //   1232: aload_0
    //   1233: iconst_0
    //   1234: putfield 108	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1237: aload_0
    //   1238: aload_0
    //   1239: getfield 106	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1242: iload_1
    //   1243: aload_0
    //   1244: getfield 108	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1247: isub
    //   1248: isub
    //   1249: putfield 106	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1252: aload_0
    //   1253: iload_1
    //   1254: putfield 108	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1257: aload_0
    //   1258: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1261: ifne +23 -> 1284
    //   1264: aload_0
    //   1265: getfield 106	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1268: istore_1
    //   1269: goto -221 -> 1048
    //   1272: astore 9
    //   1274: iload_2
    //   1275: istore_1
    //   1276: goto -588 -> 688
    //   1279: astore 9
    //   1281: goto -280 -> 1001
    //   1284: goto -236 -> 1048
    //   1287: astore 9
    //   1289: goto -601 -> 688
    //   1292: iload_2
    //   1293: iconst_1
    //   1294: iadd
    //   1295: istore_2
    //   1296: goto -868 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1299	0	this	AudioDeviceInterface
    //   0	1299	1	paramInt	int
    //   8	1288	2	i	int
    //   17	623	3	j	int
    //   392	116	4	k	int
    //   508	94	5	m	int
    //   116	6	6	bool	boolean
    //   200	829	7	l	long
    //   95	349	9	localObject1	Object
    //   643	25	9	localException1	Exception
    //   684	27	9	localException2	Exception
    //   733	3	9	localIOException	java.io.IOException
    //   743	10	9	localObject2	Object
    //   849	1	9	localIllegalStateException	java.lang.IllegalStateException
    //   940	56	9	localObject3	Object
    //   1272	1	9	localException3	Exception
    //   1279	1	9	localException4	Exception
    //   1287	1	9	localException5	Exception
    //   869	19	10	localException6	Exception
    // Exception table:
    //   from	to	target	type
    //   124	129	643	java/lang/Exception
    //   91	97	684	java/lang/Exception
    //   112	118	684	java/lang/Exception
    //   129	134	684	java/lang/Exception
    //   134	146	684	java/lang/Exception
    //   151	164	684	java/lang/Exception
    //   164	171	684	java/lang/Exception
    //   173	185	684	java/lang/Exception
    //   645	681	684	java/lang/Exception
    //   735	740	684	java/lang/Exception
    //   755	785	684	java/lang/Exception
    //   785	812	684	java/lang/Exception
    //   812	826	684	java/lang/Exception
    //   828	833	684	java/lang/Exception
    //   836	841	684	java/lang/Exception
    //   1068	1082	684	java/lang/Exception
    //   151	164	733	java/io/IOException
    //   91	97	743	finally
    //   112	118	743	finally
    //   124	129	743	finally
    //   129	134	743	finally
    //   134	146	743	finally
    //   151	164	743	finally
    //   164	171	743	finally
    //   173	185	743	finally
    //   189	253	743	finally
    //   253	261	743	finally
    //   266	281	743	finally
    //   281	333	743	finally
    //   333	378	743	finally
    //   378	383	743	finally
    //   383	426	743	finally
    //   428	497	743	finally
    //   510	534	743	finally
    //   534	569	743	finally
    //   569	624	743	finally
    //   624	636	743	finally
    //   645	681	743	finally
    //   688	724	743	finally
    //   735	740	743	finally
    //   755	785	743	finally
    //   785	812	743	finally
    //   812	826	743	finally
    //   828	833	743	finally
    //   836	841	743	finally
    //   851	866	743	finally
    //   871	914	743	finally
    //   914	928	743	finally
    //   928	933	743	finally
    //   936	942	743	finally
    //   947	992	743	finally
    //   995	1001	743	finally
    //   1003	1046	743	finally
    //   1057	1065	743	finally
    //   1068	1082	743	finally
    //   1082	1090	743	finally
    //   1094	1142	743	finally
    //   1156	1204	743	finally
    //   1204	1237	743	finally
    //   1237	1269	743	finally
    //   266	281	849	java/lang/IllegalStateException
    //   281	333	849	java/lang/IllegalStateException
    //   333	378	849	java/lang/IllegalStateException
    //   378	383	849	java/lang/IllegalStateException
    //   510	534	869	java/lang/Exception
    //   1082	1090	1272	java/lang/Exception
    //   1094	1142	1272	java/lang/Exception
    //   1156	1204	1272	java/lang/Exception
    //   1204	1237	1272	java/lang/Exception
    //   1237	1269	1272	java/lang/Exception
    //   947	992	1279	java/lang/Exception
    //   995	1001	1279	java/lang/Exception
    //   1057	1065	1279	java/lang/Exception
    //   189	253	1287	java/lang/Exception
    //   253	261	1287	java/lang/Exception
    //   266	281	1287	java/lang/Exception
    //   281	333	1287	java/lang/Exception
    //   333	378	1287	java/lang/Exception
    //   378	383	1287	java/lang/Exception
    //   383	426	1287	java/lang/Exception
    //   428	497	1287	java/lang/Exception
    //   534	569	1287	java/lang/Exception
    //   569	624	1287	java/lang/Exception
    //   624	636	1287	java/lang/Exception
    //   851	866	1287	java/lang/Exception
    //   871	914	1287	java/lang/Exception
    //   914	928	1287	java/lang/Exception
    //   928	933	1287	java/lang/Exception
    //   936	942	1287	java/lang/Exception
    //   1003	1046	1287	java/lang/Exception
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   4: ifne +40 -> 44
    //   7: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +32 -> 42
    //   13: ldc 151
    //   15: iconst_2
    //   16: new 153	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 449
    //   26: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   33: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: iconst_m1
    //   43: ireturn
    //   44: aload_0
    //   45: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   48: invokevirtual 368	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   51: aload_0
    //   52: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   55: astore 4
    //   57: aload 4
    //   59: ifnonnull +13 -> 72
    //   62: aload_0
    //   63: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   66: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   69: bipush 254
    //   71: ireturn
    //   72: aload_0
    //   73: getfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_1
    //   79: if_icmpne +13 -> 92
    //   82: bipush 237
    //   84: invokestatic 377	android/os/Process:setThreadPriority	(I)V
    //   87: aload_0
    //   88: iconst_0
    //   89: putfield 98	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   92: aload_0
    //   93: getfield 134	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   96: invokevirtual 391	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   99: pop
    //   100: aload_0
    //   101: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   104: aload_0
    //   105: getfield 138	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   108: iconst_0
    //   109: iload_1
    //   110: invokevirtual 452	android/media/AudioRecord:read	([BII)I
    //   113: istore_2
    //   114: iload_2
    //   115: ifge +150 -> 265
    //   118: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +45 -> 166
    //   124: ldc 151
    //   126: iconst_2
    //   127: new 153	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 454
    //   137: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_2
    //   141: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 442
    //   147: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_1
    //   151: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc_w 444
    //   157: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_0
    //   167: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   170: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   173: iconst_m1
    //   174: ireturn
    //   175: astore 4
    //   177: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq -93 -> 87
    //   183: ldc 151
    //   185: iconst_2
    //   186: new 153	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 456
    //   196: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload 4
    //   201: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   204: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: goto -126 -> 87
    //   216: astore 4
    //   218: iconst_0
    //   219: istore_2
    //   220: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +33 -> 256
    //   226: ldc 151
    //   228: iconst_2
    //   229: new 153	java/lang/StringBuilder
    //   232: dup
    //   233: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   236: ldc_w 458
    //   239: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 4
    //   244: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   247: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: aload_0
    //   257: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   260: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   263: iload_2
    //   264: ireturn
    //   265: aload_0
    //   266: getfield 134	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   269: aload_0
    //   270: getfield 138	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   273: iconst_0
    //   274: iload_2
    //   275: invokevirtual 462	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   278: pop
    //   279: getstatic 57	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   282: ifeq +27 -> 309
    //   285: aload_0
    //   286: getfield 114	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   289: astore 4
    //   291: aload 4
    //   293: ifnull +16 -> 309
    //   296: aload_0
    //   297: getfield 114	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   300: aload_0
    //   301: getfield 138	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   304: iconst_0
    //   305: iload_2
    //   306: invokevirtual 383	java/io/FileOutputStream:write	([BII)V
    //   309: iload_2
    //   310: iload_1
    //   311: if_icmpeq +75 -> 386
    //   314: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +45 -> 362
    //   320: ldc 151
    //   322: iconst_2
    //   323: new 153	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 464
    //   333: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: iload_2
    //   337: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   340: ldc_w 442
    //   343: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload_1
    //   347: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc_w 444
    //   353: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   362: aload_0
    //   363: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   366: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   369: iconst_m1
    //   370: ireturn
    //   371: astore 4
    //   373: aload 4
    //   375: invokevirtual 423	java/io/IOException:printStackTrace	()V
    //   378: goto -69 -> 309
    //   381: astore 4
    //   383: goto -163 -> 220
    //   386: aload_0
    //   387: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   390: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   393: iload_2
    //   394: ireturn
    //   395: astore 4
    //   397: aload_0
    //   398: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   401: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   404: aload 4
    //   406: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	AudioDeviceInterface
    //   0	407	1	paramInt	int
    //   113	281	2	i	int
    //   76	4	3	bool	boolean
    //   55	3	4	localAudioRecord	AudioRecord
    //   175	25	4	localException1	Exception
    //   216	27	4	localException2	Exception
    //   289	3	4	localFileOutputStream	FileOutputStream
    //   371	3	4	localIOException	java.io.IOException
    //   381	1	4	localException3	Exception
    //   395	10	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   82	87	175	java/lang/Exception
    //   51	57	216	java/lang/Exception
    //   72	77	216	java/lang/Exception
    //   87	92	216	java/lang/Exception
    //   92	114	216	java/lang/Exception
    //   177	213	216	java/lang/Exception
    //   296	309	371	java/io/IOException
    //   118	166	381	java/lang/Exception
    //   265	291	381	java/lang/Exception
    //   296	309	381	java/lang/Exception
    //   314	362	381	java/lang/Exception
    //   373	378	381	java/lang/Exception
    //   51	57	395	finally
    //   72	77	395	finally
    //   82	87	395	finally
    //   87	92	395	finally
    //   92	114	395	finally
    //   118	166	395	finally
    //   177	213	395	finally
    //   220	256	395	finally
    //   265	291	395	finally
    //   296	309	395	finally
    //   314	362	395	finally
    //   373	378	395	finally
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 151
    //   17: iconst_2
    //   18: ldc_w 474
    //   21: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +40 -> 70
    //   33: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc 151
    //   41: iconst_2
    //   42: new 153	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 476
    //   52: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   59: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   74: invokevirtual 428	android/media/AudioTrack:play	()V
    //   77: getstatic 57	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   80: ifeq +52 -> 132
    //   83: aload_0
    //   84: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   94: invokevirtual 253	android/media/AudioManager:getMode	()I
    //   97: istore_1
    //   98: aload_0
    //   99: new 478	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: ldc_w 480
    //   107: iload_1
    //   108: invokespecial 484	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: invokespecial 486	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: putfield 112	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   117: aload_0
    //   118: new 379	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 112	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   126: invokespecial 489	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: putfield 116	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   137: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 151
    //   145: iconst_2
    //   146: ldc_w 491
    //   149: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_2
    //   155: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 151
    //   163: iconst_2
    //   164: ldc_w 493
    //   167: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_2
    //   171: invokevirtual 494	java/lang/IllegalStateException:printStackTrace	()V
    //   174: iconst_m1
    //   175: ireturn
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 495	java/io/FileNotFoundException:printStackTrace	()V
    //   181: goto -49 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AudioDeviceInterface
    //   1	107	1	i	int
    //   154	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   176	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   70	77	154	java/lang/IllegalStateException
    //   117	132	176	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 151
    //   10: iconst_2
    //   11: ldc_w 498
    //   14: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +40 -> 61
    //   24: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +32 -> 59
    //   30: ldc 151
    //   32: iconst_2
    //   33: new 153	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 500
    //   43: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   50: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: ifnonnull +40 -> 105
    //   68: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc 151
    //   76: iconst_2
    //   77: new 153	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 502
    //   87: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_m1
    //   104: ireturn
    //   105: aload_0
    //   106: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   109: invokevirtual 505	android/media/AudioRecord:startRecording	()V
    //   112: getstatic 57	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: getfield 87	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   129: invokevirtual 253	android/media/AudioManager:getMode	()I
    //   132: istore_1
    //   133: aload_0
    //   134: new 478	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: ldc_w 507
    //   142: iload_1
    //   143: invokespecial 484	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   146: invokespecial 486	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: putfield 110	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   152: aload_0
    //   153: new 379	java/io/FileOutputStream
    //   156: dup
    //   157: aload_0
    //   158: getfield 110	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   161: invokespecial 489	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: putfield 114	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   172: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 151
    //   180: iconst_2
    //   181: ldc_w 509
    //   184: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 151
    //   198: iconst_2
    //   199: ldc_w 511
    //   202: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 494	java/lang/IllegalStateException:printStackTrace	()V
    //   209: iconst_m1
    //   210: ireturn
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 495	java/io/FileNotFoundException:printStackTrace	()V
    //   216: goto -49 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	AudioDeviceInterface
    //   1	142	1	i	int
    //   189	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   211	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   105	112	189	java/lang/IllegalStateException
    //   152	167	211	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 151
    //   8: iconst_2
    //   9: new 153	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 514
    //   19: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   26: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +53 -> 92
    //   42: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +45 -> 90
    //   48: ldc 151
    //   50: iconst_2
    //   51: new 153	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 516
    //   61: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   68: invokevirtual 212	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc_w 365
    //   74: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   81: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: aload_0
    //   93: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 368	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: aload_0
    //   100: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   103: invokevirtual 404	android/media/AudioTrack:getPlayState	()I
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_3
    //   109: if_icmpne +70 -> 179
    //   112: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 151
    //   120: iconst_2
    //   121: ldc_w 406
    //   124: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 409	android/media/AudioTrack:stop	()V
    //   134: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: ldc 151
    //   142: iconst_2
    //   143: new 153	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 414
    //   153: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   160: invokevirtual 404	android/media/AudioTrack:getPlayState	()I
    //   163: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   176: invokevirtual 412	android/media/AudioTrack:flush	()V
    //   179: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: ldc 151
    //   187: iconst_2
    //   188: new 153	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 416
    //   198: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   205: invokevirtual 404	android/media/AudioTrack:getPlayState	()I
    //   208: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   221: invokevirtual 224	android/media/AudioTrack:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 67	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   234: aload_0
    //   235: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   238: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 151
    //   249: iconst_2
    //   250: ldc_w 518
    //   253: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_2
    //   259: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 151
    //   267: iconst_2
    //   268: ldc_w 425
    //   271: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: invokevirtual 494	java/lang/IllegalStateException:printStackTrace	()V
    //   278: aload_0
    //   279: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   282: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 92	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   292: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   295: aload_2
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	AudioDeviceInterface
    //   106	4	1	i	int
    //   258	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   287	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	127	258	java/lang/IllegalStateException
    //   127	134	258	java/lang/IllegalStateException
    //   99	107	287	finally
    //   112	127	287	finally
    //   127	134	287	finally
    //   134	172	287	finally
    //   172	179	287	finally
    //   179	217	287	finally
    //   217	234	287	finally
    //   259	274	287	finally
    //   274	278	287	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 151
    //   8: iconst_2
    //   9: ldc_w 521
    //   12: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +40 -> 59
    //   22: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 151
    //   30: iconst_2
    //   31: new 153	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 523
    //   41: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   48: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 368	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 526	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +48 -> 124
    //   79: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +35 -> 117
    //   85: ldc 151
    //   87: iconst_2
    //   88: new 153	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 528
    //   98: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   105: invokevirtual 526	android/media/AudioRecord:getRecordingState	()I
    //   108: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 529	android/media/AudioRecord:stop	()V
    //   124: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc 151
    //   132: iconst_2
    //   133: new 153	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 531
    //   143: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   150: invokevirtual 526	android/media/AudioRecord:getRecordingState	()I
    //   153: invokevirtual 163	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   166: invokevirtual 314	android/media/AudioRecord:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 69	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 100	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   179: aload_0
    //   180: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   183: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   186: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 151
    //   194: iconst_2
    //   195: ldc_w 533
    //   198: invokestatic 171	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_2
    //   204: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc 151
    //   212: iconst_2
    //   213: ldc_w 535
    //   216: invokestatic 215	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_2
    //   220: invokevirtual 494	java/lang/IllegalStateException:printStackTrace	()V
    //   223: aload_0
    //   224: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   227: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   237: invokevirtual 371	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	AudioDeviceInterface
    //   73	4	1	i	int
    //   203	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   232	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	117	203	java/lang/IllegalStateException
    //   117	124	203	java/lang/IllegalStateException
    //   66	74	232	finally
    //   79	117	232	finally
    //   117	124	232	finally
    //   124	162	232	finally
    //   162	179	232	finally
    //   204	219	232	finally
    //   219	223	232	finally
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.a(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
      if (bool != true) {
        break label146;
      }
    }
    label146:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if ((Build.VERSION.SDK_INT >= 17) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      return 0;
    }
  }
  
  private int getLowlatencySamplerate()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
    }
    label146:
    label153:
    do
    {
      return 0;
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
        if (bool != true) {
          break label146;
        }
      }
      for (String str = "Y";; str = "N")
      {
        QLog.w("TRAE", 2, str);
        if (Build.VERSION.SDK_INT >= 17) {
          break label153;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        return 0;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
    return 0;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = arrayOfStackTraceElement.length;
    localStringBuffer.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void onOutputChanage(String paramString)
  {
    if (!TraeAudioManager.a(this._modePolicy)) {
      return;
    }
    this._connectedDev = paramString;
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label193;
      }
      localObject = "am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label223;
      }
      localObject = "_audioTrack==null";
      label81:
      QLog.w("TRAE", 2, (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" curr mode:").append(paramString);
          if (this._audioManager != null) {
            continue;
          }
          paramString = "am==null";
          QLog.w("TRAE", 2, paramString);
        }
        if (this._connectedDev.equals("DEVICE_SPEAKERPHONE")) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label193:
        label223:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label81;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    if (this._as != null)
    {
      this._as.g();
      this._as.a();
    }
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this._streamType = TraeAudioManager.b(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new hyt(this));
    }
    if (this._as != null)
    {
      this._as.a(this._modePolicy, this._streamType);
      this._as.e();
    }
    LogTraceExit();
    return 0;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */