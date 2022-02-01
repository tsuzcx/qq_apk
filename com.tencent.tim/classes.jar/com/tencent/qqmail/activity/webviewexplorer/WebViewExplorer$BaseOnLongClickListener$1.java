package com.tencent.qqmail.activity.webviewexplorer;

import android.webkit.WebView.HitTestResult;
import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import java.util.HashMap;

class WebViewExplorer$BaseOnLongClickListener$1
  implements InlineImageSaver.ISaveToAlbumCallBack
{
  WebViewExplorer$BaseOnLongClickListener$1(WebViewExplorer.BaseOnLongClickListener paramBaseOnLongClickListener) {}
  
  public void handleSaveImageByType(HashMap<String, String> paramHashMap, WebView.HitTestResult paramHitTestResult, int paramInt1, int paramInt2) {}
  
  public void onBeforeSaved() {}
  
  public void onCompleteSaved()
  {
    String str = QMApplicationContext.sharedInstance().getString(2131693722) + InlineImageSaver.SAVE_IMG_PATH;
    Toast.makeText(this.this$1.this$0, str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.BaseOnLongClickListener.1
 * JD-Core Version:    0.7.0.1
 */