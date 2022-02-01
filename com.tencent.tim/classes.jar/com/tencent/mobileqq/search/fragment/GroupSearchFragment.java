package com.tencent.mobileqq.search.fragment;

import acfp;
import acja;
import acnk;
import acnm;
import amkb;
import amkd;
import amke;
import amkl;
import amkl.a;
import amlt;
import amlx;
import ammz;
import amna;
import amov;
import amow;
import ampf;
import ampg;
import amph;
import ampi;
import ampj;
import ampk;
import ampm;
import ampo;
import ampr;
import ampv;
import ampw;
import ampx;
import amqg;
import amqk;
import amql;
import amqm;
import amqv;
import amqy;
import amra;
import amrd;
import amrj;
import amrk;
import amub;
import amwd;
import amwt;
import amwu;
import amxd;
import amxk;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import anot;
import aqdf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lampv;>;
import org.json.JSONException;
import org.json.JSONObject;
import txn;

public class GroupSearchFragment
  extends BaseSearchFragment
  implements amke, AbsListView.e
{
  public static volatile String caM;
  public amrd a;
  private long ajR;
  public long ajS;
  public amrd b;
  private volatile boolean boL;
  public boolean cDA;
  public boolean cDB;
  private boolean cDv = true;
  public String caF = "";
  public boolean cj;
  public int cyX;
  int dCQ = 0;
  int dCR = 0;
  public volatile int dCU;
  public volatile int dCV;
  public volatile int dyI;
  byte[] fp;
  private int fromType = -1;
  public boolean isEnd;
  public boolean isViewCreated;
  public long lastUpdateTime;
  public Handler mHandler = new ammz(this, Looper.getMainLooper());
  int mScrollState;
  private int source;
  
  public GroupSearchFragment()
  {
    this.jdField_a_of_type_Amrd = new amrd("", -1, 2130841037, true);
  }
  
  public static GroupSearchFragment a(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("source", paramInt2);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  public static GroupSearchFragment a(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("fromType", paramInt1);
    localBundle.putInt("source", paramInt2);
    localBundle.putLong("searchEngineKey", paramLong);
    GroupSearchFragment localGroupSearchFragment = new GroupSearchFragment();
    localGroupSearchFragment.setArguments(localBundle);
    return localGroupSearchFragment;
  }
  
  private void d(int paramInt, String paramString, List<ampv> paramList)
  {
    int i = 1;
    Object localObject1 = "";
    Object localObject2 = new HashMap();
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        if (paramList.size() > 0)
        {
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            Object localObject3 = (ampv)paramList.next();
            if (!(localObject3 instanceof ampf)) {
              continue;
            }
            localObject3 = ((ampf)localObject3).getGroupName();
            if (acfp.m(2131707066).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(1), Integer.valueOf(1));
              continue;
            }
            if (acfp.m(2131707053).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(2), Integer.valueOf(2));
              continue;
            }
            if (acfp.m(2131707047).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(3), Integer.valueOf(3));
              continue;
            }
            if (acfp.m(2131707045).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(4), Integer.valueOf(4));
              continue;
            }
            if (acfp.m(2131707077).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(5), Integer.valueOf(5));
              continue;
            }
            if (acfp.m(2131695158).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(6), Integer.valueOf(6));
              continue;
            }
            if (acfp.m(2131707057).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(7), Integer.valueOf(7));
              continue;
            }
            if (acfp.m(2131720732).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(8), Integer.valueOf(8));
              continue;
            }
            if (acfp.m(2131707058).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(9), Integer.valueOf(9));
              continue;
            }
            if (acfp.m(2131707062).equals(localObject3))
            {
              ((HashMap)localObject2).put(Integer.valueOf(10), Integer.valueOf(10));
              continue;
            }
            ((HashMap)localObject2).put(Integer.valueOf(11), Integer.valueOf(11));
            continue;
          }
        }
        paramList = (List<ampv>)localObject1;
        if (((HashMap)localObject2).size() > 0)
        {
          paramList = new StringBuilder();
          localObject1 = ((HashMap)localObject2).values().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            if (i == 0)
            {
              paramList.append("_");
              paramList.append(localObject2);
            }
          }
          else
          {
            paramList = paramList.toString();
          }
        }
        else
        {
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)localObject1;
            anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800973C", "0X800973C", paramInt, 0, "", "", paramString, paramList);
            return;
          }
          localObject1 = null;
          continue;
        }
        i = 0;
      }
      catch (Throwable paramString)
      {
        return;
      }
    }
  }
  
  private int fj(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 6: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  private List<Long> gf()
  {
    List localList = new PublicAccountSearchEngine(this.d, this.fromType).a(new amwt(this.keyword));
    if ((localList == null) || (localList.size() == 0)) {
      return null;
    }
    ArrayList localArrayList1 = ((acja)this.d.getManager(56)).cx();
    ArrayList localArrayList2 = new ArrayList();
    if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "all publicAccountInfoList is null or empty");
      }
    }
    for (;;)
    {
      return localArrayList2;
      int i = 0;
      while (i < localList.size())
      {
        amqy localamqy = (amqy)localList.get(i);
        int j = 0;
        while (j < localArrayList1.size())
        {
          PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)localArrayList1.get(j);
          if (TextUtils.equals(String.valueOf(localPublicAccountInfo.uin), String.valueOf(localamqy.e.uin))) {
            localArrayList2.add(Long.valueOf(localPublicAccountInfo.uin));
          }
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  private int je(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 6: 
    default: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 3;
    case 4: 
      return 4;
    }
    return 5;
  }
  
  private void mj(List<ampv> paramList)
  {
    amrj.B(paramList, this.keyword);
    mk(paramList);
  }
  
  private void mk(List<ampv> paramList)
  {
    int k = 0;
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int i = 0;
      label91:
      int j;
      if (i < paramList.size())
      {
        ampv localampv1 = (ampv)paramList.get(i);
        ArrayList localArrayList1;
        if ((localampv1 instanceof amra)) {
          if (((amra)localampv1).awh())
          {
            localArrayList1 = localArrayList2;
            if (i > 0)
            {
              ampv localampv2 = (ampv)paramList.get(i - 1);
              if ((localampv2 instanceof ampf))
              {
                localArrayList1.add(localampv2);
                localArrayList4.remove(localampv2);
              }
            }
            localArrayList1.add(localampv1);
            j = i;
            if (i + 1 > paramList.size())
            {
              localampv1 = (ampv)paramList.get(i + 1);
              j = i;
              if ((localampv1 instanceof ampg)) {
                localArrayList1.add(localampv1);
              }
            }
          }
        }
        for (j = i + 1;; j = i)
        {
          i = j + 1;
          break;
          localArrayList1 = localArrayList3;
          break label91;
          if (((localampv1 instanceof ampr)) && (QLog.isColorLevel())) {
            QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, error, GroupSearchModelRichNode.");
          }
          localArrayList4.add(localampv1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, total:" + paramList.size() + " exact:" + localArrayList2.size() + " fuzzy:" + localArrayList3.size() + " other:" + localArrayList4.size());
      }
      if ((localArrayList2.size() != 0) || (localArrayList3.size() != 0))
      {
        if (localArrayList3.size() == 0)
        {
          paramList.clear();
          paramList.addAll(localArrayList2);
          paramList.addAll(localArrayList4);
          return;
        }
        paramList.clear();
        paramList.addAll(localArrayList2);
        if (localArrayList4.size() == 0)
        {
          paramList.addAll(localArrayList3);
          return;
        }
        j = z(localArrayList4);
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "adjustRichNodePosition, fuzzy pos:" + j);
        }
        i = k;
        if (j <= 0)
        {
          paramList.addAll(localArrayList3);
          paramList.addAll(localArrayList4);
          return;
        }
        while (i < j)
        {
          paramList.add(localArrayList4.get(i));
          i += 1;
        }
        paramList.addAll(localArrayList3);
        i = j;
        while (i < localArrayList4.size())
        {
          paramList.add(localArrayList4.get(i));
          i += 1;
        }
      }
    }
  }
  
  private int z(List<ampv> paramList)
  {
    int i = 0;
    if (paramList == null) {
      i = -1;
    }
    while (paramList.size() == 0) {
      return i;
    }
    int j = 0;
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if (j < paramList.size())
    {
      localObject3 = (ampv)paramList.get(j);
      if ((localObject3 instanceof ampf))
      {
        localObject2 = ((ampf)localObject3).a();
        if (localObject2 == null)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break label586;
          }
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, groupmodel is null:" + localObject3);
        }
      }
    }
    for (;;)
    {
      j += 1;
      break;
      localObject1 = ((ampw)localObject2).eX();
      localObject2 = ((ampf)localObject3).getGroupName();
      if ((!acfp.m(2131707068).equals(localObject2)) && (!acfp.m(2131707065).equals(localObject2)) && (!acfp.m(2131707050).equals(localObject2)) && (!ampo.cbt.equals(localObject2)))
      {
        if (acfp.m(2131707046).equals(localObject2))
        {
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((List)localObject1).size() != 0) {}
          }
          else
          {
            localObject2 = localObject1;
            if (QLog.isColorLevel()) {
              QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision error, only has title， miniprogram");
            }
          }
        }
        else
        {
          if (((ampf)localObject3).cDR) {
            continue;
          }
          localObject2 = amkd.yY();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(((ampf)localObject3).getGroupName()))) {
            i = 1;
          }
          for (;;)
          {
            if (i != 0)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break label586;
              }
              if (((List)localObject1).size() == 0)
              {
                break;
                i = 0;
                continue;
              }
              if ((((List)localObject1).get(0) instanceof amow))
              {
                localObject3 = (amow)((List)localObject1).get(0);
                localObject2 = ((amow)localObject3).name;
                localObject3 = ((amow)localObject3).getKeyword();
                if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(localObject3))) {
                  break label398;
                }
                i = 1;
              }
              for (;;)
              {
                if (i != 0)
                {
                  break;
                  label398:
                  i = 0;
                  continue;
                  if ((localObject3 instanceof ampg))
                  {
                    localObject1 = null;
                    break;
                  }
                  if ((localObject3 instanceof amrd))
                  {
                    if (!((amrd)localObject3).awi()) {
                      break label584;
                    }
                    localObject1 = null;
                    break;
                  }
                  if (((localObject3 instanceof ampo)) || ((localObject3 instanceof ampi)) || ((localObject3 instanceof ampm)) || ((localObject3 instanceof amph)) || ((localObject3 instanceof ampj)) || ((localObject3 instanceof ampk)) || (((localObject3 instanceof amqv)) && (((amqv)localObject3).cDR)) || ((localObject1 != null) && (((List)localObject1).contains(localObject3)))) {
                    break;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "getFuzzyPotision, break:" + localObject3);
                  }
                }
              }
            }
          }
          label584:
          return j;
        }
        label586:
        localObject1 = localObject2;
      }
    }
  }
  
  public ArrayList B(List paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.size() == 0) {
      return new ArrayList(paramList);
    }
    ArrayList localArrayList = ((amrk)this.d.getManager(318)).S(caM);
    return amrj.a(caM, localArrayList, paramList);
  }
  
  protected boolean DS()
  {
    return false;
  }
  
  protected int IT()
  {
    return 0;
  }
  
  public void Id(String paramString)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment log for search  startSearch   isLocalSearch");
    VADHelper.PZ("voice_search_als_cost");
    fO(paramString, 1);
  }
  
  public void PQ(String paramString)
  {
    this.keyword = paramString;
    caM = paramString;
    if (QLog.isColorLevel()) {
      QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "GroupSearchFragment isViewCreated " + this.isViewCreated + " startSearch:" + paramString + "  forceRequestStatus=" + this.dCV);
    }
    if ((!this.isViewCreated) || (this.d == null))
    {
      QLog.w("Q.uniteSearch.GroupSearchFragment", 1, "startSearchForHotWord called  isViewCreated == false!! ");
      return;
    }
    amkl.ajN = System.currentTimeMillis();
    amkl.mT.clear();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      amub.a(this.d, new ReportModelDC02528().module("all_result").action("search_request").ver1(paramString).ver2(amub.eZ(this.fromType)).ver7(localJSONObject.toString()).session_id(this.d.getCurrentAccountUin() + amkl.ajN));
      if ((this.fromType == 21) && (amkd.IP() == 0))
      {
        amxk.b("all_result", "exp_pure_net_result", new String[] { paramString });
        this.dCV = 6;
        showLoading();
        s(new ArrayList(), 4);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      hideLoading();
      paramString = new GroupSearchFragment.2(this);
      if (this.cDy)
      {
        this.mHandler.removeMessages(100);
        this.mHandler.sendEmptyMessage(100);
        return;
      }
      ThreadManager.postImmediately(paramString, null, true);
    }
  }
  
  public void Pm(boolean paramBoolean)
  {
    this.cDv = paramBoolean;
  }
  
  public void X(String paramString1, int paramInt, String paramString2)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search onResultError, keyword = " + paramString1);
    this.Hb.setVisibility(8);
    hideLoading();
    this.cj = false;
    this.isEnd = true;
    if ((this.rc.size() != 1) || (!(this.rc.get(0) instanceof amrd)) || (!((amrd)this.rc.get(0)).awi()))
    {
      this.YM.setVisibility(0);
      this.YM.setOnClickListener(new amna(this));
    }
  }
  
  protected amlt a()
  {
    return new amlx(this.jdField_a_of_type_ComTencentWidgetListView, this.c, this, this.fromType);
  }
  
  protected amwd a()
  {
    if (this.jdField_a_of_type_Amwd != null) {
      return this.jdField_a_of_type_Amwd;
    }
    if (this.ajR > 0L)
    {
      Object localObject = amxd.a().getObject(this.ajR);
      if ((localObject != null) && ((localObject instanceof GroupSearchEngine)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchFragment", 2, " use VADActivity cache engine...");
        }
        this.cDy = true;
        return (GroupSearchEngine)localObject;
      }
    }
    return new GroupSearchEngine(this.d, this.fromType);
  }
  
  public void a(String paramString, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, List<ampv> paramList)
  {
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "onResultSuc, keyword = " + paramString + ", isFirstReq = " + paramBoolean1 + ", cookie = " + paramArrayOfByte + ", isEnd = " + paramBoolean2 + ", netResultItemList = " + paramList);
    }
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    int j;
    int i;
    int k;
    if (paramBoolean1)
    {
      j = 0;
      i = 0;
      while (i < ((List)localObject).size())
      {
        k = j;
        if (!(((List)localObject).get(i) instanceof ampf)) {
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      paramList = new JSONObject();
    }
    try
    {
      paramList.put("project", amub.zn());
      paramList.put("event_src", "client");
      paramList.put("web_num", j);
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      amub.a(localQQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(paramString).ver2(amub.eZ(this.fromType)).ver7(paramList.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      if (!paramBoolean1) {
        break label526;
      }
      i = 0;
      j = 0;
      k = 0;
      while (k < ((List)localObject).size())
      {
        int n = j;
        int m = i;
        if ((((List)localObject).get(k) instanceof amow))
        {
          if (((amow)((List)localObject).get(k)).IW() == 1001) {
            i = 1;
          }
          n = j;
          m = i;
          if (((amow)((List)localObject).get(k)).IW() == 1001)
          {
            n = 1;
            m = i;
          }
        }
        k += 1;
        j = n;
        i = m;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
      }
      k = 0;
      if (i == 0) {
        break label635;
      }
    }
    if (j != 0)
    {
      i = 90;
      if (i != 0) {
        anot.a(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i, 0, "", "", "", "");
      }
      label526:
      this.cj = false;
      bt(paramArrayOfByte);
      this.isEnd = paramBoolean2;
      this.Hb.setVisibility(8);
      this.YM.setVisibility(8);
      paramArrayOfByte = ((List)localObject).iterator();
      i = 0;
      label571:
      if (!paramArrayOfByte.hasNext()) {
        break label672;
      }
      paramList = (ampv)paramArrayOfByte.next();
      if (!(paramList instanceof ampw)) {
        break label663;
      }
      if (((ampw)paramList).eX() == null) {
        break label1082;
      }
      i = ((ampw)paramList).eX().size() + i;
    }
    label663:
    label672:
    label948:
    label1076:
    label1082:
    for (;;)
    {
      break label571;
      label635:
      if (i != 0)
      {
        i = 70;
        break;
      }
      i = k;
      if (j == 0) {
        break;
      }
      i = 80;
      break;
      i += 1;
      continue;
      if (paramBoolean1)
      {
        if (i > 0) {
          amxk.b("all_result", "exp_net_result", new String[] { "" + paramString });
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult isFirstReq==" + paramBoolean1 + " newSearchDataCount:" + this.dCR + "   newSearchIndex:" + this.dCQ + " result.size():" + i);
        }
        if (this.isEnd) {
          break label1076;
        }
        this.dCR += i;
        this.dCQ += 1;
        i = 10;
        if (UniteSearchActivity.bi(this.source, this.fromType)) {
          i = 20;
        }
        if (this.dCR <= i) {
          break label948;
        }
        this.dCQ = 0;
        this.dCR = 0;
        this.cDx = paramBoolean1;
        i = 0;
      }
      for (;;)
      {
        label863:
        if (i != 0)
        {
          if (this.FM == null)
          {
            this.cDx = paramBoolean1;
            this.FM = ((List)localObject);
          }
          for (;;)
          {
            this.cyX += 1;
            d(this.fromType, paramString, this.rc);
            return;
            amxk.b("all_result", "noresult_net", new String[] { "" + paramString });
            break;
            if (this.dCQ >= 3)
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "handleTabSearchResult 触发限频逻辑");
              }
              this.isEnd = true;
              i = 0;
              break label863;
            }
            i = 1;
            dOn();
            break label863;
            this.FM.addAll((Collection)localObject);
          }
        }
        Jp(true);
        if ((this.FM != null) && (this.FM.size() > 0)) {
          ((List)localObject).addAll(0, this.FM);
        }
        for (;;)
        {
          c((List)localObject, this.cDx);
          this.FM = null;
          this.cDx = false;
          break;
          this.cDx = paramBoolean1;
        }
        i = 0;
      }
    }
  }
  
  public void a(List paramList, amwu paramamwu)
  {
    if (paramamwu.oI(this.keyword)) {
      s(paramList, paramamwu.status);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.uniteSearch.GroupSearchFragment", 2, new Object[] { "onFinish not match keyword1:", paramamwu.keyword, " keyword2:", this.keyword });
  }
  
  public boolean avY()
  {
    return this.cDv;
  }
  
  public void bt(byte[] paramArrayOfByte)
  {
    this.fp = paramArrayOfByte;
  }
  
  public void c(List<ampv> paramList, boolean paramBoolean)
  {
    hideLoading();
    if (paramList.size() > 0)
    {
      i = amkl.mT.size();
      int k = 0;
      long l1 = -1L;
      if (k < paramList.size())
      {
        ampv localampv = (ampv)paramList.get(k);
        Object localObject2;
        Object localObject3;
        long l2;
        Object localObject1;
        if ((localampv instanceof amov))
        {
          localObject2 = (amov)localampv;
          int j = i;
          if (((amov)localObject2).eX() != null)
          {
            j = i;
            if (((amov)localObject2).eX().size() > 0)
            {
              j = 0;
              if (j < ((amov)localObject2).eX().size())
              {
                localObject3 = (ampv)((amov)localObject2).eX().get(k);
                l2 = 0L;
                localObject1 = "";
                if ((localObject3 instanceof amqg))
                {
                  l2 = ((amqg)localObject3).ajO;
                  localObject1 = ((amqg)localObject3).id;
                }
                for (;;)
                {
                  amkl.a locala = new amkl.a();
                  i += 1;
                  locala.index = i;
                  locala.ajO = l2;
                  locala.caE = ((String)localObject1);
                  locala.key = ((amov)localampv).getKeyword();
                  amkl.mT.put((ampx)localObject3, locala);
                  j += 1;
                  break;
                  if ((localObject3 instanceof amow))
                  {
                    l2 = ((amow)localObject3).IW();
                    localObject1 = ((amow)localObject3).id;
                  }
                }
              }
              j = i;
            }
          }
          l2 = l1;
          if (l1 == -1L) {
            l2 = ((amov)localObject2).ajO;
          }
          i = j;
          l1 = l2;
        }
        for (;;)
        {
          k += 1;
          break;
          if ((localampv instanceof amqm))
          {
            i += 1;
            localObject1 = ((amqm)localampv).zA;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (amql)((Iterator)localObject1).next();
                localObject3 = new amkl.a();
                ((amkl.a)localObject3).index = i;
                ((amkl.a)localObject3).key = ((amqg)localampv).getKeyword();
                amkl.mT.put(localObject2, localObject3);
              }
            }
          }
          else if ((localampv instanceof amqk))
          {
            i += 1;
            localObject1 = ((amqk)localampv).zA;
            if (localObject1 != null)
            {
              localObject1 = ((ArrayList)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (amql)((Iterator)localObject1).next();
                localObject3 = new amkl.a();
                ((amkl.a)localObject3).index = i;
                ((amkl.a)localObject3).key = ((amqg)localampv).getKeyword();
                amkl.mT.put(localObject2, localObject3);
              }
            }
          }
          else if ((localampv instanceof amqg))
          {
            localObject1 = new amkl.a();
            i += 1;
            ((amkl.a)localObject1).index = i;
            ((amkl.a)localObject1).ajO = ((amqg)localampv).ajO;
            ((amkl.a)localObject1).caE = ((amqg)localampv).id;
            ((amkl.a)localObject1).key = ((amqg)localampv).getKeyword();
            amkl.mT.put((ampx)localampv, localObject1);
          }
          else if ((localampv instanceof amow))
          {
            l2 = ((amow)localampv).IW();
            localObject1 = ((amow)localampv).id;
            localObject2 = new amkl.a();
            i += 1;
            ((amkl.a)localObject2).index = i;
            ((amkl.a)localObject2).ajO = l2;
            ((amkl.a)localObject2).caE = ((String)localObject1);
            ((amkl.a)localObject2).key = ((amow)localampv).getKeyword();
            amkl.mT.put((ampx)localampv, localObject2);
          }
          else if (((localampv instanceof amrd)) && (((amrd)localampv).blx == -4))
          {
            localObject1 = new amkl.a();
            i += 1;
            ((amkl.a)localObject1).index = i;
            ((amkl.a)localObject1).ajO = 2073745984L;
            ((amkl.a)localObject1).key = ((amrd)localampv).f().toString();
            amkl.mT.put((ampx)localampv, localObject1);
          }
          else if ((localampv instanceof ampg))
          {
            localObject1 = new amkl.a();
            ((amkl.a)localObject1).ajO = ((ampg)localampv).ajO;
            ((amkl.a)localObject1).caE = ((ampg)localampv).cbr;
            amkl.mT.put(localampv, localObject1);
          }
        }
      }
    }
    if ((paramBoolean) && (this.rc.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      this.rc.addAll(paramList);
      mj(this.rc);
      if (this.rc.isEmpty()) {
        break;
      }
      this.YL.setVisibility(8);
      this.jdField_a_of_type_Amlt.aq(this.rc, paramBoolean);
      if (i != 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.setSelection(0);
      }
      return;
    }
    this.jdField_a_of_type_Amlt.cS(paramList);
    this.rc = paramList;
  }
  
  public void cR(List paramList)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onUpdate, resultList = " + paramList);
    }
    paramList = B(paramList);
    paramList = this.mHandler.obtainMessage(13, paramList);
    this.mHandler.sendMessage(paramList);
  }
  
  public void clearSearchResult()
  {
    if (this.rc != null) {
      this.rc.clear();
    }
    if (this.FM != null) {
      this.FM.clear();
    }
    if (this.jdField_a_of_type_Amlt != null) {
      this.jdField_a_of_type_Amlt.cS(this.rc);
    }
  }
  
  public void dOm()
  {
    Object localObject1 = "";
    if (this.keyword != null) {
      localObject1 = this.keyword;
    }
    QLog.i("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch " + (String)localObject1);
    Object localObject2;
    double d1;
    double d2;
    label254:
    Bundle localBundle;
    List localList1;
    String str;
    List localList2;
    int i;
    boolean bool;
    if (!UniteSearchActivity.bi(this.source, this.fromType))
    {
      localObject1 = (acnm)this.d.getBusinessHandler(111);
      localObject2 = null;
      d1 = 0.0D;
      d2 = 0.0D;
      if ((getActivity() instanceof amkb))
      {
        d1 = ((amkb)getActivity()).getLat();
        d2 = ((amkb)getActivity()).z();
      }
      this.dCR = 0;
      this.dCQ = 0;
      this.cj = true;
      this.isEnd = false;
      this.caF = (System.currentTimeMillis() + "");
      if (UniteSearchActivity.bi(this.source, this.fromType)) {
        break label406;
      }
      if (this.dCV == 0) {
        this.dCV = 4;
      }
      amxk.b("all_result", "active_net", new String[] { "" + this.keyword, "" + fj(this.dCV) });
      localBundle = new Bundle();
      localBundle.putInt("matchCount", this.dyI);
      localBundle.putInt("source", this.source);
      localList1 = gf();
      if (localObject1 == null) {
        break label494;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use old protocl");
      }
      localObject2 = this.keyword;
      str = this.caF;
      localList2 = amxk.c(acnm.ab);
      i = this.dCV;
      if (this.dCU != 2) {
        break label488;
      }
      bool = true;
      label350:
      ((acnm)localObject1).a((String)localObject2, str, 20, localList2, localList1, i, null, d1, d2, false, bool, this.fromType, localBundle);
    }
    for (;;)
    {
      this.dCV = 0;
      return;
      localObject2 = (acnk)this.d.getBusinessHandler(152);
      localObject1 = null;
      break;
      label406:
      if (this.dCV == 0) {
        this.dCV = 4;
      }
      amxk.b("all_result", "active_net", new String[] { "" + this.keyword, "" + je(this.dCV) });
      break label254;
      label488:
      bool = false;
      break label350;
      label494:
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch use new protocl");
        }
        localObject1 = this.keyword;
        str = this.caF;
        localList2 = amxk.c(acnk.ab);
        i = this.dCV;
        if (this.dCU == 2) {}
        for (bool = true;; bool = false)
        {
          ((acnk)localObject2).a((String)localObject1, str, 20, localList2, localList1, i, null, d1, d2, false, bool, this.fromType, localBundle);
          break;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "log for search startNetSearch error");
      }
    }
  }
  
  public void dOn()
  {
    this.cj = true;
    Jp(false);
    Object localObject1;
    Object localObject2;
    if (!UniteSearchActivity.bi(this.source, this.fromType))
    {
      localObject1 = (acnm)this.d.getBusinessHandler(111);
      localObject2 = null;
    }
    for (;;)
    {
      hideLoading();
      this.Hb.setVisibility(0);
      this.YM.setVisibility(8);
      double d1 = 0.0D;
      double d2 = 0.0D;
      if ((getActivity() instanceof amkb))
      {
        d1 = ((amkb)getActivity()).getLat();
        d2 = ((amkb)getActivity()).z();
      }
      this.caF = (System.currentTimeMillis() + "");
      if (QLog.isColorLevel()) {
        QLog.i("Q.uniteSearch.GroupSearchFragmentGroupSearchFragment", 2, "start search index=" + this.cyX);
      }
      label189:
      Bundle localBundle;
      List localList;
      if (!UniteSearchActivity.bi(this.source, this.fromType))
      {
        if (this.dCV == 0) {
          this.dCV = 5;
        }
        localBundle = new Bundle();
        localBundle.putInt("matchCount", this.dyI);
        localList = gf();
        if (localObject1 == null) {
          break label450;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use old protocol");
        }
        ((acnm)localObject1).a(this.keyword, this.caF, 20, amxk.c(acnm.ab), localList, this.dCV, this.fp, d1, d2, true, this.fromType, localBundle);
        label277:
        this.dCV = 0;
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("project", amub.zn());
        ((JSONObject)localObject1).put("event_src", "client");
        ((JSONObject)localObject1).put("get_src", "web");
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        amub.a((QQAppInterface)localObject2, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.keyword).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(((JSONObject)localObject1).toString()).session_id(((QQAppInterface)localObject2).getCurrentAccountUin() + amkl.ajN));
        return;
        localObject2 = (acnk)this.d.getBusinessHandler(152);
        localObject1 = null;
        continue;
        if (this.dCV != 0) {
          break label189;
        }
        this.dCV = 5;
        break label189;
        label450:
        if (localObject2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch use new protocol");
          }
          ((acnk)localObject2).a(this.keyword, this.caF, 20, amxk.c(acnk.ab), localList, this.dCV, this.fp, d1, d2, true, this.fromType, localBundle);
          break label277;
        }
        if (!QLog.isColorLevel()) {
          break label277;
        }
        QLog.d("Q.uniteSearch.GroupSearchFragment", 2, "startNetNewSearch error");
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "e = " + localJSONException);
        }
      }
    }
  }
  
  public void destroyEngine()
  {
    if (this.jdField_a_of_type_Amwd != null)
    {
      this.jdField_a_of_type_Amwd.cancel();
      this.jdField_a_of_type_Amwd.destroy();
    }
    this.cDy = false;
  }
  
  public void ie()
  {
    hideLoading();
    this.jdField_a_of_type_Amlt.cS(this.rc);
    this.YL.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.fromType = localBundle.getInt("fromType", -1);
      this.source = localBundle.getInt("source", 0);
      this.ajR = localBundle.getLong("searchEngineKey", 0L);
    }
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.destory();
    }
    anot.a(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", IT(), 0, String.valueOf(this.dCT), "", this.keyword, "");
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.isViewCreated = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_Amlt.notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScroll" + paramInt1);
    if (this.mScrollState == 0) {}
    do
    {
      return;
      if ((getActivity() instanceof UniteSearchActivity)) {
        paramAbsListView = (UniteSearchActivity)getActivity();
      }
    } while ((this.jdField_a_of_type_Amlt == null) || (this.jdField_a_of_type_Amlt.getCount() == 0) || (this.dCU == 0) || (paramInt3 - paramInt1 - paramInt2 >= 10) || (this.cj) || (this.isEnd));
    if (this.fp == null)
    {
      this.dCV = 3;
      if (UniteSearchActivity.bi(this.source, this.fromType)) {
        this.dCV = 3;
      }
      dOm();
      Jp(false);
      this.YM.setVisibility(8);
    }
    for (;;)
    {
      this.Hb.setVisibility(0);
      return;
      dOn();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    QLog.d("Q.uniteSearch.GroupSearchFragment", 4, " onScrollStateChanged" + paramInt);
    if ((getActivity() instanceof UniteSearchActivity)) {
      paramAbsListView = (UniteSearchActivity)getActivity();
    }
    this.mScrollState = paramInt;
    if ((this.jdField_a_of_type_Amlt == null) || (this.jdField_a_of_type_Amlt.getCount() == 0)) {}
    while (this.dCU == 0) {
      return;
    }
    if ((this.mScrollState != 0) && (this.isViewCreated) && (!this.cj) && (!this.isEnd) && ((this.rc == null) || (this.rc.size() < 20)))
    {
      if (this.fp != null) {
        break label196;
      }
      this.dCV = 3;
      if (UniteSearchActivity.bi(this.source, this.fromType)) {
        this.dCV = 3;
      }
      dOm();
      Jp(false);
      this.YM.setVisibility(8);
    }
    for (;;)
    {
      this.Hb.setVisibility(0);
      if (paramInt != 0) {
        break;
      }
      txn.a().stopMonitorScene("list_unite_search", false);
      return;
      label196:
      dOn();
    }
    txn.a().startMonitorScene("list_unite_search");
  }
  
  public void onStart()
  {
    super.onStart();
    ((GroupSearchEngine)this.jdField_a_of_type_Amwd).bHZ();
  }
  
  public void onStop()
  {
    super.onStop();
    ((GroupSearchEngine)this.jdField_a_of_type_Amwd).bIa();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.c = new aqdf(super.getActivity(), super.getActivity().app);
    this.jdField_a_of_type_Amlt = a();
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Amlt);
    showLoading();
    this.YN.setText("");
    ie();
    this.isViewCreated = true;
    if ((getActivity() instanceof UniteSearchActivity))
    {
      ((UniteSearchActivity)getActivity()).p(((UniteSearchActivity)getActivity()).caJ, this.cDA, this.cDB);
      this.cDA = false;
      this.cDB = false;
    }
  }
  
  public void resetData()
  {
    this.dCU = 0;
    this.caF = "";
    this.cj = false;
    this.isEnd = false;
    Pm(false);
    if (this.isViewCreated)
    {
      Jp(false);
      showLoading();
      this.jdField_a_of_type_Amlt.notifyDataSetChanged();
      this.Hb.setVisibility(8);
      this.YM.setVisibility(8);
    }
    this.cyX = 0;
  }
  
  public void s(List paramList, int paramInt)
  {
    if (isDetached()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.uniteSearch.GroupSearchFragment", 2, "onFinish, resultList = " + paramList + ", status = " + paramInt);
    }
    if ((paramInt == 4) || (paramInt == 5)) {}
    for (paramList = B(paramList);; paramList = new ArrayList(paramList))
    {
      paramList = this.mHandler.obtainMessage(14, paramList);
      paramList.arg1 = paramInt;
      this.mHandler.sendMessage(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.GroupSearchFragment
 * JD-Core Version:    0.7.0.1
 */