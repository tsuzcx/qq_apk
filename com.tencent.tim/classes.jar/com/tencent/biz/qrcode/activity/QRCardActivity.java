package com.tencent.biz.qrcode.activity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqha;
import aqju;
import ausj;
import auss;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rtx;
import rty;
import rtz;
import rua;
import rub;
import ruc;
import rud;
import rws;

public class QRCardActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected static String aCn = "((?:(?i)https?://|www\\.|[a-zA-Z0-9]+\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)";
  public rws a;
  protected String aCb;
  protected String aCc;
  protected String aCd;
  protected String aCe;
  protected String aCf;
  protected String aCg;
  public String aCh;
  protected String aCi;
  protected String aCj;
  public String aCk;
  protected String aCl;
  protected String aCm;
  public boolean aJJ;
  protected boolean aJK;
  public boolean acX;
  private View.OnLongClickListener b = new rud(this);
  protected Handler bv = new rtx(this);
  protected Button cw;
  protected Resources f;
  protected LinearLayout ff;
  protected Thread h;
  public ausj mActionSheet;
  protected float mDensity;
  protected String mHeaderUrl;
  protected int mLinkColor;
  protected String mNickName;
  public ImageView nB;
  protected TextView zl;
  protected TextView zm;
  protected TextView zn;
  
  private void a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = super.getLayoutInflater();
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    Object localObject4;
    int n;
    Object localObject6;
    TextView localTextView;
    if (paramInt == 0)
    {
      i = this.a.fC.size();
      i = this.a.fB.size() + i;
      if (paramInt != 0) {
        break label683;
      }
      k = i;
      if (!this.a.fC.isEmpty())
      {
        localObject2 = this.a.fC.keySet().iterator();
        paramInt = m;
      }
    }
    else
    {
      for (;;)
      {
        j = paramInt;
        k = i;
        if (!((Iterator)localObject2).hasNext()) {
          break label413;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = (String)this.a.fC.get(localObject3);
        localObject4 = ((String)localObject5).split(";");
        if ((localObject4 != null) && (localObject4.length > 0))
        {
          m = i + (localObject4.length - 1);
          if (localObject4.length > 1)
          {
            n = localObject4.length;
            k = 0;
            j = paramInt;
            for (;;)
            {
              paramInt = j;
              i = m;
              if (k >= n) {
                break;
              }
              localObject5 = localObject4[k];
              localObject6 = ((LayoutInflater)localObject1).inflate(2131560590, null);
              ((View)localObject6).setTag(Integer.valueOf(0));
              localTextView = (TextView)((View)localObject6).findViewById(2131365360);
              ((TextView)((View)localObject6).findViewById(2131379769)).setText((CharSequence)localObject3);
              localTextView.setText((CharSequence)localObject5);
              a(j, m, (View)localObject6, paramViewGroup, 1);
              j += 1;
              k += 1;
            }
            if (paramInt != 1) {
              break;
            }
            i = this.a.fE.size();
            n = this.a.fF.size();
            int i1 = this.a.fD.size();
            i = this.a.fA.size() + (i + n + i1);
            break;
          }
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560590, null);
          ((View)localObject4).setTag(Integer.valueOf(0));
          localObject6 = (TextView)((View)localObject4).findViewById(2131365360);
          ((TextView)((View)localObject4).findViewById(2131379769)).setText((CharSequence)localObject3);
          ((TextView)localObject6).setText((CharSequence)localObject5);
          a(paramInt, m, (View)localObject4, paramViewGroup, 1);
          paramInt += 1;
          i = m;
        }
      }
    }
    label413:
    if (!this.a.fB.isEmpty())
    {
      localObject2 = this.a.fB.keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        localObject5 = (String)this.a.fB.get(localObject3);
        localObject4 = ((String)localObject5).split(";");
        if ((localObject4 != null) && (localObject4.length > 0))
        {
          m = k + (localObject4.length - 1);
          if (localObject4.length > 1)
          {
            n = localObject4.length;
            i = 0;
            paramInt = j;
            for (;;)
            {
              j = paramInt;
              k = m;
              if (i >= n) {
                break;
              }
              localObject5 = localObject4[i];
              localObject6 = ((LayoutInflater)localObject1).inflate(2131560588, null);
              localTextView = (TextView)((View)localObject6).findViewById(2131365360);
              ((TextView)((View)localObject6).findViewById(2131379769)).setText((CharSequence)localObject3);
              localTextView.setText((CharSequence)localObject5);
              a(paramInt, m, (View)localObject6, paramViewGroup, 0);
              paramInt += 1;
              i += 1;
            }
          }
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560588, null);
          localObject6 = (TextView)((View)localObject4).findViewById(2131365360);
          ((TextView)((View)localObject4).findViewById(2131379769)).setText((CharSequence)localObject3);
          ((TextView)localObject6).setText((CharSequence)localObject5);
          a(j, m, (View)localObject4, paramViewGroup, 0);
          j += 1;
          k = m;
        }
      }
      label683:
      if (paramInt == 1)
      {
        paramInt = k;
        if (!this.a.fF.isEmpty())
        {
          localObject2 = this.aCk;
          localObject3 = (String)this.a.fF.get(this.aCk);
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560590, null);
          ((View)localObject4).setTag(Integer.valueOf(2));
          localObject5 = (TextView)((View)localObject4).findViewById(2131365360);
          ((TextView)((View)localObject4).findViewById(2131379769)).setText((CharSequence)localObject2);
          ((TextView)localObject5).setText((CharSequence)localObject3);
          a(0, i, (View)localObject4, paramViewGroup, 1);
          paramInt = 1;
        }
        j = paramInt;
        if (!this.a.fE.isEmpty())
        {
          localObject2 = this.aCj;
          localObject3 = (String)this.a.fE.get(this.aCj);
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560588, null);
          localObject5 = (TextView)((View)localObject4).findViewById(2131365360);
          ((TextView)((View)localObject4).findViewById(2131379769)).setText((CharSequence)localObject2);
          ((TextView)localObject5).setText((CharSequence)localObject3);
          a(paramInt, i, (View)localObject4, paramViewGroup, 0);
          j = paramInt + 1;
        }
        if (!this.a.fD.isEmpty())
        {
          localObject2 = this.aCh;
          localObject3 = (String)this.a.fD.get(this.aCh);
          if (!Pattern.compile(aCn).matcher((CharSequence)localObject3).matches()) {
            break label1181;
          }
          localObject4 = ((LayoutInflater)localObject1).inflate(2131560590, null);
          ((View)localObject4).setTag(Integer.valueOf(1));
          localObject5 = (TextView)((View)localObject4).findViewById(2131365360);
          ((TextView)((View)localObject4).findViewById(2131379769)).setText((CharSequence)localObject2);
          ((TextView)localObject5).setText((CharSequence)localObject3);
          a(j, i, (View)localObject4, paramViewGroup, 1);
        }
        while (!this.a.fA.isEmpty())
        {
          localObject1 = ((LayoutInflater)localObject1).inflate(2131560588, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131365360);
          localObject3 = (TextView)((View)localObject1).findViewById(2131379769);
          ((TextView)localObject2).setMovementMethod(LinkMovementMethod.getInstance());
          ((TextView)localObject3).setText(this.aCi);
          localObject3 = (String)this.a.fA.get(this.aCi);
          localObject4 = new SpannableString((CharSequence)localObject3);
          localObject5 = Pattern.compile("\\d{5,}").matcher((CharSequence)localObject3);
          for (;;)
          {
            if (((Matcher)localObject5).find())
            {
              paramInt = ((Matcher)localObject5).start();
              j = ((Matcher)localObject5).end();
              if (j - paramInt <= 16)
              {
                ((SpannableString)localObject4).setSpan(new NumberSpan(((String)localObject3).toString().substring(paramInt, j)), paramInt, j, 33);
                continue;
                localObject4 = ((LayoutInflater)localObject1).inflate(2131560588, null);
                localObject5 = (TextView)((View)localObject4).findViewById(2131365360);
                ((TextView)((View)localObject4).findViewById(2131379769)).setText((CharSequence)localObject2);
                ((TextView)localObject5).setText((CharSequence)localObject3);
                a(j, i, (View)localObject4, paramViewGroup, 0);
                break;
              }
            }
          }
          localObject5 = Pattern.compile(aCn).matcher((CharSequence)localObject3);
          while (((Matcher)localObject5).find())
          {
            paramInt = ((Matcher)localObject5).start();
            j = ((Matcher)localObject5).end();
            ((SpannableString)localObject4).setSpan(new NumberSpan(((String)localObject3).toString().substring(paramInt, j)), paramInt, j, 33);
          }
          ((TextView)localObject2).setText((CharSequence)localObject4);
          if (i != 1) {
            break label1331;
          }
          ((View)localObject1).setBackgroundResource(2130839682);
        }
      }
    }
    for (;;)
    {
      label1181:
      paramViewGroup.addView((View)localObject1);
      return;
      label1331:
      ((View)localObject1).setBackgroundResource(2130839689);
    }
  }
  
  private void b(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    this.mActionSheet = ((ausj)auss.a(this, null));
    boolean[] arrayOfBoolean = new boolean[4];
    boolean[] tmp19_17 = arrayOfBoolean;
    tmp19_17[0] = 0;
    boolean[] tmp25_19 = tmp19_17;
    tmp25_19[1] = 0;
    boolean[] tmp31_25 = tmp25_19;
    tmp31_25[2] = 0;
    boolean[] tmp37_31 = tmp31_25;
    tmp37_31[3] = 0;
    tmp37_31;
    if (paramInt == 2)
    {
      arrayOfBoolean[0] = true;
      String str = this.f.getString(2131721646);
      this.mActionSheet.addButton(str, 0);
      str = this.f.getString(2131721644);
      this.mActionSheet.addButton(str, 0);
    }
    if (paramInt == 0)
    {
      arrayOfBoolean[1] = true;
      this.mActionSheet.addButton(this.f.getString(2131692643), 1);
    }
    if (paramInt == 4)
    {
      arrayOfBoolean[2] = true;
      this.mActionSheet.addButton(this.f.getString(2131689931), 1);
      this.mActionSheet.addButton(this.f.getString(2131689926), 1);
    }
    if (paramInt == 3)
    {
      arrayOfBoolean[3] = true;
      this.mActionSheet.addButton(2131692643, 1);
      this.mActionSheet.addButton(2131692330, 1);
      this.mActionSheet.addButton(2131689787, 1);
      this.mActionSheet.addButton(2131695152, 1);
      this.mActionSheet.setMainTitle(String.format(paramContext.getString(2131696502), new Object[] { paramString1 }));
    }
    this.mActionSheet.a(new rty(this, arrayOfBoolean, paramString2, paramContext, paramString1));
    this.mActionSheet.addCancelButton(2131721058);
    this.mActionSheet.setOnDismissListener(new rtz(this));
    if (!this.mActionSheet.isShowing())
    {
      this.acX = false;
      this.mActionSheet.show();
    }
  }
  
  private void bwx()
  {
    super.setTitle(2131697399);
    this.nB = ((ImageView)super.findViewById(2131368698));
    this.zl = ((TextView)super.findViewById(2131379401));
    this.zm = ((TextView)super.findViewById(2131381219));
    this.cw = ((Button)super.findViewById(2131367381));
    this.zn = ((TextView)super.findViewById(2131372384));
    this.cw.setOnClickListener(this);
    this.ff = ((LinearLayout)super.findViewById(2131369423));
    if (!TextUtils.isEmpty(this.aCl)) {
      this.zl.setText(this.aCl);
    }
    if (TextUtils.isEmpty(this.mNickName)) {
      if (!TextUtils.isEmpty(this.aCm)) {
        this.zn.setText(this.f.getString(2131721139) + ": " + this.aCm);
      }
    }
    for (;;)
    {
      boolean bool = AppNetConnInfo.isWifiConn();
      if ((this.aJK) && (bool))
      {
        this.h = new Thread(new QRCardActivity.2(this));
        this.h.start();
      }
      updateView();
      return;
      this.zn.setText(this.f.getString(2131696319) + ": " + this.mNickName);
      if (!TextUtils.isEmpty(this.aCm)) {
        this.zm.setText(this.f.getString(2131721139) + ": " + this.aCm);
      }
    }
  }
  
  private ViewGroup i()
  {
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = (int)(this.mDensity * 5.0F);
    localLayoutParams.setMargins(0, i, 0, i << 1);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  private void updateView()
  {
    this.ff.removeAllViewsInLayout();
    ViewGroup localViewGroup1 = i();
    a(localViewGroup1, 0);
    ViewGroup localViewGroup2 = i();
    a(localViewGroup2, 1);
    this.ff.addView(localViewGroup1);
    this.ff.addView(localViewGroup2);
    this.ff.requestLayout();
    this.ff.invalidate();
  }
  
  public void a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, int paramInt3)
  {
    if (paramInt1 == 0) {
      paramView.setBackgroundResource(2130839701);
    }
    for (;;)
    {
      if (paramInt2 == 1) {
        paramView.setBackgroundResource(2130839682);
      }
      if (paramInt3 == 1)
      {
        paramView.setOnClickListener(new ruc(this));
        paramView.setOnLongClickListener(this.b);
      }
      paramViewGroup.addView(paramView);
      return;
      if (paramInt1 == paramInt2 - 1) {
        paramView.setBackgroundResource(2130839689);
      } else {
        paramView.setBackgroundResource(2130839695);
      }
    }
  }
  
  public void a(Intent paramIntent, HashMap<String, String> paramHashMap)
  {
    paramIntent.putExtra("job_title", this.aCm);
    paramIntent.putExtra("name", this.zl.getText().toString());
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramHashMap.get(str1);
      String[] arrayOfString = str2.split(";");
      if ((arrayOfString != null) && (arrayOfString.length > 0)) {
        if (str1.equals(this.aCj))
        {
          paramIntent.putExtra("company", str2);
        }
        else if (str1.equals(this.aCk))
        {
          paramIntent.putExtra("email", str2);
        }
        else if (str1.contains(this.aCb))
        {
          paramIntent.putExtra("phone", arrayOfString[0]);
          if (str1.contains(this.aCc)) {
            paramIntent.putExtra("phone_type", 1);
          }
          for (;;)
          {
            if (arrayOfString.length <= 1) {
              break label266;
            }
            paramIntent.putExtra("secondary_phone", arrayOfString[1]);
            if (!str1.contains(this.aCc)) {
              break label268;
            }
            paramIntent.putExtra("phone_type", 1);
            break;
            if (str1.contains(this.aCd)) {
              paramIntent.putExtra("phone_type", 3);
            } else {
              paramIntent.putExtra("phone_type", 7);
            }
          }
          label266:
          continue;
          label268:
          if (str1.contains(this.aCd)) {
            paramIntent.putExtra("phone_type", 3);
          } else {
            paramIntent.putExtra("phone_type", 7);
          }
        }
      }
    }
    try
    {
      startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QrcodeScannerCard", 2, "Intent.ACTION_INSERT or ACTION_INSERT_OR_EDIT do not exist");
    }
  }
  
  protected void aR(int paramInt, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    label54:
    label74:
    label81:
    Object localObject3;
    label183:
    int i;
    if (paramInt == 0)
    {
      if (paramString.length() <= "MECARD:".length()) {}
      do
      {
        do
        {
          return;
          paramString = paramString.substring("MECARD:".length());
        } while (TextUtils.isEmpty(paramString));
        localObject2 = paramString.split(";");
      } while (localObject2 == null);
      paramInt = 0;
      if (paramInt < localObject2.length) {
        if (localObject2[paramInt].contains(":")) {
          break label81;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break label54;
        break;
        localObject1 = localObject2[paramInt].split(":");
        if ((localObject1 != null) && (localObject1.length > 1) && (!TextUtils.isEmpty(localObject1[0])) && (!TextUtils.isEmpty(localObject1[1])))
        {
          localObject3 = localObject1[0].toLowerCase().trim();
          paramString = localObject1[1].trim();
          if (((String)localObject3).equalsIgnoreCase("n"))
          {
            this.aCl = paramString;
          }
          else
          {
            if (!((String)localObject3).equalsIgnoreCase("til")) {
              break label183;
            }
            this.aCm = paramString;
          }
        }
      }
      if (((String)localObject3).startsWith("photo"))
      {
        if (localObject1.length <= 2) {
          break label2423;
        }
        paramString = new StringBuilder();
        i = 1;
        while (i < localObject1.length)
        {
          paramString.append(localObject1[i]);
          if (i != localObject1.length - 1) {
            paramString.append(":");
          }
          i += 1;
        }
        paramString = paramString.toString();
      }
    }
    label749:
    label2420:
    label2423:
    for (;;)
    {
      this.mHeaderUrl = paramString;
      this.aJK = true;
      break label74;
      if (((String)localObject3).equals("tel"))
      {
        localObject1 = paramString;
        if (this.a.fC.containsKey(this.aCb)) {
          localObject1 = (String)this.a.fC.get(this.aCb) + ";" + paramString;
        }
        this.a.fC.put(this.aCb, localObject1);
        break label74;
      }
      if (((String)localObject3).equals("adr"))
      {
        localObject1 = paramString;
        if (this.a.fB.containsKey(this.aCe)) {
          localObject1 = (String)this.a.fB.get(this.aCe) + ";" + paramString;
        }
        this.a.fB.put(this.aCe, localObject1);
        break label74;
      }
      if (((String)localObject3).equals("email"))
      {
        this.a.fF.put(this.aCk, paramString);
        break label74;
      }
      if (((String)localObject3).equals("org"))
      {
        this.a.fE.put(this.aCj, paramString);
        break label74;
      }
      if (((String)localObject3).equals("url"))
      {
        if (localObject1.length > 2)
        {
          paramString = new StringBuilder();
          i = 1;
          while (i < localObject1.length)
          {
            paramString.append(localObject1[i]);
            if (i != localObject1.length - 1) {
              paramString.append(":");
            }
            i += 1;
          }
          paramString = paramString.toString();
        }
        this.a.fD.put(this.aCh, paramString);
        break label74;
      }
      if (((String)localObject3).equals("note"))
      {
        if (localObject1.length > 2)
        {
          paramString = new StringBuilder();
          i = 1;
          while (i < localObject1.length)
          {
            paramString.append(localObject1[i]);
            if (i != localObject1.length - 1) {
              paramString.append(":");
            }
            i += 1;
          }
          paramString = paramString.toString();
        }
        this.a.fA.put(this.aCi, paramString);
        break label74;
      }
      if (!((String)localObject3).equals("nickname")) {
        break label74;
      }
      this.mNickName = paramString;
      break label74;
      String[] arrayOfString;
      if (paramInt == 1)
      {
        if (paramString.length() <= "BEGIN:VCARD\nEND:VCARD".length()) {
          break;
        }
        if (paramString.contains("\n"))
        {
          localObject1 = "\n";
          paramString = paramString.substring("BEGIN:VCARD".length(), paramString.length() - "END:VCARD".length());
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          arrayOfString = paramString.split((String)localObject1);
          if (arrayOfString == null) {
            break;
          }
          paramInt = 0;
          if (paramInt < arrayOfString.length) {
            if (arrayOfString[paramInt].contains(":")) {
              break label856;
            }
          }
        }
        for (;;)
        {
          paramInt += 1;
          break label793;
          break;
          if (paramString.contains("\r"))
          {
            localObject1 = "\r";
            break label749;
          }
          if (!paramString.contains("\r\n")) {
            break;
          }
          localObject1 = "\r\n";
          break label749;
          localObject3 = arrayOfString[paramInt].split(":");
          if ((localObject3 != null) && (localObject3.length > 1) && (!TextUtils.isEmpty(localObject3[0])) && (!TextUtils.isEmpty(localObject3[1])))
          {
            localObject2 = localObject3[0].toLowerCase().trim();
            paramString = localObject3[1].trim();
            if (((((String)localObject2).equals("n")) || (((String)localObject2).equals("fn"))) && (TextUtils.isEmpty(this.aCl)))
            {
              localObject2 = paramString;
              if (paramString.contains(";"))
              {
                localObject3 = paramString.split(";");
                if ((localObject3 != null) && (localObject3.length > 0))
                {
                  int j = localObject3.length;
                  i = 0;
                  for (;;)
                  {
                    localObject2 = paramString;
                    if (i >= j) {
                      break;
                    }
                    localObject2 = localObject3[i];
                    paramString = paramString + " " + (String)localObject2;
                    i += 1;
                  }
                }
                localObject2 = "";
              }
              this.aCl = ((String)localObject2);
            }
            else if (((String)localObject2).equals("title"))
            {
              this.aCm = paramString;
            }
            else if (((String)localObject2).startsWith("photo"))
            {
              if (localObject3.length > 2)
              {
                paramString = new StringBuilder();
                i = 1;
                while (i < localObject3.length)
                {
                  paramString.append(localObject3[i]);
                  if (i != localObject3.length - 1) {
                    paramString.append(":");
                  }
                  i += 1;
                }
                paramString = paramString.toString();
              }
              this.mHeaderUrl = paramString;
              this.aJK = true;
            }
            else
            {
              if (!((String)localObject2).equals("nickname")) {
                break label1176;
              }
              this.mNickName = paramString;
            }
          }
        }
        if (((String)localObject2).startsWith("tel")) {
          if (((String)localObject2).contains("home"))
          {
            localObject2 = this.aCc;
            if ((!"tel".equals(paramString)) || (localObject3.length <= 2)) {
              break label2420;
            }
            paramString = localObject3[2];
          }
        }
      }
      for (;;)
      {
        localObject3 = paramString;
        if (this.a.fC.containsKey(localObject2)) {
          localObject3 = (String)this.a.fC.get(localObject2) + ";" + paramString;
        }
        this.a.fC.put(localObject2, localObject3);
        break label813;
        if (((String)localObject2).contains("work"))
        {
          localObject2 = this.aCd;
          break label1204;
        }
        localObject2 = this.aCb;
        break label1204;
        if (((String)localObject2).contains("adr"))
        {
          if (((String)localObject2).contains("home")) {
            localObject2 = this.aCf;
          }
          for (;;)
          {
            if (paramString.contains(";;"))
            {
              localObject3 = new StringBuilder();
              paramString = paramString.substring(2);
              if (TextUtils.isEmpty(paramString)) {
                break;
              }
              paramString = paramString.split(";");
              if (paramString == null) {
                break;
              }
              i = 0;
              for (;;)
              {
                if (i < paramString.length)
                {
                  if (!TextUtils.isEmpty(paramString[i]))
                  {
                    ((StringBuilder)localObject3).append(paramString[i]);
                    if (i != paramString.length - 1) {
                      ((StringBuilder)localObject3).append((String)localObject1);
                    }
                  }
                  i += 1;
                  continue;
                  if (((String)localObject2).contains("work"))
                  {
                    localObject2 = this.aCg;
                    break;
                  }
                  localObject2 = this.aCe;
                  break;
                }
              }
              paramString = ((StringBuilder)localObject3).toString();
            }
          }
        }
        for (;;)
        {
          localObject3 = paramString;
          if (this.a.fB.containsKey(localObject2)) {
            localObject3 = (String)this.a.fB.get(localObject2) + ";" + paramString;
          }
          this.a.fB.put(localObject2, localObject3);
          break label813;
          if (((String)localObject2).equals("email"))
          {
            this.a.fF.put(this.aCk, paramString);
            break label813;
          }
          if (((String)localObject2).equals("org"))
          {
            this.a.fE.put(this.aCj, paramString);
            break label813;
          }
          if (((String)localObject2).equals("url"))
          {
            if (localObject3.length > 2)
            {
              paramString = new StringBuilder();
              i = 1;
              while (i < localObject3.length)
              {
                paramString.append(localObject3[i]);
                if (i != localObject3.length - 1) {
                  paramString.append(":");
                }
                i += 1;
              }
              paramString = paramString.toString();
            }
            this.a.fD.put(this.aCh, paramString);
            break label813;
          }
          if (!((String)localObject2).equals("note")) {
            break label813;
          }
          if (localObject3.length > 2)
          {
            paramString = new StringBuilder();
            i = 1;
            while (i < localObject3.length)
            {
              paramString.append(localObject3[i]);
              if (i != localObject3.length - 1) {
                paramString.append(":");
              }
              i += 1;
            }
            paramString = paramString.toString();
          }
          this.a.fA.put(this.aCi, paramString);
          break label813;
          if (paramString.length() <= "BIZCARD:;;".length()) {
            break;
          }
          localObject2 = paramString.substring("BIZCARD:".length(), paramString.length() - ";;".length());
          if (TextUtils.isEmpty(paramString)) {
            break;
          }
          arrayOfString = ((String)localObject2).split(";");
          if (arrayOfString == null) {
            break;
          }
          paramInt = 0;
          paramString = null;
          if (paramInt < arrayOfString.length)
          {
            if (!arrayOfString[paramInt].contains(":"))
            {
              localObject2 = localObject1;
              localObject1 = paramString;
              paramString = (String)localObject2;
            }
            for (;;)
            {
              paramInt += 1;
              localObject2 = localObject1;
              localObject1 = paramString;
              paramString = (String)localObject2;
              break;
              localObject2 = arrayOfString[paramInt].split(":");
              if ((localObject2 != null) && (localObject2.length > 1) && (!TextUtils.isEmpty(localObject2[0])))
              {
                if (TextUtils.isEmpty(localObject2[1]))
                {
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                localObject3 = localObject2[0].toLowerCase().trim();
                localObject2 = localObject2[1].trim();
                if (((String)localObject3).equals("x"))
                {
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("n"))
                {
                  localObject1 = paramString;
                  paramString = (String)localObject2;
                  continue;
                }
                if (((String)localObject3).equals("t"))
                {
                  this.aCm = ((String)localObject2);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("b"))
                {
                  localObject3 = localObject2;
                  if (this.a.fC.containsKey(this.aCb)) {
                    localObject3 = (String)this.a.fC.get(this.aCb) + ";" + (String)localObject2;
                  }
                  this.a.fC.put(this.aCb, localObject3);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("a"))
                {
                  localObject3 = localObject2;
                  if (this.a.fB.containsKey(this.aCe)) {
                    localObject3 = (String)this.a.fB.get(this.aCe) + ";" + (String)localObject2;
                  }
                  this.a.fB.put(this.aCe, localObject3);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("e"))
                {
                  this.a.fF.put(this.aCk, localObject2);
                  localObject2 = paramString;
                  paramString = (String)localObject1;
                  localObject1 = localObject2;
                  continue;
                }
                if (((String)localObject3).equals("c")) {
                  this.a.fE.put(this.aCj, localObject2);
                }
              }
              localObject2 = paramString;
              paramString = (String)localObject1;
              localObject1 = localObject2;
            }
          }
          if (!TextUtils.isEmpty(paramString))
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              this.aCl = (paramString + " " + (String)localObject1);
              return;
            }
            this.aCl = paramString;
            return;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          this.aCl = ((String)localObject1);
          return;
        }
      }
    }
  }
  
  public void bww()
  {
    this.f = super.getResources();
    this.mDensity = this.f.getDisplayMetrics().density;
    this.aCb = this.f.getString(2131720976);
    this.aCc = this.f.getString(2131694633);
    this.aCd = this.f.getString(2131721910);
    this.aCe = this.f.getString(2131689934);
    this.aCf = this.f.getString(2131694632);
    this.aCg = this.f.getString(2131721909);
    this.aCh = this.f.getString(2131721640);
    this.aCi = this.f.getString(2131696400);
    this.aCj = this.f.getString(2131696694);
    this.aCk = this.f.getString(2131693036);
    this.mLinkColor = super.getResources().getColor(2131165943);
    this.a = new rws();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(null, 4, null, null);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131560596);
    paramBundle = super.getIntent();
    bww();
    String str = paramBundle.getStringExtra("QRCARDSTR");
    aR(paramBundle.getIntExtra("CARDMODE", 3), str);
    bwx();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.h != null)
    {
      this.aJJ = true;
      this.bv.removeMessages(0);
    }
    if (this.mActionSheet != null) {
      this.mActionSheet.dismiss();
    }
  }
  
  public void sL(String paramString)
  {
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(2131717212);
    localaqju.setMessage(paramString);
    rua localrua = new rua(this);
    localaqju.setPositiveButton(2131721079, new rub(this, paramString));
    localaqju.setNegativeButton(2131721058, localrua);
    localaqju.show();
  }
  
  class NumberSpan
    extends URLSpan
  {
    public NumberSpan(String paramString)
    {
      super();
    }
    
    public void onClick(View paramView)
    {
      String str = getURL();
      if (!TextUtils.isEmpty(str))
      {
        if (!Pattern.compile("\\d{5,}").matcher(str).matches()) {
          break label42;
        }
        QRCardActivity.a(QRCardActivity.this, paramView.getContext(), 3, str, null);
      }
      label42:
      while (!Pattern.compile(QRCardActivity.aCn).matcher(str).matches()) {
        return;
      }
      QRCardActivity.this.sL(str);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(QRCardActivity.this.mLinkColor);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRCardActivity
 * JD-Core Version:    0.7.0.1
 */