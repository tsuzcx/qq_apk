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

class vqd
  extends vpv<vqb>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367657);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367658);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370335);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370336);
  
  private vqd(vqb paramvqb, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561384, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130845777);
      return;
    case '1': 
      paramImageView.setImageResource(2130845778);
      return;
    case '2': 
      paramImageView.setImageResource(2130845779);
      return;
    case '3': 
      paramImageView.setImageResource(2130845780);
      return;
    case '4': 
      paramImageView.setImageResource(2130845781);
      return;
    case '5': 
      paramImageView.setImageResource(2130845782);
      return;
    case '6': 
      paramImageView.setImageResource(2130845783);
      return;
    case '7': 
      paramImageView.setImageResource(2130845784);
      return;
    case '8': 
      paramImageView.setImageResource(2130845785);
      return;
    }
    paramImageView.setImageResource(2130845786);
  }
  
  public void a(vqb paramvqb, int paramInt)
  {
    super.a(paramvqb, paramInt);
    paramvqb = new SimpleDateFormat("HH:mm");
    ((vqb)this.jdField_a_of_type_Vpu).c = paramvqb.format(new Date());
    veg.b("TimeFilterData", "TimeFilterData time:" + ((vqb)this.jdField_a_of_type_Vpu).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((vqb)this.jdField_a_of_type_Vpu).c.charAt(0));
    a(this.b, ((vqb)this.jdField_a_of_type_Vpu).c.charAt(1));
    a(this.c, ((vqb)this.jdField_a_of_type_Vpu).c.charAt(3));
    a(this.d, ((vqb)this.jdField_a_of_type_Vpu).c.charAt(4));
    int i = vzo.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Vqb.a != null) && (this.jdField_a_of_type_Vqb.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Vqb.a != null) && (this.jdField_a_of_type_Vqb.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Vqb.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Vqb.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > bbct.k() / bbct.l())
      {
        paramInt = (int)(bbct.k() * this.jdField_a_of_type_Vqb.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Vqb.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + bawz.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = bawz.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
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
 * Qualified Name:     vqd
 * JD-Core Version:    0.7.0.1
 */