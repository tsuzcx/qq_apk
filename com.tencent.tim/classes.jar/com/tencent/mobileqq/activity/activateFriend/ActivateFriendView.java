package com.tencent.mobileqq.activity.activateFriend;

import acfd;
import acof;
import acog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import aqdf;
import aqdf.a;
import aqgv;
import aqhu;
import aqnm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import whg;
import whh;
import whi;

public class ActivateFriendView
  extends LinearLayout
  implements aqdf.a
{
  private static final int bNl = aqnm.dpToPx(85.0F);
  private static final int bNm = aqnm.dpToPx(70.0F);
  private static final int bNn = aqnm.dpToPx(70.0F);
  private static final int bNo = aqnm.dpToPx(52.0F);
  private static Bitmap du;
  private aqdf jdField_a_of_type_Aqdf;
  private ActivateFriendGrid.a jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a;
  private QQAppInterface app;
  public acof b;
  acog b;
  private int bNk;
  private boolean bcn = true;
  private boolean bco;
  private boolean bcp = true;
  acfd c = new whh(this);
  private View.OnClickListener dF = new whg(this);
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private ArrayList<ActivateFriendItem> mData = new ArrayList();
  private ArrayList<ActivateFriendViewItem> pX = new ArrayList();
  
  public ActivateFriendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Acog = new whi(this);
  }
  
  private Bitmap getFaceBitmap(String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_Aqdf.b(1, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_Aqdf.isPausing()) {
      this.jdField_a_of_type_Aqdf.a(paramString, 1, true, (byte)0);
    }
    return du;
  }
  
  public ActivateFriendViewItem a(int paramInt)
  {
    ActivateFriendViewItem localActivateFriendViewItem = new ActivateFriendViewItem(getContext(), this.bco, this.bcp);
    addView(localActivateFriendViewItem, new LinearLayout.LayoutParams(paramInt, -2));
    return localActivateFriendViewItem;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_Aqdf.isPausing())
    {
      if (paramBitmap != null) {
        this.faceCache.put(paramString, paramBitmap);
      }
      if (paramInt1 <= 0)
      {
        paramInt2 = this.pX.size();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          long l = ((ActivateFriendItem)this.mData.get(paramInt1)).uin;
          paramString = (Bitmap)this.faceCache.get(String.valueOf(l));
          if (paramString != null) {
            ((ActivateFriendViewItem)this.pX.get(paramInt1)).setHead(paramString);
          }
          paramInt1 += 1;
        }
        this.faceCache.clear();
      }
    }
  }
  
  public void setCheckAbilityEnable(boolean paramBoolean)
  {
    this.bcn = paramBoolean;
  }
  
  public void setData(QQAppInterface paramQQAppInterface, ArrayList<ActivateFriendItem> paramArrayList)
  {
    this.app = paramQQAppInterface;
    if (du == null) {
      du = aqhu.G();
    }
    this.mData.clear();
    paramQQAppInterface = this.pX.iterator();
    while (paramQQAppInterface.hasNext()) {
      removeView((ActivateFriendViewItem)paramQQAppInterface.next());
    }
    this.pX.clear();
    this.mData.addAll(paramArrayList);
    if (this.jdField_a_of_type_Aqdf == null)
    {
      this.jdField_a_of_type_Aqdf = new aqdf(getContext(), this.app);
      this.jdField_a_of_type_Aqdf.a(this);
    }
    this.jdField_b_of_type_Acof = ((acof)this.app.getManager(85));
    this.app.addObserver(this.c);
    this.app.registObserver(this.jdField_b_of_type_Acog);
    this.bNk = 0;
    int k = this.mData.size();
    int i;
    int j;
    switch (k)
    {
    default: 
      i = -2;
      j = 0;
      label198:
      if (j >= k) {
        break label592;
      }
      paramQQAppInterface = a(i);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.mData.get(j)).birthdayDesc);
      paramArrayList = String.valueOf(((ActivateFriendItem)this.mData.get(j)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.mData.get(j)).nickName))
      {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.mData.get(j)).nickName);
        label289:
        paramQQAppInterface.setHead(getFaceBitmap(paramArrayList));
        if (this.bcn) {
          paramQQAppInterface.setOnClickListener(this.dF);
        }
        if (this.bcn)
        {
          if ((!getResources().getString(2131689658).equals(((ActivateFriendItem)this.mData.get(j)).birthdayDesc)) && (!this.jdField_b_of_type_Acof.n(((ActivateFriendItem)this.mData.get(j)).uin, ((ActivateFriendItem)this.mData.get(j)).type))) {
            break label472;
          }
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689658));
        }
      }
      break;
    }
    for (;;)
    {
      this.pX.add(paramQQAppInterface);
      j += 1;
      break label198;
      i = bNl;
      break;
      i = bNm;
      break;
      i = bNn;
      break;
      i = bNo;
      break;
      paramQQAppInterface.setNickName(aqgv.b(this.app, paramArrayList, true));
      break label289;
      label472:
      if ((this.jdField_b_of_type_Acof.l(((ActivateFriendItem)this.mData.get(j)).uin, ((ActivateFriendItem)this.mData.get(j)).type)) || (this.jdField_b_of_type_Acof.m(((ActivateFriendItem)this.mData.get(j)).uin, ((ActivateFriendItem)this.mData.get(j)).type)))
      {
        paramQQAppInterface.setChecked(false);
        paramQQAppInterface.setBirthday(getResources().getString(2131689661));
      }
      else
      {
        this.bNk += 1;
        paramQQAppInterface.setChecked(true);
      }
    }
    label592:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a.BW(this.bNk);
    }
  }
  
  public void setGridCallBack(ActivateFriendGrid.a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a = parama;
  }
  
  public void setSkinable(boolean paramBoolean)
  {
    this.bco = paramBoolean;
  }
  
  public void setTextScrolling(boolean paramBoolean)
  {
    this.bcp = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendView
 * JD-Core Version:    0.7.0.1
 */