import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class yvd
  extends yva<yuu>
  implements View.OnClickListener
{
  public yvd(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yur == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new yve(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((yuu)this.jdField_a_of_type_Yur).a(), ((yuu)this.jdField_a_of_type_Yur).a(), this);; localObject = (yve)paramView)
    {
      ((yve)localObject).a((yuu)this.jdField_a_of_type_Yur, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131378482)).intValue();
    yuv localyuv = (yuv)((yuu)this.jdField_a_of_type_Yur).a.get(i);
    ImageView localImageView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378460);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localyuv.a = localImageView.getDrawable();
      this.jdField_a_of_type_Yut.a(localyuv);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ykq.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yvd
 * JD-Core Version:    0.7.0.1
 */