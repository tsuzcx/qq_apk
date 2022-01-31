import com.tencent.mm.opensdk.modelbase.BaseResp;

class wuw
  implements bcww
{
  wuw(wur paramwur) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((wur.c(this.a) == null) || (!wur.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      bcql.a(wur.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    bcql.a(wur.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wuw
 * JD-Core Version:    0.7.0.1
 */