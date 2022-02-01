import android.content.Context;
import android.content.res.Resources;
import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.List;

class auhj
  extends atgd
{
  auhj(auhh paramauhh) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if ((paramBoolean1) && (this.this$0.a != null) && (this.this$0.a.Pp()) && (paramBoolean2)) {
      this.this$0.a.showSuccessToast(this.this$0.context.getResources().getString(2131691576));
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte, long paramLong, FileManagerEntity paramFileManagerEntity, int paramInt, String paramString)
  {
    super.a(paramBoolean, paramArrayOfByte, paramLong, paramFileManagerEntity, paramInt, paramString);
    if ((this.this$0.a != null) && (this.this$0.a.Pp()) && (paramFileManagerEntity.cloudFile != null) && (paramFileManagerEntity.cloudFile.onlineFileExt != null) && (paramFileManagerEntity.cloudFile.onlineFileExt.createSrcType == 0))
    {
      if (paramBoolean) {
        this.this$0.a.showSuccessToast(this.this$0.context.getResources().getString(2131691569));
      }
    }
    else {
      return;
    }
    this.this$0.a.qw(this.this$0.context.getResources().getString(2131691568));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhj
 * JD-Core Version:    0.7.0.1
 */