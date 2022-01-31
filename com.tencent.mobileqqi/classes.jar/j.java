import com.dataline.activities.DLBaseFileViewActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;

public class j
  extends FMObserver
{
  public j(DLBaseFileViewActivity paramDLBaseFileViewActivity) {}
  
  protected void a()
  {
    super.a();
    this.a.f();
  }
  
  protected void a(int paramInt, String paramString)
  {
    FileManagerUtil.a(paramString);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    paramString = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong1, paramString, paramInt, paramLong2);
    if (paramString == null) {}
    while (paramLong2 != paramString.nSessionId) {
      return;
    }
    this.a.f();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      FileManagerUtil.a(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.a()) {
      return;
    }
    this.a.jdField_b_of_type_Boolean = paramBoolean;
    this.a.f();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong2) != null)
    {
      if (!paramBoolean) {
        break label35;
      }
      FileManagerUtil.a(paramLong2);
    }
    for (;;)
    {
      this.a.f();
      return;
      label35:
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
    }
  }
  
  protected void b()
  {
    super.b();
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     j
 * JD-Core Version:    0.7.0.1
 */