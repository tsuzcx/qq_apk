import android.view.View;

class ujv
  extends ujw
{
  ujv(uju paramuju) {}
  
  public void hide()
  {
    super.hide();
    if (uju.a(this.a) != null)
    {
      uju.a(this.a).setVisibility(4);
      uju.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      uju.a(this.a, 0);
    }
    while ((paramInt <= uju.a(this.a)) || (uju.a(this.a) == null)) {
      return;
    }
    if (uju.a(this.a)) {
      uju.a(this.a).setVisibility(0);
    }
    uju.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujv
 * JD-Core Version:    0.7.0.1
 */