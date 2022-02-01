import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class ayox
  implements DialogInterface.OnShowListener
{
  ayox(ayov paramayov, boolean paramBoolean) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (ayov.a(this.b) != null) {
      ayov.a(this.b).onShow(paramDialogInterface);
    }
    if (this.dAh)
    {
      ayov.a(this.b).bmy();
      return;
    }
    ayov.a(this.b).setKeyBoardState(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayox
 * JD-Core Version:    0.7.0.1
 */