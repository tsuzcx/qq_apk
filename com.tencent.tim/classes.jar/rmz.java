import android.media.AudioTrack;
import android.support.annotation.RequiresApi;
import com.tencent.biz.qqstory.takevideo.tools.audio.AudioCombiner;
import com.tencent.biz.qqstory.takevideo.tools.audio.AudioCombiner.a;
import com.tencent.qphone.base.util.QLog;

public class rmz
{
  private alwc jdField_a_of_type_Alwc;
  private AudioCombiner jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner;
  private rmz.a jdField_a_of_type_Rmz$a;
  private rnb jdField_a_of_type_Rnb;
  public boolean aIS;
  private boolean aIT;
  private AudioTrack audioTrack;
  protected int btq;
  protected int btr;
  protected int mSampleSize;
  
  @RequiresApi(api=16)
  public boolean LM()
  {
    if (this.aIS)
    {
      int i = this.mSampleSize;
      this.audioTrack = new AudioTrack(3, i, 4, 2, AudioTrack.getMinBufferSize(i, 4, 2) * 10, 1);
      this.audioTrack.play();
    }
    if (this.jdField_a_of_type_Rmz$a == null) {
      this.jdField_a_of_type_Rmz$a = new rmz.a();
    }
    if (this.jdField_a_of_type_Alwc != null) {
      this.jdField_a_of_type_Alwc.qh();
    }
    this.jdField_a_of_type_Rnb.xN(this.btr);
    this.jdField_a_of_type_Rnb.xM(this.btq);
    this.jdField_a_of_type_Rnb.setTargetSampleSize(this.mSampleSize);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner.a(this.jdField_a_of_type_Rmz$a);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner.setGap(60);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner.setDuration(100000);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner.start();
    return false;
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_Rnb != null)
    {
      this.jdField_a_of_type_Rnb.release();
      this.jdField_a_of_type_Rnb = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner.release();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner = null;
    }
    if (this.audioTrack != null) {
      this.audioTrack.release();
    }
  }
  
  /* Error */
  @RequiresApi(api=16)
  public void sE(java.lang.String paramString)
  {
    // Byte code:
    //   0: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 115
    //   8: iconst_2
    //   9: new 117	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   16: ldc 121
    //   18: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: aconst_null
    //   32: astore 4
    //   34: new 135	android/media/MediaMetadataRetriever
    //   37: dup
    //   38: invokespecial 136	android/media/MediaMetadataRetriever:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 139	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   47: aload_3
    //   48: bipush 9
    //   50: invokevirtual 143	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: invokestatic 149	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   56: istore_2
    //   57: aload_0
    //   58: getfield 65	rmz:jdField_a_of_type_Rnb	Lrnb;
    //   61: aload_1
    //   62: lconst_0
    //   63: iload_2
    //   64: sipush 1000
    //   67: imul
    //   68: i2l
    //   69: invokevirtual 153	rnb:g	(Ljava/lang/String;JJ)V
    //   72: new 155	rna
    //   75: dup
    //   76: aload_0
    //   77: getfield 65	rmz:jdField_a_of_type_Rnb	Lrnb;
    //   80: aload_1
    //   81: iload_2
    //   82: aload_0
    //   83: getfield 83	rmz:jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner	Lcom/tencent/biz/qqstory/takevideo/tools/audio/AudioCombiner;
    //   86: invokevirtual 159	com/tencent/biz/qqstory/takevideo/tools/audio/AudioCombiner:dV	()J
    //   89: invokespecial 162	rna:<init>	(Lrnb;Ljava/lang/String;IJ)V
    //   92: astore_1
    //   93: aload_1
    //   94: aload_0
    //   95: getfield 67	rmz:btr	I
    //   98: putfield 165	rna:btu	I
    //   101: aload_1
    //   102: aload_0
    //   103: getfield 75	rmz:btq	I
    //   106: putfield 168	rna:btt	I
    //   109: aload_1
    //   110: aload_0
    //   111: getfield 39	rmz:mSampleSize	I
    //   114: putfield 171	rna:bts	I
    //   117: aload_0
    //   118: getfield 83	rmz:jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner	Lcom/tencent/biz/qqstory/takevideo/tools/audio/AudioCombiner;
    //   121: aload_1
    //   122: invokevirtual 174	com/tencent/biz/qqstory/takevideo/tools/audio/AudioCombiner:a	(Lrmx;)V
    //   125: aload_3
    //   126: ifnull +7 -> 133
    //   129: aload_3
    //   130: invokevirtual 175	android/media/MediaMetadataRetriever:release	()V
    //   133: return
    //   134: astore_3
    //   135: aload 4
    //   137: astore_1
    //   138: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +31 -> 172
    //   144: ldc 115
    //   146: iconst_2
    //   147: new 117	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   154: ldc 177
    //   156: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_3
    //   160: invokevirtual 180	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_1
    //   173: ifnull -40 -> 133
    //   176: aload_1
    //   177: invokevirtual 175	android/media/MediaMetadataRetriever:release	()V
    //   180: return
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_3
    //   185: ifnull +7 -> 192
    //   188: aload_3
    //   189: invokevirtual 175	android/media/MediaMetadataRetriever:release	()V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: goto -11 -> 184
    //   198: astore 4
    //   200: aload_1
    //   201: astore_3
    //   202: aload 4
    //   204: astore_1
    //   205: goto -21 -> 184
    //   208: astore 4
    //   210: aload_3
    //   211: astore_1
    //   212: aload 4
    //   214: astore_3
    //   215: goto -77 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	rmz
    //   0	218	1	paramString	java.lang.String
    //   56	26	2	i	int
    //   41	89	3	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   134	26	3	localException1	java.lang.Exception
    //   183	32	3	localObject1	Object
    //   32	104	4	localObject2	Object
    //   198	5	4	localObject3	Object
    //   208	5	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   34	42	134	java/lang/Exception
    //   34	42	181	finally
    //   42	125	194	finally
    //   138	172	198	finally
    //   42	125	208	java/lang/Exception
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioCombiner.stop();
    }
    if (this.audioTrack != null) {
      this.audioTrack.stop();
    }
    if (this.jdField_a_of_type_Alwc != null) {
      this.jdField_a_of_type_Alwc.yC();
    }
    this.aIT = false;
    if (QLog.isColorLevel()) {
      QLog.d("AudioMuxer", 2, "stop called");
    }
  }
  
  class a
    implements AudioCombiner.a
  {
    a() {}
    
    public void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null) {}
      do
      {
        return;
        if ((rmz.this.aIS) && (rmz.a(rmz.this) != null)) {
          rmz.a(rmz.this).write(paramArrayOfByte, 0, paramArrayOfByte.length);
        }
      } while ((rmz.a(rmz.this) == null) || (!rmz.a(rmz.this)));
      rmz.a(rmz.this).e(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rmz
 * JD-Core Version:    0.7.0.1
 */