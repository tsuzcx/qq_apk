package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Folder;

public abstract interface FolderCallBack
{
  public abstract void operateFolderError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void operateFolderSuccess(Folder paramFolder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.FolderCallBack
 * JD-Core Version:    0.7.0.1
 */