package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class StructMsgForHypertext$HyperSpannable
  extends URLSpan
{
  long jdField_a_of_type_Long = -1L;
  private StructMsgForHypertext.Hypertext jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext = null;
  
  public StructMsgForHypertext$HyperSpannable(StructMsgForHypertext paramStructMsgForHypertext, StructMsgForHypertext.Hypertext paramHypertext)
  {
    super(paramHypertext.b);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext = paramHypertext;
  }
  
  public void onClick(View paramView)
  {
    if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long < 1000L) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      } while ((this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext == null) || ((paramView != null) && ((paramView instanceof StructMsgForHypertext.HyperTextView)) && (!((StructMsgForHypertext.HyperTextView)paramView).a())));
      if (("web".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b)) || ("auto".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b)) || ("replyMsg".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b)) || ("replyCmd".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b)) || ("plugin".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b)))
      {
        new StructMsgClickHandler(paramView).a(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.a, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.c, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.d);
        this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.mHyperClick = true;
        return;
      }
    } while (!"app".equals(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.b));
    localContext = paramView.getContext();
    PackageManager localPackageManager = localContext.getPackageManager();
    paramView = "";
    localView = paramView;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.d)) {
          continue;
        }
        localView = paramView;
        localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.c;
        localView = paramView;
        i = ((String)localObject).indexOf("://");
        if (i != -1) {
          continue;
        }
        localView = paramView;
        if (localPackageManager.getPackageInfo((String)localObject, 1) == null) {
          continue;
        }
        localView = paramView;
        localObject = localPackageManager.getLaunchIntentForPackage((String)localObject);
        localView = paramView;
        if (!TextUtils.isEmpty(paramView))
        {
          localView = paramView;
          ((Intent)localObject).setData(Uri.parse(paramView));
        }
        localView = paramView;
        localContext.startActivity((Intent)localObject);
      }
      catch (Exception paramView)
      {
        Object localObject;
        int i;
        String str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HypertextMsg", 2, paramView.getMessage(), paramView);
        if ((TextUtils.isEmpty(localView)) || ((!localView.startsWith("http://")) && (!localView.startsWith("https://")))) {
          continue;
        }
        paramView = new Intent(localContext, QQBrowserActivity.class);
        paramView.putExtra("url", localView);
        localContext.startActivity(paramView);
        continue;
      }
      this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext.mHyperClick = true;
      return;
      localView = paramView;
      localObject = this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForHypertext$Hypertext.d;
      continue;
      localView = paramView;
      str = ((String)localObject).substring(0, i);
      localView = paramView;
      paramView = ((String)localObject).substring(i + 3);
      localObject = str;
      continue;
      localView = paramView;
      if (!TextUtils.isEmpty(paramView))
      {
        localView = paramView;
        if (!paramView.startsWith("http://"))
        {
          localView = paramView;
          if (!paramView.startsWith("https://")) {}
        }
        else
        {
          localView = paramView;
          localObject = new Intent(localContext, QQBrowserActivity.class);
          localView = paramView;
          ((Intent)localObject).putExtra("url", paramView);
          localView = paramView;
          localContext.startActivity((Intent)localObject);
        }
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.StructMsgForHypertext.HyperSpannable
 * JD-Core Version:    0.7.0.1
 */