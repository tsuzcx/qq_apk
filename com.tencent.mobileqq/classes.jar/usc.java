import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class usc
  extends wcr<ups>
{
  public static final String KEY = "DetailLikeListSegment";
  private upc jdField_a_of_type_Upc;
  private ups jdField_a_of_type_Ups;
  private urs jdField_a_of_type_Urs = new urs(2);
  private urt jdField_a_of_type_Urt = new urt();
  private boolean b;
  
  public usc(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ups != null) && (this.jdField_a_of_type_Ups.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvas.a(2131369189);
    SpannableStringBuilder localSpannableStringBuilder = upz.a(this.jdField_a_of_type_Ups.a, this.jdField_a_of_type_Ups.b(this.b), this.jdField_a_of_type_Urs);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramvas.a();
    }
    if ((this.jdField_a_of_type_Ups.b(this.b) >= 30) && (this.jdField_a_of_type_Ups.b(this.b) > this.jdField_a_of_type_Ups.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { vzo.a(this.jdField_a_of_type_Ups.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Urt);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    return new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561220, paramViewGroup, false));
  }
  
  public void a(upc paramupc)
  {
    this.jdField_a_of_type_Upc = paramupc;
    this.jdField_a_of_type_Urs.a(paramupc);
  }
  
  public void a(ups paramups, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ups = paramups;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     usc
 * JD-Core Version:    0.7.0.1
 */