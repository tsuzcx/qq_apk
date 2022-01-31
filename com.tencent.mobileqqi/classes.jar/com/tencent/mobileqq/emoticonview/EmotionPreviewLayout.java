package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import fth;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class EmotionPreviewLayout
  extends LinearLayout
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 10000;
  private static String jdField_a_of_type_JavaLangString = EmotionPreviewLayout.class.getSimpleName();
  private static final int jdField_b_of_type_Int = 3000;
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  
  public EmotionPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int i = (int)(10.0F * this.jdField_a_of_type_Float);
    setPadding(0, i, i, i);
    this.jdField_a_of_type_AndroidOsHandler = new fth(this);
  }
  
  private void a()
  {
    EmoticonKeyword localEmoticonKeyword;
    int i;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        localEmoticonKeyword = (EmoticonKeyword)localIterator.next();
        i = 4;
        if (!localEmoticonKeyword.isSound) {
          break label620;
        }
        i = 12;
      }
    }
    label620:
    for (boolean bool1 = false;; bool1 = true)
    {
      for (;;)
      {
        Object localObject3 = Integer.toString(i);
        try
        {
          localObject1 = new URL("emotion_pic", "big_img", localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
          boolean bool3 = a(localEmoticonKeyword);
          if ((b(localEmoticonKeyword)) && (!bool3))
          {
            bool2 = true;
            if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
              this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839112));
            }
            if ((this.b == null) || (this.b.get() == null)) {
              this.b = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839113));
            }
            localObject1 = URLDrawable.getDrawable((URL)localObject1, (Drawable)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Drawable)this.b.get(), bool1);
            if (((URLDrawable)localObject1).getStatus() != 1)
            {
              ((URLDrawable)localObject1).setTag(localEmoticonKeyword);
              ((URLDrawable)localObject1).addHeader("my_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              ((URLDrawable)localObject1).addHeader("emo_tasks", (String)localObject3);
              ((URLDrawable)localObject1).addHeader("image_dl_extra_info", Boolean.toString(bool2));
              if (!bool3) {}
            }
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          try
          {
            for (;;)
            {
              ((URLDrawable)localObject1).downloadImediatly();
              localObject3 = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903086, null);
              ImageView localImageView = (ImageView)((View)localObject3).findViewById(2131231102);
              localImageView.setTag(localEmoticonKeyword);
              localImageView.setAdjustViewBounds(false);
              localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
              localImageView.setContentDescription("原创表情" + localEmoticonKeyword.name);
              localImageView.setImageDrawable((Drawable)localObject1);
              localImageView.setOnClickListener(this);
              Object localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 70.0F));
              ((RelativeLayout.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 70.0F));
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
              if (localEmoticonKeyword.isSound) {
                ((ImageView)((View)localObject3).findViewById(2131231103)).setVisibility(0);
              }
              addView((View)localObject3);
              break;
              localMalformedURLException = localMalformedURLException;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_a_of_type_JavaLangString, 2, "getDrawable ,", localMalformedURLException);
              }
              Object localObject2 = null;
            }
            boolean bool2 = false;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "showEmotions oom,emoj id=" + localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
              }
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate", 0, 1, "", "", "", "");
      return;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = null;
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public boolean a(EmoticonKeyword paramEmoticonKeyword)
  {
    if (paramEmoticonKeyword.jobType == 1) {
      paramEmoticonKeyword = EmosmUtils.getQFaceGifPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);
    }
    while (paramEmoticonKeyword != null)
    {
      paramEmoticonKeyword = new File(paramEmoticonKeyword);
      if ((paramEmoticonKeyword.exists()) && (paramEmoticonKeyword.isFile()))
      {
        return true;
        paramEmoticonKeyword = EmosmUtils.getEmoticonEncryptPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public boolean b(EmoticonKeyword paramEmoticonKeyword)
  {
    if (paramEmoticonKeyword.jobType == 1) {
      paramEmoticonKeyword = EmosmUtils.getEmoticonPreviewPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);
    }
    while (paramEmoticonKeyword != null)
    {
      paramEmoticonKeyword = new File(paramEmoticonKeyword);
      if ((paramEmoticonKeyword.exists()) && (paramEmoticonKeyword.isFile()))
      {
        return true;
        paramEmoticonKeyword = EmosmUtils.getEmoticonAIOPreviewPath(paramEmoticonKeyword.epId, paramEmoticonKeyword.eId);
      }
      else
      {
        return false;
      }
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    paramView = (Emoticon)paramView.getTag();
    if (paramView != null)
    {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
        this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 1, "", "", "", "");
    }
    setVisibility(8);
  }
  
  public void setEmoticonKeywordList(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt == 0) {
      a();
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewLayout
 * JD-Core Version:    0.7.0.1
 */