import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qst
  extends rsd
  implements View.OnClickListener
{
  public static final String KEY = "DetailDoubleTabSegment";
  private qrn jdField_a_of_type_Qrn;
  private qru jdField_a_of_type_Qru;
  private qyd b;
  private int bmt = 1;
  
  public qst(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QQStoryContext.isNightMode()) {
        paramTextView.setBackgroundResource(2130847341);
      }
      for (;;)
      {
        paramTextView.setTextColor(this.context.getResources().getColor(2131166748));
        return;
        paramTextView.setBackgroundResource(2130847340);
      }
    }
    paramTextView.setBackgroundResource(0);
    if (QQStoryContext.isNightMode())
    {
      paramTextView.setTextColor(this.context.getResources().getColor(2131166761));
      return;
    }
    paramTextView.setTextColor(this.context.getResources().getColor(2131166749));
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramqyd.get(2131378792);
    TextView localTextView = (TextView)paramqyd.get(2131378791);
    if (this.bmt == 1)
    {
      a(paramViewGroup, true);
      a(localTextView, false);
    }
    for (;;)
    {
      return paramqyd.getItemView();
      a(paramViewGroup, false);
      a(localTextView, true);
    }
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    this.b = new qyd(LayoutInflater.from(this.context).inflate(2131561814, paramViewGroup, false));
    paramViewGroup = (TextView)this.b.get(2131378792);
    TextView localTextView = (TextView)this.b.get(2131378791);
    if (QQStoryContext.isNightMode())
    {
      paramViewGroup.setBackgroundColor(this.context.getResources().getColor(2131166759));
      localTextView.setBackgroundColor(this.context.getResources().getColor(2131166759));
      this.b.get(2131375118).setBackgroundColor(this.context.getResources().getColor(2131166761));
    }
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.b;
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
    if (this.jdField_a_of_type_Qru.Kl())
    {
      if (paramBoolean) {
        this.bmt = 2;
      }
    }
    else {
      return;
    }
    this.bmt = 1;
  }
  
  public int getCount()
  {
    if ((this.isDisplay) && (this.jdField_a_of_type_Qru != null) && (this.jdField_a_of_type_Qru.Km())) {
      return 1;
    }
    return 0;
  }
  
  public String getKey()
  {
    return "DetailDoubleTabSegment";
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qrn == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131378791: 
        if (this.bmt != 2) {
          this.jdField_a_of_type_Qrn.wu(2);
        }
        break;
      case 2131378792: 
        if (this.bmt != 1) {
          this.jdField_a_of_type_Qrn.wu(1);
        }
        break;
      }
    }
  }
  
  public int sO()
  {
    return this.bmt;
  }
  
  public int sP()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getItemView().getMeasuredHeight();
  }
  
  public void setCallback(qrn paramqrn)
  {
    this.jdField_a_of_type_Qrn = paramqrn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qst
 * JD-Core Version:    0.7.0.1
 */