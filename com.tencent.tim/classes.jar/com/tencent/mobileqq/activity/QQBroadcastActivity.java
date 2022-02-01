package com.tencent.mobileqq.activity;

import acbn;
import aehk;
import aevp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Observer;
import ton;
import vnl;
import vnm;
import vno;
import vnp;
import wja;

public class QQBroadcastActivity
  extends BaseSystemActivity
  implements Observer
{
  public a a;
  public Handler handler = new vnl(this);
  
  private void aQ()
  {
    int i = 999;
    QQMessageFacade localQQMessageFacade = this.app.b();
    int j;
    if (localQQMessageFacade != null)
    {
      j = localQQMessageFacade.bl();
      if (j <= 0) {
        break label79;
      }
      if (j <= 999) {
        break label99;
      }
    }
    for (;;)
    {
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131720735) + "(" + i + ")"));
      return;
      label79:
      setLeftViewName(getIntent().putExtra("leftViewText", getString(2131720735)));
      return;
      label99:
      i = j;
    }
  }
  
  protected CursorAdapter a()
  {
    if (this.a == null) {
      this.a = new a(this, this.app.a(0).a(ay(), 0));
    }
    return this.a;
  }
  
  public String ay()
  {
    return String.valueOf(acbn.bkG);
  }
  
  protected void bJp()
  {
    aQ();
  }
  
  public Cursor getCursor()
  {
    return this.app.a(0).a(ay(), 0);
  }
  
  protected CharSequence j()
  {
    return getString(2131720682);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.app.b().ca(ay(), 0);
    aQ();
    this.rightViewText.setVisibility(8);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.changeCursor(null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public class a
    extends CursorAdapter
  {
    QQBroadcastActivity.b a;
    
    public a(Context paramContext, Cursor paramCursor)
    {
      super(paramCursor);
      QQBroadcastActivity.this.b(paramCursor);
    }
    
    public void E(String paramString1, int paramInt, String paramString2)
    {
      Intent localIntent = wja.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("uintype", paramInt);
      String str;
      if (paramString2 != null)
      {
        str = paramString2;
        if (paramString2.trim().length() != 0) {}
      }
      else
      {
        str = paramString1;
      }
      localIntent.putExtra("uinname", str);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.startActivity(localIntent);
    }
    
    public void bindView(View paramView, Context paramContext, Cursor paramCursor)
    {
      int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
      Object localObject = paramCursor.getString(paramCursor.getColumnIndex("msg"));
      long l1 = paramCursor.getLong(paramCursor.getColumnIndex("time"));
      long l2 = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b = ((QQBroadcastActivity.b)paramView.getTag());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b = new QQBroadcastActivity.b(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tvTitle = ((TextView)paramView.findViewById(2131380534));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY = ((RelativeLayout)paramView.findViewById(2131379118));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI = ((TextView)paramView.findViewById(2131380510));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ = ((TextView)paramView.findViewById(2131380537));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EK = ((TextView)paramView.findViewById(2131380533));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.qJ = ((ImageView)paramView.findViewById(2131372289));
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tN = paramView.findViewById(2131363725);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gZ = ((RelativeLayout)paramView.findViewById(2131363622));
        paramView.setTag(this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.K(l2) != -1L)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EK.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EK.setText(BaseSystemActivity.f(1000L * l1, false));
        label274:
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setOnLongClickListener(new vnm(this, l2));
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getSharedPreferences(String.valueOf(acbn.bkG), 0);
        paramCursor = "QQBROADCAST_MSG_UIN" + l2 + l1;
        if (!paramView.contains(paramCursor)) {
          break label450;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.qJ.setVisibility(8);
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setClickable(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setOnClickListener(null);
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setVisibility(8);
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EK.setVisibility(8);
          break label274;
          label450:
          this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.qJ.setVisibility(0);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gZ.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tvTitle.setText(paramContext.getResources().getString(2131720682));
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI.setPadding(0, 0, 0, 12);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setClickable(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setOnClickListener(new vno(this, paramView, paramCursor));
      return;
      localObject = aehk.b((String)localObject);
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setClickable(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setOnClickListener(null);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tN.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gZ.setVisibility(8);
      }
      if ((localObject != null) && (((aevp)localObject).bCi.length() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tvTitle.setText(((aevp)localObject).bCi);
        if ((localObject == null) || (((aevp)localObject).bCh.length() <= 0)) {
          break label870;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI.setText(((aevp)localObject).bCh);
        label732:
        if ((localObject == null) || (((aevp)localObject).bCm.length() <= 0)) {
          break label910;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tN.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gZ.setVisibility(0);
        if ((localObject == null) || (((aevp)localObject).bCk.length() <= 0)) {
          break label885;
        }
        paramContext = ((aevp)localObject).bCk;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ.setText(paramContext);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setClickable(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setOnClickListener(new vnp(this, (aevp)localObject, paramView, paramCursor));
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tvTitle.setText(paramContext.getResources().getString(2131720682));
        break;
        label870:
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EI.setVisibility(8);
        break label732;
        label885:
        paramContext = paramContext.getResources().getString(2131720691);
        this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ.setText(paramContext);
      }
      label910:
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gY.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.EJ.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.tN.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity$b.gZ.setVisibility(8);
    }
    
    public void changeCursor(Cursor paramCursor)
    {
      super.changeCursor(paramCursor);
      notifyDataSetChanged();
    }
    
    public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQQBroadcastActivity.getLayoutInflater().inflate(2131558955, paramViewGroup, false);
    }
  }
  
  static class b
  {
    TextView EI;
    TextView EJ;
    TextView EK;
    RelativeLayout gY;
    RelativeLayout gZ;
    ImageView qJ;
    View tN;
    TextView tvTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity
 * JD-Core Version:    0.7.0.1
 */