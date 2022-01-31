import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDialog;

class xew
  implements Runnable
{
  xew(xev paramxev, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((GoldMsgDialog.a(this.jdField_a_of_type_Xev.a.a) != null) && (this.jdField_a_of_type_Xev.a.a.isShowing()) && (GoldMsgDialog.a(this.jdField_a_of_type_Xev.a.a) != null))
    {
      int i = GoldMsgDialog.b(this.jdField_a_of_type_Xev.a.a).getWidth();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)GoldMsgDialog.a(this.jdField_a_of_type_Xev.a.a).getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = (i * this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth());
        GoldMsgDialog.a(this.jdField_a_of_type_Xev.a.a).setLayoutParams(localLayoutParams);
      }
      GoldMsgDialog.a(this.jdField_a_of_type_Xev.a.a).setVisibility(0);
      GoldMsgDialog.a(this.jdField_a_of_type_Xev.a.a).setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xew
 * JD-Core Version:    0.7.0.1
 */