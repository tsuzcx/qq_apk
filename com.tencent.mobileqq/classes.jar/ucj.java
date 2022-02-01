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
import com.tencent.mobileqq.app.face.FaceDecoder;

public class ucj
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public uch a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public ucj(uci paramuci, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376854);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376855);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376857));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376856));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363002));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363007));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378003));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378004));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366964));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366965));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramuci.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166078));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843247);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new uck(this, paramuci));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new ucl(this, paramuci));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new ucm(this, paramuci, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new ucn(this, paramuci));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramuci.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166079));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843246);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Uch.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Uch.b);
      localIntent.putExtra("hide_operation_bar", true);
      ugf.a(localIntent, this.jdField_a_of_type_Uch.b);
      this.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
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
        if (!this.jdField_a_of_type_Uci.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843244);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166093));
          this.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131713705));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843245);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_Uci.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843247);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Uci.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166092));
      this.jdField_a_of_type_AndroidWidgetButton.setText(amtj.a(2131713696));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843246);
    }
  }
  
  public void a(uch paramuch, int paramInt)
  {
    if (paramuch == null) {
      return;
    }
    this.jdField_a_of_type_Uch = paramuch;
    if (paramuch.jdField_a_of_type_Long == -1L)
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
    if (paramuch.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      uci.a(this.jdField_a_of_type_Uci).a(uet.a(paramuch.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramuch.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label153:
    Object localObject2;
    if (paramuch.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramuch.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Uci.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramuch.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramuch.jdField_a_of_type_JavaLangString);
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramuch.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, (String)localObject1);
      if (localObject2 != null) {
        break label325;
      }
      this.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840312);
    }
    for (;;)
    {
      localObject2 = (amxz)this.jdField_a_of_type_Uci.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject2 == null) {
        break;
      }
      if (((amxz)localObject2).c((String)localObject1) == null) {
        break label337;
      }
      a(1);
      paramuch.jdField_a_of_type_Int = 1;
      return;
      localObject1 = "";
      break label153;
      label325:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label337:
    if (paramuch.jdField_a_of_type_Int == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramuch.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ucj
 * JD-Core Version:    0.7.0.1
 */