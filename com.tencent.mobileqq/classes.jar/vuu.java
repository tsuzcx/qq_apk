import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.UIStyle;
import com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tribe.async.dispatch.Subscriber;
import java.util.Map;

public class vuu
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public static SparseArray<Pools.Pool<vux>> a;
  private vuw a;
  public vux a;
  public vuy a;
  private int b;
  
  public vuu(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int a(StoryVideoItem paramStoryVideoItem)
  {
    int k = 0;
    utg localutg = paramStoryVideoItem.getOALinkInfo();
    int i;
    if ((localutg != null) && (localutg.jdField_a_of_type_Int > 0))
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
            if (azfz.p()) {
              break label60;
            }
            return 0;
            j = k;
          } while (paramStoryVideoItem == null);
          j = k;
        } while (paramStoryVideoItem.jdField_a_of_type_Uth == null);
      } while (!paramStoryVideoItem.jdField_a_of_type_Uth.a());
      return 0;
      label118:
      i = 0;
    }
  }
  
  private vux a(int paramInt)
  {
    if ((this.jdField_a_of_type_Vux != null) && (this.jdField_b_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_Vux;
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
    localObject = (vux)((Pools.Pool)localObject).acquire();
    if (localObject == null) {
      localObject = b(paramInt);
    }
    for (;;)
    {
      if (localObject != null) {
        ((vux)localObject).b = true;
      }
      localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      if ((localPool != null) && (this.jdField_a_of_type_Vux != null))
      {
        localPool.release(this.jdField_a_of_type_Vux);
        this.jdField_a_of_type_Vux.b = false;
      }
      this.jdField_a_of_type_Vux = ((vux)localObject);
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
      if (ndd.a(paramString))
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.startDownload();
        paramImageView.setImageDrawable(paramString);
      }
      while (paramString != null) {
        if (paramString.getStatus() == 1)
        {
          return;
          wsv.d("BannerVideoInfoWidget", "invalid url, failed to parse the url drawable " + paramString);
          paramImageView.setImageDrawable(paramDrawable);
          paramString = localObject;
        }
        else
        {
          paramString.setURLDrawableListener(new vuv(paramImageView, paramDrawable));
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      wsv.b("BannerVideoInfoWidget", "set image fail , %s", paramString);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  private vux b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return null;
    case 1: 
      return new vwm();
    case 2: 
      return new vwk();
    case 3: 
      return new vvu();
    case 5: 
      return new vxv();
    case 6: 
      return new vxx();
    }
    return new vvs();
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
    this.jdField_a_of_type_Vuw = new vuw(this);
    a(this.jdField_a_of_type_Vuw);
  }
  
  public void a(@NonNull vpk paramvpk, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    wsv.a(this.jdField_b_of_type_JavaLangString, "BannerVideoInfoWidget3 doOnBindUIWhileVideoInfoReady, dataVid:%s, videoItemVid:%s", paramvpk.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
    if (this.jdField_a_of_type_Vuy == null)
    {
      this.jdField_a_of_type_Vuy = new vuy(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    int i = a(paramStoryVideoItem);
    paramStoryVideoItem = a(i);
    if (paramStoryVideoItem != null) {
      paramStoryVideoItem.a(this, i, paramvpk);
    }
  }
  
  public boolean a(vpk paramvpk, StoryVideoItem paramStoryVideoItem)
  {
    if ((a().mUIStyle.hideBannerInfo) || ((paramvpk.jdField_a_of_type_Utx != null) && (paramvpk.jdField_a_of_type_Utx.jdField_a_of_type_Int == 13))) {}
    while (a(paramStoryVideoItem) <= 0) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return 2131561595;
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
          vux localvux = (vux)localPool.acquire();
          if (localvux == null) {
            break;
          }
          localvux.a();
        }
        i += 1;
      }
      jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_a_of_type_Vuw != null) {
      b(this.jdField_a_of_type_Vuw);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Vux != null) {
      this.jdField_a_of_type_Vux.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vuu
 * JD-Core Version:    0.7.0.1
 */