import com.tencent.qg.sdk.QGRenderer.QGEventListener;

class ayct
  implements QGRenderer.QGEventListener
{
  ayct(aycm paramaycm) {}
  
  public void onCanvasCreated()
  {
    ram.d("StoryEffectTextMode", "Event: Canvas was created");
    aycm.e(this.this$0, true);
    aycm.c(this.this$0, true);
    aycm.d(this.this$0);
  }
  
  public void onDrawFrame()
  {
    if (aycm.a(this.this$0) != null) {
      aycm.a(this.this$0).enk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayct
 * JD-Core Version:    0.7.0.1
 */