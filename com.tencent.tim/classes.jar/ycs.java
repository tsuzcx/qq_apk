import android.view.View;

class ycs
  implements ausj.a
{
  ycs(ycd paramycd) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.this$0.ach) {
      return;
    }
    this.this$0.ach = true;
    if ((this.this$0.iF != null) && (this.this$0.iF.length > 0))
    {
      this.this$0.showLoading(2131697483);
      paramInt = this.this$0.iF[0];
      if (paramInt == 0) {
        this.this$0.aC(true, 0);
      }
    }
    for (;;)
    {
      this.this$0.e.dismiss();
      return;
      this.this$0.aC(false, paramInt);
      continue;
      this.this$0.showLoading(2131697483);
      this.this$0.aC(true, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ycs
 * JD-Core Version:    0.7.0.1
 */