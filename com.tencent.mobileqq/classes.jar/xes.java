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

class xes
  extends xek<xeq>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367786);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367787);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370638);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370639);
  
  private xes(xeq paramxeq, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561573, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846162);
      return;
    case '1': 
      paramImageView.setImageResource(2130846163);
      return;
    case '2': 
      paramImageView.setImageResource(2130846164);
      return;
    case '3': 
      paramImageView.setImageResource(2130846165);
      return;
    case '4': 
      paramImageView.setImageResource(2130846166);
      return;
    case '5': 
      paramImageView.setImageResource(2130846167);
      return;
    case '6': 
      paramImageView.setImageResource(2130846168);
      return;
    case '7': 
      paramImageView.setImageResource(2130846169);
      return;
    case '8': 
      paramImageView.setImageResource(2130846170);
      return;
    }
    paramImageView.setImageResource(2130846171);
  }
  
  public void a(xeq paramxeq, int paramInt)
  {
    super.a(paramxeq, paramInt);
    paramxeq = new SimpleDateFormat("HH:mm");
    ((xeq)this.jdField_a_of_type_Xej).c = paramxeq.format(new Date());
    wsv.b("TimeFilterData", "TimeFilterData time:" + ((xeq)this.jdField_a_of_type_Xej).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((xeq)this.jdField_a_of_type_Xej).c.charAt(0));
    a(this.b, ((xeq)this.jdField_a_of_type_Xej).c.charAt(1));
    a(this.c, ((xeq)this.jdField_a_of_type_Xej).c.charAt(3));
    a(this.d, ((xeq)this.jdField_a_of_type_Xej).c.charAt(4));
    int i = xod.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Xeq.a != null) && (this.jdField_a_of_type_Xeq.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Xeq.a != null) && (this.jdField_a_of_type_Xeq.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Xeq.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Xeq.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > bdcb.k() / bdcb.l())
      {
        paramInt = (int)(bdcb.k() * this.jdField_a_of_type_Xeq.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Xeq.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + bcwh.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = bcwh.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
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
 * Qualified Name:     xes
 * JD-Core Version:    0.7.0.1
 */