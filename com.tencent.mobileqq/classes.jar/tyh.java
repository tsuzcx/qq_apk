import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class tyh
  implements URLDrawableHandler
{
  private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
  private tyg b;
  
  public tyh(tyg paramtyg1, URLDrawableHandler paramURLDrawableHandler, tyg paramtyg2)
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
    this.b = paramtyg2;
  }
  
  public tyg a()
  {
    return this.b;
  }
  
  protected void a()
  {
    QLog.d(tyg.b(this.jdField_a_of_type_Tyg), 1, "image download start: " + tyg.c(this.jdField_a_of_type_Tyg) + " supportInnerIp: " + tye.a(this.jdField_a_of_type_Tyg.a));
    if (tye.b(this.jdField_a_of_type_Tyg.a))
    {
      Object localObject1 = InnerDns.getHostFromUrl(tyg.c(this.jdField_a_of_type_Tyg));
      Object localObject2 = InnerDns.getInstance().reqSerAddrList((String)localObject1, 1002);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new StringBuilder();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(((bewy)((Iterator)localObject2).next()).toString()).append(" ");
        }
        QLog.d(tyg.b(this.jdField_a_of_type_Tyg), 1, "InnerIp address " + localObject1);
      }
    }
    else
    {
      return;
    }
    QLog.d(tyg.b(this.jdField_a_of_type_Tyg), 1, "InnerIp address empty");
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentImageURLDrawableHandler instanceof suu)) {
      ((suu)this.jdField_a_of_type_ComTencentImageURLDrawableHandler).a(paramString);
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
 * Qualified Name:     tyh
 * JD-Core Version:    0.7.0.1
 */