import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoInnerStatusListener;

class aihs
  implements IVideoInnerStatusListener
{
  aihs(aihr paramaihr) {}
  
  public void notifyVideoClose(int paramInt) {}
  
  public void notifyVideoSeek(int paramInt) {}
  
  public void notifyVideoStart()
  {
    if (aihr.a(this.b) != null)
    {
      ajat.a().requestMediaFocus(1, aihr.a(this.b));
      return;
    }
    this.b.KZ(false);
  }
  
  public void notifyVideoStop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aihs
 * JD-Core Version:    0.7.0.1
 */