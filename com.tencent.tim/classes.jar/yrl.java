import com.tencent.mobileqq.widget.QQToast;

class yrl
  extends accn
{
  yrl(yri paramyri) {}
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      QQToast.a(yri.a(this.this$0), 2131701422, 3000).show();
      if (yri.a(this.this$0) != 23) {
        this.this$0.AH(true);
      }
      return;
    }
    QQToast.a(yri.a(this.this$0), 2131701421, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yrl
 * JD-Core Version:    0.7.0.1
 */