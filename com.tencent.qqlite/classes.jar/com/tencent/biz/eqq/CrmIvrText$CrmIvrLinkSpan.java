package com.tencent.biz.eqq;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.QQText.LinkSpan;
import com.tencent.mobileqq.widget.QQToast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class CrmIvrText$CrmIvrLinkSpan
  extends QQText.LinkSpan
{
  public CrmIvrText$CrmIvrLinkSpan(CrmIvrText paramCrmIvrText, String paramString)
  {
    super(paramCrmIvrText, paramString);
  }
  
  public void onClick(View paramView)
  {
    if (CrmUtils.a.matcher(this.jdField_a_of_type_JavaLangString).find())
    {
      this.jdField_a_of_type_ComTencentBizEqqCrmIvrText.a.getApplication();
      QQToast.a(MobileQQ.getContext(), 2131364498, 0).a();
      return;
    }
    super.onClick(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText.CrmIvrLinkSpan
 * JD-Core Version:    0.7.0.1
 */