package tmsdk.common.module.pgsdk;

import com.tencent.qqpimsecure.pg.r;

public class PermissionGuide$PermissionRequest
{
  private int[] a;
  private int b = 0;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  private PermissionGuide$PermissionRequest(int... paramVarArgs)
  {
    this.a = paramVarArgs;
  }
  
  public PermissionRequest manualQuick(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public PermissionRequest monitor(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public void request(RequestCallback paramRequestCallback)
  {
    if (this.b != 0)
    {
      r.a().a(this.a, this.d, this.e, this.c, paramRequestCallback);
      return;
    }
    if (this.f)
    {
      r.a().c(this.a, this.d, this.e, this.c, paramRequestCallback);
      return;
    }
    r.a().b(this.a, this.d, this.e, this.c, paramRequestCallback);
  }
  
  public PermissionRequest skipCheck(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public PermissionRequest source(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public PermissionRequest type(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.PermissionGuide.PermissionRequest
 * JD-Core Version:    0.7.0.1
 */