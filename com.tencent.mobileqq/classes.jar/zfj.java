import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class zfj
  extends zfg<zfa>
  implements View.OnClickListener
{
  public zfj(Context paramContext)
  {
    super(paramContext);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Zex == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    if (paramView == null) {}
    for (Object localObject = new zfk(this.jdField_a_of_type_AndroidContentContext, paramViewGroup.getWidth(), ((zfa)this.jdField_a_of_type_Zex).a(), ((zfa)this.jdField_a_of_type_Zex).a(), this);; localObject = (zfk)paramView)
    {
      ((zfk)localObject).a((zfa)this.jdField_a_of_type_Zex, paramInt, getCount());
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag(2131378427)).intValue();
    zfb localzfb = (zfb)((zfa)this.jdField_a_of_type_Zex).a.get(i);
    ImageView localImageView = (ImageView)paramView;
    Boolean localBoolean = (Boolean)localImageView.getTag(2131378405);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      localzfb.a = localImageView.getDrawable();
      this.jdField_a_of_type_Zez.a(localzfb);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yuk.b("LocationFaceAdapter", "ImageView drawable has not been downloaded.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfj
 * JD-Core Version:    0.7.0.1
 */