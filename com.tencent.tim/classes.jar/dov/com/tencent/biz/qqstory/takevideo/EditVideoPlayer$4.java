package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import ayhk;
import java.util.concurrent.CountDownLatch;

public class EditVideoPlayer$4
  implements Runnable
{
  public EditVideoPlayer$4(ayhk paramayhk, int paramInt, Bitmap[] paramArrayOfBitmap, CountDownLatch paramCountDownLatch) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:this$0	Layhk;
    //   4: getfield 35	ayhk:oD	Ljava/util/List;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +56 -> 65
    //   12: aload_0
    //   13: getfield 20	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:bqv	I
    //   16: aload_1
    //   17: invokeinterface 41 1 0
    //   22: if_icmpge +43 -> 65
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 20	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:bqv	I
    //   30: invokeinterface 45 2 0
    //   35: checkcast 47	dov/com/tencent/biz/qqstory/takevideo/MultiBlockVideoPlayer$a
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +17 -> 57
    //   43: aload_0
    //   44: getfield 22	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:j	[Landroid/graphics/Bitmap;
    //   47: iconst_0
    //   48: aload_0
    //   49: getfield 18	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:this$0	Layhk;
    //   52: aload_1
    //   53: invokevirtual 51	ayhk:a	(Ldov/com/tencent/biz/qqstory/takevideo/MultiBlockVideoPlayer$a;)Landroid/graphics/Bitmap;
    //   56: aastore
    //   57: aload_0
    //   58: getfield 24	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   61: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
    //   64: return
    //   65: aconst_null
    //   66: astore_1
    //   67: goto -28 -> 39
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 24	dov/com/tencent/biz/qqstory/takevideo/EditVideoPlayer$4:val$countDownLatch	Ljava/util/concurrent/CountDownLatch;
    //   75: invokevirtual 56	java/util/concurrent/CountDownLatch:countDown	()V
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	4
    //   7	60	1	localObject1	Object
    //   70	9	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	70	finally
    //   12	39	70	finally
    //   43	57	70	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.4
 * JD-Core Version:    0.7.0.1
 */