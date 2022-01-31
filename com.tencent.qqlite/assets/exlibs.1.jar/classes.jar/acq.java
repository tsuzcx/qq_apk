import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.transfile.HttpDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class acq
  extends BaseAdapter
{
  protected LayoutInflater a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public acq(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramChatBackgroundSettingActivity.getSystemService("layout_inflater"));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size() + 1;
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
    URLImageView localURLImageView;
    View localView1;
    View localView2;
    int i;
    Object localObject2;
    if (paramView != null)
    {
      localObject1 = paramView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).width = this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Int;
      ((ViewGroup.LayoutParams)localObject1).height = this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Int;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramViewGroup = (ImageView)paramView.findViewById(2131296794);
      localURLImageView = (URLImageView)paramView.findViewById(2131296792);
      localView1 = paramView.findViewById(2131296793);
      localView2 = paramView.findViewById(2131296796);
      i = (((ViewGroup.LayoutParams)localObject1).height - (int)(8.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float)) * 31 / 132;
      localView2.setPadding((int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float), ((ViewGroup.LayoutParams)localObject1).height - i - (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float), (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float), (int)(4.0F * this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_Float));
      localObject1 = (ProgressBar)paramView.findViewById(2131296797);
      localView1.setVisibility(8);
      paramViewGroup.setVisibility(8);
      localObject2 = (ImageView)paramView.findViewById(2131296795);
      if (paramInt != 0) {
        break label417;
      }
      if (SkinEngine.getInstances().getSkinRootPath() != null) {
        break label368;
      }
      i = 1;
      label212:
      localURLImageView.setImageResource(2130837697);
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.d == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.d.equals("none"))) && ((i == 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.d != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.d.length() != 0) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.d))))) {
        break label374;
      }
      localView1.setVisibility(0);
      localURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364371, new Object[] { Integer.valueOf(paramInt + 1) }));
      this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_Int = 0;
      label334:
      paramView.setTag(null);
    }
    label417:
    label811:
    label1069:
    for (;;)
    {
      paramViewGroup.setOnClickListener(new acr(this));
      return paramView;
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903107, paramViewGroup, false);
      break;
      label368:
      i = 0;
      break label212;
      label374:
      localView1.setVisibility(8);
      localURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364372, new Object[] { Integer.valueOf(paramInt + 1) }));
      break label334;
      ChatBackgroundInfo localChatBackgroundInfo = (ChatBackgroundInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt - 1);
      paramView.setTag(localChatBackgroundInfo);
      if (localChatBackgroundInfo.type.equals("1")) {
        ((ImageView)localObject2).setVisibility(0);
      }
      Object localObject3;
      int k;
      for (;;)
      {
        localObject2 = EmosmUtils.insertMtype("VIP_other", localChatBackgroundInfo.thumb_url);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.getResources().getDrawable(2130837697);
        try
        {
          localObject2 = URLDrawable.getDrawable(new URL("chatbg_pro", null, (String)localObject2), (Drawable)localObject3, (Drawable)localObject3);
          ((URLDrawable)localObject2).addHeader("chatbg_id", localChatBackgroundInfo.id);
          localURLImageView.setImageDrawable((Drawable)localObject2);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaUtilArrayList.size() > 0)
          {
            i = 0;
            int j = 0;
            for (;;)
            {
              k = i;
              if (j >= this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaUtilArrayList.size()) {
                break;
              }
              if (localChatBackgroundInfo.id.equals(((ChatBackgroundInfo)this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_JavaUtilArrayList.get(j)).id)) {
                i = 1;
              }
              j += 1;
            }
            ((ImageView)localObject2).setVisibility(8);
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          for (;;)
          {
            localMalformedURLException.printStackTrace();
          }
          k = 0;
        }
      }
      HttpDownloadFileProcessor localHttpDownloadFileProcessor;
      if (k != 0)
      {
        String str = AppConstants.bb + localChatBackgroundInfo.id + ".png";
        localObject3 = new File(str);
        localHttpDownloadFileProcessor = (HttpDownloadFileProcessor)this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.app.a().a(localChatBackgroundInfo.url);
        if ((((File)localObject3).exists()) && ((localHttpDownloadFileProcessor == null) || (localHttpDownloadFileProcessor.f())))
        {
          localView2.setVisibility(8);
          paramViewGroup.setVisibility(8);
          localURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364372, new Object[] { Integer.valueOf(paramInt + 1) }));
          if (str.equals(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.d))
          {
            if ((!localChatBackgroundInfo.type.equals("1")) || (this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_ComTencentMobileqqAppSVIPHandler.c() >= 1)) {
              break label845;
            }
            localView1.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_b_of_type_Int = paramInt;
          }
        }
      }
      for (;;)
      {
        if (paramInt != this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label1069;
        }
        ChatBackgroundSettingActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity).setVisibility(8);
        break;
        label845:
        localView1.setVisibility(0);
        localURLImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364371, new Object[] { Integer.valueOf(paramInt + 1) }));
        break label811;
        if ((localHttpDownloadFileProcessor == null) || (localHttpDownloadFileProcessor.f()))
        {
          paramViewGroup.setVisibility(0);
          localView2.setVisibility(8);
          paramViewGroup.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364373, new Object[] { Integer.valueOf(paramInt + 1) }));
        }
        else
        {
          localView2.setVisibility(0);
          paramViewGroup.setVisibility(8);
          localView2.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364374, new Object[] { Integer.valueOf(paramInt + 1) }));
          ((ProgressBar)localObject1).setProgress((int)(((ProgressBar)localObject1).getMax() * ((float)localHttpDownloadFileProcessor.b() / (float)localHttpDownloadFileProcessor.a())));
          continue;
          paramViewGroup.setVisibility(0);
          localView2.setVisibility(8);
          paramViewGroup.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityChatBackgroundSettingActivity.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131364373, new Object[] { Integer.valueOf(paramInt + 1) }));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     acq
 * JD-Core Version:    0.7.0.1
 */