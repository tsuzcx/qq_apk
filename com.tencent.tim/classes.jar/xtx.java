import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.a;

public class xtx
  extends akye.a
{
  public xtx(AIOImageProviderService paramAIOImageProviderService, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString) {}
  
  public void a(int paramInt, akxr paramakxr)
  {
    Object localObject = this.this$0.c;
    if (localObject != null)
    {
      if (paramakxr.mResult != 0) {
        break label139;
      }
      ((xui)localObject).b(this.val$id, this.bWI, this.val$type, 1, this.aWm, paramakxr.bjc);
      this.this$0.c(this.val$id, this.bWI, this.val$type, this.aWm);
    }
    for (;;)
    {
      localObject = this.this$0.a;
      if (localObject != null)
      {
        if (paramakxr.mResult != 0) {
          break;
        }
        ((AIOImageProviderService.a)localObject).a(this.val$id, this.bWI, this.val$type, 1, this.aWm, paramakxr.bjc);
        this.this$0.c(this.val$id, this.bWI, this.val$type, this.aWm);
      }
      return;
      label139:
      ((xui)localObject).b(this.val$id, this.bWI, this.val$type, 2, "step:" + paramakxr.c.bUI + ", desc:" + paramakxr.c.bUJ, paramakxr.bjc);
      this.this$0.c(this.val$id, this.bWI, this.val$type, "I:E");
    }
    ((AIOImageProviderService.a)localObject).a(this.val$id, this.bWI, this.val$type, 2, "step:" + paramakxr.c.bUI + ", desc:" + paramakxr.c.bUJ, paramakxr.bjc);
    this.this$0.c(this.val$id, this.bWI, this.val$type, "I:E");
  }
  
  public void aO(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.this$0.c;
    if (localObject != null) {
      ((xui)localObject).b(this.val$id, this.bWI, this.val$type, paramInt, this.val$fileSize, paramBoolean);
    }
    localObject = this.this$0.a;
    if (localObject != null) {
      ((AIOImageProviderService.a)localObject).a(this.val$id, this.bWI, this.val$type, paramInt, this.val$fileSize, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtx
 * JD-Core Version:    0.7.0.1
 */