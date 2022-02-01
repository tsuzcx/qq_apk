import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class tqz
  extends tov
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private trc jdField_a_of_type_Trc;
  protected boolean b;
  
  public tqz(Activity paramActivity, trc paramtrc)
  {
    super(paramActivity);
    this.jdField_a_of_type_Trc = paramtrc;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560289, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131369100);
    localImageView.setImageResource(2130841701);
    ((TextView)paramLayoutInflater.findViewById(2131369178)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131369182)).setText(anvx.a(2131713611));
    paramLayoutInflater.findViewById(2131369164).setVisibility(8);
    paramLayoutInflater.findViewById(2131377408).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new tra(this));
    localImageView.setOnClickListener(new trb(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tqz
 * JD-Core Version:    0.7.0.1
 */