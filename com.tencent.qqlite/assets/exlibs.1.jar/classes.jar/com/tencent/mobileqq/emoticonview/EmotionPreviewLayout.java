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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeyword;
import com.tencent.mobileqq.data.EmoticonKeywordForCloud;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import dew;
import dex;
import dey;
import dez;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmotionPreviewLayout
  extends LinearLayout
  implements View.OnClickListener
{
  static final int jdField_a_of_type_Int = 10000;
  public static String a;
  static final int jdField_b_of_type_Int = 10001;
  static final int c = 10002;
  static final int d = 3000;
  private static final int i = 66;
  float jdField_a_of_type_Float;
  Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public EditText a;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new dex(this);
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new dez(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  public List a;
  public String b;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  public List b;
  public int e;
  public int f = 0;
  final int g = 2;
  private int h;
  
  static
  {
    jdField_a_of_type_JavaLangString = EmotionPreviewLayout.class.getSimpleName();
  }
  
  public EmotionPreviewLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int j = (int)(10.0F * this.jdField_a_of_type_Float);
    setPadding(0, j, j, j);
    this.jdField_a_of_type_AndroidOsHandler = new dew(this);
    getBackground().setAlpha(204);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    EmoticonKeyword localEmoticonKeyword;
    int j;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt1)) {
      if (this.jdField_a_of_type_JavaUtilList.size() >= paramInt2)
      {
        if (paramInt1 >= paramInt2) {
          break label598;
        }
        localEmoticonKeyword = (EmoticonKeyword)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        j = 4;
        if (!localEmoticonKeyword.isSound) {
          break label599;
        }
        j = 12;
      }
    }
    label598:
    label599:
    for (boolean bool1 = false;; bool1 = true)
    {
      for (;;)
      {
        Object localObject3 = Integer.toString(j);
        try
        {
          localObject1 = new URL("emotion_pic", "big_img", localEmoticonKeyword.epId + "_" + localEmoticonKeyword.eId);
          boolean bool3 = a(localEmoticonKeyword);
          if ((b(localEmoticonKeyword)) && (!bool3))
          {
            bool2 = true;
            if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {
              this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838986));
            }
            if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null)) {
              this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838987));
            }
            localObject1 = URLDrawable.getDrawable((URL)localObject1, (Drawable)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Drawable)this.jdField_b_of_type_JavaLangRefWeakReference.get(), bool1);
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
              localObject3 = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903061, null);
              ImageView localImageView = (ImageView)((View)localObject3).findViewById(2131296544);
              localImageView.setTag(localEmoticonKeyword);
              localImageView.setAdjustViewBounds(false);
              localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
              localImageView.setContentDescription("原创表情" + localEmoticonKeyword.name);
              localImageView.setImageDrawable((Drawable)localObject1);
              localImageView.setOnClickListener(this);
              Object localObject1 = (RelativeLayout.LayoutParams)localImageView.getLayoutParams();
              ((RelativeLayout.LayoutParams)localObject1).width = ((int)(66.0F * this.jdField_a_of_type_Float));
              ((RelativeLayout.LayoutParams)localObject1).height = ((int)(66.0F * this.jdField_a_of_type_Float));
              ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
              if (localEmoticonKeyword.isSound) {
                ((ImageView)((View)localObject3).findViewById(2131296545)).setVisibility(0);
              }
              addView((View)localObject3);
              this.e += 1;
              paramInt1 += 1;
              break;
              paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
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
      return;
    }
  }
  
  private void c()
  {
    a(this.e, 4);
    if ((this.e < 4) && (this.h > this.e))
    {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null) {}
      for (Object localObject1 = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString(); (localObject1 == null) || (localObject1 == ""); localObject1 = null) {
        return;
      }
      localObject1 = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903061, null);
      Object localObject2 = (ImageView)((View)localObject1).findViewById(2131296544);
      ((ImageView)localObject2).setAdjustViewBounds(false);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageView)localObject2).setContentDescription("原创表情loading");
      ((ImageView)localObject2).setOnClickListener(this);
      ((ImageView)localObject2).setImageResource(2130838986);
      localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).width = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject2).height = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      localObject2 = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
      ((ProgressBar)localObject2).setIndeterminateDrawable(getResources().getDrawable(2130837910));
      int j = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.bottomMargin = j;
      localLayoutParams.addRule(13);
      ((ViewGroup)localObject1).addView((View)localObject2, localLayoutParams);
      ((ProgressBar)localObject2).setVisibility(0);
      addView((View)localObject1);
      localObject1 = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      for (;;)
      {
        localObject2 = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
        ((EmosmHandler)localObject2).a(new dey(this, (EmosmHandler)localObject2));
        ((EmosmHandler)localObject2).a(this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString(), (ArrayList)localObject1);
        return;
        localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add(((EmoticonKeyword)((Iterator)localObject2).next()).eId);
        }
      }
    }
    if (this.e > 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000));
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, EditText paramEditText)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      break label4;
    }
    label4:
    while ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    if ((getChildCount() > 0) && (!(getChildAt(getChildCount() - 1).getTag() instanceof EmoticonKeyword))) {
      removeView(getChildAt(getChildCount() - 1));
    }
    int j = this.e;
    int m;
    int n;
    label101:
    EmoticonKeywordForCloud localEmoticonKeywordForCloud;
    if (this.jdField_b_of_type_JavaUtilList.size() + this.e <= 4)
    {
      m = this.jdField_b_of_type_JavaUtilList.size();
      n = 0;
      if (n >= m) {
        break label555;
      }
      localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)this.jdField_b_of_type_JavaUtilList.get(n);
      if (localEmoticonKeywordForCloud != null) {
        break label149;
      }
    }
    label149:
    View localView;
    for (;;)
    {
      n += 1;
      break label101;
      m = 4 - this.e;
      break;
      Object localObject2 = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      ((PicEmoticonInfo)localObject2).c = 6;
      ((PicEmoticonInfo)localObject2).a = localEmoticonKeywordForCloud;
      ((PicEmoticonInfo)localObject2).h = 3;
      localView = inflate(this.jdField_a_of_type_AndroidContentContext, 2130903061, null);
      localView.setTag(localEmoticonKeywordForCloud);
      Object localObject1 = (ImageView)localView.findViewById(2131296544);
      ((ImageView)localObject1).setTag(localEmoticonKeywordForCloud);
      ((ImageView)localObject1).setAdjustViewBounds(false);
      ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
      ((ImageView)localObject1).setContentDescription("原创表情" + localEmoticonKeywordForCloud.name);
      ((ImageView)localObject1).setOnClickListener(this);
      localObject2 = ((PicEmoticonInfo)localObject2).a(true);
      int k = j;
      if (localObject2 != null)
      {
        ((URLDrawable)localObject2).setTag(localEmoticonKeywordForCloud);
        if (((URLDrawable)localObject2).getStatus() == 1) {
          break label522;
        }
        ((URLDrawable)localObject2).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
        addView(localView);
        localEmoticonKeywordForCloud.loadedType = 1;
        ProgressBar localProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
        localProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130837910));
        k = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, k);
        localLayoutParams.bottomMargin = k;
        localLayoutParams.leftMargin = k;
        localLayoutParams.addRule(13);
        ((ViewGroup)localView).addView(localProgressBar, localLayoutParams);
        localProgressBar.setVisibility(0);
        this.f += 1;
        label424:
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
        k = j;
      }
      localObject1 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject1).height = ((int)(this.jdField_a_of_type_Float * 66.0F));
      ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
      if (localEmoticonKeywordForCloud.isSound) {
        ((ImageView)localView.findViewById(2131296545)).setVisibility(0);
      }
      this.e += 1;
      j = k;
    }
    label522:
    if (getChildCount() < j) {
      j = getChildCount();
    }
    for (;;)
    {
      addView(localView, j);
      j += 1;
      localEmoticonKeywordForCloud.loadedType = 2;
      break label424;
      label555:
      if (this.f != 0) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      return;
    }
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
  
  public void b()
  {
    int m = getChildCount();
    int k = 0;
    int j = 0;
    if (k < m)
    {
      if (!(getChildAt(k) instanceof ViewGroup)) {}
      for (;;)
      {
        k += 1;
        break;
        ViewGroup localViewGroup = (ViewGroup)getChildAt(k);
        if ((localViewGroup.getTag() instanceof EmoticonKeywordForCloud))
        {
          EmoticonKeywordForCloud localEmoticonKeywordForCloud = (EmoticonKeywordForCloud)localViewGroup.getTag();
          if (localEmoticonKeywordForCloud.loadedType == 2)
          {
            if ((localViewGroup.getChildAt(localViewGroup.getChildCount() - 1) instanceof ProgressBar)) {
              localViewGroup.getChildAt(localViewGroup.getChildCount() - 1).setVisibility(8);
            }
            if (k > j)
            {
              removeView(localViewGroup);
              addView(localViewGroup, j);
            }
            j += 1;
          }
          for (;;)
          {
            break;
            if (localEmoticonKeywordForCloud.loadedType == 3)
            {
              if ((localViewGroup.getChildAt(localViewGroup.getChildCount() - 1) instanceof ProgressBar)) {
                localViewGroup.getChildAt(localViewGroup.getChildCount() - 1).setVisibility(8);
              }
              removeView(localViewGroup);
              addView(localViewGroup);
            }
          }
        }
        j += 1;
      }
    }
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
    if (paramView.getId() == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_icon", 0, 1, "", "", "", "");
      removeView(paramView);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
      c();
    }
    while ((this.jdField_a_of_type_AndroidWidgetEditText == null) || ("" == this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString())) {
      return;
    }
    if ((paramView.getTag() instanceof Emoticon)) {}
    for (paramView = (EmoticonKeyword)paramView.getTag();; paramView = null)
    {
      if (paramView != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate", 0, 1, "", "", "", "");
        if (!(paramView instanceof EmoticonKeywordForCloud)) {
          break label324;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_more", 0, 1, "", "", "", "");
        if (((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramView.epId) == null)
        {
          ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(39)).a(paramView.epId, EmojiManager.c, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
          ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramView.epId).type = 3;
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(10000);
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_AndroidWidgetEditText != null)
        {
          this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().clear();
          this.jdField_a_of_type_AndroidWidgetEditText.setText("");
        }
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
        setVisibility(8);
        return;
        label324:
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_associate_local", 0, 1, "", "", "", "");
      }
    }
  }
  
  public void setEmoticonKeywordList(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.h = paramInt;
  }
  
  public void setVisibility(int paramInt)
  {
    String str;
    if (paramInt == 0) {
      if (this.jdField_a_of_type_AndroidWidgetEditText != null)
      {
        str = this.jdField_a_of_type_AndroidWidgetEditText.getEditableText().toString();
        this.jdField_b_of_type_JavaLangString = str;
        this.e = 0;
        this.f = 0;
        a(0, 2);
        if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate_local", 0, 1, "", "", "", "");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "View_associate", 0, 1, "", "", "", "");
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 10000), 3000L);
      }
    }
    for (;;)
    {
      super.setVisibility(paramInt);
      return;
      str = "";
      break;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPreviewLayout
 * JD-Core Version:    0.7.0.1
 */