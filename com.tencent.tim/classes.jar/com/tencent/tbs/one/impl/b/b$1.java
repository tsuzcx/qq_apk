package com.tencent.tbs.one.impl.b;

import android.content.Context;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;
import java.util.Map;

final class b$1
  extends TBSOneCallback<TBSOneDebugPlugin>
{
  b$1(b paramb, Context paramContext, String paramString, Map paramMap, TBSOneCallback paramTBSOneCallback) {}
  
  public final void onError(int paramInt, String paramString)
  {
    if (this.d != null) {
      this.d.onError(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.b.1
 * JD-Core Version:    0.7.0.1
 */