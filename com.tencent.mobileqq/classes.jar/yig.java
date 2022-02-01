import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class yig
  extends zsv<yfw>
{
  public static final String KEY = "DetailLikeListSegment";
  private yfg jdField_a_of_type_Yfg;
  private yfw jdField_a_of_type_Yfw;
  private yhw jdField_a_of_type_Yhw = new yhw(2);
  private yhx jdField_a_of_type_Yhx = new yhx();
  private boolean b;
  
  public yig(Context paramContext)
  {
    super(paramContext);
  }
  
  public void T_()
  {
    if (((StoryDetailListView)a()).a())
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Yfw != null) && (this.jdField_a_of_type_Yfw.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyqw.a(2131369931);
    SpannableStringBuilder localSpannableStringBuilder = ygd.a(this.jdField_a_of_type_Yfw.a, this.jdField_a_of_type_Yfw.b(this.b), this.jdField_a_of_type_Yhw);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramyqw.a();
    }
    if ((this.jdField_a_of_type_Yfw.b(this.b) >= 30) && (this.jdField_a_of_type_Yfw.b(this.b) > this.jdField_a_of_type_Yfw.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { zps.a(this.jdField_a_of_type_Yfw.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Yhx);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561704, paramViewGroup, false));
  }
  
  public void a(yfg paramyfg)
  {
    this.jdField_a_of_type_Yfg = paramyfg;
    this.jdField_a_of_type_Yhw.a(paramyfg);
  }
  
  public void a(yfw paramyfw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Yfw = paramyfw;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yig
 * JD-Core Version:    0.7.0.1
 */