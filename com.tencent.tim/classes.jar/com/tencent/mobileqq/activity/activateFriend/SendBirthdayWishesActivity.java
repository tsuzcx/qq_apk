package com.tencent.mobileqq.activity.activateFriend;

import acof;
import acog;
import afmf;
import afmi;
import afqv;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aofr;
import aofy;
import aqft;
import aqgv;
import aqiw;
import arhz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.c;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import wic;
import wid;
import wja;

public class SendBirthdayWishesActivity
  extends IphoneTitleBarActivity
  implements afmf, TextWatcher, View.OnClickListener, XPanelContainer.c
{
  TextView HN;
  long[] W;
  acof a;
  public EditText aL;
  ImageButton ai;
  private MqqHandler b = new MqqHandler(Looper.getMainLooper());
  boolean bcu = false;
  acog jdField_c_of_type_Acog = new wid(this);
  ActivateFriendGrid jdField_c_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid;
  public XPanelContainer d;
  private Runnable ef = new SendBirthdayWishesActivity.3(this);
  arhz jdField_f_of_type_Arhz;
  long[] jdField_f_of_type_ArrayOfLong;
  int msgType = 1;
  Button sendBtn;
  View vZ;
  
  private void BZ(int paramInt)
  {
    int i = 0;
    if (this.msgType == 2)
    {
      if (paramInt != 0) {
        break label49;
      }
      if (this.msgType != 1) {
        break label43;
      }
      paramInt = 2131690034;
      i = 2;
    }
    for (;;)
    {
      QQToast.a(this, i, paramInt, 1).show(getTitleBarHeight());
      return;
      label43:
      paramInt = 2131690032;
      break;
      label49:
      if (paramInt == 1)
      {
        paramInt = 2131690051;
      }
      else if (paramInt == 2)
      {
        paramInt = 2131690046;
        i = 1;
      }
      else
      {
        paramInt = 0;
      }
    }
  }
  
  private void bcH()
  {
    Object localObject;
    if (this.msgType == 1) {
      localObject = String.format(getString(2131690047), new Object[] { getIntent().getStringExtra("key_roam_city") });
    }
    String str;
    for (;;)
    {
      this.aL.setText((CharSequence)localObject);
      this.aL.setSelection(((String)localObject).length());
      this.aL.addTextChangedListener(this);
      localObject = new ArrayList(this.jdField_f_of_type_ArrayOfLong.length);
      int i = 0;
      while (i < this.jdField_f_of_type_ArrayOfLong.length)
      {
        ActivateFriendItem localActivateFriendItem = new ActivateFriendItem(this.msgType, this.jdField_f_of_type_ArrayOfLong[i]);
        if (this.msgType == 2) {
          localActivateFriendItem.birthSendTime = this.W[i];
        }
        ((ArrayList)localObject).add(localActivateFriendItem);
        i += 1;
      }
      try
      {
        localObject = acof.az(this);
      }
      catch (Exception localException)
      {
        str = getString(2131690040);
      }
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, str);
  }
  
  private void initViews()
  {
    setRightHighlightButton(2131721058, new wic(this));
    Object localObject1 = "";
    if (this.msgType == 1) {
      if (this.jdField_f_of_type_ArrayOfLong.length == 1) {
        localObject1 = getString(2131690049);
      }
    }
    for (;;)
    {
      setTitle((CharSequence)localObject1);
      enableRightHighlight(true);
      this.leftView.setVisibility(8);
      this.aL = ((EditText)findViewById(2131369276));
      this.aL.setMaxLines(8);
      this.aL.setEditableFactory(aofr.a);
      this.d = ((XPanelContainer)findViewById(2131377546));
      this.d.setOnPanelChangeListener(this);
      this.d.ja(this.aL);
      try
      {
        localObject1 = getResources().getDrawable(2130839260);
        this.d.setBackgroundDrawable((Drawable)localObject1);
        this.ai = ((ImageButton)findViewById(2131366307));
        this.ai.setOnClickListener(this);
        this.sendBtn = ((Button)findViewById(2131367817));
        this.sendBtn.setOnClickListener(this);
        this.vZ = findViewById(2131369579);
        this.vZ.setOnClickListener(this);
        localObject1 = new StateListDrawable();
        localObject2 = getResources().getDrawable(2130850992);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = getResources().getDrawable(2130850991);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.sendBtn.setBackgroundDrawable((Drawable)localObject1);
        boolean bool = ((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue();
        localObject1 = findViewById(2131369277);
        if (bool)
        {
          localObject2 = ((View)localObject1).findViewById(2131378466);
          ((View)localObject2).setBackgroundResource(2130839270);
          ((View)localObject2).setVisibility(0);
          ((View)localObject1).getBackground().setVisible(false, false);
          this.HN = ((TextView)findViewById(2131378009));
          localObject1 = this.HN;
          if (this.msgType != 1) {
            break label602;
          }
          i = 2131690053;
          ((TextView)localObject1).setText(i);
          this.HN.setBackgroundColor(getResources().getColor(2131167277));
          this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)findViewById(2131367678));
          this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setCheckAbilityEnable(false);
          this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setSkinable(true);
          localObject1 = findViewById(2131367734);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.HN.getText());
          long[] arrayOfLong = this.jdField_f_of_type_ArrayOfLong;
          int j = arrayOfLong.length;
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              long l = arrayOfLong[i];
              ((StringBuilder)localObject2).append(aqgv.A(this.app, String.valueOf(l))).append(",");
              i += 1;
              continue;
              localObject1 = getString(2131690050);
              break;
              if (this.msgType == 3) {
                break;
              }
              localObject1 = getString(2131690048);
            }
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        Drawable localDrawable;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            localException.printStackTrace();
          }
          localDrawable = getResources().getDrawable(2130851037);
          continue;
          localDrawable.getBackground().setVisible(true, false);
          localDrawable.findViewById(2131378466).setVisibility(8);
          continue;
          label602:
          int i = 2131690052;
        }
        localDrawable.setContentDescription(((StringBuilder)localObject2).toString());
      }
    }
  }
  
  public View a(int paramInt)
  {
    if (paramInt == 2)
    {
      SystemEmoticonPanel localSystemEmoticonPanel = new SystemEmoticonPanel(this, this);
      View localView = localSystemEmoticonPanel.findViewById(2131376602);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.bottomMargin = wja.dp2px(15.0F, getResources());
      localView.setLayoutParams(localLayoutParams);
      localSystemEmoticonPanel.setBackgroundResource(2130845001);
      return localSystemEmoticonPanel;
    }
    return null;
  }
  
  public void a(afmi paramafmi)
  {
    if ((paramafmi instanceof afqv))
    {
      int i = this.aL.getSelectionStart();
      int j = this.aL.getSelectionEnd();
      if ((i >= 0) && (j >= 0) && (j >= i)) {
        this.aL.getEditableText().replace(i, j, aofy.fx(((afqv)paramafmi).code));
      }
    }
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return true;
  }
  
  void abJ()
  {
    if (this.jdField_f_of_type_Arhz == null) {
      this.jdField_f_of_type_Arhz = new arhz(this, getTitleBarHeight());
    }
    this.jdField_f_of_type_Arhz.setMessage(2131689675);
    this.jdField_f_of_type_Arhz.show();
    this.jdField_f_of_type_Arhz.setCancelable(false);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!this.bcu)
    {
      anot.a(this.app, "CliOper", "", "", "0X8004E0B", "0X8004E0B", 0, 0, "", "", "", "");
      this.bcu = true;
    }
  }
  
  public void aqz()
  {
    if (this.jdField_f_of_type_Arhz != null) {
      this.jdField_f_of_type_Arhz.dismiss();
    }
  }
  
  public void b(afmi paramafmi) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void bo() {}
  
  public void delete()
  {
    if (this.aL.getSelectionStart() == 0) {}
    for (;;)
    {
      return;
      try
      {
        Editable localEditable = this.aL.getEditableText();
        int i = this.aL.getSelectionStart();
        int j = TextUtils.getOffsetBefore(this.aL.getText(), i);
        if (i != j)
        {
          localEditable.delete(Math.min(i, j), Math.max(i, j));
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = -1;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561173);
    getWindow().setBackgroundDrawable(null);
    getWindow().setSoftInputMode(20);
    this.a = ((acof)this.app.getManager(85));
    this.msgType = getIntent().getIntExtra("key_msg_type", this.msgType);
    this.jdField_f_of_type_ArrayOfLong = getIntent().getLongArrayExtra("key_friend_list");
    this.W = getIntent().getLongArrayExtra("key_time_list");
    if ((this.jdField_f_of_type_ArrayOfLong == null) || (this.jdField_f_of_type_ArrayOfLong.length == 0) || ((this.msgType == 2) && ((this.W == null) || (this.jdField_f_of_type_ArrayOfLong.length != this.W.length))))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder().append("intent data is invaild, msgType = ").append(this.msgType).append(" | uin count = ");
        if (this.jdField_f_of_type_ArrayOfLong == null) {
          break label231;
        }
      }
      label231:
      for (int i = this.jdField_f_of_type_ArrayOfLong.length;; i = -1)
      {
        paramBundle = paramBundle.append(i).append(" | time count = ");
        i = j;
        if (this.W != null) {
          i = this.W.length;
        }
        QLog.d("ActivateFriend.SendActivity", 2, i);
        finish();
        return false;
      }
    }
    initViews();
    bcH();
    this.app.registObserver(this.jdField_c_of_type_Acog);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.unRegistObserver(this.jdField_c_of_type_Acog);
    this.jdField_c_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.destroy();
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771990);
  }
  
  public void gq() {}
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void n(int paramInt1, int paramInt2)
  {
    this.b.post(new SendBirthdayWishesActivity.4(this, paramInt2));
  }
  
  public boolean onBackEvent()
  {
    if (this.d.vm() != 0)
    {
      this.d.aJS();
      return true;
    }
    anot.a(this.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.ai) {
      if (this.d.vm() == 2) {
        this.d.abp(1);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.d.abp(2);
      continue;
      if (paramView == this.sendBtn)
      {
        String str = this.aL.getEditableText().toString();
        if (str.length() != 0) {
          if (!aqiw.isNetSupport(this))
          {
            QQToast.a(this, 2131696272, 0).show(getTitleBarHeight());
          }
          else
          {
            ArrayList localArrayList = aqft.a(str, 560, 20, null, new ArrayList());
            if ((QLog.isColorLevel()) && (localArrayList.size() > 1)) {
              QLog.d("ActivateFriend.SendActivity", 2, "onclick | bytes = " + str.getBytes().length + " | partArray.size = " + localArrayList.size());
            }
            if (localArrayList.size() > 1)
            {
              QQToast.a(this, 2131719509, 0).show(getTitleBarHeight());
            }
            else
            {
              this.a.a(this.msgType, this.jdField_f_of_type_ArrayOfLong, this.W, str);
              anot.a(this.app, "CliOper", "", "", "0X8004E09", "0X8004E09", 0, 0, this.jdField_f_of_type_ArrayOfLong.length + "", "", "", "");
              anot.a(this.app, "dc00898", "", "", "0X8007AE9", "0X8007AE9", this.jdField_f_of_type_ArrayOfLong.length, 0, "", "", "", "");
              abJ();
            }
          }
        }
      }
      else if (paramView == this.vZ)
      {
        if (this.d.vm() == 1) {
          this.d.aJS();
        }
        finish();
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean r(int paramInt)
  {
    return false;
  }
  
  public void send() {}
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity
 * JD-Core Version:    0.7.0.1
 */