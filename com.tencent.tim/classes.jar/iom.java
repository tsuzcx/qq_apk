import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.ttpic.openapi.model.VideoMaterial;

public abstract interface iom
{
  public abstract int a(int paramInt, boolean paramBoolean1, ioy paramioy, boolean paramBoolean2);
  
  public abstract void a(PendantItem paramPendantItem, VideoMaterial paramVideoMaterial);
  
  public abstract void a(FilterDesc paramFilterDesc);
  
  public abstract void a(iow paramiow, ioy paramioy);
  
  public abstract boolean a(ior paramior);
  
  public abstract void aoH();
  
  public abstract void aoI();
  
  public abstract void aoJ();
  
  public abstract void bE(int paramInt1, int paramInt2);
  
  public abstract void cp(long paramLong);
  
  public abstract void iC(boolean paramBoolean);
  
  public abstract void initInGL(int paramInt1, int paramInt2);
  
  public abstract boolean isNeedFaceDetect();
  
  public abstract boolean uN();
  
  public abstract boolean uO();
  
  public abstract void updateWidthHeight(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iom
 * JD-Core Version:    0.7.0.1
 */