import android.widget.Button;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.utils.DataReport;
import com.tencent.sharp.jni.TraeAudioSession.ITraeAudioCallback;

public class bks
  implements TraeAudioSession.ITraeAudioCallback
{
  public bks(VideoControlUI paramVideoControlUI) {}
  
  public void a(int paramInt)
  {
    this.a.p = paramInt;
    this.a.a.a().m = paramInt;
    this.a.b(this.a.a.a().n, true);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return;
    }
    this.a.p = paramInt2;
    this.a.a.a().m = paramInt2;
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt != 0) || (!paramBoolean)) {}
    while (!paramBoolean) {
      return;
    }
    this.a.a.a().i = paramString;
    this.a.p();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0) {}
    do
    {
      do
      {
        return;
      } while (this.a.a == null);
      paramInt = this.a.a.a().jdField_a_of_type_Int;
    } while (((paramInt == 1) || (paramInt == 2)) && ((!this.a.a.c()) || (!this.a.a.a().e()) || (this.a.c == null)));
    this.a.c.setEnabled(paramBoolean);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt != 0) {}
    for (;;)
    {
      return;
      this.a.a.a().jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
      this.a.a.a().i = paramString1;
      this.a.p();
      if (paramArrayOfString != null)
      {
        paramInt = 0;
        while (paramInt < paramArrayOfString.length)
        {
          if (paramArrayOfString[paramInt].equals("DEVICE_WIREDHEADSET")) {
            DataReport.q(this.a.a);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3)
  {
    this.a.a.a().i = paramString1;
    this.a.a.a().jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.a.p();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        if (paramArrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
          DataReport.q(this.a.a);
        }
        i += 1;
      }
    }
  }
  
  public void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean)
  {
    if (this.a.a == null) {}
    int i;
    do
    {
      return;
      i = this.a.a.a().jdField_a_of_type_Int;
    } while (((i == 1) || (i == 2)) && ((!this.a.a.c()) || (!this.a.a.a().e()) || (this.a.c == null)));
    this.a.c.setEnabled(paramBoolean);
  }
  
  public void c(int paramInt, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bks
 * JD-Core Version:    0.7.0.1
 */