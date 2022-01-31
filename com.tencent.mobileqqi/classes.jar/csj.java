import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.permissionsDialog.PermissionsDialog;
import com.tencent.widget.XListView;
import mqq.app.permission.PermissionCallback;

class csj
  implements PermissionCallback
{
  csj(csi paramcsi) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    new PermissionsDialog().a(this.a.jdField_a_of_type_Csc.a.a(), paramInt, paramArrayOfString, new csl(this));
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    Leba.b(this.a.jdField_a_of_type_Csc.a, false);
    this.a.jdField_a_of_type_Csc.a.a(this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_Int, null);
    this.a.jdField_a_of_type_Csc.a.a.postDelayed(new csk(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csj
 * JD-Core Version:    0.7.0.1
 */