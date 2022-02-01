package com.tencent.mobileqq.activity.phone;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import aqcl;
import aqho;
import aqje;
import aqje.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.minigame.utils.AssetsUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import zqm;
import zqn;
import zqo;

public class CountryActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IndexView.a
{
  LinkedHashMap<String, Integer> I = new LinkedHashMap();
  private a a;
  public d a;
  private EditText aQ;
  public IndexView c;
  private PinnedDividerListView e;
  ArrayList<aqje.a> rI = new ArrayList();
  public View rootView;
  private View yS;
  public View yg;
  
  private static View a(ViewGroup paramViewGroup, LayoutInflater paramLayoutInflater, boolean paramBoolean)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559746, paramViewGroup, false);
    if (paramBoolean) {
      paramViewGroup.setPadding(paramViewGroup.getPaddingLeft(), paramViewGroup.getPaddingTop(), (int)aqho.convertDpToPixel(BaseApplicationImpl.sApplication, 40.0F), paramViewGroup.getPaddingBottom());
    }
    paramLayoutInflater = new b(null);
    paramLayoutInflater.nameText = ((TextView)paramViewGroup.findViewById(2131365475));
    paramLayoutInflater.Na = ((TextView)paramViewGroup.findViewById(2131365474));
    paramViewGroup.setTag(paramLayoutInflater);
    return paramViewGroup;
  }
  
  static void a(View paramView, aqje.a parama)
  {
    paramView = (b)paramView.getTag();
    paramView.nameText.setText(parama.name);
    paramView.Na.setText("+" + parama.code);
    paramView.a = parama;
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.e.setSelection(0);
      return;
    }
    PinnedDividerListView localPinnedDividerListView = this.e;
    int i = this.e.getHeaderViewsCount();
    localPinnedDividerListView.setSelection(((Integer)this.I.get(paramString)).intValue() + i);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559744);
    String[] arrayOfString = getResources().getStringArray(2130968655);
    Object localObject = aqje.ah(AssetsUtil.getContentFromAssets(this, "internationalCode.json"));
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.rI;
    }
    this.rI = paramBundle;
    localObject = aqje.a(arrayOfString, this.rI);
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = this.I;
    }
    this.I = paramBundle;
    setTitle(acfp.m(2131704510));
    this.leftView.setText(2131691039);
    this.yg = findViewById(2131377361);
    this.rootView = ((View)this.yg.getParent());
    this.e = ((PinnedDividerListView)findViewById(2131365476));
    this.yS = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2131563007, this.e, false);
    this.yS.setPadding(0, 0, 40, 0);
    this.yS.findViewById(2131363801).setVisibility(8);
    this.aQ = ((EditText)this.yS.findViewById(2131366542));
    this.aQ.setFocusableInTouchMode(false);
    this.aQ.setCursorVisible(false);
    this.aQ.setOnClickListener(this);
    aqcl.iq(this.yS);
    this.e.addHeaderView(this.yS);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$a = new a(null);
    this.e.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$a);
    this.c = ((IndexView)findViewById(2131369141));
    this.c.setIndex(arrayOfString, true);
    this.c.setOnIndexChangedListener(this);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.aQ)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$d = new d(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$d.setCanceledOnTouchOutside(true);
      int i = this.yg.getHeight();
      TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
      localTranslateAnimation1.setDuration(300L);
      localTranslateAnimation1.setFillAfter(true);
      localTranslateAnimation1.setAnimationListener(new zqm(this));
      TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation2.setDuration(300L);
      localTranslateAnimation2.setAnimationListener(new zqn(this, i));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$d.setOnDismissListener(new zqo(this, i, localTranslateAnimation2));
      this.rootView.startAnimation(localTranslateAnimation1);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onItemClick(paramView);
    }
  }
  
  public void onItemClick(View paramView)
  {
    paramView = (b)paramView.getTag();
    if (paramView.a != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$d != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$d.isShowing()) && (!super.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$d.dismiss();
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("k_name", paramView.a.name);
      localIntent.putExtra("k_code", paramView.a.code);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  class a
    extends PinnedDividerListView.a
  {
    private a() {}
    
    public int ag()
    {
      return 2131559745;
    }
    
    public void b(View paramView, int paramInt)
    {
      paramInt = ((Integer)CountryActivity.this.I.get(((aqje.a)CountryActivity.this.rI.get(paramInt)).tag)).intValue();
      ((TextView)paramView).setText(((aqje.a)CountryActivity.this.rI.get(paramInt)).tag);
    }
    
    public int getCount()
    {
      return CountryActivity.this.rI.size();
    }
    
    public Object getItem(int paramInt)
    {
      return CountryActivity.this.rI.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (((aqje.a)CountryActivity.this.rI.get(paramInt)).cUl) {
        return 0;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      aqje.a locala = (aqje.a)CountryActivity.this.rI.get(paramInt);
      if (getItemViewType(paramInt) == 0)
      {
        if (paramView != null) {
          break label121;
        }
        paramView = CountryActivity.this.getLayoutInflater().inflate(ag(), paramViewGroup, false);
      }
      label121:
      for (;;)
      {
        ((TextView)paramView).setText(locala.tag);
        for (;;)
        {
          paramView.setVisibility(0);
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          View localView = paramView;
          if (paramView == null)
          {
            localView = CountryActivity.b(paramViewGroup, CountryActivity.this.getLayoutInflater(), false);
            localView.setOnClickListener(CountryActivity.this);
          }
          CountryActivity.a(localView, locala);
          paramView = localView;
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    public boolean t(int paramInt)
    {
      return ((aqje.a)CountryActivity.this.rI.get(paramInt)).cUl;
    }
  }
  
  static class b
  {
    public TextView Na;
    public aqje.a a;
    public TextView nameText;
  }
  
  class c
    extends BaseAdapter
  {
    private String baC = "";
    private ArrayList<aqje.a> rJ = CountryActivity.this.rI;
    
    private c() {}
    
    private int a(aqje.a parama)
    {
      if (parama.cUl) {
        return 0;
      }
      if ((this.baC == null) || (this.baC.equals(""))) {
        return 0;
      }
      String str2 = parama.code;
      String str3 = parama.name;
      String str1 = parama.bYY;
      parama = str1;
      if (str1 != null) {
        parama = str1.toLowerCase();
      }
      str1 = ChnToSpell.aJ(str3, 1);
      String str4 = ChnToSpell.aJ(str3, 2);
      if ((str2.equals(this.baC)) || (str3.equals(this.baC)) || (str1.equals(this.baC)) || (str4.equals(this.baC)) || ((parama != null) && (parama.equals(this.baC)))) {
        return 3;
      }
      if ((str2.indexOf(this.baC) == 0) || (str3.indexOf(this.baC) == 0) || (str1.indexOf(this.baC) == 0) || (str4.indexOf(this.baC) == 0) || ((parama != null) && (parama.indexOf(this.baC) == 0))) {
        return 2;
      }
      if ((str2.indexOf(this.baC) > 0) || (str3.indexOf(this.baC) > 0) || (str1.indexOf(this.baC) > 0) || (str4.indexOf(this.baC) > 0)) {
        return 1;
      }
      return 0;
    }
    
    public void cY(String paramString)
    {
      int j = 0;
      Object localObject = paramString.toLowerCase();
      paramString = (String)localObject;
      if (((String)localObject).equals("hk")) {
        paramString = "xianggang";
      }
      localObject = paramString;
      if (paramString.equals("uk")) {
        localObject = "united kingdom";
      }
      int i;
      label81:
      aqje.a locala;
      int k;
      if (((String)localObject).startsWith(this.baC))
      {
        paramString = this.rJ;
        this.baC = ((String)localObject);
        localObject = new ArrayList(8);
        paramString = paramString.iterator();
        i = 0;
        if (!paramString.hasNext()) {
          break label181;
        }
        locala = (aqje.a)paramString.next();
        k = a(locala);
        if (k != 3) {
          break label141;
        }
        ((ArrayList)localObject).add(j, locala);
        j += 1;
      }
      for (;;)
      {
        break label81;
        paramString = CountryActivity.this.rI;
        break;
        label141:
        if (k == 2)
        {
          ((ArrayList)localObject).add(i + j, locala);
          i += 1;
        }
        else if (k == 1)
        {
          ((ArrayList)localObject).add(locala);
        }
      }
      label181:
      this.rJ = ((ArrayList)localObject);
      notifyDataSetChanged();
    }
    
    public int getCount()
    {
      return this.rJ.size();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = CountryActivity.b(paramViewGroup, CountryActivity.this.getLayoutInflater(), true);
        paramView.setOnClickListener(CountryActivity.this);
      }
      for (;;)
      {
        CountryActivity.a(paramView, (aqje.a)this.rJ.get(paramInt));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  public class d
    extends ReportDialog
    implements TextWatcher, View.OnClickListener, View.OnTouchListener
  {
    private TextView Nh;
    private CountryActivity.c jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$c;
    EditText aR;
    ImageButton as;
    private ListView p;
    private View yT;
    
    public d(Context paramContext)
    {
      super();
      requestWindowFeature(1);
      getWindow().setSoftInputMode(36);
      getWindow().setBackgroundDrawable(new ColorDrawable());
      setContentView(2131559079);
      paramContext = getWindow().getAttributes();
      paramContext.x = 0;
      paramContext.y = 0;
      paramContext.width = -1;
      paramContext.windowAnimations = 16973824;
      paramContext.gravity = 51;
      this.aR = ((EditText)findViewById(2131366542));
      this.aR.addTextChangedListener(this);
      this.aR.setSelection(0);
      this.aR.requestFocus();
      this.as = ((ImageButton)findViewById(2131368696));
      this.as.setOnClickListener(this);
      paramContext = (Button)findViewById(2131363801);
      paramContext.setVisibility(0);
      paramContext.setOnClickListener(this);
      this.yT = findViewById(2131377207);
      this.Nh = ((TextView)findViewById(2131372437));
      this.Nh.setCompoundDrawables(null, null, null, null);
      this.Nh.setText(2131719279);
      findViewById(2131377828).setVisibility(8);
      this.p = ((ListView)findViewById(2131377856));
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$c = new CountryActivity.c(CountryActivity.this, null);
      this.p.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$c);
      this.p.setOnTouchListener(this);
    }
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = this.aR.getText().toString().trim();
      vv(paramEditable);
      if (paramEditable.equals(""))
      {
        this.as.setVisibility(8);
        return;
      }
      this.as.setVisibility(0);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    /* Error */
    public void dismiss()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 197	android/app/Dialog:dismiss	()V
      //   4: aload_0
      //   5: invokestatic 203	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
      //   8: return
      //   9: astore_1
      //   10: aload_0
      //   11: invokestatic 203	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
      //   14: return
      //   15: astore_1
      //   16: aload_0
      //   17: invokestatic 203	txb:fixMesssageLeak	(Landroid/app/Dialog;)V
      //   20: aload_1
      //   21: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	22	0	this	d
      //   9	1	1	localException	java.lang.Exception
      //   15	6	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	4	9	java/lang/Exception
      //   0	4	15	finally
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
        dismiss();
        continue;
        this.aR.setText("");
      }
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      ((InputMethodManager)CountryActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      return false;
    }
    
    void vv(String paramString)
    {
      if ((paramString.equals("")) || (paramString.trim().length() == 0))
      {
        this.yT.setVisibility(8);
        return;
      }
      this.yT.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$c.cY(paramString);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$c.getCount() == 0) {
        this.Nh.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhoneCountryActivity$c.notifyDataSetChanged();
        return;
        this.Nh.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.CountryActivity
 * JD-Core Version:    0.7.0.1
 */