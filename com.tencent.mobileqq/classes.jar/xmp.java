import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class xmp
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public static SparseArray<Pools.Pool<xms>> a;
  private xmr a;
  public xms a;
  public xmt a;
  private int b;
  
  public xmp(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int a(StoryVideoItem paramStoryVideoItem)
  {
    int k = 0;
    wlh localwlh = paramStoryVideoItem.getOALinkInfo();
    int i;
    if ((localwlh != null) && (localwlh.jdField_a_of_type_Int > 0))
    {
      i = paramStoryVideoItem.getOALinkInfo().jdField_a_of_type_Int;
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
            i = paramStoryVideoItem.jdField_a_of_type_Int;
            break;
            if (bddt.n()) {
              break label60;
            }
            return 0;
            j = k;
          } while (paramStoryVideoItem == null);
          j = k;
        } while (paramStoryVideoItem.jdField_a_of_type_Wli == null);
      } while (!paramStoryVideoItem.jdField_a_of_type_Wli.a());
      return 0;
      label118:
      i = 0;
    }
  }
  
  private xms a(int paramInt)
  {
    if ((this.jdField_a_of_type_Xms != null) && (this.jdField_b_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_Xms;
    }
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    Pools.Pool localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localPool;
    if (localPool == null)
    {
      localObject = new Pools.SimplePool(5);
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    }
    localObject = (xms)((Pools.Pool)localObject).acquire();
    if (localObject == null) {
      localObject = b(paramInt);
    }
    for (;;)
    {
      if (localObject != null) {
        ((xms)localObject).b = true;
      }
      localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      if ((localPool != null) && (this.jdField_a_of_type_Xms != null))
      {
        localPool.release(this.jdField_a_of_type_Xms);
        this.jdField_a_of_type_Xms.b = false;
      }
      this.jdField_a_of_type_Xms = ((xms)localObject);
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
      if (HttpUtil.isValidUrl(paramString))
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.startDownload();
        paramImageView.setImageDrawable(paramString);
      }
      while (paramString != null) {
        if (paramString.getStatus() == 1)
        {
          return;
          ykq.d("BannerVideoInfoWidget", "invalid url, failed to parse the url drawable " + paramString);
          paramImageView.setImageDrawable(paramDrawable);
          paramString = localObject;
        }
        else
        {
          paramString.setURLDrawableListener(new xmq(paramImageView, paramDrawable));
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      ykq.b("BannerVideoInfoWidget", "set image fail , %s", paramString);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  private xms b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return null;
    case 1: 
      return new xoh();
    case 2: 
      return new xof();
    case 3: 
      return new xnp();
    case 5: 
      return new xpq();
    case 6: 
      return new xps();
    }
    return new xnn();
  }
  
  public String a()
  {
    return "BannerVideoInfoWidget";
  }
  
  public void a(View paramView)
  {
    if (jdField_a_of_type_AndroidUtilSparseArray == null) {
      jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
  }
  
  public void a(Map<Subscriber, String> paramMap)
  {
    this.jdField_a_of_type_Xmr = new xmr(this);
    a(this.jdField_a_of_type_Xmr);
  }
  
  public void a(@NonNull xhf paramxhf, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ykq.a(this.jdField_b_of_type_JavaLangString, "BannerVideoInfoWidget3 doOnBindUIWhileVideoInfoReady, dataVid:%s, videoItemVid:%s", paramxhf.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
    if (this.jdField_a_of_type_Xmt == null)
    {
      this.jdField_a_of_type_Xmt = new xmt(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    int i = a(paramStoryVideoItem);
    paramStoryVideoItem = a(i);
    if (paramStoryVideoItem != null) {
      paramStoryVideoItem.a(this, i, paramxhf);
    }
  }
  
  public boolean a(xhf paramxhf, StoryVideoItem paramStoryVideoItem)
  {
    if ((a().mUIStyle.hideBannerInfo) || ((paramxhf.jdField_a_of_type_Wly != null) && (paramxhf.jdField_a_of_type_Wly.jdField_a_of_type_Int == 13))) {}
    while (a(paramStoryVideoItem) <= 0) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return 2131561834;
  }
  
  public void f() {}
  
  public void g()
  {
    if ((jdField_a_of_type_AndroidUtilSparseArray != null) && (jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      int i = 0;
      while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        Pools.Pool localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        for (;;)
        {
          xms localxms = (xms)localPool.acquire();
          if (localxms == null) {
            break;
          }
          localxms.a();
        }
        i += 1;
      }
      jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_a_of_type_Xmr != null) {
      b(this.jdField_a_of_type_Xmr);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Xms != null) {
      this.jdField_a_of_type_Xms.a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmp
 * JD-Core Version:    0.7.0.1
 */