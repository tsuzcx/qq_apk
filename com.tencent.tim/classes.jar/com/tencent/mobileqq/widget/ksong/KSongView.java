package com.tencent.mobileqq.widget.ksong;

import aagd;
import aiwm;
import aiwn;
import aiwp;
import aiwv;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import arkm.a;
import arkm.c;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import cooperation.qwallet.plugin.QwAdapter.IViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class KSongView
  extends FrameLayout
{
  private arkm.a jdField_a_of_type_Arkm$a = new arkm.a();
  private KSongTextView jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
  private b jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b;
  private QwAdapter jdField_a_of_type_CooperationQwalletPluginQwAdapter;
  private long awa;
  private arkm.c jdField_b_of_type_Arkm$c;
  private KSongProsBar jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongProsBar;
  private KSongTextView jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
  private int ejX;
  private List<aiwp> list;
  private int mState = -1;
  public long startTime;
  private long uS;
  private ListView x;
  
  public KSongView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(int paramInt, long paramLong)
  {
    Object localObject = (aiwp)this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.getItem(paramInt);
    if ((localObject == null) || (((aiwp)localObject).xv.size() <= 0))
    {
      QLog.i("KSongView", 2, "error, sentence = " + localObject);
      return 0.0F;
    }
    if (paramLong >= ((aiwp)localObject).mStartTime + ((aiwp)localObject).mDuration)
    {
      QLog.i("KSongView", 2, "over the sentence...");
      return 1.0F;
    }
    aiwm localaiwm = null;
    paramInt = 0;
    for (;;)
    {
      if (paramInt < ((aiwp)localObject).xv.size())
      {
        localaiwm = (aiwm)((aiwp)localObject).xv.get(paramInt);
        if (paramLong >= localaiwm.mStartTime + localaiwm.mDuration) {}
      }
      else
      {
        if (localaiwm != null) {
          break;
        }
        QLog.i("KSongView", 2, "error, charaxter is null...");
        return 0.0F;
      }
      paramInt += 1;
    }
    localObject = (aiwm)((aiwp)localObject).xv.get(((aiwp)localObject).xv.size() - 1);
    float f = (float)(paramLong - localaiwm.mStartTime) / (float)localaiwm.mDuration;
    return (localaiwm.mStart + f) / ((aiwm)localObject).mEnd;
  }
  
  private arkm.a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.i("KSongView", 2, "error! config path wrong...");
    }
    arkm.a locala;
    do
    {
      return null;
      try
      {
        paramString = aagd.readFile(paramString);
        QLog.i("KSongView", 2, "config_content = " + paramString);
        if (TextUtils.isEmpty(paramString))
        {
          QLog.i("KSongView", 2, "error! config content wrong...");
          return null;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = new JSONObject(paramString);
      locala = new arkm.a();
      locala.singer = paramString.optString("name");
      locala.singer = paramString.optString("singer");
      locala.time = paramString.optLong("time");
      locala.cAG = paramString.optString("ksongId");
      paramString = paramString.optJSONObject("qrcConfig");
    } while (paramString == null);
    locala.start = paramString.optLong("start", 0L);
    locala.end = paramString.optLong("end", 0L);
    locala.avX = paramString.optLong("pretime", 0L);
    locala.total = paramString.optLong("total", 0L);
    if ((0L < locala.start) && (0L < locala.end) && (0L < locala.avX) && (0L < locala.total))
    {
      paramString = locala;
      if (locala.start < locala.end) {}
    }
    else
    {
      QLog.i("KSongView", 2, "error! config is wrong...");
      paramString = null;
    }
    return paramString;
  }
  
  private boolean da(long paramLong)
  {
    if (this.mState != 1) {
      return false;
    }
    if (this.ejX >= this.list.size())
    {
      QLog.i("KSongView", 2, "error, out of scrop...");
      return false;
    }
    paramLong = this.jdField_a_of_type_Arkm$a.start + paramLong - this.jdField_a_of_type_Arkm$a.avX;
    if (this.jdField_b_of_type_Arkm$c != null) {
      this.jdField_b_of_type_Arkm$c.update(paramLong);
    }
    Object localObject = (aiwp)this.list.get(this.ejX);
    long l = ((aiwp)localObject).mStartTime + ((aiwp)localObject).mDuration;
    mm(paramLong);
    if (paramLong > l)
    {
      if (l >= this.jdField_a_of_type_Arkm$a.end)
      {
        QLog.i("KSongView", 2, "play over, no scroll...");
        return false;
      }
      QLog.i("KSongView", 2, "scroll to next line = " + this.ejX + " duration = " + paramLong);
      localObject = this.x;
      int i = this.ejX + 1;
      this.ejX = i;
      ((ListView)localObject).smoothScrollToPositionFromTop(i, -1, 50);
    }
    return true;
  }
  
  private void initView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView = new KSongTextView(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.setText("● ● ● ● ●");
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.setTextSize(2, 15.0F);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.setVisibility(4);
    localLinearLayout.addView(this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ListView(paramContext);
    this.x = ((ListView)localObject2);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.x.setDivider(null);
    this.x.setVerticalScrollBarEnabled(false);
    addView(localLinearLayout, paramAttributeSet);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundResource(2130844274);
    ((LinearLayout)localObject1).setClickable(true);
    addView((View)localObject1, paramAttributeSet);
    paramAttributeSet = this.x;
    localObject1 = new ArrayList();
    this.list = ((List)localObject1);
    paramContext = new QwAdapter(paramContext, (List)localObject1, 2131560687, new c());
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter = paramContext;
    paramAttributeSet.setAdapter(paramContext);
  }
  
  private void mm(long paramLong)
  {
    View localView = this.x.getChildAt(0);
    if (localView == null) {
      QLog.i("KSongView", 2, "update sentence v is null...");
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView = ((KSongTextView)localView.findViewById(2131375320));
      QLog.i("KSongView", 2, "index line = " + this.ejX);
    } while (this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView == null);
    float f = a(this.ejX, paramLong);
    QLog.i("KSongView", 2, "show text color rate = " + f);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongTextView.c(f, 15, -1);
  }
  
  private boolean sf(String paramString)
  {
    int k = 0;
    Object localObject = aagd.readFile(paramString);
    paramString = aiwv.a((String)localObject, true);
    if ((paramString == null) || (paramString.xs == null))
    {
      QLog.i("KSongView", 2, "error, parse Qrc fail, qrc = " + (String)localObject);
      return false;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < paramString.xs.size())
      {
        localObject = (aiwp)paramString.xs.get(i);
        if ((((aiwp)localObject).mStartTime >= this.jdField_a_of_type_Arkm$a.start) && (((aiwp)localObject).mStartTime + ((aiwp)localObject).mDuration <= this.jdField_a_of_type_Arkm$a.end)) {
          this.list.add(localObject);
        }
        if (((aiwp)localObject).mStartTime >= this.jdField_a_of_type_Arkm$a.end) {
          j = k;
        }
      }
      else
      {
        while (j < 5)
        {
          this.list.add(new aiwp());
          j += 1;
        }
      }
      i += 1;
    }
    QLog.i("KSongView", 2, "list size = " + this.list.size());
    return true;
  }
  
  public arkm.a a()
  {
    return this.jdField_a_of_type_Arkm$a;
  }
  
  public void a(String paramString1, String paramString2, KSongProsBar paramKSongProsBar, arkm.c paramc)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.i("KSongView", 2, "error! need thinds is null...");
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongProsBar = paramKSongProsBar;
    setKListener(paramc);
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b = new b(this);
    new a().execute(new String[] { paramString1, paramString2 });
  }
  
  public int getState()
  {
    try
    {
      int i = this.mState;
      return i;
    }
    finally {}
  }
  
  public void hk(boolean paramBoolean)
  {
    int i = 0;
    try
    {
      if (this.mState < 0) {
        throw new RuntimeException("error! lyric object not initialized...");
      }
    }
    finally {}
    if (this.mState == 1)
    {
      QLog.i("KSongView", 2, "error, the playing is going...");
      return;
    }
    if (this.mState == 2)
    {
      this.mState = 1;
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b.sendEmptyMessage(0);
      this.uS += System.currentTimeMillis() - this.awa;
      return;
    }
    QLog.i("KSongView", 2, "start playing...");
    if (this.mState == 3) {
      reset();
    }
    this.mState = 1;
    this.uS = 0L;
    KSongTextView localKSongTextView = this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView;
    if (paramBoolean) {}
    for (;;)
    {
      localKSongTextView.kC(i, 0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongTextView.a(this.jdField_a_of_type_Arkm$a.avX, null);
      this.startTime = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b.sendEmptyMessage(0);
      return;
      i = getResources().getColor(2131166390);
    }
  }
  
  public void ml(long paramLong)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongProsBar != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongProsBar.update(paramLong);
    }
  }
  
  public void pause()
  {
    if (this.mState == 1)
    {
      this.mState = 2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b.removeMessages(0);
      this.awa = System.currentTimeMillis();
    }
  }
  
  public void release()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b.removeMessages(0);
    }
    if (this.mState > 0) {
      this.mState = 0;
    }
  }
  
  public void reset()
  {
    QLog.i("KSongView", 2, "start reset...");
    this.jdField_a_of_type_CooperationQwalletPluginQwAdapter.notifyDataSetChanged();
    ListView localListView = this.x;
    this.ejX = 0;
    localListView.setSelection(0);
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongProsBar != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetKsongKSongProsBar.update(0L);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetKsongKSongView$b.removeMessages(0);
    if (this.mState > 0) {
      this.mState = 0;
    }
  }
  
  public void setKListener(arkm.c paramc)
  {
    this.jdField_b_of_type_Arkm$c = paramc;
  }
  
  public class a
    extends AsyncTask<String, Void, arkm.a>
  {
    public a() {}
    
    protected arkm.a a(String... paramVarArgs)
    {
      String str = paramVarArgs[0];
      paramVarArgs = paramVarArgs[1];
      for (;;)
      {
        try
        {
          KSongView.a(KSongView.this, KSongView.a(KSongView.this, paramVarArgs));
          if ((KSongView.a(KSongView.this) != null) && (KSongView.a(KSongView.this, str)))
          {
            paramVarArgs = KSongView.a(KSongView.this);
            return paramVarArgs;
          }
        }
        finally {}
        paramVarArgs = null;
      }
    }
    
    protected void b(arkm.a parama)
    {
      boolean bool = false;
      if (parama != null)
      {
        if (KSongView.a(KSongView.this) != null) {
          KSongView.a(KSongView.this).a(parama);
        }
        KSongView.a(KSongView.this).notifyDataSetChanged();
        KSongView.a(KSongView.this, 0);
      }
      QLog.i("KSongView", 2, "InitTask config = " + parama);
      if (KSongView.a(KSongView.this) != null)
      {
        arkm.c localc = KSongView.a(KSongView.this);
        if (parama != null) {
          bool = true;
        }
        localc.BY(bool);
      }
    }
  }
  
  static class b
    extends Handler
  {
    WeakReference<KSongView> iJ;
    
    public b(KSongView paramKSongView)
    {
      this.iJ = new WeakReference(paramKSongView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 0)
      {
        paramMessage = (KSongView)this.iJ.get();
        if ((paramMessage != null) && (1 == paramMessage.getState())) {
          break label31;
        }
      }
      label31:
      do
      {
        return;
        long l = System.currentTimeMillis() - KSongView.a(paramMessage) - paramMessage.startTime;
        arkm.a locala = paramMessage.a();
        paramMessage.ml(l);
        if (l >= locala.avX) {
          KSongView.a(paramMessage, l);
        }
        QLog.i("KSongView", 2, "real_duration = " + l);
        if (l < locala.total)
        {
          sendEmptyMessageDelayed(0, 50L);
          return;
        }
        KSongView.a(paramMessage, 3);
      } while (KSongView.a(paramMessage) == null);
      KSongView.a(paramMessage).complete();
    }
  }
  
  public class c
    implements QwAdapter.IViewHolder<aiwp>
  {
    public KSongTextView c;
    
    public c() {}
    
    public void a(int paramInt, View paramView, aiwp paramaiwp)
    {
      this.c.reset();
      KSongTextView localKSongTextView = this.c;
      if (TextUtils.isEmpty(paramaiwp.mText)) {}
      for (paramView = "";; paramView = paramaiwp.mText)
      {
        localKSongTextView.setText(paramView);
        return;
      }
    }
    
    public QwAdapter.IViewHolder clone()
      throws CloneNotSupportedException
    {
      return (QwAdapter.IViewHolder)super.clone();
    }
    
    public View initView(int paramInt, View paramView)
    {
      this.c = ((KSongTextView)paramView.findViewById(2131375320));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongView
 * JD-Core Version:    0.7.0.1
 */