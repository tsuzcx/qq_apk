package com.tencent.mobileqq.richmediabrowser;

import amcu;
import amdo;
import android.os.Handler;
import android.os.Looper;
import anot;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

public class ImmersionHelper
{
  private amcu jdField_a_of_type_Amcu;
  private ImmersionTimerRunnable jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable;
  public boolean cCe;
  public boolean cCf;
  public boolean cCg;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public ImmersionHelper(amcu paramamcu)
  {
    this.jdField_a_of_type_Amcu = paramamcu;
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = new ImmersionTimerRunnable(null);
  }
  
  private int dS(String paramString)
  {
    int k = 1;
    Object localObject = this.jdField_a_of_type_Amcu.getSelectedItem();
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {}
    label89:
    label106:
    do
    {
      return -1;
      if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
      {
        int j;
        int i;
        if (("0X800A99B".equals(paramString)) || ("0X800A9B5".equals(paramString)))
        {
          j = 1;
          localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
          if (((AIOVideoData)localObject).mBusiType != 0) {
            break label106;
          }
          if (j == 0) {
            break label89;
          }
          i = 2;
        }
        for (;;)
        {
          return i;
          j = 0;
          break;
          i = k;
          if (!"0X8009AA6".equals(paramString))
          {
            do
            {
              do
              {
                i = -1;
                break;
              } while (((AIOVideoData)localObject).mBusiType != 1);
              i = k;
              if (j != 0) {
                break;
              }
            } while (!"0X8009AA6".equals(paramString));
            i = k;
          }
        }
      }
    } while ((!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOFileVideoData)) || ((!"0X800A99B".equals(paramString)) && (!"0X800A9B5".equals(paramString))));
    return 3;
  }
  
  private int sZ()
  {
    Object localObject = this.jdField_a_of_type_Amcu.getSelectedItem();
    if ((localObject == null) || (((RichMediaBrowserInfo)localObject).baseData == null)) {
      return -1;
    }
    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOFilePictureData)) {
      return 2;
    }
    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOPictureData))
    {
      if (!((AIOPictureData)((RichMediaBrowserInfo)localObject).baseData).bjg) {
        return 1;
      }
      return 5;
    }
    if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOVideoData))
    {
      localObject = (AIOVideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (((AIOVideoData)localObject).mBusiType == 0) {
        return 4;
      }
      if (((AIOVideoData)localObject).mBusiType == 1) {
        return 3;
      }
    }
    else if ((((RichMediaBrowserInfo)localObject).baseData instanceof AIOFileVideoData))
    {
      return 5;
    }
    return -1;
  }
  
  public void dMm()
  {
    if (!this.jdField_a_of_type_Amcu.avH())
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "startImmersionTimer, immersion switch is not open");
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "startImmersionTimer");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = new ImmersionTimerRunnable(null);
    }
    this.mHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable, 5000L);
  }
  
  public void dMn()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "removeImmersionTimer");
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable != null) {
      this.mHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserImmersionHelper$ImmersionTimerRunnable = null;
  }
  
  public void dMo()
  {
    this.cCf = this.jdField_a_of_type_Amcu.a.avJ();
    this.cCg = this.jdField_a_of_type_Amcu.avI();
  }
  
  public void dMp()
  {
    this.cCf = false;
    this.cCg = false;
  }
  
  public void dMq()
  {
    int i = dS("0X800A9B5");
    if (this.jdField_a_of_type_Amcu.agC()) {}
    for (String str = "1";; str = "2")
    {
      anot.a(null, "dc00898", "", "", "0X800A9B5", "0X800A9B5", i, 0, str, "", "", "");
      return;
    }
  }
  
  public void dMr()
  {
    if (this.cCe) {}
    for (int i = 2;; i = 1)
    {
      anot.a(null, "dc00898", "", "", "0X800A99B", "0X800A99B", i, 0, "" + dS("0X800A99B"), "", "", "");
      return;
    }
  }
  
  public void dMs()
  {
    anot.a(null, "dc00898", "", "", "0X800A9B4", "0X800A9B4", sZ(), 0, "", "", "", "");
  }
  
  class ImmersionTimerRunnable
    implements Runnable
  {
    private ImmersionTimerRunnable() {}
    
    public void run()
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("ImmersionHelper", 2, "ImmersionTimerRunnable run");
      ImmersionHelper.this.cCe = true;
      if (ImmersionHelper.a(ImmersionHelper.this).a != null) {
        ImmersionHelper.a(ImmersionHelper.this).a.OR(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.ImmersionHelper
 * JD-Core Version:    0.7.0.1
 */