package com.tencent.qflutter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class TextPlatformViewFactory
  extends PlatformViewFactory
{
  public TextPlatformViewFactory(MessageCodec<Object> paramMessageCodec)
  {
    super(paramMessageCodec);
  }
  
  public PlatformView create(Context paramContext, int paramInt, Object paramObject)
  {
    return new TextPlatformView(paramContext);
  }
  
  static class TextPlatformView
    implements PlatformView
  {
    private TextView platformTv;
    
    public TextPlatformView(Context paramContext)
    {
      this.platformTv = new TextView(paramContext);
      this.platformTv.setText("PlatformView Demo");
    }
    
    public void dispose() {}
    
    public View getView()
    {
      return this.platformTv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qflutter.TextPlatformViewFactory
 * JD-Core Version:    0.7.0.1
 */