import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class oog
{
  private static int bfv = -1;
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt)
  {
    if (paramWSVerticalPageFragment == null) {}
    stJumpInfo localstJumpInfo;
    do
    {
      return;
      localstJumpInfo = ohy.a().a();
    } while (localstJumpInfo == null);
    String str2 = localstJumpInfo.schema_url;
    if (localstJumpInfo.h5url != null) {}
    for (String str1 = localstJumpInfo.h5url;; str1 = localstJumpInfo.url)
    {
      ooz.d("BlockPageHelper", "schemaUrl:" + str2 + ",h5url:" + str1 + ",jumpurl:" + localstJumpInfo.url);
      String str3 = paramWSVerticalPageFragment.getFrom();
      String str4 = paramWSVerticalPageFragment.getPlayScene();
      opn.a(paramWSVerticalPageFragment.getActivity(), str2, str1, "", 5, new ooh(paramWSVerticalPageFragment, str3, str4, localstJumpInfo, paramInt));
      bfS();
      ooz.d("BlockPageHelper", "reportBlockPage, id:" + localstJumpInfo.id + " ,pageType:" + 5);
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt)
  {
    osv.a(paramString1, paramString2, paramInt, paramstJumpInfo);
  }
  
  private static void bfS()
  {
    bfv = -1;
  }
  
  public static void c(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {}
    do
    {
      return;
      bfS();
      paramstGlobalConfig = paramstGlobalConfig.jumpinfo;
    } while ((paramstGlobalConfig == null) || (paramstGlobalConfig.index < 0) || (paramstGlobalConfig.id <= 0));
    bfv = paramstGlobalConfig.index;
    ooz.i("BlockPageHelper", "全屏阻断页是第" + bfv + "个,id为：" + paramstGlobalConfig.id);
  }
  
  public static boolean et(int paramInt)
  {
    return bfv == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oog
 * JD-Core Version:    0.7.0.1
 */