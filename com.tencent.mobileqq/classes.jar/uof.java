import UserGrowth.stGlobalConfig;
import UserGrowth.stJumpInfo;
import UserGrowth.stPopWindowsConfig;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uof
{
  private static int a = -1;
  
  private static void a()
  {
    a = -1;
  }
  
  public static void a(stGlobalConfig paramstGlobalConfig)
  {
    if (paramstGlobalConfig == null) {}
    do
    {
      return;
      a();
      paramstGlobalConfig = paramstGlobalConfig.jumpinfo;
    } while ((paramstGlobalConfig == null) || (paramstGlobalConfig.index < 0) || (paramstGlobalConfig.id <= 0));
    a = paramstGlobalConfig.index;
    upe.a("BlockPageHelper", "全屏阻断页是第" + a + "个,id为：" + paramstGlobalConfig.id);
  }
  
  public static void a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt)
  {
    if (paramWSVerticalPageFragment == null) {}
    stJumpInfo localstJumpInfo;
    do
    {
      return;
      localstJumpInfo = ugb.a().a();
    } while (localstJumpInfo == null);
    String str2 = localstJumpInfo.schema_url;
    if (localstJumpInfo.h5url != null) {}
    for (String str1 = localstJumpInfo.h5url;; str1 = localstJumpInfo.url)
    {
      upe.b("BlockPageHelper", "schemaUrl:" + str2 + ",h5url:" + str1 + ",jumpurl:" + localstJumpInfo.url);
      String str3 = paramWSVerticalPageFragment.a();
      String str4 = paramWSVerticalPageFragment.b();
      ups.a(paramWSVerticalPageFragment.getActivity(), str2, str1, "", 5, new uog(paramWSVerticalPageFragment, str3, str4, localstJumpInfo, paramInt));
      a();
      upe.b("BlockPageHelper", "reportBlockPage, id:" + localstJumpInfo.id + " ,pageType:" + 5);
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return a == paramInt;
  }
  
  private static void b(String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt)
  {
    uut.a(paramString1, paramString2, paramInt, paramstJumpInfo);
    paramString1 = ugb.a().a();
    int i;
    if (paramString1 != null)
    {
      paramInt = paramString1.type;
      i = paramString1.windowsid;
    }
    for (;;)
    {
      if (paramstJumpInfo == null) {}
      for (paramString1 = "";; paramString1 = paramstJumpInfo.url)
      {
        unh.c(paramString1, paramInt, i);
        return;
      }
      i = -1;
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uof
 * JD-Core Version:    0.7.0.1
 */