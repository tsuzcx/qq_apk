import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopMemberListActivity;

class boz
  implements Runnable
{
  boz(boy paramboy, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boy.a.b != null) && (this.jdField_a_of_type_Boy.a.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_Boy.a.jdField_c_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_Boy.a.jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
      ((TextView)this.jdField_a_of_type_Boy.a.b.findViewById(2131298946)).setCompoundDrawables(null, null, null, null);
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Boy.a.h))) {}
    while ((this.jdField_a_of_type_Boy.a.b == null) || (this.jdField_a_of_type_Boy.a.b.getVisibility() == 8)) {
      return;
    }
    this.jdField_a_of_type_Boy.a.b.setEnabled(true);
    ((TextView)this.jdField_a_of_type_Boy.a.b.findViewById(2131296879)).setTextColor(this.jdField_a_of_type_Boy.a.getResources().getColor(2131427471));
    this.jdField_a_of_type_Boy.a.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
    this.jdField_a_of_type_Boy.a.l = this.jdField_b_of_type_JavaLangString;
    ((TextView)this.jdField_a_of_type_Boy.a.b.findViewById(2131298946)).setText(this.c);
    String str = "@全体成员";
    if (this.c != null) {
      str = "@全体成员" + "," + this.c;
    }
    this.jdField_a_of_type_Boy.a.b.setContentDescription(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     boz
 * JD-Core Version:    0.7.0.1
 */