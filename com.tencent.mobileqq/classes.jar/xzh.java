import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class xzh
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean e;
  
  public xzh(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "UploadStatusVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131380989));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131380991));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131380990));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380992));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  public void a(StoryVideoItem paramStoryVideoItem)
  {
    if (paramStoryVideoItem.isUploadFail())
    {
      j();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      switch (paramStoryVideoItem.mUpLoadFailedError)
      {
      default: 
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698629);
      }
      while (this.e)
      {
        this.e = false;
        yup.a("play_video", "retrypub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131698631);
      }
      yup.a("play_video", "exp_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
      return;
    }
    if (paramStoryVideoItem.isUploading())
    {
      j();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = wmf.a().a(paramStoryVideoItem.mVid);
      if (i >= 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131714706) + i + "%");
      }
      for (;;)
      {
        wmf.a().a(paramStoryVideoItem.mVid, new xzi(this));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131714708));
      }
    }
    k();
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xzj(this), "");
  }
  
  public void a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    a(paramStoryVideoItem);
  }
  
  public boolean a(@NonNull xqz paramxqz, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading());
  }
  
  public int b()
  {
    return 2131561909;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Xqz != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Xqz.a();
      if (localStoryVideoItem != null) {
        break label41;
      }
      yuk.d(this.b, "video item not found ,click error..");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localStoryVideoItem = null;
      break;
      label41:
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131380989: 
        switch (localStoryVideoItem.mUploadStatus)
        {
        }
        break;
      }
    }
    if (!xiz.a(localStoryVideoItem, b())) {
      yup.a("play_video", "retrypub_fail", 0, 0, new String[0]);
    }
    for (;;)
    {
      yup.a("play_video", "clk_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from) });
      yuk.b(this.b, "on retry click !");
      break;
      this.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzh
 * JD-Core Version:    0.7.0.1
 */