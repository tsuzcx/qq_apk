import com.tencent.mobileqq.ark.ArkAppCenter;

class adqc
  implements acci
{
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "ArkTemp.queryAppInfoByAppNameBatch, sso request failed");
      paramObject = null;
    }
    for (;;)
    {
      paramObject = adqb.a(this.this$0, (String)paramObject);
      if (this.a != null) {
        this.a.a(paramObject, this.val$userdata);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqc
 * JD-Core Version:    0.7.0.1
 */