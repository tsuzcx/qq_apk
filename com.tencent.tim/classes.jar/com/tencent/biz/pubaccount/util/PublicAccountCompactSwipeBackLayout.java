package com.tencent.biz.pubaccount.util;

import android.content.Context;
import android.graphics.Rect;
import com.tencent.mobileqq.colornote.swipeback.SwipePostTableLayout;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import odu;

public class PublicAccountCompactSwipeBackLayout
  extends SwipePostTableLayout
{
  protected WebViewFragment a;
  protected odu a;
  private boolean awg = true;
  private boolean awh;
  
  public PublicAccountCompactSwipeBackLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Odu = new odu();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Odu.a(paramString, new Rect(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public void pa(String paramString)
  {
    this.jdField_a_of_type_Odu.pv(paramString);
  }
  
  public void qu(boolean paramBoolean)
  {
    this.awg = paramBoolean;
  }
  
  public void qv(boolean paramBoolean)
  {
    this.awh = paramBoolean;
  }
  
  public void setWebViewFragment(WebViewFragment paramWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment = paramWebViewFragment;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountCompactSwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */