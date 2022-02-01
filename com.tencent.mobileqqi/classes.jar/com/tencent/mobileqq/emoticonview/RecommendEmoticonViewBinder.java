package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fpb;
import java.io.File;
import java.net.URL;
import java.util.List;

public class RecommendEmoticonViewBinder
  extends EmoticonPanelViewBinder
  implements View.OnClickListener, URLDrawableDownListener
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString = "RecommendEmoticonViewBinder";
  private static Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private static Drawable c;
  private static Drawable d;
  private static int o = 11;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private String jdField_b_of_type_JavaLangString;
  
  public RecommendEmoticonViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    super(paramContext, 8, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected int a(int paramInt)
  {
    int i = -1;
    if (paramInt == b() - 1) {
      i = 2002;
    }
    while (paramInt >= b() - 1) {
      return i;
    }
    return 2001;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839163);
    paramContext = paramContext.getResources().getDrawable(2130839164);
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
    if (jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    }
    if (c != null)
    {
      c.setCallback(null);
      c = null;
    }
    if (d != null)
    {
      d.setCallback(null);
      d = null;
    }
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = a(paramInt);
        if (i != 2001) {
          break;
        }
      } while (paramInt > b() - 2);
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      URLImageView localURLImageView = (URLImageView)paramView.findViewById(2131233324);
      Button localButton = (Button)paramView.findViewById(2131233323);
      paramView = (TextView)paramView.findViewById(2131233322);
      if (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839141);
      }
      if (jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
        jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839140);
      }
      paramInt = localSTRecommendTabInfo.u32_tab_id.get();
      paramView.setText(StringUtil.a(localSTRecommendTabInfo.str_tab_name.get(), o));
      if (localSTRecommendTabInfo.i32_tab_type.get() == 5) {}
      paramView = EmosmUtils.getRecommendBackgroundUrl(paramInt);
      if ((paramView != null) && (!"".equals(paramView)))
      {
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, jdField_a_of_type_AndroidGraphicsDrawableDrawable, jdField_b_of_type_AndroidGraphicsDrawableDrawable));
        localURLImageView.setURLDrawableDownListener(this);
      }
      for (;;)
      {
        localButton.setOnClickListener(new fpb(this));
        return;
        localURLImageView.setImageDrawable(jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      }
    } while ((i != 2002) || (paramInt != b() - 1));
    if (this.jdField_b_of_type_JavaLangString == null) {
      this.jdField_b_of_type_JavaLangString = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ((Button)paramView.findViewById(2131231610)).setOnClickListener(this);
    if (c == null) {
      c = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839127);
    }
    if (d == null) {
      d = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839126);
    }
    paramView = (URLImageView)paramView.findViewById(2131233324);
    paramView.setImageDrawable(URLDrawable.getDrawable(this.jdField_b_of_type_JavaLangString, c, d));
    paramView.setURLDrawableDownListener(this);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
        i = this.jdField_a_of_type_JavaUtilList.size() + 1;
      }
    }
    return i;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {}
    label152:
    label157:
    for (;;)
    {
      return;
      paramView = AbsDownloader.a(paramURLDrawable.getURL().toString());
      if (paramView != null) {}
      for (long l = paramView.length();; l = 0L)
      {
        if (l == 0L) {
          break label157;
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
            break label152;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecommendEmoticonViewBinder
 * JD-Core Version:    0.7.0.1
 */