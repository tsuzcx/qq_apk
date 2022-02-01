package tv.danmaku.ijk.media.player;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class IjkMediaPlayer$DefaultMediaCodecSelector
  implements IjkMediaPlayer.OnMediaCodecSelectListener
{
  public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();
  
  @TargetApi(16)
  public String onMediaCodecSelect(IMediaPlayer paramIMediaPlayer, String paramString, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Log.i(IjkMediaPlayer.access$100(), String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    Object localObject1 = new ArrayList();
    int i = MediaCodecList.getCodecCount();
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramIMediaPlayer = MediaCodecList.getCodecInfoAt(paramInt1);
      Log.d(IjkMediaPlayer.access$100(), String.format(Locale.US, "  found codec: %s", new Object[] { paramIMediaPlayer.getName() }));
      if (!paramIMediaPlayer.isEncoder())
      {
        String[] arrayOfString = paramIMediaPlayer.getSupportedTypes();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          paramInt2 = 0;
          while (paramInt2 < j)
          {
            Object localObject2 = arrayOfString[paramInt2];
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              Log.d(IjkMediaPlayer.access$100(), String.format(Locale.US, "    mime: %s", new Object[] { localObject2 }));
              if (((String)localObject2).equalsIgnoreCase(paramString))
              {
                localObject2 = IjkMediaCodecInfo.setupCandidate(paramIMediaPlayer, paramString);
                if (localObject2 != null)
                {
                  ((ArrayList)localObject1).add(localObject2);
                  Log.i(IjkMediaPlayer.access$100(), String.format(Locale.US, "candidate codec: %s rank=%d", new Object[] { paramIMediaPlayer.getName(), Integer.valueOf(((IjkMediaCodecInfo)localObject2).mRank) }));
                  ((IjkMediaCodecInfo)localObject2).dumpProfileLevels(paramString);
                }
              }
            }
            paramInt2 += 1;
          }
        }
      }
      paramInt1 += 1;
    }
    if (((ArrayList)localObject1).isEmpty()) {
      return null;
    }
    paramIMediaPlayer = (IjkMediaCodecInfo)((ArrayList)localObject1).get(0);
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramString = (IjkMediaCodecInfo)((Iterator)localObject1).next();
      if (paramString.mRank > paramIMediaPlayer.mRank) {
        paramIMediaPlayer = paramString;
      }
    }
    if (paramIMediaPlayer.mRank < 600)
    {
      Log.w(IjkMediaPlayer.access$100(), String.format(Locale.US, "unaccetable codec: %s", new Object[] { paramIMediaPlayer.mCodecInfo.getName() }));
      return null;
    }
    Log.i(IjkMediaPlayer.access$100(), String.format(Locale.US, "selected codec: %s rank=%d", new Object[] { paramIMediaPlayer.mCodecInfo.getName(), Integer.valueOf(paramIMediaPlayer.mRank) }));
    return paramIMediaPlayer.mCodecInfo.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector
 * JD-Core Version:    0.7.0.1
 */