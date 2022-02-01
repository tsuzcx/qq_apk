import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.voip.VoipHistoryActivity;
import com.tencent.mobileqq.activity.voip.VoipHistoryAllType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QCallRecent;
import com.tencent.mobileqq.data.voip.VoipHistoryData;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.utils.ImageUtil;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ewr
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public ewr(VoipHistoryActivity paramVoipHistoryActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).size();
  }
  
  public Object getItem(int paramInt)
  {
    return VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Date localDate = new Date(System.currentTimeMillis());
    paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904060, paramViewGroup, false);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131234699);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131234701);
    TextView localTextView2 = (TextView)paramViewGroup.findViewById(2131234700);
    TextView localTextView3 = (TextView)paramViewGroup.findViewById(2131234702);
    TextView localTextView1 = (TextView)paramViewGroup.findViewById(2131234703);
    VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity, (RelativeLayout)paramViewGroup.findViewById(2131234698));
    VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity);
    paramView = (ewq)paramViewGroup.getTag();
    if (paramView == null)
    {
      paramView = new ewq(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity, null);
      paramViewGroup.setTag(paramView);
    }
    for (;;)
    {
      paramView.a = ((VoipHistoryAllType)VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).get(paramInt));
      VoipHistoryData localVoipHistoryData;
      if (paramView.a.type == VoipHistoryActivity.jdField_b_of_type_Int)
      {
        localVoipHistoryData = (VoipHistoryData)paramView.a.obj;
        if (VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity) != null)
        {
          paramView = VoipHistoryActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).a(localVoipHistoryData.contactLookupId);
          if ((paramView == null) || (paramView.photoUri == null)) {}
        }
      }
      try
      {
        paramView = MediaStore.Images.Media.getBitmap(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity.getContentResolver(), paramView.photoUri);
        localImageView2.setImageBitmap(ImageUtil.a(paramView, paramView.getWidth(), paramView.getWidth(), paramView.getHeight()));
        label259:
        if (localVoipHistoryData.contactLookupId != null)
        {
          localTextView2.setText(localVoipHistoryData.strContactName);
          localTextView3.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity.getString(2131559880));
          if (localVoipHistoryData.startTime != 0L)
          {
            paramView = new Date(localVoipHistoryData.startTime);
            if (paramView.getDate() != localDate.getDate()) {
              break label526;
            }
            paramView = new SimpleDateFormat("HH:mm").format(paramView);
            label340:
            localTextView1.setText(paramView);
          }
          switch (localVoipHistoryData.status)
          {
          }
        }
        for (;;)
        {
          VoipHistoryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity, (RelativeLayout)paramViewGroup.findViewById(2131234697));
          VoipHistoryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity);
          if (VoipHistoryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity) != null) {
            VoipHistoryActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity).setOnLongClickListener(new ews(this));
          }
          return paramViewGroup;
          if (!TextUtils.isEmpty(localVoipHistoryData.nickName))
          {
            localTextView2.setText(localVoipHistoryData.nickName);
            break;
          }
          if (TextUtils.isEmpty(localVoipHistoryData.countryCode)) {}
          for (paramView = localVoipHistoryData.phoneNumberWithoutCountry;; paramView = localVoipHistoryData.countryCode + " " + localVoipHistoryData.phoneNumberWithoutCountry)
          {
            localTextView2.setText(paramView);
            break;
          }
          label526:
          paramView = new SimpleDateFormat("MM-dd").format(paramView);
          break label340;
          localImageView1.setImageResource(2130840376);
          continue;
          localImageView1.setImageResource(2130840374);
          continue;
          localImageView1.setImageResource(2130840375);
        }
        paramView = (QCallRecent)paramView.a.obj;
        localImageView2.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(paramView.uin));
        localTextView2.setText(paramView.displayName);
        if (paramView.isVideo())
        {
          localTextView3.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity.getString(2131559878));
          ((ImageView)paramViewGroup.findViewById(2131234704)).setImageResource(2130840483);
          if (paramView.isSend())
          {
            localImageView1.setImageResource(2130840376);
            label666:
            if (paramView.lastCallTime == 0L) {
              break label814;
            }
            paramView = new Date(paramView.lastCallTime * 1000L);
            if (paramView.getDate() != localDate.getDate()) {
              break label816;
            }
          }
        }
        label814:
        label816:
        for (paramView = new SimpleDateFormat("HH:mm").format(paramView);; paramView = new SimpleDateFormat("MM-dd").format(paramView))
        {
          localTextView1.setText(paramView);
          break;
          if (paramView.isMissedCall())
          {
            localImageView1.setImageResource(2130840375);
            break label666;
          }
          localImageView1.setImageResource(2130840374);
          break label666;
          localTextView3.setText(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipHistoryActivity.getString(2131559879));
          if (paramView.isSend())
          {
            localImageView1.setImageResource(2130840376);
            break label666;
          }
          if (paramView.isMissedCall())
          {
            localImageView1.setImageResource(2130840375);
            break label666;
          }
          localImageView1.setImageResource(2130840374);
          break label666;
          break;
        }
      }
      catch (IOException paramView)
      {
        break label259;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewr
 * JD-Core Version:    0.7.0.1
 */