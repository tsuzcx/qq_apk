package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bkj;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MultiVideoEnterPage
{
  static final String jdField_a_of_type_JavaLangString = "MultiVideoEnterPage";
  long jdField_a_of_type_Long;
  Resources jdField_a_of_type_AndroidContentResResources = null;
  private View jdField_a_of_type_AndroidViewView = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  MultiVideoMembersHolderUI jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference = null;
  private View jdField_b_of_type_AndroidViewView = null;
  TextView jdField_b_of_type_AndroidWidgetTextView = null;
  
  public MultiVideoEnterPage(Context paramContext, long paramLong, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    paramContext = (AVActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramContext != null) {
      this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private void b()
  {
    int i = 0;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131232246);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_b_of_type_AndroidViewView.findViewById(2131232255));
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI = ((MultiVideoMembersHolderUI)this.jdField_a_of_type_AndroidViewView.findViewById(2131232247));
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a(this.jdField_a_of_type_Long);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131232256));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232252));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131560250);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131560262);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131232249));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131232250));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131232251));
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a() == 1) {
      i = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427652);
    }
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      localLayoutParams.topMargin = i;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_JavaLangRunnable = new bkj(this);
      UITools.a((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131232254), this.jdField_a_of_type_AndroidContentResResources.getString(2131560170));
      return;
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a() == 0) {
        i = this.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131427651);
      }
    }
  }
  
  private void c()
  {
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoEnterPage", 2, "setNetTips-->context is null");
      }
      return;
    }
    int i = NetworkUtil.a(localContext);
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "setNetTips-->NetInfo=" + i);
    }
    if (i == 2) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131560263);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
      if ((i == 3) || (i == 4)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131560264);
      } else if (i == 1) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131560255);
      } else if (i == 0) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      } else if (QLog.isColorLevel()) {
        QLog.e("MultiVideoEnterPage", 2, "RemoveTipsRunnable-->Wrong Type of NetTips.NetInfo=" + i);
      }
    }
  }
  
  public View a()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).inflate(2130903352, null);
    b();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI != null) {
      this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.b();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("MultiVideoEnterPage", 2, "refreshHeadbitmap-->mMemberUi is null");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoEnterPage", 2, "setNetTips-->type=" + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramInt == 0)
    {
      paramInt = 2131560145;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        paramInt = 2131560144;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        break;
      }
      if (paramInt == 1)
      {
        paramInt = 2131560143;
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MultiVideoEnterPage", 2, "setNetTips-->Wrong Type.Type=" + paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    int i = paramArrayList.size();
    if (i > 0)
    {
      String str = ((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getString(2131560250) + "(" + i + ")";
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a(paramArrayList, 12);
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPage
 * JD-Core Version:    0.7.0.1
 */