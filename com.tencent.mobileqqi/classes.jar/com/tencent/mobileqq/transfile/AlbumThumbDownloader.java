package com.tencent.mobileqq.transfile;

import android.app.Application;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.activity.photo.ThumbDecoder;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class AlbumThumbDownloader
  extends ProtocolDownloader.Adapter
{
  public static int a = 0;
  public static final String c = "AlbumThumb";
  ThumbDecoder a;
  
  static
  {
    jdField_a_of_type_Int = 200;
  }
  
  public AlbumThumbDownloader(Application paramApplication)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoThumbDecoder = new ThumbDecoder();
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return AlbumThumbManager.a(BaseApplicationImpl.getContext()).a(paramDownloadParams.url, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoThumbDecoder, null);
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    return true;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(AppConstants.al);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AlbumThumbDownloader
 * JD-Core Version:    0.7.0.1
 */