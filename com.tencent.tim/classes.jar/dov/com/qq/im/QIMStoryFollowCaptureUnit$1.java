package dov.com.qq.im;

import awsz;

public class QIMStoryFollowCaptureUnit$1
  implements Runnable
{
  public QIMStoryFollowCaptureUnit$1(awsz paramawsz) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 21	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 22	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   13: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   16: getfield 34	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:videoPath	Ljava/lang/String;
    //   19: invokevirtual 38	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   22: aload_2
    //   23: bipush 9
    //   25: invokevirtual 42	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: invokestatic 48	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: istore_1
    //   34: iload_1
    //   35: ifne +185 -> 220
    //   38: aload_0
    //   39: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   42: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   45: aload_3
    //   46: invokestatic 54	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   49: putfield 58	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:duration	J
    //   52: aload_0
    //   53: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   56: getfield 61	awsz:a	Ldov/com/tencent/mobileqq/richmedia/capture/view/QIMCameraCaptureButtonLayout;
    //   59: aload_0
    //   60: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   63: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   66: getfield 58	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:duration	J
    //   69: l2f
    //   70: invokevirtual 67	dov/com/tencent/mobileqq/richmedia/capture/view/QIMCameraCaptureButtonLayout:setMaxDuration	(F)V
    //   73: aload_0
    //   74: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   77: invokestatic 70	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/view/FollowCaptureView;
    //   80: aload_0
    //   81: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   84: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   87: invokevirtual 76	com/tencent/mobileqq/richmedia/capture/view/FollowCaptureView:setData	(Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;)V
    //   90: aload_0
    //   91: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   94: iconst_0
    //   95: invokestatic 79	awsz:a	(Lawsz;Z)Z
    //   98: pop
    //   99: new 81	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   106: aload_0
    //   107: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   110: invokestatic 70	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/view/FollowCaptureView;
    //   113: invokevirtual 86	com/tencent/mobileqq/richmedia/capture/view/FollowCaptureView:yI	()Ljava/lang/String;
    //   116: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   122: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 97
    //   127: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: getstatic 95	java/io/File:separator	Ljava/lang/String;
    //   133: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokestatic 102	anlb:Ab	()Ljava/lang/String;
    //   139: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore_3
    //   146: aload_0
    //   147: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   150: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   153: aload_3
    //   154: putfield 108	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:audioPath	Ljava/lang/String;
    //   157: aload_0
    //   158: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   161: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   164: getfield 34	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:videoPath	Ljava/lang/String;
    //   167: aload_0
    //   168: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   171: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   174: getfield 58	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:duration	J
    //   177: aload_0
    //   178: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   181: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   184: getfield 108	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:audioPath	Ljava/lang/String;
    //   187: invokestatic 114	dov/com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:k	(Ljava/lang/String;JLjava/lang/String;)V
    //   190: aload_0
    //   191: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   194: iconst_1
    //   195: invokestatic 79	awsz:a	(Lawsz;Z)Z
    //   198: pop
    //   199: aload_0
    //   200: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   203: aload_0
    //   204: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   207: invokestatic 117	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$VideoCaptureResult;
    //   210: aload_0
    //   211: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   214: invokestatic 120	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;
    //   217: invokevirtual 123	awsz:a	(Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView$VideoCaptureResult;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V
    //   220: aload_2
    //   221: invokevirtual 126	android/media/MediaMetadataRetriever:release	()V
    //   224: return
    //   225: astore_3
    //   226: ldc 128
    //   228: iconst_1
    //   229: aload_3
    //   230: iconst_1
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: new 81	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   243: ldc 130
    //   245: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_0
    //   249: getfield 12	dov/com/qq/im/QIMStoryFollowCaptureUnit$1:this$0	Lawsz;
    //   252: invokestatic 28	awsz:a	(Lawsz;)Lcom/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam;
    //   255: getfield 34	com/tencent/mobileqq/richmedia/capture/data/FollowCaptureParam:videoPath	Ljava/lang/String;
    //   258: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: aastore
    //   265: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   268: goto -48 -> 220
    //   271: astore_3
    //   272: aload_2
    //   273: invokevirtual 126	android/media/MediaMetadataRetriever:release	()V
    //   276: aload_3
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	1
    //   33	2	1	bool	boolean
    //   7	266	2	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   28	126	3	str	java.lang.String
    //   225	5	3	localException	java.lang.Exception
    //   271	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   38	220	225	java/lang/Exception
    //   8	34	271	finally
    //   38	220	271	finally
    //   226	268	271	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMStoryFollowCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */