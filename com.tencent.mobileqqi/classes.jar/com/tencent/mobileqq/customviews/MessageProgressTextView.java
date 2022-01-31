package com.tencent.mobileqq.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.AIOSendMask;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.qphone.base.util.QLog;
import frs;

public class MessageProgressTextView
  extends TextView
{
  private static final String jdField_a_of_type_JavaLangString = "ProgressTextView";
  public static boolean a;
  private static final int d = 0;
  int jdField_a_of_type_Int;
  private MessageProgressTextView.ProgressListener jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener;
  private BaseTransProcessor jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor;
  public frs a;
  int b;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public MessageProgressTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public MessageProgressTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == null) {}
    label222:
    do
    {
      int i;
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() < 100) && (paramInt1 >= 100)) {
          i = 100;
        }
        do
        {
          this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a(i);
          paramInt1 = Math.max(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d(), 0);
          long l = 50L;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.d() < 0) {
            l = 1000L;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() > paramInt1) {
            break label222;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProgressTextView", 2, "currentProgress " + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
          }
          setProgress(i);
          if (this.jdField_a_of_type_Frs != null) {
            break;
          }
          this.jdField_a_of_type_Frs = new frs(this, i, paramInt2);
          postDelayed(this.jdField_a_of_type_Frs, l);
          return;
          i = paramInt1;
        } while (paramInt1 < 100);
        this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = null;
        return;
      } while (paramInt2 == 1);
      this.jdField_a_of_type_Frs.b(paramInt2);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "doUpdateCurrentProgress ,currentProgress:" + i + " receiveProgress " + paramInt1 + "addProgress" + paramInt2 + " processor.getKey() " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a() + " processor " + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
      }
    } while (paramInt1 <= this.jdField_c_of_type_Int);
    setProgress(paramInt1);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener.a();
    }
    return 0;
  }
  
  public MessageProgressTextView.ProgressListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateProgress processor:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a(), 1);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProgressTextView", 2, "updateToFinish processor:" + this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor.a();
      int j = Math.max(1, (100 - i) / 10);
      if (QLog.isColorLevel()) {
        QLog.d("ProgressTextView", 2, "updateToFinish addProgress:" + j + ",currentProgress:" + i);
      }
      a(i, j);
    }
  }
  
  public void setDisplayInTextView(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setProcessor(BaseTransProcessor paramBaseTransProcessor)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor == paramBaseTransProcessor) {
      return;
    }
    if (this.jdField_a_of_type_Frs != null)
    {
      removeCallbacks(this.jdField_a_of_type_Frs);
      this.jdField_a_of_type_Frs = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = paramBaseTransProcessor;
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener.a(paramInt);
    }
    if (this.jdField_b_of_type_Boolean) {
      setText(paramInt + "%");
    }
    for (;;)
    {
      Drawable localDrawable = getBackground();
      if (localDrawable != null)
      {
        localDrawable.setLevel((100 - paramInt) * 100);
        if (((localDrawable instanceof AIOSendMask)) && (!this.jdField_b_of_type_Boolean)) {
          ((AIOSendMask)localDrawable).a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      return;
      setText("");
    }
  }
  
  public void setProgressListener(MessageProgressTextView.ProgressListener paramProgressListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqCustomviewsMessageProgressTextView$ProgressListener = paramProgressListener;
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.MessageProgressTextView
 * JD-Core Version:    0.7.0.1
 */