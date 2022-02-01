package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo.Section;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.api.composition.TPMediaCompositionFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class TVideoUtil
{
  public static ITPMediaAsset createTPMediaAsset(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (paramSuperPlayerVideoInfo.getFormat() == 303)
    {
      ITPMediaTrack localITPMediaTrack = TPMediaCompositionFactory.createMediaTrack(1);
      paramSuperPlayerVideoInfo = paramSuperPlayerVideoInfo.getTVideoSectionList().iterator();
      while (paramSuperPlayerVideoInfo.hasNext())
      {
        TVKVideoInfo.Section localSection = (TVKVideoInfo.Section)paramSuperPlayerVideoInfo.next();
        if (TextUtils.isEmpty(localSection.getUrl())) {
          return null;
        }
        ITPMediaTrackClip localITPMediaTrackClip = TPMediaCompositionFactory.createMediaTrackClip(localSection.getUrl(), 1, 0L, 0L);
        localITPMediaTrackClip.setOriginalDurationMs((localSection.getDuration() * 1000.0D));
        localITPMediaTrack.addTrackClip(localITPMediaTrackClip);
      }
      return localITPMediaTrack;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.TVideoUtil
 * JD-Core Version:    0.7.0.1
 */