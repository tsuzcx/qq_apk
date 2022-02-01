package com.tencent.mobileqq.search.fragment;

import acfp;
import amlt;
import ammv;
import ammw;
import amoq;
import ampt;
import ampx;
import amsf.a;
import amux;
import amvg;
import amwd;
import amwo;
import amwq;
import amwu;
import amwv;
import amwx;
import amxd;
import amxk;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import aprg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactSearchFragment
  extends BaseSearchFragment
{
  private List<PhoneContact> FN = new ArrayList();
  private amsf.a a;
  private Set<String> ac = new HashSet();
  private long ajQ = -1L;
  private boolean bBc;
  private boolean cDi;
  private Set<String> cQ;
  private Set<String> cR = new HashSet();
  private String caU;
  private int dCH;
  private int dCI;
  private int fromType;
  private boolean isSearching;
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, amsf.a parama)
  {
    return a(paramInt1, paramInt2, paramString, paramList, parama, false, 0, -1L);
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, String paramString, List<String> paramList, amsf.a parama, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ContactSearchFragment localContactSearchFragment = new ContactSearchFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("contactSearchSource", paramInt2);
    localBundle.putString("specifiedTroopUin", paramString);
    localBundle.putBoolean("isApproximate", paramBoolean);
    localBundle.putInt("ContactCombineType", paramInt3);
    if (paramList != null) {
      localBundle.putStringArray("hiddenUinSet", (String[])paramList.toArray(new String[paramList.size()]));
    }
    if (parama != null) {
      localBundle.putLong("contactSearchOnActionListener", amxd.a().b(parama));
    }
    if (paramLong > 0L) {
      localBundle.putLong("contactSearchResultFilterType", paramLong);
    }
    localContactSearchFragment.setArguments(localBundle);
    return localContactSearchFragment;
  }
  
  public static ContactSearchFragment a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    return a(paramInt1, paramInt2, null, null, null, paramBoolean, paramInt3, -1L);
  }
  
  protected boolean DS()
  {
    return amxk.lo(this.fromType);
  }
  
  protected int IT()
  {
    return 20;
  }
  
  public void N(List<String> paramList1, List<String> paramList2)
  {
    this.ac.clear();
    this.cR.clear();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        String str = (String)paramList1.next();
        this.ac.add(str);
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      paramList1 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        this.cR.add(paramList2);
      }
    }
  }
  
  public void Pt(boolean paramBoolean)
  {
    this.bBc = paramBoolean;
  }
  
  protected amlt a()
  {
    return new ammw(this, this.jdField_a_of_type_ComTencentWidgetListView, this.c);
  }
  
  protected amwd a()
  {
    if (this.dCH == 524288)
    {
      if (this.fromType == 19) {
        return new amwq(this.d, this.fromType, this.dCH, this.caU, this.cQ);
      }
      return new amwo(this.d, this.fromType, this.dCH, this.caU, this.cQ);
    }
    if (this.cDi) {
      return new amux(this.d, this.fromType, this.dCH, this.caU, this.cQ);
    }
    if (this.dCH == 1048576)
    {
      if (this.fromType == 23) {
        return new amwx(this.d, this.fromType, this.dCH, this.caU, this.cQ);
      }
      return new amwv(this.d, this.fromType, this.dCH, this.caU, this.cQ);
    }
    return new amvg(this.d, this.fromType, this.dCH, this.caU, this.cQ);
  }
  
  public void a(List paramList, amwu paramamwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with respData:", paramamwu.toString() });
    }
    if (paramamwu.oI(this.keyword)) {
      s(paramList, paramamwu.status);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramamwu.keyword, " keyword2:", this.keyword });
  }
  
  protected void fO(String paramString, int paramInt)
  {
    super.fO(paramString, paramInt);
    if (((!amxk.lo(this.fromType)) || (this.fromType == -1)) && (this.GV != null))
    {
      if (!TextUtils.isEmpty(paramString)) {
        break label73;
      }
      this.isSearching = false;
      if (this.fromType == -1) {
        this.GV.setBackgroundResource(2131167595);
      }
    }
    else
    {
      return;
    }
    this.GV.setBackgroundResource(2131165586);
    return;
    label73:
    this.isSearching = true;
    this.GV.setBackgroundResource(2130838900);
  }
  
  protected void mg(List paramList)
  {
    super.mg(paramList);
    if ((amxk.lo(this.fromType)) && (paramList != null) && (!this.isReported))
    {
      this.isReported = true;
      amxk.b("contact", "exp_page", new String[] { "" + this.keyword, "" + paramList.size() });
    }
  }
  
  public void mi(List<PhoneContact> paramList)
  {
    this.FN.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.FN.addAll(paramList);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 0;
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.dCH = localBundle.getInt("contactSearchSource", 197437);
      this.fromType = localBundle.getInt("fromType", -1);
      this.ajQ = localBundle.getLong("contactSearchResultFilterType", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("ContactSearchFragment", 2, "onCreate searchSource = " + this.dCH + ",fromType = " + this.fromType + ",filterType = " + this.ajQ);
      }
      this.cDi = localBundle.getBoolean("isApproximate", false);
      this.dCI = localBundle.getInt("ContactCombineType", 0);
      this.caU = localBundle.getString("specifiedTroopUin");
      String[] arrayOfString = localBundle.getStringArray("hiddenUinSet");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        this.cQ = new HashSet();
        int j = arrayOfString.length;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.cQ.add(str);
          i += 1;
        }
      }
      long l = localBundle.getLong("contactSearchOnActionListener", -1L);
      if (l != -1L) {
        this.jdField_a_of_type_Amsf$a = ((amsf.a)amxd.a().getObject(l));
      }
    }
    super.onCreate(paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (!amxk.lo(this.fromType))
    {
      if (this.fromType != -1) {
        break label55;
      }
      this.GV.setBackgroundResource(2131167595);
    }
    for (;;)
    {
      this.isSearching = false;
      this.jdField_a_of_type_ComTencentWidgetListView.setOnTouchListener(new ammv(this));
      return;
      label55:
      this.GV.setBackgroundResource(2131165586);
    }
  }
  
  public void s(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, new Object[] { "onFinish with status:", Integer.valueOf(paramInt) });
    }
    Object localObject1 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder(2048);
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        Object localObject3;
        if ((QLog.isColorLevel()) && ((localObject2 instanceof ampt)))
        {
          localObject3 = (ampt)localObject2;
          localStringBuilder.append("model name:").append(((ampt)localObject3).za()).append(" clss:").append(localObject3.getClass().getSimpleName()).append(" degree:").append(((ampt)localObject3).gN()).append(" second:").append(((ampt)localObject3).gM()).append("\n");
        }
        if ((localObject2 instanceof ampx))
        {
          localObject2 = (ampx)localObject2;
          if ((!this.bBc) || (!(this.d instanceof QQAppInterface)) || (!aprg.V(this.d, ((ampx)localObject2).getUin())))
          {
            if ((this.ajQ > 0L) && ((this.ajQ & 1L) != 0L) && ((localObject2 instanceof amoq)))
            {
              localObject3 = (amoq)localObject2;
              if ((((amoq)localObject3).lk() == 1000) || (((amoq)localObject3).lk() == 1004) || (((amoq)localObject3).lk() == 1003) || (((amoq)localObject3).lk() == 1006) || (((amoq)localObject3).lk() == 2016))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("ContactSearchFragment", 2, "onFinish filter a result ,uintype = " + ((amoq)localObject3).lk());
                continue;
              }
            }
            if ((this.dCI == 2) && (amxk.a((ampx)localObject2))) {
              ((List)localObject1).add(localObject2);
            } else if ((this.dCI == 1) && (!amxk.a((ampx)localObject2))) {
              ((List)localObject1).add(localObject2);
            } else if (this.dCI == 0) {
              ((List)localObject1).add(localObject2);
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ContactSearchFragment", 2, localStringBuilder.toString());
    }
    super.s((List)localObject1, paramInt);
    if ((amxk.lo(this.fromType)) && (!this.isReported))
    {
      this.isReported = true;
      localObject1 = "" + this.keyword;
      localStringBuilder = new StringBuilder().append("");
      if (paramList != null) {
        break label590;
      }
    }
    label590:
    for (paramInt = 0;; paramInt = paramList.size())
    {
      amxk.b("contact", "exp_page", new String[] { localObject1, paramInt });
      if (this.cDi)
      {
        this.cDi = false;
        this.cDy = false;
        this.jdField_a_of_type_Amwd = a();
        this.jdField_a_of_type_Amwd.init();
        this.cDy = true;
      }
      return;
    }
  }
  
  protected String vn()
  {
    if (this.dCI == 2) {
      return acfp.m(2131704438);
    }
    return acfp.m(2131704441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.ContactSearchFragment
 * JD-Core Version:    0.7.0.1
 */