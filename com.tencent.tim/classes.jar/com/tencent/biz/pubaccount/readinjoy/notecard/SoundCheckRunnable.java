package com.tencent.biz.pubaccount.readinjoy.notecard;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;

public class SoundCheckRunnable
  implements Runnable
{
  private static String TAG = "SoundCheckRunnable";
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, 8000, 2, 2, this.mBufferSize);
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable$a;
  private boolean dp = true;
  private float jp = 1.0F;
  private int mBufferSize = AudioRecord.getMinBufferSize(8000, 2, 2);
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable$a = parama;
  }
  
  public boolean isRecording()
  {
    return this.dp;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 61	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   4: invokestatic 82	allc:a	(Landroid/media/AudioRecord;)V
    //   7: aload_0
    //   8: getfield 56	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:mBufferSize	I
    //   11: newarray byte
    //   13: astore 8
    //   15: new 84	java/util/LinkedList
    //   18: dup
    //   19: invokespecial 85	java/util/LinkedList:<init>	()V
    //   22: astore 9
    //   24: lconst_0
    //   25: lstore 6
    //   27: aload_0
    //   28: getfield 48	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:dp	Z
    //   31: ifeq +254 -> 285
    //   34: ldc2_w 86
    //   37: invokestatic 93	java/lang/Thread:sleep	(J)V
    //   40: aload_0
    //   41: getfield 61	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   44: aload 8
    //   46: iconst_0
    //   47: aload_0
    //   48: getfield 56	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:mBufferSize	I
    //   51: invokevirtual 97	android/media/AudioRecord:read	([BII)I
    //   54: istore_3
    //   55: aload 8
    //   57: arraylength
    //   58: istore 4
    //   60: iconst_0
    //   61: istore_1
    //   62: iconst_0
    //   63: istore_2
    //   64: iload_1
    //   65: iload 4
    //   67: if_icmpge +55 -> 122
    //   70: aload 8
    //   72: iload_1
    //   73: baload
    //   74: istore 5
    //   76: iload_2
    //   77: iload 5
    //   79: iload 5
    //   81: imul
    //   82: iadd
    //   83: istore_2
    //   84: iload_1
    //   85: iconst_1
    //   86: iadd
    //   87: istore_1
    //   88: goto -24 -> 64
    //   91: astore 8
    //   93: invokestatic 102	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   96: ifeq +15 -> 111
    //   99: getstatic 27	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:TAG	Ljava/lang/String;
    //   102: iconst_1
    //   103: aload 8
    //   105: invokevirtual 106	java/lang/Exception:toString	()Ljava/lang/String;
    //   108: invokestatic 110	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: return
    //   112: astore 10
    //   114: aload 10
    //   116: invokevirtual 113	java/lang/InterruptedException:printStackTrace	()V
    //   119: goto -79 -> 40
    //   122: iload_2
    //   123: iload_3
    //   124: iconst_1
    //   125: iadd
    //   126: idiv
    //   127: istore_1
    //   128: aload 9
    //   130: iload_1
    //   131: invokestatic 119	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   134: invokevirtual 123	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   137: pop
    //   138: iload_1
    //   139: i2l
    //   140: lload 6
    //   142: ladd
    //   143: lstore 6
    //   145: aload 9
    //   147: invokevirtual 127	java/util/LinkedList:size	()I
    //   150: bipush 10
    //   152: if_icmple +151 -> 303
    //   155: lload 6
    //   157: aload 9
    //   159: invokevirtual 131	java/util/LinkedList:removeFirst	()Ljava/lang/Object;
    //   162: checkcast 115	java/lang/Integer
    //   165: invokevirtual 134	java/lang/Integer:intValue	()I
    //   168: i2l
    //   169: lsub
    //   170: lstore 6
    //   172: lload 6
    //   174: aload 9
    //   176: invokevirtual 127	java/util/LinkedList:size	()I
    //   179: i2l
    //   180: ldiv
    //   181: l2i
    //   182: istore_2
    //   183: getstatic 140	java/lang/System:out	Ljava/io/PrintStream;
    //   186: new 142	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   193: ldc 145
    //   195: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_1
    //   199: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc 154
    //   204: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: iload_2
    //   208: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 156
    //   213: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_0
    //   217: getfield 46	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jp	F
    //   220: ldc 157
    //   222: fmul
    //   223: invokevirtual 160	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   226: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 167	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   232: iload_2
    //   233: i2f
    //   234: aload_0
    //   235: getfield 46	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jp	F
    //   238: ldc 157
    //   240: fmul
    //   241: fcmpl
    //   242: ifle -215 -> 27
    //   245: aload_0
    //   246: getfield 70	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable$a	Lcom/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable$a;
    //   249: astore 10
    //   251: aload 10
    //   253: ifnull +21 -> 274
    //   256: aload_0
    //   257: getfield 44	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:mUIHandler	Landroid/os/Handler;
    //   260: new 169	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable$1
    //   263: dup
    //   264: aload_0
    //   265: aload 10
    //   267: invokespecial 172	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable$1:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable;Lcom/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable$a;)V
    //   270: invokevirtual 176	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   273: pop
    //   274: aload 9
    //   276: invokevirtual 179	java/util/LinkedList:clear	()V
    //   279: lconst_0
    //   280: lstore 6
    //   282: goto -255 -> 27
    //   285: aload_0
    //   286: getfield 61	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   289: invokevirtual 182	android/media/AudioRecord:stop	()V
    //   292: aload_0
    //   293: getfield 61	com/tencent/biz/pubaccount/readinjoy/notecard/SoundCheckRunnable:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   296: invokevirtual 185	android/media/AudioRecord:release	()V
    //   299: return
    //   300: astore 8
    //   302: return
    //   303: goto -131 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	SoundCheckRunnable
    //   61	138	1	i	int
    //   63	170	2	j	int
    //   54	72	3	k	int
    //   58	10	4	m	int
    //   74	8	5	n	int
    //   25	256	6	l	long
    //   13	58	8	arrayOfByte	byte[]
    //   91	13	8	localException1	java.lang.Exception
    //   300	1	8	localException2	java.lang.Exception
    //   22	253	9	localLinkedList	java.util.LinkedList
    //   112	3	10	localInterruptedException	java.lang.InterruptedException
    //   249	17	10	locala	a
    // Exception table:
    //   from	to	target	type
    //   0	7	91	java/lang/Exception
    //   34	40	112	java/lang/InterruptedException
    //   285	299	300	java/lang/Exception
  }
  
  public void stop()
  {
    this.dp = false;
  }
  
  public static abstract interface a
  {
    public abstract void aMH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable
 * JD-Core Version:    0.7.0.1
 */