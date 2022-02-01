package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView.a;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class BaseTroopCardView
  extends RelativeLayout
{
  public ContactBaseView.a a;
  protected QQAppInterface mApp;
  protected Context mContext;
  
  public BaseTroopCardView(ContactBaseView.a parama)
  {
    super(parama.getActivity());
    this.a = parama;
    this.mContext = this.a.getActivity();
    this.mApp = parama.getApp();
  }
  
  public void setContentView(int paramInt)
  {
    LayoutInflater.from(this.mContext).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.BaseTroopCardView
 * JD-Core Version:    0.7.0.1
 */