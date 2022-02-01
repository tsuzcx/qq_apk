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

class yhh
  extends ygz<yhf>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368211);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368212);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371287);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371288);
  
  private yhh(yhf paramyhf, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561744, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846599);
      return;
    case '1': 
      paramImageView.setImageResource(2130846600);
      return;
    case '2': 
      paramImageView.setImageResource(2130846601);
      return;
    case '3': 
      paramImageView.setImageResource(2130846602);
      return;
    case '4': 
      paramImageView.setImageResource(2130846603);
      return;
    case '5': 
      paramImageView.setImageResource(2130846604);
      return;
    case '6': 
      paramImageView.setImageResource(2130846605);
      return;
    case '7': 
      paramImageView.setImageResource(2130846606);
      return;
    case '8': 
      paramImageView.setImageResource(2130846607);
      return;
    }
    paramImageView.setImageResource(2130846608);
  }
  
  public void a(yhf paramyhf, int paramInt)
  {
    super.a(paramyhf, paramInt);
    paramyhf = new SimpleDateFormat("HH:mm");
    ((yhf)this.jdField_a_of_type_Ygy).c = paramyhf.format(new Date());
    xvv.b("TimeFilterData", "TimeFilterData time:" + ((yhf)this.jdField_a_of_type_Ygy).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((yhf)this.jdField_a_of_type_Ygy).c.charAt(0));
    a(this.b, ((yhf)this.jdField_a_of_type_Ygy).c.charAt(1));
    a(this.c, ((yhf)this.jdField_a_of_type_Ygy).c.charAt(3));
    a(this.d, ((yhf)this.jdField_a_of_type_Ygy).c.charAt(4));
    int i = UIUtils.getWindowScreenHeight(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Yhf.a != null) && (this.jdField_a_of_type_Yhf.a.mBusinessId == 10)) || ((this.jdField_a_of_type_Yhf.a != null) && (this.jdField_a_of_type_Yhf.a.mBusinessId == 12)))
    {
      if (this.jdField_a_of_type_Yhf.a.mEditSource.getWidth() / this.jdField_a_of_type_Yhf.a.mEditSource.getHeight() > DeviceInfoUtil.getWidth() / DeviceInfoUtil.getHeight())
      {
        paramInt = (int)(DeviceInfoUtil.getWidth() * this.jdField_a_of_type_Yhf.a.mEditSource.getHeight() / this.jdField_a_of_type_Yhf.a.mEditSource.getWidth());
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
 * Qualified Name:     yhh
 * JD-Core Version:    0.7.0.1
 */