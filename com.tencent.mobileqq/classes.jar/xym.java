import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.List;

public class xym
  extends zgz<xwc>
{
  public static final String KEY = "DetailLikeListSegment";
  private xvm jdField_a_of_type_Xvm;
  private xwc jdField_a_of_type_Xwc;
  private xyc jdField_a_of_type_Xyc = new xyc(2);
  private xyd jdField_a_of_type_Xyd = new xyd();
  private boolean b;
  
  public xym(Context paramContext)
  {
    super(paramContext);
  }
  
  public void P_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xwc != null) && (this.jdField_a_of_type_Xwc.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyhc.a(2131370095);
    SpannableStringBuilder localSpannableStringBuilder = xwj.a(this.jdField_a_of_type_Xwc.a, this.jdField_a_of_type_Xwc.b(this.b), this.jdField_a_of_type_Xyc);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramyhc.a();
    }
    if ((this.jdField_a_of_type_Xwc.b(this.b) >= 30) && (this.jdField_a_of_type_Xwc.b(this.b) > this.jdField_a_of_type_Xwc.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { UIUtils.formatCount(this.jdField_a_of_type_Xwc.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Xyd);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    return new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561652, paramViewGroup, false));
  }
  
  public void a(xvm paramxvm)
  {
    this.jdField_a_of_type_Xvm = paramxvm;
    this.jdField_a_of_type_Xyc.a(paramxvm);
  }
  
  public void a(xwc paramxwc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xwc = paramxwc;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xym
 * JD-Core Version:    0.7.0.1
 */