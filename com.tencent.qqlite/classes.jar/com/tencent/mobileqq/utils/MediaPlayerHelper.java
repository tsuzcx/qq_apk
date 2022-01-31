package com.tencent.mobileqq.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MediaPlayerHelper
{
  private static MediaPlayerHelper jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  
  public static MediaPlayerHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper == null) {
      jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper = new MediaPlayerHelper();
    }
    return jdField_a_of_type_ComTencentMobileqqUtilsMediaPlayerHelper;
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_m1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 24	android/media/MediaPlayer:getCurrentPosition	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   12	13	1	i	int
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   18: invokevirtual 27	android/media/MediaPlayer:stop	()V
    //   21: aload_0
    //   22: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   25: invokevirtual 30	android/media/MediaPlayer:release	()V
    //   28: aload_0
    //   29: aconst_null
    //   30: putfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   33: goto -22 -> 11
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	MediaPlayerHelper
    //   6	2	1	localMediaPlayer	MediaPlayer
    //   36	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	36	finally
    //   14	33	36	finally
  }
  
  public void a(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(paramOnCompletionListener);
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 41	android/media/MediaPlayer:start	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 44	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  public boolean a(Context paramContext, Uri paramUri)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramContext, paramUri);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        bool = true;
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (SecurityException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      return bool;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
    }
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      boolean bool2;
      try
      {
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
        }
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
        paramContext = new File(paramContext.getFilesDir(), paramString);
        bool2 = paramContext.exists();
        if (bool2) {
          break label73;
        }
      }
      catch (IllegalStateException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      catch (SecurityException paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      return bool1;
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      continue;
      label73:
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(new FileInputStream(paramContext.getAbsolutePath()).getFD());
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      bool1 = true;
    }
  }
  
  /* Error */
  public int b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_m1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 103	android/media/MediaPlayer:getDuration	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   12	13	1	i	int
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 27	android/media/MediaPlayer:stop	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 44	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 107	android/media/MediaPlayer:pause	()V
    //   24: iconst_1
    //   25: istore_1
    //   26: goto -13 -> 13
    //   29: astore_2
    //   30: aload_2
    //   31: invokevirtual 44	java/lang/IllegalStateException:printStackTrace	()V
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	MediaPlayerHelper
    //   1	25	1	bool	boolean
    //   8	2	2	localMediaPlayer	MediaPlayer
    //   29	2	2	localIllegalStateException	IllegalStateException
    //   37	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   17	24	29	java/lang/IllegalStateException
    //   4	9	37	finally
    //   17	24	37	finally
    //   30	34	37	finally
  }
  
  /* Error */
  public boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 19	com/tencent/mobileqq/utils/MediaPlayerHelper:jdField_a_of_type_AndroidMediaMediaPlayer	Landroid/media/MediaPlayer;
    //   21: invokevirtual 111	android/media/MediaPlayer:isPlaying	()Z
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	MediaPlayerHelper
    //   12	13	1	bool	boolean
    //   6	2	2	localMediaPlayer	MediaPlayer
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.MediaPlayerHelper
 * JD-Core Version:    0.7.0.1
 */