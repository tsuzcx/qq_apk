import android.view.View;

class okh
  extends oki
{
  okh(okg paramokg) {}
  
  public void hide()
  {
    super.hide();
    if (okg.a(this.a) != null)
    {
      okg.a(this.a).setVisibility(4);
      okg.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      okg.a(this.a, 0);
    }
    while ((paramInt <= okg.a(this.a)) || (okg.a(this.a) == null)) {
      return;
    }
    if (okg.a(this.a)) {
      okg.a(this.a).setVisibility(0);
    }
    okg.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okh
 * JD-Core Version:    0.7.0.1
 */