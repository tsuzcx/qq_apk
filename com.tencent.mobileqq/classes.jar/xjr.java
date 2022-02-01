import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.List;

public class xjr
  extends ysg<xhh>
{
  public static final String KEY = "DetailLikeListSegment";
  private xgr jdField_a_of_type_Xgr;
  private xhh jdField_a_of_type_Xhh;
  private xjh jdField_a_of_type_Xjh = new xjh(2);
  private xji jdField_a_of_type_Xji = new xji();
  private boolean b;
  
  public xjr(Context paramContext)
  {
    super(paramContext);
  }
  
  public void N_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Xhh != null) && (this.jdField_a_of_type_Xhh.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramxsh.a(2131369925);
    SpannableStringBuilder localSpannableStringBuilder = xho.a(this.jdField_a_of_type_Xhh.a, this.jdField_a_of_type_Xhh.b(this.b), this.jdField_a_of_type_Xjh);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramxsh.a();
    }
    if ((this.jdField_a_of_type_Xhh.b(this.b) >= 30) && (this.jdField_a_of_type_Xhh.b(this.b) > this.jdField_a_of_type_Xhh.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { UIUtils.formatCount(this.jdField_a_of_type_Xhh.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Xji);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    return new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561584, paramViewGroup, false));
  }
  
  public void a(xgr paramxgr)
  {
    this.jdField_a_of_type_Xgr = paramxgr;
    this.jdField_a_of_type_Xjh.a(paramxgr);
  }
  
  public void a(xhh paramxhh, boolean paramBoolean)
  {
    this.jdField_a_of_type_Xhh = paramxhh;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjr
 * JD-Core Version:    0.7.0.1
 */