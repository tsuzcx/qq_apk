package com.tencent.mobileqq.richmedia.segment;

import ambu;
import android.media.MediaFormat;

public class SegmentManager$1
  implements Runnable
{
  public SegmentManager$1(ambu paramambu, String paramString, MediaFormat paramMediaFormat) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   4: invokestatic 35	ambu:a	(Lambu;)Ljava/lang/String;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnull +22 -> 31
    //   12: iconst_0
    //   13: ifeq +11 -> 24
    //   16: new 37	java/lang/NullPointerException
    //   19: dup
    //   20: invokespecial 38	java/lang/NullPointerException:<init>	()V
    //   23: athrow
    //   24: return
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   30: return
    //   31: aload_0
    //   32: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   35: invokevirtual 45	ambu:getThumbPath	()Ljava/lang/String;
    //   38: astore 4
    //   40: new 47	java/io/File
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_0
    //   51: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   54: getfield 53	ambu:a	Lcom/tencent/mobileqq/richmedia/capture/view/CameraCaptureView;
    //   57: invokevirtual 59	com/tencent/mobileqq/richmedia/capture/view/CameraCaptureView:getContext	()Landroid/content/Context;
    //   60: aload_0
    //   61: getfield 18	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:val$filePath	Ljava/lang/String;
    //   64: invokestatic 65	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   67: astore_3
    //   68: aload 4
    //   70: invokestatic 71	aqhq:deleteFile	(Ljava/lang/String;)Z
    //   73: pop
    //   74: aload 4
    //   76: invokestatic 75	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   79: pop
    //   80: aload_1
    //   81: invokevirtual 79	java/io/File:createNewFile	()Z
    //   84: pop
    //   85: new 81	java/io/BufferedOutputStream
    //   88: dup
    //   89: new 83	java/io/FileOutputStream
    //   92: dup
    //   93: aload 4
    //   95: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   98: invokespecial 87	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   101: astore_2
    //   102: aload_2
    //   103: astore_1
    //   104: aload_3
    //   105: getstatic 93	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   108: bipush 80
    //   110: aload_2
    //   111: invokevirtual 99	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   114: pop
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 102	android/graphics/Bitmap:recycle	()V
    //   121: aload_2
    //   122: astore_1
    //   123: aload_2
    //   124: invokevirtual 105	java/io/BufferedOutputStream:flush	()V
    //   127: aload_2
    //   128: astore_1
    //   129: aload_0
    //   130: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   133: aload 4
    //   135: invokestatic 108	ambu:a	(Lambu;Ljava/lang/String;)Ljava/lang/String;
    //   138: pop
    //   139: aload_2
    //   140: astore_1
    //   141: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   144: ifeq +36 -> 180
    //   147: aload_2
    //   148: astore_1
    //   149: ldc 115
    //   151: iconst_2
    //   152: new 117	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   159: ldc 120
    //   161: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_0
    //   165: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   168: invokestatic 35	ambu:a	(Lambu;)Ljava/lang/String;
    //   171: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_2
    //   181: astore_1
    //   182: aload_0
    //   183: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   186: invokestatic 134	ambu:a	(Lambu;)Landroid/os/Bundle;
    //   189: astore_3
    //   190: aload_2
    //   191: astore_1
    //   192: aload_0
    //   193: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   196: getfield 138	ambu:c	Lalvs;
    //   199: sipush 202
    //   202: iconst_m1
    //   203: aload_3
    //   204: invokevirtual 143	alvs:a	(IILandroid/os/Bundle;)Z
    //   207: pop
    //   208: aload_2
    //   209: astore_1
    //   210: aload_0
    //   211: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   214: aload_0
    //   215: getfield 20	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:h	Landroid/media/MediaFormat;
    //   218: invokestatic 146	ambu:a	(Lambu;Landroid/media/MediaFormat;)V
    //   221: aload_2
    //   222: ifnull -198 -> 24
    //   225: aload_2
    //   226: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   229: return
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   235: return
    //   236: astore_3
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_2
    //   240: astore_1
    //   241: aload_3
    //   242: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   245: aload_2
    //   246: astore_1
    //   247: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq +13 -> 263
    //   253: aload_2
    //   254: astore_1
    //   255: ldc 115
    //   257: iconst_2
    //   258: ldc 152
    //   260: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_2
    //   264: astore_1
    //   265: aload_0
    //   266: getfield 16	com/tencent/mobileqq/richmedia/segment/SegmentManager$1:this$0	Lambu;
    //   269: invokevirtual 155	ambu:onError	()V
    //   272: aload_2
    //   273: ifnull -249 -> 24
    //   276: aload_2
    //   277: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   280: return
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   286: return
    //   287: astore_2
    //   288: aconst_null
    //   289: astore_1
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 149	java/io/BufferedOutputStream:close	()V
    //   298: aload_2
    //   299: athrow
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 41	java/io/IOException:printStackTrace	()V
    //   305: goto -7 -> 298
    //   308: astore_2
    //   309: goto -19 -> 290
    //   312: astore_3
    //   313: goto -74 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	1
    //   7	2	1	str1	String
    //   25	2	1	localIOException1	java.io.IOException
    //   49	161	1	localObject1	Object
    //   230	2	1	localIOException2	java.io.IOException
    //   240	25	1	localObject2	Object
    //   281	2	1	localIOException3	java.io.IOException
    //   289	6	1	localObject3	Object
    //   300	2	1	localIOException4	java.io.IOException
    //   101	176	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   287	12	2	localObject4	Object
    //   308	1	2	localObject5	Object
    //   67	137	3	localObject6	Object
    //   236	6	3	localException1	java.lang.Exception
    //   312	1	3	localException2	java.lang.Exception
    //   38	96	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   16	24	25	java/io/IOException
    //   225	229	230	java/io/IOException
    //   0	8	236	java/lang/Exception
    //   31	102	236	java/lang/Exception
    //   276	280	281	java/io/IOException
    //   0	8	287	finally
    //   31	102	287	finally
    //   294	298	300	java/io/IOException
    //   104	115	308	finally
    //   117	121	308	finally
    //   123	127	308	finally
    //   129	139	308	finally
    //   141	147	308	finally
    //   149	180	308	finally
    //   182	190	308	finally
    //   192	208	308	finally
    //   210	221	308	finally
    //   241	245	308	finally
    //   247	253	308	finally
    //   255	263	308	finally
    //   265	272	308	finally
    //   104	115	312	java/lang/Exception
    //   117	121	312	java/lang/Exception
    //   123	127	312	java/lang/Exception
    //   129	139	312	java/lang/Exception
    //   141	147	312	java/lang/Exception
    //   149	180	312	java/lang/Exception
    //   182	190	312	java/lang/Exception
    //   192	208	312	java/lang/Exception
    //   210	221	312	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.SegmentManager.1
 * JD-Core Version:    0.7.0.1
 */