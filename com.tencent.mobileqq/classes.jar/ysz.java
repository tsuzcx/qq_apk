import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.apollo.aioChannel.IRenderRunner;
import com.tencent.mobileqq.apollo.utils.ApolloGameMusicPlayer;

public class ysz
  implements MediaPlayer.OnCompletionListener
{
  int jdField_a_of_type_Int = this.b;
  
  public ysz(ApolloGameMusicPlayer paramApolloGameMusicPlayer, int paramInt1, int paramInt2, IRenderRunner paramIRenderRunner, long paramLong) {}
  
  /* Error */
  public void onCompletion(android.media.MediaPlayer paramMediaPlayer)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 30	ysz:jdField_a_of_type_Int	I
    //   5: iconst_1
    //   6: isub
    //   7: putfield 30	ysz:jdField_a_of_type_Int	I
    //   10: aload_1
    //   11: iconst_0
    //   12: invokevirtual 41	android/media/MediaPlayer:seekTo	(I)V
    //   15: aload_0
    //   16: getfield 30	ysz:jdField_a_of_type_Int	I
    //   19: ifle +21 -> 40
    //   22: aload_0
    //   23: getfield 17	ysz:jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer;
    //   26: getfield 46	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   29: invokevirtual 52	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   32: ifne +8 -> 40
    //   35: aload_1
    //   36: invokevirtual 55	android/media/MediaPlayer:start	()V
    //   39: return
    //   40: aload_0
    //   41: getfield 17	ysz:jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer;
    //   44: getfield 46	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   47: invokevirtual 52	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   50: ifeq +11 -> 61
    //   53: invokestatic 61	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: iconst_0
    //   57: invokestatic 66	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   60: pop
    //   61: aload_0
    //   62: getfield 17	ysz:jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer;
    //   65: invokestatic 69	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:a	(Lcom/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer;)Ljava/lang/Object;
    //   68: astore_2
    //   69: aload_2
    //   70: monitorenter
    //   71: aload_0
    //   72: getfield 17	ysz:jdField_a_of_type_ComTencentMobileqqApolloUtilsApolloGameMusicPlayer	Lcom/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer;
    //   75: aload_0
    //   76: getfield 21	ysz:c	I
    //   79: aload_1
    //   80: invokestatic 72	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:a	(Lcom/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer;ILandroid/media/MediaPlayer;)V
    //   83: aload_2
    //   84: monitorexit
    //   85: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +32 -> 120
    //   91: getstatic 80	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: iconst_2
    //   95: new 82	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   102: ldc 85
    //   104: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 93	android/media/MediaPlayer:getAudioSessionId	()I
    //   111: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   120: aload_0
    //   121: getfield 23	ysz:jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner	Lcom/tencent/mobileqq/apollo/aioChannel/IRenderRunner;
    //   124: instanceof 106
    //   127: ifeq +24 -> 151
    //   130: aload_0
    //   131: getfield 23	ysz:jdField_a_of_type_ComTencentMobileqqApolloAioChannelIRenderRunner	Lcom/tencent/mobileqq/apollo/aioChannel/IRenderRunner;
    //   134: checkcast 106	com/tencent/mobileqq/apollo/ApolloSurfaceView
    //   137: astore_2
    //   138: aload_2
    //   139: new 108	yta
    //   142: dup
    //   143: aload_0
    //   144: aload_2
    //   145: invokespecial 111	yta:<init>	(Lysz;Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;)V
    //   148: invokevirtual 115	com/tencent/mobileqq/apollo/ApolloSurfaceView:queueEvent	(Ljava/lang/Runnable;)V
    //   151: aload_1
    //   152: invokevirtual 118	android/media/MediaPlayer:reset	()V
    //   155: aload_1
    //   156: invokevirtual 121	android/media/MediaPlayer:release	()V
    //   159: return
    //   160: astore_2
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 121	android/media/MediaPlayer:release	()V
    //   169: getstatic 80	com/tencent/mobileqq/apollo/utils/ApolloGameMusicPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: iconst_1
    //   173: ldc 123
    //   175: aload_2
    //   176: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   179: return
    //   180: astore_3
    //   181: aload_2
    //   182: monitorexit
    //   183: aload_3
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ysz
    //   0	185	1	paramMediaPlayer	android.media.MediaPlayer
    //   160	22	2	localThrowable	java.lang.Throwable
    //   180	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	39	160	java/lang/Throwable
    //   40	61	160	java/lang/Throwable
    //   61	71	160	java/lang/Throwable
    //   85	120	160	java/lang/Throwable
    //   120	151	160	java/lang/Throwable
    //   151	159	160	java/lang/Throwable
    //   183	185	160	java/lang/Throwable
    //   71	85	180	finally
    //   181	183	180	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ysz
 * JD-Core Version:    0.7.0.1
 */