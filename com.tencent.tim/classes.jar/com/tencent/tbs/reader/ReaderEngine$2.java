package com.tencent.tbs.reader;

import android.util.Log;
import com.tencent.tbs.one.TBSOneCallback;
import java.io.File;

class ReaderEngine$2
  extends TBSOneCallback<File>
{
  ReaderEngine$2(ReaderEngine paramReaderEngine, TBSOneCallback paramTBSOneCallback) {}
  
  public void onCompleted(File paramFile)
  {
    Log.d("ReaderEngine", "TBSOneCallback:onCompleted");
    this.this$0.report(1003, "tbs:onCompleted", null);
    if (this.val$callback != null) {
      this.val$callback.onCompleted(paramFile);
    }
  }
  
  public void onError(int paramInt, String paramString)
  {
    Log.e("ReaderEngine", "TBSOneCallback:onError:" + paramInt);
    String str = String.format("tbs:onError,code=%d, des=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    this.this$0.report(1004, str, null);
    if (this.val$callback != null) {
      this.val$callback.onError(paramInt, paramString);
    }
  }
  
  public void onProgressChanged(int paramInt1, int paramInt2)
  {
    if (this.val$callback != null) {
      this.val$callback.onProgressChanged(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.reader.ReaderEngine.2
 * JD-Core Version:    0.7.0.1
 */