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

class zcm
  extends zce<zck>
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368114);
  private ImageView b = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368115);
  private ImageView c = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371211);
  private ImageView d = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371212);
  
  private zcm(zck paramzck, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561826, paramViewGroup, false);
  }
  
  void a(ImageView paramImageView, char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return;
    case '0': 
      paramImageView.setImageResource(2130846674);
      return;
    case '1': 
      paramImageView.setImageResource(2130846675);
      return;
    case '2': 
      paramImageView.setImageResource(2130846676);
      return;
    case '3': 
      paramImageView.setImageResource(2130846677);
      return;
    case '4': 
      paramImageView.setImageResource(2130846678);
      return;
    case '5': 
      paramImageView.setImageResource(2130846679);
      return;
    case '6': 
      paramImageView.setImageResource(2130846680);
      return;
    case '7': 
      paramImageView.setImageResource(2130846681);
      return;
    case '8': 
      paramImageView.setImageResource(2130846682);
      return;
    }
    paramImageView.setImageResource(2130846683);
  }
  
  public void a(zck paramzck, int paramInt)
  {
    super.a(paramzck, paramInt);
    paramzck = new SimpleDateFormat("HH:mm");
    ((zck)this.jdField_a_of_type_Zcd).c = paramzck.format(new Date());
    yqp.b("TimeFilterData", "TimeFilterData time:" + ((zck)this.jdField_a_of_type_Zcd).c);
    a(this.jdField_a_of_type_AndroidWidgetImageView, ((zck)this.jdField_a_of_type_Zcd).c.charAt(0));
    a(this.b, ((zck)this.jdField_a_of_type_Zcd).c.charAt(1));
    a(this.c, ((zck)this.jdField_a_of_type_Zcd).c.charAt(3));
    a(this.d, ((zck)this.jdField_a_of_type_Zcd).c.charAt(4));
    int i = zlx.d(this.jdField_a_of_type_AndroidViewView.getContext());
    if (((this.jdField_a_of_type_Zck.a != null) && (this.jdField_a_of_type_Zck.a.jdField_a_of_type_Int == 10)) || ((this.jdField_a_of_type_Zck.a != null) && (this.jdField_a_of_type_Zck.a.jdField_a_of_type_Int == 12)))
    {
      if (this.jdField_a_of_type_Zck.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() / this.jdField_a_of_type_Zck.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() > bgln.k() / bgln.l())
      {
        paramInt = (int)(bgln.k() * this.jdField_a_of_type_Zck.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.b() / this.jdField_a_of_type_Zck.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
        if (paramInt > i / 3 * 2 + bggq.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F))
        {
          this.jdField_a_of_type_AndroidViewView.setPadding(0, i / 3 * 2, 0, 0);
          return;
        }
        i = bggq.a(this.jdField_a_of_type_AndroidViewView.getContext(), 75.0F);
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
 * Qualified Name:     zcm
 * JD-Core Version:    0.7.0.1
 */