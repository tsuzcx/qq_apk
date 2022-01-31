package com.tencent.mobileqq.activity.recent;

import android.app.Dialog;
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
import android.widget.TextView;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.IDragViewProvider;
import com.tencent.mobileqq.activity.recent.cur.DragRelativeLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.SwipListView;
import com.tencent.widget.XListView;
import eti;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class RecentAdapter
  extends BaseAdapter
  implements View.OnClickListener, View.OnLongClickListener, DragRelativeLayout.IDragViewProvider, DragRelativeLayout.OnDragModeChangedListener, FaceDecoder.DecodeTaskCompletionListener
{
  protected static final int a = 1;
  public static final int b = 99;
  private long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  protected Context a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new eti(this);
  private OnRecentUserOpsListener jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener = null;
  protected RecentBaseData a;
  protected RecentFaceDecoder a;
  protected RecentItemBuilderFactory a;
  protected DragRelativeLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected BubblePopupWindow a;
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
      } else if (paramInt == 4) {
        this.d = 7;
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
      if ((localObject != null) && (localObject.equals("RECENT_BLANK_VIEW"))) {
        this.jdField_a_of_type_JavaUtilList.remove(localObject);
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
  
  public DragRelativeLayout a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout;
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
        localView = localView.findViewById(2131234178);
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
    if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b();
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
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
          break label354;
          this.jdField_a_of_type_Long = l;
          break;
        }
        int i = ((Integer)RecentFaceDecoder.a(localRecentBaseData.a(), localRecentBaseData.a()).first).intValue();
        if (i == -2147483648) {
          break label354;
        }
        Object localObject = i + ":" + localRecentBaseData.a();
        localObject = (Bitmap)this.jdField_a_of_type_JavaUtilHashtable.get(localObject);
        if (localObject == null) {
          break label354;
        }
        a(paramBitmap, localRecentBaseData, new BitmapDrawable((Bitmap)localObject));
        bool = true;
        break label354;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "decodecomplete|faceCache size = " + this.jdField_a_of_type_JavaUtilHashtable.size() + ", isNeedUpdateAvatar=" + bool);
      }
      this.jdField_a_of_type_JavaUtilHashtable.clear();
      return;
      label354:
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "5", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "6", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "7", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "8", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "9", "", paramString2, "");
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004142", "0X8004142", 0, 0, "10", "", paramString2, "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentOnRecentUserOpsListener.a(paramString1, paramRecentBaseData, paramString2);
  }
  
  public void a(DragRelativeLayout paramDragRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout = paramDragRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.a(this, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragRelativeLayout.setDragViewProvider(this);
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
    } while ((paramBoolean) || ((k != 0) && (k != 1000) && (k != 1020) && (k != 1003) && (k != 1005) && (k != 1004) && (k != 1008) && (k != 1001) && (k != 1009) && (k != 1023) && (k != 1024)));
    a(localView, localRecentBaseData);
  }
  
  public void a(List paramList)
  {
    Object localObject1 = null;
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
    }
    for (localObject2 = localObject3;; localObject2 = null)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a();
      boolean bool;
      label304:
      int j;
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          localObject3 = (RecentBaseData)paramList.next();
          if ((localObject3 != null) && ((((RecentBaseData)localObject3).a() < 7000) || (((RecentBaseData)localObject3).a() > 7200))) {
            this.jdField_a_of_type_JavaUtilList.add(localObject3);
          } else if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "setDataList, [item is null]");
          }
        }
        if (this.jdField_a_of_type_JavaUtilList.size() > 0) {}
        switch (i)
        {
        default: 
          if (localObject2 != null)
          {
            if (this.jdField_a_of_type_JavaUtilList.size() == 0)
            {
              bool = false;
              localObject2.setDragEnable(bool);
            }
          }
          else if ((localObject1 instanceof RecentBaseData))
          {
            paramList = (RecentBaseData)localObject1;
            i = Math.max(localObject2.q(), 0);
            j = Math.min(localObject2.r() + 1, this.jdField_a_of_type_JavaUtilList.size());
          }
          break;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          if (!paramList.equals(this.jdField_a_of_type_JavaUtilList.get(i))) {
            break label483;
          }
          this.c = i;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.recent", 4, "setDataList getsel, [" + i + "," + this.jdField_a_of_type_JavaUtilList.get(i) + "]");
          }
        }
        if ((localObject2 != null) && (this.c == -1)) {
          localObject2.b();
        }
        notifyDataSetChanged();
        return;
        this.jdField_a_of_type_JavaUtilList.add("RECENT_BLANK_VIEW");
        break;
        bool = true;
        break label304;
        label483:
        i += 1;
      }
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
  
  public void a(boolean paramBoolean, int paramInt, DragRelativeLayout paramDragRelativeLayout)
  {
    if (paramBoolean)
    {
      if (paramInt != 2) {
        break label282;
      }
      paramDragRelativeLayout = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
      if (paramDragRelativeLayout != null) {
        paramDragRelativeLayout.j();
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        if (((localObject2 instanceof RecentBaseData)) && ((localObject2 instanceof RecentUserBaseData)))
        {
          Object localObject1 = (RecentUserBaseData)localObject2;
          if (((RecentUserBaseData)localObject1).A > 0)
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
                if (paramDragRelativeLayout == null) {}
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
              if (paramDragRelativeLayout == null) {}
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
                paramDragRelativeLayout = paramDragRelativeLayout.a();
              } while (paramDragRelativeLayout == null);
              paramDragRelativeLayout = (Integer)paramDragRelativeLayout.getTag();
            } while (paramDragRelativeLayout == null);
            paramDragRelativeLayout = getItem(paramDragRelativeLayout.intValue());
            if (QLog.isColorLevel()) {
              QLog.d("Drag", 2, "onChange:" + paramDragRelativeLayout);
            }
          } while (!(paramDragRelativeLayout instanceof RecentBaseData));
          if (!(paramDragRelativeLayout instanceof RecentUserBaseData)) {
            break;
          }
          paramDragRelativeLayout = (RecentUserBaseData)paramDragRelativeLayout;
          paramDragRelativeLayout.c();
          paramDragRelativeLayout = paramDragRelativeLayout.a();
          RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout, true);
        } while (this.e != 0);
        RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout);
        return;
      } while (!(paramDragRelativeLayout instanceof RecentTroopAssistantItem));
      paramDragRelativeLayout = (RecentTroopAssistantItem)paramDragRelativeLayout;
      paramDragRelativeLayout.c();
      RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout.a(), paramDragRelativeLayout.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramDragRelativeLayout.a(), paramDragRelativeLayout.a());
      paramDragRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDragRelativeLayout.a(), 1);
    } while (paramDragRelativeLayout == null);
    TroopAssistantManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDragRelativeLayout.time);
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
    return (c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0);
  }
  
  protected boolean c()
  {
    return (this.d == 3) || (this.d == 8);
  }
  
  public int getCount()
  {
    if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    try
    {
      if ((c()) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
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
    Object localObject2 = getItem(paramInt);
    RecentItemBaseBuilder localRecentItemBaseBuilder = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(localObject2);
    Object localObject1;
    if (localRecentItemBaseBuilder != null) {
      if ((localObject2 instanceof RecentBaseData))
      {
        localObject1 = (RecentBaseData)localObject2;
        localObject1 = localRecentItemBaseBuilder.a(paramInt, localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentFaceDecoder.a(((RecentBaseData)localObject1).a(), ((RecentBaseData)localObject1).a()), paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      }
    }
    for (;;)
    {
      if ((localRecentItemBaseBuilder == null) || (localObject1 == null))
      {
        paramView = "[" + this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a() + "," + paramInt + "," + localRecentItemBaseBuilder + "," + localObject2 + "," + this.jdField_a_of_type_JavaUtilList.size() + "]";
        StatisticCollector.a(BaseApplication.getContext()).a("Q.recent", paramView);
      }
      return localObject1;
      if ((localObject2 instanceof Integer))
      {
        localObject1 = localRecentItemBaseBuilder.a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, this, this, this);
      }
      else
      {
        localObject1 = paramView;
        if ((localObject2 instanceof String))
        {
          localObject1 = localRecentItemBaseBuilder.a(paramInt, localObject2, null, paramView, paramViewGroup, this.jdField_a_of_type_AndroidContentContext, null, null, null);
          continue;
          localObject1 = paramView;
          if (QLog.isDevelopLevel())
          {
            QLog.i("Q.recent", 4, "builder is null|[" + paramInt + "," + localObject2 + "]");
            localObject1 = paramView;
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.b();
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    if (paramView == null) {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "RecentAdpater onClick v is null");
      }
    }
    label361:
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
          break label361;
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
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory != null) {}
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentItemBuilderFactory.a(); ((i == 0) || (i == 4)) && (Conversation.d()); i = 0) {
      return false;
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
      if ((localObject2 instanceof QZoneShareAlbumDefaultItemBuilder))
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick QZoneAlbum");
        }
        return false;
      }
      if (((RecentBaseData)localObject1).a() == 1)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(((RecentBaseData)localObject1).a());
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "right", 0, 0, ((RecentBaseData)localObject1).a(), String.valueOf(i - 1), "", "");
      }
      if (localObject2 != null) {}
      for (localObject1 = ((RecentItemBaseBuilder)localObject2).a((RecentBaseData)localObject1, this.jdField_a_of_type_AndroidContentContext);; localObject1 = null)
      {
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = new QQCustomMenu();
          i = 0;
          while (i < ((List)localObject1).size())
          {
            ((QQCustomMenu)localObject2).a(j, (String)((List)localObject1).get(i));
            i += 1;
          }
          localObject1 = (TextView)paramView.findViewById(16908308);
          if (((TextView)localObject1).getText() != null) {}
          for (localObject1 = ((TextView)localObject1).getText().toString();; localObject1 = null)
          {
            this.jdField_a_of_type_AndroidAppDialog = BubbleContextMenu.a(paramView, (QQCustomMenu)localObject2, this.jdField_a_of_type_AndroidViewView$OnClickListener, (CharSequence)localObject1);
            return true;
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("Q.recent", 4, "RecentAdpater onLongClick no menu, builder = " + localObject2);
        }
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter
 * JD-Core Version:    0.7.0.1
 */