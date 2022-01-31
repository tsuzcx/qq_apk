import com.tencent.mm.opensdk.modelbase.BaseResp;

class wfy
  implements bbsh
{
  wfy(wfw paramwfw) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((wfw.c(this.a) == null) || (!wfw.c(this.a).equals(paramBaseResp.transaction))) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    case -2: 
    case -1: 
    default: 
      bbmy.a(wfw.a(this.a), 1, "分享失败", 0).a();
      return;
    }
    bbmy.a(wfw.a(this.a), 2, "分享成功", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wfy
 * JD-Core Version:    0.7.0.1
 */