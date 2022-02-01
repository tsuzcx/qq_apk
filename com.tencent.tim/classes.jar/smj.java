import android.text.TextUtils.EllipsizeCallback;
import android.widget.TextView;
import com.tencent.biz.troop.file.MoveFileActivity;

public class smj
  implements TextUtils.EllipsizeCallback
{
  public smj(MoveFileActivity paramMoveFileActivity, TextView paramTextView) {}
  
  public void ellipsized(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      this.Ay.setText(MoveFileActivity.a(this.this$0));
      return;
    }
    String str1 = MoveFileActivity.a(this.this$0).substring(0, paramInt1);
    String str2 = MoveFileActivity.a(this.this$0).substring(paramInt2, MoveFileActivity.a(this.this$0).length());
    this.Ay.setText(str1 + "..." + str2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     smj
 * JD-Core Version:    0.7.0.1
 */