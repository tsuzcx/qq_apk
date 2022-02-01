import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class tiu
  extends tgq
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private tix jdField_a_of_type_Tix;
  protected boolean b;
  
  public tiu(Activity paramActivity, tix paramtix)
  {
    super(paramActivity);
    this.jdField_a_of_type_Tix = paramtix;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560224, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, afur.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131368826);
    localImageView.setImageResource(2130841645);
    ((TextView)paramLayoutInflater.findViewById(2131368896)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131368900)).setText(anni.a(2131712923));
    paramLayoutInflater.findViewById(2131368885).setVisibility(8);
    paramLayoutInflater.findViewById(2131377231).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new tiv(this));
    localImageView.setOnClickListener(new tiw(this));
    return paramLayoutInflater;
  }
  
  public void a(View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (!this.b)
    {
      a();
      this.b = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tiu
 * JD-Core Version:    0.7.0.1
 */