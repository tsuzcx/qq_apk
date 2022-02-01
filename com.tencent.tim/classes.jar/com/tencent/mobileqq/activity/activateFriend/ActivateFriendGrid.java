package com.tencent.mobileqq.activity.activateFriend;

import acfd;
import acof;
import acog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqcx;
import aqdf;
import aqdf.a;
import aqgv;
import aqhu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import whd;
import whe;
import whf;

public class ActivateFriendGrid
  extends FrameLayout
  implements aqdf.a
{
  private static int bNi = 15;
  private static int bNj = 14;
  private static Bitmap du;
  private aqdf jdField_a_of_type_Aqdf;
  private a jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$b;
  private QQAppInterface app;
  public acof b;
  acog b;
  private int bNk;
  private boolean bcn = true;
  private boolean bco;
  private boolean bcp = true;
  acfd c = new whe(this);
  private View.OnClickListener dF = new whd(this);
  private Hashtable<String, Bitmap> faceCache = new Hashtable();
  private ArrayList<ActivateFriendItem> mData = new ArrayList();
  private int measuredHeight;
  private int measuredWidth;
  private ArrayList<ActivateFriendGridItem> pX = new ArrayList();
  
  public ActivateFriendGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Acog = new whf(this);
  }
  
  private int ah(int paramInt1, int paramInt2)
  {
    if (paramInt2 < 3) {
      return paramInt2;
    }
    if (paramInt1 < 3) {
      return 3;
    }
    return paramInt2 - 3;
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
  
  private int measureHeight(int paramInt)
  {
    paramInt = 0;
    if (this.pX.size() > 0) {
      paramInt = ((ActivateFriendGridItem)this.pX.get(0)).getMeasuredHeight();
    }
    return paramInt * 2 + aqcx.dip2px(getContext(), bNi) * 1;
  }
  
  public String[] D()
  {
    String[] arrayOfString = new String[this.bNk];
    StringBuilder localStringBuilder = new StringBuilder(" ActivateFriendGrid friendsBirth:");
    int j = 0;
    int i = 0;
    Object localObject;
    int k;
    int m;
    int n;
    int i1;
    label131:
    String str;
    if (j < this.pX.size())
    {
      if (!((ActivateFriendGridItem)this.pX.get(j)).isChecked) {
        break label370;
      }
      long l = ((ActivateFriendItem)this.mData.get(j)).birthSendTime;
      localObject = new Time();
      ((Time)localObject).set(l * 1000L);
      k = ((Time)localObject).month;
      m = ((Time)localObject).monthDay;
      ((Time)localObject).setToNow();
      n = ((Time)localObject).year;
      i1 = ((Time)localObject).month;
      if (m < 10)
      {
        localObject = "-0";
        if (k >= 9) {
          break label240;
        }
        str = "-0";
        label141:
        if ((k != 0) || (i1 != 11)) {
          break label247;
        }
        arrayOfString[i] = (n + 1 + "-0" + (k + 1) + (String)localObject + m);
        label194:
        localStringBuilder.append(arrayOfString[i] + "|");
        i += 1;
      }
    }
    label240:
    label370:
    for (;;)
    {
      j += 1;
      break;
      localObject = "-";
      break label131;
      str = "-";
      break label141;
      label247:
      if ((k == 11) && (i1 == 0))
      {
        arrayOfString[i] = (n - 1 + "-" + (k + 1) + (String)localObject + m);
        break label194;
      }
      arrayOfString[i] = (n + str + (k + 1) + (String)localObject + m);
      break label194;
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriendGrid", 2, new Object[] { localStringBuilder });
      }
      return arrayOfString;
    }
  }
  
  public ActivateFriendGridItem a()
  {
    ActivateFriendGridItem localActivateFriendGridItem = new ActivateFriendGridItem(getContext(), this.bco, this.bcp);
    addView(localActivateFriendGridItem, new FrameLayout.LayoutParams(-2, -2));
    return localActivateFriendGridItem;
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.c);
      this.app.unRegistObserver(this.jdField_b_of_type_Acog);
    }
  }
  
  public long[] h()
  {
    long[] arrayOfLong = new long[this.bNk];
    int i = 0;
    int k;
    for (int j = 0; i < this.pX.size(); j = k)
    {
      k = j;
      if (((ActivateFriendGridItem)this.pX.get(i)).isChecked)
      {
        arrayOfLong[j] = ((ActivateFriendItem)this.mData.get(i)).uin;
        k = j + 1;
      }
      i += 1;
    }
    return arrayOfLong;
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
            ((ActivateFriendGridItem)this.pX.get(paramInt1)).setHead(paramString);
          }
          paramInt1 += 1;
        }
        this.faceCache.clear();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 0;
    int i = this.pX.size();
    label22:
    int n;
    ActivateFriendGridItem localActivateFriendGridItem;
    int j;
    int k;
    int m;
    if (i > 3)
    {
      paramInt2 = 2;
      paramInt3 = 0;
      if (paramInt3 >= i) {
        break label290;
      }
      n = ah(paramInt3, i);
      localActivateFriendGridItem = (ActivateFriendGridItem)this.pX.get(paramInt3);
      j = localActivateFriendGridItem.getMeasuredHeight();
      k = localActivateFriendGridItem.getMeasuredWidth();
      paramInt4 = paramInt3 / 3;
      m = paramInt3 % 3;
      if (m != 0) {
        break label291;
      }
      paramInt1 = 0;
      if (this.pX.size() > 0) {
        paramInt1 = ((ActivateFriendGridItem)this.pX.get(0)).getMeasuredWidth();
      }
      if (paramInt1 * n + aqcx.dip2px(getContext(), bNj) * (n - 1) <= this.measuredWidth) {
        break label242;
      }
      paramInt1 = (this.measuredWidth - paramInt1 * n) / (n + 2);
      bNj = paramInt1;
    }
    label158:
    label290:
    label291:
    for (;;)
    {
      if (paramInt2 > 1) {}
      for (paramInt4 = paramInt4 * j + paramInt4 * aqcx.dip2px(getContext(), bNi);; paramInt4 = this.measuredHeight / 2 - j / 2)
      {
        m = m * k + paramInt1 + m * aqcx.dip2px(getContext(), bNj);
        localActivateFriendGridItem.layout(m, paramInt4, k + m, j + paramInt4);
        paramInt3 += 1;
        break label22;
        paramInt2 = 1;
        break;
        label242:
        paramInt1 = (this.measuredWidth - paramInt1 * n - (n - 1) * aqcx.dip2px(getContext(), bNj)) / 2;
        break label158;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.measuredWidth = getMeasuredWidth();
    this.measuredHeight = measureHeight(paramInt2);
    setMeasuredDimension(getMeasuredWidth(), this.measuredHeight);
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
      removeView((ActivateFriendGridItem)paramQQAppInterface.next());
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
    int j = this.mData.size();
    int i = 0;
    if (i < j)
    {
      paramQQAppInterface = a();
      paramQQAppInterface.setIndex(i);
      paramQQAppInterface.setBirthday(((ActivateFriendItem)this.mData.get(i)).birthdayDesc);
      paramQQAppInterface.setCheckViewGone();
      paramArrayList = String.valueOf(((ActivateFriendItem)this.mData.get(i)).uin);
      if (!TextUtils.isEmpty(((ActivateFriendItem)this.mData.get(i)).nickName))
      {
        paramQQAppInterface.setNickName(((ActivateFriendItem)this.mData.get(i)).nickName);
        label255:
        paramQQAppInterface.setHead(getFaceBitmap(paramArrayList));
        if (this.bcn) {
          paramQQAppInterface.setOnClickListener(this.dF);
        }
        if (this.bcn)
        {
          if ((!getResources().getString(2131689658).equals(((ActivateFriendItem)this.mData.get(i)).birthdayDesc)) && (!this.jdField_b_of_type_Acof.n(((ActivateFriendItem)this.mData.get(i)).uin, ((ActivateFriendItem)this.mData.get(i)).type))) {
            break label405;
          }
          paramQQAppInterface.setChecked(false);
          paramQQAppInterface.setBirthday(getResources().getString(2131689658));
        }
      }
      for (;;)
      {
        this.pX.add(paramQQAppInterface);
        i += 1;
        break;
        paramQQAppInterface.setNickName(aqgv.b(this.app, paramArrayList, true));
        break label255;
        label405:
        if ((this.jdField_b_of_type_Acof.l(((ActivateFriendItem)this.mData.get(i)).uin, ((ActivateFriendItem)this.mData.get(i)).type)) || (this.jdField_b_of_type_Acof.m(((ActivateFriendItem)this.mData.get(i)).uin, ((ActivateFriendItem)this.mData.get(i)).type)))
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
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a.BW(this.bNk);
    }
  }
  
  public void setGridCallBack(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$a = parama;
  }
  
  public void setGridItemClickCallBack(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid$b = paramb;
  }
  
  public void setSkinable(boolean paramBoolean)
  {
    this.bco = paramBoolean;
  }
  
  public void setTextScrolling(boolean paramBoolean)
  {
    this.bcp = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void BW(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void rr(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid
 * JD-Core Version:    0.7.0.1
 */