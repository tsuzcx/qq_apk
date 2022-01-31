import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public class vcj
  extends vcg<vca>
  implements View.OnClickListener
{
  public vcj(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Vbx == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new vck(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((vca)this.jdField_a_of_type_Vbx).a(), ((vca)this.jdField_a_of_type_Vbx).a(), this);; paramView = (vck)paramView)
    {
      paramView.a((vca)this.jdField_a_of_type_Vbx, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131311062)).intValue();
    vcb localvcb = (vcb)((vca)this.jdField_a_of_type_Vbx).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131311040);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localvcb.a = paramView.getDrawable();
      this.jdField_a_of_type_Vbz.a(localvcb);
      return;
    }
    urk.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcj
 * JD-Core Version:    0.7.0.1
 */