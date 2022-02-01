import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qie
  extends rsd
  implements View.OnClickListener
{
  public static final String KEY = "PlayerDoubleTabSegment";
  private qhy jdField_a_of_type_Qhy;
  private qru jdField_a_of_type_Qru;
  private qyd b;
  private int bmt = 1;
  
  public qie(Context paramContext)
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
    if (QQStoryContext.isNightMode())
    {
      paramViewGroup.setBackgroundColor(this.context.getResources().getColor(2131166759));
      localTextView.setBackgroundColor(this.context.getResources().getColor(2131166759));
      paramqyd.get(2131375118).setBackgroundColor(this.context.getResources().getColor(2131166761));
    }
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
    paramViewGroup.setOnClickListener(this);
    localTextView.setOnClickListener(this);
    return this.b;
  }
  
  public void a(qhy paramqhy)
  {
    this.jdField_a_of_type_Qhy = paramqhy;
  }
  
  public void c(qru paramqru)
  {
    this.jdField_a_of_type_Qru = paramqru;
    if (this.jdField_a_of_type_Qru.Kl()) {
      this.bmt = this.jdField_a_of_type_Qhy.sB();
    }
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
    return "PlayerDoubleTabSegment";
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Qhy.setTabType(1);
      rar.a("content_flow", "clk_detail_reply", 0, 1, new String[] { "", rar.bX(4444), this.jdField_a_of_type_Qru.d.feedId });
      continue;
      this.jdField_a_of_type_Qhy.setTabType(2);
      rar.a("content_flow", "clk_detail_reply", 0, 2, new String[] { "", rar.bX(4444), this.jdField_a_of_type_Qru.d.feedId });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qie
 * JD-Core Version:    0.7.0.1
 */