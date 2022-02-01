package me.ele.uetool.view;

import alkw;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import me.ele.uetool.base.Application;
import me.ele.uetool.util.Util;

class ColorPickerFloatView$1
  implements GestureDetector.OnGestureListener
{
  boolean isInit = false;
  
  ColorPickerFloatView$1(ColorPickerFloatView paramColorPickerFloatView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    ColorPickerFloatView.access$002(this.this$0, (int)paramMotionEvent.getRawX());
    ColorPickerFloatView.access$102(this.this$0, (int)paramMotionEvent.getRawY());
    this.isInit = false;
    ColorPickerFloatView.access$202(this.this$0, ColorPickerFloatView.access$100(this.this$0));
    ColorPickerFloatView.access$302(this.this$0, ColorPickerFloatView.access$000(this.this$0));
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.isInit)
    {
      ColorPickerFloatView.access$500(this.this$0, 100);
      this.isInit = true;
    }
    paramMotionEvent1 = ColorPickerFloatView.access$600(this.this$0);
    paramMotionEvent1.y = ((int)(paramMotionEvent1.y + (paramMotionEvent2.getRawY() - ColorPickerFloatView.access$200(this.this$0)) / 1.5D));
    paramMotionEvent1 = ColorPickerFloatView.access$600(this.this$0);
    paramMotionEvent1.x = ((int)(paramMotionEvent1.x + (paramMotionEvent2.getRawX() - ColorPickerFloatView.access$300(this.this$0)) / 1.5D));
    ColorPickerFloatView.access$700(this.this$0, ColorPickerFloatView.access$600(this.this$0));
    this.this$0.windowManager.updateViewLayout(this.this$0, ColorPickerFloatView.access$600(this.this$0));
    ColorPickerFloatView.access$800(this.this$0);
    ColorPickerFloatView.access$202(this.this$0, (int)paramMotionEvent2.getRawY());
    ColorPickerFloatView.access$302(this.this$0, (int)paramMotionEvent2.getRawX());
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = Util.intToHexColor(ColorPickerFloatView.access$400(this.this$0));
    ClipboardManager localClipboardManager = (ClipboardManager)Application.getApplicationContext().getSystemService("clipboard");
    ClipData localClipData = ClipData.newPlainText("color", paramMotionEvent);
    alkw.a(localClipboardManager, localClipData);
    localClipboardManager.setPrimaryClip(localClipData);
    Toast.makeText(Application.getApplicationContext(), "copy color: " + paramMotionEvent, 0).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.view.ColorPickerFloatView.1
 * JD-Core Version:    0.7.0.1
 */