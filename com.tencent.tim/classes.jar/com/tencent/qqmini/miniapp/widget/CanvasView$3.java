package com.tencent.qqmini.miniapp.widget;

class CanvasView$3
  implements Runnable
{
  CanvasView$3(CanvasView paramCanvasView) {}
  
  public void run()
  {
    if ((CanvasView.access$300(this.this$0)) && (CanvasView.access$400(this.this$0) <= CanvasView.access$500(this.this$0)))
    {
      CanvasView.access$600(this.this$0);
      this.this$0.postInvalidate();
      CanvasView.access$402(this.this$0, System.currentTimeMillis());
      CanvasView.access$502(this.this$0, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CanvasView.3
 * JD-Core Version:    0.7.0.1
 */