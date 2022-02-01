import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.cloudfile.CloudFileListFragment;
import java.util.Arrays;
import java.util.List;

public class atfs
  extends atgd
{
  public atfs(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<atiu> paramList, boolean paramBoolean2, String paramString, int paramInt2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramBoolean2, paramString, paramInt2);
    if (CloudFileListFragment.d(this.this$0))
    {
      ((ateh)CloudFileListFragment.n(this.this$0).getBusinessHandler(180)).a(paramArrayOfByte, 1, null);
      CloudFileListFragment.c(this.this$0, false);
    }
  }
  
  public void a(boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramBoolean, paramArrayOfByte1, paramArrayOfByte2, paramString1, paramInt, paramString2);
    if ((paramBoolean) && (CloudFileListFragment.a(this.this$0) != null) && (Arrays.equals(CloudFileListFragment.a(this.this$0).Y(), paramArrayOfByte2)))
    {
      if (!CloudFileListFragment.b(this.this$0)) {
        this.this$0.setTitle(paramString1);
      }
      CloudFileListFragment.a(this.this$0, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfs
 * JD-Core Version:    0.7.0.1
 */