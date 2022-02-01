package com.tencent.av.ui.beauty;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.BaseToolbar;
import com.tencent.av.ui.EffectSettingUi;
import com.tencent.av.ui.QavListItemBase.c;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import ikd;
import java.util.ArrayList;
import jcc;
import jcc.a;
import jcs;
import jjc;

public class MakeupView
  extends BeautyBaseView
  implements jcc.a
{
  String Nv = null;
  ikd jdField_a_of_type_Ikd = null;
  jcs jdField_a_of_type_Jcs = null;
  int anX = 50;
  final BeautySeekView b;
  final ArrayList<QavListItemBase.c> ed = new ArrayList(10);
  jcc mAdapter = null;
  final HorizontalListView mListView;
  final TextView mTipView;
  
  public MakeupView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MakeupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MakeupView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    inflate(paramContext, 2131559942, this);
    this.mTipView = ((TextView)findViewById(2131379722));
    this.b = ((BeautySeekView)findViewById(2131363380));
    this.b.setBeautySeekActionListener(this);
    this.mListView = ((HorizontalListView)findViewById(2131368682));
    this.mListView.setStayDisplayOffsetZero(true);
    avP();
  }
  
  public void K(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ikd != null) {
      this.jdField_a_of_type_Ikd.a(paramLong, this.jdField_a_of_type_Jcs);
    }
    refreshUI();
  }
  
  public void L(long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ikd != null) {
      this.jdField_a_of_type_Ikd.b(paramLong, this.jdField_a_of_type_Jcs);
    }
  }
  
  public void a(long paramLong, QavListItemBase.c paramc)
  {
    PendantItem localPendantItem = null;
    if (QLog.isColorLevel()) {
      QLog.i("MakeupView", 2, "onEffectClick, seq[" + paramLong + "], info[" + paramc + "]");
    }
    EffectSettingUi.a(this.mApp, paramLong);
    if (paramc == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Ikd != null) {
        this.jdField_a_of_type_Ikd.o(paramLong, "onEffectClick");
      }
      if (TextUtils.equals("0", paramc.id))
      {
        if (this.jdField_a_of_type_Ikd != null) {
          this.jdField_a_of_type_Ikd.a(paramLong, null);
        }
        kq(null);
        jjc.b("0X800AA64", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_a_of_type_Ikd != null) {
        localPendantItem = (PendantItem)this.jdField_a_of_type_Ikd.a(paramc.id);
      }
    } while ((localPendantItem == null) || (TextUtils.isEmpty(localPendantItem.getId())));
    if (this.jdField_a_of_type_Ikd != null) {
      this.jdField_a_of_type_Ikd.a(paramLong, localPendantItem);
    }
    kq(paramc.id);
    try
    {
      jjc.au("0X800AA62", Integer.parseInt(paramc.id));
      return;
    }
    catch (Throwable paramc) {}
  }
  
  public void avP()
  {
    if (TextUtils.isEmpty(this.Nv))
    {
      if (this.mTipView != null) {
        this.mTipView.setVisibility(0);
      }
      if (this.b != null) {
        this.b.setVisibility(8);
      }
    }
    do
    {
      return;
      if (this.mTipView != null) {
        this.mTipView.setVisibility(8);
      }
    } while (this.b == null);
    this.b.setVisibility(0);
    String str = getContext().getResources().getString(2131697596);
    this.b.a(str, this.Nv, this.anX, 0);
  }
  
  public void avQ()
  {
    Object localObject2 = null;
    int j = 0;
    if (this.jdField_a_of_type_Ikd != null) {
      if (this.jdField_a_of_type_Ikd.tz()) {
        break label123;
      }
    }
    label123:
    for (Object localObject1 = this.jdField_a_of_type_Ikd.Nv;; localObject1 = null)
    {
      int i = 0;
      if (i < this.ed.size())
      {
        QavListItemBase.c localc = (QavListItemBase.c)this.ed.get(i);
        if ((localc == null) || (!TextUtils.equals((CharSequence)localObject1, localc.id))) {}
      }
      for (;;)
      {
        if (i < 1)
        {
          i = j;
          localObject1 = localObject2;
        }
        for (;;)
        {
          kq((String)localObject1);
          if (this.mAdapter != null) {
            BaseToolbar.setSelectedListViewItemAndShow(this.mListView, this.mAdapter, i);
          }
          return;
          i += 1;
          break;
        }
        i = -1;
      }
    }
  }
  
  void avR()
  {
    ArrayList localArrayList = this.jdField_a_of_type_Jcs.a(getContext());
    this.ed.clear();
    this.ed.addAll(localArrayList);
  }
  
  public void dk(long paramLong)
  {
    EffectSettingUi.a(this.mApp, paramLong);
  }
  
  public void j(String paramString, int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 1: 
    default: 
    case 2: 
      do
      {
        return;
        this.anX = paramInt2;
      } while (this.jdField_a_of_type_Ikd == null);
      this.jdField_a_of_type_Ikd.d(this.Nv, this.anX, false);
      return;
    }
    this.anX = paramInt2;
    if (this.jdField_a_of_type_Ikd != null) {
      this.jdField_a_of_type_Ikd.d(this.Nv, this.anX, true);
    }
    try
    {
      jjc.au("0X800AA63", Integer.parseInt(this.Nv));
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void kq(String paramString)
  {
    if (!TextUtils.equals(paramString, this.Nv))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MakeupView", 2, "changeCurSelItem, cur[" + paramString + "], pre[" + this.Nv + "]");
      }
      this.Nv = paramString;
      if (this.jdField_a_of_type_Ikd != null)
      {
        this.anX = this.jdField_a_of_type_Ikd.am(this.Nv);
        this.jdField_a_of_type_Ikd.d(this.Nv, this.anX, false);
      }
      avP();
    }
  }
  
  public void onClick(View paramView) {}
  
  public void refreshUI()
  {
    if ((this.mAdapter != null) && (this.jdField_a_of_type_Ikd != null))
    {
      avR();
      this.mAdapter.bE(this.ed);
      this.mAdapter.notifyDataSetChanged();
      avQ();
    }
  }
  
  public void setAppInterface(VideoAppInterface paramVideoAppInterface)
  {
    super.setAppInterface(paramVideoAppInterface);
    long l = AudioHelper.hG();
    if (this.mApp != null)
    {
      this.jdField_a_of_type_Ikd = ((ikd)paramVideoAppInterface.a(13));
      this.jdField_a_of_type_Ikd.a(l, this.jdField_a_of_type_Jcs);
    }
    this.jdField_a_of_type_Jcs = new jcs(4, this.jdField_a_of_type_Ikd);
    avR();
    this.mAdapter = new jcc(this.mApp, getContext(), this.ed, this.mListView, 5.6F);
    this.jdField_a_of_type_Jcs.a(this.mAdapter);
    this.mAdapter.a(this);
    this.mAdapter.a(this.jdField_a_of_type_Jcs);
    this.mAdapter.jU(true);
    this.mAdapter.jV(true);
    this.mListView.setAdapter(this.mAdapter);
    avQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.beauty.MakeupView
 * JD-Core Version:    0.7.0.1
 */