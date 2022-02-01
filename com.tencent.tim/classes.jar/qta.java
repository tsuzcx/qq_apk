import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import java.util.List;

public class qta
  extends rsd<qru>
{
  public static final String KEY = "DetailLikeListSegment";
  private qrn jdField_a_of_type_Qrn;
  private qru jdField_a_of_type_Qru;
  private qss.a jdField_a_of_type_Qss$a = new qss.a(2);
  private qss.b b = new qss.b();
  private boolean mIsOpen;
  
  public qta(Context paramContext)
  {
    super(paramContext);
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramqyd.get(2131370446);
    SpannableStringBuilder localSpannableStringBuilder = qrx.a(this.jdField_a_of_type_Qru.d, this.jdField_a_of_type_Qru.i(this.mIsOpen), this.jdField_a_of_type_Qss$a);
    if (localSpannableStringBuilder.length() == 0)
    {
      paramViewGroup.setVisibility(8);
      return paramqyd.getItemView();
    }
    if ((this.jdField_a_of_type_Qru.s(this.mIsOpen) >= 30) && (this.jdField_a_of_type_Qru.s(this.mIsOpen) > this.jdField_a_of_type_Qru.i(this.mIsOpen).size())) {
      localSpannableStringBuilder.append(String.format("等%s人赞了", new Object[] { rpq.aL(this.jdField_a_of_type_Qru.s(this.mIsOpen)) }));
    }
    for (;;)
    {
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(localSpannableStringBuilder);
      paramViewGroup.setOnTouchListener(this.b);
      break;
      localSpannableStringBuilder.append("赞了");
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    return new qyd(LayoutInflater.from(this.context).inflate(2131561820, paramViewGroup, false));
  }
  
  public void bqo()
  {
    if (((StoryDetailListView)a()).Kx())
    {
      this.isDisplay = true;
      return;
    }
    this.isDisplay = false;
  }
  
  public void d(qru paramqru, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qru = paramqru;
    this.mIsOpen = paramBoolean;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.i(this.mIsOpen).size() > 0)) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "DetailLikeListSegment";
  }
  
  public void setCallback(qrn paramqrn)
  {
    this.jdField_a_of_type_Qrn = paramqrn;
    this.jdField_a_of_type_Qss$a.setCallback(paramqrn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qta
 * JD-Core Version:    0.7.0.1
 */