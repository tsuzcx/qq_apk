package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.HexUtil;
import java.io.File;
import java.util.LinkedList;

public class AlbumWorkSpace
  extends Workspace
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public AlbumWorkSpace(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setDrawingCacheEnabled(false);
  }
  
  public AlbumWorkSpace(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    setDrawingCacheEnabled(false);
  }
  
  private void c(int paramInt)
  {
    int j = this.jdField_a_of_type_JavaUtilLinkedList.size();
    int i = 0;
    if (i < j)
    {
      AlbumImageProxy localAlbumImageProxy = (AlbumImageProxy)getChildAt(i);
      File localFile;
      if (Math.abs(i - paramInt) <= 1)
      {
        String str3 = (String)this.jdField_a_of_type_JavaUtilLinkedList.get(i);
        int k = CardHandler.c(this.jdField_a_of_type_AndroidContentContext);
        String str2 = CardHandler.a(HexUtil.a(str3), k);
        localFile = new File(str2);
        if ((!localFile.exists()) || ((0L == localFile.length()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str3 + k) != null))) {}
        try
        {
          if ((this.jdField_a_of_type_JavaLangString != null) && (!"".equals(this.jdField_a_of_type_JavaLangString))) {
            break label231;
          }
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          label159:
          this.jdField_a_of_type_JavaLangString = str1;
          str1 = HexUtil.a(str3);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, str2, str1, (short)k, 0, 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            String str1;
            localException.printStackTrace();
            if (localFile.exists()) {
              localFile.delete();
            }
          }
        }
        localAlbumImageProxy.setCacheImageBmp(true);
        if ((i != paramInt) && (localAlbumImageProxy.getScale() != 1.0F)) {
          localAlbumImageProxy.zoomTo(1.0F);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label231:
        str1 = this.jdField_a_of_type_JavaLangString;
        break label159;
        localAlbumImageProxy.setCacheImageBmp(false);
      }
    }
  }
  
  public String a()
  {
    return (String)this.jdField_a_of_type_JavaUtilLinkedList.get(this.c);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilLinkedList.size()))
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramInt);
      removeViewAt(paramInt);
      int i = paramInt;
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() == paramInt)
      {
        i = paramInt;
        if (paramInt > 0) {
          i = paramInt - 1;
        }
      }
      setCurrentScreen(i);
      postInvalidate();
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
      {
        if (((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).equals(paramString)) {
          a(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  public void b(int paramInt)
  {
    b();
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    int j = this.d;
    if (i != this.c) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (this.d != i)
      {
        localObject = a();
        if (localObject != null) {
          ((Workspace.OnScreenChangeListener)localObject).b(i);
        }
        this.d = i;
      }
      this.e = i;
      Object localObject = getFocusedChild();
      if ((localObject != null) && (paramInt != 0) && (localObject == getChildAt(this.c))) {
        ((View)localObject).clearFocus();
      }
      paramInt = getWidth() * i - getScrollX();
      this.jdField_a_of_type_AndroidWidgetScroller.startScroll(getScrollX(), 0, paramInt, 0, Math.abs(paramInt));
      invalidate();
      if (j != i) {
        c(i);
      }
      return;
    }
  }
  
  public void b(String paramString)
  {
    int i = this.c - 1;
    while (i <= this.c + 1)
    {
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilLinkedList.size()) && (paramString.equals(HexUtil.a((String)this.jdField_a_of_type_JavaUtilLinkedList.get(i)))))
      {
        AlbumImageProxy localAlbumImageProxy = (AlbumImageProxy)getChildAt(i);
        localAlbumImageProxy.setCacheImageBmp(true);
        localAlbumImageProxy.postInvalidate();
      }
      i += 1;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      this.jdField_a_of_type_Boolean = true;
      this.h = 1;
      View localView = getChildAt(this.d);
      return (this.h != 0) && (!a(localView, true, paramMotionEvent)) && (!a(localView, false, paramMotionEvent));
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void setCurrentScreen(int paramInt)
  {
    super.setCurrentScreen(paramInt);
    c(paramInt);
  }
  
  public void setFileKeyList(LinkedList paramLinkedList, int paramInt)
  {
    if (paramLinkedList.size() - this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      int i = this.jdField_a_of_type_JavaUtilLinkedList.size();
      if (i < paramLinkedList.size())
      {
        Object localObject = (String)paramLinkedList.get(i);
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        if (Math.abs(i - paramInt) < 2) {}
        for (boolean bool = true;; bool = false)
        {
          localObject = new AlbumImageProxy(localQQAppInterface, localContext, (String)localObject, 2130837934, bool);
          ((AlbumImageProxy)localObject).SetMinZoom(0.5F);
          addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
          i += 1;
          break;
        }
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList = paramLinkedList;
    setCurrentScreen(paramInt);
  }
  
  public void setUin(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AlbumWorkSpace
 * JD-Core Version:    0.7.0.1
 */