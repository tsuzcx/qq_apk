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

class zgh
  extends zfz<zgf>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368186);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368187);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371318);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371319);
  
  private zgh(zgf paramzgf, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561867, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846691);
      return;
    case '1': 
      paramImageView.setImageResource(2130846692);
      return;
    case '2': 
      paramImageView.setImageResource(2130846693);
      return;
    case '3': 
      paramImageView.setImageResource(2130846694);
      return;
    case '4': 
      paramImageView.setImageResource(2130846695);
      return;
    case '5': 
      paramImageView.setImageResource(2130846696);
      return;
    case '6': 
      paramImageView.setImageResource(2130846697);
      return;
    case '7': 
      paramImageView.setImageResource(2130846698);
      return;
    case '8': 
      paramImageView.setImageResource(2130846699);
      return;
    }
    paramImageView.setImageResource(2130846700);
  }
  
  public void a(zgf paramzgf, int paramInt)
  {
    super.a(paramzgf, paramInt);
    paramzgf = new SimpleDateFormat("HH:mm");
    ((zgf)this.jdField_a_of_type_Zfy).c = paramzgf.format(new Date());
    yuk.b("TimeFilterData", "TimeFilterData time:" + ((zgf)this.jdField_a_of_type_Zfy).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((zgf)this.jdField_a_of_type_Zfy).c.charAt(0));
    a(this.b, ((zgf)this.jdField_a_of_type_Zfy).c.charAt(1));
    a(this.c, ((zgf)this.jdField_a_of_type_Zfy).c.charAt(3));
    a(this.d, ((zgf)this.jdField_a_of_type_Zfy).c.charAt(4));
    int i = zps.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Zgf.a != null) && (this.jdField_a_of_type_Zgf.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Zgf.a != null) && (this.jdField_a_of_type_Zgf.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Zgf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Zgf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > bhlo.k() / bhlo.l())
      {
        paramInt = (int)(bhlo.k() * this.jdField_a_of_type_Zgf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Zgf.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + bhgr.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = bhgr.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
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
 * Qualified Name:     zgh
 * JD-Core Version:    0.7.0.1
 */