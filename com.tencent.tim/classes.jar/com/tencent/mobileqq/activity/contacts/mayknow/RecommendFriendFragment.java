package com.tencent.mobileqq.activity.contacts.mayknow;

import acfd;
import achg;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.b;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;
import wja;
import yzn;
import zar;
import zas;

public class RecommendFriendFragment
  extends ContactsBaseFragment
  implements yzn
{
  public zas a;
  protected int cbY = -1;
  protected int cbZ = -1;
  acfd e = new zar(this);
  public Runnable eJ = new RecommendFriendFragment.2(this);
  protected Runnable eR = new RecommendFriendFragment.3(this);
  protected Runnable eS = new RecommendFriendFragment.4(this);
  public XListView mListView;
  View root;
  View yv;
  
  private void cnD()
  {
    if (this.a != null)
    {
      Object localObject = (achg)this.mApp.getManager(159);
      if (localObject != null)
      {
        ((achg)localObject).iu(3);
        localObject = ((achg)localObject).cw();
        this.a.gJ((List)localObject);
        this.yv.removeCallbacks(this.eS);
        this.yv.postDelayed(this.eS, 100L);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecommendFriendFragment", 2, "loadAndUpdateData size:" + this.a.getCount() + "  uin:" + this.mApp.getCurrentAccountUin());
      }
    }
  }
  
  private boolean isEmpty()
  {
    if (this.a != null) {
      return this.a.isEmpty();
    }
    return false;
  }
  
  public void Av(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnResume:" + paramBoolean);
    }
    if (this.mListView == null) {
      return;
    }
    bpM();
    if (this.a == null)
    {
      this.a = new zas(this.mActivity, this.mApp, this.mListView, 1, true);
      this.mListView.setAdapter(this.a);
      cnD();
    }
    if (this.a != null) {
      this.a.onResume();
    }
    fX(this.cbY, this.cbZ);
  }
  
  public void Aw(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnPause:" + paramBoolean);
    }
    if (paramBoolean) {
      bpN();
    }
    if (this.a != null) {
      this.a.cli();
    }
  }
  
  public View a(LayoutInflater paramLayoutInflater, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "getView mListView=" + this.mListView);
    }
    if (this.root == null)
    {
      this.root = LayoutInflater.from(this.mActivity).inflate(2131559104, null, false);
      this.mListView = ((XListView)this.root.findViewById(2131376946));
      this.mListView.setSelector(new ColorDrawable(0));
      this.mListView.setNeedCheckSpringback(true);
      this.mListView.setCacheColorHint(0);
      this.mListView.setDivider(null);
      this.mListView.setOverScrollMode(0);
      this.mListView.mForContacts = true;
      this.yv = this.root.findViewById(2131366395);
      paramLayoutInflater = (ImageView)this.root.findViewById(2131366413);
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestHeight = wja.dp2px(200.0F, BaseApplication.getContext().getResources());
      paramBundle.mRequestWidth = wja.dp2px(145.0F, BaseApplication.getContext().getResources());
      paramBundle.mLoadingDrawable = null;
      paramBundle.mFailedDrawable = null;
      paramLayoutInflater.setImageDrawable(URLDrawable.getDrawable("https://sqimg.qq.com/qq_product_operations/nearby/recommend/recommend_empty.png", paramBundle));
    }
    for (;;)
    {
      return this.root;
      paramLayoutInflater = this.root.getParent();
      if ((paramLayoutInflater instanceof ViewGroup)) {
        ((ViewGroup)paramLayoutInflater).removeView(this.root);
      }
    }
  }
  
  public void bpM()
  {
    if (this.mApp != null) {
      this.mApp.addObserver(this.e);
    }
  }
  
  public void bpN()
  {
    if (this.mApp != null) {
      this.mApp.removeObserver(this.e);
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "doOnDestroy");
    }
    if (this.a != null) {
      this.a.onDestroy();
    }
    if (this.yv != null)
    {
      this.yv.removeCallbacks(this.eR);
      this.yv.removeCallbacks(this.eS);
    }
    if (this.mListView != null) {
      this.mListView.removeCallbacks(this.eJ);
    }
    bpN();
  }
  
  public View e()
  {
    return this.mListView;
  }
  
  public void fX(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecommendFriendFragment", 2, "onHeadViewScrollChanged currentY:" + paramInt1 + "  maxY:" + paramInt2);
    }
    this.cbY = paramInt1;
    this.cbZ = paramInt2;
    if ((this.yv != null) && (this.yv.getVisibility() == 0) && (this.yv.getMeasuredHeight() > 0) && (this.root.getMeasuredHeight() > 0))
    {
      this.yv.removeCallbacks(this.eR);
      this.yv.post(this.eR);
    }
  }
  
  public void refresh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecommendFriendFragment", 2, "refresh");
    }
    cnD();
    if (this.b != null) {
      this.b.d(xZ(), true, null);
    }
  }
  
  public void resetData()
  {
    cnD();
    if (this.a != null) {
      this.a.bo(this.mApp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.mayknow.RecommendFriendFragment
 * JD-Core Version:    0.7.0.1
 */