package wf7;

import Protocol.MConch.ConchPushInfo;
import Protocol.MConch.c;
import Protocol.MConch.f;
import com.tencent.wifisdk.services.common.api.a;

public class fw
  implements cc
{
  private gh rH;
  
  public fw(gh paramgh)
  {
    this.rH = paramgh;
  }
  
  public cd H(int paramInt)
  {
    Object localObject = this.rH.av(paramInt);
    if ((localObject != null) && (((ConchPushInfo)localObject).bs != null) && (((ConchPushInfo)localObject).bs.bj != null)) {}
    for (localObject = (f)df.a(((ConchPushInfo)localObject).bs.bj, new f(), false);; localObject = null)
    {
      if ((localObject != null) && (((f)localObject).by != null)) {
        return new cd(paramInt, ((f)localObject).by);
      }
      return new cd(paramInt, null);
    }
  }
  
  public boolean a(int paramInt, a parama)
  {
    if (this.rH == null) {
      return false;
    }
    return this.rH.a(paramInt, parama);
  }
  
  public boolean a(int paramInt, cf paramcf)
  {
    if (this.rH == null) {
      return false;
    }
    paramcf = new fw.1(this, paramcf);
    return this.rH.a(paramInt, paramcf);
  }
  
  public ConchPushInfo av(int paramInt)
  {
    if (this.rH == null) {
      return null;
    }
    return this.rH.av(paramInt);
  }
  
  public void aw(int paramInt)
  {
    if (this.rH == null) {
      return;
    }
    this.rH.aw(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.fw
 * JD-Core Version:    0.7.0.1
 */