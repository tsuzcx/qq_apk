import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;

public class tvt
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public tvr a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public tvt(tvs paramtvs, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377102);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377103);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377105));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377104));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362988));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362991));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378233));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378234));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366943));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366944));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramtvs.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166059));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843185);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new tvu(this, paramtvs));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new tvv(this, paramtvs));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new tvw(this, paramtvs, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new tvx(this, paramtvs));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramtvs.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166060));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843184);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Tvr.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Tvs.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Tvr.b);
      localIntent.putExtra("hide_operation_bar", true);
      tzq.a(localIntent, this.jdField_a_of_type_Tvr.b);
      this.jdField_a_of_type_Tvs.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.d.isShown()) && ((this.d.getDrawable() instanceof Animatable))) {
      ((Animatable)this.d.getDrawable()).stop();
    }
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        if (!this.jdField_a_of_type_Tvs.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843182);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Tvs.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166074));
          this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131713473));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843183);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_Tvs.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843185);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Tvs.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166073));
      this.jdField_a_of_type_AndroidWidgetButton.setText(anzj.a(2131713464));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843184);
    }
  }
  
  public void a(tvr paramtvr, int paramInt)
  {
    if (paramtvr == null) {
      return;
    }
    this.jdField_a_of_type_Tvr = paramtvr;
    if (paramtvr.jdField_a_of_type_Long == -1L)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject1;
    if (paramtvr.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      tvs.a(this.jdField_a_of_type_Tvs).a(tye.a(paramtvr.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramtvr.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label153:
    Object localObject2;
    if (paramtvr.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramtvr.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Tvs.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramtvr.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramtvr.jdField_a_of_type_JavaLangString);
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramtvr.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_Tvs.jdField_a_of_type_Aoof.a(1, (String)localObject1);
      if (localObject2 != null) {
        break label325;
      }
      this.jdField_a_of_type_Tvs.jdField_a_of_type_Aoof.a((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840274);
    }
    for (;;)
    {
      localObject2 = (aody)this.jdField_a_of_type_Tvs.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject2 == null) {
        break;
      }
      if (((aody)localObject2).c((String)localObject1) == null) {
        break label337;
      }
      a(1);
      paramtvr.jdField_a_of_type_Int = 1;
      return;
      localObject1 = "";
      break label153;
      label325:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label337:
    if (paramtvr.jdField_a_of_type_Int == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramtvr.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvt
 * JD-Core Version:    0.7.0.1
 */