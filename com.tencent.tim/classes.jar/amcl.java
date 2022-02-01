import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.richmediabrowser.presenter.IProvider;

public class amcl
  implements IProvider
{
  public xuh a;
  
  public void a(xuh paramxuh)
  {
    this.a = paramxuh;
  }
  
  public void cancelDownloadMedia(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.cancelDownloadMedia(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void downloadMedia(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      this.a.downloadMedia(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void favorite(long paramLong)
  {
    if (this.a != null) {
      this.a.favorite(paramLong);
    }
  }
  
  public void ge(long paramLong)
  {
    if (this.a != null) {
      this.a.ge(paramLong);
    }
  }
  
  public Intent getFavorateParams(long paramLong, int paramInt)
    throws RemoteException
  {
    if (this.a != null) {
      return this.a.getFavorateParams(paramLong, paramInt);
    }
    return null;
  }
  
  public Intent getForwardData(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a != null) {
      return this.a.getForwardData(paramLong, paramInt1, paramInt2);
    }
    return null;
  }
  
  public int getSaveFileProgress(long paramLong, int paramInt)
  {
    if (this.a != null) {
      return this.a.getSaveFileProgress(paramLong, paramInt);
    }
    return 0;
  }
  
  public boolean isPingBinder()
  {
    if (this.a != null) {
      return this.a.asBinder().pingBinder();
    }
    return false;
  }
  
  public void loadMedias(int paramInt)
  {
    if (this.a != null) {
      this.a.loadMedias(paramInt);
    }
  }
  
  public void onFileVideoStatusChange(long paramLong, int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.onFileVideoStatusChange(paramLong, paramInt, paramBundle);
    }
  }
  
  public void payFlow(long paramLong, int paramInt)
  {
    if (this.a != null) {
      this.a.payFlow(paramLong, paramInt);
    }
  }
  
  public void reportData(String paramString, int paramInt)
  {
    if (this.a != null) {
      this.a.reportData(paramString, paramInt);
    }
  }
  
  public void safetyReport(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.a != null) {
      this.a.safetyReport(paramInt, paramBoolean, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void saveToWeiyun(long paramLong)
  {
    if (this.a != null) {
      this.a.saveToWeiyun(paramLong);
    }
  }
  
  public void sendFileToPC(long paramLong)
  {
    if (this.a != null) {
      this.a.sendFileToPC(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amcl
 * JD-Core Version:    0.7.0.1
 */