import android.view.View;

class nyk
  implements ausj.a
{
  nyk(nyj paramnyj, nyi paramnyi, int paramInt, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.val$actionSheet.dismiss();
      return;
    }
    nyj.a(this.this$0, this.b);
    paramInt = this.b.mUnreadNum;
    int i = this.b.mUnreadFlag;
    if (this.b.mUnreadFlag != 1) {
      paramInt = 0;
    }
    for (;;)
    {
      long l = nyn.a().a(this.b);
      anot.a(nyj.a(this.this$0), "dc01160", "Pb_account_lifeservice", "" + this.b.mUin, "0X80067F2", "0X80067F2", 0, 0, "" + (this.val$index + 1), "" + l, "" + i, "" + paramInt);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyk
 * JD-Core Version:    0.7.0.1
 */