import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public class vpc
  extends voz<vot>
  implements View.OnClickListener
{
  public vpc(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Voq == null) {
      return paramView;
    }
    if (paramView == null) {}
    for (paramView = new vpd(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((vot)this.jdField_a_of_type_Voq).a(), ((vot)this.jdField_a_of_type_Voq).a(), this);; paramView = (vpd)paramView)
    {
      paramView.a((vot)this.jdField_a_of_type_Voq, paramInt, getCount());
      return paramView;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131376873)).intValue();
    vou localvou = (vou)((vot)this.jdField_a_of_type_Voq).a.get(i);
    paramView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)paramView.getTag(2131376851);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localvou.a = paramView.getDrawable();
      this.jdField_a_of_type_Vos.a(localvou);
      return;
    }
    ved.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vpc
 * JD-Core Version:    0.7.0.1
 */