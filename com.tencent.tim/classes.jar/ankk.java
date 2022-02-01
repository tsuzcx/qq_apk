import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import com.tencent.qphone.base.util.QLog;

@TargetApi(18)
public class ankk
{
  public static int a(String paramString, ankk.a parama)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    label226:
    for (;;)
    {
      String str1;
      String str2;
      String str3;
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString);
        str1 = localMediaMetadataRetriever.extractMetadata(18);
        str2 = localMediaMetadataRetriever.extractMetadata(19);
        paramString = localMediaMetadataRetriever.extractMetadata(24);
        str3 = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        if ((paramString != null) && (!"".equals(paramString)) && (!"null".equals(paramString))) {
          break label226;
        }
        paramString = "0";
        if ((str1 == null) || (str2 == null))
        {
          QLog.e("MediaMetadataUtils", 1, "[@] extractMetadata:width=" + str1 + " height=" + str2);
          return -2;
        }
      }
      catch (RuntimeException paramString)
      {
        QLog.e("MediaMetadataUtils", 1, "[@] setDataSource", paramString);
        return -1;
      }
      for (;;)
      {
        try
        {
          parama.mMetaData[0] = Integer.parseInt(str1);
          parama.mMetaData[1] = Integer.parseInt(str2);
          parama.mMetaData[3] = Integer.parseInt(str3);
          i = 0;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("MediaMetadataUtils", 1, "[@] parseInt", localNumberFormatException);
          int i = -3;
          continue;
        }
        try
        {
          parama.mMetaData[2] = Integer.parseInt(paramString);
          parama.mMetaData[4] = 0;
          return i;
        }
        catch (NumberFormatException paramString)
        {
          QLog.e("MediaMetadataUtils", 1, "[@] parseInt", paramString);
          parama.mMetaData[2] = 0;
          return i;
        }
      }
    }
  }
  
  public static class a
  {
    public int[] mMetaData = new int[5];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankk
 * JD-Core Version:    0.7.0.1
 */