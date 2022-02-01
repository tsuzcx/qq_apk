import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class yel
  extends zpa<ycb>
{
  public static final String KEY = "DetailLikeListSegment";
  private ybl jdField_a_of_type_Ybl;
  private ycb jdField_a_of_type_Ycb;
  private yeb jdField_a_of_type_Yeb = new yeb(2);
  private yec jdField_a_of_type_Yec = new yec();
  private boolean b;
  
  public yel(Context paramContext)
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Ycb != null) && (this.jdField_a_of_type_Ycb.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramynb.a(2131369833);
    SpannableStringBuilder localSpannableStringBuilder = yci.a(this.jdField_a_of_type_Ycb.a, this.jdField_a_of_type_Ycb.b(this.b), this.jdField_a_of_type_Yeb);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramynb.a();
    }
    if ((this.jdField_a_of_type_Ycb.b(this.b) >= 30) && (this.jdField_a_of_type_Ycb.b(this.b) > this.jdField_a_of_type_Ycb.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { zlx.a(this.jdField_a_of_type_Ycb.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Yec);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    return new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561663, paramViewGroup, false));
  }
  
  public void a(ybl paramybl)
  {
    this.jdField_a_of_type_Ybl = paramybl;
    this.jdField_a_of_type_Yeb.a(paramybl);
  }
  
  public void a(ycb paramycb, boolean paramBoolean)
  {
    this.jdField_a_of_type_Ycb = paramycb;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yel
 * JD-Core Version:    0.7.0.1
 */