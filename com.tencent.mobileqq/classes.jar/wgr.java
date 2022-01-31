import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class wgr
  extends xrg<weh>
{
  public static final String KEY = "DetailLikeListSegment";
  private wdr jdField_a_of_type_Wdr;
  private weh jdField_a_of_type_Weh;
  private wgh jdField_a_of_type_Wgh = new wgh(2);
  private wgi jdField_a_of_type_Wgi = new wgi();
  private boolean b;
  
  public wgr(Context paramContext)
  {
    super(paramContext);
  }
  
  public void Z_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Weh != null) && (this.jdField_a_of_type_Weh.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwph.a(2131369421);
    SpannableStringBuilder localSpannableStringBuilder = weo.a(this.jdField_a_of_type_Weh.a, this.jdField_a_of_type_Weh.b(this.b), this.jdField_a_of_type_Wgh);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramwph.a();
    }
    if ((this.jdField_a_of_type_Weh.b(this.b) >= 30) && (this.jdField_a_of_type_Weh.b(this.b) > this.jdField_a_of_type_Weh.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { xod.a(this.jdField_a_of_type_Weh.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Wgi);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561409, paramViewGroup, false));
  }
  
  public void a(wdr paramwdr)
  {
    this.jdField_a_of_type_Wdr = paramwdr;
    this.jdField_a_of_type_Wgh.a(paramwdr);
  }
  
  public void a(weh paramweh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Weh = paramweh;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wgr
 * JD-Core Version:    0.7.0.1
 */