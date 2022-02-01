package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Folder;

public abstract interface FolderListCallBack
{
  public abstract void onRetrieveFoldersError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onRetrieveFoldersSuccess(Folder[] paramArrayOfFolder1, Folder[] paramArrayOfFolder2, Folder[] paramArrayOfFolder3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.FolderListCallBack
 * JD-Core Version:    0.7.0.1
 */