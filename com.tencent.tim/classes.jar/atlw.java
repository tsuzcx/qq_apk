import com.tencent.cloudfile.BatchResult;
import com.tencent.cloudfile.CloudBase;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class atlw
  extends atgd
{
  public atlw(CloudPhotoListActivity paramCloudPhotoListActivity) {}
  
  public void a(boolean paramBoolean1, byte[] paramArrayOfByte, int paramInt1, List<BatchResult> paramList, int paramInt2, String paramString, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramArrayOfByte, paramInt1, paramList, paramInt2, paramString, paramBoolean2);
    if (paramBoolean1)
    {
      paramArrayOfByte = paramList.iterator();
      while (paramArrayOfByte.hasNext())
      {
        paramList = (BatchResult)paramArrayOfByte.next();
        paramInt2 = 0;
        for (i = -1; paramInt2 < CloudPhotoListActivity.a(this.a).size(); i = j)
        {
          j = i;
          if (Arrays.equals(((FileManagerEntity)CloudPhotoListActivity.a(this.a).get(paramInt2)).cloudFile.cloudId, paramList.cloudId))
          {
            j = i;
            if (paramInt1 != 0) {
              j = paramInt2;
            }
          }
          paramInt2 += 1;
        }
        if (i != -1) {
          CloudPhotoListActivity.a(this.a).remove(i);
        }
        if (this.a.Pp()) {
          CloudPhotoListActivity.a(this.a).notifyDataSetChanged();
        }
      }
      if ((CloudPhotoListActivity.a(this.a) != null) && (CloudPhotoListActivity.a(this.a).size() == 0)) {
        this.a.finish();
      }
    }
    while (!this.a.Pp())
    {
      int i;
      int j;
      return;
    }
    auds.D(1, paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlw
 * JD-Core Version:    0.7.0.1
 */