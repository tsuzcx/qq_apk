import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public class xdu
  extends xdr<xdl>
  implements View.OnClickListener
{
  public xdu(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xdi == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new xdv(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((xdl)this.jdField_a_of_type_Xdi).a(), ((xdl)this.jdField_a_of_type_Xdi).a(), this);; paramView = (xdv)paramView)
    {
      paramView.a((xdl)this.jdField_a_of_type_Xdi, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131377387)).intValue();
    xdm localxdm = (xdm)((xdl)this.jdField_a_of_type_Xdi).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131377365);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localxdm.a = paramView.getDrawable();
      this.jdField_a_of_type_Xdk.a(localxdm);
      return;
    }
    wsv.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdu
 * JD-Core Version:    0.7.0.1
 */