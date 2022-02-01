import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView.a;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class lta
  implements ProteusItemView.a
{
  private boolean akN;
  private final ProteusItemView jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView;
  private lie jdField_d_of_type_Lie;
  private View kD;
  private View.OnClickListener mOnClickListener = new ltb(this);
  
  public lta(ProteusItemView paramProteusItemView)
  {
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView = paramProteusItemView;
    init();
  }
  
  private boolean CH()
  {
    return false;
  }
  
  private void KR()
  {
    if (this.akN) {
      return;
    }
    this.akN = true;
    kbp.a(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", kxm.a().b("jump_src", kys.ja()).build(), false);
  }
  
  private static float getAlpha()
  {
    try
    {
      float f = Float.valueOf((String)awit.f("kandian_daily_wrapper_alpha", "1.0")).floatValue();
      if ((f >= 0.0F) && (f <= 1.0F)) {
        return f;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ProteusItemHelper", 1, localException, new Object[] { "" });
    }
    return 1.0F;
  }
  
  private void init()
  {
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.a(this);
  }
  
  public lie a()
  {
    return this.jdField_d_of_type_Lie;
  }
  
  public void aDi()
  {
    if (CH())
    {
      if (this.kD == null)
      {
        this.kD = LayoutInflater.from(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getContext()).inflate(2131560341, null, false);
        localObject = (TextView)this.kD.findViewById(2131379590);
        ((TextView)localObject).setTextSize(0, Utils.dp2px(14.0D));
        ((TextView)localObject).setText(nen.ai(((TextView)localObject).getContext()));
        f = getAlpha();
        this.kD.setBackgroundResource(2130850232);
        this.kD.getBackground().setAlpha((int)(f * 255.0F));
        this.kD.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getWidth(), this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getHeight());
        this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.addView(this.kD, (ViewGroup.LayoutParams)localObject);
        KR();
      }
      this.kD.setVisibility(0);
      this.kD.setOnClickListener(this.mOnClickListener);
    }
    while (this.kD == null)
    {
      Object localObject;
      float f;
      return;
    }
    this.kD.setVisibility(8);
    this.jdField_d_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.removeView(this.kD);
    this.kD = null;
  }
  
  public void setModel(lie paramlie)
  {
    this.jdField_d_of_type_Lie = paramlie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lta
 * JD-Core Version:    0.7.0.1
 */