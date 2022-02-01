package com.dataline.activities;

import acde;
import acio;
import acir;
import ackv;
import ahav;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqfx;
import aqiw;
import ce;
import cf;
import co;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.MyCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cp;
import cp.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo;

public class PrinterOptionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private View jdField_B_of_type_AndroidViewView;
  private Button jdField_B_of_type_AndroidWidgetButton;
  private View C;
  private View D;
  private TextView I;
  private TextView J;
  private TextView K;
  private TextView L;
  private ArrayList<FileInfo> N;
  private MyCheckBox jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox;
  private cp.a jdField_a_of_type_Cp$a = new ce(this);
  private acde b;
  private boolean bg;
  private boolean bp = true;
  private boolean bq;
  private boolean br;
  private int jdField_do = 1;
  public ViewGroup e;
  private LinearLayout m;
  
  private boolean N()
  {
    ackv localackv = (ackv)this.app.getBusinessHandler(10);
    acir localacir = (acir)this.app.getBusinessHandler(74);
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PrinterOptionActivity", 4, "UpdateStatus : network error");
      }
      this.K.setText(2131692380);
      this.K.setVisibility(0);
      this.jdField_B_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_B_of_type_AndroidViewView.setEnabled(false);
    }
    for (;;)
    {
      return false;
      if (!d(true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : Null printer has been selected");
        }
        this.K.setVisibility(4);
        this.I.setText(2131692395);
        if (!this.bq) {
          this.I.setTextColor(Color.parseColor("#808080"));
        }
        this.jdField_B_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_B_of_type_AndroidViewView.setEnabled(true);
      }
      else if (localackv.bi() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not login");
        }
        this.K.setText(2131692381);
        this.K.setVisibility(0);
        this.jdField_B_of_type_AndroidWidgetButton.setEnabled(false);
      }
      else if (!localacir.abe())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : PCQQ is not outdate");
        }
        this.K.setText(2131692379);
        this.K.setVisibility(0);
        this.jdField_B_of_type_AndroidWidgetButton.setEnabled(false);
      }
      else
      {
        if (R()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("PrinterOptionActivity", 4, "UpdateStatus : The file is not support print");
        }
        this.K.setText(2131692383);
        this.K.setVisibility(0);
        this.jdField_B_of_type_AndroidWidgetButton.setEnabled(false);
        this.jdField_B_of_type_AndroidViewView.setEnabled(true);
      }
    }
    if (this.br)
    {
      this.K.setVisibility(0);
      this.K.setText(2131692382);
    }
    for (;;)
    {
      this.jdField_B_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_B_of_type_AndroidViewView.setEnabled(true);
      return true;
      this.K.setVisibility(4);
    }
  }
  
  private void P(boolean paramBoolean)
  {
    startActivityForResult(new Intent(this, PrinterSubOptionActivity.class), 103);
  }
  
  private boolean R()
  {
    int i = 1;
    co localco = this.b.b.a;
    Iterator localIterator1;
    FileInfo localFileInfo;
    String str;
    int j;
    boolean bool1;
    int k;
    if (localco != null) {
      if (localco.dB == 2)
      {
        localIterator1 = this.N.iterator();
        while (localIterator1.hasNext())
        {
          localFileInfo = (FileInfo)localIterator1.next();
          str = localFileInfo.getName().toLowerCase();
          j = ahav.getFileType(str);
          if ((j != 9) && (j != 0)) {
            this.br = true;
          }
          if (!this.b.b.B(str))
          {
            if (QLog.isDevelopLevel()) {
              QLog.i("IphoneTitleBarActivity", 1, "printer unsupport file printer : " + localco.bJ + " file : " + localFileInfo.getName());
            }
            bool1 = false;
            k = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (k == 0)
      {
        this.C.setVisibility(8);
        this.D.setVisibility(8);
      }
      label242:
      label383:
      int n;
      label398:
      label413:
      boolean bool2;
      if (i != 0)
      {
        this.m.setVisibility(0);
        this.L.setVisibility(8);
        return bool1;
        if (localco.dB == 1)
        {
          if (this.b.a.K() == null) {
            break label562;
          }
          localIterator1 = this.N.iterator();
          j = 1;
          i = 1;
          bool1 = false;
          if (!localIterator1.hasNext()) {
            break label553;
          }
          localFileInfo = (FileInfo)localIterator1.next();
          str = localFileInfo.getName().toLowerCase();
          k = ahav.getFileType(str);
          if ((k != 9) || (k != 0)) {
            this.br = true;
          }
          Iterator localIterator2 = this.b.a.xN.iterator();
          for (;;)
          {
            if (localIterator2.hasNext())
            {
              C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo localSupportFileInfo = (C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)localIterator2.next();
              if (str.endsWith("." + localSupportFileInfo.str_file_suffix.get())) {
                if (localSupportFileInfo.uint32_copies.get() == 1)
                {
                  k = 1;
                  if (localSupportFileInfo.uint32_duplex.get() != 1) {
                    break label498;
                  }
                  n = 1;
                  j = n & j;
                  n = i & k;
                  bool1 = true;
                  i = j;
                  if (bool1) {
                    break label504;
                  }
                  j = i;
                  k = n;
                  bool2 = bool1;
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("IphoneTitleBarActivity", 1, "printer unsupport file printer : " + localco.bJ + " file : " + localFileInfo.getName());
                    bool2 = bool1;
                    k = n;
                    j = i;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        i = j;
        bool1 = bool2;
        break;
        k = 0;
        break label383;
        label498:
        n = 0;
        break label398;
        label504:
        j = i;
        i = n;
        break label242;
        i = 0;
        k = 0;
        bool1 = false;
        break;
        this.L.setVisibility(0);
        this.m.setVisibility(8);
        return bool1;
        n = i;
        bool1 = false;
        i = j;
        break label413;
        label553:
        k = i;
        bool2 = bool1;
        continue;
        label562:
        j = 1;
        k = 1;
        bool2 = false;
      }
      bool1 = true;
      break;
      k = 1;
      bool1 = false;
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1;
    Object localObject;
    if (this.b.b.a == null)
    {
      bool1 = bool2;
      if (paramBoolean)
      {
        localObject = this.b.b.a();
        this.b.b.a = ((co)localObject);
        if (localObject != null) {
          break label124;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      localObject = "";
      if (bool1)
      {
        String str = this.b.b.a.bJ;
        this.b.b.I(str);
        localObject = str;
        if (!this.bq)
        {
          this.I.setTextColor(-16777216);
          localObject = str;
        }
      }
      this.I.setText((CharSequence)localObject);
      return bool1;
      label124:
      bool1 = true;
      continue;
      bool1 = true;
    }
  }
  
  void bY()
  {
    boolean bool2 = true;
    Object localObject = getString(2131692385) + this.jdField_do;
    this.J.setText((CharSequence)localObject);
    localObject = this.C;
    if (this.jdField_do > 1)
    {
      bool1 = true;
      ((View)localObject).setEnabled(bool1);
      localObject = this.D;
      if (this.jdField_do >= 99) {
        break label85;
      }
    }
    label85:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((View)localObject).setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 103) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("sPrinterName");
      long l = paramIntent.getLongExtra("sPrintDin", 0L);
      if ((str == null) && (l == 0L)) {
        this.b.b.a = null;
      }
      if ((N()) && (this.b.b.a != null)) {
        this.b.b.I(this.b.b.a.bJ);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.b = ((acde)this.app.getBusinessHandler(8));
    this.N = super.getIntent().getParcelableArrayListExtra("sFilesSelected");
    this.bg = super.getIntent().getBooleanExtra("sIsCloudPrinter", false);
    this.bg = getIntent().getBooleanExtra("sIsCloudPrinter", false);
    super.getWindow().setBackgroundDrawableResource(2131165572);
    setContentView(2131559192);
    setTitle(2131692391);
    super.getWindow().setBackgroundDrawable(null);
    this.e = ((ViewGroup)super.findViewById(2131365596));
    this.e.setTag(2131361821, "n/a");
    this.jdField_B_of_type_AndroidViewView = super.findViewById(2131373597);
    this.jdField_B_of_type_AndroidViewView.setOnClickListener(this);
    this.I = ((TextView)super.findViewById(2131373598));
    this.jdField_B_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131361959));
    this.jdField_B_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.K = ((TextView)super.findViewById(2131369154));
    this.J = ((TextView)super.findViewById(2131373592));
    this.C = super.findViewById(2131365654);
    this.C.setOnClickListener(this);
    this.D = super.findViewById(2131369131);
    this.D.setOnClickListener(this);
    this.L = ((TextView)super.findViewById(2131373599));
    this.m = ((LinearLayout)super.findViewById(2131373594));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox = ((MyCheckBox)super.findViewById(2131378711));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.setOnCheckedChangeListener(new cf(this));
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.bq = true;
      this.D.setBackgroundResource(2130842399);
      this.C.setBackgroundResource(2130842398);
      this.jdField_B_of_type_AndroidWidgetButton.setBackgroundResource(2130842401);
    }
    this.b.b.a = null;
    this.b.b.a(this.jdField_a_of_type_Cp$a);
    if (!d(true))
    {
      this.K.setText(2131692395);
      this.K.setVisibility(0);
    }
    this.L.setVisibility(8);
    bY();
    return true;
  }
  
  public void doOnDestroy()
  {
    this.b.b.ch();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    LiteActivity.a(this, this.e);
    N();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_B_of_type_AndroidViewView) {
      P(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_B_of_type_AndroidWidgetButton)
      {
        if ((this.bp) && (N()))
        {
          this.bp = false;
          Intent localIntent = new Intent();
          for (;;)
          {
            try
            {
              localObject = new JSONObject();
              ((JSONObject)localObject).put("printCopies", this.jdField_do);
              if (!this.jdField_a_of_type_ComTencentMobileqqWidgetMyCheckBox.isChecked()) {
                continue;
              }
              ((JSONObject)localObject).put("duplexMode", 2);
              ((JSONObject)localObject).put("printerName", this.b.a.boS);
              localObject = ((JSONObject)localObject).toString();
              if (QLog.isDevelopLevel()) {
                QLog.i("IphoneTitleBarActivity", 1, "printer params : " + (String)localObject);
              }
              localIntent.putExtra("sPrintParam", (String)localObject);
              localIntent.putParcelableArrayListExtra("sFilesSelected", this.N);
              localIntent.putExtra(aqfx.REQUEST_CODE, super.getIntent().getIntExtra(aqfx.REQUEST_CODE, 0));
            }
            catch (JSONException localJSONException)
            {
              Object localObject;
              this.bp = true;
              continue;
            }
            setResult(-1, localIntent);
            finish();
            anot.a(this.app, "CliOper", "", "", "0X800405A", "0X800405A", 0, 0, "", "", "", "");
            break;
            ((JSONObject)localObject).put("duplexMode", 1);
          }
        }
      }
      else if (paramView == this.C)
      {
        this.jdField_do -= 1;
        this.jdField_do = Math.max(1, this.jdField_do);
        bY();
      }
      else if (paramView == this.D)
      {
        this.jdField_do += 1;
        bY();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.dataline.activities.PrinterOptionActivity
 * JD-Core Version:    0.7.0.1
 */