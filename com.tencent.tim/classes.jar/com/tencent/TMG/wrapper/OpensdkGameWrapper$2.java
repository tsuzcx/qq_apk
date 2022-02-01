package com.tencent.TMG.wrapper;

import android.util.Log;
import com.tencent.TMG.ptt.PttListener.PlayFileListener;

class OpensdkGameWrapper$2
  implements PttListener.PlayFileListener
{
  OpensdkGameWrapper$2(OpensdkGameWrapper paramOpensdkGameWrapper) {}
  
  public void onCompleted(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    Log.i("opensdkGameWrapper", String.format("playRecordedFile|onCompleted| code=%d, filePath=%s", new Object[] { Integer.valueOf(paramInt), str }));
    this.this$0.nativePlayRecordedFileCallback(paramInt, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.wrapper.OpensdkGameWrapper.2
 * JD-Core Version:    0.7.0.1
 */