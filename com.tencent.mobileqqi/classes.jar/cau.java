import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity.PicInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.util.ArrayList;

public class cau
  extends BaseAdapter
{
  protected LayoutInflater a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public cau(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramChatBackgroundSettingActivity.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    Object localObject3;
    View localView1;
    View localView2;
    if (paramView != null)
    {
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject1).height = this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Int;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject3 = (ImageView)paramView.findViewById(2131231325);
      paramViewGroup = (ImageView)paramView.findViewById(2131231327);
      localView1 = paramView.findViewById(2131231326);
      localView2 = paramView.findViewById(2131231328);
      int i = (((ViewGroup.LayoutParams)localObject1).height - (int)(8.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float)) * 31 / 132;
      localView2.setPadding((int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float * 4.0F), ((ViewGroup.LayoutParams)localObject1).height - i - (int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float * 4.0F), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float * 4.0F), (int)(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float * 4.0F));
      localObject1 = (ProgressBar)paramView.findViewById(2131231329);
      localView1.setVisibility(8);
      paramViewGroup.setVisibility(8);
      if (paramInt != 0) {
        break label337;
      }
      if (SkinEngine.getInstances().getSkinRootPath() != null) {
        break label322;
      }
      paramInt = 1;
      label200:
      ((ImageView)localObject3).setImageResource(2130839804);
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaLangString.equals("none"))) && ((paramInt == 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaLangString.length() != 0) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaLangString))))) {
        break label327;
      }
      localView1.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_Int = 0;
      label288:
      paramView.setTag(null);
    }
    for (;;)
    {
      paramViewGroup.setOnClickListener(new cav(this));
      return paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903128, paramViewGroup, false);
      break;
      label322:
      paramInt = 0;
      break label200;
      label327:
      localView1.setVisibility(8);
      break label288;
      label337:
      Object localObject2 = (ChatBackgroundSettingActivity.PicInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      paramView.setTag(localObject2);
      Object localObject4 = BitmapManager.a(AppConstants.aV + ((ChatBackgroundSettingActivity.PicInfo)localObject2).a + ".png");
      if (localObject4 != null)
      {
        ((ImageView)localObject3).setImageDrawable(new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.getResources(), (Bitmap)localObject4));
        localObject3 = AppConstants.aW + ((ChatBackgroundSettingActivity.PicInfo)localObject2).jdField_b_of_type_JavaLangString + ".png";
        localObject4 = new File((String)localObject3);
        localObject2 = (HttpDownloadFileProcessor)this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((ChatBackgroundSettingActivity.PicInfo)localObject2).c);
        if ((((File)localObject4).exists()) && ((localObject2 == null) || (((HttpDownloadFileProcessor)localObject2).f())))
        {
          localView2.setVisibility(8);
          paramViewGroup.setVisibility(8);
          if (!((String)localObject3).equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaLangString)) {
            continue;
          }
          localView1.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_Int = paramInt;
        }
      }
      else
      {
        ((ImageView)localObject3).setImageResource(2130839804);
        localView2.setVisibility(8);
        paramViewGroup.setVisibility(8);
        return paramView;
      }
      if ((localObject2 == null) || (((HttpDownloadFileProcessor)localObject2).f()))
      {
        paramViewGroup.setVisibility(0);
        localView2.setVisibility(8);
      }
      else
      {
        localView2.setVisibility(0);
        paramViewGroup.setVisibility(8);
        float f = ((ProgressBar)localObject1).getMax();
        ((ProgressBar)localObject1).setProgress((int)((float)((HttpDownloadFileProcessor)localObject2).b() / (float)((HttpDownloadFileProcessor)localObject2).a() * f));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cau
 * JD-Core Version:    0.7.0.1
 */