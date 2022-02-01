import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public class alzu
{
  private static final char[] hexArray = "0123456789ABCDEF".toCharArray();
  
  @Nullable
  public static List<Long> aK(String paramString)
  {
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        paramString = new ArrayList();
        i = 0;
        if (i >= localMediaExtractor.getTrackCount()) {
          break label313;
        }
        MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(i);
        if (localMediaFormat.getString("mime").startsWith("video/"))
        {
          localMediaExtractor.selectTrack(i);
          l1 = localMediaFormat.getLong("durationUs");
          if (l1 != -1L) {
            break label129;
          }
          localMediaExtractor.release();
          return null;
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        localMediaExtractor.release();
        return null;
      }
      i += 1;
      continue;
      label129:
      long l2;
      do
      {
        Object localObject;
        paramString.add(Long.valueOf(localObject));
        localMediaExtractor.seekTo(1000000L + localObject, 1);
        if (localMediaExtractor.getSampleTime() == -1L) {
          break;
        }
        l2 = localMediaExtractor.getSampleTime();
      } while ((paramString.size() <= 1) || (((Long)paramString.get(paramString.size() - 1)).longValue() != l2));
      paramString.add(Long.valueOf(l1));
      localMediaExtractor.release();
      int i = paramString.size();
      if (i > 2)
      {
        l1 = ((Long)paramString.get(i - 2)).longValue();
        l2 = ((Long)paramString.get(i - 3)).longValue();
        long l3 = ((Long)paramString.get(i - 1)).longValue() - ((Long)paramString.get(i - 2)).longValue();
        if ((l3 < 400000L) && (l1 - l2 + l3 < 2000000L)) {
          paramString.remove(i - 2);
        }
      }
      return paramString;
      label313:
      long l1 = -1L;
    }
  }
  
  public static int dQ(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(18);
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ram.e("MediaUtil", paramString.toString());
      return 0;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public static int dR(String paramString)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(19);
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.valueOf(paramString).intValue();
      }
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ram.e("MediaUtil", paramString.toString());
      return 0;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public static long getDuration(String paramString)
  {
    long l = -1L;
    if (Build.VERSION.SDK_INT >= 10) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(9);
      localMediaMetadataRetriever.release();
      l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  /* Error */
  public static int[] m(String paramString)
  {
    // Byte code:
    //   0: new 127	android/media/MediaMetadataRetriever
    //   3: dup
    //   4: invokespecial 128	android/media/MediaMetadataRetriever:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_0
    //   10: invokevirtual 129	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   13: aload_3
    //   14: bipush 18
    //   16: invokevirtual 133	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   19: astore_0
    //   20: aload_3
    //   21: bipush 19
    //   23: invokevirtual 133	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   26: astore 4
    //   28: aload_0
    //   29: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   32: ifne +81 -> 113
    //   35: aload_0
    //   36: invokestatic 144	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   39: invokevirtual 147	java/lang/Integer:intValue	()I
    //   42: istore_1
    //   43: aload 4
    //   45: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne +60 -> 108
    //   51: aload 4
    //   53: invokestatic 144	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   56: invokevirtual 147	java/lang/Integer:intValue	()I
    //   59: istore_2
    //   60: aload_3
    //   61: invokevirtual 148	android/media/MediaMetadataRetriever:release	()V
    //   64: iconst_2
    //   65: newarray int
    //   67: dup
    //   68: iconst_0
    //   69: iload_1
    //   70: iastore
    //   71: dup
    //   72: iconst_1
    //   73: iload_2
    //   74: iastore
    //   75: areturn
    //   76: astore_0
    //   77: iconst_0
    //   78: istore_1
    //   79: ldc 150
    //   81: aload_0
    //   82: invokevirtual 154	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   85: invokestatic 160	ram:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_3
    //   89: invokevirtual 148	android/media/MediaMetadataRetriever:release	()V
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -30 -> 64
    //   97: astore_0
    //   98: aload_3
    //   99: invokevirtual 148	android/media/MediaMetadataRetriever:release	()V
    //   102: aload_0
    //   103: athrow
    //   104: astore_0
    //   105: goto -26 -> 79
    //   108: iconst_0
    //   109: istore_2
    //   110: goto -50 -> 60
    //   113: iconst_0
    //   114: istore_1
    //   115: goto -72 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString	String
    //   42	73	1	i	int
    //   59	51	2	j	int
    //   7	92	3	localMediaMetadataRetriever	MediaMetadataRetriever
    //   26	26	4	str	String
    // Exception table:
    //   from	to	target	type
    //   28	43	76	java/lang/NumberFormatException
    //   28	43	97	finally
    //   43	60	97	finally
    //   79	88	97	finally
    //   43	60	104	java/lang/NumberFormatException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzu
 * JD-Core Version:    0.7.0.1
 */