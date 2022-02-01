import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;

class wcm
  extends RecyclerView.ViewHolder
{
  public RelativeLayout a;
  public TextView a;
  public FeedCloudMeta.StTagInfo a;
  
  public wcm(wcl paramwcl, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369610));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369608));
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo, int paramInt)
  {
    if (paramStTagInfo != null)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = paramStTagInfo;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStTagInfo.tagName.get());
      paramStTagInfo = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt != 0) {
        break label89;
      }
      paramStTagInfo.setMargins(0, 0, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramStTagInfo);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(bdep.a(5.0F), 0, bdep.a(5.0F), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new wcn(this));
      return;
      label89:
      if (paramInt == this.jdField_a_of_type_Wcl.a.size() - 1) {
        paramStTagInfo.setMargins(bdep.a(5.0F), 0, bdep.a(38.0F), 0);
      } else {
        paramStTagInfo.setMargins(bdep.a(5.0F), 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcm
 * JD-Core Version:    0.7.0.1
 */