import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zbo
  extends zbl<zbf>
  implements View.OnClickListener
{
  public zbo(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Zbc == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new zbp(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((zbf)this.jdField_a_of_type_Zbc).a(), ((zbf)this.jdField_a_of_type_Zbc).a(), this);; localObject = (zbp)paramView)
    {
      ((zbp)localObject).a((zbf)this.jdField_a_of_type_Zbc, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131378270)).intValue();
    zbg localzbg = (zbg)((zbf)this.jdField_a_of_type_Zbc).a.get(i);
    ImageView localImageView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378248);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localzbg.a = localImageView.getDrawable();
      this.jdField_a_of_type_Zbe.a(localzbg);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yqp.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbo
 * JD-Core Version:    0.7.0.1
 */