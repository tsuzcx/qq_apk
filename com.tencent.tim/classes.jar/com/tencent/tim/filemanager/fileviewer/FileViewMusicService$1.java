package com.tencent.tim.filemanager.fileviewer;

import atyk;
import atyk.a;

public class FileViewMusicService$1
  implements Runnable
{
  public FileViewMusicService$1(atyk paramatyk, String paramString, atyk.a parama) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 37	android/media/MediaPlayer
    //   3: dup
    //   4: invokespecial 38	android/media/MediaPlayer:<init>	()V
    //   7: astore_3
    //   8: new 40	java/io/FileInputStream
    //   11: dup
    //   12: new 42	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: getfield 18	com/tencent/tim/filemanager/fileviewer/FileViewMusicService$1:bGY	Ljava/lang/String;
    //   20: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_2
    //   28: astore_1
    //   29: aload_3
    //   30: iconst_3
    //   31: invokevirtual 52	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   34: aload_2
    //   35: astore_1
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 56	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   41: invokevirtual 60	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   44: aload_2
    //   45: astore_1
    //   46: aload_3
    //   47: new 62	atyl
    //   50: dup
    //   51: aload_0
    //   52: aload_3
    //   53: invokespecial 65	atyl:<init>	(Lcom/tencent/tim/filemanager/fileviewer/FileViewMusicService$1;Landroid/media/MediaPlayer;)V
    //   56: invokevirtual 69	android/media/MediaPlayer:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: invokevirtual 72	android/media/MediaPlayer:prepareAsync	()V
    //   65: aload_2
    //   66: ifnull +7 -> 73
    //   69: aload_2
    //   70: invokevirtual 75	java/io/FileInputStream:close	()V
    //   73: return
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   79: return
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: invokevirtual 79	java/lang/IllegalArgumentException:printStackTrace	()V
    //   89: aload_2
    //   90: ifnull -17 -> 73
    //   93: aload_2
    //   94: invokevirtual 75	java/io/FileInputStream:close	()V
    //   97: return
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   103: return
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: astore_1
    //   109: aload_3
    //   110: invokevirtual 80	java/lang/SecurityException:printStackTrace	()V
    //   113: aload_2
    //   114: ifnull -41 -> 73
    //   117: aload_2
    //   118: invokevirtual 75	java/io/FileInputStream:close	()V
    //   121: return
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   127: return
    //   128: astore_3
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: astore_1
    //   133: aload_3
    //   134: invokevirtual 81	java/lang/IllegalStateException:printStackTrace	()V
    //   137: aload_2
    //   138: ifnull -65 -> 73
    //   141: aload_2
    //   142: invokevirtual 75	java/io/FileInputStream:close	()V
    //   145: return
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   151: return
    //   152: astore_3
    //   153: aconst_null
    //   154: astore_2
    //   155: aload_2
    //   156: astore_1
    //   157: aload_3
    //   158: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   161: aload_2
    //   162: ifnull -89 -> 73
    //   165: aload_2
    //   166: invokevirtual 75	java/io/FileInputStream:close	()V
    //   169: return
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   175: return
    //   176: astore_3
    //   177: aconst_null
    //   178: astore_2
    //   179: aload_2
    //   180: astore_1
    //   181: aload_3
    //   182: invokevirtual 82	java/lang/NullPointerException:printStackTrace	()V
    //   185: aload_2
    //   186: ifnull -113 -> 73
    //   189: aload_2
    //   190: invokevirtual 75	java/io/FileInputStream:close	()V
    //   193: return
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   199: return
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 75	java/io/FileInputStream:close	()V
    //   211: aload_2
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_2
    //   222: goto -19 -> 203
    //   225: astore_3
    //   226: goto -47 -> 179
    //   229: astore_3
    //   230: goto -75 -> 155
    //   233: astore_3
    //   234: goto -103 -> 131
    //   237: astore_3
    //   238: goto -131 -> 107
    //   241: astore_3
    //   242: goto -159 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	1
    //   28	33	1	localFileInputStream1	java.io.FileInputStream
    //   74	2	1	localIOException1	java.io.IOException
    //   84	1	1	localFileInputStream2	java.io.FileInputStream
    //   98	2	1	localIOException2	java.io.IOException
    //   108	1	1	localFileInputStream3	java.io.FileInputStream
    //   122	2	1	localIOException3	java.io.IOException
    //   132	1	1	localFileInputStream4	java.io.FileInputStream
    //   146	2	1	localIOException4	java.io.IOException
    //   156	1	1	localFileInputStream5	java.io.FileInputStream
    //   170	2	1	localIOException5	java.io.IOException
    //   180	1	1	localFileInputStream6	java.io.FileInputStream
    //   194	2	1	localIOException6	java.io.IOException
    //   202	6	1	localObject1	Object
    //   213	2	1	localIOException7	java.io.IOException
    //   26	164	2	localFileInputStream7	java.io.FileInputStream
    //   200	12	2	localObject2	Object
    //   221	1	2	localObject3	Object
    //   7	55	3	localMediaPlayer	android.media.MediaPlayer
    //   80	6	3	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   104	6	3	localSecurityException1	java.lang.SecurityException
    //   128	6	3	localIllegalStateException1	java.lang.IllegalStateException
    //   152	6	3	localIOException8	java.io.IOException
    //   176	6	3	localNullPointerException1	java.lang.NullPointerException
    //   225	1	3	localNullPointerException2	java.lang.NullPointerException
    //   229	1	3	localIOException9	java.io.IOException
    //   233	1	3	localIllegalStateException2	java.lang.IllegalStateException
    //   237	1	3	localSecurityException2	java.lang.SecurityException
    //   241	1	3	localIllegalArgumentException2	java.lang.IllegalArgumentException
    // Exception table:
    //   from	to	target	type
    //   69	73	74	java/io/IOException
    //   8	27	80	java/lang/IllegalArgumentException
    //   93	97	98	java/io/IOException
    //   8	27	104	java/lang/SecurityException
    //   117	121	122	java/io/IOException
    //   8	27	128	java/lang/IllegalStateException
    //   141	145	146	java/io/IOException
    //   8	27	152	java/io/IOException
    //   165	169	170	java/io/IOException
    //   8	27	176	java/lang/NullPointerException
    //   189	193	194	java/io/IOException
    //   8	27	200	finally
    //   207	211	213	java/io/IOException
    //   29	34	221	finally
    //   36	44	221	finally
    //   46	59	221	finally
    //   61	65	221	finally
    //   85	89	221	finally
    //   109	113	221	finally
    //   133	137	221	finally
    //   157	161	221	finally
    //   181	185	221	finally
    //   29	34	225	java/lang/NullPointerException
    //   36	44	225	java/lang/NullPointerException
    //   46	59	225	java/lang/NullPointerException
    //   61	65	225	java/lang/NullPointerException
    //   29	34	229	java/io/IOException
    //   36	44	229	java/io/IOException
    //   46	59	229	java/io/IOException
    //   61	65	229	java/io/IOException
    //   29	34	233	java/lang/IllegalStateException
    //   36	44	233	java/lang/IllegalStateException
    //   46	59	233	java/lang/IllegalStateException
    //   61	65	233	java/lang/IllegalStateException
    //   29	34	237	java/lang/SecurityException
    //   36	44	237	java/lang/SecurityException
    //   46	59	237	java/lang/SecurityException
    //   61	65	237	java/lang/SecurityException
    //   29	34	241	java/lang/IllegalArgumentException
    //   36	44	241	java/lang/IllegalArgumentException
    //   46	59	241	java/lang/IllegalArgumentException
    //   61	65	241	java/lang/IllegalArgumentException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.filemanager.fileviewer.FileViewMusicService.1
 * JD-Core Version:    0.7.0.1
 */