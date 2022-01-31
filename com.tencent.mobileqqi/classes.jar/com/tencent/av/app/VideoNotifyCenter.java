package com.tencent.av.app;

import java.util.Observable;

public class VideoNotifyCenter
  extends Observable
{
  static final String jdField_a_of_type_JavaLangString = "VideoNotifyCenter";
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  
  public VideoNotifyCenter(VideoAppInterface paramVideoAppInterface)
  {
    this.a = null;
    if (paramVideoAppInterface != null) {
      this.a = paramVideoAppInterface;
    }
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    try
    {
      super.setChanged();
      super.notifyObservers(paramArrayOfObject);
      return;
    }
    finally
    {
      paramArrayOfObject = finally;
      throw paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoNotifyCenter
 * JD-Core Version:    0.7.0.1
 */