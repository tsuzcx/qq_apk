import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.qphone.base.util.QLog;

class yid
  implements Runnable
{
  yid(yic paramyic, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ArrayOfByte != null)) {
      QLog.d("ApolloRender", 2, "httpLog httpCallBack data.len=" + this.jdField_a_of_type_ArrayOfByte.length);
    }
    ((ApolloSurfaceView)this.jdField_a_of_type_Yic.jdField_a_of_type_AndroidViewView).getRender().getSavaWrapper().a(this.jdField_a_of_type_Yic.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yid
 * JD-Core Version:    0.7.0.1
 */