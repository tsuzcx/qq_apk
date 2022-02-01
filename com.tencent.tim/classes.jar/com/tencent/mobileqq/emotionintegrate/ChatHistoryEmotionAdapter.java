package com.tencent.mobileqq.emotionintegrate;

import acfp;
import afrj;
import afrm;
import afrn;
import afrp;
import afrp.a;
import afrq;
import aixi;
import akxb;
import akxj;
import akxl;
import akxq;
import anaz;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import aoiz;
import aojj;
import aooi;
import aoop;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;
import wja;
import xud;

public class ChatHistoryEmotionAdapter
  extends BaseAdapter
  implements afrp.a, URLDrawableDownListener
{
  public static final Object bR = new Object();
  public static final Object bS = new Object();
  public static final Object bT = new Object();
  private List<MessageRecord> At;
  private afrn a;
  public boolean aTT;
  private int aVz;
  private String aWl;
  private xud b = new xud();
  int bWV = -1;
  private boolean bjo = true;
  private boolean bjp;
  private int bvC = -1;
  private GridView e;
  private HashMap<MessageForPic, afrp> kv = new HashMap();
  private Calendar l;
  public int mColumnCount = 4;
  private Context mContext;
  private int mCurType = -1;
  private Handler mHandler;
  private int mImageWidth;
  private LayoutInflater mInflater;
  public List<Object> sm = new ArrayList();
  
  public ChatHistoryEmotionAdapter(Activity paramActivity, afrn paramafrn, Handler paramHandler, int paramInt, GridView paramGridView)
  {
    this.mContext = paramActivity;
    this.a = paramafrn;
    this.mHandler = paramHandler;
    this.mImageWidth = paramInt;
    this.e = paramGridView;
    this.mInflater = paramActivity.getLayoutInflater();
    this.aVz = wja.dp2px(40.0F, this.mContext.getResources());
  }
  
  private aojj a(MessageForPic paramMessageForPic)
  {
    boolean bool = true;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      akxl localakxl = new akxl();
      localakxl.fileSizeFlag = paramMessageForPic.fileSizeFlag;
      if (localakxl.fileSizeFlag == 1) {}
      for (;;)
      {
        int i = aoop.n("aiothumb", bool);
        paramMessageForPic = ((QQAppInterface)localAppRuntime).a().a(aooi.o(paramMessageForPic.md5, paramMessageForPic.uuid, i));
        if ((paramMessageForPic == null) || (!(paramMessageForPic instanceof aojj))) {
          break;
        }
        return (aojj)paramMessageForPic;
        bool = false;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, View paramView, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    }
    String str;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (paramView == null);
          r(paramInt1, paramView);
          return;
        } while (!b.class.isInstance(paramObject));
        paramObject = (b)paramObject;
      } while (paramObject == null);
      str = (String)getItem(paramInt1);
      paramObject.mTextView.setText(str);
      if (AppSetting.enableTalkBack)
      {
        paramInt1 /= 4;
        paramObject.mTextView.setContentDescription(acfp.m(2131703669) + (paramInt1 + 1) + acfp.m(2131703621) + str);
      }
    } while (!Pl());
    ViewGroup localViewGroup = (ViewGroup)paramObject.mCheckBox.getParent();
    if (localViewGroup != null) {
      localViewGroup.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839637));
    }
    paramObject.mCheckBox.setVisibility(0);
    paramObject.mCheckBox.setChecked(this.b.hS(str));
    paramObject.mCheckBox.setClickable(false);
    paramView.setOnClickListener(new afrj(this, str));
  }
  
  public boolean Pl()
  {
    return (this.bjp) && (this.bvC != -1);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(1000L * paramLong);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic) {}
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    this.kv.remove(paramMessageForPic);
    notifyDataSetChanged();
  }
  
  public boolean ay(boolean paramBoolean)
  {
    if (paramBoolean != this.bjo)
    {
      this.bjo = paramBoolean;
      return true;
    }
    return false;
  }
  
  public List<MessageRecord> eO()
  {
    return this.At;
  }
  
  public void expandAll()
  {
    if (this.b.f(this.sm, this.mColumnCount)) {
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    int i = this.sm.size();
    int j = i;
    if (this.bjo)
    {
      int k = i % 4;
      j = i;
      if (k > 0) {
        j = i + (4 - k);
      }
      j += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.bjo) {
      return this.sm.get(paramInt);
    }
    if (paramInt < this.sm.size()) {
      return this.sm.get(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return bT;
    }
    return bS;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof MessageRecord)) {}
    do
    {
      return 0;
      if (bS.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (bR.equals(localObject)) {
        return 3;
      }
    } while (!bT.equals(localObject));
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = null;
      switch (i)
      {
      default: 
        localObject2 = localObject1;
        localObject1 = paramView;
        paramView = (View)localObject2;
      }
    }
    for (;;)
    {
      a(paramInt, (View)localObject1, i, paramView);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView.getTag();
      break;
      if (a.class.isInstance(localObject1))
      {
        localObject2 = paramView;
        paramView = (View)localObject1;
        localObject1 = localObject2;
      }
      else
      {
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("ChatHistoryEmotionAdapter", 2, "[getView] type 0 while convertView type " + paramView.viewType);
        }
        localObject2 = this.mInflater.inflate(2131559279, null);
        ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.mImageWidth, this.mImageWidth));
        paramView = new a();
        paramView.av = ((URLImageView)((View)localObject2).findViewById(2131373182));
        paramView.av.setAdjustViewBounds(false);
        paramView.tO = ((ImageView)((View)localObject2).findViewById(2131373186));
        paramView.mSelectedIconView = ((ImageView)((View)localObject2).findViewById(2131373187));
        ((View)localObject2).setTag(paramView);
        paramView = (View)localObject1;
        localObject1 = localObject2;
        continue;
        if (bS.equals(localObject1))
        {
          localObject2 = paramView;
          paramView = (View)localObject1;
          localObject1 = localObject2;
        }
        else
        {
          localObject2 = new View(this.mContext);
          ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(this.mImageWidth, this.mImageWidth));
          ((View)localObject2).setTag(bS);
          paramView = (View)localObject1;
          localObject1 = localObject2;
          continue;
          if (b.class.isInstance(localObject1))
          {
            localObject2 = paramView;
            paramView = (View)localObject1;
            localObject1 = localObject2;
          }
          else
          {
            localObject2 = this.mInflater.inflate(2131561537, null);
            paramView = new b();
            paramView.mTextView = ((TextView)((View)localObject2).findViewById(2131379567));
            paramView.mCheckBox = ((CheckBox)((View)localObject2).findViewById(2131369742));
            localObject1 = new FullWidthFixedViewLayout(this.mContext);
            Object localObject3 = ((View)localObject2).getLayoutParams();
            if (localObject3 != null)
            {
              ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
              ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
            }
            ((FrameLayout)localObject1).addView((View)localObject2);
            ((View)localObject1).setTag(paramView);
            continue;
            if (bR.equals(localObject1))
            {
              localObject2 = paramView;
              paramView = (View)localObject1;
              localObject1 = localObject2;
            }
            else
            {
              localObject2 = new View(this.mContext);
              ((View)localObject2).setMinimumHeight(this.aVz);
              ((View)localObject2).setVisibility(4);
              ((View)localObject2).setTag(bR);
              paramView = (View)localObject1;
              localObject1 = localObject2;
              continue;
              if (bT.equals(localObject1))
              {
                localObject2 = paramView;
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
              else
              {
                localObject2 = new FullWidthFixedViewLayout(this.mContext);
                paramView = this.mInflater.inflate(2131561536, null);
                localObject3 = new FrameLayout.LayoutParams(-2, -2);
                ((FrameLayout.LayoutParams)localObject3).gravity = 17;
                paramView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
                ((FullWidthFixedViewLayout)localObject2).addView(paramView);
                ((View)localObject2).setTag(bT);
                paramView = (View)localObject1;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public Object j(int paramInt)
  {
    return this.sm.get(paramInt);
  }
  
  public void kx(List<MessageRecord> paramList)
  {
    this.At.addAll(paramList);
    x(false, paramList);
    ay(false);
    notifyDataSetChanged();
  }
  
  public void ky(List<MessageRecord> paramList)
  {
    this.At = paramList;
    x(true, this.At);
    ay(false);
    notifyDataSetChanged();
  }
  
  public void l(MessageForPic paramMessageForPic)
  {
    afrp localafrp = new afrp(paramMessageForPic, this.mHandler, this);
    if (!this.kv.containsKey(paramMessageForPic)) {
      this.kv.put(paramMessageForPic, localafrp);
    }
    Object localObject = a(paramMessageForPic);
    if (localObject != null) {
      ((aojj)localObject).b(localafrp);
    }
    do
    {
      return;
      localObject = akxj.a(5, 1536, 1);
      ((akxq)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
      ((akxq)localObject).b(localafrp);
      paramMessageForPic = BaseApplicationImpl.getApplication().getRuntime();
    } while ((paramMessageForPic == null) || (!(paramMessageForPic instanceof QQAppInterface)));
    akxj.a((akxq)localObject, (QQAppInterface)paramMessageForPic);
  }
  
  public void onDestory()
  {
    if (!this.kv.isEmpty())
    {
      Iterator localIterator = this.kv.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        aojj localaojj = a((MessageForPic)localEntry.getKey());
        if (localaojj != null) {
          localaojj.a((akxb)localEntry.getValue());
        }
      }
    }
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    try
    {
      File localFile = paramURLDrawable.getFileInLocal();
      if (localFile == null) {
        break label64;
      }
      i = aqhu.fh(localFile.getAbsolutePath());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        label64:
        int i = 0;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionAdapter", 2, new Object[] { "onLoadSuccessed,orientation:", Integer.valueOf(i) });
    }
    AIOGalleryAdapter.updateRotation(paramView, paramURLDrawable, i);
  }
  
  public void r(int paramInt, View paramView)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1 = paramView.getTag();
    if (!afrq.class.isInstance(localObject2))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not AIORichMediaInfo, position:" + paramInt);
      return;
    }
    if (!(localObject1 instanceof a))
    {
      QLog.d("ChatHistoryEmotionAdapter", 2, "[updateView] is not ContentHolder, position:" + paramInt);
      return;
    }
    localObject1 = (a)localObject1;
    localObject2 = (afrq)localObject2;
    Object localObject3 = ((a)localObject1).av;
    Object localObject4 = this.a;
    localObject4 = afrn.a(this.mContext, (afrq)localObject2);
    if (((afrq)localObject2).cax)
    {
      if (((afrq)localObject2).cay) {
        ((URLImageView)localObject3).setURLDrawableDownListener(this);
      }
    }
    else
    {
      if ((!(localObject4 instanceof aixi)) || (((aixi)localObject4).getBitmap() == null)) {
        break label341;
      }
      ((URLImageView)localObject3).setImageBitmap(afrm.k(((aixi)localObject4).getBitmap(), this.mImageWidth, this.mImageWidth));
      label191:
      localObject3 = ((a)localObject1).tO;
      localObject1 = ((a)localObject1).mSelectedIconView;
      if (!this.aTT) {
        break label374;
      }
      if (!((afrq)localObject2).isSelected) {
        break label351;
      }
      ((ImageView)localObject3).setVisibility(0);
      ((ImageView)localObject1).setImageResource(2130846610);
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      int i = paramInt / 4;
      paramView.setContentDescription(acfp.m(2131703627) + (i + 1) + acfp.m(2131703687) + (paramInt % 4 + 1) + acfp.m(2131703668));
      return;
      if (aoiz.getFile(aoop.a((MessageForPic)((afrq)localObject2).h, 65537).toString()) != null) {
        break;
      }
      l((MessageForPic)((afrq)localObject2).h);
      break;
      label341:
      ((URLImageView)localObject3).setImageDrawable((Drawable)localObject4);
      break label191;
      label351:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setImageResource(2130846607);
      ((ImageView)localObject1).setVisibility(0);
      continue;
      label374:
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setVisibility(4);
    }
  }
  
  public void setCurType(int paramInt)
  {
    this.mCurType = paramInt;
    this.bvC = AIOPhotoListAdapter.fl(this.mCurType);
  }
  
  public int wu()
  {
    return this.sm.size();
  }
  
  public int wv()
  {
    return wu() + this.b.wx();
  }
  
  public void x(boolean paramBoolean, List<MessageRecord> paramList)
  {
    boolean bool = false;
    if (this.mColumnCount == 0) {
      return;
    }
    int i;
    if (paramBoolean)
    {
      this.sm.clear();
      this.bWV = -1;
      this.aWl = null;
      if (this.l == null)
      {
        this.l = Calendar.getInstance();
        this.l.setTimeInMillis(anaz.gQ() * 1000L);
      }
      i = paramList.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label292;
      }
      Object localObject2 = (MessageRecord)paramList.get(i);
      localObject1 = new afrq((MessageRecord)localObject2);
      localObject2 = a(this.l, ((MessageRecord)localObject2).time);
      if (!((String)localObject2).equals(this.aWl))
      {
        this.aWl = ((String)localObject2);
        if (this.bWV != -1)
        {
          int k = this.bWV % this.mColumnCount;
          if (k > 0)
          {
            j = 0;
            for (;;)
            {
              if (j < this.mColumnCount - k)
              {
                this.sm.add(bS);
                j += 1;
                continue;
                this.b.J(this.sm, this.mColumnCount);
                break;
              }
            }
          }
        }
        this.bWV = 0;
        this.sm.add(localObject2);
        int j = 0;
        while (j < this.mColumnCount - 1)
        {
          this.sm.add(bR);
          j += 1;
        }
      }
      this.sm.add(localObject1);
      this.bWV += 1;
      i -= 1;
    }
    label292:
    Object localObject1 = this.b;
    if (!paramBoolean)
    {
      paramBoolean = bool;
      if (!paramList.isEmpty()) {}
    }
    else
    {
      paramBoolean = true;
    }
    ((xud)localObject1).e(paramBoolean, this.mColumnCount, this.sm);
  }
  
  public void zB(boolean paramBoolean)
  {
    this.bjp = paramBoolean;
  }
  
  class FullWidthFixedViewLayout
    extends FrameLayout
  {
    public FullWidthFixedViewLayout(Context paramContext)
    {
      super();
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = ChatHistoryEmotionAdapter.a(ChatHistoryEmotionAdapter.this).getPaddingLeft() + getPaddingLeft();
      if (i != paramInt1) {
        offsetLeftAndRight(i - paramInt1);
      }
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(ChatHistoryEmotionAdapter.a(ChatHistoryEmotionAdapter.this).getMeasuredWidth() - ChatHistoryEmotionAdapter.a(ChatHistoryEmotionAdapter.this).getPaddingLeft() - ChatHistoryEmotionAdapter.a(ChatHistoryEmotionAdapter.this).getPaddingRight(), View.MeasureSpec.getMode(paramInt1)), paramInt2);
    }
  }
  
  public class a
  {
    public URLImageView av;
    public ImageView mSelectedIconView;
    public ImageView tO;
    
    public a() {}
  }
  
  public class b
  {
    CheckBox mCheckBox;
    TextView mTextView;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */