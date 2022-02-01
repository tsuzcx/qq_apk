import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class qmm
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public static SparseArray<Pools.Pool<qmm.b>> aO;
  private qmm.a a;
  public qmm.b a;
  public qmm.c a;
  private int mType;
  
  public qmm(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int a(StoryVideoItem paramStoryVideoItem)
  {
    int k = 0;
    pty localpty = paramStoryVideoItem.getOALinkInfo();
    int i;
    if ((localpty != null) && (localpty.styleType > 0))
    {
      i = paramStoryVideoItem.getOALinkInfo().styleType;
      paramStoryVideoItem = null;
    }
    for (;;)
    {
      switch (i)
      {
      }
      label60:
      do
      {
        int j = i;
        do
        {
          do
          {
            return j;
            paramStoryVideoItem = paramStoryVideoItem.getVideoLinkInfo();
            if (paramStoryVideoItem == null) {
              break label118;
            }
            i = paramStoryVideoItem.styleType;
            break;
            if (anki.axQ()) {
              break label60;
            }
            return 0;
            j = k;
          } while (paramStoryVideoItem == null);
          j = k;
        } while (paramStoryVideoItem.a == null);
      } while (!paramStoryVideoItem.a.IY());
      return 0;
      label118:
      i = 0;
    }
  }
  
  private qmm.b a(int paramInt)
  {
    if ((this.jdField_a_of_type_Qmm$b != null) && (this.mType == paramInt)) {
      return this.jdField_a_of_type_Qmm$b;
    }
    if (aO == null) {
      aO = new SparseArray();
    }
    Pools.Pool localPool = (Pools.Pool)aO.get(paramInt);
    Object localObject = localPool;
    if (localPool == null)
    {
      localObject = new Pools.SimplePool(5);
      aO.put(paramInt, localObject);
    }
    localObject = (qmm.b)((Pools.Pool)localObject).acquire();
    if (localObject == null) {
      localObject = b(paramInt);
    }
    for (;;)
    {
      if (localObject != null) {
        ((qmm.b)localObject).aEt = true;
      }
      localPool = (Pools.Pool)aO.get(this.mType);
      if ((localPool != null) && (this.jdField_a_of_type_Qmm$b != null))
      {
        localPool.release(this.jdField_a_of_type_Qmm$b);
        this.jdField_a_of_type_Qmm$b.aEt = false;
      }
      this.jdField_a_of_type_Qmm$b = ((qmm.b)localObject);
      return localObject;
    }
  }
  
  public static void a(String paramString, @NonNull ImageView paramImageView, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
      localURLDrawableOptions.mFailedDrawable = paramDrawable;
      localURLDrawableOptions.mPlayGifImage = false;
      localURLDrawableOptions.mGifRoundCorner = 0.0F;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      localURLDrawableOptions.mMemoryCacheKeySuffix = "link";
      Object localObject = null;
      if (jqc.isValidUrl(paramString))
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.startDownload();
        paramImageView.setImageDrawable(paramString);
      }
      while (paramString != null) {
        if (paramString.getStatus() == 1)
        {
          return;
          ram.w("BannerVideoInfoWidget", "invalid url, failed to parse the url drawable " + paramString);
          paramImageView.setImageDrawable(paramDrawable);
          paramString = localObject;
        }
        else
        {
          paramString.setURLDrawableListener(new qmn(paramImageView, paramDrawable));
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      ram.w("BannerVideoInfoWidget", "set image fail , %s", paramString);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  private qmm.b b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return null;
    case 1: 
      return new qnf();
    case 2: 
      return new qne();
    case 3: 
      return new qmx();
    case 5: 
      return new qoa();
    case 6: 
      return new qoc();
    }
    return new qmw();
  }
  
  public void N(Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Qmm$a = new qmm.a();
    a(this.jdField_a_of_type_Qmm$a);
  }
  
  public void a(@NonNull qjq paramqjq, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ram.b(this.TAG, "BannerVideoInfoWidget3 doOnBindUIWhileVideoInfoReady, dataVid:%s, videoItemVid:%s", paramqjq.vid, paramStoryVideoItem.mVid);
    if (this.jdField_a_of_type_Qmm$c == null)
    {
      this.jdField_a_of_type_Qmm$c = new qmm.c(this.mItemView);
      this.mItemView.setOnClickListener(this);
    }
    int i = a(paramStoryVideoItem);
    paramStoryVideoItem = a(i);
    if (paramStoryVideoItem != null) {
      paramStoryVideoItem.a(this, i, paramqjq);
    }
  }
  
  public boolean a(qjq paramqjq, StoryVideoItem paramStoryVideoItem)
  {
    if ((a().mUIStyle.hideBannerInfo) || ((paramqjq.h != null) && (paramqjq.h.nodeType == 13))) {}
    while (a(paramStoryVideoItem) <= 0) {
      return false;
    }
    return true;
  }
  
  public void dJ(View paramView)
  {
    if (aO == null) {
      aO = new SparseArray();
    }
  }
  
  public void doOnCreate() {}
  
  public void doOnDestroy()
  {
    if ((aO != null) && (aO.size() > 0))
    {
      int i = 0;
      while (i < aO.size())
      {
        Pools.Pool localPool = (Pools.Pool)aO.valueAt(i);
        for (;;)
        {
          qmm.b localb = (qmm.b)localPool.acquire();
          if (localb == null) {
            break;
          }
          localb.destroy();
        }
        i += 1;
      }
      aO.clear();
    }
    if (this.jdField_a_of_type_Qmm$a != null) {
      b(this.jdField_a_of_type_Qmm$a);
    }
  }
  
  public int getLayoutId()
  {
    return 2131562006;
  }
  
  public String getTag()
  {
    return "BannerVideoInfoWidget";
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qmm$b != null) {
      this.jdField_a_of_type_Qmm$b.F(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public class a
    extends qjh
  {
    public a() {}
    
    public void a(Bundle paramBundle1, Bundle paramBundle2)
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).a(paramBundle1, paramBundle2);
        }
      }
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent);
        }
      }
    }
    
    public void onDestroy()
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).onDestroy();
        }
      }
    }
    
    public void onPause()
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).onPause();
        }
      }
    }
    
    public void onResume()
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).onResume();
        }
      }
    }
    
    public void onStart()
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).onStart();
        }
      }
    }
    
    public void onStop()
    {
      if ((qmm.this.a != null) && (qmm.this.a.aM != null) && (!qmm.this.a.aM.isEmpty()))
      {
        Iterator localIterator = qmm.this.a.aM.iterator();
        while (localIterator.hasNext()) {
          ((qig)localIterator.next()).onStop();
        }
      }
    }
  }
  
  public static abstract class b
    implements IEventReceiver
  {
    private long AO;
    public boolean aEt;
    protected Set<qig> aM;
    public qmm b;
    protected Map<Subscriber, String> fY;
    protected boolean mIsInited;
    
    public boolean F(View paramView)
    {
      if (System.currentTimeMillis() - this.AO < 500L) {
        return false;
      }
      this.AO = System.currentTimeMillis();
      return true;
    }
    
    public Map<Subscriber, String> N()
    {
      return null;
    }
    
    public final void a(qmm.c paramc, qjq paramqjq)
    {
      paramc.reset();
      b(paramc, paramqjq);
    }
    
    public final void a(@NonNull qmm paramqmm, int paramInt, @NonNull qjq paramqjq)
    {
      qmm.a(paramqmm, paramInt);
      this.b = paramqmm;
      if (!this.mIsInited)
      {
        Object localObject1 = N();
        if ((localObject1 != null) && (!((Map)localObject1).isEmpty()))
        {
          Iterator localIterator = ((Map)localObject1).entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject2 = (Map.Entry)localIterator.next();
            Subscriber localSubscriber = (Subscriber)((Map.Entry)localObject2).getKey();
            localObject2 = (String)((Map.Entry)localObject2).getValue();
            pmi.a().registerSubscriber((String)localObject2, localSubscriber);
          }
          if (this.fY == null) {
            this.fY = new HashMap();
          }
          this.fY.putAll((Map)localObject1);
        }
        localObject1 = v();
        if ((localObject1 != null) && (!((Set)localObject1).isEmpty()))
        {
          if (this.aM == null) {
            this.aM = new HashSet();
          }
          this.aM.addAll((Collection)localObject1);
        }
        this.mIsInited = true;
      }
      a(paramqmm.a, paramqjq);
    }
    
    public abstract void b(qmm.c paramc, qjq paramqjq);
    
    public void destroy()
    {
      Iterator localIterator;
      Object localObject;
      if ((this.fY != null) && (!this.fY.isEmpty()))
      {
        localIterator = this.fY.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject = (Subscriber)((Map.Entry)localIterator.next()).getKey();
          pmi.a().unRegisterSubscriber((Subscriber)localObject);
        }
        this.fY.clear();
      }
      if ((this.aM != null) && (!this.aM.isEmpty()))
      {
        localIterator = this.aM.iterator();
        while (localIterator.hasNext())
        {
          localObject = (qig)localIterator.next();
          this.b.b((qig)localObject);
        }
        this.aM.clear();
      }
    }
    
    public boolean isValidate()
    {
      return this.aEt;
    }
    
    public Set<qig> v()
    {
      return null;
    }
  }
  
  public static class c
  {
    public int bnm;
    public TextView content;
    public Drawable defaultDrawable;
    public ImageView imageView;
    public View itemView;
    public ImageView mJ;
    public TextView xj;
    public TextView xk;
    
    public c(View paramView)
    {
      this.itemView = paramView.findViewById(2131370522);
      this.imageView = ((ImageView)paramView.findViewById(2131370521));
      this.content = ((TextView)paramView.findViewById(2131370513));
      this.xj = ((TextView)paramView.findViewById(2131370510));
      this.mJ = ((ImageView)paramView.findViewById(2131370520));
      this.xk = ((TextView)paramView.findViewById(2131361975));
      this.bnm = paramView.getContext().getResources().getDimensionPixelOffset(2131299509);
      this.defaultDrawable = paramView.getContext().getResources().getDrawable(2130840151);
    }
    
    public void reset()
    {
      this.itemView.setBackgroundResource(2130840145);
      this.itemView.setPadding(this.itemView.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), this.itemView.getPaddingBottom());
      this.imageView.setVisibility(8);
      this.imageView.setImageResource(2130840151);
      this.xj.setVisibility(8);
      this.xj.setText("");
      this.xj.setTypeface(null, 1);
      this.xj.setContentDescription("");
      this.xj.setTextColor(-16777216);
      this.content.setVisibility(8);
      this.content.setText("");
      this.content.setContentDescription("");
      this.content.setTextColor(-16777216);
      this.mJ.setVisibility(8);
      this.xk.setVisibility(8);
    }
  }
  
  public static abstract interface d
  {
    public abstract void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
    
    public abstract void onDestroy();
    
    public abstract void onStop();
  }
  
  public static class e
    extends qjh
  {
    private qmm.d a;
    
    public void a(qmm.d paramd)
    {
      this.a = paramd;
    }
    
    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      if (this.a != null) {
        this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    
    public void onDestroy()
    {
      if (this.a != null) {
        this.a.onDestroy();
      }
    }
    
    public void onStop()
    {
      if (this.a != null) {
        this.a.onStop();
      }
    }
  }
  
  public static abstract interface f
  {
    public abstract void bnS();
    
    public abstract void rC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qmm
 * JD-Core Version:    0.7.0.1
 */