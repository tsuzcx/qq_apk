import android.content.Intent;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;

public class zvw
  extends ztv
{
  protected zvw(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.c(this.a.sessionInfo);
    paramIntent = new HashMap();
    int i1 = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    while (i1 < this.mPhotoCommonData.selectedPhotoList.size())
    {
      paramArrayList = (String)this.mPhotoCommonData.selectedPhotoList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl(paramArrayList))
      {
        m = k;
        k = i;
        i = m;
        i1 += 1;
        m = k;
        k = i;
        i = m;
      }
      else
      {
        int n;
        if (((NewPhotoListActivity)this.mActivity).getMediaType(paramArrayList) == 1)
        {
          paramArrayList = ((NewPhotoListActivity)this.mActivity).getMediaInfo(paramArrayList);
          n = j;
          m = i;
          if (paramArrayList != null)
          {
            SendVideoActivity.SendVideoInfo localSendVideoInfo = new SendVideoActivity.SendVideoInfo();
            localSendVideoInfo.fileSize = paramArrayList.fileSize;
            localSendVideoInfo.duration = paramArrayList.mDuration;
            paramIntent.put(Integer.valueOf(k), localSendVideoInfo);
            m = i + 1;
            n = j;
          }
        }
        for (;;)
        {
          i = k + 1;
          j = n;
          k = m;
          break;
          n = j + 1;
          m = i;
        }
      }
    }
    anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, String.valueOf(j), String.valueOf(i), "", "");
    crS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvw
 * JD-Core Version:    0.7.0.1
 */