import android.view.View;

class uqq
  extends uqr
{
  uqq(uqp paramuqp) {}
  
  public void hide()
  {
    super.hide();
    if (uqp.a(this.a) != null)
    {
      uqp.a(this.a).setVisibility(4);
      uqp.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      uqp.a(this.a, 0);
    }
    while ((paramInt <= uqp.a(this.a)) || (uqp.a(this.a) == null)) {
      return;
    }
    if (uqp.a(this.a)) {
      uqp.a(this.a).setVisibility(0);
    }
    uqp.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqq
 * JD-Core Version:    0.7.0.1
 */