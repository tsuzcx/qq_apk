package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.XViewPager;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import pmi;
import psu;
import psx;
import pyc.a;
import qgy.d;
import qir;
import qjh;
import qjq;
import qml;
import ram;
import rom;

public abstract class AbsVideoInfoWidget
  extends qir
  implements IEventReceiver
{
  public final String TAG = "Q.qqstory.player.videoinfowidget." + getTag();
  protected ProgressView a;
  public b a;
  @Nullable
  public qjq a;
  protected boolean aEp;
  protected boolean aEq;
  protected boolean aEr;
  protected Map<Subscriber, String> fY = new HashMap();
  protected Dialog g;
  public Handler mUIHandler = new Handler(Looper.getMainLooper());
  
  public AbsVideoInfoWidget(View paramView)
  {
    super(paramView);
  }
  
  public AbsVideoInfoWidget(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private final void a(qjq paramqjq)
  {
    if ((paramqjq == null) || (!paramqjq.JM()))
    {
      this.jdField_a_of_type_Qjq = null;
      hide();
      return;
    }
    this.jdField_a_of_type_Qjq = paramqjq;
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).b(paramqjq.vid);
    if ((localStoryVideoItem == null) || (localStoryVideoItem.mErrorCode != 0))
    {
      hide();
      return;
    }
    if (a(paramqjq, localStoryVideoItem))
    {
      bpl();
      show();
      a(paramqjq, localStoryVideoItem);
      return;
    }
    hide();
  }
  
  private final void bpj()
  {
    this.aEp = true;
    a locala = new a(this);
    this.fY.clear();
    this.fY.put(locala, "");
    pmi.a().registerSubscriber("", locala);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$b = new b();
    a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$b);
    ram.d(this.TAG, "onWidgetCreate!");
  }
  
  private final void bpk()
  {
    if (this.aEq) {
      doOnDestroy();
    }
    this.aEp = false;
    this.aEq = false;
    Iterator localIterator = this.fY.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Subscriber localSubscriber = (Subscriber)((Map.Entry)localIterator.next()).getKey();
      pmi.a().unRegisterSubscriber(localSubscriber);
    }
    this.fY.clear();
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$b != null) {
      b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetAbsVideoInfoWidget$b);
    }
    ram.d(this.TAG, "onWidgetDestroy!");
  }
  
  protected abstract void N(@NonNull Map<Subscriber, String> paramMap);
  
  public final void a(int paramInt, qgy.d paramd, @NonNull ArrayList<qjq> paramArrayList)
  {
    boolean bool = this.aDy;
    super.a(paramInt, paramd, paramArrayList);
    if (!bool) {
      bpj();
    }
    paramInt = ((StoryPlayerGroupHolder)a()).bmz;
    if ((paramInt >= this.nR.size()) || (paramInt < 0))
    {
      ram.w(this.TAG, "Position error , bind data error, current position = %d , size = %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.nR.size()) });
      updateUI();
      return;
    }
    a((qjq)this.nR.get(paramInt));
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, paramBoolean, 0L);
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean, long paramLong)
  {
    Activity localActivity = getActivity();
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mUIHandler.postDelayed(new AbsVideoInfoWidget.2(this, localActivity, paramBoolean, paramCharSequence), paramLong);
  }
  
  protected abstract void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem);
  
  protected abstract boolean a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem);
  
  public final void boy()
  {
    super.boy();
    bpk();
  }
  
  protected void bpl()
  {
    if (!this.aEq)
    {
      this.aEq = true;
      doOnCreate();
      HashMap localHashMap = new HashMap();
      N(localHashMap);
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Map.Entry)localIterator.next();
        Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        pmi.a().registerSubscriber((String)localObject, localSubscriber);
      }
      this.fY.putAll(localHashMap);
      if (!this.aEr)
      {
        this.aEr = true;
        if (getLayoutId() != -1)
        {
          rom.assertTrue(this.mItemView instanceof ViewGroup);
          LayoutInflater.from(this.mItemView.getContext()).inflate(getLayoutId(), (ViewGroup)this.mItemView, true);
        }
        dJ(this.mItemView);
      }
    }
  }
  
  public final void bpm()
  {
    this.mUIHandler.removeCallbacksAndMessages(null);
    this.mUIHandler.post(new AbsVideoInfoWidget.3(this));
  }
  
  protected abstract void dJ(View paramView);
  
  protected abstract void doOnCreate();
  
  protected abstract void doOnDestroy();
  
  public final void g(CharSequence paramCharSequence)
  {
    a(paramCharSequence, true, 0L);
  }
  
  public final Activity getActivity()
  {
    return n();
  }
  
  protected abstract int getLayoutId();
  
  public abstract String getTag();
  
  public final int getVideoSource()
  {
    return a().mReportData.from;
  }
  
  public final void hide()
  {
    setVisibility(8);
  }
  
  public final boolean isShow()
  {
    return getVisibility() == 0;
  }
  
  public final boolean isValidate()
  {
    return this.aEp;
  }
  
  public final String mL()
  {
    if (this.jdField_a_of_type_Qjq != null)
    {
      VideoListFeedItem localVideoListFeedItem = this.jdField_a_of_type_Qjq.a();
      if ((localVideoListFeedItem != null) && ((localVideoListFeedItem instanceof ShareGroupFeedItem))) {
        return ((ShareGroupFeedItem)localVideoListFeedItem).getOwner().getUnionId();
      }
    }
    return "";
  }
  
  public final void onCreate()
  {
    super.onCreate();
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)a();
    localStoryPlayerGroupHolder.a.a(new qml(this, localStoryPlayerGroupHolder));
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    return paramViewGroup;
  }
  
  public final void show()
  {
    setVisibility(0);
  }
  
  public final void updateUI()
  {
    a(this.jdField_a_of_type_Qjq);
  }
  
  public static class ProgressView
    extends FrameLayout
  {
    private ProgressBar mProgressBar;
    private TextView nM;
    
    public ProgressView(Context paramContext)
    {
      super();
      init(paramContext);
    }
    
    public ProgressView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      init(paramContext);
    }
    
    private void init(Context paramContext)
    {
      LayoutInflater.from(paramContext).inflate(2131562047, this);
      this.mProgressBar = ((ProgressBar)findViewById(2131373659));
      this.nM = ((TextView)findViewById(2131379401));
    }
    
    public void setProgressText(CharSequence paramCharSequence)
    {
      if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
      {
        this.nM.setVisibility(8);
        return;
      }
      this.nM.setVisibility(0);
      this.nM.setText(paramCharSequence);
    }
  }
  
  public static class a
    extends QQUIEventReceiver<AbsVideoInfoWidget, pyc.a>
  {
    public a(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget)
    {
      super();
    }
    
    public void a(@NonNull AbsVideoInfoWidget paramAbsVideoInfoWidget, @NonNull pyc.a parama)
    {
      if ((parama.b.isFail()) || (parama.mVideoList == null)) {}
      String str;
      StoryVideoItem localStoryVideoItem;
      do
      {
        do
        {
          return;
          while (paramAbsVideoInfoWidget.a == null) {}
          str = paramAbsVideoInfoWidget.a.vid;
          parama = parama.mVideoList.iterator();
        } while (!parama.hasNext());
        localStoryVideoItem = (StoryVideoItem)parama.next();
      } while ((!TextUtils.equals(str, localStoryVideoItem.mVid)) || (!localStoryVideoItem.isBasicInfoOK()));
      paramAbsVideoInfoWidget.updateUI();
    }
    
    public Class acceptEventClass()
    {
      return pyc.a.class;
    }
  }
  
  public class b
    extends qjh
  {
    public b() {}
    
    public void onDestroy()
    {
      super.onDestroy();
      if (AbsVideoInfoWidget.this.aEp)
      {
        AbsVideoInfoWidget.a(AbsVideoInfoWidget.this);
        ram.d(AbsVideoInfoWidget.this.TAG, "destroy by activity");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget
 * JD-Core Version:    0.7.0.1
 */