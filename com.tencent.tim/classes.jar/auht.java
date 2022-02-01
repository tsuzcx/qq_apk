import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudBase;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class auht
  extends atgd
{
  auht(auhr paramauhr) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if (paramBoolean1) {
      paramList = paramList.iterator();
    }
    label52:
    label109:
    label238:
    label241:
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramString = (BatchResult)paramList.next();
        paramInt1 = 0;
        if (paramInt1 >= auhr.a(this.this$0).size()) {
          break label238;
        }
        paramArrayOfByte = null;
        if ((auhr.a(this.this$0).get(paramInt1) instanceof FileManagerEntity))
        {
          paramArrayOfByte = ((FileManagerEntity)auhr.a(this.this$0).get(paramInt1)).cloudFile;
          if ((paramArrayOfByte == null) || (!Arrays.equals(paramArrayOfByte.cloudId, paramString.cloudId))) {
            break label192;
          }
        }
      }
      for (;;)
      {
        if (paramInt1 == -1) {
          break label241;
        }
        auhr.a(this.this$0).remove(paramInt1);
        break;
        if (!(auhr.a(this.this$0).get(paramInt1) instanceof atin)) {
          break label109;
        }
        paramArrayOfByte = ((atin)auhr.a(this.this$0).get(paramInt1)).a;
        break label109;
        paramInt1 += 1;
        break label52;
        if (this.this$0.a != null) {
          this.this$0.a.f(paramBoolean1, 4, this.this$0.isComplete());
        }
        auhr.a(this.this$0);
        return;
        paramInt1 = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auht
 * JD-Core Version:    0.7.0.1
 */