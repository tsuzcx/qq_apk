package com.tencent.superplayer.utils;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.superplayer.config.CacheContent;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.tmediacodec.reuse.ReusePolicy.EraseType;
import org.json.JSONArray;
import org.json.JSONException;

public class CodecReuseHelper
{
  private static final String TAG = "CodecReuseHelper";
  private static volatile CodecReuseHelper mInstance;
  private boolean hasLoadHardwareList = false;
  private boolean isDeviceSupport = false;
  
  public static CodecReuseHelper get()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new CodecReuseHelper();
      }
      return mInstance;
    }
    finally {}
  }
  
  public ReusePolicy.EraseType getEraseType()
  {
    int i = Math.max(Math.min(ConfigManager.get().getConfig("codecReuse").getInt("codec_erase_policy", ReusePolicy.EraseType.SAME.ordinal()), ReusePolicy.EraseType.values().length - 1), 0);
    return ReusePolicy.EraseType.values()[i];
  }
  
  public boolean isDeviceSupport()
  {
    Object localObject;
    if (!this.hasLoadHardwareList) {
      localObject = ConfigManager.get().getConfig("codecReuse").getString("white_hardware_list", "");
    }
    for (;;)
    {
      try
      {
        localObject = new JSONArray((String)localObject);
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          if ((TextUtils.isEmpty(str)) || (!TextUtils.equals(str, Build.MODEL))) {
            continue;
          }
          this.isDeviceSupport = true;
        }
      }
      catch (JSONException localJSONException)
      {
        int i;
        LogUtil.e("CodecReuseHelper", "isDeviceSupport error,", localJSONException);
        continue;
      }
      this.hasLoadHardwareList = true;
      return this.isDeviceSupport;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.CodecReuseHelper
 * JD-Core Version:    0.7.0.1
 */