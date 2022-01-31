import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public final class yib
  implements Runnable
{
  public yib(int paramInt, Intent paramIntent, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ApolloRender", 2, "imageselector selectimagecallback ");
    }
    if (this.jdField_a_of_type_Int == -1)
    {
      Object localObject = (Bitmap)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("data");
      ByteBuffer localByteBuffer = ByteBuffer.allocate(((Bitmap)localObject).getByteCount());
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      ((Bitmap)localObject).copyPixelsToBuffer(localByteBuffer);
      localObject = localByteBuffer.array();
      QLog.e("ApolloRender", 2, "imageselector selectimageallback textureView  " + this.jdField_a_of_type_Int + " data: ");
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(ApolloRender.access$000(), 1, i, j, (byte[])localObject);
      return;
    }
    if (this.jdField_a_of_type_Int == 0)
    {
      ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(ApolloRender.access$000(), 3, 0, 0, null);
      return;
    }
    ((ApolloSurfaceView)this.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(ApolloRender.access$000(), 2, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yib
 * JD-Core Version:    0.7.0.1
 */