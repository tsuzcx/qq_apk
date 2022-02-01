import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class tyf
  implements URLDrawableHandler
{
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  private tye b;
  
  public tyf(tye paramtye1, URLDrawableHandler paramURLDrawableHandler, tye paramtye2)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
    this.b = paramtye2;
  }
  
  public tye a()
  {
    return this.b;
  }
  
  protected void a()
  {
    QLog.d(tye.b(this.jdField_a_of_type_Tye), 1, "image download start: " + tye.c(this.jdField_a_of_type_Tye) + " supportInnerIp: " + tyc.a(this.jdField_a_of_type_Tye.a));
    if (tyc.b(this.jdField_a_of_type_Tye.a))
    {
      Object localObject1 = InnerDns.getHostFromUrl(tye.c(this.jdField_a_of_type_Tye));
      Object localObject2 = InnerDns.getInstance().reqSerAddrList((String)localObject1, 1002);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new StringBuilder();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(((bdyf)((Iterator)localObject2).next()).toString()).append(" ");
        }
        QLog.d(tye.b(this.jdField_a_of_type_Tye), 1, "InnerIp address " + localObject1);
      }
    }
    else
    {
      return;
    }
    QLog.d(tye.b(this.jdField_a_of_type_Tye), 1, "InnerIp address empty");
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawableHandler instanceof tec)) {
      ((tec)this.jdField_a_of_type_ComTencentImageURLDrawableHandler).a(paramString);
    }
  }
  
  public void doCancel()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.doCancel();
  }
  
  public boolean isCancelled()
  {
    return this.jdField_a_of_type_ComTencentImageURLDrawableHandler.isCancelled();
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.b.a(false, paramInt);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    this.b.b();
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadStarted();
    a();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    this.b.a(true, 0);
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(paramLong);
  }
  
  public void publishProgress(int paramInt)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */