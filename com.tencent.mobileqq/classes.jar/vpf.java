import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public class vpf
  extends vpc<vow>
  implements View.OnClickListener
{
  public vpf(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Vot == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new vpg(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((vow)this.jdField_a_of_type_Vot).a(), ((vow)this.jdField_a_of_type_Vot).a(), this);; paramView = (vpg)paramView)
    {
      paramView.a((vow)this.jdField_a_of_type_Vot, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131376871)).intValue();
    vox localvox = (vox)((vow)this.jdField_a_of_type_Vot).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131376849);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localvox.a = paramView.getDrawable();
      this.jdField_a_of_type_Vov.a(localvox);
      return;
    }
    veg.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpf
 * JD-Core Version:    0.7.0.1
 */