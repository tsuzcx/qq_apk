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

class xjb
  extends xit<xiz>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367796);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367797);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370657);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370658);
  
  private xjb(xiz paramxiz, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561591, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846235);
      return;
    case '1': 
      paramImageView.setImageResource(2130846236);
      return;
    case '2': 
      paramImageView.setImageResource(2130846237);
      return;
    case '3': 
      paramImageView.setImageResource(2130846238);
      return;
    case '4': 
      paramImageView.setImageResource(2130846239);
      return;
    case '5': 
      paramImageView.setImageResource(2130846240);
      return;
    case '6': 
      paramImageView.setImageResource(2130846241);
      return;
    case '7': 
      paramImageView.setImageResource(2130846242);
      return;
    case '8': 
      paramImageView.setImageResource(2130846243);
      return;
    }
    paramImageView.setImageResource(2130846244);
  }
  
  public void a(xiz paramxiz, int paramInt)
  {
    super.a(paramxiz, paramInt);
    paramxiz = new SimpleDateFormat("HH:mm");
    ((xiz)this.jdField_a_of_type_Xis).c = paramxiz.format(new Date());
    wxe.b("TimeFilterData", "TimeFilterData time:" + ((xiz)this.jdField_a_of_type_Xis).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((xiz)this.jdField_a_of_type_Xis).c.charAt(0));
    a(this.b, ((xiz)this.jdField_a_of_type_Xis).c.charAt(1));
    a(this.c, ((xiz)this.jdField_a_of_type_Xis).c.charAt(3));
    a(this.d, ((xiz)this.jdField_a_of_type_Xis).c.charAt(4));
    int i = xsm.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Xiz.a != null) && (this.jdField_a_of_type_Xiz.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Xiz.a != null) && (this.jdField_a_of_type_Xiz.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Xiz.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Xiz.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > bdgk.k() / bdgk.l())
      {
        paramInt = (int)(bdgk.k() * this.jdField_a_of_type_Xiz.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Xiz.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + bdaq.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = bdaq.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
        this.jdField_a_of_type_AndroidViewView.setPadding(0, paramInt - i, 0, 0);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjb
 * JD-Core Version:    0.7.0.1
 */