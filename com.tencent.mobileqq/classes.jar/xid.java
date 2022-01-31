import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public class xid
  extends xia<xhu>
  implements View.OnClickListener
{
  public xid(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xhr == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new xie(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((xhu)this.jdField_a_of_type_Xhr).a(), ((xhu)this.jdField_a_of_type_Xhr).a(), this);; paramView = (xie)paramView)
    {
      paramView.a((xhu)this.jdField_a_of_type_Xhr, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131377441)).intValue();
    xhv localxhv = (xhv)((xhu)this.jdField_a_of_type_Xhr).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131377419);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localxhv.a = paramView.getDrawable();
      this.jdField_a_of_type_Xht.a(localxhv);
      return;
    }
    wxe.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xid
 * JD-Core Version:    0.7.0.1
 */