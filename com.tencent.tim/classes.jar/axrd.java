import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QimMusicDownloader;
import dov.com.qq.im.capture.view.MusicProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class axrd
  extends axpn
{
  axrh b;
  public MusicItemInfo b;
  int eGI;
  
  public axrd(int paramInt)
  {
    super(null);
    this.jdField_b_of_type_Axrh = new axre(this);
    this.eGI = paramInt;
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = ((QIMMusicConfigManager)axov.a(2)).c(paramInt);
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((paramInt == 1) || (paramInt == 3)) {
      return;
    }
    ((axro)axov.a().c(8)).aeH(paramInt);
  }
  
  public void E(Activity paramActivity, int paramInt)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {}
    while ((paramInt == 1) || (paramInt == 3)) {
      return;
    }
    ((axro)axov.a().c(8)).Zx();
  }
  
  public int Rq()
  {
    int j = 3;
    for (;;)
    {
      try
      {
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("MusicProviderView.Downloader", 2, "download STATE_DOWNLOADED" + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
            i = j;
          }
          return i;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress > -1)
        {
          if (QLog.isColorLevel()) {
            QLog.i("MusicProviderView.Downloader", 2, "download mMusic.mProgress" + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
          }
        }
        else
        {
          if (!aqhq.fileExists(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath()))
          {
            if (QLog.isColorLevel()) {
              QLog.i("MusicProviderView.Downloader", 2, "download ." + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
            }
            this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress = 1;
            QimMusicDownloader.a(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mUrl, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath(), this.jdField_b_of_type_Axrh);
            eNI();
            i = 2;
            continue;
          }
          i = j;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("MusicProviderView.Downloader", 2, "STATE_DOWNLOADED ." + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress);
          i = j;
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo.Music", 2, "applyMusic" + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo == null) {
      return 0;
    }
    MusicProviderView localMusicProviderView2 = (MusicProviderView)paramActivity.findViewById(2131364267);
    MusicProviderView localMusicProviderView1 = localMusicProviderView2;
    if (localMusicProviderView2 == null)
    {
      ((QIMProviderContainerView)paramActivity.findViewById(2131373718)).aeS(104);
      localMusicProviderView1 = (MusicProviderView)paramActivity.findViewById(2131364267);
      localMusicProviderView1.ePb();
    }
    paramActivity = ((axro)axov.a().c(8)).b();
    if ((MusicProviderView.dwS) && (paramActivity != null) && (paramActivity.mItemId != this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mItemId) && (paramActivity.mType == 5))
    {
      localMusicProviderView1.m(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
      return 0;
    }
    localMusicProviderView1.l(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo);
    return 0;
  }
  
  public float getProgress()
  {
    try
    {
      int i = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress;
      float f = 1.0F * i / 100.0F;
      return f;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getState()
  {
    int i = 3;
    for (;;)
    {
      boolean bool;
      try
      {
        MusicItemInfo localMusicItemInfo = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
        if (localMusicItemInfo == null) {
          return i;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress > -1)
        {
          int j = this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.mProgress;
          if (j == 100) {
            continue;
          }
          i = 1;
          continue;
        }
      }
      finally {}
      try
      {
        bool = aqhq.fileExists(this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath());
        if (bool) {
          continue;
        }
      }
      catch (Exception localException)
      {
        continue;
      }
      i = 2;
    }
  }
  
  public String toString()
  {
    return "Music@" + this.eGI + "@" + this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axrd
 * JD-Core Version:    0.7.0.1
 */