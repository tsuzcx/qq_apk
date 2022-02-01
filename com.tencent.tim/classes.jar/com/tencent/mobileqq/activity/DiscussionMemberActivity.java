package com.tencent.mobileqq.activity;

import abdw;
import abeg;
import abeg.a;
import acci;
import acdu;
import acfd;
import acff;
import acfp;
import android.app.Dialog;
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
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqdj;
import aqgv;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.a;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import uva;
import uvb;
import uvc;
import uvd;
import uve;
import uvf;
import uvg;
import uvh;

public class DiscussionMemberActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, View.OnTouchListener, IndexView.a, PinnedDividerListView.b, AdapterView.c
{
  private b a;
  public d a;
  private String aMM;
  private String aMN;
  private ImageButton ae;
  private EditText ax;
  public EditText ay;
  private IndexView b;
  private final int bFA = 1;
  PinnedDividerListView d;
  private RelativeLayout ex;
  private View hY;
  public View mRootView;
  private List<a> mSearchResultList = new ArrayList();
  XListView o;
  List<a> qG = new ArrayList();
  View sp;
  private View sq;
  private View sr;
  
  private void bNp()
  {
    acff localacff = (acff)this.app.getManager(51);
    Object localObject = (acdu)this.app.getManager(53);
    if (localacff != null)
    {
      localObject = ((acdu)localObject).z(this.aMM);
      if (localObject != null)
      {
        this.qG.clear();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)((Iterator)localObject).next();
          if (localDiscussionMemberInfo.memberUin.equals(this.app.getCurrentAccountUin()))
          {
            this.aMN = aqgv.a(this.app, localDiscussionMemberInfo);
          }
          else
          {
            a locala = new a(null);
            locala.uin = localDiscussionMemberInfo.memberUin;
            locala.name = aqgv.a(localDiscussionMemberInfo, this.app);
            localacff.e(locala.uin);
            locala.pinyinAll = ChnToSpell.aJ(locala.name, 1);
            locala.pinyinFirst = ChnToSpell.aJ(locala.name, 2);
            this.qG.add(locala);
          }
        }
      }
    }
  }
  
  private void cq()
  {
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131563018);
    Object localObject1 = localReportDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject1).x = 0;
    ((WindowManager.LayoutParams)localObject1).y = 0;
    ((WindowManager.LayoutParams)localObject1).width = -1;
    ((WindowManager.LayoutParams)localObject1).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject1).gravity = 51;
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    int i = this.hY.getHeight();
    Object localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i);
    ((TranslateAnimation)localObject3).setDuration(300L);
    ((TranslateAnimation)localObject3).setFillAfter(true);
    Object localObject2 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    localObject1 = (InputMethodManager)getSystemService("input_method");
    uva localuva = new uva(this, (TranslateAnimation)localObject3, localReportDialog, (TranslateAnimation)localObject2, i);
    ((TranslateAnimation)localObject3).setAnimationListener(localuva);
    ((TranslateAnimation)localObject2).setAnimationListener(localuva);
    this.mRootView.startAnimation((Animation)localObject3);
    localObject3 = new uvb(this);
    addObserver((acci)localObject3);
    localReportDialog.setOnDismissListener(new uvc(this, i, (TranslateAnimation)localObject2, (InputMethodManager)localObject1, (acfd)localObject3));
    this.ay = ((EditText)localReportDialog.findViewById(2131366542));
    this.ay.addTextChangedListener(new e(null));
    this.ay.setSelection(0);
    this.ay.requestFocus();
    this.ae = ((ImageButton)localReportDialog.findViewById(2131368696));
    this.ae.setOnClickListener(new uvd(this));
    localObject2 = (Button)localReportDialog.findViewById(2131363801);
    ((Button)localObject2).setVisibility(0);
    ((Button)localObject2).setOnClickListener(new uve(this, localReportDialog));
    this.sq = localReportDialog.findViewById(2131372437);
    this.ex = ((RelativeLayout)localReportDialog.findViewById(2131377207));
    this.ex.setOnClickListener(new uvf(this, localReportDialog));
    this.o = ((XListView)localReportDialog.findViewById(2131377779));
    this.o.setBackgroundDrawable(getResources().getDrawable(2130838900));
    this.o.setDividerHeight(0);
    this.mSearchResultList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$d = new d(this.mSearchResultList);
    this.o.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$d);
    this.o.setOnTouchListener(new uvg(this, (InputMethodManager)localObject1));
    this.o.setOnItemClickListener(new uvh(this, localReportDialog));
  }
  
  private void initUI()
  {
    this.d = ((PinnedDividerListView)findViewById(2131364452));
    this.b = ((IndexView)findViewById(2131369142));
    this.d.setSelector(2131167595);
    this.d.setOnItemClickListener(this);
    this.d.setOnLayoutListener(this);
    this.b.setIndex(new String[] { "$", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.b.setOnIndexChangedListener(this);
    this.hY = findViewById(2131377361);
    this.mRootView = ((View)this.hY.getParent());
    this.sp = findViewById(2131377947);
    this.sp.setBackgroundResource(2130838900);
    setTitle(acfp.m(2131705145));
    Object localObject = (RelativeLayout)getLayoutInflater().inflate(2131563007, this.d, false);
    ((RelativeLayout)localObject).setPadding(0, 0, 40, 0);
    this.ax = ((EditText)((RelativeLayout)localObject).findViewById(2131366542));
    this.ax.setFocusable(false);
    this.ax.setOnTouchListener(this);
    ((Button)((RelativeLayout)localObject).findViewById(2131363801)).setVisibility(8);
    this.d.addHeaderView((View)localObject);
    this.sr = getLayoutInflater().inflate(2131559251, this.d, false);
    TroopMemberListActivity.i locali = new TroopMemberListActivity.i();
    locali.uin = this.app.getCurrentAccountUin();
    locali.pQ = ((ImageView)this.sr.findViewById(2131369767));
    locali.pQ.setBackgroundDrawable(aqdj.a(this.app, this.app.getCurrentAccountUin(), (byte)1));
    locali.fe = ((TextView)this.sr.findViewById(2131380814));
    localObject = this.app.getCurrentNickname();
    TextView localTextView = locali.fe;
    if ((localObject != null) && (((String)localObject).trim().length() > 0)) {}
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      this.sr.setTag(locali);
      this.sr.setOnClickListener(this);
      this.d.addHeaderView(this.sr);
      return;
      localObject = this.app.getCurrentAccountUin();
    }
  }
  
  public void O(String paramString)
  {
    if ("$".equals(paramString)) {
      this.d.setSelection(0);
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$b.m(paramString);
    } while (i == -1);
    this.d.setSelection(i + this.d.getHeaderViewsCount());
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.d.getFirstVisiblePosition() > 0) || ((this.d.getFirstVisiblePosition() == 0) && (this.d.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$b.getCount() + this.d.getHeaderViewsCount()))) {
      this.b.setVisibility(0);
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((-1 == paramInt2) && (paramInt2 == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$b.notifyDataSetChanged();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131563053);
    this.aMM = getIntent().getStringExtra("uin");
    initUI();
    bNp();
    ((TroopMemberListActivity.i)this.sr.getTag()).fe.setText(this.aMN);
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$b = new b();
    this.d.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$b);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$b.destroy();
    super.doOnDestroy();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(48);
  }
  
  public void eE(View paramView)
  {
    paramView = (abeg.a)paramView.getTag();
    if ((paramView != null) && (paramView.uin != null))
    {
      paramView = paramView.uin;
      if (paramView.equals(this.app.getCurrentAccountUin()))
      {
        paramView = new ProfileActivity.AllInOne(paramView, 0);
        paramView.bIZ = 5;
        ProfileActivity.a(this, paramView, 1);
      }
    }
    else
    {
      return;
    }
    if (((acff)this.app.getManager(51)).isFriend(paramView))
    {
      localAllInOne = new ProfileActivity.AllInOne(paramView, 1);
      localAllInOne.nickname = aqgv.d(this.app, paramView, 0);
      localAllInOne.bIZ = 5;
      ProfileActivity.a(this, localAllInOne, 1);
      return;
    }
    ProfileActivity.AllInOne localAllInOne = new ProfileActivity.AllInOne(paramView, 46);
    localAllInOne.nickname = aqgv.d(this.app, paramView, 0);
    localAllInOne.aOF = paramView;
    localAllInOne.bIX = 3000;
    localAllInOne.discussUin = this.aMM;
    localAllInOne.bIZ = 5;
    ProfileActivity.a(this, localAllInOne, 1);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.sr) {
      eE(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    eE(paramView);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      cq();
    }
    return true;
  }
  
  void vv(String paramString)
  {
    this.mSearchResultList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.ae.setVisibility(8);
      this.o.setVisibility(8);
      this.sq.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity$d.notifyDataSetChanged();
      return;
      this.ae.setVisibility(0);
      this.o.setVisibility(0);
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      Iterator localIterator = this.qG.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala != null) {
          if ((locala.name.equals(paramString)) || (locala.uin.equals(paramString)) || (locala.pinyinAll.equals(paramString.toLowerCase())) || (locala.pinyinFirst.equals(paramString.toLowerCase()))) {
            localArrayList1.add(locala);
          } else if ((locala.name.indexOf(paramString) == 0) || (locala.uin.indexOf(paramString) == 0) || (locala.pinyinFirst.indexOf(paramString.toLowerCase()) == 0) || (locala.pinyinAll.indexOf(paramString.toLowerCase()) == 0)) {
            localArrayList2.add(locala);
          } else if ((locala.name.indexOf(paramString) > 0) || (locala.uin.indexOf(paramString) > 0) || (locala.pinyinFirst.indexOf(paramString.toLowerCase()) > 0) || (locala.pinyinAll.indexOf(paramString.toLowerCase()) > 0)) {
            localArrayList3.add(locala);
          }
        }
      }
      Collections.sort(localArrayList2, new c(null));
      this.mSearchResultList.addAll(localArrayList1);
      this.mSearchResultList.addAll(localArrayList2);
      this.mSearchResultList.addAll(localArrayList3);
      if (this.mSearchResultList.isEmpty()) {
        this.sq.setVisibility(0);
      } else {
        this.sq.setVisibility(8);
      }
    }
  }
  
  class a
  {
    public String name;
    public String pinyinAll;
    public String pinyinFirst;
    public String uin;
    
    private a() {}
  }
  
  class b
    extends abdw
  {
    private LinkedHashMap<String, List<DiscussionMemberActivity.a>> D = new LinkedHashMap();
    private int[] ad = new int[0];
    private String[] k = new String[0];
    
    public b()
    {
      super(DiscussionMemberActivity.this.app, DiscussionMemberActivity.this.d, true);
      bNq();
    }
    
    private void bNq()
    {
      this.D.clear();
      Object localObject2 = DiscussionMemberActivity.this.qG.iterator();
      label66:
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        DiscussionMemberActivity.a locala = (DiscussionMemberActivity.a)((Iterator)localObject2).next();
        if ((locala.pinyinFirst == null) || (locala.pinyinFirst.length() == 0))
        {
          localObject1 = "#";
          i = ((String)localObject1).charAt(0);
          if (((65 > i) || (i > 90)) && ((97 > i) || (i > 122))) {
            break label171;
          }
        }
        label171:
        for (localObject1 = ((String)localObject1).toUpperCase();; localObject1 = "#")
        {
          if (this.D.get(localObject1) == null) {
            this.D.put(localObject1, new ArrayList());
          }
          ((List)this.D.get(localObject1)).add(locala);
          break;
          localObject1 = locala.pinyinFirst.substring(0, 1);
          break label66;
        }
      }
      Object localObject1 = this.D;
      this.D = new LinkedHashMap();
      for (char c = 'A'; c <= 'Z'; c = (char)(c + '\001')) {
        if (((LinkedHashMap)localObject1).get(String.valueOf(c)) != null) {
          this.D.put(String.valueOf(c), ((LinkedHashMap)localObject1).get(String.valueOf(c)));
        }
      }
      if (((LinkedHashMap)localObject1).get("#") != null) {
        this.D.put("#", ((LinkedHashMap)localObject1).get("#"));
      }
      ((LinkedHashMap)localObject1).clear();
      this.ad = new int[this.D.keySet().size()];
      this.k = new String[this.ad.length];
      localObject1 = this.D.keySet().iterator();
      if (this.ad.length == 0) {}
      for (;;)
      {
        return;
        this.ad[0] = 0;
        i = 1;
        while (i < this.ad.length)
        {
          localObject2 = this.ad;
          int j = localObject2[i];
          int m = this.ad[(i - 1)];
          localObject2[i] = (((List)this.D.get(((Iterator)localObject1).next())).size() + m + 1 + j);
          i += 1;
        }
        localObject1 = this.D.keySet().iterator();
        i = 0;
        while (((Iterator)localObject1).hasNext())
        {
          this.k[i] = ((String)((Iterator)localObject1).next());
          i += 1;
        }
      }
    }
    
    public int ag()
    {
      return 2131559496;
    }
    
    public void b(View paramView, int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      paramInt = i;
      if (i < 0) {
        paramInt = -(i + 1) - 1;
      }
      ((TextView)paramView).setText(this.k[paramInt]);
    }
    
    public int getCount()
    {
      if (this.ad.length == 0) {
        return 0;
      }
      int i = this.ad[(this.ad.length - 1)];
      return ((List)this.D.get(this.k[(this.k.length - 1)])).size() + i + 1;
    }
    
    public Object getItem(int paramInt)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      if (i >= 0) {
        return null;
      }
      i = -(i + 1) - 1;
      return (DiscussionMemberActivity.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = Arrays.binarySearch(this.ad, paramInt);
      TroopMemberListActivity.i locali;
      if (paramView == null)
      {
        paramView = DiscussionMemberActivity.this.getLayoutInflater().inflate(2131559251, paramViewGroup, false);
        locali = new TroopMemberListActivity.i();
        paramView.setTag(locali);
        locali.hk = ((RelativeLayout)paramView.findViewById(2131377444));
        locali.Gn = ((TextView)paramView.findViewById(2131380761));
        locali.pQ = ((ImageView)paramView.findViewById(2131369767));
        locali.fe = ((TextView)paramView.findViewById(2131380814));
      }
      for (;;)
      {
        locali = (TroopMemberListActivity.i)paramView.getTag();
        if (i < 0)
        {
          i = -(i + 1) - 1;
          DiscussionMemberActivity.a locala = (DiscussionMemberActivity.a)((List)this.D.get(this.k[i])).get(paramInt - this.ad[i] - 1);
          locali.hk.setVisibility(0);
          locali.Gn.setVisibility(8);
          locali.pQ.setImageBitmap(e(locala.uin, 1));
          locali.fe.setText(locala.name);
          locali.uin = locala.uin;
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          locali.hk.setVisibility(8);
          locali.Gn.setVisibility(0);
          locali.Gn.setText(String.valueOf(this.k[i]));
        }
      }
    }
    
    public int m(String paramString)
    {
      int i;
      if (this.k != null)
      {
        i = 0;
        if (i >= this.k.length) {
          break label53;
        }
        if (!this.k[i].equals(paramString)) {}
      }
      for (;;)
      {
        if (i >= 0)
        {
          return this.ad[i];
          i += 1;
          break;
        }
        return -1;
        return -1;
        label53:
        i = -1;
      }
    }
    
    public void notifyDataSetChanged()
    {
      bNq();
      super.notifyDataSetChanged();
    }
    
    public boolean t(int paramInt)
    {
      return Arrays.binarySearch(this.ad, paramInt) >= 0;
    }
  }
  
  class c
    implements Comparator<DiscussionMemberActivity.a>
  {
    private c() {}
    
    public int a(DiscussionMemberActivity.a parama1, DiscussionMemberActivity.a parama2)
    {
      return parama1.pinyinFirst.compareToIgnoreCase(parama2.pinyinFirst);
    }
  }
  
  public class d
    extends abeg
  {
    private List<DiscussionMemberActivity.a> mList;
    
    public d()
    {
      super(DiscussionMemberActivity.this.app, DiscussionMemberActivity.this.o, 1, true);
      Object localObject;
      this.mList = localObject;
    }
    
    public int getCount()
    {
      if (this.mList == null) {
        return 0;
      }
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      Object localObject;
      if (paramView == null)
      {
        localView = DiscussionMemberActivity.this.getLayoutInflater().inflate(2131559251, paramViewGroup, false);
        paramView = new DiscussionMemberActivity.f(null);
        paramView.pQ = ((ImageView)localView.findViewById(2131369767));
        paramView.fe = ((TextView)localView.findViewById(2131380814));
        localView.setTag(paramView);
        localObject = (DiscussionMemberActivity.a)getItem(paramInt);
        if (localObject != null)
        {
          if ((((DiscussionMemberActivity.a)localObject).name != null) && (!"".equals(((DiscussionMemberActivity.a)localObject).name.trim()))) {
            break label176;
          }
          paramView.fe.setText(((DiscussionMemberActivity.a)localObject).uin);
        }
      }
      for (;;)
      {
        paramView.uin = ((DiscussionMemberActivity.a)localObject).uin;
        paramView.pQ.setImageBitmap(a(1, ((DiscussionMemberActivity.a)localObject).uin));
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (DiscussionMemberActivity.f)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label176:
        paramView.fe.setText(((DiscussionMemberActivity.a)localObject).name);
      }
    }
  }
  
  class e
    implements TextWatcher
  {
    private e() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = DiscussionMemberActivity.this.ay.getText().toString().trim();
      DiscussionMemberActivity.this.vv(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  static class f
    extends abeg.a
  {
    public TextView fe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity
 * JD-Core Version:    0.7.0.1
 */