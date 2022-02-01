package com.tencent.moai.mailsdk.callback;

import com.tencent.moai.mailsdk.model.Folder;
import java.util.ArrayList;

public abstract interface CheckMailCallback
{
  public abstract void notSync();
  
  public abstract void onFail(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onSync(ArrayList<Folder> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.CheckMailCallback
 * JD-Core Version:    0.7.0.1
 */