import android.os.Bundle;

class xzi
  extends aklo
{
  xzi(xys paramxys) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBoolean == true))
    {
      paramBundle.getInt("gif_ui_show_bid");
      long l = paramBundle.getLong("gif_ui_show_seq");
      this.this$0.refresh(65536);
      xys.a(this.this$0, Long.valueOf(l).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xzi
 * JD-Core Version:    0.7.0.1
 */