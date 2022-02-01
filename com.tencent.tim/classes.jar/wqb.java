import com.tencent.qphone.base.util.QLog;
import com.wx.voice.vad.WXVad;
import com.wx.voice.vad.WXVadNative;
import com.wx.voice.vad.WXVadParam;
import com.wx.voice.vad.WXVadSeg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class wqb
{
  private final String TAG = "VadHelper";
  private WXVad jdField_a_of_type_ComWxVoiceVadWXVad;
  private WXVadNative jdField_a_of_type_ComWxVoiceVadWXVadNative;
  private WXVadParam jdField_a_of_type_ComWxVoiceVadWXVadParam;
  private AtomicBoolean bG = new AtomicBoolean();
  private int bQD;
  private String path;
  public List<WXVadSeg> rH = new ArrayList();
  
  static
  {
    System.loadLibrary("wx-asr-vad");
  }
  
  public void caD()
  {
    this.jdField_a_of_type_ComWxVoiceVadWXVadNative = new WXVadNative();
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam = new WXVadParam();
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.mode = 1;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.sample_rate = 16000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.opt_spk_time = 3000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_spk_time = 80;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_max_spk_time = 50000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_nspk_time = 50;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_process_time = 10000;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_remove_sil = true;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_padding_btime = 100;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_padding_etime = 150;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_min_sil_time = 600;
    this.jdField_a_of_type_ComWxVoiceVadWXVadParam.offline_rtcmode = 3;
    this.jdField_a_of_type_ComWxVoiceVadWXVad = new WXVad();
    if (1 == this.jdField_a_of_type_ComWxVoiceVadWXVad.Init(this.jdField_a_of_type_ComWxVoiceVadWXVadParam)) {
      if (QLog.isColorLevel()) {
        QLog.d("VadHelper", 2, "WXVad Error reading configure");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VadHelper", 2, "WXVad Success init");
  }
  
  /* Error */
  public void caE()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	wqb:bG	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4: invokevirtual 124	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   7: ifeq +18 -> 25
    //   10: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +11 -> 24
    //   16: ldc 34
    //   18: iconst_2
    //   19: ldc 126
    //   21: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: return
    //   25: aload_0
    //   26: getfield 41	wqb:rH	Ljava/util/List;
    //   29: invokeinterface 131 1 0
    //   34: aload_0
    //   35: getfield 46	wqb:bG	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: iconst_1
    //   39: invokevirtual 135	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   42: new 137	java/io/File
    //   45: dup
    //   46: aload_0
    //   47: getfield 139	wqb:path	Ljava/lang/String;
    //   50: invokespecial 141	java/io/File:<init>	(Ljava/lang/String;)V
    //   53: astore 6
    //   55: new 143	java/io/FileInputStream
    //   58: dup
    //   59: aload 6
    //   61: invokespecial 146	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: astore 5
    //   66: aload 5
    //   68: astore 4
    //   70: aload 6
    //   72: invokevirtual 150	java/io/File:length	()J
    //   75: lstore_2
    //   76: aload 5
    //   78: astore 4
    //   80: new 38	java/util/ArrayList
    //   83: dup
    //   84: invokespecial 39	java/util/ArrayList:<init>	()V
    //   87: pop
    //   88: aload 5
    //   90: astore 4
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 152	wqb:bQD	I
    //   98: i2l
    //   99: invokevirtual 156	java/io/FileInputStream:skip	(J)J
    //   102: pop2
    //   103: aload 5
    //   105: astore 4
    //   107: lload_2
    //   108: aload_0
    //   109: getfield 152	wqb:bQD	I
    //   112: i2l
    //   113: lsub
    //   114: l2i
    //   115: newarray byte
    //   117: astore 6
    //   119: aload 5
    //   121: astore 4
    //   123: aload 5
    //   125: aload 6
    //   127: invokevirtual 160	java/io/FileInputStream:read	([B)I
    //   130: pop
    //   131: aload 5
    //   133: astore 4
    //   135: aload 6
    //   137: invokestatic 166	com/wx/voice/vad/Utils:toShortArray	([B)[S
    //   140: astore 6
    //   142: aload 5
    //   144: astore 4
    //   146: aload_0
    //   147: getfield 100	wqb:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   150: aload 6
    //   152: aload 6
    //   154: arraylength
    //   155: i2l
    //   156: invokevirtual 170	com/wx/voice/vad/WXVad:OfflineProcess	([SJ)Lcom/wx/voice/vad/WXVadData;
    //   159: astore 6
    //   161: aload 5
    //   163: astore 4
    //   165: aload 6
    //   167: getfield 175	com/wx/voice/vad/WXVadData:RET_STATE	I
    //   170: iconst_1
    //   171: if_icmpeq +132 -> 303
    //   174: iconst_0
    //   175: istore_1
    //   176: aload 5
    //   178: astore 4
    //   180: iload_1
    //   181: aload 6
    //   183: getfield 179	com/wx/voice/vad/WXVadData:offline_odata	Ljava/util/ArrayList;
    //   186: invokevirtual 183	java/util/ArrayList:size	()I
    //   189: if_icmpge +114 -> 303
    //   192: aload 5
    //   194: astore 4
    //   196: aload 6
    //   198: getfield 179	com/wx/voice/vad/WXVadData:offline_odata	Ljava/util/ArrayList;
    //   201: iload_1
    //   202: invokevirtual 186	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   205: checkcast 188	com/wx/voice/vad/WXVadSeg
    //   208: astore 7
    //   210: aload 5
    //   212: astore 4
    //   214: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   217: ifeq +63 -> 280
    //   220: aload 5
    //   222: astore 4
    //   224: ldc 34
    //   226: iconst_2
    //   227: new 190	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   234: ldc 193
    //   236: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 7
    //   241: getfield 201	com/wx/voice/vad/WXVadSeg:mbtm	J
    //   244: l2f
    //   245: ldc 202
    //   247: fdiv
    //   248: invokestatic 208	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   251: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc 210
    //   256: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload 7
    //   261: getfield 213	com/wx/voice/vad/WXVadSeg:metm	J
    //   264: l2f
    //   265: ldc 202
    //   267: fdiv
    //   268: invokestatic 208	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   271: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: aload 5
    //   282: astore 4
    //   284: aload_0
    //   285: getfield 41	wqb:rH	Ljava/util/List;
    //   288: aload 7
    //   290: invokeinterface 221 2 0
    //   295: pop
    //   296: iload_1
    //   297: iconst_1
    //   298: iadd
    //   299: istore_1
    //   300: goto -124 -> 176
    //   303: aload 5
    //   305: astore 4
    //   307: aload_0
    //   308: getfield 100	wqb:jdField_a_of_type_ComWxVoiceVadWXVad	Lcom/wx/voice/vad/WXVad;
    //   311: invokevirtual 224	com/wx/voice/vad/WXVad:Reset	()I
    //   314: pop
    //   315: aload 5
    //   317: astore 4
    //   319: aload_0
    //   320: getfield 46	wqb:bG	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   323: iconst_0
    //   324: invokevirtual 135	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   327: aload 5
    //   329: invokevirtual 227	java/io/FileInputStream:close	()V
    //   332: return
    //   333: astore 4
    //   335: aload 4
    //   337: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   340: return
    //   341: astore 6
    //   343: aconst_null
    //   344: astore 5
    //   346: aload 5
    //   348: astore 4
    //   350: aload 6
    //   352: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   355: aload 5
    //   357: astore 4
    //   359: aload_0
    //   360: getfield 46	wqb:bG	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   363: iconst_0
    //   364: invokevirtual 135	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   367: aload 5
    //   369: invokevirtual 227	java/io/FileInputStream:close	()V
    //   372: return
    //   373: astore 4
    //   375: aload 4
    //   377: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   380: return
    //   381: astore 5
    //   383: aconst_null
    //   384: astore 4
    //   386: aload 4
    //   388: invokevirtual 227	java/io/FileInputStream:close	()V
    //   391: aload 5
    //   393: athrow
    //   394: astore 4
    //   396: aload 4
    //   398: invokevirtual 230	java/lang/Exception:printStackTrace	()V
    //   401: goto -10 -> 391
    //   404: astore 5
    //   406: goto -20 -> 386
    //   409: astore 6
    //   411: goto -65 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	this	wqb
    //   175	125	1	i	int
    //   75	33	2	l	long
    //   68	250	4	localFileInputStream1	java.io.FileInputStream
    //   333	3	4	localException1	java.lang.Exception
    //   348	10	4	localFileInputStream2	java.io.FileInputStream
    //   373	3	4	localException2	java.lang.Exception
    //   384	3	4	localObject1	Object
    //   394	3	4	localException3	java.lang.Exception
    //   64	304	5	localFileInputStream3	java.io.FileInputStream
    //   381	11	5	localObject2	Object
    //   404	1	5	localObject3	Object
    //   53	144	6	localObject4	Object
    //   341	10	6	localException4	java.lang.Exception
    //   409	1	6	localException5	java.lang.Exception
    //   208	81	7	localWXVadSeg	WXVadSeg
    // Exception table:
    //   from	to	target	type
    //   327	332	333	java/lang/Exception
    //   55	66	341	java/lang/Exception
    //   367	372	373	java/lang/Exception
    //   55	66	381	finally
    //   386	391	394	java/lang/Exception
    //   70	76	404	finally
    //   80	88	404	finally
    //   92	103	404	finally
    //   107	119	404	finally
    //   123	131	404	finally
    //   135	142	404	finally
    //   146	161	404	finally
    //   165	174	404	finally
    //   180	192	404	finally
    //   196	210	404	finally
    //   214	220	404	finally
    //   224	280	404	finally
    //   284	296	404	finally
    //   307	315	404	finally
    //   319	327	404	finally
    //   350	355	404	finally
    //   359	367	404	finally
    //   70	76	409	java/lang/Exception
    //   80	88	409	java/lang/Exception
    //   92	103	409	java/lang/Exception
    //   107	119	409	java/lang/Exception
    //   123	131	409	java/lang/Exception
    //   135	142	409	java/lang/Exception
    //   146	161	409	java/lang/Exception
    //   165	174	409	java/lang/Exception
    //   180	192	409	java/lang/Exception
    //   196	210	409	java/lang/Exception
    //   214	220	409	java/lang/Exception
    //   224	280	409	java/lang/Exception
    //   284	296	409	java/lang/Exception
    //   307	315	409	java/lang/Exception
    //   319	327	409	java/lang/Exception
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_ComWxVoiceVadWXVad != null) {
      this.jdField_a_of_type_ComWxVoiceVadWXVad.Release();
    }
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wqb
 * JD-Core Version:    0.7.0.1
 */