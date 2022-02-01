package com.tencent.qqmini.flutter;

import android.content.Context;
import android.view.Surface;
import android.view.View;
import com.qflutter.video.QflutterVideoViewSource.Provider;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.Map;

public class VideoViewProvider
  implements QflutterVideoViewSource.Provider
{
  public View getView(Context paramContext, int paramInt, Surface paramSurface, Map<String, Object> paramMap)
  {
    if ("getView" + paramMap != null) {}
    for (paramSurface = paramMap.toString();; paramSurface = "")
    {
      QMLog.e("QFVideoView", paramSurface);
      paramMap.get("videoPlayerId");
      paramMap.put("autoplay", Boolean.valueOf(true));
      return new FlutterVideoViewContainer(paramContext, paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.flutter.VideoViewProvider
 * JD-Core Version:    0.7.0.1
 */