import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class ufg
  extends vpv<ucw>
{
  public static final String KEY = "DetailLikeListSegment";
  private ucg jdField_a_of_type_Ucg;
  private ucw jdField_a_of_type_Ucw;
  private uew jdField_a_of_type_Uew = new uew(2);
  private uex jdField_a_of_type_Uex = new uex();
  private boolean b;
  
  public ufg(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ucw != null) && (this.jdField_a_of_type_Ucw.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramunw.a(2131303521);
    SpannableStringBuilder localSpannableStringBuilder = udd.a(this.jdField_a_of_type_Ucw.a, this.jdField_a_of_type_Ucw.b(this.b), this.jdField_a_of_type_Uew);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramunw.a();
    }
    if ((this.jdField_a_of_type_Ucw.b(this.b) >= 30) && (this.jdField_a_of_type_Ucw.b(this.b) > this.jdField_a_of_type_Ucw.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { vms.a(this.jdField_a_of_type_Ucw.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Uex);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    return new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495629, paramViewGroup, false));
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
    this.jdField_a_of_type_Uew.a(paramucg);
  }
  
  public void a(ucw paramucw, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ucw = paramucw;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ufg
 * JD-Core Version:    0.7.0.1
 */