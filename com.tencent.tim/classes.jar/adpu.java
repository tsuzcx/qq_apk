import com.tencent.mobileqq.ark.ArkAppCenter;

class adpu
  implements adpq.c
{
  adpu(adpq paramadpq, adpq.a parama, adpq.c paramc, String paramString) {}
  
  public void GG(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.r("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.a.name }));
      this.b.GG(true);
      return;
    }
    ArkAppCenter.r("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.a.name }));
    adpq.a(this.this$0, this.buY, this.a, new adpv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adpu
 * JD-Core Version:    0.7.0.1
 */