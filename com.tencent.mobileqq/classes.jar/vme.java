import UserGrowth.stJumpInfo;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vme
{
  private void a(String paramString1, String paramString2, stJumpInfo paramstJumpInfo, int paramInt1, int paramInt2)
  {
    if (paramstJumpInfo == null) {
      return;
    }
    vsj.a(paramString1, paramString2, paramInt1, paramstJumpInfo);
    vkq.c(paramstJumpInfo.url, paramInt2, paramstJumpInfo.id);
  }
  
  public void a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt1, int paramInt2)
  {
    if (paramWSVerticalPageFragment == null) {}
    stJumpInfo localstJumpInfo;
    do
    {
      return;
      localstJumpInfo = vau.a().a(paramInt2);
    } while (localstJumpInfo == null);
    String str2 = localstJumpInfo.schema_url;
    if (!TextUtils.isEmpty(localstJumpInfo.h5url)) {}
    for (String str1 = localstJumpInfo.h5url;; str1 = localstJumpInfo.url)
    {
      vmp.b("WSBlockPage", "schemaUrl:" + str2 + ",h5url:" + str1 + ",jumpurl:" + localstJumpInfo.url);
      String str3 = paramWSVerticalPageFragment.a();
      String str4 = paramWSVerticalPageFragment.b();
      vnd.a(paramWSVerticalPageFragment.getActivity(), str2, str1, "", 5, new vmf(this, paramWSVerticalPageFragment, str3, str4, localstJumpInfo, paramInt1));
      vmp.b("WSBlockPage", "reportBlockPage, id:" + localstJumpInfo.id + " ,pageType:" + 5);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vme
 * JD-Core Version:    0.7.0.1
 */