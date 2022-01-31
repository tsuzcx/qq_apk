import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class urz
  extends wco<upp>
{
  public static final String KEY = "DetailLikeListSegment";
  private uoz jdField_a_of_type_Uoz;
  private upp jdField_a_of_type_Upp;
  private urp jdField_a_of_type_Urp = new urp(2);
  private urq jdField_a_of_type_Urq = new urq();
  private boolean b;
  
  public urz(Context paramContext)
  {
    super(paramContext);
  }
  
  public void R_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Upp != null) && (this.jdField_a_of_type_Upp.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvap.a(2131369189);
    SpannableStringBuilder localSpannableStringBuilder = upw.a(this.jdField_a_of_type_Upp.a, this.jdField_a_of_type_Upp.b(this.b), this.jdField_a_of_type_Urp);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramvap.a();
    }
    if ((this.jdField_a_of_type_Upp.b(this.b) >= 30) && (this.jdField_a_of_type_Upp.b(this.b) > this.jdField_a_of_type_Upp.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { vzl.a(this.jdField_a_of_type_Upp.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Urq);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561219, paramViewGroup, false));
  }
  
  public void a(uoz paramuoz)
  {
    this.jdField_a_of_type_Uoz = paramuoz;
    this.jdField_a_of_type_Urp.a(paramuoz);
  }
  
  public void a(upp paramupp, boolean paramBoolean)
  {
    this.jdField_a_of_type_Upp = paramupp;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urz
 * JD-Core Version:    0.7.0.1
 */