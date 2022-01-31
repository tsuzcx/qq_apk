import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.component.ComponentBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StTagInfo;

public class ttj
  extends tvg
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QCircleInitBean jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean;
  private tzk jdField_a_of_type_Tzk;
  
  public ttj(QCircleInitBean paramQCircleInitBean)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean = paramQCircleInitBean;
  }
  
  private void a(FeedCloudMeta.StTagInfo paramStTagInfo)
  {
    if (paramStTagInfo == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramStTagInfo.tagName.get());
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377904);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378985));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368697));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_Tzk = ((tzk)a(tzk.class));
    this.jdField_a_of_type_Tzk.b.observe(a(), new ttk(this));
    if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean != null) && (this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo() != null)) {
      a(this.jdField_a_of_type_ComTencentBizQqcircleQCircleInitBean.getTagInfo());
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    int i;
    if ((TextUtils.equals(paramString, "tag_page_action_title_bar_animation")) && ((paramObject instanceof Message)))
    {
      i = ((Message)paramObject).what;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.argb(i, 235, 236, 240));
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.argb(i, 0, 0, 0));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (i != 0) {
        break label94;
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    label94:
    while (i != 255) {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(a().getResources().getColor(2131166178));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while ((a().onBackEvent()) || (a() == null));
    a().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ttj
 * JD-Core Version:    0.7.0.1
 */