import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicDataline.1;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class zvb
  extends ztv
{
  protected zvb(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "sendPicAndVideoToDataline...");
    }
    paramIntent.setClassName("com.tencent.tim", "com.dataline.activities.LiteActivity");
    paramIntent.addFlags(603979776);
    paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
    paramIntent.putExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    paramActivity.startActivityForResult(paramIntent, 2);
    paramActivity.finish();
    aqfy.anim(paramActivity, false, false);
  }
  
  protected void a(Intent paramIntent, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    int i2 = PhotoUtils.c(this.a.sessionInfo);
    paramArrayList = new HashMap();
    int j = 0;
    int i = 0;
    int i1 = 0;
    int k = 0;
    while (i1 < this.mPhotoCommonData.selectedPhotoList.size())
    {
      localObject1 = (String)this.mPhotoCommonData.selectedPhotoList.get(i1);
      int m;
      if (ImageManager.isNetworkUrl((String)localObject1))
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
        if (((NewPhotoListActivity)this.mActivity).getMediaType((String)localObject1) == 1)
        {
          localObject1 = ((NewPhotoListActivity)this.mActivity).getMediaInfo((String)localObject1);
          n = j;
          m = i;
          if (localObject1 != null)
          {
            localObject2 = new SendVideoActivity.SendVideoInfo();
            ((SendVideoActivity.SendVideoInfo)localObject2).fileSize = ((LocalMediaInfo)localObject1).fileSize;
            ((SendVideoActivity.SendVideoInfo)localObject2).duration = ((LocalMediaInfo)localObject1).mDuration;
            paramArrayList.put(Integer.valueOf(k), localObject2);
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
    Object localObject1 = String.valueOf(j);
    Object localObject2 = String.valueOf(i);
    if (!paramArrayList.isEmpty()) {
      paramIntent.putExtra("PhotoConst.VIDEO_INFOS", paramArrayList);
    }
    for (i = 1;; i = 0)
    {
      if ((anfr.akV != 0L) && (System.currentTimeMillis() - anfr.akV < 300000L)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "PhotoListLogicDataline isConfirmed=" + paramBoolean + " allowUploadInXGTime=" + anfr.akV);
        }
        if ((!aqiw.isMobileNetWork(BaseApplicationImpl.getContext())) || (paramBoolean) || (i == 0)) {
          break;
        }
        paramArrayList = ((NewPhotoListActivity)this.mActivity).getResources().getString(2131719478);
        paramIntent = new PhotoListLogicDataline.1(this, paramIntent, i2, (String)localObject1, (String)localObject2);
        if (armm.a(this.mActivity, 4, new zvc(this, paramIntent))) {
          aqha.a(this.mActivity, 232, null, paramArrayList, new zvd(this, paramIntent), new zve(this)).show();
        }
        if (QLog.isColorLevel()) {
          QLog.i("PhotoListActivity", 2, "show datalinephoto_mobile_send_confirm dialog");
        }
        return;
      }
      a(this.mActivity, paramIntent, this.mPhotoCommonData.selectedPhotoList);
      anot.a(null, "CliOper", "", "", "0X8009AB0", "0X8009AB0", i2, 0, (String)localObject1, (String)localObject2, "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zvb
 * JD-Core Version:    0.7.0.1
 */