package com.tencent.qqmail.activity.sdcardfileexplorer;

import android.app.Activity;
import android.content.Context;
import java.io.File;

public class SdcardExplorer
  extends FileExplorer
{
  public SdcardExplorer(String paramString, Activity paramActivity, int paramInt)
  {
    super(paramString, paramActivity, paramInt);
  }
  
  public SdcardExplorer(String paramString, File[] paramArrayOfFile, Activity paramActivity, int paramInt)
  {
    super(paramString, paramArrayOfFile, paramActivity, paramInt);
  }
  
  public String getFolderName()
  {
    return getContext().getString(2131693655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.sdcardfileexplorer.SdcardExplorer
 * JD-Core Version:    0.7.0.1
 */