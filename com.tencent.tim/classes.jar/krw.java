import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class krw
  implements DialogInterface.OnClickListener
{
  krw(kte paramkte, ktm paramktm) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      if (this.jdField_b_of_type_Kte != null)
      {
        paramDialogInterface = this.jdField_b_of_type_Kte.a();
        if (paramDialogInterface != null)
        {
          paramDialogInterface.q(this.jdField_b_of_type_Ktm);
          this.jdField_b_of_type_Kte.notifyDataSetChanged();
        }
      }
      awit.H("family_comment_card_hide_timestamp", Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     krw
 * JD-Core Version:    0.7.0.1
 */