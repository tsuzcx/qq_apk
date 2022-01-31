import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFramesFetcher;

public class xtq
  implements Runnable
{
  public xtq(VideoFramesFetcher paramVideoFramesFetcher) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 25	com/tencent/maxvideo/trim/TrimNative:isGetThumbnailReady	()Z
    //   3: ifne +50 -> 53
    //   6: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +11 -> 20
    //   12: ldc 32
    //   14: iconst_2
    //   15: ldc 34
    //   17: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   20: return
    //   21: aload_3
    //   22: getfield 43	xtr:jdField_a_of_type_Int	I
    //   25: i2l
    //   26: aload_3
    //   27: getfield 46	xtr:b	I
    //   30: i2l
    //   31: invokestatic 51	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:b	(JJ)Landroid/graphics/Bitmap;
    //   34: astore_2
    //   35: aload_2
    //   36: ifnonnull +69 -> 105
    //   39: invokestatic 30	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +11 -> 53
    //   45: ldc 32
    //   47: iconst_2
    //   48: ldc 53
    //   50: invokestatic 38	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: aload_0
    //   54: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   57: invokestatic 58	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   60: ifne +138 -> 198
    //   63: aload_0
    //   64: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   67: invokestatic 61	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   70: ifnull +128 -> 198
    //   73: aload_0
    //   74: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   77: invokestatic 61	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/BlockingQueue;
    //   80: invokeinterface 67 1 0
    //   85: checkcast 40	xtr
    //   88: astore_3
    //   89: aload_0
    //   90: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   93: invokestatic 58	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Z
    //   96: istore_1
    //   97: iload_1
    //   98: ifeq -77 -> 21
    //   101: invokestatic 70	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   104: return
    //   105: new 72	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame
    //   108: dup
    //   109: invokespecial 73	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: aload_2
    //   117: getstatic 79	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   120: iconst_1
    //   121: invokevirtual 85	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   124: putfield 88	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   127: aload 4
    //   129: aload_3
    //   130: getfield 43	xtr:jdField_a_of_type_Int	I
    //   133: aload_0
    //   134: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   137: invokestatic 91	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:b	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)I
    //   140: idiv
    //   141: putfield 92	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame:jdField_a_of_type_Int	I
    //   144: aload_2
    //   145: invokevirtual 95	android/graphics/Bitmap:recycle	()V
    //   148: aload_0
    //   149: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   152: invokestatic 98	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter;
    //   155: aload 4
    //   157: invokevirtual 103	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FrameAdapter:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/FramesProcessor$Frame;)V
    //   160: aload_0
    //   161: getfield 12	xtq:a	Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;
    //   164: invokestatic 106	com/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher:a	(Lcom/tencent/mobileqq/activity/richmedia/trimvideo/video/widget/VideoFramesFetcher;)Ljava/util/concurrent/ConcurrentHashMap;
    //   167: aload_3
    //   168: getfield 43	xtr:jdField_a_of_type_Int	I
    //   171: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: invokevirtual 118	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: goto -125 -> 53
    //   181: astore_2
    //   182: ldc 32
    //   184: iconst_2
    //   185: ldc 120
    //   187: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_2
    //   191: invokevirtual 126	java/lang/InterruptedException:printStackTrace	()V
    //   194: invokestatic 70	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   197: return
    //   198: invokestatic 70	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   201: return
    //   202: astore_2
    //   203: invokestatic 70	com/tencent/maxvideo/trim/TrimNative:release	()V
    //   206: aload_2
    //   207: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	xtq
    //   96	2	1	bool	boolean
    //   34	111	2	localBitmap	android.graphics.Bitmap
    //   181	10	2	localInterruptedException	java.lang.InterruptedException
    //   202	5	2	localObject	Object
    //   21	147	3	localxtr	xtr
    //   112	44	4	localFrame	com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor.Frame
    // Exception table:
    //   from	to	target	type
    //   21	35	181	java/lang/InterruptedException
    //   39	53	181	java/lang/InterruptedException
    //   53	97	181	java/lang/InterruptedException
    //   105	178	181	java/lang/InterruptedException
    //   21	35	202	finally
    //   39	53	202	finally
    //   53	97	202	finally
    //   105	178	202	finally
    //   182	194	202	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xtq
 * JD-Core Version:    0.7.0.1
 */