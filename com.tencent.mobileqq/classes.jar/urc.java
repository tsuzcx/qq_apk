import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class urc
{
  public static int a(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    while (!TextUtils.equals(paramString, "aio_home_page")) {
      return i;
    }
    return 12;
  }
  
  public static List<uru> a(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
        uru localuru = new uru();
        localuru.a(localstSimpleMetaFeed);
        localArrayList.add(localuru);
      }
      return localArrayList;
    }
    return null;
  }
  
  public static List<ukn> a(List<uru> paramList, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    if (paramBoolean)
    {
      i = paramInt + 1;
      while (i < paramInt + 1 + 3)
      {
        a(localArrayList, paramList, i);
        i += 1;
      }
    }
    int i = paramInt - 1;
    while (i > paramInt - 1 - 3)
    {
      a(localArrayList, paramList, i);
      i -= 1;
    }
    return localArrayList;
  }
  
  public static ukn a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    ukn localukn = new ukn(paramstSimpleMetaFeed.video_url, paramstSimpleMetaFeed.video.duration);
    localukn.a = paramstSimpleMetaFeed.id;
    localukn.c = paramstSimpleMetaFeed.feed_desc;
    return localukn;
  }
  
  public static void a(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null)) {
      paramRelativeLayout.setPadding(paramRelativeLayout.getPaddingLeft(), paramRelativeLayout.getPaddingTop() + upr.a(paramActivity), paramRelativeLayout.getPaddingRight(), paramRelativeLayout.getPaddingBottom());
    }
  }
  
  private static void a(List<ukn> paramList, List<uru> paramList1, int paramInt)
  {
    if ((paramList1.size() > paramInt) && (paramInt >= 0))
    {
      paramList1 = (uru)paramList1.get(paramInt);
      if ((paramList1.a() instanceof stSimpleMetaFeed)) {}
    }
    else
    {
      return;
    }
    paramList.add(a((stSimpleMetaFeed)paramList1.a()));
  }
  
  public static int b(String paramString)
  {
    if ((TextUtils.equals(paramString, "recommend_tab")) || (TextUtils.equals(paramString, "aio_new_msg")) || (TextUtils.equals(paramString, "mini_app_personal_main")) || (TextUtils.equals(paramString, "mini_app_personal_guest")) || (TextUtils.equals(paramString, "vertical_layer_collection")) || (TextUtils.equals(paramString, "aio_home_page")) || (TextUtils.equals(paramString, "qqchat"))) {
      return 1;
    }
    if ((TextUtils.equals(paramString, "follow_tab")) || (TextUtils.equals(paramString, "friend_feed"))) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urc
 * JD-Core Version:    0.7.0.1
 */