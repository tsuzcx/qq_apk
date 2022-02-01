package com.tencent.mobileqq.filemanager.fileviewer;

import agkf;
import android.content.Intent;
import android.os.Bundle;
import aviz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class FilePicQFavActivity
  extends IphoneTitleBarActivity
{
  long nSessionId;
  ChatMessage t;
  
  private void djm()
  {
    if (this.nSessionId != -1L)
    {
      FileManagerEntity localFileManagerEntity = this.app.a().b(this.nSessionId);
      if ((localFileManagerEntity != null) && (-1L != localFileManagerEntity.uniseq))
      {
        this.t = ((ChatMessage)this.app.b().b(localFileManagerEntity.peerUin, localFileManagerEntity.peerType, localFileManagerEntity.uniseq));
        new aviz(3).a(this.app, this, localFileManagerEntity, this.t, false);
      }
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.nSessionId = getIntent().getLongExtra("file_pic_favorites", -1L);
    djm();
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("FilePicQFavActivity", 4, "FilePicQFavActivity onDestroy");
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity
 * JD-Core Version:    0.7.0.1
 */