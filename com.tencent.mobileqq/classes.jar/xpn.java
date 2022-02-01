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

public class xpn
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean e;
  
  public xpn(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "UploadStatusVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131381067));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131381069));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131381068));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381070));
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699215);
      }
      while (this.e)
      {
        this.e = false;
        ykv.a("play_video", "retrypub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699217);
      }
      ykv.a("play_video", "exp_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
      return;
    }
    if (paramStoryVideoItem.isUploading())
    {
      j();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = wcz.a().a(paramStoryVideoItem.mVid);
      if (i >= 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131715288) + i + "%");
      }
      for (;;)
      {
        wcz.a().a(paramStoryVideoItem.mVid, new xpo(this));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anvx.a(2131715290));
      }
    }
    k();
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new xpp(this), "");
  }
  
  public void a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    a(paramStoryVideoItem);
  }
  
  public boolean a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading());
  }
  
  public int b()
  {
    return 2131561854;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    StoryVideoItem localStoryVideoItem;
    if (this.jdField_a_of_type_Xhf != null)
    {
      localStoryVideoItem = this.jdField_a_of_type_Xhf.a();
      if (localStoryVideoItem != null) {
        break label41;
      }
      ykq.d(this.b, "video item not found ,click error..");
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
      case 2131381067: 
        switch (localStoryVideoItem.mUploadStatus)
        {
        }
        break;
      }
    }
    if (!wzk.a(localStoryVideoItem, b())) {
      ykv.a("play_video", "retrypub_fail", 0, 0, new String[0]);
    }
    for (;;)
    {
      ykv.a("play_video", "clk_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from) });
      ykq.b(this.b, "on retry click !");
      break;
      this.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpn
 * JD-Core Version:    0.7.0.1
 */