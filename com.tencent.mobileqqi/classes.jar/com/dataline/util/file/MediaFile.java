package com.dataline.util.file;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;

public class MediaFile
{
  public static String a(String paramString)
  {
    return MimeTypesTools.a(BaseApplicationImpl.getContext(), FileManagerUtil.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.file.MediaFile
 * JD-Core Version:    0.7.0.1
 */