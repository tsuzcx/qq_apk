import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class wla
  extends xvp<wiq>
{
  public static final String KEY = "DetailLikeListSegment";
  private wia jdField_a_of_type_Wia;
  private wiq jdField_a_of_type_Wiq;
  private wkq jdField_a_of_type_Wkq = new wkq(2);
  private wkr jdField_a_of_type_Wkr = new wkr();
  private boolean b;
  
  public wla(Context paramContext)
  {
    super(paramContext);
  }
  
  public void W_()
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Wiq != null) && (this.jdField_a_of_type_Wiq.b(this.b).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwtq.a(2131369439);
    SpannableStringBuilder localSpannableStringBuilder = wix.a(this.jdField_a_of_type_Wiq.a, this.jdField_a_of_type_Wiq.b(this.b), this.jdField_a_of_type_Wkq);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramwtq.a();
    }
    if ((this.jdField_a_of_type_Wiq.b(this.b) >= 30) && (this.jdField_a_of_type_Wiq.b(this.b) > this.jdField_a_of_type_Wiq.b(this.b).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { xsm.a(this.jdField_a_of_type_Wiq.b(this.b)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.jdField_a_of_type_Wkr);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public String a()
  {
    return "DetailLikeListSegment";
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    return new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561427, paramViewGroup, false));
  }
  
  public void a(wia paramwia)
  {
    this.jdField_a_of_type_Wia = paramwia;
    this.jdField_a_of_type_Wkq.a(paramwia);
  }
  
  public void a(wiq paramwiq, boolean paramBoolean)
  {
    this.jdField_a_of_type_Wiq = paramwiq;
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wla
 * JD-Core Version:    0.7.0.1
 */