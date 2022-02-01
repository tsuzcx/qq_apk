package com.tencent.biz.publicAccountImageCollection;

import com.tencent.qphone.base.util.QLog;
import jzv;
import oub.a;

class PublicAccountImageCollectionPreloadManager$1
  implements Runnable
{
  PublicAccountImageCollectionPreloadManager$1(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, oub.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(PublicAccountImageCollectionPreloadManager.access$400(), 2, "notifyUIToRefresh articleId=" + this.c.articleId);
    }
    if (PublicAccountImageCollectionPreloadManager.a(this.this$0) != null) {
      PublicAccountImageCollectionPreloadManager.a(this.this$0).a(this.c);
    }
    PublicAccountImageCollectionPreloadManager.a(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.1
 * JD-Core Version:    0.7.0.1
 */