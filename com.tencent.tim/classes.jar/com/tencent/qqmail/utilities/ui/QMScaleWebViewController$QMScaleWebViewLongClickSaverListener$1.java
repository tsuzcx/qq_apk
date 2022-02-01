package com.tencent.qqmail.utilities.ui;

import android.app.Activity;
import android.webkit.WebView.HitTestResult;
import android.widget.Toast;
import com.tencent.qqmail.activity.webviewexplorer.InlineImageSaver;
import com.tencent.qqmail.activity.webviewexplorer.InlineImageSaver.ISaveToAlbumCallBack;
import java.util.HashMap;

class QMScaleWebViewController$QMScaleWebViewLongClickSaverListener$1
  implements InlineImageSaver.ISaveToAlbumCallBack
{
  QMScaleWebViewController$QMScaleWebViewLongClickSaverListener$1(QMScaleWebViewController.QMScaleWebViewLongClickSaverListener paramQMScaleWebViewLongClickSaverListener) {}
  
  public void handleSaveImageByType(HashMap<String, String> paramHashMap, WebView.HitTestResult paramHitTestResult, int paramInt1, int paramInt2) {}
  
  public void onBeforeSaved() {}
  
  public void onCompleteSaved()
  {
    Toast.makeText(QMScaleWebViewController.access$700(this.this$1.this$0).getApplicationContext(), QMScaleWebViewController.access$700(this.this$1.this$0).getString(2131693722) + InlineImageSaver.SAVE_IMG_PATH, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewLongClickSaverListener.1
 * JD-Core Version:    0.7.0.1
 */