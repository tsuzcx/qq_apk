import android.content.SharedPreferences.Editor;
import com.tencent.biz.subscribe.comment.EmoView;

class ohh
  implements sea.a
{
  ohh(ohe paramohe) {}
  
  public void onSoftKeyboardClosed()
  {
    if (ohe.a(this.this$0))
    {
      ohe.b(this.this$0, false);
      ohe.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      ohe.a(this.this$0, false);
      return;
      this.this$0.dismiss();
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if (ohe.a(this.this$0) != paramInt)
    {
      ohe.a(this.this$0, paramInt);
      ohe.a(this.this$0);
      ohe.a(this.this$0).putInt("GroupSoftKeyboardHeight", paramInt);
      ohe.a(this.this$0).commit();
    }
    ohe.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ohh
 * JD-Core Version:    0.7.0.1
 */