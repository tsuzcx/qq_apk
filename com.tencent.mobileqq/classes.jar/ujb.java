import android.view.View;

class ujb
  extends ujc
{
  ujb(uja paramuja) {}
  
  public void hide()
  {
    super.hide();
    if (uja.a(this.a) != null)
    {
      uja.a(this.a).setVisibility(4);
      uja.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      uja.a(this.a, 0);
    }
    while ((paramInt <= uja.a(this.a)) || (uja.a(this.a) == null)) {
      return;
    }
    if (uja.a(this.a)) {
      uja.a(this.a).setVisibility(0);
    }
    uja.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujb
 * JD-Core Version:    0.7.0.1
 */