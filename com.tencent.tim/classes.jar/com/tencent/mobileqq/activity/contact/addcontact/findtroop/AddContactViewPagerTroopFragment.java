package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import aczc;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import ypo;
import ypo.a;
import yps;
import ypt;
import ypw;
import ypy;

public class AddContactViewPagerTroopFragment
  extends ContactsBaseFragment
  implements View.OnClickListener
{
  public TextView Lp;
  public TextView Lq;
  public TextView Lr;
  public ypo a;
  public String aZu;
  public String aZv = "";
  ypo.a b;
  private boolean bod;
  View.OnClickListener el = new ypt(this);
  public LinearLayout hy;
  protected int itemType = -1;
  public String keyWord;
  public XListView mListView;
  View rootView;
  public View.OnTouchListener t = new yps(this);
  public ImageView uv;
  
  public AddContactViewPagerTroopFragment()
  {
    this.jdField_b_of_type_Ypo$a = new ypw(this);
  }
  
  private void Au(boolean paramBoolean)
  {
    this.hy.setVisibility(0);
    this.mListView.setVisibility(8);
    Object localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115412_lWT3DV2SAk.png", null);
    if ((localObject != null) && (1 != ((URLDrawable)localObject).getStatus())) {
      ((URLDrawable)localObject).restartDownload();
    }
    this.uv.setImageDrawable((Drawable)localObject);
    this.Lp.setText(2131689860);
    this.Lq.setText(2131708706);
    this.Lr.setText(2131689859);
    localObject = this.hy.getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup))) {
      ((ViewGroup)localObject).setBackgroundResource(2130839642);
    }
    if (paramBoolean)
    {
      this.Lr.setOnTouchListener(this.t);
      this.Lr.setOnClickListener(this.el);
      this.Lr.setVisibility(0);
      return;
    }
    this.Lr.setVisibility(8);
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onResume:" + paramBoolean);
    }
    if (this.mListView == null) {}
    for (;;)
    {
      return;
      if (paramBoolean) {
        bpM();
      }
      if ((this.mk) && (this.hy.getVisibility() == 0))
      {
        if (!this.Lp.getText().equals(getResources().getString(2131689860))) {
          break label152;
        }
        anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "no_location_exp", 0, 0, "", "", "", "");
      }
      while ((this.mk) && (!this.bod))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onResume requestData");
        }
        this.bod = true;
        this.a.At(false);
        return;
        label152:
        anot.a(null, "dc00899", "Grp_find_new", "", "grptab", "no_meet_exp", 0, 0, this.aZv, this.aZu, "", "");
      }
    }
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onPause");
    }
    if (paramBoolean) {
      bpN();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "getView");
    }
    if (this.rootView == null)
    {
      this.rootView = paramLayoutInflater.inflate(2131560047, null);
      this.hy = ((LinearLayout)this.rootView.findViewById(2131379756));
      this.uv = ((ImageView)this.rootView.findViewById(2131368952));
      this.Lp = ((TextView)this.rootView.findViewById(2131379599));
      this.Lq = ((TextView)this.rootView.findViewById(2131379600));
      this.Lr = ((TextView)this.rootView.findViewById(2131379601));
      this.mListView = ((XListView)this.rootView.findViewById(2131376939));
      this.mListView.setId(2131362197);
      this.mListView.setSelector(2131167595);
      this.mListView.setNeedCheckSpringback(true);
      this.mListView.setDivider(null);
      this.mListView.setClipToPadding(false);
      this.mListView.setScrollBarStyle(33554432);
      this.mListView.mForContacts = true;
      this.mListView.setOnScrollListener(this);
      if ((this.itemType == 1) && (Build.VERSION.SDK_INT >= 23)) {
        if ((getActivity().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != -1) && (getActivity().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != -1)) {
          break label454;
        }
      }
    }
    label454:
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, "getView  >= M, canRequestLocation = " + bool);
      }
      if (!bool)
      {
        Au(true);
        this.a = new ypo(this.mApp, this.mActivity, this.mListView, null, this.itemType, this.keyWord);
        this.a.a = this.jdField_b_of_type_Ypo$a;
      }
      for (;;)
      {
        return this.rootView;
        this.hy.setVisibility(8);
        this.mListView.setVisibility(0);
        paramLayoutInflater = aczc.a("recommend_troop");
        if (QLog.isColorLevel()) {
          QLog.w("ac_ft.AddContactViewPagerTroopFragment", 2, "getView  >= M, canRequestLocation = " + bool + ",cached info = " + paramLayoutInflater);
        }
        if (paramLayoutInflater != null) {
          break;
        }
        aczc.a(new ypy(this, "recommend_troop"));
        break;
        paramLayoutInflater = this.rootView.getParent();
        if ((paramLayoutInflater != null) && ((paramLayoutInflater instanceof ViewGroup))) {
          ((ViewGroup)paramLayoutInflater).removeView(this.rootView);
        }
      }
    }
  }
  
  public void bpM()
  {
    if (this.mk) {}
  }
  
  public void bpN() {}
  
  public void dK(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "onHotTagClickChanged,keyWord = " + this.keyWord + ",newKeyWord = " + paramString1 + ",newHotTagName = " + paramString2);
    }
    this.aZv = paramString2;
    if (!this.keyWord.equals(paramString1))
    {
      this.keyWord = paramString1;
      if ((this.mk) && (this.a != null)) {
        this.a.zc(paramString1);
      }
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "doOnDestroy");
    }
    bpN();
    if (this.a != null) {
      this.a.onDetach();
    }
  }
  
  public View e()
  {
    return this.mListView;
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void refresh()
  {
    if (this.mk) {
      this.a.refresh();
    }
  }
  
  public void resetData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ac_ft.AddContactViewPagerTroopFragment", 2, "resetData");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactViewPagerTroopFragment
 * JD-Core Version:    0.7.0.1
 */