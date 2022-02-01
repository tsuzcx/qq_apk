import android.view.View;

class vey
  extends vez
{
  vey(vex paramvex) {}
  
  public void hide()
  {
    super.hide();
    if (vex.a(this.a) != null)
    {
      vex.a(this.a).setVisibility(4);
      vex.a(this.a, 0);
    }
  }
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    super.updateUnreadCount(paramInt, paramBoolean);
    if (paramInt == 0) {
      vex.a(this.a, 0);
    }
    while ((paramInt <= vex.a(this.a)) || (vex.a(this.a) == null)) {
      return;
    }
    if (vex.a(this.a)) {
      vex.a(this.a).setVisibility(0);
    }
    vex.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vey
 * JD-Core Version:    0.7.0.1
 */