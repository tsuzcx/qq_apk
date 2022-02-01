package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import arqp;
import arqq;
import arqr;
import arqs;
import arqt;
import arqu;
import artj;
import artl;
import artp;
import artp.a;
import artr;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class FriendChooser
  extends BaseActivity
  implements View.OnClickListener, Animation.AnimationListener, artp.a
{
  protected TextView Bi;
  protected AlphaAnimation C;
  protected TranslateAnimation F;
  protected XListView F;
  protected TranslateAnimation G;
  protected ImageButton G;
  protected TextView GS;
  protected ImageView Gk;
  public EditText I;
  protected View JX;
  protected View JY;
  protected ViewStub L;
  public artl a;
  public a a;
  protected c a;
  public ArrayList<Friend> aQ = new ArrayList();
  protected TextView acP;
  public HorizontalScrollView b;
  public InnerFrameManager b;
  public boolean bBe;
  final Handler bP = new arqs(this);
  protected String beA;
  protected String beB;
  protected RelativeLayout cQ;
  public InputMethodManager d;
  public int ekM = 99999;
  protected int ekN = 99999;
  protected Button hB;
  protected Button hC;
  protected LinearLayout ib;
  protected Button mCancelBtn;
  protected float mDensity;
  protected TextView mRightBtn;
  public List<Friend> mSearchResultList = new ArrayList();
  protected TextView mTitle;
  protected View mTitleBar;
  protected String mTitleString;
  public GridView q;
  protected ArrayList<String> so;
  
  protected void Dj(boolean paramBoolean)
  {
    int i = this.aQ.size();
    if (i <= 1) {}
    for (String str = this.beA; paramBoolean; str = MessageFormat.format(this.beB, new Object[] { Integer.valueOf(i) }))
    {
      this.hB.setVisibility(4);
      this.hC.setVisibility(0);
      this.hC.setText(str);
      return;
    }
    this.hB.setVisibility(0);
    this.hB.setText(str);
    this.hC.setVisibility(4);
  }
  
  protected void a(Friend paramFriend)
  {
    boolean bool;
    if (this.jdField_a_of_type_Artl.so(paramFriend.openId))
    {
      bool = false;
      this.aQ.remove(paramFriend);
      this.jdField_a_of_type_Artl.Xa(paramFriend.openId);
    }
    for (;;)
    {
      cz(bool);
      cAc();
      return;
      if (this.jdField_a_of_type_Artl.bA() >= this.ekM)
      {
        elh();
        return;
      }
      bool = true;
      this.aQ.add(paramFriend);
      this.jdField_a_of_type_Artl.WZ(paramFriend.openId);
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$c.notifyDataSetChanged();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3)
  {
    if (paramBoolean1)
    {
      this.Bi.setVisibility(0);
      this.Bi.setText(paramString1);
      this.GS.setVisibility(4);
      IphoneTitleBarActivity.setLayerType(this.Bi);
      if (!paramBoolean2) {
        break label85;
      }
      this.mRightBtn.setVisibility(0);
      this.mRightBtn.setText(paramString3);
    }
    for (;;)
    {
      this.mTitle.setText(paramString2);
      return;
      this.Bi.setVisibility(4);
      this.GS.setVisibility(4);
      break;
      label85:
      this.mRightBtn.setVisibility(4);
    }
  }
  
  protected void aC()
  {
    this.mTitleString = super.getString(2131719448);
    this.beA = super.getString(2131691799);
    this.beB = super.getString(2131691799);
    this.Bi.setVisibility(4);
    this.GS.setVisibility(4);
    this.mRightBtn.setVisibility(0);
    this.mRightBtn.setText(2131690092);
    this.mTitle.setText(this.mTitleString);
    this.Bi.setOnClickListener(this);
    this.mRightBtn.setOnClickListener(this);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      this.Bi.setVisibility(0);
      this.Bi.setText(paramString1);
      this.GS.setVisibility(4);
      IphoneTitleBarActivity.setLayerType(this.Bi);
      if (!paramBoolean2) {
        break label76;
      }
      this.mRightBtn.setVisibility(0);
    }
    for (;;)
    {
      this.mTitle.setText(paramString2);
      return;
      this.Bi.setVisibility(4);
      this.GS.setVisibility(4);
      break;
      label76:
      this.mRightBtn.setVisibility(4);
    }
  }
  
  protected void bNU()
  {
    this.I.setText("");
    this.jdField_G_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -this.mTitleBar.getHeight(), 0.0F);
    this.jdField_G_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_G_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    this.cQ.setVisibility(8);
    this.ib.startAnimation(this.jdField_G_of_type_AndroidViewAnimationTranslateAnimation);
    this.d.hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    this.bBe = false;
  }
  
  public void cAc()
  {
    this.acP.setText(this.aQ.size() + "/" + this.ekM);
    if (this.aQ.size() > 0)
    {
      Dj(true);
      return;
    }
    Dj(false);
  }
  
  protected abstract void cjw();
  
  public void cq()
  {
    if (this.d == null) {
      this.d = ((InputMethodManager)super.getSystemService("input_method"));
    }
    this.jdField_F_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mTitleBar.getHeight());
    this.jdField_F_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_F_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.C = new AlphaAnimation(0.0F, 1.0F);
    this.C.setDuration(300L);
    this.jdField_F_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, this.ib.getHeight() + this.mTitleBar.getHeight());
    this.ib.setLayoutParams(localLayoutParams);
    this.ib.startAnimation(this.jdField_F_of_type_AndroidViewAnimationTranslateAnimation);
    this.d.toggleSoftInput(0, 0);
    this.bBe = true;
  }
  
  public void cz(boolean paramBoolean)
  {
    this.acP.setText(this.aQ.size() + "/" + this.ekM);
    this.q.setNumColumns(this.aQ.size());
    ViewGroup.LayoutParams localLayoutParams = this.q.getLayoutParams();
    localLayoutParams.width = ((int)((this.aQ.size() * 36 + this.aQ.size() * 10) * this.mDensity));
    this.q.setLayoutParams(localLayoutParams);
    if (this.jdField_a_of_type_Artl.bA() == this.ekM) {
      this.Gk.setVisibility(4);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.bP.sendEmptyMessageDelayed(100, 200L);
      }
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$a.notifyDataSetChanged();
      return;
      this.Gk.setVisibility(0);
    }
  }
  
  protected void elg()
  {
    this.cQ = ((RelativeLayout)this.L.inflate());
    this.I = ((EditText)this.cQ.findViewById(2131366542));
    this.jdField_G_of_type_AndroidWidgetImageButton = ((ImageButton)this.cQ.findViewById(2131368696));
    this.mCancelBtn = ((Button)this.cQ.findViewById(2131363801));
    this.JX = this.cQ.findViewById(2131377207);
    this.jdField_F_of_type_ComTencentWidgetXListView = ((XListView)this.cQ.findViewById(2131377856));
    this.JY = this.cQ.findViewById(2131372437);
    this.I.addTextChangedListener(new d());
    this.jdField_G_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.mCancelBtn.setOnClickListener(this);
    this.jdField_F_of_type_ComTencentWidgetXListView.setBackgroundResource(2130838900);
    this.jdField_F_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$c = new c(this.mSearchResultList);
    this.jdField_F_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$c);
    this.JX.setOnClickListener(this);
    this.jdField_F_of_type_ComTencentWidgetXListView.setOnTouchListener(new arqq(this));
    this.jdField_F_of_type_ComTencentWidgetXListView.setOnItemClickListener(new arqr(this));
  }
  
  public abstract void elh();
  
  public abstract String getAppid();
  
  protected int getLayoutId()
  {
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  protected void initBottomBar()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      this.jdField_b_of_type_AndroidWidgetHorizontalScrollView.setOverScrollMode(2);
    }
    this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$a = new a();
    this.q.setAdapter(this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$a);
    this.q.setSmoothScrollbarEnabled(false);
    this.hB.setVisibility(0);
    this.hB.setText(this.beA);
    this.hB.setEnabled(false);
    this.hC.setVisibility(4);
    this.hC.setText(this.beB);
    this.q.setOnItemClickListener(new arqp(this));
    this.hC.setOnClickListener(this);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_G_of_type_AndroidViewAnimationTranslateAnimation)
    {
      paramAnimation = new FrameLayout.LayoutParams(-1, -1);
      this.ib.setLayoutParams(paramAnimation);
    }
    while (paramAnimation != this.jdField_F_of_type_AndroidViewAnimationTranslateAnimation) {
      return;
    }
    if (this.cQ == null) {
      elg();
    }
    this.JX.startAnimation(this.C);
    this.cQ.setVisibility(0);
    this.I.requestFocus();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public boolean onBackEvent()
  {
    if ((this.cQ != null) && (this.cQ.getVisibility() == 0))
    {
      bNU();
      return true;
    }
    switch (this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.uy())
    {
    default: 
      return super.onBackEvent();
    }
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.Bi) {
      onBackEvent();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.mRightBtn)
      {
        super.finish();
      }
      else if (paramView == this.hC)
      {
        cjw();
      }
      else if (paramView == this.jdField_G_of_type_AndroidWidgetImageButton)
      {
        this.I.setText("");
        this.d.showSoftInput(this.I, 0);
      }
      else if (paramView == this.mCancelBtn)
      {
        bNU();
      }
      else if (paramView == this.JX)
      {
        bNU();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.requestWindowFeature(1);
    super.onCreate(paramBundle);
    super.setTheme(2131755343);
    super.setContentView(getLayoutId());
    OpenAppClient.J(this.app);
    this.jdField_a_of_type_Artl = artl.a();
    this.mTitleBar = super.findViewById(2131379791);
    this.mTitle = ((TextView)super.findViewById(2131369627));
    this.Bi = ((TextView)super.findViewById(2131369579));
    this.GS = ((TextView)super.findViewById(2131369581));
    this.mRightBtn = ((TextView)super.findViewById(2131369612));
    this.ib = ((LinearLayout)super.findViewById(2131372661));
    this.L = ((ViewStub)super.findViewById(2131377848));
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager = ((InnerFrameManager)super.findViewById(2131372670));
    this.jdField_b_of_type_AndroidWidgetHorizontalScrollView = ((HorizontalScrollView)super.findViewById(2131377766));
    this.q = ((GridView)super.findViewById(2131377967));
    this.hB = ((Button)super.findViewById(2131366030));
    this.hC = ((Button)super.findViewById(2131366031));
    this.acP = ((TextView)super.findViewById(2131377934));
    this.Gk = ((ImageView)super.findViewById(2131372313));
    aC();
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.onCreate(this);
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.setAppIntf(this.app);
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.yW(0);
    initBottomBar();
    this.mDensity = getResources().getDisplayMetrics().density;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.onDestroy();
    if (this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$c != null) {
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$c = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.onResume();
  }
  
  public void onStart()
  {
    super.onStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void onStop()
  {
    super.onStop();
    super.getWindow().setSoftInputMode(48);
    this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.onStop();
  }
  
  protected void vv(String paramString)
  {
    this.mSearchResultList.clear();
    if ((paramString.equals("")) || (paramString.trim().length() == 0))
    {
      this.jdField_G_of_type_AndroidWidgetImageButton.setVisibility(8);
      this.jdField_F_of_type_ComTencentWidgetXListView.setVisibility(8);
      this.JY.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentOpenAgentFriendChooser$c.notifyDataSetChanged();
      return;
      this.jdField_G_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_F_of_type_ComTencentWidgetXListView.setVisibility(0);
      this.mSearchResultList.clear();
      Object localObject = ((OpenFrame)this.jdField_b_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).gP();
      if (localObject != null)
      {
        paramString = paramString.toLowerCase();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Friend localFriend = (Friend)((Iterator)localObject).next();
          if ((paramString.equals(localFriend.cCi)) || (paramString.equals(localFriend.cCj)) || (paramString.equals(localFriend.label)) || (paramString.equals(localFriend.nickName))) {
            localArrayList1.add(localFriend);
          } else if (((localFriend.label != null) && (localFriend.label.indexOf(paramString) >= 0)) || ((localFriend.nickName != null) && (localFriend.nickName.indexOf(paramString) >= 0)) || (localFriend.cCi.indexOf(paramString) >= 0) || (localFriend.cCj.indexOf(paramString) >= 0)) {
            localArrayList2.add(localFriend);
          }
        }
        Collections.sort(localArrayList2, new b());
        this.mSearchResultList.addAll(localArrayList1);
        this.mSearchResultList.addAll(localArrayList2);
      }
      if (this.mSearchResultList.isEmpty()) {
        this.JY.setVisibility(0);
      } else {
        this.JY.setVisibility(8);
      }
    }
  }
  
  public class a
    extends artj
  {
    protected a() {}
    
    public int getCount()
    {
      return FriendChooser.this.aQ.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < FriendChooser.this.aQ.size())) {
        return FriendChooser.this.aQ.get(paramInt);
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Friend localFriend = (Friend)getItem(paramInt);
      Object localObject;
      Bitmap localBitmap;
      if (paramView == null)
      {
        localObject = new FriendChooser.e();
        paramView = FriendChooser.this.getLayoutInflater().inflate(2131559454, null);
        ((FriendChooser.e)localObject).pQ = ((ImageView)paramView.findViewById(2131366624));
        paramView.setTag(localObject);
        if ((localFriend.cCh == null) || ("".equals(localFriend.cCh))) {
          localFriend.cCh = artr.cg(FriendChooser.this.getAppid(), localFriend.openId);
        }
        localBitmap = artp.a().Q(localFriend.cCh);
        if (localBitmap != null) {
          break label182;
        }
        ((FriendChooser.e)localObject).pQ.setImageResource(2130840645);
        localObject = ((FriendChooser.e)localObject).pQ;
        artp.a().a(localFriend.cCh, new arqt(this, (ImageView)localObject));
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localObject = (FriendChooser.e)paramView.getTag();
        break;
        label182:
        ((FriendChooser.e)localObject).pQ.setImageBitmap(localBitmap);
      }
    }
  }
  
  public class b
    implements Comparator<Friend>
  {
    protected b() {}
    
    public int a(Friend paramFriend1, Friend paramFriend2)
    {
      return paramFriend1.cCj.compareToIgnoreCase(paramFriend2.cCj);
    }
  }
  
  public class c
    extends artj
  {
    protected List<Friend> mList;
    
    public c()
    {
      Object localObject;
      this.mList = localObject;
    }
    
    public int getCount()
    {
      return this.mList.size();
    }
    
    public Object getItem(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mList.size())) {
        return this.mList.get(paramInt);
      }
      return null;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      if (paramView == null)
      {
        localView = FriendChooser.this.getLayoutInflater().inflate(2131563067, paramViewGroup, false);
        paramView = new FriendChooser.e();
        paramView.pQ = ((ImageView)localView.findViewById(2131369767));
        paramView.nickname = ((TextView)localView.findViewById(2131380814));
        paramView.acQ = ((TextView)localView.findViewById(2131380940));
        localView.setTag(paramView);
      }
      while ((this.mList == null) || (this.mList.size() == 0))
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject1 = (FriendChooser.e)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject1;
      }
      Object localObject1 = (Friend)this.mList.get(paramInt);
      label179:
      Object localObject2;
      if ((((Friend)localObject1).label == null) || ("".equals(((Friend)localObject1).label)))
      {
        paramView.nickname.setText(((Friend)localObject1).nickName);
        if ((((Friend)localObject1).cCh == null) || ("".equals(((Friend)localObject1).cCh))) {
          ((Friend)localObject1).cCh = artr.cg(FriendChooser.this.getAppid(), ((Friend)localObject1).openId);
        }
        localObject2 = artp.a().Q(((Friend)localObject1).cCh);
        if (localObject2 != null) {
          break label319;
        }
        paramView.pQ.setImageResource(2130840645);
        localObject2 = paramView.pQ;
        artp.a().a(((Friend)localObject1).cCh, new arqu(this, (ImageView)localObject2));
        label274:
        if (!FriendChooser.this.a.so(((Friend)localObject1).openId)) {
          break label331;
        }
        paramView.acQ.setText(2131692853);
      }
      for (;;)
      {
        break;
        paramView.nickname.setText(((Friend)localObject1).label);
        break label179;
        label319:
        paramView.pQ.setImageBitmap((Bitmap)localObject2);
        break label274;
        label331:
        paramView.acQ.setText("");
      }
    }
  }
  
  public class d
    implements TextWatcher
  {
    protected d() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      paramEditable = FriendChooser.this.I.getText().toString().trim();
      FriendChooser.this.vv(paramEditable);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  static class e
  {
    TextView acQ;
    TextView nickname;
    ImageView pQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.FriendChooser
 * JD-Core Version:    0.7.0.1
 */