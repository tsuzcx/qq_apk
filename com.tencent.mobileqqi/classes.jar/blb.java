import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.ui.VideoInviteActivity;

public class blb
  extends VideoObserver
{
  public blb(VideoInviteActivity paramVideoInviteActivity) {}
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    if (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().c())
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.c, 0);
      this.a.jdField_a_of_type_ComTencentAvVideoController.c(this.a.c, paramInt);
      this.a.jdField_e_of_type_Boolean = true;
      this.a.finish();
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((this.a.c != null) && (paramString != null) && (this.a.c.equals(paramString)) && (paramBoolean))
    {
      this.a.jdField_e_of_type_Boolean = paramBoolean;
      this.a.finish();
    }
  }
  
  protected void b()
  {
    super.b();
    this.a.g();
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.a.jdField_e_of_type_Int, this.a.c, this.a.jdField_e_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     blb
 * JD-Core Version:    0.7.0.1
 */