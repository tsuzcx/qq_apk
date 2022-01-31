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

class vqa
  extends vps<vpy>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367657);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367658);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370334);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370335);
  
  private vqa(vpy paramvpy, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561383, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130845783);
      return;
    case '1': 
      paramImageView.setImageResource(2130845784);
      return;
    case '2': 
      paramImageView.setImageResource(2130845785);
      return;
    case '3': 
      paramImageView.setImageResource(2130845786);
      return;
    case '4': 
      paramImageView.setImageResource(2130845787);
      return;
    case '5': 
      paramImageView.setImageResource(2130845788);
      return;
    case '6': 
      paramImageView.setImageResource(2130845789);
      return;
    case '7': 
      paramImageView.setImageResource(2130845790);
      return;
    case '8': 
      paramImageView.setImageResource(2130845791);
      return;
    }
    paramImageView.setImageResource(2130845792);
  }
  
  public void a(vpy paramvpy, int paramInt)
  {
    super.a(paramvpy, paramInt);
    paramvpy = new SimpleDateFormat("HH:mm");
    ((vpy)this.jdField_a_of_type_Vpr).c = paramvpy.format(new Date());
    ved.b("TimeFilterData", "TimeFilterData time:" + ((vpy)this.jdField_a_of_type_Vpr).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((vpy)this.jdField_a_of_type_Vpr).c.charAt(0));
    a(this.b, ((vpy)this.jdField_a_of_type_Vpr).c.charAt(1));
    a(this.c, ((vpy)this.jdField_a_of_type_Vpr).c.charAt(3));
    a(this.d, ((vpy)this.jdField_a_of_type_Vpr).c.charAt(4));
    int i = vzl.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Vpy.a != null) && (this.jdField_a_of_type_Vpy.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Vpy.a != null) && (this.jdField_a_of_type_Vpy.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Vpy.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Vpy.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > bbdh.k() / bbdh.l())
      {
        paramInt = (int)(bbdh.k() * this.jdField_a_of_type_Vpy.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Vpy.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + baxn.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = baxn.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
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
 * Qualified Name:     vqa
 * JD-Core Version:    0.7.0.1
 */