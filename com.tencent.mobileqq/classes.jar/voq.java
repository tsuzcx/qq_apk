import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class voq
{
  public static int a(String paramString)
  {
    int i = 2;
    if (TextUtils.equals(paramString, "trends")) {
      i = 6;
    }
    do
    {
      return i;
      if (TextUtils.equals(paramString, "aio_home_page")) {
        return 12;
      }
    } while (!TextUtils.equals(paramString, "qqchat"));
    return 10007;
  }
  
  public static List<vpj> a(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramList.next();
        vpj localvpj = new vpj();
        localvpj.a(localstSimpleMetaFeed);
        localArrayList.add(localvpj);
      }
      return localArrayList;
    }
    return null;
  }
  
  public static List<vgp> a(List<vpj> paramList, int paramInt, boolean paramBoolean)
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
  
  public static vgp a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    vgp localvgp = new vgp(paramstSimpleMetaFeed.video_url, paramstSimpleMetaFeed.video.duration);
    localvgp.a = paramstSimpleMetaFeed.id;
    localvgp.c = paramstSimpleMetaFeed.feed_desc;
    return localvgp;
  }
  
  public static void a(Activity paramActivity, RelativeLayout paramRelativeLayout)
  {
    if ((paramActivity != null) && (paramRelativeLayout != null)) {
      paramRelativeLayout.setPadding(paramRelativeLayout.getPaddingLeft(), paramRelativeLayout.getPaddingTop() + vnc.a(paramActivity), paramRelativeLayout.getPaddingRight(), paramRelativeLayout.getPaddingBottom());
    }
  }
  
  public static void a(String paramString, List<vpj> paramList)
  {
    if (QLog.isColorLevel())
    {
      if (paramList == null) {
        vmp.d("FEED_TITLE", paramString + " itemList is null!");
      }
    }
    else {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (vpj)localIterator.next();
      if ((((vpj)localObject).a() instanceof stSimpleMetaFeed))
      {
        localObject = (stSimpleMetaFeed)((vpj)localObject).a();
        vmp.a("FEED_TITLE", paramString + " title:" + ((stSimpleMetaFeed)localObject).feed_desc);
      }
    }
    vmp.b("FEED_TITLE", paramString + " feedListSize:" + paramList.size());
  }
  
  private static void a(List<vgp> paramList, List<vpj> paramList1, int paramInt)
  {
    if ((paramList1.size() > paramInt) && (paramInt >= 0))
    {
      paramList1 = (vpj)paramList1.get(paramInt);
      if ((paramList1.a() instanceof stSimpleMetaFeed)) {}
    }
    else
    {
      return;
    }
    paramList.add(a((stSimpleMetaFeed)paramList1.a()));
  }
  
  public static boolean a(Set<String> paramSet, int paramInt, vgi paramvgi)
  {
    if (paramInt == 1) {
      if (!TextUtils.isEmpty(paramvgi.a)) {
        paramSet.add(paramvgi.a);
      }
    }
    for (;;)
    {
      return false;
      if (!paramSet.contains(paramvgi.a))
      {
        vmp.d("WSVerticalUtils", "[checkNoStartedVideo] title:" + paramvgi.d);
        return true;
      }
      paramSet.remove(paramvgi.a);
    }
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
 * Qualified Name:     voq
 * JD-Core Version:    0.7.0.1
 */