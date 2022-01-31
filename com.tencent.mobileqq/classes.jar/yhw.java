import android.widget.PopupWindow;
import com.tencent.mobileqq.apollo.ApolloRender;

public final class yhw
  implements Runnable
{
  public yhw(ApolloRender paramApolloRender) {}
  
  public void run()
  {
    if (this.a.mShowEditWindow)
    {
      this.a.mEditWindow.dismiss();
      this.a.mShowEditWindow = false;
      ApolloRender.sIsKeyBoardDissmiss = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhw
 * JD-Core Version:    0.7.0.1
 */