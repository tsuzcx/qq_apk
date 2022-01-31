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

public class ugc
  extends AbsVideoInfoWidget
  implements View.OnClickListener
{
  public static SparseArray<Pools.Pool<ugf>> a;
  private uge a;
  public ugf a;
  public ugg a;
  private int b;
  
  public ugc(ViewGroup paramViewGroup)
  {
    super(paramViewGroup);
  }
  
  private int a(StoryVideoItem paramStoryVideoItem)
  {
    int k = 0;
    teo localteo = paramStoryVideoItem.getOALinkInfo();
    int i;
    if ((localteo != null) && (localteo.jdField_a_of_type_Int > 0))
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
            if (axkt.p()) {
              break label60;
            }
            return 0;
            j = k;
          } while (paramStoryVideoItem == null);
          j = k;
        } while (paramStoryVideoItem.jdField_a_of_type_Tep == null);
      } while (!paramStoryVideoItem.jdField_a_of_type_Tep.a());
      return 0;
      label118:
      i = 0;
    }
  }
  
  private ugf a(int paramInt)
  {
    if ((this.jdField_a_of_type_Ugf != null) && (this.jdField_b_of_type_Int == paramInt)) {
      return this.jdField_a_of_type_Ugf;
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
    localObject = (ugf)((Pools.Pool)localObject).acquire();
    if (localObject == null) {
      localObject = b(paramInt);
    }
    for (;;)
    {
      if (localObject != null) {
        ((ugf)localObject).b = true;
      }
      localPool = (Pools.Pool)jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_b_of_type_Int);
      if ((localPool != null) && (this.jdField_a_of_type_Ugf != null))
      {
        localPool.release(this.jdField_a_of_type_Ugf);
        this.jdField_a_of_type_Ugf.b = false;
      }
      this.jdField_a_of_type_Ugf = ((ugf)localObject);
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
      if (naj.a(paramString))
      {
        paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
        paramString.startDownload();
        paramImageView.setImageDrawable(paramString);
      }
      while (paramString != null) {
        if (paramString.getStatus() == 1)
        {
          return;
          ved.d("BannerVideoInfoWidget", "invalid url, failed to parse the url drawable " + paramString);
          paramImageView.setImageDrawable(paramDrawable);
          paramString = localObject;
        }
        else
        {
          paramString.setURLDrawableListener(new ugd(paramImageView, paramDrawable));
        }
      }
    }
    catch (IllegalArgumentException paramString)
    {
      ved.b("BannerVideoInfoWidget", "set image fail , %s", paramString);
      paramImageView.setImageDrawable(paramDrawable);
      return;
    }
  }
  
  private ugf b(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
      return null;
    case 1: 
      return new uhu();
    case 2: 
      return new uhs();
    case 3: 
      return new uhc();
    case 5: 
      return new ujd();
    case 6: 
      return new ujf();
    }
    return new uha();
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
    this.jdField_a_of_type_Uge = new uge(this);
    a(this.jdField_a_of_type_Uge);
  }
  
  public void a(@NonNull uas paramuas, @NonNull StoryVideoItem paramStoryVideoItem)
  {
    ved.a(this.jdField_b_of_type_JavaLangString, "BannerVideoInfoWidget3 doOnBindUIWhileVideoInfoReady, dataVid:%s, videoItemVid:%s", paramuas.jdField_a_of_type_JavaLangString, paramStoryVideoItem.mVid);
    if (this.jdField_a_of_type_Ugg == null)
    {
      this.jdField_a_of_type_Ugg = new ugg(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    }
    int i = a(paramStoryVideoItem);
    paramStoryVideoItem = a(i);
    if (paramStoryVideoItem != null) {
      paramStoryVideoItem.a(this, i, paramuas);
    }
  }
  
  public boolean a(uas paramuas, StoryVideoItem paramStoryVideoItem)
  {
    if ((a().mUIStyle.hideBannerInfo) || ((paramuas.jdField_a_of_type_Tff != null) && (paramuas.jdField_a_of_type_Tff.jdField_a_of_type_Int == 13))) {}
    while (a(paramStoryVideoItem) <= 0) {
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return 2131561405;
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
          ugf localugf = (ugf)localPool.acquire();
          if (localugf == null) {
            break;
          }
          localugf.a();
        }
        i += 1;
      }
      jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    if (this.jdField_a_of_type_Uge != null) {
      b(this.jdField_a_of_type_Uge);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Ugf != null) {
      this.jdField_a_of_type_Ugf.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ugc
 * JD-Core Version:    0.7.0.1
 */