package com.tencent.mobileqq.apollo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

final class ApolloRender$27
  implements Runnable
{
  ApolloRender$27(int paramInt, Intent paramIntent, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("sava_ApolloRender", 2, "imageselector selectimagecallback ");
    }
    if (this.val$resultCode == -1)
    {
      Object localObject = (Bitmap)this.val$data.getParcelableExtra("data");
      ByteBuffer localByteBuffer = ByteBuffer.allocate(((Bitmap)localObject).getByteCount());
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      ((Bitmap)localObject).copyPixelsToBuffer(localByteBuffer);
      localObject = localByteBuffer.array();
      QLog.e("sava_ApolloRender", 2, "imageselector selectimageallback textureView  " + this.val$resultCode + " data: ");
      ((ApolloSurfaceView)this.val$view).getRender().getSavaWrapper().a(ApolloRender.access$900(), 1, i, j, (byte[])localObject);
      return;
    }
    if (this.val$resultCode == 0)
    {
      ((ApolloSurfaceView)this.val$view).getRender().getSavaWrapper().a(ApolloRender.access$900(), 3, 0, 0, null);
      return;
    }
    ((ApolloSurfaceView)this.val$view).getRender().getSavaWrapper().a(ApolloRender.access$900(), 2, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.27
 * JD-Core Version:    0.7.0.1
 */