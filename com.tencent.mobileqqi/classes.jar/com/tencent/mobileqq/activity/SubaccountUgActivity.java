package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountAssistantManager;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import dtd;
import dte;
import dtg;
import dti;
import dtj;
import dtn;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SubaccountUgActivity
  extends SubAccountBaseActivity
  implements View.OnClickListener, Observer
{
  public static final int a = 1980;
  Handler jdField_a_of_type_AndroidOsHandler = new dtd(this);
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new dte(this);
  SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver;
  public SubAccountAssistantManager a;
  public String a;
  private String b;
  public boolean c;
  boolean d = true;
  public boolean e;
  public boolean f;
  
  public SubaccountUgActivity()
  {
    this.jdField_b_of_type_JavaLangString = "Q.subaccount.SubaccountUgActivity";
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private void a(ImageView paramImageView)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    for (;;)
    {
      return;
      try
      {
        List localList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllNotSynAccountList();
        if ((localList != null) && (localList.size() > 1))
        {
          String str = ((SimpleAccount)localList.get(0)).getUin();
          Object localObject = str;
          if (str != null)
          {
            localObject = str;
            if (str.equalsIgnoreCase(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
              localObject = ((SimpleAccount)localList.get(1)).getUin();
            }
          }
          localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((String)localObject, false);
          if (localObject != null)
          {
            paramImageView.setImageBitmap((Bitmap)localObject);
            return;
          }
        }
      }
      catch (Exception paramImageView)
      {
        paramImageView.printStackTrace();
      }
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130904000);
    setTitle(2131562836);
    this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager = SubAccountAssistantManager.a();
    ImageView localImageView = (ImageView)findViewById(2131234549);
    Object localObject4 = (ImageView)findViewById(2131234548);
    TextView localTextView = (TextView)findViewById(2131234550);
    Object localObject3 = (TextView)findViewById(2131234551);
    Button localButton = (Button)findViewById(2131234552);
    Object localObject2 = findViewById(2131234553);
    Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = ImageUtil.a();
    }
    localImageView.setImageBitmap(paramBundle);
    localTextView.setTextColor(getResources().getColor(2131362070));
    this.c = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    int k = 0;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    int i;
    int j;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramBundle = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getAllAccounts();
      i = k;
      if (paramBundle != null)
      {
        if (paramBundle.size() == 0) {
          i = k;
        }
      }
      else
      {
        j = i;
        if (i == 0) {
          j = 2131563252;
        }
        ((TextView)localObject3).setVisibility(8);
        if (!this.c) {
          break label918;
        }
        localTextView.setTextColor(getResources().getColor(2131362070));
        paramBundle = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramBundle, false);
        if (localObject1 != null) {
          ((ImageView)localObject4).setImageBitmap((Bitmap)localObject1);
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle) + "(" + paramBundle + ")";
        this.d = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
        if (!this.d) {
          break label623;
        }
        SubAccountAssistantForward.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        finish();
        return false;
      }
      i = 0;
      if (i >= paramBundle.size()) {
        break label934;
      }
      localObject1 = (SimpleAccount)paramBundle.get(i);
      if (localObject1 == null) {}
      while ((((SimpleAccount)localObject1).getUin() == null) || (!((SimpleAccount)localObject1).getUin().equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)))
      {
        i += 1;
        break;
      }
      j = 1;
      if (!((SimpleAccount)localObject1).isLogined()) {
        break label929;
      }
      i = 1;
    }
    for (;;)
    {
      if (j != 0)
      {
        if (i != 0)
        {
          this.d = true;
          i = k;
          break;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        if (i != 0) {
          switch (i)
          {
          default: 
            i = 0;
          }
        }
        for (;;)
        {
          break;
          i = 2131561462;
          continue;
          i = 2131561464;
          continue;
          i = 2131561463;
          continue;
          i = 2131561462;
          continue;
          i = 2131561462;
          continue;
          i = 2131563289;
        }
      }
      i = 2131563289;
      break;
      i = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
      if (i == 0)
      {
        i = 2131563252;
        break;
      }
      if (i == 1)
      {
        i = 2131563252;
        break;
      }
      i = 2131563252;
      break;
      label623:
      localObject4 = getString(j, new Object[] { localObject1 });
      if (j == 2131563289)
      {
        ((TextView)localObject3).setVisibility(0);
        localButton.setText(2131563165);
        ((View)localObject2).setVisibility(0);
        localObject3 = (Button)((View)localObject2).findViewById(2131234554);
        localObject2 = (Button)((View)localObject2).findViewById(2131234556);
        i = ((Button)localObject3).getPaint().getFlags() | 0x8;
        ((Button)localObject3).getPaint().setFlags(i);
        ((Button)localObject2).getPaint().setFlags(i);
        ((Button)localObject3).setOnClickListener(new dtg(this, paramBundle));
        ((Button)localObject2).setOnClickListener(new dti(this));
        i = ((String)localObject4).indexOf((String)localObject1);
        if (i > -1)
        {
          paramBundle = new SpannableString((CharSequence)localObject4);
          paramBundle.setSpan(new ForegroundColorSpan(-16754769), i, ((String)localObject1).length() + i, 33);
          localTextView.setText(paramBundle);
        }
      }
      for (;;)
      {
        localButton.setOnClickListener(this);
        paramBundle = SubAccountAssistantManager.a();
        if (paramBundle.a(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
          paramBundle.a(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new dtj(this);
        a(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
        a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
        if (!jdField_a_of_type_Boolean)
        {
          i();
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass(), this.jdField_a_of_type_AndroidOsHandler);
        return true;
        ((TextView)localObject3).setVisibility(8);
        break;
        label918:
        ((ImageView)localObject4).setImageResource(2130840246);
      }
      label929:
      i = 0;
      continue;
      label934:
      i = 0;
      j = 0;
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    b(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(getClass());
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) && (!jdField_a_of_type_Boolean)) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  public void h()
  {
    this.c = false;
    View localView = findViewById(2131234553);
    TextView localTextView1 = (TextView)findViewById(2131234550);
    TextView localTextView2 = (TextView)findViewById(2131234551);
    ImageView localImageView = (ImageView)findViewById(2131234548);
    ((Button)findViewById(2131234552)).setText(2131561704);
    localView.setVisibility(8);
    localTextView1.setText(2131563252);
    localTextView2.setVisibility(8);
    localImageView.setImageResource(2130840246);
  }
  
  public void i()
  {
    if (this.k != null)
    {
      Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject == null) {
        break label100;
      }
      int i = ((QQMessageFacade)localObject).f();
      if (i > 0)
      {
        localObject = Integer.toString(i);
        if (i > 99) {
          localObject = "99+";
        }
        this.k.setText(getString(2131561807) + "(" + (String)localObject + ")");
      }
    }
    else
    {
      return;
    }
    this.k.setText(getString(2131561807));
    return;
    label100:
    this.k.setText(getString(2131561807));
  }
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    if (!this.c)
    {
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 1)) {
        paramView.setClass(this, SubAccountBindActivity.class);
      }
      for (;;)
      {
        startActivity(paramView);
        return;
        paramView.setClass(this, SubLoginActivity.class);
      }
    }
    if (this.d)
    {
      SubAccountAssistantManager.a().a(a(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false);
      SubAccountAssistantForward.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      finish();
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSubaccountSubAccountAssistantManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    paramView.putExtra("is_need_bind", false);
    paramView.putExtra("subuin", (String)localObject);
    paramView.setClass(this, SubLoginActivity.class);
    startActivity(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (((paramObject instanceof MessageRecord)) && (!((MessageRecord)paramObject).isSendFromLocal())) {
      runOnUiThread(new dtn(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubaccountUgActivity
 * JD-Core Version:    0.7.0.1
 */