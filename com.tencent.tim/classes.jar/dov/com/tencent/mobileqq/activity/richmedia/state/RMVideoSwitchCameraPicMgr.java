package dov.com.tencent.mobileqq.activity.richmedia.state;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import azam;
import java.io.File;

public class RMVideoSwitchCameraPicMgr
{
  private a jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$a = new a(null);
  b jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$b = null;
  
  private native Bitmap getPreprocessBitmap(int[] paramArrayOfInt);
  
  private String qF()
  {
    String str = "shortvideo_cover_pic";
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$a.bzl) {
      str = "ptv_cover_pic";
    }
    return azam.cdR + File.separator + str + ".jpg";
  }
  
  private String qG()
  {
    return azam.cdR + File.separator + "player_cover_pic" + ".jpg";
  }
  
  public Bitmap ar()
  {
    Object localObject = null;
    String str = qG();
    if (new File(str).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = 4;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public Bitmap b(boolean paramBoolean)
  {
    Object localObject = null;
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr$a.bzl = paramBoolean;
    String str = qF();
    if (new File(str).exists())
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = 2;
    }
    try
    {
      localObject = BitmapFactory.decodeFile(str);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  class a
  {
    boolean bzk = false;
    boolean bzl = true;
    int previewHeight = 0;
    int previewWidth = 0;
    
    private a() {}
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr
 * JD-Core Version:    0.7.0.1
 */