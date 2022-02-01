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
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.FaceDecoder;

public class uqg
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public uqe a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public uqg(uqf paramuqf, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377126);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131377127);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377129));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377128));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363019));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363024));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378291));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378292));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131367082));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367083));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramuqf.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166087));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843283);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new uqh(this, paramuqf));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new uqi(this, paramuqf));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new uqj(this, paramuqf, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new uqk(this, paramuqf));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramuqf.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166088));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843282);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Uqe.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Uqe.b);
      localIntent.putExtra("hide_operation_bar", true);
      uuc.a(localIntent, this.jdField_a_of_type_Uqe.b);
      this.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
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
        if (!this.jdField_a_of_type_Uqf.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843280);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166102));
          this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131714052));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843281);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_Uqf.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843283);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Uqf.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166101));
      this.jdField_a_of_type_AndroidWidgetButton.setText(anvx.a(2131714043));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130843282);
    }
  }
  
  public void a(uqe paramuqe, int paramInt)
  {
    if (paramuqe == null) {
      return;
    }
    this.jdField_a_of_type_Uqe = paramuqe;
    if (paramuqe.jdField_a_of_type_Long == -1L)
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
    if (paramuqe.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      uqf.a(this.jdField_a_of_type_Uqf).a(usq.a(paramuqe.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramuqe.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label153:
    Object localObject2;
    if (paramuqe.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramuqe.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Uqf.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramuqe.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramuqe.jdField_a_of_type_JavaLangString);
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramuqe.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, (String)localObject1);
      if (localObject2 != null) {
        break label326;
      }
      this.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840348);
    }
    for (;;)
    {
      localObject2 = (aoan)this.jdField_a_of_type_Uqf.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
      if (localObject2 == null) {
        break;
      }
      if (((aoan)localObject2).c((String)localObject1) == null) {
        break label338;
      }
      a(1);
      paramuqe.jdField_a_of_type_Int = 1;
      return;
      localObject1 = "";
      break label153;
      label326:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label338:
    if (paramuqe.jdField_a_of_type_Int == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramuqe.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uqg
 * JD-Core Version:    0.7.0.1
 */