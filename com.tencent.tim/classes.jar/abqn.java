import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;

class abqn
  implements DialogInterface.OnClickListener
{
  abqn(abql paramabql) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (abql.a(this.this$0) != null)
    {
      abql.b(this.this$0).setVisibility(8);
      abql.c(this.this$0).setVisibility(8);
      abql.b(this.this$0, false);
      abql.a(this.this$0).resume();
    }
    this.this$0.v(6, 3, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqn
 * JD-Core Version:    0.7.0.1
 */