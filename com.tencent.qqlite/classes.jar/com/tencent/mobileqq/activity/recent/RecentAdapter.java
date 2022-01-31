package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import ckk;
import ckl;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentMsgBoxItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MenuPopupDialog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class RecentAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, DragFrameLayout.IDragViewProvider, DragFrameLayout.OnDragModeChangedListener, FaceDecoder.DecodeTaskCompletionListener
{
  protected static final int a = 1;
  public static final int b = 99;
  private long jdField_a_of_type_Long = 0L;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ckl(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  protected RecentBaseData a;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MenuPopupDialog jdField_a_of_type_ComTencentWidgetMenuPopupDialog;
  protected XListView a;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  protected List a;
  public int c = -1;
  private int d;
  private int e;
  
  public RecentAdapter(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, OnRecentUserOpsListener paramOnRecentUserOpsListener, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = paramOnRecentUserOpsListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(99);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory = new RecentItemBuilderFactory(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder = new RecentFaceDecoder(paramQQAppInterface, this);
    if (paramInt == 0) {
      this.d = 0;
    }
    for (;;)
    {
      this.e = paramInt;
      return;
      if (paramInt == 1) {
        this.d = 5;
      } else if (paramInt == 3) {
        this.d = 10;
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 1))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList.get(0);
      if (localObject != null)
      {
        if (localObject.equals("RECENT_BLANK_VIEW")) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
        if (localObject.equals(RecentItemBuilderFactory.a)) {
          this.jdField_a_of_type_JavaUtilList.remove(localObject);
        }
      }
    }
  }
  
  public RecentBaseData a(View paramView)
  {
    if ((paramView != null) && ((paramView.getTag(-1) instanceof Integer)))
    {
      paramView = getItem(((Integer)paramView.getTag(-1)).intValue());
      if ((paramView instanceof RecentBaseData)) {
        return (RecentBaseData)paramView;
      }
    }
    return null;
  }
  
  public DragFrameLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      if (localView != null)
      {
        localView = localView.findViewById(2131298717);
        if ((localView != null) && ((localView instanceof DragTextView)))
        {
          DragTextView localDragTextView = (DragTextView)localView;
          if ((localView.getVisibility() == 0) && (localDragTextView.a() != -1)) {
            localArrayList.add(localView);
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null)
    {
      this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.dismiss();
      this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = null;
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String arg3, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(???))) {}
    long l;
    for (;;)
    {
      return;
      if ((paramBitmap != null) || (paramInt1 <= 0))
      {
        if (paramBitmap != null) {
          this.jdField_a_of_type_JavaUtilHashtable.put(paramInt2 + ":" + ???, paramBitmap);
        }
        l = System.currentTimeMillis();
        if ((this.jdField_a_of_type_Long > 0L) && (l - this.jdField_a_of_type_Long > 300L)) {}
        for (paramInt2 = 1; (paramInt1 <= 0) || (paramInt2 != 0); paramInt2 = 0) {
          synchronized (this.jdField_a_of_type_JavaUtilHashtable)
          {
            if (this.jdField_a_of_type_JavaUtilHashtable.size() != 0) {
              break label132;
            }
            return;
          }
        }
      }
    }
    label132:
    boolean bool;
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Long = 0L;
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      bool = false;
    }
    for (;;)
    {
      if (paramInt1 < paramInt2)
      {
        paramBitmap = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        RecentBaseData localRecentBaseData = a(paramBitmap);
        if (localRecentBaseData == null)
        {
          break label364;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int i = ((Integer)RecentFaceDecoder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localRecentBaseData.a(), localRecentBaseData.a()).first).intValue();
        if (i == -2147483648) {
          break label364;
        }
        Object localObject = i + ":" + localRecentBaseData.a();
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (localObject == null) {
          break label364;
        }
        a(paramBitmap, localRecentBaseData, new BitmapDrawable(BaseApplication.getContext().getResources(), (Bitmap)localObject));
        bool = true;
        break label364;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label364:
      paramInt1 += 1;
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData)
  {
    a(paramView, paramRecentBaseData, null);
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null)) {}
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = paramDrawable;
      if (paramDrawable == null) {
        localDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramRecentBaseData.a(), paramRecentBaseData.a());
      }
      paramDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(paramRecentBaseData);
    } while (paramDrawable == null);
    paramDrawable.a(paramView, paramRecentBaseData, this.jdField_a_of_type_AndroidContentContext, localDrawable);
  }
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (paramRecentBaseData == null)) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label22:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if (localRecentBaseData != null) {
        break label57;
      }
    }
    label57:
    while (!localRecentBaseData.equals(paramRecentBaseData))
    {
      i += 1;
      break label22;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString1, String paramString2)
  {
    a();
    if (Utils.a(paramString1, this.jdField_a_of_type_AndroidContentContext.getResources().getString(RecentItemBaseBuilder.a[0])))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramRecentBaseData);
      }
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramRecentBaseData);
        c();
        notifyDataSetChanged();
      }
      switch (paramRecentBaseData.a())
      {
      default: 
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "999", paramString2, "", "");
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null)
    {
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "0", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "1", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "2", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "3", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "4", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramString1, paramRecentBaseData, paramString2);
  }
  
  public void a(DragFrameLayout paramDragFrameLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.setDragViewProvider(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(paramQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      a(null);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (localRecentBaseData.a() == paramInt)) {
        break label71;
      }
    }
    label71:
    while (!Utils.a(localRecentBaseData.a(), paramString))
    {
      i += 1;
      break label26;
      break;
    }
    a(localView, localRecentBaseData);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 1;
    label26:
    View localView;
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
      localRecentBaseData = a(localView);
      if ((localRecentBaseData != null) && (Utils.a(paramString, localRecentBaseData.a()))) {
        break label74;
      }
    }
    label74:
    int k;
    do
    {
      i += 1;
      break label26;
      break;
      k = localRecentBaseData.a();
      if ((paramBoolean) && (k == 1))
      {
        a(localView, localRecentBaseData);
        return;
      }
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1025) && (k != 1005) && (k != 1004) && (k != 1001) && (k != 1009) && (k != 1023) && (k != 1024)));
    a(localView, localRecentBaseData);
  }
  
  public void a(List paramList)
  {
    Object localObject2 = null;
    a();
    Object localObject3;
    if ((this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView))
    {
      localObject3 = (SwipListView)this.jdField_a_of_type_ComTencentWidgetXListView;
      localObject1 = localObject2;
      if (this.c >= 0)
      {
        localObject1 = localObject2;
        if (this.c < this.jdField_a_of_type_JavaUtilList.size()) {
          localObject1 = this.jdField_a_of_type_JavaUtilList.get(this.c);
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "setDataList findsel, [" + this.c + "," + localObject1 + "]");
      }
      this.c = -1;
      localObject2 = localObject1;
    }
    for (Object localObject1 = localObject3;; localObject1 = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a();
      int j;
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject3 = (RecentBaseData)paramList.next();
          if (localObject3 != null)
          {
            if ((RecentUserBaseData.class.isInstance(localObject3)) && (((RecentUserBaseData)localObject3).a() == 1024)) {}
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          }
          else if (QLog.isColorLevel())
          {
            QLog.i("Q.recent", 2, "setDataList, [item is null]");
          }
        }
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
        switch (i)
        {
        default: 
          if ((localObject2 instanceof RecentBaseData))
          {
            paramList = (RecentBaseData)localObject2;
            i = Math.max(localObject1.q(), 0);
            j = Math.min(localObject1.r() + 1, this.jdField_a_of_type_JavaUtilList.size());
          }
          break;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          if (!paramList.equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
            break label428;
          }
          this.c = i;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "setDataList getsel, [" + i + "," + this.jdField_a_of_type_JavaUtilList.get(i) + "]");
          }
        }
        notifyDataSetChanged();
        return;
        this.jdField_a_of_type_JavaUtilList.add("RECENT_BLANK_VIEW");
        break;
        label428:
        i += 1;
      }
      localObject2 = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.c();
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a.b();
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    int i = 0;
    label76:
    RecentBaseData localRecentBaseData;
    if (i < j)
    {
      localRecentBaseData = a(this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i));
      if (localRecentBaseData != null) {
        break label107;
      }
    }
    for (;;)
    {
      i += 1;
      break label76;
      break;
      label107:
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(localRecentBaseData.a(), localRecentBaseData.a(), false);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if (paramBoolean)
    {
      if (paramInt != 2) {
        break label282;
      }
      paramDragFrameLayout = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
      if (paramDragFrameLayout != null) {
        paramDragFrameLayout.k();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (((localObject2 instanceof RecentBaseData)) && ((localObject2 instanceof RecentUserBaseData)))
        {
          Object localObject1 = (RecentUserBaseData)localObject2;
          if (((RecentUserBaseData)localObject1).v > 0)
          {
            ((RecentUserBaseData)localObject1).c();
            localObject1 = ((RecentUserBaseData)localObject1).a();
            if ((localObject2 instanceof RecentItemTroopMsgData))
            {
              paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentUser)localObject1).uin);
              if ((paramInt == 2) || (paramInt == 4))
              {
                RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (RecentUser)localObject1, true);
              }
              else
              {
                localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                if (paramDragFrameLayout == null) {}
                for (paramBoolean = true;; paramBoolean = false)
                {
                  RecentUtil.a((QQAppInterface)localObject2, (RecentUser)localObject1, paramBoolean);
                  break;
                }
              }
            }
            else
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramDragFrameLayout == null) {}
              for (paramBoolean = true;; paramBoolean = false)
              {
                RecentUtil.a((QQAppInterface)localObject2, (RecentUser)localObject1, paramBoolean);
                break;
              }
            }
          }
        }
      }
      if (this.e == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800419D", "0X800419D", 0, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      }
    }
    label282:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramDragFrameLayout = paramDragFrameLayout.a();
              } while (paramDragFrameLayout == null);
              paramDragFrameLayout = (Integer)paramDragFrameLayout.getTag();
            } while (paramDragFrameLayout == null);
            paramDragFrameLayout = getItem(paramDragFrameLayout.intValue());
            if (QLog.isColorLevel()) {
              QLog.d("Drag", 2, "onChange:" + paramDragFrameLayout);
            }
          } while (!(paramDragFrameLayout instanceof RecentBaseData));
          if (!(paramDragFrameLayout instanceof RecentUserBaseData)) {
            break;
          }
          paramDragFrameLayout = (RecentUserBaseData)paramDragFrameLayout;
          paramDragFrameLayout.c();
          paramDragFrameLayout = paramDragFrameLayout.a();
          RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout, true);
        } while (this.e != 0);
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout);
        return;
        if (!(paramDragFrameLayout instanceof RecentTroopAssistantItem)) {
          break;
        }
        paramDragFrameLayout = (RecentTroopAssistantItem)paramDragFrameLayout;
        paramDragFrameLayout.c();
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
        paramDragFrameLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragFrameLayout.a(), 1);
      } while (paramDragFrameLayout == null);
      TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.time);
      return;
    } while (!(paramDragFrameLayout instanceof RecentMsgBoxItem));
    paramDragFrameLayout = (RecentMsgBoxItem)paramDragFrameLayout;
    paramDragFrameLayout.c();
    RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragFrameLayout.a(), paramDragFrameLayout.a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragFrameLayout.a(), paramDragFrameLayout.a());
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentWidgetXListView instanceof SwipListView);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilList.size() == 0;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        return Integer.valueOf(this.d);
      }
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        Object localObject = this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, localException.toString());
      }
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = getItem(paramInt);
    RecentItemBaseBuilder localRecentItemBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject);
    if ((localObject instanceof RecentBaseData))
    {
      localObject = (RecentBaseData)localObject;
      return localRecentItemBaseBuilder.a(paramInt, localObject, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(((RecentBaseData)localObject).a(), ((RecentBaseData)localObject).a()), paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    if ((localObject instanceof Integer)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    if ((localObject instanceof String)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
    }
    if ((localObject instanceof Long)) {
      return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
    }
    return localRecentItemBaseBuilder.a(paramInt, localObject, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.b();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    label351:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (Utils.a("tag_recent_item_menu_item", paramView.getTag()))
          {
            localObject = paramView.getTag(-1);
            paramView = paramView.getTag(-2);
            if ((!(localObject instanceof Integer)) || (!(paramView instanceof Integer)))
            {
              if (!QLog.isDevelopLevel()) {
                continue;
              }
              QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
              return;
            }
            int i = ((Integer)localObject).intValue();
            int j = ((Integer)paramView).intValue();
            try
            {
              paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getString(j);
              localObject = getItem(i);
              if (QLog.isDevelopLevel()) {
                QLog.i("Q.recent", 4, "onClick|obj = " + localObject + ", " + paramView);
              }
              if ((paramView != null) && ((localObject instanceof RecentBaseData)))
              {
                if (this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog != null) {
                  this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog.dismiss();
                }
                a((RecentBaseData)localObject, paramView, "2");
                return;
              }
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                if (QLog.isDevelopLevel()) {
                  QLog.i("Q.recent", 4, paramView.toString());
                }
                paramView = null;
              }
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener == null) {
          break label351;
        }
        localObject = paramView.getTag(-1);
        if ((localObject instanceof Integer)) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.recent", 4, "RecentAdpater onClick tag is not int");
      return;
      Object localObject = getItem(((Integer)localObject).intValue());
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onClick|obj = " + localObject);
      }
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, (RecentBaseData)localObject, ((RecentBaseData)localObject).a, true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramView, localObject);
      return;
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "onClick|mRecentLis is null");
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a();
    }
    if (paramView == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick v is null");
      }
      return false;
    }
    Object localObject1 = paramView.getTag(-1);
    if (!(localObject1 instanceof Integer))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onLongClick tag is not int");
      }
      return false;
    }
    int j = ((Integer)localObject1).intValue();
    localObject1 = getItem(j);
    if ((localObject1 instanceof RecentBaseData)) {}
    for (localObject1 = (RecentBaseData)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick item is null, pos = " + j);
        }
        return false;
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject1);
      int i;
      if (((RecentBaseData)localObject1).a() == 1)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentBaseData)localObject1).a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).a(), String.valueOf(i - 1), "", "");
      }
      paramView.setSelected(true);
      if (localObject2 != null) {}
      for (List localList = ((RecentItemBaseBuilder)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localList = null)
      {
        if ((localList != null) && (localList.size() > 0))
        {
          localObject2 = new QQCustomMenu();
          i = 0;
          while (i < localList.size())
          {
            ((QQCustomMenu)localObject2).a(j, (String)localList.get(i));
            i += 1;
          }
          this.jdField_a_of_type_ComTencentWidgetMenuPopupDialog = MenuPopupDialog.a(paramView, ((RecentBaseData)localObject1).a, (QQCustomMenu)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, new ckk(this, paramView));
          return true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter
 * JD-Core Version:    0.7.0.1
 */