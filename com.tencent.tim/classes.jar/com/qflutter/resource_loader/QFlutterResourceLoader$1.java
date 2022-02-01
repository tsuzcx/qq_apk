package com.qflutter.resource_loader;

import android.os.Handler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

class QFlutterResourceLoader$1
  implements Runnable
{
  QFlutterResourceLoader$1(QFlutterResourceLoader paramQFlutterResourceLoader, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Map localMap = QFlutterResourceLoader.access$000(this.this$0);
    if ((QFlutterResourceLoader.access$100(this.this$0).getUiThreadHandler() != null) && (localMap != null)) {
      QFlutterResourceLoader.access$100(this.this$0).getUiThreadHandler().post(new QFlutterResourceLoader.1.1(this, localMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qflutter.resource_loader.QFlutterResourceLoader.1
 * JD-Core Version:    0.7.0.1
 */