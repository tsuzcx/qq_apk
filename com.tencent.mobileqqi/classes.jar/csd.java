import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.widget.XListView;
import mqq.app.permission.PermissionCallback;

class csd
  implements PermissionCallback
{
  csd(csc paramcsc) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.jdField_a_of_type_Csb.a.a(), paramInt, paramArrayOfString, new csf(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Leba.b(this.a.jdField_a_of_type_Csb.a, false);
    this.a.jdField_a_of_type_Csb.a.a(this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_Int, null);
    this.a.jdField_a_of_type_Csb.a.a.postDelayed(new cse(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csd
 * JD-Core Version:    0.7.0.1
 */