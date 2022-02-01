package com.tencent.thumbplayer.adapter.player.thumbplayer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap.MapDrmType;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.util.Arrays;
import java.util.HashSet;

final class TPDrmCapability$1
  implements Runnable
{
  TPDrmCapability$1(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    int i = 0;
    Object localObject = new int[0];
    try
    {
      int[] arrayOfInt = TPThumbplayerCapabilityHelper.getDRMCapabilities();
      localObject = arrayOfInt;
    }
    catch (TPNativeLibraryException localTPNativeLibraryException)
    {
      for (;;)
      {
        TPLogUtil.e("TPDrmCapability", localTPNativeLibraryException);
      }
      HashSet localHashSet = new HashSet();
      int j = localObject.length;
      while (i < j)
      {
        localHashSet.add(String.valueOf(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, localObject[i])));
        i += 1;
      }
      TPDrmCapability.access$000(localHashSet);
      localObject = this.val$sp.edit();
      ((SharedPreferences.Editor)localObject).putStringSet("DRM_CAP_LIST", localHashSet);
      ((SharedPreferences.Editor)localObject).apply();
    }
    TPLogUtil.i("TPDrmCapability", "TPThumbplayerCapabilityHelper, drm cap:" + Arrays.toString((int[])localObject));
    if (localObject.length == 0) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.thumbplayer.TPDrmCapability.1
 * JD-Core Version:    0.7.0.1
 */