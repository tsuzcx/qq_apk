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
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class uja
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean e;
  
  public uja(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  public String a()
  {
    return "UploadStatusVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131379120));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131379122));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131379121));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379123));
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
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699715);
      }
      while (this.e)
      {
        this.e = false;
        vei.a("play_video", "retrypub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699717);
      }
      vei.a("play_video", "exp_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from), "", "", paramStoryVideoItem.mVid });
      return;
    }
    if (paramStoryVideoItem.isUploading())
    {
      j();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      int i = svx.a().a(paramStoryVideoItem.mVid);
      if (i >= 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715936) + i + "%");
      }
      for (;;)
      {
        svx.a().a(paramStoryVideoItem.mVid, new ujb(this));
        return;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715938));
      }
    }
    k();
  }
  
  public void a(@NonNull Map<Subscriber, String> paramMap)
  {
    paramMap.put(new ujc(this), "");
  }
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    a(paramStoryVideoItem);
  }
  
  public boolean a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (paramStoryVideoItem.isUploadFail()) || (paramStoryVideoItem.isUploading());
  }
  
  public int b()
  {
    return 2131561426;
  }
  
  public void f() {}
  
  public void g() {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Uas != null) {}
    for (StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_Uas.a(); localStoryVideoItem == null; localStoryVideoItem = null)
    {
      ved.d(this.b, "video item not found ,click error..");
      return;
    }
    switch (paramView.getId())
    {
    default: 
      return;
    }
    switch (localStoryVideoItem.mUploadStatus)
    {
    case 4: 
    case 5: 
    default: 
      return;
    }
    if (!tsr.a(localStoryVideoItem, b())) {
      vei.a("play_video", "retrypub_fail", 0, 0, new String[0]);
    }
    for (;;)
    {
      vei.a("play_video", "clk_pub_fail", 0, 0, new String[] { String.valueOf(a().mReportData.from) });
      ved.b(this.b, "on retry click !");
      return;
      this.e = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uja
 * JD-Core Version:    0.7.0.1
 */