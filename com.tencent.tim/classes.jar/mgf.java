import com.tencent.biz.pubaccount.readinjoy.skin.BaseResData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInjoySkinAndRefreshFacade.1;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;

public class mgf
{
  private String Zq;
  mgf.a a;
  private boolean ajv;
  private mfq.a b = new mgg(this);
  public AppInterface mApp;
  private int mSource;
  
  public mgf(AppInterface paramAppInterface, int paramInt)
  {
    this.mApp = paramAppInterface;
    this.mSource = paramInt;
  }
  
  private void a(int paramInt, String paramString, BaseResData paramBaseResData)
  {
    if (this.a != null) {
      this.a.b(paramInt, paramString, paramBaseResData);
    }
  }
  
  public void a(mgf.a parama)
  {
    this.a = parama;
  }
  
  public void aOZ()
  {
    ThreadManager.post(new ReadInjoySkinAndRefreshFacade.1(this), 5, null, true);
  }
  
  public void onDestroy()
  {
    this.a = null;
    this.mApp.removeObserver(this.b);
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, String paramString, BaseResData paramBaseResData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mgf
 * JD-Core Version:    0.7.0.1
 */