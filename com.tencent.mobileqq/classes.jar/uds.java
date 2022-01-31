import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.List;

class uds
  extends RecyclerView.ViewHolder
{
  public RelativeLayout a;
  public TextView a;
  public FeedCloudMeta.StTagInfo a;
  
  public uds(udr paramudr, View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369111));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131369109));
  }
  
  public void a(FeedCloudMeta.StTagInfo paramStTagInfo, int paramInt)
  {
    if (paramStTagInfo != null)
    {
      this.jdField_a_of_type_FeedcloudFeedCloudMeta$StTagInfo = paramStTagInfo;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStTagInfo.tagName.get());
      paramStTagInfo = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt != 0) {
        break label93;
      }
      paramStTagInfo.setMargins(azgq.a(12.0F), 0, 0, 0);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(paramStTagInfo);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(azgq.a(5.0F), 0, azgq.a(5.0F), 0);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new udt(this));
      return;
      label93:
      if (paramInt == this.jdField_a_of_type_Udr.a.size() - 1) {
        paramStTagInfo.setMargins(azgq.a(5.0F), 0, azgq.a(38.0F), 0);
      } else {
        paramStTagInfo.setMargins(azgq.a(5.0F), 0, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uds
 * JD-Core Version:    0.7.0.1
 */