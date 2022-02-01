package com.qq.ac.sdk.api;

import com.qq.ac.sdk.a.a.a;
import com.qq.ac.sdk.bean.AcChapterListResponse;
import com.qq.ac.sdk.listener.AcChapterListListener;

public class AcChapterList
  extends BaseAcApi<AcChapterList, AcChapterListListener>
{
  public void getChapterList(String paramString)
  {
    this.mAcComicImpl.a(paramString);
  }
  
  public void getPartChapterList(String paramString1, String paramString2)
  {
    this.mAcComicImpl.a(paramString1, paramString2);
  }
  
  public AcChapterList setListener(AcChapterListListener paramAcChapterListListener)
  {
    this.mAcComicImpl.a(paramAcChapterListListener);
    return this;
  }
  
  public AcChapterListResponse syncGetChapterList(String paramString)
  {
    return this.mAcComicImpl.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.ac.sdk.api.AcChapterList
 * JD-Core Version:    0.7.0.1
 */