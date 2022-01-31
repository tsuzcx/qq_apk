import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import java.text.SimpleDateFormat;
import java.util.Date;

class vdh
  extends vcz<vdf>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302039);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302040);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304679);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131304680);
  
  private vdh(vdf paramvdf, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131495793, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130845594);
      return;
    case '1': 
      paramImageView.setImageResource(2130845595);
      return;
    case '2': 
      paramImageView.setImageResource(2130845596);
      return;
    case '3': 
      paramImageView.setImageResource(2130845597);
      return;
    case '4': 
      paramImageView.setImageResource(2130845598);
      return;
    case '5': 
      paramImageView.setImageResource(2130845599);
      return;
    case '6': 
      paramImageView.setImageResource(2130845600);
      return;
    case '7': 
      paramImageView.setImageResource(2130845601);
      return;
    case '8': 
      paramImageView.setImageResource(2130845602);
      return;
    }
    paramImageView.setImageResource(2130845603);
  }
  
  public void a(vdf paramvdf, int paramInt)
  {
    super.a(paramvdf, paramInt);
    paramvdf = new SimpleDateFormat("HH:mm");
    ((vdf)this.jdField_a_of_type_Vcy).c = paramvdf.format(new Date());
    urk.b("TimeFilterData", "TimeFilterData time:" + ((vdf)this.jdField_a_of_type_Vcy).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((vdf)this.jdField_a_of_type_Vcy).c.charAt(0));
    a(this.b, ((vdf)this.jdField_a_of_type_Vcy).c.charAt(1));
    a(this.c, ((vdf)this.jdField_a_of_type_Vcy).c.charAt(3));
    a(this.d, ((vdf)this.jdField_a_of_type_Vcy).c.charAt(4));
    int i = vms.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Vdf.a != null) && (this.jdField_a_of_type_Vdf.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Vdf.a != null) && (this.jdField_a_of_type_Vdf.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Vdf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Vdf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > babp.k() / babp.l())
      {
        paramInt = (int)(babp.k() * this.jdField_a_of_type_Vdf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Vdf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + azvv.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = azvv.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
        this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt - i, 0, 0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdh
 * JD-Core Version:    0.7.0.1
 */