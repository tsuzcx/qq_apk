import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

class ywa
  extends yvs<yvy>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368355);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368356);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371473);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371474);
  
  private ywa(yvy paramyvy, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561812, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846695);
      return;
    case '1': 
      paramImageView.setImageResource(2130846696);
      return;
    case '2': 
      paramImageView.setImageResource(2130846697);
      return;
    case '3': 
      paramImageView.setImageResource(2130846698);
      return;
    case '4': 
      paramImageView.setImageResource(2130846699);
      return;
    case '5': 
      paramImageView.setImageResource(2130846700);
      return;
    case '6': 
      paramImageView.setImageResource(2130846701);
      return;
    case '7': 
      paramImageView.setImageResource(2130846702);
      return;
    case '8': 
      paramImageView.setImageResource(2130846703);
      return;
    }
    paramImageView.setImageResource(2130846704);
  }
  
  public void a(yvy paramyvy, int paramInt)
  {
    super.a(paramyvy, paramInt);
    paramyvy = new SimpleDateFormat("HH:mm");
    ((yvy)this.jdField_a_of_type_Yvr).c = paramyvy.format(new Date());
    ykq.b("TimeFilterData", "TimeFilterData time:" + ((yvy)this.jdField_a_of_type_Yvr).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((yvy)this.jdField_a_of_type_Yvr).c.charAt(0));
    a(this.b, ((yvy)this.jdField_a_of_type_Yvr).c.charAt(1));
    a(this.c, ((yvy)this.jdField_a_of_type_Yvr).c.charAt(3));
    a(this.d, ((yvy)this.jdField_a_of_type_Yvr).c.charAt(4));
    int i = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Yvy.a != null) && (this.jdField_a_of_type_Yvy.a.mBusinessId == 10)) || ((this.jdField_a_of_type_Yvy.a != null) && (this.jdField_a_of_type_Yvy.a.mBusinessId == 12)))
    {
      if (this.jdField_a_of_type_Yvy.a.mEditSource.getWidth() / this.jdField_a_of_type_Yvy.a.mEditSource.getHeight() > DeviceInfoUtil.getWidth() / DeviceInfoUtil.getHeight())
      {
        paramInt = (int)(DeviceInfoUtil.getWidth() * this.jdField_a_of_type_Yvy.a.mEditSource.getHeight() / this.jdField_a_of_type_Yvy.a.mEditSource.getWidth());
        if (paramInt > i / 3 * 2 + DisplayUtil.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
        this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt - i, 0, 0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ywa
 * JD-Core Version:    0.7.0.1
 */