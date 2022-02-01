import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.teamwork.PadInfo;
import java.util.List;

public abstract interface auhk
{
  public static abstract interface a
    extends augw
  {
    public abstract void euV();
    
    public abstract void setBundle(Bundle paramBundle);
    
    public abstract void show();
  }
  
  public static abstract interface b
    extends augx
  {
    public abstract void a(auhk.a parama);
    
    public abstract void al(boolean paramBoolean, String paramString);
    
    public abstract void dismiss();
    
    public abstract void ehM();
    
    public abstract String getInputValue();
    
    public abstract void show();
    
    public abstract void showLoading();
  }
  
  public static abstract interface c
    extends auhk.a
  {
    public abstract void a(int paramInt, ResolveInfo paramResolveInfo);
  }
  
  public static abstract interface d
    extends augx
  {
    public abstract void a(Context paramContext, Object... paramVarArgs);
    
    public abstract void a(auhk.e parame);
    
    public abstract void d(Context paramContext, Object paramObject);
    
    public abstract void e(Context paramContext, Object paramObject);
    
    public abstract void euU();
    
    public abstract void h(Context paramContext, List<Object> paramList);
    
    public abstract void i(Context paramContext, List<Object> paramList);
    
    public abstract void qw(String paramString);
    
    public abstract void showSuccessToast(String paramString);
  }
  
  public static abstract interface e
    extends augw
  {
    public abstract void a(byte[] paramArrayOfByte1, FileInfo paramFileInfo, byte[] paramArrayOfByte2, int paramInt);
    
    public abstract void a(byte[] paramArrayOfByte1, List<FileInfo> paramList, byte[] paramArrayOfByte2);
    
    public abstract void al(Object... paramVarArgs);
    
    public abstract void bG(Object paramObject);
    
    public abstract void bH(Object paramObject);
    
    public abstract void k(Object paramObject, String paramString);
    
    public abstract void nS(List<Object> paramList);
    
    public abstract void nT(List<Object> paramList);
    
    public abstract void o(int paramInt, Object... paramVarArgs);
  }
  
  public static abstract interface f
    extends augw
  {}
  
  public static abstract interface g
    extends augx
  {
    public abstract void f(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
    
    public abstract void qw(String paramString);
    
    public abstract void showSuccessToast(String paramString);
  }
  
  public static abstract interface h
  {
    public abstract void onConfirm();
  }
  
  public static abstract interface i
    extends auhk.e
  {
    public abstract void c(atkw paramatkw);
    
    public abstract void d(atkw paramatkw);
  }
  
  public static abstract interface j
    extends auhk.e
  {
    public abstract void b(PadInfo paramPadInfo);
  }
  
  public static abstract interface k
    extends auhk.g
  {
    public abstract void g(boolean paramBoolean1, int paramInt, boolean paramBoolean2);
    
    public abstract void wE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auhk
 * JD-Core Version:    0.7.0.1
 */