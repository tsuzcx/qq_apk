package com.tencent.mobileqq.troop.activity;

import acfp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import aovm;
import aovn;
import aovo;
import aovp;
import aprb.a;
import aprv;
import auvp;
import com.tencent.mobileqq.activity.contacts.base.Contacts.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPublishLocationSelectActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, aprb.a, AdapterView.c
{
  public long BN;
  private String TAG = "TroopBarPublishLocationSelectActivity";
  public XListView W;
  protected a a;
  protected TroopBarPOI a;
  protected SosoInterface.a b;
  public final TroopBarPOI c = new TroopBarPOI("-1", "", acfp.m(2131715583), 0, "", 0, "");
  protected boolean cOX;
  protected TroopBarPOI d;
  protected PullRefreshHeader d;
  protected Drawable dA;
  public ArrayList<TroopBarPOI> kd;
  public Handler mHandler = new aovo(this);
  protected View oM;
  
  public static final void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, aprb.a parama)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("lat", String.valueOf(paramInt1));
    localBundle1.putString("lon", String.valueOf(paramInt2));
    localBundle1.putString("num", String.valueOf(50));
    localBundle1.putString("start", String.valueOf(paramInt3));
    Bundle localBundle2 = new Bundle();
    if (paramBoolean) {
      localBundle2.putBoolean("refresh_all_poi", paramBoolean);
    }
    aprv.a(paramBaseActivity, localBundle1, "https://buluo.qq.com/cgi-bin/bar/user/poilist", 3, localBundle2, parama);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    xa(false);
    if (paramJSONObject != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        if (paramJSONObject.optInt("isend", -1) != 1) {
          break label331;
        }
        bool = true;
        tG(bool);
        localJSONArray = paramJSONObject.getJSONArray("poilist");
        if (this.kd == null) {
          this.kd = new ArrayList();
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("refresh_all_poi"))) {
          this.kd.clear();
        }
        if (!this.kd.isEmpty()) {
          break label326;
        }
        this.kd.add(this.c);
      }
      catch (JSONException paramBundle)
      {
        JSONArray localJSONArray;
        if (!QLog.isColorLevel()) {
          break label211;
        }
        QLog.d("TroopBar", 2, paramBundle.toString());
      }
      if (paramInt < localJSONArray.length())
      {
        this.kd.add(new TroopBarPOI(localJSONArray.getJSONObject(paramInt)));
        paramInt += 1;
      }
      else
      {
        if (this.kd.size() > 1)
        {
          paramBundle = (TroopBarPOI)this.kd.get(1);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramBundle;
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$a.notifyDataSetChanged();
          return;
          label211:
          if (paramJSONObject.optInt("isend", -1) == 1) {
            break;
          }
          paramInt = paramJSONObject.optInt("retcode", -1);
          if (paramInt == 0) {
            break label271;
          }
          QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(paramInt) }), 0).show(getTitleBarHeight());
          return;
        }
        paramBundle = null;
        continue;
        label271:
        QQToast.a(this, 1, getString(2131698504, new Object[] { Integer.valueOf(paramJSONObject.optInt("errno", -1)) }), 0).show(getTitleBarHeight());
        return;
        QQToast.a(this, 1, 2131698503, 0).show(getTitleBarHeight());
        return;
        label326:
        paramInt = 0;
        continue;
        label331:
        bool = false;
      }
    }
  }
  
  protected void aMA()
  {
    this.b = new aovp(this, 0, true, true, 0L, false, false, "QLifeCommentActivity");
    SosoInterface.a(this.b);
  }
  
  public void bX(int paramInt, boolean paramBoolean)
  {
    xa(true);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null)
    {
      a(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.latitude, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.longitude, paramInt, paramBoolean, this);
      return;
    }
    aMA();
  }
  
  protected void btl()
  {
    this.jdField_d_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131559847, this.W, false));
    Contacts.a locala = new Contacts.a();
    this.jdField_d_of_type_ComTencentMobileqqWidgetPullRefreshHeader.setTag(locala);
    this.W.setOverscrollHeader(getResources().getDrawable(2130839645));
    this.W.setOverScrollHeader(this.jdField_d_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.W.setOverScrollListener(new aovn(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.W = new XListView(this);
    this.W.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.W.setDivider(getResources().getDrawable(2130841243));
    this.W.setDividerHeight(1);
    setContentView(this.W);
    setTitle(2131698463);
    this.rightViewImg.setImageResource(2130843351);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setOnClickListener(this);
    paramBundle = getIntent();
    this.kd = paramBundle.getParcelableArrayListExtra("current_location_list");
    this.cOX = paramBundle.getBooleanExtra("Transparent_Bg", false);
    this.jdField_d_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)paramBundle.getParcelableExtra("key_selected_poi"));
    if (this.jdField_d_of_type_ComTencentMobileqqTroopDataTroopBarPOI == null) {
      this.jdField_d_of_type_ComTencentMobileqqTroopDataTroopBarPOI = this.c;
    }
    if (this.kd != null)
    {
      if (this.kd.isEmpty())
      {
        paramBundle = null;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramBundle;
        this.kd.add(0, this.c);
      }
    }
    else
    {
      if (!this.cOX) {
        break label404;
      }
      this.W.setBackgroundResource(17170445);
    }
    for (;;)
    {
      this.oM = LayoutInflater.from(this).inflate(2131559847, null);
      btl();
      paramBundle = (ImageView)this.oM.findViewById(2131377034);
      TextView localTextView1 = (TextView)this.oM.findViewById(2131377036);
      TextView localTextView2 = (TextView)this.oM.findViewById(2131377043);
      ProgressBar localProgressBar = (ProgressBar)this.oM.findViewById(2131377037);
      localTextView1.setTextColor(-8355712);
      localTextView1.setText(2131720482);
      localTextView2.setVisibility(8);
      paramBundle.setVisibility(8);
      localProgressBar.setVisibility(8);
      this.W.addFooterView(this.oM);
      this.W.setOnScrollListener(new aovm(this));
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$a = new a(this, this.cOX);
      this.W.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$a);
      this.W.setOnItemClickListener(this);
      bX(0, true);
      return true;
      paramBundle = (TroopBarPOI)this.kd.get(0);
      break;
      label404:
      this.W.setBackgroundResource(2130838900);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.b != null) {
      SosoInterface.c(this.b);
    }
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
      bX(0, true);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.kd == null) || (paramInt < 0) || (paramInt >= this.kd.size())) {
      return;
    }
    this.jdField_d_of_type_ComTencentMobileqqTroopDataTroopBarPOI = ((TroopBarPOI)this.kd.get(paramInt));
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPublishLocationSelectActivity$a.notifyDataSetChanged();
    if (this.c.equals(this.jdField_d_of_type_ComTencentMobileqqTroopDataTroopBarPOI)) {}
    for (paramAdapterView = null;; paramAdapterView = this.jdField_d_of_type_ComTencentMobileqqTroopDataTroopBarPOI)
    {
      paramView = new Intent();
      paramView.putExtra("key_selected_poi", paramAdapterView);
      setResult(-1, paramView);
      finish();
      return;
    }
  }
  
  protected void tG(boolean paramBoolean)
  {
    TextView localTextView = (TextView)this.oM.findViewById(2131377036);
    if (paramBoolean)
    {
      localTextView.setText(2131720487);
      return;
    }
    localTextView.setText(2131720482);
  }
  
  protected void xa(boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((this.centerView != null) && (this.dA == null))
      {
        this.dA = getResources().getDrawable(2130839651);
        this.centerView.setCompoundDrawablesWithIntrinsicBounds(this.dA, null, null, null);
        ((Animatable)this.dA).start();
      }
    }
    while ((this.centerView == null) || (this.dA == null)) {
      return;
    }
    ((Animatable)this.dA).stop();
    this.dA = null;
    this.centerView.setCompoundDrawables(null, null, null, null);
  }
  
  protected void xd(int paramInt)
  {
    if (this.jdField_d_of_type_ComTencentMobileqqWidgetPullRefreshHeader != null)
    {
      Contacts.a locala = (Contacts.a)this.jdField_d_of_type_ComTencentMobileqqWidgetPullRefreshHeader.getTag();
      if (locala != null)
      {
        locala.bpP = false;
        this.mHandler.sendEmptyMessageDelayed(1001, 800L);
        if (paramInt == 0) {
          this.BN = System.currentTimeMillis();
        }
        this.jdField_d_of_type_ComTencentMobileqqWidgetPullRefreshHeader.tT(paramInt);
      }
    }
  }
  
  class a
    extends auvp
  {
    protected boolean cOX;
    protected LayoutInflater mInflater;
    
    public a(Context paramContext, boolean paramBoolean)
    {
      this.mInflater = LayoutInflater.from(paramContext);
      this.cOX = paramBoolean;
    }
    
    public int getCount()
    {
      if (TroopBarPublishLocationSelectActivity.this.kd == null) {
        return 0;
      }
      return TroopBarPublishLocationSelectActivity.this.kd.size();
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
      View localView;
      Object localObject;
      int i;
      if (paramView == null)
      {
        localView = this.mInflater.inflate(2131562412, null);
        paramView = new a();
        paramView.Ee = ((ImageView)localView.findViewById(2131370328));
        paramView.nt = ((ImageView)localView.findViewById(2131377968));
        paramView.yM = ((TextView)localView.findViewById(2131370317));
        paramView.aag = ((TextView)localView.findViewById(2131370312));
        localView.setTag(paramView);
        localObject = (TroopBarPOI)TroopBarPublishLocationSelectActivity.this.kd.get(paramInt);
        paramView.yM.setText(((TroopBarPOI)localObject).name);
        ImageView localImageView = paramView.nt;
        if (!((TroopBarPOI)localObject).equals(TroopBarPublishLocationSelectActivity.this.d)) {
          break label261;
        }
        i = 0;
        label139:
        localImageView.setVisibility(i);
        if (TextUtils.isEmpty(((TroopBarPOI)localObject).Tr)) {
          break label268;
        }
        paramView.aag.setText(((TroopBarPOI)localObject).Tr);
        paramView.aag.setVisibility(0);
        label177:
        if (paramInt != 0) {
          break label280;
        }
        paramView.Ee.setVisibility(4);
        label189:
        if (!this.cOX) {
          break label291;
        }
        localView.setBackgroundResource(17170445);
      }
      for (;;)
      {
        localView.setContentDescription(((TroopBarPOI)localObject).name);
        localView.setFocusable(true);
        localView.setFocusableInTouchMode(true);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (a)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        label261:
        i = 8;
        break label139;
        label268:
        paramView.aag.setVisibility(8);
        break label177;
        label280:
        paramView.Ee.setVisibility(0);
        break label189;
        label291:
        localView.setBackgroundResource(2130849226);
      }
    }
    
    public class a
    {
      protected ImageView Ee;
      protected TextView aag;
      protected ImageView nt;
      protected TextView yM;
      
      protected a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity
 * JD-Core Version:    0.7.0.1
 */