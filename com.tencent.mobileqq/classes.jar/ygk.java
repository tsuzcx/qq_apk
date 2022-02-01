import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ygk
  extends ygh<ygb>
  implements View.OnClickListener
{
  public ygk(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yfy == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new ygl(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((ygb)this.jdField_a_of_type_Yfy).a(), ((ygb)this.jdField_a_of_type_Yfy).a(), this);; localObject = (ygl)paramView)
    {
      ((ygl)localObject).a((ygb)this.jdField_a_of_type_Yfy, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131378194)).intValue();
    ygc localygc = (ygc)((ygb)this.jdField_a_of_type_Yfy).a.get(i);
    ImageView localImageView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378172);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localygc.a = localImageView.getDrawable();
      this.jdField_a_of_type_Yga.a(localygc);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      xvv.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygk
 * JD-Core Version:    0.7.0.1
 */