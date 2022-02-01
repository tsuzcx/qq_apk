import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.open.base.BspatchUtil;
import java.io.File;

class adpy
  implements adpq.b
{
  adpy(adpq paramadpq, adpq.a parama1, String paramString1, adpq.a parama2, String paramString2, adpq.c paramc) {}
  
  public void aY(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.a.name, this.a.url }));
    }
    for (;;)
    {
      this.b.GG(false);
      return;
      if (!adpq.f(paramArrayOfByte, this.a.bvb))
      {
        ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.a.name, this.a.url, this.a.bvb }));
      }
      else
      {
        String str1 = adpq.aO(this.buZ, this.c.name);
        if (!new File(str1).isFile())
        {
          ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.a.name, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.buY, this.a.md5 });
          if (!adpq.e(paramArrayOfByte, str2))
          {
            ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.a.name, str2 }));
          }
          else
          {
            if (BspatchUtil.D(str1, str2, String.format("%s/%s", new Object[] { this.buY, this.a.name }))) {
              break;
            }
            ArkAppCenter.r("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.a.name, this.a.bvb }));
          }
        }
      }
    }
    this.b.GG(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpy
 * JD-Core Version:    0.7.0.1
 */