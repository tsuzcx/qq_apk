package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.PromotionEmoticonPkg;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dfj;
import java.io.File;
import java.net.URL;
import java.util.List;

public class RecommendEmoticonViewBinder
  extends EmoticonPanelViewBinder
  implements URLDrawableDownListener
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString = "RecommendEmoticonViewBinder";
  private static Drawable b;
  private static int o = 11;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  
  public RecommendEmoticonViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    super(paramContext, 8, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = ClubContentJsonTask.a(paramQQAppInterface);
  }
  
  protected int a(int paramInt)
  {
    return 2001;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839034);
    paramContext = paramContext.getResources().getDrawable(2130839035);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    if (b != null)
    {
      b.setCallback(null);
      b = null;
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    ClubContentJsonTask.PromotionEmoticonPkg localPromotionEmoticonPkg = (ClubContentJsonTask.PromotionEmoticonPkg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1 = (URLImageView)paramView.findViewById(2131298676);
    Object localObject2 = (Button)paramView.findViewById(2131298675);
    TextView localTextView = (TextView)paramView.findViewById(2131298674);
    if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839011);
    }
    if (b == null) {
      b = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839010);
    }
    localTextView.setText(StringUtil.a(localPromotionEmoticonPkg.c, o));
    ((URLImageView)localObject1).setImageDrawable(URLDrawable.getDrawable(ClubContentJsonTask.a.c + localPromotionEmoticonPkg.jdField_b_of_type_JavaLangString, jdField_a_of_type_AndroidGraphicsDrawableDrawable, b));
    ((URLImageView)localObject1).setURLDrawableDownListener(this);
    ((Button)localObject2).setText(localPromotionEmoticonPkg.d);
    ((Button)localObject2).setOnClickListener(new dfj(this, localPromotionEmoticonPkg));
    localObject2 = new Bundle();
    if (localPromotionEmoticonPkg.jdField_b_of_type_Int == 1) {
      localObject1 = "Ep_offer_info_index";
    }
    for (;;)
    {
      ((Bundle)localObject2).putString("key", (String)localObject1);
      ((Bundle)localObject2).putString("id", localPromotionEmoticonPkg.jdField_a_of_type_JavaLangString);
      paramView.setTag(localObject2);
      return;
      if (localPromotionEmoticonPkg.jdField_b_of_type_Int == 2) {
        localObject1 = "Ep_offer_info_detail";
      } else {
        localObject1 = "Ep_offer_info_activity";
      }
    }
  }
  
  public void a(ClubContentJsonTask.PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    boolean bool = true;
    switch (paramPromotionEmoticonPkg.jdField_b_of_type_Int)
    {
    default: 
      return;
    case 1: 
      EmojiHomeUiPlugin.openEmojiHomePage((BaseActivity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid());
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_offer_info_click_index", 0, 0, paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString, "", "", "");
      return;
    case 2: 
      if (paramPromotionEmoticonPkg.jdField_a_of_type_Int == 5) {}
      for (;;)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSid(), bool);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_offer_info_click_detail", 0, 0, paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString, "", "", "");
        return;
        bool = false;
      }
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramPromotionEmoticonPkg.e);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_offer_info_click_activity", 0, 0, paramPromotionEmoticonPkg.jdField_a_of_type_JavaLangString, "", "", "");
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ((URLImageView)paramView).setImageDrawable(b);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {}
    label155:
    label160:
    for (;;)
    {
      return;
      paramView = AbsDownloader.a(paramURLDrawable.getURL().toString());
      if (paramView != null) {}
      for (long l = paramView.length();; l = 0L)
      {
        if (l == 0L) {
          break label160;
        }
        if (NetworkUtil.a(((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo()))
        {
          paramView = new String[3];
          paramView[0] = "param_XGEmojiStoreDownloadFlow";
          paramView[1] = "param_XGFlow";
          paramView[2] = "param_Flow";
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
            break label155;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramView, l);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("RecommendEmoticonViewBinder", 2, "file length:" + l);
          return;
          paramView = new String[3];
          paramView[0] = "param_WIFIEmojiStoreDownloadFlow";
          paramView[1] = "param_WIFIFlow";
          paramView[2] = "param_Flow";
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmoticonViewBinder
 * JD-Core Version:    0.7.0.1
 */