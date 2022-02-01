import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class ayim
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!ayil.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  ayim(ayil paramayil, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    aykb.b localb = this.b.a().a;
    assert (localb != null);
    ayil.a(paramDialogInterface, localb);
    paramDialogInterface.putInt("element_index", this.bwX);
    this.b.b.r(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayim
 * JD-Core Version:    0.7.0.1
 */