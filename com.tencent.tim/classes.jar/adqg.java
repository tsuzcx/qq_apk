import com.tencent.mobileqq.ark.ArkAppCenter;

class adqg
  implements acci
{
  adqg(adqb paramadqb) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.r("ArkApp.ArkAppCGI", "doVipReport(), sso request failed");
      return;
    }
    ArkAppCenter.q("ArkApp.ArkAppCGI", "doVipReport().server.back=" + paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adqg
 * JD-Core Version:    0.7.0.1
 */