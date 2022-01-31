package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import cbv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ReaderTipsBar
  implements TipsBarTask
{
  private static final String b = ReaderTipsBar.class.getSimpleName();
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected String a;
  
  public ReaderTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(Object... paramVarArgs)
  {
    paramVarArgs = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903070, null);
    paramVarArgs.setOnClickListener(new cbv(this));
    ((TextView)paramVarArgs.findViewById(2131296587)).setText(this.jdField_a_of_type_JavaLangString);
    return paramVarArgs;
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d(b, 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
          }
          paramVarArgs = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
          if (paramVarArgs != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(b, 2, "data == null");
        return;
        str = paramVarArgs.getString("bookname");
        if (!TextUtils.isEmpty(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(b, 2, "onAIOEvent() : bookName is empty");
      return;
      this.jdField_a_of_type_JavaLangString = String.format("正在阅读《%s》", new Object[] { str });
      this.jdField_a_of_type_Long = paramVarArgs.getLong("bookid");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[0]);
    } while (!QLog.isColorLevel());
    QLog.d(b, 2, "onAIOEvent() : show ReaderTipBar, bookName : " + str);
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 30;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar
 * JD-Core Version:    0.7.0.1
 */