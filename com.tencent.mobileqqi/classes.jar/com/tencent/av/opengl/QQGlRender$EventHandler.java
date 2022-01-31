package com.tencent.av.opengl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class QQGlRender$EventHandler
  extends Handler
{
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public QQGlRender$EventHandler(QQGlRender paramQQGlRender1, QQGlRender paramQQGlRender2, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQGlRender2);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQGlRender localQQGlRender = (QQGlRender)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    switch (paramMessage.what)
    {
    default: 
      if (localQQGlRender != null) {
        localQQGlRender.requestRender();
      }
      break;
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.m_view.get() == null);
    ((QQGlView)this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.m_view.get()).a(this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.mTextureW, this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.mTextureH, this.jdField_a_of_type_ComTencentAvOpenglQQGlRender.mAngle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.QQGlRender.EventHandler
 * JD-Core Version:    0.7.0.1
 */